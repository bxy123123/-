package com.cc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateUtil {

	public static String simpleDateUtil(Date date) {
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
		return  simpleDate.format(date);
	}
}
