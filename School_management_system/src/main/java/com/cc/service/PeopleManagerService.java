package com.cc.service;

import com.cc.entity.SearchpeopleByMessage;
import com.cc.entity.Student;
import com.cc.entity.Teacher;
import com.cc.util.NoteResult;
import com.cc.util.PageUtil;

public interface PeopleManagerService {

	//����idɾ��ѧ��
	NoteResult DeleteStudent(Integer studentid);

	//���ѧ��
	NoteResult AddStudent(Student s);

	//����Id��ѯѧ��������Ϣ
	NoteResult Student_Show(Integer student_id);

	//�޸�ѧ��
	NoteResult updateStudent(Student s);

	//����idɾ����ʦ
	NoteResult DeleteTeacher(Integer teacherid);

	//��ӽ�ʦ
	NoteResult AddTeacher(Teacher t);

	//��ѯ��ʦ��Ϣ
	NoteResult Teacher_Show(Integer teacher_id);

	//�޸Ľ�ʦ��Ϣ
	NoteResult UpdateTeacher(Teacher t);

	//����������Ϣ��ѯѧ����Ϣ
	PageUtil SearchStudent(SearchpeopleByMessage s);

	//�����������Ϣ��ѯ���н�ʦ��Ϣ
	PageUtil SearchTeacher(SearchpeopleByMessage s);

	//��ѯ����רҵ
	NoteResult findProfession();

}
