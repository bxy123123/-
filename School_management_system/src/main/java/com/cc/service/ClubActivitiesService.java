package com.cc.service;

import com.cc.entity.Club_activities;
import com.cc.util.NoteResult;

public interface ClubActivitiesService {

	//添加社团活动
	NoteResult AddClubActivities(Club_activities c);

	//删除社团活动
	NoteResult DeleteClubActivities(Integer id);

	//根据id查询社团活动信息
	NoteResult ShowClubActivities(Integer id);

	NoteResult clubActivitiesStart(Integer id, Integer number);

	NoteResult clubActivitiesStartStop(Integer id);

	//修改社团活动
	NoteResult UpdateClubActivities(Club_activities c);

	//查询所有场地
	NoteResult findAllPlace();

}
