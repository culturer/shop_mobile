package com.culturer.shop.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class TeJia {
	
	/**
	 * products : [{"Id":16,"SortId":11,"UserId":1,"ProductTypeId":10,"PartnerId":0,"Name":"%E8%8A%92%E6%9E%9C","Count":1111,"Price":111,"StandardPrice":11,"Desc":"%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%0A%20%20%20%20%20%20%20%20","Msg":"%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C%E8%8A%92%E6%9E%9C","CreateTime":"2018-05-25 22:27:07","CoverUrl":"","BuyNum":0,"SumPrice":0,"IsCarousel":1,"IsHot":1,"IsTeShe":true,"IsTeJia":true,"IsQiangGou":true,"IsGuiGe":false,"GuiGe":""},{"Id":15,"SortId":222,"UserId":1,"ProductTypeId":10,"PartnerId":0,"Name":"西瓜","Count":111,"Price":2,"StandardPrice":1,"Desc":"鲜嫩多姿","Msg":"美味","CreateTime":"2018-05-25 22:26:27","CoverUrl":"","BuyNum":0,"SumPrice":0,"IsCarousel":1,"IsHot":1,"IsTeShe":true,"IsTeJia":true,"IsQiangGou":true,"IsGuiGe":false,"GuiGe":""}]
	 * status : 200
	 * time : 2018-06-05 19:35:21
	 */
	
	private int status;
	private String time;
	private List<ProductsBean> products;
	
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
	
	public List<ProductsBean> getProducts() {
		return products;
	}
	
	public void setProducts(List<ProductsBean> products) {
		this.products = products;
	}
	
}
