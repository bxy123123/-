package com.cc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cc.entity.ClassInformation;
import com.cc.entity.Class_Schedule;
import com.cc.entity.Class_curriculum;
import com.cc.entity.Teacher;

public interface ClassManagerDao {

	//删除班级信息
	void DeleteClassInformation(Integer id);
	//新增班级信息
	void AddClassInformation(ClassInformation classInformation);
	//根据id显示班级信息
	ClassInformation ShowClassInformation(Integer id);
	//修改班级信息
	void UpdateClassInformation(ClassInformation classInformation);
	
	//根据身份证号查询辅导员信息
	Teacher class_Instructor_show(String iDCard);
	
	//查找所有辅导员
	List<Teacher> findInstructor();
	
	//获取该辅导员的身份证号
	String findIDCard(Integer id);
	
	//显示班级课程信息
	List<Class_curriculum> ShowClassCurriculum(@Param("message")String message);
	
	//查询所有班级名称
	List<ClassInformation> findClassName();
	
	//添加班级课程
	void Addclass_curriculum(Class_curriculum c);
	
	//根据Id显示班级课程
	Class_curriculum Showclass_curriculumById(Integer id);
	
	//根据id修改班级课程
	void Updateclass_curriculum(Class_curriculum c);
	
	//查询是否存在班级当天数据
	Class_curriculum Select_curriculum(@Param("classname")String classname, @Param("week")String week);
	
	//查找所有教师
	List<Teacher> findAllTeacher();
	
	//添加教师表
	void AddClassSchedule(Class_Schedule c);
	
	//根据id显示教师班表在编辑页面
	Class_Schedule ShowClassScheduleById(Integer id);
	
	//修改教师班表
	void UpdateClassSchedule(Class_Schedule c);
	
	//根据id删除教师班表
	void DeleteClassSchedule(Integer id);
	
}
