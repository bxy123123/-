package com.cc.service;

import com.cc.entity.School_activities;
import com.cc.util.NoteResult;

public interface SchoolActivitiesService {

	//���У԰�
	NoteResult AddSchoolActivities(School_activities s);

	//ɾ��У԰�
	NoteResult DeleteSchoolActivities(Integer id);

	//����Id��ʾУ԰���Ϣ
	NoteResult ShowSchoolActivities(Integer id);

	//����id�޸�У԰���Ϣ
	NoteResult UpdateSchoolActivities(School_activities s);

	NoteResult schoolActivitiesStart(Integer id, Integer number);

	NoteResult schoolActivitiesStartStop(Integer id);

	NoteResult SelectReason(Integer id, Integer number);

}
