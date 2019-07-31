package com.cc.dao;


import java.util.List;

import com.cc.entity.Arrange;
import com.cc.entity.School_activities;

public interface SchoolActivitiesDao {

	//添加校园活动
	void AddSchoolActivities(School_activities s);

	//删除校园活动
	void DeleteSchoolActivities(Integer id);

	//根据id显示校园活动信息
	School_activities ShowSchoolActivities(Integer id);

	//根据Id修改校园活动信息
	void UpdateSchoolActivities(School_activities s);

	void schoolActivitiesStart(Integer id);

	void addArrangeReason(School_activities s);

	List<Arrange> showArrange(Integer id);

	void addArrangeStop(int arrange_id);

	void schoolActivitiesStartStop(Integer id);

	Arrange SelectReason(Integer id);

	Arrange SelectReason2(Integer id);

}
