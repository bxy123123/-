package com.cc.service;

import com.cc.entity.School_activities;
import com.cc.util.NoteResult;

public interface SchoolActivitiesService {

	//添加校园活动
	NoteResult AddSchoolActivities(School_activities s);

	//删除校园活动
	NoteResult DeleteSchoolActivities(Integer id);

	//根据Id显示校园活动信息
	NoteResult ShowSchoolActivities(Integer id);

	//根据id修改校园活动信息
	NoteResult UpdateSchoolActivities(School_activities s);

	NoteResult schoolActivitiesStart(Integer id, Integer number);

	NoteResult schoolActivitiesStartStop(Integer id);

	NoteResult SelectReason(Integer id, Integer number);

}
