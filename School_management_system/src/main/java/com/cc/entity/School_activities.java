package com.cc.entity;

import java.util.Date;
/**
 * У԰���
 * @author Administrator
 *
 */

public class School_activities {

	private int school_activities_id;//�id
	private String school_activities_name;//�����
	private String school_activities_organizer;//���췽
	private String school_activities_participants;//�μӷ�
	private String school_activities_place;//��ص�
	private int school_activities_number;//�μ�����
	private Date school_activities_starttime;//�ʱ��
	private Date school_activities_endtime;//����ʱ��
	private int school_activities_status;//ԤԼ״̬  0:δԤԼ 1:ԤԼ�ɹ� 2:ԤԼʧ�� 3:ԤԼ��
	
	
	@Override
	public String toString() {
		return "School_activities [school_activities_id=" + school_activities_id + ", school_activities_name="
				+ school_activities_name + ", school_activities_organizer=" + school_activities_organizer
				+ ", school_activities_participants=" + school_activities_participants + ", school_activities_place="
				+ school_activities_place + ", school_activities_number=" + school_activities_number
				+ ", school_activities_starttime=" + school_activities_starttime + ", school_activities_endtime="
				+ school_activities_endtime + ", school_activities_status=" + school_activities_status + "]";
	}
	public int getSchool_activities_id() {
		return school_activities_id;
	}
	public void setSchool_activities_id(int school_activities_id) {
		this.school_activities_id = school_activities_id;
	}
	public String getSchool_activities_name() {
		return school_activities_name;
	}
	public void setSchool_activities_name(String school_activities_name) {
		this.school_activities_name = school_activities_name;
	}
	public String getSchool_activities_organizer() {
		return school_activities_organizer;
	}
	public void setSchool_activities_organizer(String school_activities_organizer) {
		this.school_activities_organizer = school_activities_organizer;
	}
	public String getSchool_activities_participants() {
		return school_activities_participants;
	}
	public void setSchool_activities_participants(String school_activities_participants) {
		this.school_activities_participants = school_activities_participants;
	}
	public String getSchool_activities_place() {
		return school_activities_place;
	}
	public void setSchool_activities_place(String school_activities_place) {
		this.school_activities_place = school_activities_place;
	}
	
	public int getSchool_activities_number() {
		return school_activities_number;
	}
	public void setSchool_activities_number(int school_activities_number) {
		this.school_activities_number = school_activities_number;
	}
	public Date getSchool_activities_starttime() {
		return school_activities_starttime;
	}
	public void setSchool_activities_starttime(Date school_activities_starttime) {
		this.school_activities_starttime = school_activities_starttime;
	}
	public Date getSchool_activities_endtime() {
		return school_activities_endtime;
	}
	public void setSchool_activities_endtime(Date school_activities_endtime) {
		this.school_activities_endtime = school_activities_endtime;
	}
	public int getSchool_activities_status() {
		return school_activities_status;
	}
	public void setSchool_activities_status(int school_activities_status) {
		this.school_activities_status = school_activities_status;
	}
	
	
}
