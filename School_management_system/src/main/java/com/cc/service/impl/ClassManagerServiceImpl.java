package com.cc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cc.dao.ClassManagerDao;
import com.cc.entity.ClassInformation;
import com.cc.entity.Class_Schedule;
import com.cc.entity.Class_curriculum;
import com.cc.entity.Teacher;
import com.cc.service.ClassManagerService;
import com.cc.util.NoteResult;

@Service
public class ClassManagerServiceImpl implements ClassManagerService {

	@Resource
	private ClassManagerDao cd;
	
	/**
	 * ɾ���༶��Ϣ
	 */
	public NoteResult DeleteClassInformation(Integer id) {
		cd.DeleteClassInformation(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	/**
	 * �����༶��Ϣ
	 */

	public NoteResult AddClassInformation(String classInformation_name, String classInformation_Instructor,String classInformation_Instructor_IDCard,
			int classInformation_number) {
		ClassInformation classInformation = new ClassInformation();
		classInformation.setClass_name(classInformation_name);
		classInformation.setClass_Instructor(classInformation_Instructor);
		classInformation.setClass_number(classInformation_number);
		classInformation.setInstructor_IDCard(classInformation_Instructor_IDCard);
		cd.AddClassInformation(classInformation);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setMsg("����ɹ�");
		return result;		
	}
	
	/**
	 * ����id��ʾ�༶��Ϣ
	 */
	public NoteResult ShowClassInformation(Integer id) {
		ClassInformation classInformation=cd.ShowClassInformation(id);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		result.setData(classInformation);
		return result;
	}
	
	/**
	 * �޸İ༶��Ϣ
	 */
	public NoteResult UpdateClassInformation(Integer id, String classInformation_name,
			String classInformation_Instructor,String classInformation_Instructor_IDCard, int classInformation_number) {
		ClassInformation classInformation = new ClassInformation();
		classInformation.setClass_id(id);
		classInformation.setClass_name(classInformation_name);
		classInformation.setClass_Instructor(classInformation_Instructor);
		classInformation.setClass_number(classInformation_number);
		classInformation.setInstructor_IDCard(classInformation_Instructor_IDCard);
		cd.UpdateClassInformation(classInformation);
		NoteResult result = new NoteResult();
		result.setStatus(0);
		return result;		
		
	}
	/**
	 * �������֤�Ų�ѯ����Ա��Ϣ
	 */
	public NoteResult class_Instructor_show(String iDCard) {
		Teacher t=cd.class_Instructor_show(iDCard);
		NoteResult result=new NoteResult();
		result.setData(t);
		result.setStatus(0);
		return result;
	}
	
	/**
	 * �������и���Ա
	 */
	public NoteResult findInstructor() {
		List<Teacher> list=cd.findInstructor();
		NoteResult result=new NoteResult();
		result.setData(list);
		result.setStatus(0);
		return result;
	}
	
	/**
	 * ��ȡ�ø���Ա�����֤��
	 */
	public NoteResult findIDCard(Integer id) {
		String teacher_IDCard=cd.findIDCard(id);
		NoteResult result=new NoteResult();
		result.setData(teacher_IDCard);
		result.setStatus(0);
		return result;
	}
	
	/**
	 * ��ʾ�༶�γ���Ϣ
	 */
	public NoteResult ShowClassCurriculum(String message) {
		List<Class_curriculum> list=cd.ShowClassCurriculum(message);
		NoteResult result=new NoteResult();
		result.setData(list);
		result.setStatus(0);
		return result;
	}
	
	/**
	 * ��ѯ���а༶����
	 */
	public NoteResult findClassName() {
		List<ClassInformation> list=cd.findClassName();
		NoteResult result=new NoteResult();
		result.setData(list);
		result.setStatus(0);
		return result;
	}
	
	/**
	 * ��Ӱ༶�γ�
	 */
	public NoteResult Addclass_curriculum(Class_curriculum c) {
		cd.Addclass_curriculum(c);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	/**
	 * ����Id��ʾ�༶�γ�
	 */
	public NoteResult Showclass_curriculumById(Integer id) {
		Class_curriculum c=cd.Showclass_curriculumById(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setData(c);
		return result;
	}
	/**
	 * ����id�޸İ༶�γ�
	 */
	public NoteResult Updateclass_curriculum(Class_curriculum c) {
		cd.Updateclass_curriculum(c);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	/**
	 * ��֤�Ƿ���ڵ���γ�
	 */
	public NoteResult Select_curriculum(String classname, String week) {
		Class_curriculum c = cd.Select_curriculum(classname,week);
		NoteResult result=new NoteResult();
		if(c != null){
			result.setStatus(1);
			result.setMsg("�Ѵ��ڵ���γ̵���Ϣ�����");
		}else{
			result.setStatus(0);
		}
		return result;
	}
	/**
	 * �������н�ʦ
	 */
	public NoteResult findAllTeacher() {
		List<Teacher> list=cd.findAllTeacher();
		NoteResult result=new NoteResult();
		result.setData(list);
		result.setStatus(0);
		return result;
	}
	
	/**
	 * ��ӽ�ʦ���
	 */
	public NoteResult AddClassSchedule(String teachername, String classname, String classSchedule_teacher_IDCard) {
		Class_Schedule c=new Class_Schedule();
		c.setClass_schedule_classname(classname);
		c.setClass_schedule_teachername(teachername);
		c.setTeacher_idcard(classSchedule_teacher_IDCard);
		cd.AddClassSchedule(c);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	
	/**
	 * ����id��ʾ��ʦ����ڱ༭ҳ��
	 */
	public NoteResult ShowClassScheduleById(Integer id) {
		Class_Schedule c=cd.ShowClassScheduleById(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setData(c);
		return result;
	}
	
	/**
	 * �޸Ľ�ʦ���
	 */
	public NoteResult UpdateClassSchedule(Class_Schedule c) {
		cd.UpdateClassSchedule(c);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setData(c);
		return result;
	}
	
	/**
	 * ����idɾ����ʦ���
	 */
	public NoteResult DeleteClassSchedule(Integer id) {
		cd.DeleteClassSchedule(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
}
