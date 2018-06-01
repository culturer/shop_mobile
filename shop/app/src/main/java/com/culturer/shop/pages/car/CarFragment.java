package com.culturer.shop.pages.car;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.culturer.shop.R;


public class CarFragment extends Fragment {
	
	private View contentView;
	
	//列表
	private ListView list;
	//选项按钮
	private CheckBox check;
	//价格
	private TextView tv_money;
	//运费
	private TextView tv_translate;
	//结算
	private TextView submit;
	
	private CarAdapter adapter;
	
	public CarFragment() {
		// Required empty public constructor
	}

	public static CarFragment newInstance(String param1, String param2) {
		CarFragment fragment = new CarFragment();
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		contentView = inflater.inflate(R.layout.fragment_car, container, false);
		init();
		return contentView;
	}
	
	private void init(){
		initBaseView();
		initList();
	}

	private void initBaseView(){
		
		list = contentView.findViewById(R.id.list);
		check = contentView.findViewById(R.id.check);
		tv_money = contentView.findViewById(R.id.tv_money);
		tv_translate = contentView.findViewById(R.id.tv_translate);
		submit = contentView.findViewById(R.id.submit);
		
	}
	
	private void initList(){
		adapter = new CarAdapter(getContext());
		list.setAdapter(adapter);
	}
	
}
