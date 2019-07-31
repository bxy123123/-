package com.cc.entity;

/**
 * 学生成绩类
 * @author Administrator
 *
 */
public class Student_achievement {

	private int student_achievement_id;
	private String student_name;//学生姓名
	private String student_code;//学生学籍号
	private String student_profession;//学生专业
	private String student_class;//学生班级
	private double student_midterm_achievement;//学生期中成绩
	private double student_final_achievement;//学生期末成绩
	private double student_total_achievement;//学生总评成绩
	private String student_semester;//学期
	@Override
	public String toString() {
		return "Student_achievement [student_achievement_id=" + student_achievement_id + ", student_name="
				+ student_name + ", student_code=" + student_code + ", student_profession=" + student_profession
				+ ", student_class=" + student_class + ", student_midterm_achievement=" + student_midterm_achievement
				+ ", student_final_achievement=" + student_final_achievement + ", student_total_achievement="
				+ student_total_achievement + ", student_semester=" + student_semester + "]";
	}
	public int getStudent_achievement_id() {
		return student_achievement_id;
	}
	public void setStudent_achievement_id(int student_achievement_id) {
		this.student_achievement_id = student_achievement_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_code() {
		return student_code;
	}
	public void setStudent_code(String student_code) {
		this.student_code = student_code;
	}
	public String getStudent_profession() {
		return student_profession;
	}
	public void setStudent_profession(String student_profession) {
		this.student_profession = student_profession;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
	public double getStudent_midterm_achievement() {
		return student_midterm_achievement;
	}
	public void setStudent_midterm_achievement(double student_midterm_achievement) {
		this.student_midterm_achievement = student_midterm_achievement;
	}
	public double getStudent_final_achievement() {
		return student_final_achievement;
	}
	public void setStudent_final_achievement(double student_final_achievement) {
		this.student_final_achievement = student_final_achievement;
	}
	public double getStudent_total_achievement() {
		return student_total_achievement;
	}
	public void setStudent_total_achievement(double student_total_achievement) {
		this.student_total_achievement = student_total_achievement;
	}
	public String getStudent_semester() {
		return student_semester;
	}
	public void setStudent_semester(String student_semester) {
		this.student_semester = student_semester;
	}
	
	
	
	
}
