package com.cc.controller.classmanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.service.ClassManagerService;
import com.cc.util.NoteResult;

@Controller
public class ClassInformationController {

	@Resource
	private ClassManagerService cs;
	
	/**
	 * ɾ���༶��Ϣ
	 * @param id
	 * @return
	 */
	@RequestMapping("/DeleteClassInformation.do")
	@ResponseBody
	public NoteResult DeleteClassInformation(Integer id){
		NoteResult result=cs.DeleteClassInformation(id);
		return result;
	}
	
	/**
	 * �����༶��Ϣ
	 */
	@RequestMapping("/AddClassInformation.do")
	@ResponseBody
	public NoteResult AddClassInformation(String classInformation_name,String classInformation_Instructor,String classInformation_Instructor_IDCard,int classInformation_number){
		NoteResult result=cs.AddClassInformation(classInformation_name,classInformation_Instructor,classInformation_Instructor_IDCard,classInformation_number);
		return result;
	}
	
	/**
	 * ����id��ʾ�༶��Ϣ
	 * @param id
	 * @return
	 */
	@RequestMapping("/ShowClassInformation.do")
	@ResponseBody
	public NoteResult ShowClassInformation(Integer id){
		NoteResult result=cs.ShowClassInformation(id);
		return result;
	}
	
	/**
	 * �޸İ༶��Ϣ
	 */
	@RequestMapping("/UpdateClassInformation.do")
	@ResponseBody
	public NoteResult UpdateClassInformation(Integer id,String classInformation_name,String classInformation_Instructor,String classInformation_Instructor_IDCard,int classInformation_number){
		NoteResult result=cs.UpdateClassInformation(id,classInformation_name,classInformation_Instructor,classInformation_Instructor_IDCard,classInformation_number);
		return result;
	}
	
	/**
	 * �������и���Ա
	 * @return
	 */
	@RequestMapping("/findInstructor.do")
	@ResponseBody
	public NoteResult findInstructor(){
		NoteResult result=cs.findInstructor();
		return result;
	}
	
	/**
	 * ��ȡ�ø���Ա�����֤��
	 * @param id
	 * @return
	 */
	@RequestMapping("/findIDCard.do")
	@ResponseBody
	public NoteResult findIDCard(Integer id){
		NoteResult result=cs.findIDCard(id);
		return result;
	}
	/**
	 * �������֤�Ų�ѯ����Ա��Ϣ
	 * @param IDCard
	 * @return
	 */
	@RequestMapping("/Instructor_show.do")
	@ResponseBody
	public NoteResult class_Instructor_show(String iDCard){
		NoteResult result=cs.class_Instructor_show(iDCard);
		return result;
	}
}
