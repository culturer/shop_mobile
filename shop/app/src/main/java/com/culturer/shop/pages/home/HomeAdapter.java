package com.culturer.shop.pages.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.culturer.shop.R;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class HomeAdapter extends BaseAdapter {
	
	private Context context;
	
	public HomeAdapter(Context context) {
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return 10;
	}
	
	@Override
	public Object getItem(int i) {
		return null;
	}
	
	@Override
	public long getItemId(int i) {
		return 0;
	}
	
	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		View view1  = LayoutInflater.from(context).inflate(R.layout.home_frament_item,null);
		return view1;
	}
}
