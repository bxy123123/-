package com.cc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.cc.dao.PageDao;
import com.cc.entity.Arrange;
import com.cc.entity.ClassInformation;
import com.cc.entity.Class_Schedule;
import com.cc.entity.Class_curriculum;
import com.cc.entity.Club_activities;
import com.cc.entity.Log;
import com.cc.entity.Professional;
import com.cc.entity.School_activities;
import com.cc.entity.Student;
import com.cc.entity.Student_achievement;
import com.cc.entity.Teacher;
import com.cc.entity.User;
import com.cc.service.PageService;
import com.cc.util.PageUtil;

@Service
public class PageImpl implements PageService {

	@Resource
	private PageDao ud;
	
	public PageUtil pageing(String currentPage) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageSize();
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<User> list = ud.findpage(page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}


	public PageUtil pageStudentInfo(String currentPage) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageSizeStudentInfo();
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Student> list = ud.findpageStudentInfo(page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}

	public PageUtil pageTeacherInfo(String currentPage) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageSizeTeacherInfo();
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Teacher> list = ud.findpageTeacherInfo(page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}

	public PageUtil pageAdminLog(String currentPage) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageSizeAdminLog();
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Log> list = ud.findpageAdminLog(page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}

	public PageUtil pagePlaceArrange(String currentPage) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pagePlaceArrange();
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Arrange> list = ud.findpagePlaceArrange(page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}

	public PageUtil pageClubActivities(String currentPage) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageClubActivities();
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Club_activities> list = ud.findpagepageClubActivities(page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}

	public PageUtil pageSchoolActivities(String currentPage) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageSchoolActivities();
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<School_activities> list = ud.findpagepageSchoolActivities(page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}

	public PageUtil pageClassInformation(String currentPage) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageClassInformation();
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<ClassInformation> list = ud.findpageClassInformation(page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}

	public PageUtil pageClassInformationByMessage(String currentPage, String message) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageClassInformationByMessage(message);
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<ClassInformation> list = ud.findpageClassInformationByMessage(page.getStart(),page.getEnd(),message);
		page.setData(list);
		return page;
	}
	
	public PageUtil pageProfession(String currentPage) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageProfession();
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Professional> list = ud.findpagepageProfession(page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}
	
	public PageUtil pageProfessionByMessage(String currentPage, String message) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageProfessionByMessage(message);
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Professional> list = ud.findpageProfessionByMessage(page.getStart(),page.getEnd(),message);
		page.setData(list);
		return page;
	}

	public PageUtil pageAdminRoleInfoByMessage(String currentPage, String message) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageAdminRoleInfoByMessage(message);
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<User> list = ud.findpageAdminRoleInfoByMessage(page.getStart(),page.getEnd(),message);
		page.setData(list);
		return page;
	}


	public PageUtil pageClassStudentInfo(String currentPage, String message) {
		//根据辅导员名字查询所带的班级
		User user=(User)SecurityUtils.getSubject().getSession().getAttribute("User");
		String user_name=user.getUser_name();
		String class_name=ud.findClassName(user_name);
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageClassStudentInfo(message,class_name);
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Student> list = ud.findpageClassStudentInfo(page.getStart(),page.getEnd(),message,class_name);
		page.setData(list);
		return page;
	}


	public PageUtil ShowClassCurriculumInformation() {
		PageUtil page = new PageUtil();
		User user=(User)SecurityUtils.getSubject().getSession().getAttribute("User");
		String user_name=user.getUser_name();
		String class_name=ud.findClassName(user_name);
		List<Class_curriculum> list=ud.ShowClassCurriculumInformation(class_name);
		page.setData(list);
		return page;
	}


	public PageUtil pageClassSchedule(String currentPage,String message) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(5);
		int size = ud.pageClassSchedule(message);
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Class_Schedule> list = ud.findpageClassSchedule(message,page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}


	/**
	 * 根据选择的班级查询该班所有的学生
	 */
	public PageUtil pagefindStudentByClassName(String currentPage, String classname, String message) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(10);
		int size = ud.pagefindStudentByClassName(classname,message);
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Student> list = ud.findpagefindStudentByClassName(classname,message,page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}

	/**
	 * 根据选择的学期查询该班所有的学生
	 */
	public PageUtil pagefindStudentBySemester(String currentPage, String classname, String semester, String message) {
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(10);
		int size = ud.pagefindStudentBySemester(classname,semester,message);
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Student_achievement> list = ud.findpagefindStudentBySemester(classname,semester,message,page.getStart(),page.getEnd());
		page.setData(list);
		return page;
	}


	/**
	 * 辅导员查看所带班级的学生成绩
	 */
	public PageUtil pageLookClassAchievement(String currentPage, String semester, String message) {
		User user=(User)SecurityUtils.getSubject().getSession().getAttribute("User");
		String user_name=user.getUser_name();
		String class_name=ud.findClassName(user_name);
		PageUtil page = new PageUtil();
		String str = currentPage;
		int current = 0;
		if(str == null || "".equals(str)){
			current = 1;
		}else{
			current = Integer.parseInt(str);
		}
		page.setPageSize(10);
		int size = ud.pageLookClassAchievement(message,class_name,semester);
		page.setTotalCount(size);
		page.setCurrentPage(current);
		List<Student_achievement> list = ud.findpageLookClassAchievement(page.getStart(),page.getEnd(),message,class_name,semester);
		page.setData(list);
		return page;
	}
}
