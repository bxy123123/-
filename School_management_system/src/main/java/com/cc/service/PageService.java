package com.cc.service;

import com.cc.util.PageUtil;

public interface PageService {

	public PageUtil pageing(String currentPage);


	public PageUtil pageStudentInfo(String currentPage);

	public PageUtil pageTeacherInfo(String currentPage);

	public PageUtil pageAdminLog(String currentPage);

	public PageUtil pagePlaceArrange(String currentPage);

	public PageUtil pageClubActivities(String currentPage);

	public PageUtil pageSchoolActivities(String currentPage);

	public PageUtil pageClassInformation(String currentPage);

	public PageUtil pageClassInformationByMessage(String currentPage, String message);

	public PageUtil pageProfession(String currentPage);

	public PageUtil pageProfessionByMessage(String currentPage, String message);

	public PageUtil pageAdminRoleInfoByMessage(String currentPage, String message);

	public PageUtil pageClassStudentInfo(String currentPage, String message);

	public PageUtil ShowClassCurriculumInformation();

	public PageUtil pageClassSchedule(String currentPage, String message);

	public PageUtil pagefindStudentByClassName(String currentPage, String classname, String message);

	public PageUtil pagefindStudentBySemester(String currentPage, String classname, String semester, String message);

	public PageUtil pageLookClassAchievement(String currentPage, String semester, String message);

}
