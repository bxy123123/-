package com.cc.service;

import com.cc.entity.Professional;
import com.cc.util.NoteResult;

public interface ProfessionManagerService {

	//���רҵ��Ϣ
	NoteResult AddProfession(Professional p);

	//ɾ��רҵ��Ϣ
	NoteResult DeleteProfession(Integer id);

	//����Id��ѯרҵ��Ϣ
	NoteResult ShowProfession(Integer id);

	//�޸�רҵ��Ϣ
	NoteResult UpdateProfession(Professional p);

}
