package com.cc.util;

import javax.servlet.http.Cookie;

public class Cookieutil {

	public static Cookie findCookie(Cookie[] cookies ,String name) {
		if(cookies!=null) {//�пղ���
			for (Cookie cookie : cookies) { //����ѭ�� 
				if(name.equals(cookie.getName()))//�ҵ����������name�� ���ظ�Cookie
					return cookie;
			}
		}
		return null;
	}
}
