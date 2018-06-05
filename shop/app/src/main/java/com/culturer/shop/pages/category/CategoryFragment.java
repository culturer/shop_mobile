package com.culturer.shop.pages.category;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.culturer.shop.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
	
	private View contentView;
	
	//标签
	List<String> pagerList = new ArrayList<>();
	//内容
	List<Fragment> fragmentList= new ArrayList<>();
	
	public CategoryFragment() {
		// Required empty public constructor
	}
	
	public static CategoryFragment newInstance(String param1, String param2) {
		CategoryFragment fragment = new CategoryFragment();
		return fragment;
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,
	                         ViewGroup container,
	                         Bundle savedInstanceState){
		if (contentView == null){
			contentView = inflater.inflate(R.layout.fragment_category, container, false);
			initData();
			initPager();
		}
		ViewGroup parent = (ViewGroup) contentView.getParent();
		if ( parent!=null ){
			parent.removeView(contentView);
		}
		return contentView;
	}
	
	private void initData(){
		pagerList.add("海鲜");
		pagerList.add("水果");
		pagerList.add("酸奶");
		pagerList.add("蔬菜");
		fragmentList.add(PageFragment.newInstance("",""));
		fragmentList.add(PageFragment.newInstance("",""));
		fragmentList.add(PageFragment.newInstance("",""));
		fragmentList.add(PageFragment.newInstance("",""));
	}
	
	private void initPager(){
		TabLayout home_tab = contentView.findViewById(R.id.home_tab);
		ViewPager home_pager = contentView.findViewById(R.id.home_pager);
		//MODE_SCROLLABLE可滑动的展示
		//MODE_FIXED固定展示
		home_tab.setTabMode(TabLayout.MODE_FIXED);
		home_tab.setSelectedTabIndicatorColor(getContext().getColor(R.color.black));
		for (int i=0 ;i<pagerList.size() ;i++ ){
			home_tab.addTab(home_tab.newTab().setText(pagerList.get(i)));
		}
		PagerAdapter pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager(), fragmentList, pagerList);
		home_pager.setAdapter(pagerAdapter);
		home_tab.setupWithViewPager(home_pager);
	}
}
