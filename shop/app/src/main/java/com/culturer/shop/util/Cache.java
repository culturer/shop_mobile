package com.culturer.shop.util;

import com.culturer.shop.bean.CarBean;
import com.culturer.shop.bean.PictureBean;
import com.culturer.shop.bean.ProductTypesBean;
import com.culturer.shop.bean.ProductsBean;
import com.culturer.shop.bean.UserInfo;

import java.util.ArrayList;
import java.util.List;


public class Cache {
	public static UserInfo userInfo = new UserInfo();
	public static List<String>  covers = new ArrayList<>();
	public static List<PictureBean> covers1 = new ArrayList<>();
	public static List<ProductsBean> tese = new ArrayList<>();
	public static List<ProductsBean> tejia = new ArrayList<>();
	public static List<ProductsBean> qianggou = new ArrayList<>();
	public static List<ProductTypesBean> productsTypes = new ArrayList<>();
	public static List<CarBean> carBeans = new ArrayList<>();
	public static  List<ProductsBean> buys  = new ArrayList<>();
}
