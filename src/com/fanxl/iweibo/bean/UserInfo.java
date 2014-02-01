package com.fanxl.iweibo.bean;

import android.graphics.drawable.Drawable;

public class UserInfo {
	
	private Long id;
	private String userId;
	private String userName;
	private String access_token;
	private String isDefault;
	private Drawable userIcon;
	
	public static final String TB_NAME="UserInfo";
	public static final String ID="_id";
	public static final String USER_ID="userId";
	public static final String USER_NAME="userName";
	public static final String ACCESS_TOKEN="access_token";
	public static final String IS_DEFAULT="isDefault";
	public static final String USER_ICON="userIcon";
	
	
	public UserInfo() {
		super();
	}
	public UserInfo(String userId, String userName, String access_token,
			String isDefault) {
		this.userId = userId;
		this.userName = userName;
		this.access_token = access_token;
		this.isDefault = isDefault;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public Drawable getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(Drawable userIcon) {
		this.userIcon = userIcon;
	}
	
}
