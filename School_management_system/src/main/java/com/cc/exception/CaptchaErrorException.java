package com.cc.exception;

import org.apache.shiro.authc.AuthenticationException;
/**
 * �Զ�����֤������쳣
 * AuthenticationExceptionΪShiro��֤������쳣,��ͬ�������ͼ̳и��쳣����
*/
public class CaptchaErrorException extends AuthenticationException{
	
	public CaptchaErrorException(String message){
		  super(message);
	}
}
