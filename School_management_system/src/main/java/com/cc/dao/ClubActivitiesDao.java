package com.cc.dao;


import java.util.List;

import com.cc.entity.Arrange;
import com.cc.entity.Club_activities;
import com.cc.entity.Place;

public interface ClubActivitiesDao {

	//添加社团活动
	void AddClubActivities(Club_activities c);

	//删除社团活动
	void DeleteClubActivities(Integer id);

	//根据Id查询社团活动信息
	Club_activities ShowClubActivities(Integer id);

	void clubActivitiesStart1(Integer id);

	void addArrangeReason(Club_activities c);

	void clubActivitiesStartStop(Integer id);

	void addArrangeStop(Integer id);

	List<Arrange> showArrange(Integer id);

	//修改社团活动
	void UpdateClubActivities(Club_activities c);

	//查询所有场地
	List<Place> findAllPlace();


}
