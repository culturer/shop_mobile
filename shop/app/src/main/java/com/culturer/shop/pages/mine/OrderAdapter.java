package com.culturer.shop.pages.mine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.culturer.shop.R;

/**
 * Created by Administrator on 2018/6/2 0002.
 */
public class OrderAdapter extends BaseExpandableListAdapter {
	
	private Context context;
	
	public OrderAdapter(Context context) {
		this.context = context;
	}
	
	@Override
	public int getGroupCount() {
		return 5;
	}
	
	@Override
	public int getChildrenCount(int groupPosition) {
		return 10;
	}
	
	@Override
	public Object getGroup(int groupPosition) {
		return null;
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return null;
	}
	
	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}
	
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}
	
	@Override
	public boolean hasStableIds() {
		return false;
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		
		return LayoutInflater.from(context).inflate(R.layout.order_group_item,null);
	}
	
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		return LayoutInflater.from(context).inflate(R.layout.order_item,null);
	}
	
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
}
