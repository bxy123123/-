package com.cc.controller.classmanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.entity.Class_curriculum;
import com.cc.service.ClassManagerService;
import com.cc.util.NoteResult;

@Controller
public class ClassCurriculumController {

	@Resource
	private ClassManagerService cs;
	
	/**
	 * ��ʾ�༶�γ���Ϣ
	 * @param message
	 * @return
	 */
	@RequestMapping("/ShowClassCurriculum.do")
	@ResponseBody
	public NoteResult ShowClassCurriculum(String message){
		NoteResult result=cs.ShowClassCurriculum(message);
		return result;
	}
	
	/**
	 * ��ѯ���а༶����
	 * @return
	 */
	@RequestMapping("/findClassName.do")
	@ResponseBody
	public NoteResult findClassName(){
		NoteResult result=cs.findClassName();
		return result;
	}
	
	/**
	 * ��Ӱ༶�γ�
	 * @param classname
	 * @param week
	 * @param class_curriculum_one
	 * @param class_curriculum_two
	 * @param class_curriculum_three
	 * @param class_curriculum_four
	 * @param class_curriculum_five
	 * @param class_curriculum_six
	 * @return
	 */
	@RequestMapping("/Addclass_curriculum.do")
	@ResponseBody
	public NoteResult Addclass_curriculum(String classname,String week,String class_curriculum_one,String class_curriculum_two,
											String class_curriculum_three,String class_curriculum_four,
											String class_curriculum_five,String class_curriculum_six){
		
		Class_curriculum c=new Class_curriculum();
		c.setClass_curriculum_classname(classname);
		c.setClass_curriculum_five(class_curriculum_five);
		c.setClass_curriculum_four(class_curriculum_four);
		c.setClass_curriculum_one(class_curriculum_one);
		c.setClass_curriculum_six(class_curriculum_six);
		c.setClass_curriculum_three(class_curriculum_three);
		c.setClass_curriculum_time(week);
		c.setClass_curriculum_two(class_curriculum_two);
		NoteResult result=cs.Addclass_curriculum(c);
		return result;
	}
	
	/**
	 * ����id��ʾ�༶�γ�
	 * @param id
	 * @return
	 */
	@RequestMapping("/Showclass_curriculumById.do")
	@ResponseBody
	public NoteResult Showclass_curriculumById(Integer id){
		NoteResult result=cs.Showclass_curriculumById(id);
		return result;
	}
	
	/**
	 * ����id�޸İ༶�γ�
	 * @param id
	 * @param class_curriculum_one
	 * @param class_curriculum_two
	 * @param class_curriculum_three
	 * @param class_curriculum_four
	 * @param class_curriculum_five
	 * @param class_curriculum_six
	 * @return
	 */
	@RequestMapping("/Updateclass_curriculum.do")
	@ResponseBody
	public NoteResult Updateclass_curriculum(Integer id,String class_curriculum_one,String class_curriculum_two,
											String class_curriculum_three,String class_curriculum_four,
											String class_curriculum_five,String class_curriculum_six){
		
		Class_curriculum c=new Class_curriculum();
		c.setClass_curriculum_id(id);
		c.setClass_curriculum_five(class_curriculum_five);
		c.setClass_curriculum_four(class_curriculum_four);
		c.setClass_curriculum_one(class_curriculum_one);
		c.setClass_curriculum_six(class_curriculum_six);
		c.setClass_curriculum_three(class_curriculum_three);
		c.setClass_curriculum_two(class_curriculum_two);
		NoteResult result=cs.Updateclass_curriculum(c);
		return result;
	}
	
	/**
	 * ��֤�Ƿ���ڵ���γ�
	 * @param classname
	 * @param week
	 * @return
	 */
	@RequestMapping("/Select_curriculum.do")
	@ResponseBody
	public NoteResult Select_curriculum(String classname,String week){
		NoteResult result=cs.Select_curriculum(classname,week);
		return result;
	}
}
