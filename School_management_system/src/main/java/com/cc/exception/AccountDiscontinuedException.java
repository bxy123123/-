package com.cc.exception;

import org.apache.shiro.authc.AuthenticationException;
/**
 * �˺�ͣ�ô����쳣
 * @author Administrator
 *
 */
public class AccountDiscontinuedException extends AuthenticationException{

	public AccountDiscontinuedException(String message){
		  super(message);
	}
}
