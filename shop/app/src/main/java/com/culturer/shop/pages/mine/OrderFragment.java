package com.culturer.shop.pages.mine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.culturer.shop.R;

public class OrderFragment extends Fragment {

	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";
	
	private String mParam1;
	private String mParam2;
	
	private View contentView;
	private ExpandableListView listView;
	private OrderAdapter adapter;
	
	public OrderFragment() {
		// Required empty public constructor
	}

	public static OrderFragment newInstance(String param1, String param2) {
		OrderFragment fragment = new OrderFragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		if (contentView == null){
			contentView = inflater.inflate(R.layout.fragment_order, container, false);
			init();
		}
		ViewGroup parent = (ViewGroup) contentView.getParent();
		if ( parent!=null ){
			parent.removeView(contentView);
		}
		return contentView;
		
	}
	
	private void init(){
		initData();
		initView();
	}
	
	private void initData(){
	
	}
	
	private void initView(){
		initBaseView();
		initListView();
	}
	
	private void initBaseView(){
		listView = contentView.findViewById(R.id.listView);
	}
	
	private void initListView(){
		adapter = new OrderAdapter(getContext());
		View headerView = LayoutInflater.from(getContext()).inflate(R.layout.order_header, null);
		listView.addHeaderView(headerView);
		listView.setAdapter(adapter);
	}
}
