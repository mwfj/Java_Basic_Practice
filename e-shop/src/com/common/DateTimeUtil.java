package com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	/**
	 * 设置当前日期及时间
	 * @return 时间格式为  yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
	
	/**
	 * 获取当前日期
	 * @return 日期格式 yyyy-MM-dd
	 */
	public static String getCurrentDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
}
