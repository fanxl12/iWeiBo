package com.fanxl.iweibo.demo;


/**
 * Activity的接口
 * @author fanxl
 *
 */
public interface IWeiBoActivity {

	//初始化数据
	void init();
	
	//刷新UI  ...表示可变长度的参数
	void refresh(Object... objects);
}
