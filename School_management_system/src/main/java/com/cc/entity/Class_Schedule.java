package com.cc.entity;
/**
 * ��ʦ�����
 * @author Administrator
 *
 */
public class Class_Schedule {

	private int class_schedule_id;
	private String class_schedule_teachername;//��ʦ��
	private String class_schedule_classname;//�༶��
	private String teacher_idcard;//��ʦ���֤��
	@Override
	public String toString() {
		return "Class_Schedule [class_schedule_id=" + class_schedule_id + ", class_schedule_teachername="
				+ class_schedule_teachername + ", class_schedule_classname=" + class_schedule_classname
				+ ", teacher_idcard=" + teacher_idcard + "]";
	}
	public int getClass_schedule_id() {
		return class_schedule_id;
	}
	public void setClass_schedule_id(int class_schedule_id) {
		this.class_schedule_id = class_schedule_id;
	}
	public String getClass_schedule_teachername() {
		return class_schedule_teachername;
	}
	public void setClass_schedule_teachername(String class_schedule_teachername) {
		this.class_schedule_teachername = class_schedule_teachername;
	}
	public String getClass_schedule_classname() {
		return class_schedule_classname;
	}
	public void setClass_schedule_classname(String class_schedule_classname) {
		this.class_schedule_classname = class_schedule_classname;
	}
	public String getTeacher_idcard() {
		return teacher_idcard;
	}
	public void setTeacher_idcard(String teacher_idcard) {
		this.teacher_idcard = teacher_idcard;
	}
	
	
}
