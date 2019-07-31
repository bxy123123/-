package com.cc.service;

import com.cc.entity.Student_achievement;
import com.cc.util.NoteResult;

public interface TeacherSerivce {

	//查找登录的教师所带的班级
	NoteResult selectClassByTeacher();

	//判断该学生成绩是否保存过
	NoteResult JudgeStudentAchievement(String student_code);

	//录入学生成绩
	NoteResult SaveStudentAchievement(Student_achievement s);

	//修改学生成绩
	NoteResult UpdateStudentAchievement(Student_achievement s);

	//教师查看所带班级的课程
	NoteResult Lookclass_curriculum(String classname);

}
