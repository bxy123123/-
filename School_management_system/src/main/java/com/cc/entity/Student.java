package com.cc.entity;

import java.util.Date;

/**
 * ѧ����
 * @author Administrator
 *
 */
public class Student {

	private int student_id;//ѧ��id
	private String student_name;//ѧ������
	private int student_age;//ѧ������
	private String student_headimage;//ѧ��ͷ��
	private String student_phone;//ѧ���ֻ�����
	private String student_IDCard;//ѧ�����֤����
	private String student_code;//ѧ��ѧ����
	private char student_sex;//ѧ���Ա�
	private Date student_birthday;//ѧ����������
	private String student_nation;//ѧ������
	private Date student_Date_of_admission;//ѧ����ѧ����
	private String student_major;//ѧ��רҵ
	private String student_class;//ѧ���༶
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_age=" + student_age
				+ ", student_headimage=" + student_headimage + ", student_phone=" + student_phone + ", student_IDCard="
				+ student_IDCard + ", student_code=" + student_code + ", student_sex=" + student_sex
				+ ", student_birthday=" + student_birthday + ", student_nation=" + student_nation
				+ ", student_Date_of_admission=" + student_Date_of_admission + ", student_major=" + student_major
				+ ", student_class=" + student_class + "]";
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getStudent_age() {
		return student_age;
	}
	public void setStudent_age(int student_age) {
		this.student_age = student_age;
	}
	
	public String getStudent_headimage() {
		return student_headimage;
	}
	public void setStudent_headimage(String student_headimage) {
		this.student_headimage = student_headimage;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	public String getStudent_IDCard() {
		return student_IDCard;
	}
	public void setStudent_IDCard(String student_IDCard) {
		this.student_IDCard = student_IDCard;
	}
	public String getStudent_code() {
		return student_code;
	}
	public void setStudent_code(String student_code) {
		this.student_code = student_code;
	}
	public char getStudent_sex() {
		return student_sex;
	}
	public void setStudent_sex(char student_sex) {
		this.student_sex = student_sex;
	}
	public Date getStudent_birthday() {
		return student_birthday;
	}
	public void setStudent_birthday(Date student_birthday) {
		this.student_birthday = student_birthday;
	}
	public String getStudent_nation() {
		return student_nation;
	}
	public void setStudent_nation(String student_nation) {
		this.student_nation = student_nation;
	}
	public Date getStudent_Date_of_admission() {
		return student_Date_of_admission;
	}
	public void setStudent_Date_of_admission(Date student_Date_of_admission) {
		this.student_Date_of_admission = student_Date_of_admission;
	}
	public String getStudent_major() {
		return student_major;
	}
	public void setStudent_major(String student_major) {
		this.student_major = student_major;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
	
	
	
	
	
	
}
