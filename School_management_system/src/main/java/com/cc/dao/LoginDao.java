package com.cc.dao;

import com.cc.entity.User;

public interface LoginDao {

	int isExist(String number);

	User findUserByPhone(String number);
}
