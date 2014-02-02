package com.fanxl.iweibo.services;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;

import com.fanxl.iweibo.bean.UserInfo;
import com.fanxl.iweibo.db.DBHelper;

public class UserInfoServices {

	private DBHelper dbHelper;

	public UserInfoServices(Context context) {
		dbHelper = new DBHelper(context);
	}

	/**
	 * 添加用户信息到数据库中
	 * 
	 * @param user
	 */
	public void insertUserInfo(UserInfo user) {

		SQLiteDatabase db = dbHelper.getWritableDatabase();

		ContentValues values = new ContentValues(2);
		values.put(UserInfo.ID, user.getId());
		values.put(UserInfo.USER_ID, user.getUserId());
		values.put(UserInfo.USER_NAME, user.getUserName());
		values.put(UserInfo.ACCESS_TOKEN, user.getAccess_token());
		values.put(UserInfo.IS_DEFAULT, user.getIsDefault());

		db.insert(UserInfo.TB_NAME, null, values); // 返回新添记录的行号，与主键id无关
		db.close();
	}

	/**
	 * 根据用户ID获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public UserInfo getUserInfoByUserId(String userId) {

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		UserInfo userInfo = null;

		Cursor cursor = db.query(UserInfo.TB_NAME, new String[] { UserInfo.ID,
				UserInfo.USER_ID, UserInfo.USER_NAME, UserInfo.ACCESS_TOKEN,
				UserInfo.IS_DEFAULT }, UserInfo.USER_ID + "=?",
				new String[] { userId }, null, null, null);

		if (null != cursor) {

			if (cursor.getCount() > 0) {
				userInfo = new UserInfo();
				Long id = cursor.getLong(cursor.getColumnIndex(UserInfo.ID));
				String user_Id = cursor.getString(cursor
						.getColumnIndex(UserInfo.USER_ID));
				String user_Name = cursor.getString(cursor
						.getColumnIndex(UserInfo.USER_NAME));
				String access_Token = cursor.getString(cursor
						.getColumnIndex(UserInfo.ACCESS_TOKEN));
				String is_Default = cursor.getString(cursor
						.getColumnIndex(UserInfo.IS_DEFAULT));

				userInfo.setId(id);
				userInfo.setUserId(user_Id);
				userInfo.setUserName(user_Name);
				userInfo.setAccess_token(access_Token);
				userInfo.setIsDefault(is_Default);
			}
		}

		cursor.close();
		db.close();
		return userInfo;
	}

	/**
	 * 查询数据库中所有保存的用户信息
	 * @return
	 */
	public List<UserInfo> findAllUser() {

		SQLiteDatabase db = dbHelper.getReadableDatabase();

		List<UserInfo> users = null;

		Cursor cursor = db.query(UserInfo.TB_NAME, new String[] { UserInfo.ID,
				UserInfo.USER_ID, UserInfo.USER_NAME, UserInfo.ACCESS_TOKEN,
				UserInfo.IS_DEFAULT, UserInfo.USER_ICON }, null, null, null,
				null, null);
		System.out.println("count>>>>>>"+cursor.getCount());
		if(null != cursor && cursor.getCount()>0){
			users = new ArrayList<UserInfo>(cursor.getCount());
			UserInfo userInfo = null;
			
			while(cursor.moveToNext()){
				
				userInfo = new UserInfo();
				Long id = cursor.getLong(cursor.getColumnIndex(UserInfo.ID));
				String user_Id = cursor.getString(cursor
						.getColumnIndex(UserInfo.USER_ID));
				String user_Name = cursor.getString(cursor
						.getColumnIndex(UserInfo.USER_NAME));
				String access_Token = cursor.getString(cursor
						.getColumnIndex(UserInfo.ACCESS_TOKEN));
				System.out.println("token>>>>>>"+access_Token);
				String is_Default = cursor.getString(cursor
						.getColumnIndex(UserInfo.IS_DEFAULT));
                byte[] byteIcon = cursor.getBlob(cursor.getColumnIndex(UserInfo.USER_ICON));
				
				userInfo.setId(id);
				userInfo.setUserId(user_Id);
				userInfo.setUserName(user_Name);
				userInfo.setAccess_token(access_Token);
				userInfo.setIsDefault(is_Default);
				
				if(null != byteIcon){
					ByteArrayInputStream is = new ByteArrayInputStream(byteIcon);
					Drawable drawIcon = Drawable.createFromStream(is, "image");
					userInfo.setUserIcon(drawIcon);
				}
				users.add(userInfo);
			}
		}
		
		cursor.close();
		db.close();
		return users;
	}
}
