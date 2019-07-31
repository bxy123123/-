package com.cc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateUtil {

	public static String simpleDateUtil(Date date) {
		
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ HH:mm:ss");
		return  simpleDate.format(date);
	}
}
