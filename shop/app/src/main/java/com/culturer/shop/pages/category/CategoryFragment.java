package com.culturer.shop.pages.category;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.culturer.shop.R;
import com.culturer.shop.bean.Category;
import com.culturer.shop.util.Cache;
import com.culturer.shop.util.Code;
import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.culturer.shop.util.URL.HOST;

public class CategoryFragment extends Fragment {
	
	private static final String TAG = "CategoryFragment" ;
	
	private View contentView;
	
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
		}
		ViewGroup parent = (ViewGroup) contentView.getParent();
		if ( parent!=null ){
			parent.removeView(contentView);
		}
		return contentView;
	}
	
	private void initData(){
		
		HttpParams params = new HttpParams();
		params.put("types",0);
		params.put("options",0);
		
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(Map<String, String> headers, byte[] t) {
				Log.i(TAG, "getCategory: "+new String(t));
				Gson gson = new Gson();
				Category category = gson.fromJson(new String(t),Category.class);
				if (category!=null){
					Cache.productsTypes = category.getProductTypes();
					for (int i=0;i<Cache.productsTypes.size();i++){
						fragmentList.add(PageFragment.newInstance(""+Cache.productsTypes.get(i).getId(),""));
					}
					initPager();
				}
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				Log.i(TAG, "getCategory: "+strMsg);
			}
		};
		
		new RxVolley.Builder()
				.url(HOST+"products")
				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
				.cacheTime(0) //default: get 5min, post 0min
				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
				.params(params)
				.shouldCache(false) //default: get true, post false
				.callback(callback)
				.encoding("UTF-8") //defaultr
				.doTask();
	}
	
	private void initPager(){
		TabLayout home_tab = contentView.findViewById(R.id.home_tab);
		ViewPager home_pager = contentView.findViewById(R.id.home_pager);
		//MODE_SCROLLABLE可滑动的展示
		//MODE_FIXED固定展示
		if (Cache.productsTypes.size()<10){
			home_tab.setTabMode(TabLayout.MODE_FIXED);
		}else {
			home_tab.setTabMode(TabLayout.MODE_SCROLLABLE);
		}
		home_tab.setSelectedTabIndicatorColor(getContext().getColor(R.color.black));
		for (int i=0 ;i<Cache.productsTypes.size() ;i++ ){
			try {
				home_tab.addTab(home_tab.newTab().setText(Code.decode(Cache.productsTypes.get(i).getTypeName())));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		PagerAdapter pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager(), fragmentList, Cache.productsTypes);
		home_pager.setAdapter(pagerAdapter);
		home_tab.setupWithViewPager(home_pager);
	}
	
}


//	private void initData(){
//		pagerList.add("海鲜");
//		pagerList.add("水果");
//		pagerList.add("酸奶");
//		pagerList.add("蔬菜");
//		fragmentList.add(PageFragment.newInstance("",""));
//		fragmentList.add(PageFragment.newInstance("",""));
//		fragmentList.add(PageFragment.newInstance("",""));
//		fragmentList.add(PageFragment.newInstance("",""));
//
//
//		HttpParams params = new HttpParams();
//		params.put("types",0);
//		params.put("options",0);
//
//		HttpCallback callback = new HttpCallback() {
//			@Override
//			public void onSuccess(Map<String, String> headers, byte[] t) {
//				Log.i(TAG, "getCategory: "+new String(t));
//				Gson gson = new Gson();
//				Category category = gson.fromJson(new String(t),Category.class);
//				if (category!=null){
//					Cache.productsTypes = category.getProductTypes();
//
//
//				}
//			}
//
//			@Override
//			public void onFailure(int errorNo, String strMsg) {
//				Log.i(TAG, "getCategory: "+strMsg);
//			}
//		};
//
//		new RxVolley.Builder()
//				.url(HOST+"products")
//				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
//				.cacheTime(0) //default: get 5min, post 0min
//				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
//				.params(params)
//				.shouldCache(false) //default: get true, post false
//				.callback(callback)
//				.encoding("UTF-8") //defaultr
//				.doTask();
//	}
//
//	private void initPager(){
//		TabLayout home_tab = contentView.findViewById(R.id.home_tab);
//		ViewPager home_pager = contentView.findViewById(R.id.home_pager);
//		//MODE_SCROLLABLE可滑动的展示
//		//MODE_FIXED固定展示
//		home_tab.setTabMode(TabLayout.MODE_FIXED);
//		home_tab.setSelectedTabIndicatorColor(getContext().getColor(R.color.black));
//		for (int i=0 ;i<pagerList.size() ;i++ ){
//			home_tab.addTab(home_tab.newTab().setText(pagerList.get(i)));
//		}
//		PagerAdapter pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager(), fragmentList, pagerList);
//		home_pager.setAdapter(pagerAdapter);
//		home_tab.setupWithViewPager(home_pager);
//	}