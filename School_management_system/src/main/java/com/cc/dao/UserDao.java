package com.cc.dao;

import org.apache.ibatis.annotations.Param;

import com.cc.entity.User;

public interface UserDao {

	//����idɾ���û�
	void DeleteUser(Integer id);

	//��ɫ�༭(��ʾ������Ϣ�ڱ༭ҳ��)
	User ModifyUser(Integer user_id);

	//��ɫ�༭(�޸ĸ�����Ϣ)
	void UpdateUser(User user);

	
	//��ӽ�ɫ
	void AddUser(User user);

	void updateStart(Integer id);

	void updateStop(Integer id);

	//�޸�����
	void ModifyPwd(@Param("pwd")String mp, @Param("user_id")int user_id);

}
