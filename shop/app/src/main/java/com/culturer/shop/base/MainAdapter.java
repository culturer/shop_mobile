package com.culturer.shop.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/9 0009.
 */

public class MainAdapter extends FragmentStatePagerAdapter {
	
	private final List<Fragment> mFragmentList = new ArrayList<>();
	private FragmentManager manager;
	
	
	public MainAdapter(FragmentManager manager) {
		super(manager);
		this.manager=manager;
	}
	
	@Override
	public Fragment getItem(int position) {
		return mFragmentList.get(position);
	}
	
	@Override
	public int getCount() {
		return mFragmentList.size();
	}
	
	public void addFragment(Fragment fragment) {
		mFragmentList.add(fragment);
	}

}
