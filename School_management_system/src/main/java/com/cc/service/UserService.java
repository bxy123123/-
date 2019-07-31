package com.cc.service;

import com.cc.entity.User;
import com.cc.util.NoteResult;

public interface UserService {

	//����idɾ���û�
	NoteResult DeleteUser(Integer id);

	//��ɫ�༭(��ʾ������Ϣ�ڱ༭ҳ��)
	NoteResult ModifyUser(Integer user_id);

	//��ɫ�༭(�޸ĸ�����Ϣ)
	NoteResult UpdateUser(User user);

	//��ӽ�ɫ
	NoteResult AddUser(User user);

	//������Ϣ
	NoteResult MyselfInfo();

	//�޸Ľ�ɫ״̬
	void updateStart(Integer id);

	//�޸Ľ�ɫת̬
	void updateStop(Integer id);

	//�޸�����
	NoteResult ModifyPwd(String pwd);

	NoteResult selectUserpwd(String pwd);
}