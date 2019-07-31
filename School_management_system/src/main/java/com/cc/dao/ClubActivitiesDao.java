package com.cc.dao;


import java.util.List;

import com.cc.entity.Arrange;
import com.cc.entity.Club_activities;
import com.cc.entity.Place;

public interface ClubActivitiesDao {

	//������Ż
	void AddClubActivities(Club_activities c);

	//ɾ�����Ż
	void DeleteClubActivities(Integer id);

	//����Id��ѯ���Ż��Ϣ
	Club_activities ShowClubActivities(Integer id);

	void clubActivitiesStart1(Integer id);

	void addArrangeReason(Club_activities c);

	void clubActivitiesStartStop(Integer id);

	void addArrangeStop(Integer id);

	List<Arrange> showArrange(Integer id);

	//�޸����Ż
	void UpdateClubActivities(Club_activities c);

	//��ѯ���г���
	List<Place> findAllPlace();


}
