package com.cc.service;

import com.cc.entity.Student_achievement;
import com.cc.util.NoteResult;

public interface TeacherSerivce {

	//���ҵ�¼�Ľ�ʦ�����İ༶
	NoteResult selectClassByTeacher();

	//�жϸ�ѧ���ɼ��Ƿ񱣴��
	NoteResult JudgeStudentAchievement(String student_code);

	//¼��ѧ���ɼ�
	NoteResult SaveStudentAchievement(Student_achievement s);

	//�޸�ѧ���ɼ�
	NoteResult UpdateStudentAchievement(Student_achievement s);

	//��ʦ�鿴�����༶�Ŀγ�
	NoteResult Lookclass_curriculum(String classname);

}
