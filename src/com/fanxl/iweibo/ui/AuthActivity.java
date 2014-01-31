package com.fanxl.iweibo.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.fanxl.iweibo.R;

public class AuthActivity extends Activity {

	private Dialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.auth);
		
		View digView = View.inflate(this, R.layout.authorize_dialog, null);
		dialog = new Dialog(this, R.style.auth_dialog);
		dialog.setContentView(digView);
		dialog.setCancelable(false);
	    dialog.show();
	    Button bt_dialog_login = (Button) digView.findViewById(R.id.bt_dialog_login);
	    bt_dialog_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(AuthActivity.this, WBAuthCodeActivity.class));
			}
		});
	}
}
