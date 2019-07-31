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
	 * ���ҵ�¼�Ľ�ʦ�����İ༶
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
	 * �жϸ�ѧ���ɼ��Ƿ񱣴��
	 */
	public NoteResult JudgeStudentAchievement(String student_code) {
		Student_achievement s=td.JudgeStudentAchievement(student_code);
		NoteResult result=new NoteResult();
		result.setData(s);
		result.setStatus(0);
		return result;
	}


	/**
	 * ¼��ѧ���ɼ�
	 */
	public NoteResult SaveStudentAchievement(Student_achievement s) {
		td.SaveStudentAchievement(s);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	/**
	 * �޸�ѧ���ɼ�
	 */
	public NoteResult UpdateStudentAchievement(Student_achievement s) {
		td.UpdateStudentAchievement(s);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	/**
	 * ��ʦ�鿴�����༶�Ŀγ�
	 */
	public NoteResult Lookclass_curriculum(String classname) {
		List<Class_curriculum> list=td.Lookclass_curriculum(classname);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setData(list);
		return result;
	}

}
