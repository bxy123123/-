package com.cc.service;

import com.cc.entity.Class_Schedule;
import com.cc.entity.Class_curriculum;
import com.cc.util.NoteResult;

public interface ClassManagerService {

	//删除班级信息
	NoteResult DeleteClassInformation(Integer id);
	//新增班级信息
	NoteResult AddClassInformation(String classInformation_name, String classInformation_Instructor,
			String classInformation_Instructor_IDCard, int classInformation_number);
	
	//根据id显示班级信息
	NoteResult ShowClassInformation(Integer id);
	
	//修改班级信息
	NoteResult UpdateClassInformation(Integer id, String classInformation_name, String classInformation_Instructor,
			String classInformation_Instructor_IDCard, int classInformation_number);
	
	//根据身份证号查询辅导员信息
	NoteResult class_Instructor_show(String iDCard);
	
	//查找所有辅导员
	NoteResult findInstructor();
	
	//获取该辅导员的身份证号
	NoteResult findIDCard(Integer id);
	
	//显示班级课程信息
	NoteResult ShowClassCurriculum(String message);
	
	//查询所有班级名称
	NoteResult findClassName();
	
	//添加班级课程
	NoteResult Addclass_curriculum(Class_curriculum c);
	
	//根据id显示班级课程
	NoteResult Showclass_curriculumById(Integer id);
	
	//根据id修改班级课程
	NoteResult Updateclass_curriculum(Class_curriculum c);
	
	//验证是否存在当天课程
	NoteResult Select_curriculum(String classname, String week);
	
	//查找所有教师
	NoteResult findAllTeacher();
	
	//添加教师班表
	NoteResult AddClassSchedule(String teachername, String classname, String classSchedule_teacher_IDCard);
	
	//根据id显示教师班表在编辑页面
	NoteResult ShowClassScheduleById(Integer id);
	
	//修改教师班表
	NoteResult UpdateClassSchedule(Class_Schedule c);
	
	//根据id删除教师班表
	NoteResult DeleteClassSchedule(Integer id);

}
