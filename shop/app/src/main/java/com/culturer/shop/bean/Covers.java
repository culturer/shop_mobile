package com.culturer.shop.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/6/5 0005.
 */

public class Covers {
	
	/**
	 * covers : [{"Id":1,"ProductId":9,"Url":"pictures/9/1527248385405.png","IsCover":true},{"Id":2,"ProductId":10,"Url":"pictures/10/1527248450391.png","IsCover":true},{"Id":3,"ProductId":11,"Url":"pictures/11/1527248514495.png","IsCover":true},{"Id":4,"ProductId":12,"Url":"pictures/12/1527248575799.png","IsCover":true},{"Id":5,"ProductId":13,"Url":"pictures/13/1527248635848.png","IsCover":true},{"Id":7,"ProductId":15,"Url":"pictures/15/1527258387912.png","IsCover":true},{"Id":8,"ProductId":16,"Url":"pictures/16/1527258427475.png","IsCover":true},{"Id":10,"ProductId":17,"Url":"pictures/17/1527258463867.png","IsCover":true},{"Id":11,"ProductId":18,"Url":"pictures/18/1527258504227.png","IsCover":true},{"Id":15,"ProductId":19,"Url":"pictures/19/1527258548869.png","IsCover":true},{"Id":16,"ProductId":20,"Url":"pictures/20/1527258580766.png","IsCover":true},{"Id":17,"ProductId":21,"Url":"pictures/21/1528120929140.png","IsCover":true},{"Id":19,"ProductId":22,"Url":"pictures/22/1528173421240.png","IsCover":true}]
	 * status : 200
	 * time : 2018-06-05 18:43:42
	 */
	
	private int status;
	private String time;
	private List<PictureBean> covers;
	
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
	
	public List<PictureBean> getCovers() {
		return covers;
	}
	
	public void setCovers(List<PictureBean> covers) {
		this.covers = covers;
	}
	
}
