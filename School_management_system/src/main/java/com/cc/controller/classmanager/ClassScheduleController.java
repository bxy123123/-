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
	 * 查找所有教师
	 * @return
	 */
	@RequestMapping("/findAllTeacher.do")
	@ResponseBody
	public NoteResult findAllTeacher(){
		NoteResult result=cs.findAllTeacher();
		return result;
	}
	
	/**
	 * 添加教师班表
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
	 * 根据id显示教师班表在编辑页面
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
	 * 修改教师班表
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
	 * 根据id删除教师班表
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
