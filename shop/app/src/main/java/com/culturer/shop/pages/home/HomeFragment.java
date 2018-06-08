package com.culturer.shop.pages.home;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.culturer.shop.R;
import com.culturer.shop.bean.Advertises;
import com.culturer.shop.bean.Covers;
import com.culturer.shop.bean.QiangGou;
import com.culturer.shop.bean.TeJia;
import com.culturer.shop.bean.TeSe;
import com.culturer.shop.util.Cache;
import com.culturer.shop.util.GlideImageLoader;
import com.culturer.shop.wedgit.GrideView.CustomGridView;
import com.culturer.shop.wedgit.ScollTextView.AutoScrollTextView;
import com.google.gson.Gson;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.culturer.shop.util.URL.HOST;


public class HomeFragment extends Fragment {
	
	private static final String TAG = "HomeFragment";
	
	private View contentView;
	private View headerView;
	private ListView listView;
	private Banner banner;
	private CustomGridView hfh_gridview;
	private AutoScrollTextView textview_auto_roll;
	private CustomGridView grid_tese;
	private CustomGridView grid_tejia;
	
	TeSeAdapter adapter_tese ;
	TeJiaAdapter adapter_tejia;
	
	public HomeFragment() {
		// Required empty public constructor
	}
	
	public static HomeFragment newInstance(String param1, String param2) {
		HomeFragment fragment = new HomeFragment();
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		headerView =  inflater.inflate(R.layout.home_frament_header, null, false);
		contentView = inflater.inflate(R.layout.fragment_home, container, false);
		init();
		return contentView;
	}
	
	private void init(){
		initData();
		initView();
	}
	
	private void initData(){

	}

	private void initView(){
		//初始化轮播广告
		initBanner();
		//初始化菜单
		initGridView();
		//初始化轮播广告
		initRollText();
		//初始化特价商品
		initTeSe();
		//初始化特价商品
		initTejia();
		//初始化列表
		initList();
	}
	
	//顶部图片轮播
	private void initBanner(){
		
		HttpParams params = new HttpParams();
		params.put("options","getCovers");
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(Map<String, String> headers, byte[] t) {
				Log.i(TAG, "getCovers: "+headers+",msg --- "+new String(t));
				Gson gson = new Gson();
				Covers covers = gson.fromJson(new String(t),Covers.class);
				if (covers.getCovers()!=null){
					Cache.covers1 = covers.getCovers();
					List<String> myCovers = new ArrayList<>();
					for (int i=0 ;i<covers.getCovers().size();i++){
						Log.i(TAG, "getCovers: "+HOST+covers.getCovers().get(i).getUrl());
						myCovers.add(HOST+covers.getCovers().get(i).getUrl());
					}
					Cache.covers  = myCovers;
					banner = headerView.findViewById(R.id.banner);
					//设置图片加载器
					banner.setImageLoader(new GlideImageLoader());
					banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
					banner.setIndicatorGravity(BannerConfig.RIGHT);
					banner.setImages(Cache.covers);
					banner.setOnBannerListener(new OnBannerListener() {
						@Override
						public void OnBannerClick(int position) {
							Toast.makeText(getContext(),"点击了第"+position+"个广告",Toast.LENGTH_LONG).show();
						}
					});
					//banner设置方法全部调用完毕时最后调用
					banner.start();
				}
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				Log.i(TAG, "getCovers: "+errorNo+",msg --- "+strMsg);
			}
		};
		new RxVolley.Builder()
				.url(HOST+"/advertise")
				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
				.params(params)
				.shouldCache(false) //default: get true, post false
				.callback(callback)
				.encoding("UTF-8") //default
				.doTask();
		
	}
	
	//初始化表格控件
	private void initGridView() {
		hfh_gridview = headerView.findViewById(R.id.hfh_gridview);
		hfh_gridview.setAdapter(new HomeGridViewAdapter(getActivity()));
		hfh_gridview.setSelector(new ColorDrawable(Color.WHITE));
		hfh_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch (position) {
					case 0:
//						Intent intent1 = new Intent(getActivity(), HomeGridviewBargainGoods.class);
//						startActivity(intent1);
						break;
					case 1:
//						Intent intent2 = new Intent(getActivity(), HomeGridviewHotGoods.class);
//						startActivity(intent2);
						break;
					case 2:
//						Intent intent3 = new Intent(getActivity(), HomeGridviewSeasonGoods.class);
//						startActivity(intent3);
						break;
					case 3:
//						Intent intent4 = new Intent(getActivity(), HomeGridviewNotimeGoods.class);
//						startActivity(intent4);
						break;
					case 4:
//						Intent intent5 = new Intent(getActivity(), HomeAllActivity.class);
//						startActivity(intent5);
						break;
					case 5:
						Toast.makeText(getActivity(), "扶贫商品！", Toast.LENGTH_SHORT).show();
						break;
					case 6:
						//机柜距离
//						EventBus.getDefault().post(new DistantEvent(0));
						break;
					case 7:
						Toast.makeText(getActivity(), "此功能年后开发,要整理好逻辑哈", Toast.LENGTH_SHORT).show();
						break;
					case 8:
//						Intent intent = new Intent(getActivity(), ShowOrderInformationActivity.class);
//						intent.putExtra("code", 0);
//						startActivity(intent);
						break;
					case 9:
						Toast.makeText(getActivity(), "此功能年后开发,要整理好逻辑哈", Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}
			}
		});
	}
	
	//滚蛋广告
	private void initRollText(){
		textview_auto_roll = headerView.findViewById(R.id.textview_auto_roll);
		
		HttpParams params = new HttpParams();
		params.put("options","getAdvertiseByPage");
		params.put("index",1);
		params.put("size",10);
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(Map<String, String> headers, byte[] t) {
				Log.i(TAG, "getAdvertise: "+headers+",msg"+new String(t));
				Gson gson = new Gson();
				Advertises advertises = gson.fromJson(new String(t),Advertises.class);
				if (advertises!=null && advertises.getAdvertises()!=null){
					List<String> fresh_list = new ArrayList<>();
					for (int i=0;i<advertises.getAdvertises().size();i++){
						fresh_list.add(advertises.getAdvertises().get(i).getTitle());
					}
					textview_auto_roll.setText(fresh_list.get(0));
					textview_auto_roll.setList(fresh_list);
					textview_auto_roll.startScroll();
					textview_auto_roll.setClickLisener(new AutoScrollTextView.ItemClickLisener() {
						@Override
						public void onClick(int position) {
//				Intent intent = new Intent(getContext(), HomeFragmentFreshNewsActivity.class);
//				startActivity(intent);
						}
					});
				}
				
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				Log.i(TAG, "getAdvertise: "+errorNo+",msg"+strMsg);
			}
		};
		new RxVolley.Builder()
				.url(HOST+"/advertise")
				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
				.params(params)
				.shouldCache(false) //default: get true, post false
				.callback(callback)
				.encoding("UTF-8") //default
				.doTask();
		
	}
	
	//特色商品
	private void initTeSe(){
		
		HttpParams params = new HttpParams();
		params.put("types",1);
		params.put("options",0);
		params.put("getType",2);
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(Map<String, String> headers, byte[] t) {
				Log.i(TAG, "getTeShe: "+headers+",msg"+new String(t));
				Gson gson = new Gson();
				TeSe teSe = gson.fromJson(new String(t),TeSe.class);
				if (teSe!=null){
					Cache.tese = teSe.getProducts();
					grid_tese = headerView.findViewById(R.id.grid_tese);
					adapter_tese = new TeSeAdapter(getContext(),Cache.tese);
					grid_tese.setAdapter(adapter_tese);
				}
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				Log.i(TAG, "getTeShe: "+errorNo+",msg"+strMsg);
			}
		};
		new RxVolley.Builder()
				.url(HOST+"/products")
				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
				.params(params)
				.shouldCache(false) //default: get true, post false
				.callback(callback)
				.encoding("UTF-8") //default
				.doTask();
		
	}
	//特价商品
	private void initTejia(){
		HttpParams params = new HttpParams();
		params.put("types",1);
		params.put("options",0);
		params.put("getType",3);
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(Map<String, String> headers, byte[] t) {
				Log.i(TAG, "getTeJia: "+headers+",msg"+new String(t));
				Gson gson = new Gson();
				TeJia teJia = gson.fromJson(new String(t),TeJia.class);
				if (teJia!=null && teJia.getProducts()!=null){
					Cache.tejia = teJia.getProducts();
					grid_tejia = headerView.findViewById(R.id.grid_tejia);
					adapter_tejia = new TeJiaAdapter(getContext(),Cache.tejia,"tejia");
					grid_tejia.setAdapter(adapter_tejia);
				}
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				Log.i(TAG, "getTeJia: "+errorNo+",msg"+strMsg);
			}
		};
		new RxVolley.Builder()
				.url(HOST+"/products")
				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
				.params(params)
				.shouldCache(false) //default: get true, post false
				.callback(callback)
				.encoding("UTF-8") //default
				.doTask();

	}
	
	//抢购商品列表
	private void initList(){
		HttpParams params = new HttpParams();
		params.put("types",1);
		params.put("options",0);
		params.put("getType",4);
		HttpCallback callback = new HttpCallback() {
			@Override
			public void onSuccess(Map<String, String> headers, byte[] t) {
				Log.i(TAG, "getQiangGou: "+headers+",msg"+new String(t));
				Gson gson = new Gson();
				QiangGou qiangGou = gson.fromJson(new String(t),QiangGou.class);
				if (qiangGou!=null){
					Cache.qianggou = qiangGou.getProducts();
					listView = contentView.findViewById(R.id.list);
					listView.addHeaderView(headerView);
					listView.setAdapter(new HomeAdapter(getContext(),Cache.qianggou));
				}
			}
			
			@Override
			public void onFailure(int errorNo, String strMsg) {
				Log.i(TAG, "getQiangGou: "+errorNo+",msg"+strMsg);
			}
		};
		new RxVolley.Builder()
				.url(HOST+"/products")
				.httpMethod(RxVolley.Method.POST) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
				.contentType(RxVolley.ContentType.FORM)//default FORM or JSON
				.params(params)
				.shouldCache(false) //default: get true, post false
				.callback(callback)
				.encoding("UTF-8") //default
				.doTask();

	}
}
