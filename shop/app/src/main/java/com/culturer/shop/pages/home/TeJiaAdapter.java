package com.culturer.shop.pages.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class TeJiaAdapter extends BaseAdapter {
	
	private final String TeSe = "tese";
	private final String TeJia = "tejia";
	
	private Context context;
	private List<ProductsBean> productsBeans;
	private String flag ;
	
	public TeJiaAdapter(Context context, List<ProductsBean> productsBeans,String flag) {
		this.context = context;
		this.productsBeans = productsBeans;
		this.flag = flag;
	}
	
	@Override
	public int getCount() {
		if (flag.equals(TeSe) && productsBeans.size()>4) return 4;
		if (flag.equals(TeJia) && productsBeans.size()>9)return 9;
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
		
		View contentView = LayoutInflater.from(context).inflate(R.layout.tejia_item,null);
		ImageView cover = contentView.findViewById(R.id.cover);
		ImageView buy = contentView.findViewById(R.id.buy);
		TextView name = contentView.findViewById(R.id.name);
		TextView guige = contentView.findViewById(R.id.guige);
		TextView desc = contentView.findViewById(R.id.desc);
		TextView price = contentView.findViewById(R.id.price);
		
		//加载封面图
		Glide.with(context)
				.load(HOST+getItem(position).getCoverUrl())
				.into(cover);
		
		//添加购物车
		buy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CarUtil.addCar(getItem(position),context);
			}
		});
		
		try {
			name.setText(Code.decode(getItem(position).getName()));
			guige.setText(Code.decode(getItem(position).getGuiGe()));
			desc.setText(Code.decode(getItem(position).getDesc()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		price.setText("￥"+getItem(position).getPrice()+"/份");
		
		return contentView;
	}
}
