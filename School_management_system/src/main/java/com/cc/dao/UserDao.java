package com.cc.dao;

import org.apache.ibatis.annotations.Param;

import com.cc.entity.User;

public interface UserDao {

	//根据id删除用户
	void DeleteUser(Integer id);

	//角色编辑(显示个人信息在编辑页面)
	User ModifyUser(Integer user_id);

	//角色编辑(修改个人信息)
	void UpdateUser(User user);

	
	//添加角色
	void AddUser(User user);

	void updateStart(Integer id);

	void updateStop(Integer id);

	//修改密码
	void ModifyPwd(@Param("pwd")String mp, @Param("user_id")int user_id);

}
