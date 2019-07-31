package com.cc.service;

import com.cc.entity.Club_activities;
import com.cc.util.NoteResult;

public interface ClubActivitiesService {

	//������Ż
	NoteResult AddClubActivities(Club_activities c);

	//ɾ�����Ż
	NoteResult DeleteClubActivities(Integer id);

	//����id��ѯ���Ż��Ϣ
	NoteResult ShowClubActivities(Integer id);

	NoteResult clubActivitiesStart(Integer id, Integer number);

	NoteResult clubActivitiesStartStop(Integer id);

	//�޸����Ż
	NoteResult UpdateClubActivities(Club_activities c);

	//��ѯ���г���
	NoteResult findAllPlace();

}
