package com.culturer.shop.bean;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class PictureBean {
	/**
	 * Id : 1
	 * ProductId : 9
	 * Url : pictures/9/1527248385405.png
	 * IsCover : true
	 */
	
	private int Id;
	private int ProductId;
	private String Url;
	private boolean IsCover;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public int getProductId() {
		return ProductId;
	}
	
	public void setProductId(int ProductId) {
		this.ProductId = ProductId;
	}
	
	public String getUrl() {
		return Url;
	}
	
	public void setUrl(String Url) {
		this.Url = Url;
	}
	
	public boolean isIsCover() {
		return IsCover;
	}
	
	public void setIsCover(boolean IsCover) {
		this.IsCover = IsCover;
	}
}
