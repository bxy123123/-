package com.cc.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cc.entity.Professional;
import com.cc.entity.SearchpeopleByMessage;
import com.cc.entity.Student;
import com.cc.entity.Teacher;
import com.cc.entity.User;

public interface PeopleManagerDao {

	
	//����idɾ��ѧ��
	void DeleteStudent(Integer studentid);

	
	//���ѧ��
	void AddStudent(Student s);


	//����id��ѯѧ��������Ϣ
	Student Show_studentInfo(Integer student_id);


	//����id�޸�ѧ��
	void UpdateStudent(Student s);

	//����idɾ����ʦ
	void DeleteTeacher(Integer teacherid);


	//��ӽ�ʦ
	void AddTeacher(Teacher t);


	//��ѯ��ʦ��Ϣ
	Teacher Show_teacherInfo(Integer teacher_id);


	//�޸Ľ�ʦ
	void UpdateTeacher(Teacher t);

	//����������Ϣ��ѯ����ѧ����Ϣ������
	int SearchStudentCount(SearchpeopleByMessage s);


	//����������Ϣ��ѯ����ѧ����Ϣ
	List<Student> SearchStudent(@Param("datemin")Date datemin, @Param("datemax")Date datemax, @Param("message")String message, @Param("start")int start,  @Param("end")int end);


	//�����������Ϣ��ѯ���н�ʦ������
	int SearchTeacherCount(SearchpeopleByMessage s);


	//�����������Ϣ��ѯ���н�ʦ��Ϣ
	List<Teacher> SearchTeacher(@Param("datemin")Date datemin, @Param("datemax")Date datemax, @Param("message")String message, @Param("start")int start,  @Param("end")int end);


	//��ѯ����רҵ
	List<Professional> findProfession();


	void AddUser(User u);

}
