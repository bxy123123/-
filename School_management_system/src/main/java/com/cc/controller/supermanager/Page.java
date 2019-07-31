package com.cc.controller.supermanager;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.service.PageService;
import com.cc.util.PageUtil;

@Controller
public class Page {
	
	@Resource
	private PageService up;
	
	@RequestMapping("/paging.do")
	@ResponseBody
	public PageUtil page(String currentPage){
		PageUtil page = up.pageing(currentPage);
		return page;
	}
	
	@RequestMapping("/pageAdminRoleInfoByMessage.do")
	@ResponseBody
	public PageUtil pageAdminRoleInfoByMessage(String currentPage,String message){
		PageUtil page = up.pageAdminRoleInfoByMessage(currentPage,message);
		return page;
	}
	
	@RequestMapping("/pageStudentInfo.do")
	@ResponseBody
	public PageUtil pageStudentInfo(String currentPage){
		PageUtil page = up.pageStudentInfo(currentPage);
		return page;
	}
	@RequestMapping("/pageAdminLog.do")
	@ResponseBody
	public PageUtil pageAdminLog(String currentPage){
		PageUtil page = up.pageAdminLog(currentPage);
		return page;
	}
	
	@RequestMapping("/pageTeacherInfo.do")
	@ResponseBody
	public PageUtil pageTeacherInfo(String currentPage){
		PageUtil page = up.pageTeacherInfo(currentPage);
		return page;
	}
	
	@RequestMapping("/pagePlaceArrange.do")
	@ResponseBody
	public PageUtil pagePlaceArrange(String currentPage){
		PageUtil page = up.pagePlaceArrange(currentPage);
		return page;
	}
	
	@RequestMapping("/pageClubActivities.do")
	@ResponseBody
	public PageUtil pageClubActivities(String currentPage){
		PageUtil page = up.pageClubActivities(currentPage);
		return page;
	}
	
	@RequestMapping("/pageSchoolActivities.do")
	@ResponseBody
	public PageUtil pageSchoolActivities(String currentPage){
		PageUtil page = up.pageSchoolActivities(currentPage);
		return page;
	}
	
	@RequestMapping("/pageClassInformation.do")
	@ResponseBody
	public PageUtil pageClassInformation(String currentPage){
		PageUtil page = up.pageClassInformation(currentPage);
		return page;
	}
	
	@RequestMapping("/pageClassInformationByMessage.do")
	@ResponseBody
	public PageUtil pageClassInformationByMessage(String currentPage,String message){
		PageUtil page = up.pageClassInformationByMessage(currentPage,message);
		return page;
	}
	
	@RequestMapping("/pageProfession.do")
	@ResponseBody
	public PageUtil pageProfession(String currentPage){
		PageUtil page = up.pageProfession(currentPage);
		return page;
	}
	
	@RequestMapping("/pageProfessionByMessage.do")
	@ResponseBody
	public PageUtil pageProfessionByMessage(String currentPage,String message){
		PageUtil page = up.pageProfessionByMessage(currentPage,message);
		return page;
	}
	
	@RequestMapping("/pageClassStudentInfo.do")
	@ResponseBody
	public PageUtil pageClassStudentInfo(String currentPage,String message){
		PageUtil page = up.pageClassStudentInfo(currentPage,message);
		return page;
	}
	
	/**
	 * 显示辅导员所带的班级课程
	 * @return
	 */
	@RequestMapping("/ShowClassCurriculumInformation.do")
	@ResponseBody
	public PageUtil ShowClassCurriculumInformation(){
		PageUtil page = up.ShowClassCurriculumInformation();
		return page;
	}
	/**
	 * 教师班表
	 * @param currentPage
	 * @param message
	 * @return
	 */
	@RequestMapping("/pageClassSchedule.do")
	@ResponseBody
	public PageUtil pageClassSchedule(String currentPage,String message){
		PageUtil page = up.pageClassSchedule(currentPage,message);
		return page;
	}
	
	/**
	 * 根据选择的班级查询该班所有的学生
	 * @param currentPage
	 * @param classname
	 * @param message
	 * @return
	 */
	@RequestMapping("/pagefindStudentByClassName.do")
	@ResponseBody
	public PageUtil pagefindStudentByClassName(String currentPage,String classname,String message){
		PageUtil page = up.pagefindStudentByClassName(currentPage,classname,message);
		return page;
	}
	
	/**
	 * 根据选择的学期查询该班所有的学生成绩
	 * @param currentPage
	 * @param classname
	 * @param semester
	 * @param message
	 * @return
	 */
	@RequestMapping("/pagefindStudentBySemester.do")
	@ResponseBody
	public PageUtil pagefindStudentBySemester(String currentPage,String classname,String semester,String message){
		PageUtil page = up.pagefindStudentBySemester(currentPage,classname,semester,message);
		return page;
	}
	
	/**
	 * 辅导员查看所带班级的学生成绩
	 * @param currentPage
	 * @param semester
	 * @param message
	 * @return
	 */
	@RequestMapping("/pageLookClassAchievement.do")
	@ResponseBody
	public PageUtil pageClassAchievement(String currentPage,String semester,String message){
		PageUtil page = up.pageLookClassAchievement(currentPage,semester,message);
		return page;
	}
}
