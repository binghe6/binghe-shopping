package com.binghe.shopping.manage.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 将时间格式化成相应字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formateDate(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}
}
