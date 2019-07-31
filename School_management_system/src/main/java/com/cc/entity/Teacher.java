package com.cc.entity;

import java.util.Date;

/**
 * 教师类
 * @author Administrator
 *
 */
public class Teacher {
 
	private int teacher_id;//老师id
	private String teacher_name;//老师姓名
	private int teacher_age;//老师年龄
	private String teacher_headimage;//教师头像
	private String teacher_phone;//老师手机号码
	private String teacher_IDCard;//老师身份证号
	private char teacher_sex;//老师性别
	private String teacher_address;//老师住址
	private String teacher_role;//老师角色(辅导员或教师)
	private String teacher_profession;//老师专业
	private Date teacher_dutytime;//教师上岗日期
	

	

	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + ", teacher_age=" + teacher_age
				+ ", teacher_headimage=" + teacher_headimage + ", teacher_phone=" + teacher_phone + ", teacher_IDCard="
				+ teacher_IDCard + ", teacher_sex=" + teacher_sex + ", teacher_address=" + teacher_address
				+ ", teacher_role=" + teacher_role + ", teacher_profession=" + teacher_profession
				+ ", teacher_dutytime=" + teacher_dutytime + "]";
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public int getTeacher_age() {
		return teacher_age;
	}

	public void setTeacher_age(int teacher_age) {
		this.teacher_age = teacher_age;
	}

	public String getTeacher_headimage() {
		return teacher_headimage;
	}

	public void setTeacher_headimage(String teacher_headimage) {
		this.teacher_headimage = teacher_headimage;
	}

	public String getTeacher_phone() {
		return teacher_phone;
	}

	public void setTeacher_phone(String teacher_phone) {
		this.teacher_phone = teacher_phone;
	}

	public String getTeacher_IDCard() {
		return teacher_IDCard;
	}

	public void setTeacher_IDCard(String teacher_IDCard) {
		this.teacher_IDCard = teacher_IDCard;
	}

	public char getTeacher_sex() {
		return teacher_sex;
	}

	public void setTeacher_sex(char teacher_sex) {
		this.teacher_sex = teacher_sex;
	}

	public String getTeacher_address() {
		return teacher_address;
	}

	public void setTeacher_address(String teacher_address) {
		this.teacher_address = teacher_address;
	}

	public String getTeacher_role() {
		return teacher_role;
	}

	public void setTeacher_role(String teacher_role) {
		this.teacher_role = teacher_role;
	}

	public String getTeacher_profession() {
		return teacher_profession;
	}

	public void setTeacher_profession(String teacher_profession) {
		this.teacher_profession = teacher_profession;
	}

	public Date getTeacher_dutytime() {
		return teacher_dutytime;
	}

	public void setTeacher_dutytime(Date teacher_dutytime) {
		this.teacher_dutytime = teacher_dutytime;
	}
	
	
	
	
}
