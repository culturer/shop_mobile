package com.culturer.shop.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public abstract class BaseActivity  extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	void init(){
		initData();
		initView();
	}
	
	abstract void initData();
	abstract void initView();
	
}
