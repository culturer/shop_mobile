package com.culturer.shop.pages.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.culturer.shop.R;

/**
 * Created by Administrator on 2018/5/29 0029.
 */

public class TeJiaAdapter extends BaseAdapter {
	
	private Context context;
	
	public TeJiaAdapter(Context context) {
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return 6;
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
		View contentView = LayoutInflater.from(context).inflate(R.layout.tejia_item,null);
		return contentView;
	}
}
