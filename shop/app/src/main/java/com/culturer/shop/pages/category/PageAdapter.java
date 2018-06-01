package com.culturer.shop.pages.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.culturer.shop.R;

public class PageAdapter extends BaseAdapter {
	
	private Context context;
	
	public PageAdapter(Context context) {
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
		View contentView = LayoutInflater.from(context).inflate(R.layout.page_item,null);
		return contentView;
	}
}
