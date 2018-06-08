package com.culturer.shop.pages.car;

import android.content.Context;
import android.widget.Toast;

import com.culturer.shop.bean.CarBean;
import com.culturer.shop.bean.ProductsBean;
import com.culturer.shop.event.CarEvent;
import com.culturer.shop.util.Cache;
import com.culturer.shop.util.Code;

import org.greenrobot.eventbus.EventBus;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2018/6/6 0006.
 */

public class CarUtil {
	public static void addCar(ProductsBean productsBean, Context context){
		for (int i=0;i< Cache.carBeans.size();i++){
			ProductsBean productsBean1 = Cache.carBeans.get(i).getProductsBean();
			if (productsBean.getId() == productsBean1.getId()){
				int count = Cache.carBeans.get(i).getProductsBean().getBuyNum();
				count++;
				Cache.carBeans.get(i).getProductsBean().setBuyNum(count);
				EventBus.getDefault().post(new CarEvent());
				try {
					Toast.makeText(context,"小丫: "+ Code.decode(productsBean.getName())+"已经加入购物车，请在购物车查看",Toast.LENGTH_LONG).show();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return;
			}
		}
		productsBean.setBuyNum(1);
		Cache.carBeans.add(new CarBean(false,productsBean));
		EventBus.getDefault().post(new CarEvent());
		try {
			Toast.makeText(context,"小丫: "+ Code.decode(productsBean.getName())+"已经加入购物车，请在购物车查看",Toast.LENGTH_LONG).show();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
