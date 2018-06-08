package com.culturer.shop.pages.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.culturer.shop.R;
import com.culturer.shop.bean.ProductsBean;
import com.culturer.shop.pages.car.CarUtil;
import com.culturer.shop.util.Code;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.culturer.shop.util.URL.HOST;

public class PageAdapter extends BaseAdapter {
	
	private Context context;
	private List<ProductsBean> productsBeans;
	
	public PageAdapter(Context context,List<ProductsBean> productsBeans) {
		this.context = context;
		this.productsBeans = productsBeans;
	}
	
	@Override
	public int getCount() {
		return productsBeans.size();
	}
	
	@Override
	public ProductsBean getItem(int position) {
		return productsBeans.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return productsBeans.get(position).getId();
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View contentView = LayoutInflater.from(context).inflate(R.layout.page_item,null);
		ImageView pic = contentView.findViewById(R.id.pic);
		TextView name = contentView.findViewById(R.id.name);
		TextView desc = contentView.findViewById(R.id.desc);
		TextView price = contentView.findViewById(R.id.price);
		TextView price1 = contentView.findViewById(R.id.price1);
		Button buys = contentView.findViewById(R.id.buys);
		
		//加载封面图
		Glide.with(context)
				.load(HOST+getItem(position).getCoverUrl())
				.into(pic);
		
		buys.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CarUtil.addCar(getItem(position),context);
			}
		});
		
		try {
			name.setText(Code.decode(getItem(position).getName()));
			desc.setText(Code.decode(getItem(position).getDesc()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		price.setText("￥ "+getItem(position).getPrice());
		price1.setText("￥ "+getItem(position).getStandardPrice());
		
		return contentView;
	}
}
