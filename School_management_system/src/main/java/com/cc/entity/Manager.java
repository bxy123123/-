package com.cc.entity;

import java.sql.Timestamp;

/**
 * 管理员类
 * @author Administrator
 *
 */
public class Manager {
	
	private int manager_id;//管理员id
	private String manager_name;//管理员名字
	private int manager_age;//管理员年龄
	private char manager_sex;//管理员性别
	private String manager_phone;//管理员手机号码
	private String manager_role;//管理员角色
	private String manager_IDCard;//管理员身份证
	private Timestamp manager_createtime;//管理员创建时间 
	
	


	@Override
	public String toString() {
		return "Manager [manager_id=" + manager_id + ", manager_name=" + manager_name + ", manager_age=" + manager_age
				+ ", manager_sex=" + manager_sex + ", manager_phone=" + manager_phone + ", manager_role=" + manager_role
				+ ", manager_IDCard=" + manager_IDCard + ", manager_createtime=" + manager_createtime + "]";
	}

	public String getManager_IDCard() {
		return manager_IDCard;
	}

	public void setManager_IDCard(String manager_IDCard) {
		this.manager_IDCard = manager_IDCard;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public int getManager_age() {
		return manager_age;
	}

	public void setManager_age(int manager_age) {
		this.manager_age = manager_age;
	}

	public char getManager_sex() {
		return manager_sex;
	}

	public void setManager_sex(char manager_sex) {
		this.manager_sex = manager_sex;
	}

	public String getManager_phone() {
		return manager_phone;
	}

	public void setManager_phone(String manager_phone) {
		this.manager_phone = manager_phone;
	}

	public String getManager_role() {
		return manager_role;
	}

	public void setManager_role(String manager_role) {
		this.manager_role = manager_role;
	}

	public Timestamp getManager_createtime() {
		return manager_createtime;
	}

	public void setManager_createtime(Timestamp manager_createtime) {
		this.manager_createtime = manager_createtime;
	}

	
	

	
}
