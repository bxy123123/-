package com.cc.entity;
/**
 * 场地安排类
 * @author Administrator
 *
 */
public class Arrange {
	private int arrange_id;
	private String arrange_company;
	private String arrange_place;
	private String arrange_content;
	private int arrange_people;
	private String arrange_usetime;
	private String arrange_stoptime;
	private String arrange_reason;
	private int arrange_statr;//0 未审核 1 审核通过  2 未通过审核  4 已取消预约
	private int clubAndSchoolActivities_id;//社团活动和校方活动id
	private int clubAndSchoolstatus;//社团活动和校方活动区别状态码   1 社团活动  2 校方活动
	
	
	@Override
	public String toString() {
		return "Arrange [arrange_id=" + arrange_id + ", arrange_company=" + arrange_company + ", arrange_place="
				+ arrange_place + ", arrange_content=" + arrange_content + ", arrange_people=" + arrange_people
				+ ", arrange_usetime=" + arrange_usetime + ", arrange_stoptime=" + arrange_stoptime
				+ ", arrange_reason=" + arrange_reason + ", arrange_statr=" + arrange_statr
				+ ", clubAndSchoolActivities_id=" + clubAndSchoolActivities_id + ", clubAndSchoolstatus="
				+ clubAndSchoolstatus + "]";
	}
	public int getClubAndSchoolActivities_id() {
		return clubAndSchoolActivities_id;
	}
	public void setClubAndSchoolActivities_id(int clubAndSchoolActivities_id) {
		this.clubAndSchoolActivities_id = clubAndSchoolActivities_id;
	}
	public int getClubAndSchoolstatus() {
		return clubAndSchoolstatus;
	}
	public void setClubAndSchoolstatus(int clubAndSchoolstatus) {
		this.clubAndSchoolstatus = clubAndSchoolstatus;
	}
	public String getArrange_reason() {
		return arrange_reason;
	}
	public void setArrange_reason(String arrange_reason) {
		this.arrange_reason = arrange_reason;
	}
	public int getArrange_statr() {
		return arrange_statr;
	}
	public void setArrange_statr(int arrange_statr) {
		this.arrange_statr = arrange_statr;
	}
	public String getArrange_content() {
		return arrange_content;
	}
	public void setArrange_content(String arrange_content) {
		this.arrange_content = arrange_content;
	}
	public int getArrange_id() {
		return arrange_id;
	}
	public void setArrange_id(int arrange_id) {
		this.arrange_id = arrange_id;
	}
	public String getArrange_company() {
		return arrange_company;
	}
	public void setArrange_company(String arrange_company) {
		this.arrange_company = arrange_company;
	}
	public String getArrange_place() {
		return arrange_place;
	}
	public void setArrange_place(String arrange_place) {
		this.arrange_place = arrange_place;
	}
	public int getArrange_people() {
		return arrange_people;
	}
	public void setArrange_people(int arrange_people) {
		this.arrange_people = arrange_people;
	}
	public String getArrange_usetime() {
		return arrange_usetime;
	}
	public void setArrange_usetime(String arrange_usetime) {
		this.arrange_usetime = arrange_usetime;
	}
	public String getArrange_stoptime() {
		return arrange_stoptime;
	}
	public void setArrange_stoptime(String arrange_stoptime) {
		this.arrange_stoptime = arrange_stoptime;
	}
	
}
