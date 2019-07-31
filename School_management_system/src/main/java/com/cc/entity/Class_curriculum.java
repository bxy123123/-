package com.cc.entity;
/**
 * 班级课程安排类
 * @author Administrator
 *
 */
public class Class_curriculum {

	private int class_curriculum_id;
	private String class_curriculum_one;//第一节
	private String class_curriculum_two;//第二节
	private String class_curriculum_three;//第三节
	private String class_curriculum_four;//第四节
	private String class_curriculum_five;//第五节
	private String class_curriculum_six;//第六节
	private String class_curriculum_classname;//班级名称
	private String class_curriculum_time;//星期
	@Override
	public String toString() {
		return "Class_curriculum [class_curriculum_id=" + class_curriculum_id + ", class_curriculum_one="
				+ class_curriculum_one + ", class_curriculum_two=" + class_curriculum_two + ", class_curriculum_three="
				+ class_curriculum_three + ", class_curriculum_four=" + class_curriculum_four
				+ ", class_curriculum_five=" + class_curriculum_five + ", class_curriculum_six=" + class_curriculum_six
				+ ", class_curriculum_classname=" + class_curriculum_classname + ", class_curriculum_time="
				+ class_curriculum_time + "]";
	}
	public int getClass_curriculum_id() {
		return class_curriculum_id;
	}
	public void setClass_curriculum_id(int class_curriculum_id) {
		this.class_curriculum_id = class_curriculum_id;
	}
	public String getClass_curriculum_one() {
		return class_curriculum_one;
	}
	public void setClass_curriculum_one(String class_curriculum_one) {
		this.class_curriculum_one = class_curriculum_one;
	}
	public String getClass_curriculum_two() {
		return class_curriculum_two;
	}
	public void setClass_curriculum_two(String class_curriculum_two) {
		this.class_curriculum_two = class_curriculum_two;
	}
	public String getClass_curriculum_three() {
		return class_curriculum_three;
	}
	public void setClass_curriculum_three(String class_curriculum_three) {
		this.class_curriculum_three = class_curriculum_three;
	}
	public String getClass_curriculum_four() {
		return class_curriculum_four;
	}
	public void setClass_curriculum_four(String class_curriculum_four) {
		this.class_curriculum_four = class_curriculum_four;
	}
	public String getClass_curriculum_five() {
		return class_curriculum_five;
	}
	public void setClass_curriculum_five(String class_curriculum_five) {
		this.class_curriculum_five = class_curriculum_five;
	}
	public String getClass_curriculum_six() {
		return class_curriculum_six;
	}
	public void setClass_curriculum_six(String class_curriculum_six) {
		this.class_curriculum_six = class_curriculum_six;
	}
	public String getClass_curriculum_classname() {
		return class_curriculum_classname;
	}
	public void setClass_curriculum_classname(String class_curriculum_classname) {
		this.class_curriculum_classname = class_curriculum_classname;
	}
	public String getClass_curriculum_time() {
		return class_curriculum_time;
	}
	public void setClass_curriculum_time(String class_curriculum_time) {
		this.class_curriculum_time = class_curriculum_time;
	}
	
	
}
