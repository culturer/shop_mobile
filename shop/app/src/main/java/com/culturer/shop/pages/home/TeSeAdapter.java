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
import java.util.ArrayList;
import java.util.List;

import static com.culturer.shop.util.URL.HOST;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class TeSeAdapter extends BaseAdapter {
	
	private Context context;
	private List<ProductsBean> productsBeans = new ArrayList<>();
	
	public TeSeAdapter(Context context, List<ProductsBean> productsBeans) {
		this.context = context;
		if (productsBeans!=null){
			this.productsBeans = productsBeans;
		}
	}
	
	@Override
	public int getCount() {
		if (productsBeans.size()>4) return 4;
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
		
		View contentView = LayoutInflater.from(context).inflate(R.layout.tese_item,null);
		ImageView pic = contentView.findViewById(R.id.pic);
		ImageView buy = contentView.findViewById(R.id.buy);
		TextView name = contentView.findViewById(R.id.name);
		TextView guige = contentView.findViewById(R.id.guige);
		TextView desc = contentView.findViewById(R.id.desc);
		TextView price = contentView.findViewById(R.id.price);
		//加载封面图
		Glide.with(context)
				.load(HOST+getItem(position).getCoverUrl())
				.into(pic);
		//添加点击事件
		buy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CarUtil.addCar(getItem(position),context);
			}
		});
		//设置基本信息
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
