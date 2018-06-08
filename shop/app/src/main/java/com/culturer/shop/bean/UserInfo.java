package com.culturer.shop.bean;

/**
 * Created by Administrator on 2018/6/7 0007.
 */

public class UserInfo {
	/**
	 * Id : 1
	 * Name : 宋志文
	 * Tel : 18588263531
	 * Password : 78901214
	 * Vid :
	 * Prov : 1
	 * CreateTime :
	 */
	
	private int Id;
	private String Name;
	private String Tel;
	private String Password;
	private String Vid;
	private int Prov;
	private String CreateTime;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getTel() {
		return Tel;
	}
	
	public void setTel(String Tel) {
		this.Tel = Tel;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String Password) {
		this.Password = Password;
	}
	
	public String getVid() {
		return Vid;
	}
	
	public void setVid(String Vid) {
		this.Vid = Vid;
	}
	
	public int getProv() {
		return Prov;
	}
	
	public void setProv(int Prov) {
		this.Prov = Prov;
	}
	
	public String getCreateTime() {
		return CreateTime;
	}
	
	public void setCreateTime(String CreateTime) {
		this.CreateTime = CreateTime;
	}
}
