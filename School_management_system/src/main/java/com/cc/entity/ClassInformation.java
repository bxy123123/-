package com.cc.entity;
/**
 * �༶��Ϣ��
 * @author Administrator
 *
 */
public class ClassInformation {

	private int class_id;
	private String class_name;//�༶����
	private String class_Instructor;//����Ա
	private int class_number;//�༶����
	private String instructor_IDCard;//����Ա���֤��
	
	
	
	@Override
	public String toString() {
		return "ClassInformation [class_id=" + class_id + ", class_name=" + class_name + ", class_Instructor="
				+ class_Instructor + ", class_number=" + class_number + ", instructor_IDCard=" + instructor_IDCard
				+ "]";
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getClass_Instructor() {
		return class_Instructor;
	}
	public void setClass_Instructor(String class_Instructor) {
		this.class_Instructor = class_Instructor;
	}
	public int getClass_number() {
		return class_number;
	}
	public void setClass_number(int class_number) {
		this.class_number = class_number;
	}
	public String getInstructor_IDCard() {
		return instructor_IDCard;
	}
	public void setInstructor_IDCard(String instructor_IDCard) {
		this.instructor_IDCard = instructor_IDCard;
	}
	
	
	
	
}
