package com.culturer.shop.pages.commit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.culturer.shop.R;
import com.culturer.shop.bean.CarBean;
import com.culturer.shop.bean.ProductsBean;
import com.culturer.shop.util.Cache;
import com.culturer.shop.util.Code;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2018/5/31 0031.
 */

public class CommitAdapter extends BaseAdapter{
	
	private Context context;
	
	public CommitAdapter(Context context) {
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return Cache.buys.size();
	}
	
	@Override
	public ProductsBean getItem(int position) {
		return Cache.buys.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return Cache.buys.get(position).getId();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View contentView = LayoutInflater.from(context).inflate(R.layout.order_item,null);
		TextView name = contentView.findViewById(R.id.name);
		TextView count = contentView.findViewById(R.id.count);
		TextView price = contentView.findViewById(R.id.price);

		try {
			name.setText(Code.decode(getItem(position).getName()));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		count.setText("数量: "+getItem(position).getBuyNum());
		price.setText("￥ "+getItem(position).getPrice());
		return contentView;
	}
}
