package com.culturer.shop.pages.home;

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
import java.util.ArrayList;
import java.util.List;

import static com.culturer.shop.util.URL.HOST;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class HomeAdapter extends BaseAdapter {
	
	private Context context;
	private List<ProductsBean> productsBeans = new ArrayList<>();
	
	public HomeAdapter(Context context,List<ProductsBean> productsBeans) {
		this.context = context;
		if (productsBeans!=null){
			this.productsBeans = productsBeans;
		}
	}
	
	@Override
	public int getCount() {
		return productsBeans.size();
	}
	
	@Override
	public ProductsBean getItem(int i) {
		return productsBeans.get(i);
	}
	
	@Override
	public long getItemId(int i) {
		return productsBeans.get(i).getId();
	}
	
	@Override
	public View getView(final int i, View view, ViewGroup viewGroup) {
		View contentView  = LayoutInflater.from(context).inflate(R.layout.home_frament_item,null);
		ImageView pic = contentView.findViewById(R.id.pic);
		TextView name = contentView.findViewById(R.id.name);
		TextView desc = contentView.findViewById(R.id.desc);
		TextView price = contentView.findViewById(R.id.price);
		TextView price1 = contentView.findViewById(R.id.price1);
		Button buys = contentView.findViewById(R.id.buys);
		
		//加载封面图
		Glide.with(context)
				.load(HOST+getItem(i).getCoverUrl())
				.into(pic);
		
		buys.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CarUtil.addCar(getItem(i),context);
			}
		});
		
		try {
			name.setText(Code.decode(getItem(i).getName()));
			desc.setText(Code.decode(getItem(i).getDesc()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		price.setText("￥ "+getItem(i).getPrice());
		price1.setText("￥ "+getItem(i).getStandardPrice());
		
		return contentView;
	}
}
