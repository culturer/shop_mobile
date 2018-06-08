package com.culturer.shop.bean;

import java.util.List;

public class Pages {
	
	/**
	 * products : [{"Id":17,"SortId":1,"UserId":1,"ProductTypeId":12,"PartnerId":0,"Name":"%E5%BC%80%E5%BF%83%E6%9E%9C","Count":22,"Price":100,"StandardPrice":90,"Desc":"%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%0A%20%20%20%20%20%20%20%20","Msg":"%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C%E5%BC%80%E5%BF%83%E6%9E%9C","CreateTime":"2018-05-25 22:27:42","CoverUrl":"","BuyNum":0,"SumPrice":0,"IsCarousel":1,"IsHot":1,"IsTeShe":true,"IsTeJia":true,"IsQiangGou":true,"IsGuiGe":false,"GuiGe":""},{"Id":18,"SortId":22,"UserId":1,"ProductTypeId":12,"PartnerId":0,"Name":"%E6%A0%B8%E6%A1%83","Count":11,"Price":22,"StandardPrice":2,"Desc":"%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%0A%20%20%20%20%20%20%20%20","Msg":"%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83%E6%A0%B8%E6%A1%83","CreateTime":"2018-05-25 22:28:24","CoverUrl":"","BuyNum":0,"SumPrice":0,"IsCarousel":1,"IsHot":1,"IsTeShe":true,"IsTeJia":true,"IsQiangGou":true,"IsGuiGe":false,"GuiGe":""}]
	 * status : 200
	 * time : 2018-06-06 15:59:18
	 * totalPage : 2
	 */
	
	private int status;
	private String time;
	private int totalPage;
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
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public List<ProductsBean> getProducts() {
		return products;
	}
	
	public void setProducts(List<ProductsBean> products) {
		this.products = products;
	}
	
}
