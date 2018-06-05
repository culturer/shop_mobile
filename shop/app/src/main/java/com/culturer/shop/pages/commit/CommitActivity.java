package com.culturer.shop.pages.commit;

import android.app.AlertDialog;
import android.os.Build;
import android.support.constraint.solver.Cache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.culturer.shop.R;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CommitActivity extends AppCompatActivity {
	
	private static final String TAG = "CommitOrderActivity";
	
	private ListView listView;
	private TextView all_price1;
	private TextView submit;
	
	private View headerView;
	private View order_address;
	private TextView username;
	private TextView tel;
	private TextView address;
	private TextView time;
	private TextView change_time;
	private TextView shop;
	private TextView ticket;
	private EditText msg;
	
	private CommitAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_commit);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();
			//设置修改状态栏
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			//设置状态栏的颜色，和你的app主题或者标题栏颜色设置一致就ok了
			window.setStatusBarColor(getColor(R.color.black));
		}
		init();
	}
	
	private void init(){
		initData();
		initBaseView();
		initHeader();
		initList();
	}
	
	private void initData(){
	
	}
	
	private void initBaseView(){
		listView = findViewById(R.id.list);
		all_price1 = findViewById(R.id.all_price1);
		submit = findViewById(R.id.submit);
		
		headerView = LayoutInflater.from(this).inflate(R.layout.activity_commit_order_header,null);
		order_address = headerView.findViewById(R.id.order_address);
		username = headerView.findViewById(R.id.username);
		tel = headerView.findViewById(R.id.tel);
		address = headerView.findViewById(R.id.address);
		time = headerView.findViewById(R.id.time);
		change_time = headerView.findViewById(R.id.change_time);
		shop = headerView.findViewById(R.id.shop);
		ticket = headerView.findViewById(R.id.ticket);
		msg = headerView.findViewById(R.id.msg);
	}
	
	private void initHeader(){
	
//		tel.setText(Cache.user.getUser().getTel());
//		try {
//			Log.i(TAG, "initHeader: username"+Code.decode(Cache.user.getUser().getName()));
//			Log.i(TAG, "initHeader: address"+Code.decode(Cache.user.getPartner().getAddress()));
//			username.setText(Code.decode(Cache.user.getUser().getName()));
//			address.setText(Code.decode(Cache.user.getPartner().getAddress()));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		order_address.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				changeAddress();
//			}
//		});
	}
	
	private void changeAddress(){
		View contentView = LayoutInflater.from(this).inflate(R.layout.dialog_order,null);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final AlertDialog dialog = builder.setTitle("提交订单")
				.setView(contentView)
				.create();
		dialog.show();
		
		final EditText receiver = contentView.findViewById(R.id.receiver);
		final EditText phone = contentView.findViewById(R.id.phone);
		final EditText address1 = contentView.findViewById(R.id.address);
		final EditText msg = contentView.findViewById(R.id.msg);
		Button commit = contentView.findViewById(R.id.commit);
		
		commit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i(TAG, "commit msg : "+phone.getText().toString()+receiver.getText().toString()+address1.getText().toString()+msg.getText().toString());
				username.setText(receiver.getText().toString());
				tel.setText(phone.getText().toString());
				address.setText(address1.getText().toString());
				dialog.dismiss();
			}
		});
	}
	
	private void initList(){
		listView.addHeaderView(headerView);
		adapter = new CommitAdapter(this);
		listView.setAdapter(adapter);
	}
}
