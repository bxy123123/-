package com.cc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cc.entity.ClassInformation;
import com.cc.entity.Class_Schedule;
import com.cc.entity.Class_curriculum;
import com.cc.entity.Teacher;

public interface ClassManagerDao {

	//ɾ���༶��Ϣ
	void DeleteClassInformation(Integer id);
	//�����༶��Ϣ
	void AddClassInformation(ClassInformation classInformation);
	//����id��ʾ�༶��Ϣ
	ClassInformation ShowClassInformation(Integer id);
	//�޸İ༶��Ϣ
	void UpdateClassInformation(ClassInformation classInformation);
	
	//�������֤�Ų�ѯ����Ա��Ϣ
	Teacher class_Instructor_show(String iDCard);
	
	//�������и���Ա
	List<Teacher> findInstructor();
	
	//��ȡ�ø���Ա�����֤��
	String findIDCard(Integer id);
	
	//��ʾ�༶�γ���Ϣ
	List<Class_curriculum> ShowClassCurriculum(@Param("message")String message);
	
	//��ѯ���а༶����
	List<ClassInformation> findClassName();
	
	//��Ӱ༶�γ�
	void Addclass_curriculum(Class_curriculum c);
	
	//����Id��ʾ�༶�γ�
	Class_curriculum Showclass_curriculumById(Integer id);
	
	//����id�޸İ༶�γ�
	void Updateclass_curriculum(Class_curriculum c);
	
	//��ѯ�Ƿ���ڰ༶��������
	Class_curriculum Select_curriculum(@Param("classname")String classname, @Param("week")String week);
	
	//�������н�ʦ
	List<Teacher> findAllTeacher();
	
	//��ӽ�ʦ��
	void AddClassSchedule(Class_Schedule c);
	
	//����id��ʾ��ʦ����ڱ༭ҳ��
	Class_Schedule ShowClassScheduleById(Integer id);
	
	//�޸Ľ�ʦ���
	void UpdateClassSchedule(Class_Schedule c);
	
	//����idɾ����ʦ���
	void DeleteClassSchedule(Integer id);
	
}
