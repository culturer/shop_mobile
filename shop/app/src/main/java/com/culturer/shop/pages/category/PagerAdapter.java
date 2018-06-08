package com.culturer.shop.pages.category;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.culturer.shop.bean.ProductTypesBean;
import com.culturer.shop.util.Code;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private List<ProductTypesBean> productTypesBeans;
    //标签
    List<String> pagerList = new ArrayList<>();
    //内容
    List<Fragment> fragmentList= new ArrayList<>();

    public PagerAdapter(FragmentManager fm,List<Fragment> fragmentList,List<ProductTypesBean> productsTypes) {
        super(fm);
        this.fragmentList = fragmentList;
        this.productTypesBeans = productsTypes;
    }

    @Override
    public int getCount() {
        return productTypesBeans.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String name = "" ;
        try {
            name = Code.decode(productTypesBeans.get(position).getTypeName());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return name;
    }
}
