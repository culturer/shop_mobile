package com.culturer.shop.pages.mine;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.culturer.shop.R;
import com.culturer.shop.pages.category.PagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MineFragment extends Fragment {
	
	private View contentView;
	
	//标签
	List<String> pagerList = new ArrayList<>();
	//内容
	List<Fragment> fragmentList= new ArrayList<>();
	
	public MineFragment() {
		// Required empty public constructor
	}
	

	public static MineFragment newInstance(String param1, String param2) {
		MineFragment fragment = new MineFragment();
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		
		if (contentView == null){
			contentView  = inflater.inflate(R.layout.fragment_mine, container, false);
		}
		ViewGroup parent = (ViewGroup) contentView.getParent();
		if ( parent!=null ){
			parent.removeView(contentView);
		}
		init();
		return contentView;
	}
	
	private void init(){
		initData();
		initView();
	}
	
	private void initView(){
		initPager();
	}
	
	private void initData(){
		pagerList.add("待付款");
		pagerList.add("待发货");
		pagerList.add("待签收");
		pagerList.add("退货");
		fragmentList.add(OrderFragment.newInstance("",""));
		fragmentList.add(OrderFragment.newInstance("",""));
		fragmentList.add(OrderFragment.newInstance("",""));
		fragmentList.add(OrderFragment.newInstance("",""));
	}
	
	private void initPager(){
		TabLayout home_tab = contentView.findViewById(R.id.home_tab1);
		ViewPager home_pager = contentView.findViewById(R.id.home_pager1);
		//MODE_SCROLLABLE可滑动的展示
		//MODE_FIXED固定展示
		home_tab.setTabMode(TabLayout.MODE_FIXED);
		home_tab.setSelectedTabIndicatorColor(getContext().getColor(R.color.black));
		for (int i=0 ;i<pagerList.size() ;i++ ){
			home_tab.addTab(home_tab.newTab().setText(pagerList.get(i)));
		}
//		PagerAdapter pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager(), fragmentList, pagerList);
//		home_pager.setAdapter(pagerAdapter);
//		home_tab.setupWithViewPager(home_pager);
	}
	
}
