package com.culturer.shop.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public class Category {
	
	/**
	 * productTypes : [{"Id":10,"TypeName":"%E6%B0%B4%E6%9E%9C","CreateTime":"2018-05-25 22:25:02","SortId":1,"Icon":"pictures/typeicon/1527258302846.png"},{"Id":11,"TypeName":"%E6%B5%B7%E9%B2%9C","CreateTime":"2018-05-25 22:25:13","SortId":1,"Icon":"pictures/typeicon/1527258313190.png"},{"Id":12,"TypeName":"%E5%9D%9A%E6%9E%9C","CreateTime":"2018-05-25 22:25:24","SortId":1,"Icon":"pictures/typeicon/1527258324541.png"}]
	 * status : 200
	 * time : 2018-06-06 11:44:53
	 * totalPage : 3
	 */
	
	private int status;
	private String time;
	private int totalPage;
	private List<ProductTypesBean> productTypes;
	
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
	
	public List<ProductTypesBean> getProductTypes() {
		return productTypes;
	}
	
	public void setProductTypes(List<ProductTypesBean> productTypes) {
		this.productTypes = productTypes;
	}

}
