package com.cc.entity;

import java.util.Date;

/**
 * ���Ż��
 * @author Administrator
 *
 */
public class Club_activities {

	private int clubactivities_id;//���Żid
	private String clubactivities_name;//���Ż����
	private String sports_Poster;//���Ż����
	private String clubactivities_place;//��ص�
	private int clubactivities_number;//�μ�����
	private Date  clubactivities_time;//���Żʱ��
	private Date clubactivities_endtime;//�����ʱ��
	private String organizational_unit;//���֯��λ
	private int clubactivities_status;//ԤԼ״̬  0:δԤԼ 1:ԤԼ�ɹ� 2:ԤԼʧ�� 3:ԤԼ��
	
	
	
	@Override
	public String toString() {
		return "Club_activities [clubactivities_id=" + clubactivities_id + ", clubactivities_name="
				+ clubactivities_name + ", sports_Poster=" + sports_Poster + ", clubactivities_place="
				+ clubactivities_place + ", clubactivities_number=" + clubactivities_number + ", clubactivities_time="
				+ clubactivities_time + ", clubactivities_endtime=" + clubactivities_endtime + ", organizational_unit="
				+ organizational_unit + ", clubactivities_status=" + clubactivities_status + "]";
	}
	public int getClubactivities_id() {
		return clubactivities_id;
	}
	public void setClubactivities_id(int clubactivities_id) {
		this.clubactivities_id = clubactivities_id;
	}
	public String getClubactivities_name() {
		return clubactivities_name;
	}
	public void setClubactivities_name(String clubactivities_name) {
		this.clubactivities_name = clubactivities_name;
	}
	public String getSports_Poster() {
		return sports_Poster;
	}
	public void setSports_Poster(String sports_Poster) {
		this.sports_Poster = sports_Poster;
	}
	public String getClubactivities_place() {
		return clubactivities_place;
	}
	public void setClubactivities_place(String clubactivities_place) {
		this.clubactivities_place = clubactivities_place;
	}
	
	public int getClubactivities_number() {
		return clubactivities_number;
	}
	public void setClubactivities_number(int clubactivities_number) {
		this.clubactivities_number = clubactivities_number;
	}
	public Date getClubactivities_time() {
		return clubactivities_time;
	}
	public void setClubactivities_time(Date clubactivities_time) {
		this.clubactivities_time = clubactivities_time;
	}
	public Date getClubactivities_endtime() {
		return clubactivities_endtime;
	}
	public void setClubactivities_endtime(Date clubactivities_endtime) {
		this.clubactivities_endtime = clubactivities_endtime;
	}
	public String getOrganizational_unit() {
		return organizational_unit;
	}
	public void setOrganizational_unit(String organizational_unit) {
		this.organizational_unit = organizational_unit;
	}
	public int getClubactivities_status() {
		return clubactivities_status;
	}
	public void setClubactivities_status(int clubactivities_status) {
		this.clubactivities_status = clubactivities_status;
	}
	
	
	
	
	
}
