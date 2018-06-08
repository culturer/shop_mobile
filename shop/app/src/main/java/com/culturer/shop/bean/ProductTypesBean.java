package com.culturer.shop.bean;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public class ProductTypesBean {
	/**
	 * Id : 10
	 * TypeName : %E6%B0%B4%E6%9E%9C
	 * CreateTime : 2018-05-25 22:25:02
	 * SortId : 1
	 * Icon : pictures/typeicon/1527258302846.png
	 */
	
	private int Id;
	private String TypeName;
	private String CreateTime;
	private int SortId;
	private String Icon;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public String getTypeName() {
		return TypeName;
	}
	
	public void setTypeName(String TypeName) {
		this.TypeName = TypeName;
	}
	
	public String getCreateTime() {
		return CreateTime;
	}
	
	public void setCreateTime(String CreateTime) {
		this.CreateTime = CreateTime;
	}
	
	public int getSortId() {
		return SortId;
	}
	
	public void setSortId(int SortId) {
		this.SortId = SortId;
	}
	
	public String getIcon() {
		return Icon;
	}
	
	public void setIcon(String Icon) {
		this.Icon = Icon;
	}
}
