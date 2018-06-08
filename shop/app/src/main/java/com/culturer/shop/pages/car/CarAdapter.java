package com.culturer.shop.pages.car;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.culturer.shop.R;
import com.culturer.shop.bean.CarBean;
import com.culturer.shop.event.CarEvent;
import com.culturer.shop.util.Cache;
import com.culturer.shop.util.Code;

import org.greenrobot.eventbus.EventBus;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.culturer.shop.util.URL.HOST;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class CarAdapter extends BaseAdapter {
	
	private Context context;
	
	public CarAdapter(Context context) {
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return Cache.carBeans.size();
	}
	
	@Override
	public CarBean getItem(int position) {
		return Cache.carBeans.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return Cache.carBeans.get(position).getProductsBean().getId();
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		View contentView = LayoutInflater.from(context).inflate(R.layout.car_item,null);
		CheckBox isSelected = contentView.findViewById(R.id.isSelected);
		ImageView pic = contentView.findViewById(R.id.pic);
		TextView name = contentView.findViewById(R.id.name);
		TextView single_price = contentView.findViewById(R.id.single_price);
		TextView count = contentView.findViewById(R.id.count);
		TextView price = contentView.findViewById(R.id.price);
		
		isSelected.setChecked(Cache.carBeans.get(position).isCheck());
		
		isSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Cache.carBeans.get(position).setCheck(isChecked);
				EventBus.getDefault().post(new CarEvent());
			}
		});
		//加载封面图
		Glide.with(context)
				.load(HOST+getItem(position).getProductsBean().getCoverUrl())
				.into(pic);
		try {
			name.setText(Code.decode(getItem(position).getProductsBean().getName()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		single_price.setText("单价:￥ "+getItem(position).getProductsBean().getPrice());
		count.setText("数量: "+getItem(position).getProductsBean().getBuyNum() );
		price.setText(getItem(position).getProductsBean().getPrice()*getItem(position).getProductsBean().getBuyNum()+"");
		return contentView;
	}
	
	public void update(){
		notifyDataSetChanged();
	}
}
