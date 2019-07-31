package com.cc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.cc.dao.TeacherDao;
import com.cc.entity.Class_Schedule;
import com.cc.entity.Class_curriculum;
import com.cc.entity.Student_achievement;
import com.cc.entity.User;
import com.cc.service.TeacherSerivce;
import com.cc.util.NoteResult;
@Service
public class TeacherSerivceImpl implements TeacherSerivce {

	@Resource
	private TeacherDao td;
	
	
	/**
	 * 查找登录的教师所带的班级
	 */
	public NoteResult selectClassByTeacher() {
		User user=(User)SecurityUtils.getSubject().getSession().getAttribute("User");
		List<Class_Schedule> list=td.selectClassByTeacher(user.getUser_IDCard());
		NoteResult result=new NoteResult();
		result.setData(list);
		result.setStatus(0);
		return result;
	}


	/**
	 * 判断该学生成绩是否保存过
	 */
	public NoteResult JudgeStudentAchievement(String student_code) {
		Student_achievement s=td.JudgeStudentAchievement(student_code);
		NoteResult result=new NoteResult();
		result.setData(s);
		result.setStatus(0);
		return result;
	}


	/**
	 * 录入学生成绩
	 */
	public NoteResult SaveStudentAchievement(Student_achievement s) {
		td.SaveStudentAchievement(s);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	/**
	 * 修改学生成绩
	 */
	public NoteResult UpdateStudentAchievement(Student_achievement s) {
		td.UpdateStudentAchievement(s);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	/**
	 * 教师查看所带班级的课程
	 */
	public NoteResult Lookclass_curriculum(String classname) {
		List<Class_curriculum> list=td.Lookclass_curriculum(classname);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setData(list);
		return result;
	}

}
