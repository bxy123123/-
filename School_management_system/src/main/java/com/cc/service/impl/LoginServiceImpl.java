package com.cc.service.impl;

import javax.annotation.Resource;

import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Service;

import com.cc.dao.LoginDao;
import com.cc.entity.User;
import com.cc.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private LoginDao ld;
	
	
	public User checkLogin(String number) {
		if(number==null){
			throw new NullPointerException("账号不能为空！");
		}
		int i = ld.isExist(number);
		if(i!=1){
			throw new UnknownAccountException("该用户不存在！");
		}
		//根据账号找到用户信息
			User user = ld.findUserByPhone(number);
			return user;
	}

}
