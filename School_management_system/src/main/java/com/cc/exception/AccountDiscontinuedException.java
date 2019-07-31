package com.cc.exception;

import org.apache.shiro.authc.AuthenticationException;
/**
 * ’À∫≈Õ£”√¥ÌŒÛ“Ï≥£
 * @author Administrator
 *
 */
public class AccountDiscontinuedException extends AuthenticationException{

	public AccountDiscontinuedException(String message){
		  super(message);
	}
}
