package com.cc.entity;

import java.sql.Timestamp;

/**
 * ����Ա��
 * @author Administrator
 *
 */
public class Manager {
	
	private int manager_id;//����Աid
	private String manager_name;//����Ա����
	private int manager_age;//����Ա����
	private char manager_sex;//����Ա�Ա�
	private String manager_phone;//����Ա�ֻ�����
	private String manager_role;//����Ա��ɫ
	private String manager_IDCard;//����Ա���֤
	private Timestamp manager_createtime;//����Ա����ʱ�� 
	
	


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
