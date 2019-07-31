package com.cc.util;

import javax.servlet.http.Cookie;

public class Cookieutil {

	public static Cookie findCookie(Cookie[] cookies ,String name) {
		if(cookies!=null) {//判空操作
			for (Cookie cookie : cookies) { //迭代循环 
				if(name.equals(cookie.getName()))//找到名字相等于name的 返回该Cookie
					return cookie;
			}
		}
		return null;
	}
}
