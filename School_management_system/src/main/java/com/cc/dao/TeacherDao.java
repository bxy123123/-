package com.cc.dao;

import java.util.List;

import com.cc.entity.Class_Schedule;
import com.cc.entity.Class_curriculum;
import com.cc.entity.Student_achievement;

public interface TeacherDao {

	//查找登录的教师所带的班级
	List<Class_Schedule> selectClassByTeacher(String user_IDCard);

	//判断该学生成绩是否保存过
	Student_achievement JudgeStudentAchievement(String student_code);

	//录入学生成绩
	void SaveStudentAchievement(Student_achievement s);

	//修改学生成绩
	void UpdateStudentAchievement(Student_achievement s);

	//教师查看所带班级的课程
	List<Class_curriculum> Lookclass_curriculum(String classname);

}
