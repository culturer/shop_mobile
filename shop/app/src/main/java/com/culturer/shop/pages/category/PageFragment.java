package com.culturer.shop.pages.category;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.culturer.shop.R;
import com.culturer.shop.bean.Pages;
import com.culturer.shop.bean.ProductsBean;
import com.culturer.shop.util.Code;
import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.culturer.shop.util.URL.HOST;

public class PageFragment extends Fragment {
	
	private static final String TAG = "PageFragment";

	private static final String ARG_PARAM1 = "pageType";
	private static final String ARG_PARAM2 = "pageData";
	
	private String typeId;
	private String pageData;
	
	private View contentView;
	private View headerView;
	private ImageView top_pic;
	private ListView list;
	
	private PageAdapter adapter;
	private List<ProductsBean> productsBeans;
	
	public PageFragment() {
		// Required empty public constructor
	}
	
	public static PageFragment newInstance(String param1, String param2) {
		PageFragment fragment = new PageFragment();
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
			typeId = getArguments().getString(ARG_PARAM1);
			Log.i(TAG, "getTypeId: "+typeId);
			pageData = getArguments().getString(ARG_PARAM2);
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		
		if (contentView == null){
			contentView = inflater.inflate(R.layout.fragment_page, container, false);
			headerView = inflater.inflate(R.layout.page_header, container, false);
			top_pic = headerView.findViewById(R.id.top_pic);
			list = contentView.findViewById(R.id.list);
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
		params.put("types",1);
		params.put("options",0);
		params.put("getType",0);
		params.put("pageNo",0);
		params.put("pageSize",0);
		params.put("productTypeId",typeId);
		
		HttpCallback callback1 = new HttpCallback() {
			@Override
			public void onSuccess(String t) {
				Log.i(TAG, "getPages: typeId["+typeId+"],datas --- "+t);
				Gson gson = new Gson();
				Pages pages = gson.fromJson(t,Pages.class);
				if (pages!=null && pages.getProducts()!=null){
					productsBeans = pages.getProducts();
					initView();
				}
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				Log.i(TAG, "onFailure: "+strMsg);
			}
			
		};
		
		new RxVolley.Builder()
				.url(HOST+"products")
				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
				.cacheTime(0) //default: get 5min, post 0min
				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
				.params(params)
				.shouldCache(false) //default: get true, post false
				.callback(callback1)
				.encoding("UTF-8") //defaultr
				.doTask();
		
	}
	
	private void initView(){
		adapter = new PageAdapter(getContext(),productsBeans);
		list.setAdapter(adapter);
		list.addHeaderView(headerView);
	}

}
