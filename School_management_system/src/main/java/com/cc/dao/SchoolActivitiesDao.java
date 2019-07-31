package com.cc.dao;


import java.util.List;

import com.cc.entity.Arrange;
import com.cc.entity.School_activities;

public interface SchoolActivitiesDao {

	//���У԰�
	void AddSchoolActivities(School_activities s);

	//ɾ��У԰�
	void DeleteSchoolActivities(Integer id);

	//����id��ʾУ԰���Ϣ
	School_activities ShowSchoolActivities(Integer id);

	//����Id�޸�У԰���Ϣ
	void UpdateSchoolActivities(School_activities s);

	void schoolActivitiesStart(Integer id);

	void addArrangeReason(School_activities s);

	List<Arrange> showArrange(Integer id);

	void addArrangeStop(int arrange_id);

	void schoolActivitiesStartStop(Integer id);

	Arrange SelectReason(Integer id);

	Arrange SelectReason2(Integer id);

}
