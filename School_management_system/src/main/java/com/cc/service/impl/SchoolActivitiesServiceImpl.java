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
	 * ���У԰�
	 */
	public NoteResult AddSchoolActivities(School_activities s) {
		sd.AddSchoolActivities(s);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	/**
	 * ɾ��У԰�
	 */
	public NoteResult DeleteSchoolActivities(Integer id) {
		sd.DeleteSchoolActivities(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	/**
	 * ����id��ʾУ԰���Ϣ
	 */
	public NoteResult ShowSchoolActivities(Integer id) {
		School_activities s=sd.ShowSchoolActivities(id);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		result.setData(s);
		return result;
	}
	/**
	 * ��ѯԤԼʧ��ԭ��
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
	 * ����id�޸�У԰���Ϣ
	 */
	public NoteResult UpdateSchoolActivities(School_activities s) {
		sd.UpdateSchoolActivities(s);
		NoteResult result=new NoteResult();
		result.setStatus(0);
		return result;
	}
	/**
	 *�޸�ԤԼ״̬
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
			result.setMsg("ԤԼ�����,�޷�ȡ��ԤԼ");
		}
		return result;
	}

}
