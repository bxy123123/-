package com.cc.service;

import com.cc.entity.SearchpeopleByMessage;
import com.cc.entity.Student;
import com.cc.entity.Teacher;
import com.cc.util.NoteResult;
import com.cc.util.PageUtil;

public interface PeopleManagerService {

	//根据id删除学生
	NoteResult DeleteStudent(Integer studentid);

	//添加学生
	NoteResult AddStudent(Student s);

	//根据Id查询学生个人信息
	NoteResult Student_Show(Integer student_id);

	//修改学生
	NoteResult updateStudent(Student s);

	//根据id删除教师
	NoteResult DeleteTeacher(Integer teacherid);

	//添加教师
	NoteResult AddTeacher(Teacher t);

	//查询教师信息
	NoteResult Teacher_Show(Integer teacher_id);

	//修改教师信息
	NoteResult UpdateTeacher(Teacher t);

	//根据输入信息查询学生信息
	PageUtil SearchStudent(SearchpeopleByMessage s);

	//根据输入的信息查询所有教师信息
	PageUtil SearchTeacher(SearchpeopleByMessage s);

	//查询所有专业
	NoteResult findProfession();

}
