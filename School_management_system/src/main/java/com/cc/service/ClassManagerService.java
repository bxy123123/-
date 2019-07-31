package com.cc.service;

import com.cc.entity.Class_Schedule;
import com.cc.entity.Class_curriculum;
import com.cc.util.NoteResult;

public interface ClassManagerService {

	//ɾ���༶��Ϣ
	NoteResult DeleteClassInformation(Integer id);
	//�����༶��Ϣ
	NoteResult AddClassInformation(String classInformation_name, String classInformation_Instructor,
			String classInformation_Instructor_IDCard, int classInformation_number);
	
	//����id��ʾ�༶��Ϣ
	NoteResult ShowClassInformation(Integer id);
	
	//�޸İ༶��Ϣ
	NoteResult UpdateClassInformation(Integer id, String classInformation_name, String classInformation_Instructor,
			String classInformation_Instructor_IDCard, int classInformation_number);
	
	//�������֤�Ų�ѯ����Ա��Ϣ
	NoteResult class_Instructor_show(String iDCard);
	
	//�������и���Ա
	NoteResult findInstructor();
	
	//��ȡ�ø���Ա�����֤��
	NoteResult findIDCard(Integer id);
	
	//��ʾ�༶�γ���Ϣ
	NoteResult ShowClassCurriculum(String message);
	
	//��ѯ���а༶����
	NoteResult findClassName();
	
	//��Ӱ༶�γ�
	NoteResult Addclass_curriculum(Class_curriculum c);
	
	//����id��ʾ�༶�γ�
	NoteResult Showclass_curriculumById(Integer id);
	
	//����id�޸İ༶�γ�
	NoteResult Updateclass_curriculum(Class_curriculum c);
	
	//��֤�Ƿ���ڵ���γ�
	NoteResult Select_curriculum(String classname, String week);
	
	//�������н�ʦ
	NoteResult findAllTeacher();
	
	//��ӽ�ʦ���
	NoteResult AddClassSchedule(String teachername, String classname, String classSchedule_teacher_IDCard);
	
	//����id��ʾ��ʦ����ڱ༭ҳ��
	NoteResult ShowClassScheduleById(Integer id);
	
	//�޸Ľ�ʦ���
	NoteResult UpdateClassSchedule(Class_Schedule c);
	
	//����idɾ����ʦ���
	NoteResult DeleteClassSchedule(Integer id);

}
