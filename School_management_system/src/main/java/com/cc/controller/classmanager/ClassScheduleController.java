package com.cc.controller.classmanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.entity.Class_Schedule;
import com.cc.service.ClassManagerService;
import com.cc.util.NoteResult;

@Controller
public class ClassScheduleController {

	@Resource
	private ClassManagerService cs;
	
	
	/**
	 * �������н�ʦ
	 * @return
	 */
	@RequestMapping("/findAllTeacher.do")
	@ResponseBody
	public NoteResult findAllTeacher(){
		NoteResult result=cs.findAllTeacher();
		return result;
	}
	
	/**
	 * ��ӽ�ʦ���
	 * @param teachername
	 * @param classname
	 * @param classSchedule_teacher_IDCard
	 * @return
	 */
	@RequestMapping("/AddClassSchedule.do")
	@ResponseBody
	public NoteResult AddClassSchedule(String teachername,String classname,String classSchedule_teacher_IDCard){
		NoteResult result=cs.AddClassSchedule(teachername,classname,classSchedule_teacher_IDCard);
		return result;
	}
	
	/**
	 * ����id��ʾ��ʦ����ڱ༭ҳ��
	 * @param id
	 * @return
	 */
	@RequestMapping("/ShowClassScheduleById.do")
	@ResponseBody
	public NoteResult ShowClassScheduleById(Integer id){
		NoteResult result=cs.ShowClassScheduleById(id);
		return result;
	}
	
	/**
	 * �޸Ľ�ʦ���
	 * @param id
	 * @param teachername
	 * @param classname
	 * @param classSchedule_teacher_IDCard
	 * @return
	 */
	@RequestMapping("/UpdateClassSchedule.do")
	@ResponseBody
	public NoteResult UpdateClassSchedule(Integer id,String teachername,String classname,String classSchedule_teacher_IDCard){
		Class_Schedule c=new Class_Schedule();
		c.setClass_schedule_classname(classname);
		c.setClass_schedule_id(id);
		c.setClass_schedule_teachername(teachername);
		c.setTeacher_idcard(classSchedule_teacher_IDCard);
		NoteResult result=cs.UpdateClassSchedule(c);
		return result;
	}
	
	/**
	 * ����idɾ����ʦ���
	 * @param id
	 * @return
	 */
	@RequestMapping("/DeleteClassSchedule.do")
	@ResponseBody
	public NoteResult DeleteClassSchedule(Integer id){
		NoteResult result=cs.DeleteClassSchedule(id);
		return result;
	}
}
