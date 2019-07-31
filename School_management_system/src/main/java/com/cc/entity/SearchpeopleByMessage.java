package com.cc.entity;

import java.util.Date;

/**
 * 根据输入的信息查询学生信息类
 * @author Administrator
 *
 */
public class SearchpeopleByMessage {

	private Date datemin;//起始日期
	private Date datemax;//终止日起
	private String message;//输入的细腻
	private String currentPage;//当前页数
	
	public Date getDatemin() {
		return datemin;
	}
	public void setDatemin(Date datemin) {
		this.datemin = datemin;
	}
	public Date getDatemax() {
		return datemax;
	}
	public void setDatemax(Date datemax) {
		this.datemax = datemax;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
