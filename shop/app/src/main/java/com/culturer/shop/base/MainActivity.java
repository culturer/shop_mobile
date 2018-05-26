package com.culturer.shop.base;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.culturer.shop.R;
import com.culturer.shop.pages.car.CarFragment;
import com.culturer.shop.pages.category.CategoryFragment;
import com.culturer.shop.pages.home.HomeFragment;
import com.culturer.shop.pages.map.MapFragment;
import com.culturer.shop.pages.mine.MineFragment;
import com.culturer.shop.wedgit.myViewPager.BottomNavigationViewHelper;
import com.culturer.shop.wedgit.myViewPager.MyViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

	
	//Android6.0以上动态权限
	//定位需要的权限
	protected String[] needPermissions = {
			Manifest.permission.ACCESS_COARSE_LOCATION,
			Manifest.permission.ACCESS_FINE_LOCATION,
			Manifest.permission.WRITE_EXTERNAL_STORAGE,
			Manifest.permission.READ_EXTERNAL_STORAGE,
			Manifest.permission.READ_PHONE_STATE
	};
	
	private static final int PERMISSON_REQUESTCODE = 0;
	
	private MyViewPager viewPager;
	private MenuItem menuItem;
	private BottomNavigationView navigation;
	
	private MainAdapter adapter;
	
	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener() {

		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			switch (item.getItemId()) {
				case R.id.home:
					viewPager.setCurrentItem(0);
					return true;
				case R.id.category:
					viewPager.setCurrentItem(1);
					return true;
				case R.id.map:
					viewPager.setCurrentItem(2);
					return true;
				case R.id.car:
					viewPager.setCurrentItem(3);
					return true;
				case R.id.mine:
					viewPager.setCurrentItem(4);
					return true;
			}
			return false;
		}
	};
	
	ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		
		}
		
		@Override
		public void onPageSelected(int position) {
			if (menuItem != null) {
				menuItem.setChecked(false);
			} else {
				navigation.getMenu().getItem(0).setChecked(false);
			}
			menuItem = navigation.getMenu().getItem(position);
			menuItem.setChecked(true);
		}
		
		@Override
		public void onPageScrollStateChanged(int state) {
		
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		checkPermissions(needPermissions);
		super.init();
		
	}
	
	@Override
	void initData() {
	
	}
	
	@Override
	void initView() {
		navigation = findViewById(R.id.navigation);
		//默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
		BottomNavigationViewHelper.disableShiftMode(navigation);
		navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
		viewPager = findViewById(R.id.viewpager);
		viewPager.addOnPageChangeListener(pageChangeListener);
		setupViewPager(viewPager);
	}
	
	/**
	 * 检查定位权限
	 *
	 * @param needPermissions
	 */
	private void checkPermissions(String[] needPermissions) {
		List<String> needRequestPermissionList = findDeniedPermission(needPermissions);
		if (needRequestPermissionList != null && needRequestPermissionList.size() > 0) {
			ActivityCompat.requestPermissions(this,
					needRequestPermissionList.toArray(new String[needRequestPermissionList.size()]),
					PERMISSON_REQUESTCODE);
		}
	}
	
	public void setupViewPager(MyViewPager viewPager) {
		adapter = new MainAdapter(getSupportFragmentManager());
		adapter.addFragment(HomeFragment.newInstance("",""));
		adapter.addFragment(CategoryFragment.newInstance("",""));
		adapter.addFragment(MapFragment.newInstance("",""));
		adapter.addFragment(CarFragment.newInstance("",""));
		adapter.addFragment(MineFragment.newInstance("",""));
		viewPager.setOffscreenPageLimit(5);
		viewPager.setAdapter(adapter);
	}
	
	/**
	 * 获取集中需要申请权限的列表
	 *
	 * @param needPermissions
	 * @return
	 */
	private List<String> findDeniedPermission(String[] needPermissions) {
		List<String> needRequestPermissionList = new ArrayList<String>();
		for (String permisson : needPermissions) {
			if (ContextCompat.checkSelfPermission(this, permisson) != PackageManager.PERMISSION_GRANTED
					|| ActivityCompat.shouldShowRequestPermissionRationale(this, permisson)) {
				needRequestPermissionList.add(permisson);
			}
		}
		return needRequestPermissionList;
	}
	
}
