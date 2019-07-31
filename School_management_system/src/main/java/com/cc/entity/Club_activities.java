package com.cc.entity;

import java.util.Date;

/**
 * 社团活动类
 * @author Administrator
 *
 */
public class Club_activities {

	private int clubactivities_id;//社团活动id
	private String clubactivities_name;//社团活动名字
	private String sports_Poster;//社团活动海报
	private String clubactivities_place;//活动地点
	private int clubactivities_number;//参加人数
	private Date  clubactivities_time;//社团活动时间
	private Date clubactivities_endtime;//活动结束时间
	private String organizational_unit;//活动组织单位
	private int clubactivities_status;//预约状态  0:未预约 1:预约成功 2:预约失败 3:预约中
	
	
	
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
