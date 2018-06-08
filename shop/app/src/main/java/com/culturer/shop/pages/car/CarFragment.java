package com.culturer.shop.pages.car;

import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import com.culturer.shop.R;
import com.culturer.shop.bean.CarBean;
import com.culturer.shop.event.CarEvent;
import com.culturer.shop.pages.commit.CommitActivity;
import com.culturer.shop.util.Cache;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EventBus.getDefault().register(this);
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
		initCheck();
		initList();
	}
	
	private void initCheck(){
		check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				for (int i=0;i<Cache.carBeans.size();i++){
					Cache.carBeans.get(i).setCheck(isChecked);
				}
				update();
			}
		});
	}

	private void initBaseView(){
		
		list = contentView.findViewById(R.id.list);
		check = contentView.findViewById(R.id.check);
		tv_money = contentView.findViewById(R.id.tv_money);
		tv_translate = contentView.findViewById(R.id.tv_translate);
		submit = contentView.findViewById(R.id.submit);
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				submit();
			}
		});
	}
	
	private void initList(){
		adapter = new CarAdapter(getContext());
		list.setAdapter(adapter);
	}
	
	private void update(){
		
		BigDecimal money=new BigDecimal(0).setScale(1, BigDecimal.ROUND_HALF_UP); //期望得到12.4
		for (int i=0;i<Cache.carBeans.size();i++){
			if (Cache.carBeans.get(i).isCheck()){
				BigDecimal num=new BigDecimal(Cache.carBeans.get(i).getProductsBean().getBuyNum()).setScale(1, BigDecimal.ROUND_HALF_UP); //期望得到12.4
				BigDecimal price=new BigDecimal(Cache.carBeans.get(i).getProductsBean().getPrice()).setScale(1, BigDecimal.ROUND_HALF_UP); //期望得到12.4
				money = money.add(price.multiply(num));
			}
		}
		tv_money.setText("合计:￥"+money);
		adapter.update();
	}
	
	private void submit(){
		Cache.buys = new ArrayList<>();
		List<CarBean> tmpCars = new ArrayList<>();
		for (int i = 0 ;i< Cache.carBeans.size();i++){
			if (Cache.carBeans.get(i).isCheck()){
				Cache.buys.add(Cache.carBeans.get(i).getProductsBean());
			}else {
				tmpCars.add(Cache.carBeans.get(i));
			}
		}
		Cache.carBeans = tmpCars;
		update();
		Intent intent = new Intent(getContext(), CommitActivity.class);
		startActivity(intent);
	}
	
	@Subscribe
	public void updateView(CarEvent event){
		update();
	}
	
}
