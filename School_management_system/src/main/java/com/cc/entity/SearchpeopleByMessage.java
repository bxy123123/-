package com.cc.entity;

import java.util.Date;

/**
 * �����������Ϣ��ѯѧ����Ϣ��
 * @author Administrator
 *
 */
public class SearchpeopleByMessage {

	private Date datemin;//��ʼ����
	private Date datemax;//��ֹ����
	private String message;//�����ϸ��
	private String currentPage;//��ǰҳ��
	
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
