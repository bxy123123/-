package com.cc.dao;

import com.cc.entity.Professional;

public interface ProfessionManagerDao {

	//���רҵ��Ϣ
	void AddProfession(Professional p);

	//ɾ��רҵ��Ϣ
	void DeleteProfession(Integer id);

	//����Id��ѯרҵ��Ϣ
	Professional ShowProfession(Integer id);

	//�޸�רҵ��Ϣ
	void UpdateProfession(Professional p);

}
