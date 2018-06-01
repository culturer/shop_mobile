package com.culturer.shop.pages.car;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.culturer.shop.R;

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
		return 10;
	}
	
	@Override
	public Object getItem(int position) {
		return null;
	}
	
	@Override
	public long getItemId(int position) {
		return 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View contentView = LayoutInflater.from(context).inflate(R.layout.car_item,null);
		return contentView;
	}
}
