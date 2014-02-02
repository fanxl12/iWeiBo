package com.fanxl.iweibo.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.fanxl.iweibo.bean.UserInfo;

public class UserInfoAdapter extends BaseAdapter{

	private Context context;
	private List<UserInfo> users;
	
	public UserInfoAdapter(Context context, List<UserInfo> users) {
		super();
		this.context = context;
		this.users = users;
	}

	@Override
	public int getCount() {
		return users==null?0:users.size();
	}

	@Override
	public Object getItem(int position) {
		return users==null?0:users.get(position);
	}

	@Override
	public long getItemId(int position) {
		return users.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}

}
