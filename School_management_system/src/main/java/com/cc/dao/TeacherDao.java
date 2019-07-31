package com.cc.dao;

import java.util.List;

import com.cc.entity.Class_Schedule;
import com.cc.entity.Class_curriculum;
import com.cc.entity.Student_achievement;

public interface TeacherDao {

	//���ҵ�¼�Ľ�ʦ�����İ༶
	List<Class_Schedule> selectClassByTeacher(String user_IDCard);

	//�жϸ�ѧ���ɼ��Ƿ񱣴��
	Student_achievement JudgeStudentAchievement(String student_code);

	//¼��ѧ���ɼ�
	void SaveStudentAchievement(Student_achievement s);

	//�޸�ѧ���ɼ�
	void UpdateStudentAchievement(Student_achievement s);

	//��ʦ�鿴�����༶�Ŀγ�
	List<Class_curriculum> Lookclass_curriculum(String classname);

}
