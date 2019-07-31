package com.cc.service.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import com.cc.dao.UserDao;
import com.cc.entity.User;
import com.cc.service.UserService;
import com.cc.util.ByteSourceUtils;
import com.cc.util.NoteResult;

@Service
public class UserServiceImpl implements UserService {

	
	@Resource
	private UserDao ud;
	
	/**
	 * 根据id删除用户
	 */
	public NoteResult DeleteUser(Integer id) {
		ud.DeleteUser(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

	/**
	 * 角色编辑(显示个人信息在编辑页面)
	 */
	public NoteResult ModifyUser(Integer user_id) {
		User user=ud.ModifyUser(user_id);
		NoteResult result=new NoteResult();
		result.setData(user);
		result.setStatus(0);
		return result;
	}

	/**
	 * 角色编辑(修改个人信息)
	 */
	public NoteResult UpdateUser(User user) {
		ud.UpdateUser(user);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

	
	/**
	 * 添加角色
	 */
	public NoteResult AddUser(User user) {
		//MD5加密
		String pwd="000000";
		String hash="MD5";
		Object salt=ByteSourceUtils.bytes(user.getUser_phone());
		int d=1024;
		Object Md5Pwd=new SimpleHash(hash,pwd,salt,d);
		String mp = Md5Pwd.toString();
		user.setUser_pwd(mp);
		Timestamp t=new Timestamp(System.currentTimeMillis());
		user.setUser_createtime(t);
		ud.AddUser(user);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

	/**
	 * 个人信息
	 */
	public NoteResult MyselfInfo() {
		User user=(User)SecurityUtils.getSubject().getSession().getAttribute("User");
		NoteResult result=new NoteResult();
		result.setData(user);
		result.setStatus(0);
		return result;
	}

	/**
	 * 修改个人状态
	 */
	public void updateStart(Integer id) {
		ud.updateStart(id);
	}
	/**
	 * 修改个人状态
	 */
	public void updateStop(Integer id) {
		ud.updateStop(id);
	}

	/**
	 * 修改密码
	 */
	public NoteResult ModifyPwd(String pwd) {
		User user=(User)SecurityUtils.getSubject().getSession().getAttribute("User");
		int user_id=user.getUser_id();
		//MD5加密
		String hash="MD5";
		Object salt=ByteSourceUtils.bytes(user.getUser_phone());
		int d=1024;
		Object Md5Pwd=new SimpleHash(hash,pwd,salt,d);
		String mp = Md5Pwd.toString();
		ud.ModifyPwd(mp,user_id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	/**
	 * 查询密码比对是否正确
	 */
	public NoteResult selectUserpwd(String pwd) {
		NoteResult result=new NoteResult();
		User u=(User)SecurityUtils.getSubject().getSession().getAttribute("User");
		String hash="MD5";
		Object salt=ByteSourceUtils.bytes(u.getUser_phone());
		int d=1024;
		Object Md5Pwd=new SimpleHash(hash,pwd,salt,d);
		String mp = Md5Pwd.toString();
		if(mp.equals(u.getUser_pwd())){
			result.setStatus(0);	
		}else{
			result.setStatus(1);
			result.setMsg("原密码不正确请重新输入");
		}
		return result;
	}

}
