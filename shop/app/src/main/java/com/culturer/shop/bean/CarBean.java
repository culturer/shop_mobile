package com.culturer.shop.bean;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public class CarBean {
	private boolean isCheck;
	private ProductsBean productsBean;
	
	public CarBean(boolean isCheck, ProductsBean productsBean) {
		this.isCheck = isCheck;
		this.productsBean = productsBean;
	}
	
	public boolean isCheck() {
		return isCheck;
	}
	
	public void setCheck(boolean check) {
		isCheck = check;
	}
	
	public ProductsBean getProductsBean() {
		return productsBean;
	}
	
	public void setProductsBean(ProductsBean productsBean) {
		this.productsBean = productsBean;
	}
}
