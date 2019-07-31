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

	
	//根据id删除学生
	void DeleteStudent(Integer studentid);

	
	//添加学生
	void AddStudent(Student s);


	//根据id查询学生个人信息
	Student Show_studentInfo(Integer student_id);


	//根据id修改学生
	void UpdateStudent(Student s);

	//根据id删除教师
	void DeleteTeacher(Integer teacherid);


	//添加教师
	void AddTeacher(Teacher t);


	//查询教师信息
	Teacher Show_teacherInfo(Integer teacher_id);


	//修改教师
	void UpdateTeacher(Teacher t);

	//根据输入信息查询所有学生信息的数量
	int SearchStudentCount(SearchpeopleByMessage s);


	//根据输入信息查询所有学生信息
	List<Student> SearchStudent(@Param("datemin")Date datemin, @Param("datemax")Date datemax, @Param("message")String message, @Param("start")int start,  @Param("end")int end);


	//根据输入的信息查询所有教师的数量
	int SearchTeacherCount(SearchpeopleByMessage s);


	//根据输入的信息查询所有教师信息
	List<Teacher> SearchTeacher(@Param("datemin")Date datemin, @Param("datemax")Date datemax, @Param("message")String message, @Param("start")int start,  @Param("end")int end);


	//查询所有专业
	List<Professional> findProfession();


	void AddUser(User u);

}
