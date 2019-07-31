package com.cc.entity;

import java.sql.Timestamp;

/**
 * 账号类
 * @author Administrator
 *
 */
public class User {

	private int user_id;//用户id
	private String user_name;//用户名字
	private int user_age;//用户年龄
	private char user_sex;//用户性别
	private String user_phone;//用户手机号码
	private String user_pwd;//用户密码
	private String user_IDCard;//用户身份证号码
	private String user_role;//用户职位
	private int user_status;//用户账号状态 0-正常  1-停用
	private Timestamp user_createtime;//用户创建时间
	private int role_id;//角色身份id 1-人员管理员  2-场地管理员   3-专业管理员   4-组织管理员   5-辅导员   6-班级管理员  7-教师

	
	
	

	

	

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_age=" + user_age + ", user_sex="
				+ user_sex + ", user_phone=" + user_phone + ", user_pwd=" + user_pwd + ", user_IDCard=" + user_IDCard
				+ ", user_role=" + user_role + ", user_status=" + user_status + ", user_createtime=" + user_createtime
				+ ", role_id=" + role_id + "]";
	}

	public int getUser_status() {
		return user_status;
	}

	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	public char getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(char user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_IDCard() {
		return user_IDCard;
	}

	public void setUser_IDCard(String user_IDCard) {
		this.user_IDCard = user_IDCard;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public Timestamp getUser_createtime() {
		return user_createtime;
	}

	public void setUser_createtime(Timestamp user_createtime) {
		this.user_createtime = user_createtime;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	
	
	
}
