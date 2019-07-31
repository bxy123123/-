package com.cc.controller.index;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.entity.User;
import com.cc.util.Cookieutil;
import com.cc.util.NoteResult;
import com.cc.util.SimpleDateUtil;

@Controller
public class IndexController {
	
	@RequestMapping("/admin_role.do")
	public String admin_role(){
		return "index/admin-role";
	}
	
	@RequestMapping("/admin_permission.do")
	public String admin_permission(){
		return "index/permission";
	}
	
	@RequestMapping("/admin_role_add.do")
	public String admin_role_add(){
		return "index/admin-role-add";
	}
	
	@RequestMapping("/admin_role_update.do")
	public String admin_role_update(){
		return "index/admin-role-update";
	}
	
	@RequestMapping("/welcome.do")
	public String welcome(){
		return "index/welcome";
	}
	//查找上次登录时间
	@RequestMapping("/FindLastLoginTime.do")
	@ResponseBody
	public NoteResult FindLastLoginTime(HttpServletRequest request, HttpServletResponse response){
				NoteResult result=new NoteResult();		
				User user=(User)SecurityUtils.getSubject().getSession().getAttribute("User");
				//设置返回的编码个格式
				response.setContentType("text/html;charset=utf-8");
				//接收客户端的Cookie集合
				Cookie [] cookies = request.getCookies();
				//分理出我们想要的键值对
				Cookie cookie = Cookieutil.findCookie(cookies, user.getUser_phone());
				//判空操作
				if(cookie==null) {
					//第一次访问
					//创建Cookie 把时间记录起来 创造键为last 记录当前时间
					Cookie cookie1 = new Cookie(user.getUser_phone(),System.currentTimeMillis()+"");
					//设置 有效时间为1年
					cookie1.setMaxAge(1*365*24*60*60);
					//添加Cookie
					response.addCookie(cookie1);
					result.setData("xxxx年xx月xx日xx:xx:xx");
				}else{
				//不是第一次登录
				//讲我们之前放入浏览器的Cookie取出
					long lasttime = Long.parseLong(cookie.getValue());
					// 拿到 我们需要的时间值， 则合理我们写一个格式化时间的类 并调用
					String date=SimpleDateUtil.simpleDateUtil(new Date(lasttime));
					result.setData(date);
					//重写设置时间值
					cookie.setValue(System.currentTimeMillis()+"");
					//设置有效时间
					cookie.setMaxAge(1*365*24*60*60);
					//设置添加
					response.addCookie(cookie);
				}
				return result;
	}
	
	@RequestMapping("/myselfInfo.do")
	public String myselfInfo(){
		return "index/myselfInfo";
	}
	
	@RequestMapping("/admin_log.do")
	public String admin_log(){
		return "index/admin-log";
	}
	
	@RequestMapping("/place_place.do")
	public String place_place(){
		return "index/place-place";
	}
	
	@RequestMapping("/place_place_add.do")
	public String place_place_add(){
		return "index/place-place-add";
	}
	@RequestMapping("/place_place_update.do")
	public String place_place_update(){
		return "index/place-place-update";
	}
	@RequestMapping("/member_add_student.do")
	public String member_add_student(){
		return "index/member-add-student";
	}
	@RequestMapping("/member_add_teacher.do")
	public String member_add_teacher(){
		return "index/member-add-teacher";
	}
	@RequestMapping("/member_student_list.do")
	public String member_student_list(){
		return "index/member-student-list";
	}
	@RequestMapping("/member_student_show.do")
	public String member_student_show(){
		return "index/member-student-show";
	}
	@RequestMapping("/member_teacher_list.do")
	public String member_teacher_list(){
		return "index/member-teacher-list";
	}
	
	@RequestMapping("/member_teacher_show.do")
	public String member_teacher_show(){
		return "index/member-teacher-show";
	}
	@RequestMapping("/member_update_student.do")
	public String member_update_student(){
		return "index/member-update-student";
		
		
	}@RequestMapping("/member_update_teacher.do")
	public String member_update_teacher(){
		return "index/member-update-teacher";
	}
	
	@RequestMapping("/place_arrange.do")
	public String place_arrange(){
		return "index/place-arrange";
	}
	@RequestMapping("/place_arrange_add.do")
	public String place_arrange_add(){
		return "index/place-arrange-add";
	}
	@RequestMapping("/place_arrange_update.do")
	public String place_arrange_update(){
		return "index/place-arrange-update";
	}
	
	@RequestMapping("/place_arrange_reason.do")
	public String place_arrange_reason(){
		return "index/place-arrange-reason";
	}
	
	@RequestMapping("/Club_activities.do")
	public String Club_activities(){
		return "index/Club-activities";
	}
	
	@RequestMapping("/Club_activities_add.do")
	public String Club_activities_add(){
		return "index/Club-activities-add";
	}
	
	@RequestMapping("/Club_activities_update.do")
	public String Club_activities_update(){
		return "index/Club-activities-update";
	}
	
	@RequestMapping("/school_activities.do")
	public String School_activities(){
		return "index/school-activities";
	}
	
	@RequestMapping("/school_activities_add.do")
	public String School_activities_add(){
		return "index/school-add-activities";
	}
	
	@RequestMapping("/school_activities_update.do")
	public String School_activities_update(){
		return "index/school-update-activities";
	}
	
	@RequestMapping("/School_reason.do")
	public String School_reason(){
		return "index/clubAndSchool-reason";
	}
	
	@RequestMapping("/club_reason.do")
	public String club_reason(){
		return "index/clubAndSchool-reason2";
	}
	@RequestMapping("/profession.do")
	public String profession(){
		return "index/profession";
	}
	
	@RequestMapping("/profession_add.do")
	public String profession_add(){
		return "index/profession-add";
	}
	
	@RequestMapping("/profession_update.do")
	public String profession_update(){
		return "index/profession-update";
	}
	
	@RequestMapping("/classInformation.do")
	public String classInformation(){
		return "index/classInformation";
	}
	
	@RequestMapping("/classInformation_add.do")
	public String classInformation_add(){
		return "index/classInformation-add";
	}
	
	@RequestMapping("/classInformation_update.do")
	public String classInformation_update(){
		return "index/classInformation-update";
	}
	
	@RequestMapping("/class_Instructor_show.do")
	public String class_Instructor_show(){
		return "index/class-Instructor-show";
	}
	
	@RequestMapping("/class_curriculum.do")
	public String class_curriculum(){
		return "index/class_curriculum";
	}
	
	@RequestMapping("/class_curriculum_add.do")
	public String class_curriculum_add(){
		return "index/class_curriculum_add";
	}
	
	@RequestMapping("/class_curriculum_update.do")
	public String class_curriculum_update(){
		return "index/class_curriculum_update";
	}
	
	@RequestMapping("/class_student_Information.do")
	public String class_student_Information(){
		return "index/class-student-Information";
	}
	
	@RequestMapping("/class_curriculum_Information.do")
	public String class_curriculum_Information(){
		return "index/class-curriculum-Information";
	}
	
	@RequestMapping("/updatepwd.do")
	public String updatepwd(){
		return "index/updatePwd";
	}
	
	@RequestMapping("/class_Schedule.do")
	public String class_Schedule(){
		return "index/class-Schedule";
	}
	
	@RequestMapping("/classSchedule_add.do")
	public String classSchedule_add(){
		return "index/class-Schedule-add";
	}
	
	@RequestMapping("/classschedule_update.do")
	public String classschedule_update(){
		return "index/class-Schedule-update";
	}
	
	@RequestMapping("/student_achievement_entry.do")
	public String student_achievement_entry(){
		return "index/student_achievement_entry";
	}
	
	@RequestMapping("/class_curriculum_look.do")
	public String class_curriculum_look(){
		return "index/class-curriculum-look";
	}
	
	@RequestMapping("/LookClassAchievement.do")
	public String LookClassAchievement(){
		return "index/class-achievement-look";
	}
}
