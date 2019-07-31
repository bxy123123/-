package com.cc.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cc.dao.SchoolActivitiesDao;
import com.cc.entity.Arrange;
import com.cc.entity.School_activities;
import com.cc.service.SchoolActivitiesService;
import com.cc.util.NoteResult;

@Service
public class SchoolActivitiesServiceImpl implements SchoolActivitiesService {

	@Resource
	private SchoolActivitiesDao sd;
	/**
	 * 添加校园活动
	 */
	public NoteResult AddSchoolActivities(School_activities s) {
		sd.AddSchoolActivities(s);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	/**
	 * 删除校园活动
	 */
	public NoteResult DeleteSchoolActivities(Integer id) {
		sd.DeleteSchoolActivities(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	/**
	 * 根据id显示校园活动信息
	 */
	public NoteResult ShowSchoolActivities(Integer id) {
		School_activities s=sd.ShowSchoolActivities(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setData(s);
		return result;
	}
	/**
	 * 查询预约失败原因
	 */
	public NoteResult SelectReason(Integer id,Integer number) {
		NoteResult result=new NoteResult();
		if(number == 1){
			Arrange s=sd.SelectReason(id);
			result.setStatus(0);
			result.setData(s);
		}else if(number == 2){
			Arrange s=sd.SelectReason2(id);
			result.setStatus(0);
			result.setData(s);
		}
		
		return result;
	}
	
	/**
	 * 根据id修改校园活动信息
	 */
	public NoteResult UpdateSchoolActivities(School_activities s) {
		sd.UpdateSchoolActivities(s);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	/**
	 *修改预约状态
	 */
	public NoteResult schoolActivitiesStart(Integer id,Integer number) {
		sd.schoolActivitiesStart(id);
		School_activities s = sd.ShowSchoolActivities(id);
		sd.addArrangeReason(s);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	
	public NoteResult schoolActivitiesStartStop(Integer id) {
		NoteResult result=new NoteResult();
		School_activities s = sd.ShowSchoolActivities(id);
		if(s.getSchool_activities_status() == 3){
			sd.schoolActivitiesStartStop(id);
			List<Arrange> list = sd.showArrange(id);
			for (Arrange arrange : list) {
				if(arrange.getArrange_statr() == 0){
					sd.addArrangeStop(arrange.getArrange_id());
				}
			}
			result.setStatus(0);
		}else{
			result.setStatus(1);
			result.setMsg("预约已审核,无法取消预约");
		}
		return result;
	}

}
