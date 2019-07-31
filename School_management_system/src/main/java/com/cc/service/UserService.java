package com.cc.service;

import com.cc.entity.User;
import com.cc.util.NoteResult;

public interface UserService {

	//根据id删除用户
	NoteResult DeleteUser(Integer id);

	//角色编辑(显示个人信息在编辑页面)
	NoteResult ModifyUser(Integer user_id);

	//角色编辑(修改个人信息)
	NoteResult UpdateUser(User user);

	//添加角色
	NoteResult AddUser(User user);

	//个人信息
	NoteResult MyselfInfo();

	//修改角色状态
	void updateStart(Integer id);

	//修改角色转态
	void updateStop(Integer id);

	//修改密码
	NoteResult ModifyPwd(String pwd);

	NoteResult selectUserpwd(String pwd);
}