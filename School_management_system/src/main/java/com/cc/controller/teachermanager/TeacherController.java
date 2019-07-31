package com.cc.controller.teachermanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.entity.Student_achievement;
import com.cc.service.TeacherSerivce;
import com.cc.util.NoteResult;

@Controller
public class TeacherController {

	
	@Resource
	private TeacherSerivce ts;
	
	/**
	 * ���ҵ�¼�Ľ�ʦ�����İ༶
	 * @return
	 */
	@RequestMapping("/selectClassByTeacher.do")
	@ResponseBody
	public NoteResult selectClassByTeacher(){
		NoteResult result=ts.selectClassByTeacher();
		return result;
	}
	
	/**
	 * �жϸ�ѧ���ɼ��Ƿ񱣴��
	 * @param student_code
	 * @return
	 */
	@RequestMapping("/JudgeStudentAchievement.do")
	@ResponseBody
	public NoteResult JudgeStudentAchievement(String student_code){
		NoteResult result=ts.JudgeStudentAchievement(student_code);
		return result;
	}
	
	/**
	 * ¼��ѧ���ɼ�
	 * @param student_name
	 * @param student_code
	 * @param student_profession
	 * @param student_midterm
	 * @param student_final
	 * @param student_total
	 * @param student_class
	 * @param student_semester
	 * @return
	 */
	@RequestMapping("/SaveStudentAchievement.do")
	@ResponseBody
	public NoteResult SaveStudentAchievement(String student_name,String student_code,String student_profession,double student_midterm,double student_final,double student_total,String student_class,String student_semester){
		Student_achievement s=new Student_achievement();
		s.setStudent_class(student_class);
		s.setStudent_code(student_code);
		s.setStudent_final_achievement(student_final);
		s.setStudent_midterm_achievement(student_midterm);
		s.setStudent_name(student_name);
		s.setStudent_profession(student_profession);
		s.setStudent_semester(student_semester);
		s.setStudent_total_achievement(student_total);
		NoteResult result=ts.SaveStudentAchievement(s);
		return result;
	}
	
	/**
	 * �޸�ѧ���ɼ�
	 * @param student_code
	 * @param student_midterm
	 * @param student_final
	 * @param student_total
	 * @return
	 */
	@RequestMapping("/UpdateStudentAchievement.do")
	@ResponseBody
	public NoteResult UpdateStudentAchievement(String student_code,double student_midterm,double student_final,double student_total){
		Student_achievement s=new Student_achievement();
		s.setStudent_code(student_code);
		s.setStudent_final_achievement(student_final);
		s.setStudent_midterm_achievement(student_midterm);
		s.setStudent_total_achievement(student_total);
		NoteResult result=ts.UpdateStudentAchievement(s);
		return result;
	}
	
	/**
	 * ��ʦ�鿴�����༶�Ŀγ�
	 * @param classname
	 * @return
	 */
	@RequestMapping("/Lookclass_curriculum.do")
	@ResponseBody
	public NoteResult Lookclass_curriculum(String classname){
		NoteResult result=ts.Lookclass_curriculum(classname);
		return result;
	}
}
