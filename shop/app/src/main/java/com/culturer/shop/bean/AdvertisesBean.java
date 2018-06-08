package com.culturer.shop.bean;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class AdvertisesBean {
	/**
	 * Id : 2
	 * Title : 西瓜特价啦
	 * Content :
	 * Count : 1
	 * ProductId : 1
	 * CreateTime : 2018.06.05 19：21
	 * IsTop : true
	 */
	
	private int Id;
	private String Title;
	private String Content;
	private int Count;
	private int ProductId;
	private String CreateTime;
	private boolean IsTop;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	public String getContent() {
		return Content;
	}
	
	public void setContent(String Content) {
		this.Content = Content;
	}
	
	public int getCount() {
		return Count;
	}
	
	public void setCount(int Count) {
		this.Count = Count;
	}
	
	public int getProductId() {
		return ProductId;
	}
	
	public void setProductId(int ProductId) {
		this.ProductId = ProductId;
	}
	
	public String getCreateTime() {
		return CreateTime;
	}
	
	public void setCreateTime(String CreateTime) {
		this.CreateTime = CreateTime;
	}
	
	public boolean isIsTop() {
		return IsTop;
	}
	
	public void setIsTop(boolean IsTop) {
		this.IsTop = IsTop;
	}
}
