package com.fanxl.iweibo.ui;

import com.fanxl.iweibo.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class LogoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//除去标题栏的第一种方式，第二种通过styles方式
//		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.logo);
		ImageView iv_main_logo = (ImageView) findViewById(R.id.iv_main_logo);
		
		//透明度动画，完全透明(0.0f)完全不透明(1.0f)
		AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
		animation.setDuration(3000); //动画时间3秒
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				startActivity(new Intent(LogoActivity.this, LoginActivity.class));
			}
		});
		
		iv_main_logo.setAnimation(animation);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
