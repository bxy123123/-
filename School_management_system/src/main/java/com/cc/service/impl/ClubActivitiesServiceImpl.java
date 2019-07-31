package com.cc.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cc.dao.ClubActivitiesDao;
import com.cc.entity.Arrange;
import com.cc.entity.Club_activities;
import com.cc.entity.Place;
import com.cc.service.ClubActivitiesService;
import com.cc.util.NoteResult;

@Service
public class ClubActivitiesServiceImpl implements ClubActivitiesService {

	@Resource
	private ClubActivitiesDao cd;
	
	
	/**
	 * ������Ż
	 */
	public NoteResult AddClubActivities(Club_activities c) {
		cd.AddClubActivities(c);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	//ɾ�����Ż
	public NoteResult DeleteClubActivities(Integer id) {
		cd.DeleteClubActivities(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	/**
	 * ����id��ѯ���Ż��Ϣ
	 */
	public NoteResult ShowClubActivities(Integer id) {
		Club_activities c=cd.ShowClubActivities(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setData(c);
		return result;
	}


	public NoteResult clubActivitiesStart(Integer id, Integer number) {
		if (number == 3) {
			cd.clubActivitiesStart1(id);
			Club_activities c = cd.ShowClubActivities(id);
			cd.addArrangeReason(c);
		}
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	public NoteResult clubActivitiesStartStop(Integer id) {
		NoteResult result=new NoteResult();
			Club_activities c = cd.ShowClubActivities(id);
			if(c.getClubactivities_status() == 3){
				cd.clubActivitiesStartStop(id);
				List<Arrange> list = cd.showArrange(id);
				for (Arrange arrange : list) {
					if(arrange.getArrange_statr() == 0){
						cd.addArrangeStop(arrange.getArrange_id());
						System.out.println(arrange.getArrange_id());
					}
				}
				result.setStatus(0);
			}else{
				result.setStatus(1);
				result.setMsg("ԤԼ�����,�޷�ȡ��ԤԼ");
			}
			return result;
	}

/**
 * �޸����Ż
 */
	public NoteResult UpdateClubActivities(Club_activities c) {
		cd.UpdateClubActivities(c);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}


	/**
	 * ��ѯ���г���
	 */
public NoteResult findAllPlace() {
	List<Place> list=cd.findAllPlace();
	NoteResult result=new NoteResult();
	result.setData(list);
	result.setStatus(0);
	return result;
}
}