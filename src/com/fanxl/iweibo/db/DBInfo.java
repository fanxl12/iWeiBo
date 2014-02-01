package com.fanxl.iweibo.db;

public class DBInfo {
	
	/**
	 * 数据库常量保存类
	 * @author fanxl
	 *
	 */
	public static class DB{
		//数据库名称
		public static final String DB_NAME="iweibo.db";
	    //数据库版本
		public static final int VERSION = 1;
		
	}
	
	public static class Table{
		
		//设置表明
		public static final String USER_INFO_TB_NAME="UserInfo";
		//创建表的SQL语句
		public static final String USER_INFO_CREATE = "CREATE TABLE IF NOT EXISTS " + USER_INFO_TB_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,userId TEXT, userName TEXT, access_token TEXT,isDefault TEXT,userIcon BLOB)";
		//删除表的SQL语句
		public static final String USER_INFO_DROP="DROP TABLE " + USER_INFO_TB_NAME;
	}

}
