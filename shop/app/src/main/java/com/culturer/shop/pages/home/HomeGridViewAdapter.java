package com.culturer.shop.pages.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.culturer.shop.R;


/**
 * Created by liton on 2017/12/27.
 */

public class HomeGridViewAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
//    private int[] pictures={R.drawable.tejia,R.drawable.remen,R.drawable.shilin,R.drawable.xianshi,
//            R.drawable.ziti, R.drawable.youhuijuan10,R.drawable.chongzhi,R.drawable.yaoqing};

    private int[] pictures = {R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private Context context;

    public HomeGridViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return pictures.length;
    }

    @Override
    public Object getItem(int position) {
        return pictures[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.home_fragment_gridview_item, null);
        ImageView iv = convertView.findViewById(R.id.hfgi_imageview);
        iv.setImageResource(pictures[position]);
        return iv;
    }
}
