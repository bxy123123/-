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
	 * ����idɾ���û�
	 */
	public NoteResult DeleteUser(Integer id) {
		ud.DeleteUser(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

	/**
	 * ��ɫ�༭(��ʾ������Ϣ�ڱ༭ҳ��)
	 */
	public NoteResult ModifyUser(Integer user_id) {
		User user=ud.ModifyUser(user_id);
		NoteResult result=new NoteResult();
		result.setData(user);
		result.setStatus(0);
		return result;
	}

	/**
	 * ��ɫ�༭(�޸ĸ�����Ϣ)
	 */
	public NoteResult UpdateUser(User user) {
		ud.UpdateUser(user);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}

	
	/**
	 * ��ӽ�ɫ
	 */
	public NoteResult AddUser(User user) {
		//MD5����
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
	 * ������Ϣ
	 */
	public NoteResult MyselfInfo() {
		User user=(User)SecurityUtils.getSubject().getSession().getAttribute("User");
		NoteResult result=new NoteResult();
		result.setData(user);
		result.setStatus(0);
		return result;
	}

	/**
	 * �޸ĸ���״̬
	 */
	public void updateStart(Integer id) {
		ud.updateStart(id);
	}
	/**
	 * �޸ĸ���״̬
	 */
	public void updateStop(Integer id) {
		ud.updateStop(id);
	}

	/**
	 * �޸�����
	 */
	public NoteResult ModifyPwd(String pwd) {
		User user=(User)SecurityUtils.getSubject().getSession().getAttribute("User");
		int user_id=user.getUser_id();
		//MD5����
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
	 * ��ѯ����ȶ��Ƿ���ȷ
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
			result.setMsg("ԭ���벻��ȷ����������");
		}
		return result;
	}

}
