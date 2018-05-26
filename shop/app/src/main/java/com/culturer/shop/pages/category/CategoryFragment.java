package com.culturer.shop.pages.category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.culturer.shop.R;
import com.culturer.shop.pages.category.adapter.WQRecycleAdapter;
import com.culturer.shop.pages.category.adapter.WQViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	private String mParam1;
	private String mParam2;
	
	private View contentView;
	
	RecyclerView leftRecycle;
	RecyclerView rightRecycle;
	
	WQRecycleAdapter leftAdapter;
	WQRecycleAdapter rightAdapter;
	
	
	List<String> leftList = new ArrayList<>();
	
	List<String> rightList = new ArrayList<>();
	
	List<String> detailsList = new ArrayList<>();
	
	
	int currentPosition = 0;
	
	public CategoryFragment() {
		// Required empty public constructor
	}
	
	public static CategoryFragment newInstance(String param1, String param2) {
		CategoryFragment fragment = new CategoryFragment();
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		contentView = inflater.inflate(R.layout.fragment_category, container, false);
		initData();
		initView();
		return contentView;
	}
	
	/**
	 * 初始化数据源
	 */
	private void initData() {
		for (int i = 0; i < 6; i++) {
			leftList.add("鞋子" + i);
			rightList.add("" + i);
		}
		for (int i = 0; i < 9; i++) {
			detailsList.add("");
		}
	}
	
	private void initView(){
		leftRecycle = contentView.findViewById(R.id.main_left_recycle);
		rightRecycle = contentView.findViewById(R.id.main_right_recycle);
		leftRecycle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
		rightRecycle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
		
		leftAdapter = new WQRecycleAdapter(getContext(), R.layout.category_left_item, leftList);
		leftRecycle.setAdapter(leftAdapter);
		
		rightAdapter = new WQRecycleAdapter(getContext(), R.layout.category_right_item, rightList);
		rightRecycle.setAdapter(rightAdapter);
		
		
		leftAdapter.setCallBack(new WQRecycleAdapter.CallBack() {
			@Override
			public <T> void convert(WQViewHolder holder, T bean, int position) {
				LinearLayout layout = (LinearLayout) holder.getView(R.id.item_main_left_layout);
				TextView type = (TextView) holder.getView(R.id.item_main_left_type);
				type.setText((String) bean);
				if (position == currentPosition) {
					layout.setBackgroundColor(0xffffffff);
					type.setTextColor(getResources().getColor(R.color.colorAccent));
				} else {
					layout.setBackgroundColor(0xffeeeeee);
					type.setTextColor(0xff444444);
				}
			}
		});
		
		leftAdapter.setOnItemClickListner(new WQRecycleAdapter.OnItemClickListner() {
			@Override
			public void onItemClickListner(View v, int position) {
				Log.i("leftAdapter", "scrollToPositionWithOffset-->" + position);
				LinearLayoutManager llm = ((LinearLayoutManager) rightRecycle.getLayoutManager());
				
				llm.scrollToPositionWithOffset(position, 0);
				
			}
		});
		
		
		rightAdapter.setCallBack(new WQRecycleAdapter.CallBack() {
			@Override
			public <T> void convert(WQViewHolder holder, T bean, int position) {
				holder.setText(R.id.item_main_right_type, (String) bean);
				RecyclerView detailsRecycle = (RecyclerView) holder.getView(R.id.item_main_right_recycle);
				updateDetailsRecycle(detailsRecycle);
			}
		});
		
		
		rightRecycle.setOnScrollChangeListener(new View.OnScrollChangeListener() {
			@Override
			public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
				LinearLayoutManager rightManager = (LinearLayoutManager) rightRecycle.getLayoutManager();
				
				LinearLayoutManager leftManager = ((LinearLayoutManager) leftRecycle.getLayoutManager());
				
				/**
				 * 获取第一个item为第几个position
				 */
				currentPosition = rightManager.findFirstVisibleItemPosition();
				
				
				/**
				 * 这地方需要进行判断，如果右边的Recycle在移动的时候，左边的RecycleView也是需要进行移动的
				 * 左边的recycleview有可能会不可见，这时候，我们必须去判断一下，左边最后的一个item是不是
				 * 小于右边滑动的位置，或左边第一个item是不是大于右边滑动的位置
				 */
				if (leftManager.findFirstVisibleItemPosition() > currentPosition) {
					leftManager.scrollToPositionWithOffset(currentPosition, 0);
				} else if (leftManager.findLastVisibleItemPosition() < currentPosition) {
					leftManager.scrollToPositionWithOffset(currentPosition, 0);
				}
				
				/**
				 * 判断右边是否滑动到最后一个item，是的话，也将左边移动到最后一个item
				 * canScrollVertically(1)表示是否能向上滚动，false表示已经滚动到底部
				 */
				if (!rightRecycle.canScrollVertically(1)) {
					currentPosition = rightList.size() - 1;
					
					Log.i("tag", currentPosition + "-------");
				}
				
				leftAdapter.notifyDataSetChanged();
			}
		});
	}
	/**
	 * 更新详情列表
	 *
	 * @param detailsRecycle
	 */
	public void updateDetailsRecycle(RecyclerView detailsRecycle) {
		WQRecycleAdapter detailsAdapter = new WQRecycleAdapter(getContext(), R.layout.category_details_item, detailsList);
		detailsRecycle.setLayoutManager(new GridLayoutManager(getContext(), 3));
		detailsRecycle.setAdapter(detailsAdapter);
	}

}
