package com.cc.entity;

import java.sql.Timestamp;

/**
 * �˺���
 * @author Administrator
 *
 */
public class User {

	private int user_id;//�û�id
	private String user_name;//�û�����
	private int user_age;//�û�����
	private char user_sex;//�û��Ա�
	private String user_phone;//�û��ֻ�����
	private String user_pwd;//�û�����
	private String user_IDCard;//�û����֤����
	private String user_role;//�û�ְλ
	private int user_status;//�û��˺�״̬ 0-����  1-ͣ��
	private Timestamp user_createtime;//�û�����ʱ��
	private int role_id;//��ɫ���id 1-��Ա����Ա  2-���ع���Ա   3-רҵ����Ա   4-��֯����Ա   5-����Ա   6-�༶����Ա  7-��ʦ

	
	
	

	

	

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
