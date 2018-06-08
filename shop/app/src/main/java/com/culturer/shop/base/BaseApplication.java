package com.culturer.shop.base;

import android.app.Application;

import com.culturer.shop.util.PreferenceUtil;
import com.vondear.rxtools.RxTool;

public class BaseApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		RxTool.init(this);
		PreferenceUtil.init(this);
	}
}
