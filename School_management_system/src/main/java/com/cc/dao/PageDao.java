package com.cc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

public interface PageDao {

	public int pageSize();

	public List<User> findpage(@Param("start")int start, @Param("end")int end);
	
	public int pageSizeAdminLog();

	public List<Log> findpageAdminLog(@Param("start")int start,  @Param("end")int end);

	public int pageSizeStudentInfo();

	public List<Student> findpageStudentInfo(@Param("start")int start,  @Param("end")int end);

	public int pageSizeTeacherInfo();

	public List<Teacher> findpageTeacherInfo(@Param("start")int start,  @Param("end")int end);

	public int pagePlaceArrange();

	public List<Arrange> findpagePlaceArrange(@Param("start")int start,  @Param("end")int end);

	public int pageClubActivities();

	public List<Club_activities> findpagepageClubActivities(@Param("start")int start,  @Param("end")int end);

	public int pageSchoolActivities();

	public List<School_activities> findpagepageSchoolActivities(@Param("start")int start,  @Param("end")int end);

	public int pageClassInformation();

	public List<ClassInformation> findpageClassInformation(@Param("start")int start,  @Param("end")int end);

	public int pageClassInformationByMessage(@Param("message")String message);

	public List<ClassInformation> findpageClassInformationByMessage(@Param("start")int start,  @Param("end")int end, @Param("message")String message);

	public int pageProfession();

	public List<Professional> findpagepageProfession(@Param("start")int start,  @Param("end")int end);
	
	public int pageProfessionByMessage(@Param("message")String message);

	public List<Professional> findpageProfessionByMessage(@Param("start")int start,  @Param("end")int end, @Param("message")String message);

	public int pageAdminRoleInfoByMessage(@Param("message")String message);

	public List<User> findpageAdminRoleInfoByMessage(@Param("start")int start,  @Param("end")int end, @Param("message")String message);

	public String findClassName(String user_name);

	public int pageClassStudentInfo(@Param("message")String message, @Param("class_name")String class_name);

	public List<Student> findpageClassStudentInfo(@Param("start")int start,  @Param("end")int end, @Param("message")String message,@Param("class_name")String class_name);

	public List<Class_curriculum> ShowClassCurriculumInformation(String class_name);

	public int pageClassSchedule(@Param("message")String message);

	public List<Class_Schedule> findpageClassSchedule(@Param("message")String message, @Param("start")int start,  @Param("end")int end);

	public int pagefindStudentByClassName(@Param("classname")String classname, @Param("message")String message);

	public List<Student> findpagefindStudentByClassName(@Param("classname")String classname, @Param("message")String message,@Param("start")int start,  @Param("end")int end);

	public int pagefindStudentBySemester(@Param("classname")String classname, @Param("semester")String semester, @Param("message")String message);

	public List<Student_achievement> findpagefindStudentBySemester(@Param("classname")String classname, @Param("semester")String semester, @Param("message")String message, @Param("start")int start,  @Param("end")int end);

	public int pageLookClassAchievement(@Param("message")String message, @Param("class_name")String class_name, @Param("semester")String semester);

	public List<Student_achievement> findpageLookClassAchievement(@Param("start")int start,  @Param("end")int end, @Param("message")String message, @Param("class_name")String class_name,
			@Param("semester")String semester);

}
