package com.fanxl.iweibo.ui;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.fanxl.iweibo.R;
import com.fanxl.iweibo.bean.Task;
import com.fanxl.iweibo.bean.UserInfo;
import com.fanxl.iweibo.demo.IWeiBoActivity;
import com.fanxl.iweibo.logic.MainService;
import com.fanxl.iweibo.services.UserInfoServices;

public class LoginActivity extends Activity implements IWeiBoActivity{
	
	private Button bt_login_login;
	private UserInfoServices services;
	private List<UserInfo> users;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//去掉标题栏
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.login);
		
		
		//启动服务
		Intent service = new Intent(this, MainService.class);
	    startService(service);
	    
	    bt_login_login = (Button) findViewById(R.id.bt_login_login);
	    bt_login_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Task task = new Task(Task.WEIBO_LOGIN, null);
				MainService.newTask(task);
			}
		});
	    
	    //把自己放到Activity集合里面去
	    MainService.addActivity(this);
	}

	@Override
	public void init() {
		services = new UserInfoServices(this);
		users = services.findAllUser();
		if(null == users && users.isEmpty()){
			startActivity(new Intent(LoginActivity.this, AuthActivity.class));
			finish();
		}else{
			//选择已经认证成功的用户
		}
	}

	@Override
	public void refresh(Object... objects) {
		
//		TextView tv_login_text = (TextView) findViewById(R.id.tv_login_text);
//	    tv_login_text.setText(objects[0].toString());
	}

}
