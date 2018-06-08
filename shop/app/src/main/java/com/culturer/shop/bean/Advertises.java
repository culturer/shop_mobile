package com.culturer.shop.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class Advertises {
	
	/**
	 * advertises : [{"Id":2,"Title":"西瓜特价啦","Content":"","Count":1,"ProductId":1,"CreateTime":"2018.06.05 19：21","IsTop":true},{"Id":1,"Title":"黄瓜特价啦","Content":"又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，又大又甜的黄瓜，又大又甜的黄瓜啦啦啦，","Count":1,"ProductId":1,"CreateTime":"2018.06.05 19：21","IsTop":true}]
	 * count : 2
	 * status : 200
	 * time : 2018-06-05 19:24:16
	 */
	
	private int count;
	private int status;
	private String time;
	private List<AdvertisesBean> advertises;
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public List<AdvertisesBean> getAdvertises() {
		return advertises;
	}
	
	public void setAdvertises(List<AdvertisesBean> advertises) {
		this.advertises = advertises;
	}
	
}
