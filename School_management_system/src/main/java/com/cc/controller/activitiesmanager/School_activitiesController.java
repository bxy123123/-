package com.cc.controller.activitiesmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.entity.School_activities;
import com.cc.service.SchoolActivitiesService;
import com.cc.util.NoteResult;

@Controller
public class School_activitiesController {                  

	@Resource
	private SchoolActivitiesService ss;
	
	/**
	 * 添加校园活动
	 * @param school_activities_name
	 * @param school_activities_place
	 * @param school_activities_organizer
	 * @param school_activities_participants
	 * @param school_activities_number
	 * @param school_activities_starttime
	 * @param school_activities_endtime
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/AddSchoolActivities.do")
	@ResponseBody
	public NoteResult AddSchoolActivities(String school_activities_name,String school_activities_place,
										 String school_activities_organizer,String school_activities_participants,
										 Integer school_activities_number,String school_activities_starttime,
										 String school_activities_endtime) throws ParseException{
		String format="yyyy-MM-dd";
		Date date_starttime=new SimpleDateFormat(format).parse(school_activities_starttime);
		Date date_of_endtime=new SimpleDateFormat(format).parse(school_activities_endtime);
		School_activities s=new School_activities();
		s.setSchool_activities_endtime(date_of_endtime);
		s.setSchool_activities_name(school_activities_name);
		s.setSchool_activities_number(school_activities_number);
		s.setSchool_activities_organizer(school_activities_organizer);
		s.setSchool_activities_participants(school_activities_participants);
		s.setSchool_activities_place(school_activities_place);
		s.setSchool_activities_starttime(date_starttime);
		s.setSchool_activities_status(0);
		
		NoteResult result=ss.AddSchoolActivities(s);
		return result;
		
	}
	
	/**
	 * 删除校园活动
	 * @param id
	 * @return
	 */
	@RequestMapping("/DeleteSchoolActivities.do")
	@ResponseBody
	public NoteResult DeleteSchoolActivities(Integer id){
		NoteResult result=ss.DeleteSchoolActivities(id);
		return result;
	}
	
	/**
	 * 根据id显示校园活动信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/ShowSchoolActivities.do")
	@ResponseBody
	public NoteResult ShowSchoolActivities(Integer id){
		NoteResult result=ss.ShowSchoolActivities(id);
		return result;
	}
	/**
	 * 修改校园活动
	 * @param school_activities_id
	 * @param school_activities_name
	 * @param school_activities_place
	 * @param school_activities_organizer
	 * @param school_activities_participants
	 * @param school_activities_number
	 * @param school_activities_starttime
	 * @param school_activities_endtime
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/UpdateSchoolActivities.do")
	@ResponseBody
	public NoteResult UpdateSchoolActivities(Integer school_activities_id,String school_activities_name,String school_activities_place,
			 String school_activities_organizer,String school_activities_participants,
			 Integer school_activities_number,String school_activities_starttime,
			 String school_activities_endtime) throws ParseException{
		
		String format="yyyy-MM-dd";
		Date date_starttime=new SimpleDateFormat(format).parse(school_activities_starttime);
		Date date_of_endtime=new SimpleDateFormat(format).parse(school_activities_endtime);
		School_activities s=new School_activities();
		s.setSchool_activities_id(school_activities_id);
		s.setSchool_activities_endtime(date_of_endtime);
		s.setSchool_activities_name(school_activities_name);
		s.setSchool_activities_number(school_activities_number);
		s.setSchool_activities_organizer(school_activities_organizer);
		s.setSchool_activities_participants(school_activities_participants);
		s.setSchool_activities_place(school_activities_place);
		s.setSchool_activities_starttime(date_starttime);
		
		NoteResult result=ss.UpdateSchoolActivities(s);
		return result;
		
	}
	
	
	/**
	 * 修改预约状态
	 * @param id
	 * @return
	 */
	@RequestMapping("/schoolActivitiesStart.do")
	@ResponseBody
	public NoteResult schoolActivitiesStart(Integer id,Integer number){
		NoteResult result=ss.schoolActivitiesStart(id,number);
		return result;
	}
	
	/**
	 * 修改预约状态
	 * @param id
	 * @return
	 */
	@RequestMapping("/schoolActivitiesStartStop.do")
	@ResponseBody
	public NoteResult schoolActivitiesStartStop(Integer id){
		NoteResult result=ss.schoolActivitiesStartStop(id);
		return result;
	}
	
	/**
	 * 查询失败原因
	 * @param id
	 * @return
	 */
	@RequestMapping("/SelectReason.do")
	@ResponseBody
	public NoteResult SelectReason(Integer id,Integer number){
		NoteResult result=ss.SelectReason(id,number);
		return result;
	}
}
