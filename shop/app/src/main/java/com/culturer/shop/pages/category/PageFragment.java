package com.culturer.shop.pages.category;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.culturer.shop.R;

public class PageFragment extends Fragment {

	private static final String ARG_PARAM1 = "pageType";
	private static final String ARG_PARAM2 = "pageData";
	
	private String pageType;
	private String pageData;
	
	private View contentView;
	private View headerView;
	private ImageView top_pic;
	private ListView list;
	
	private PageAdapter adapter;
	
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
			pageType = getArguments().getString(ARG_PARAM1);
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
			adapter = new PageAdapter(getContext());
			list.setAdapter(adapter);
			list.addHeaderView(headerView);
		}
		
		ViewGroup parent = (ViewGroup) contentView.getParent();
		
		if ( parent!=null ){
			parent.removeView(contentView);
		}
		
		
		return contentView;
	}

}
