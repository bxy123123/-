package com.cc.entity;
/**
 * רҵ��Ϣ��
 * @author Administrator
 *
 */
public class Professional {

	private int professional_id;//���
	private String professional_name;//רҵ����
	private String professional_time;//רҵʱ��
	private String professional_introduce;//רҵ����
	private double professional_tuition;//ѧ��
	private String development_direction;//��չ����
	public int getProfessional_id() {
		return professional_id;
	}
	public void setProfessional_id(int professional_id) {
		this.professional_id = professional_id;
	}
	public String getProfessional_name() {
		return professional_name;
	}
	public void setProfessional_name(String professional_name) {
		this.professional_name = professional_name;
	}
	
	public String getProfessional_time() {
		return professional_time;
	}
	public void setProfessional_time(String professional_time) {
		this.professional_time = professional_time;
	}
	public String getProfessional_introduce() {
		return professional_introduce;
	}
	public void setProfessional_introduce(String professional_introduce) {
		this.professional_introduce = professional_introduce;
	}
	public double getProfessional_tuition() {
		return professional_tuition;
	}
	public void setProfessional_tuition(double professional_tuition) {
		this.professional_tuition = professional_tuition;
	}
	public String getDevelopment_direction() {
		return development_direction;
	}
	public void setDevelopment_direction(String development_direction) {
		this.development_direction = development_direction;
	}
	@Override
	public String toString() {
		return "Professional [professional_id=" + professional_id + ", professional_name=" + professional_name
				+ ", professional_time=" + professional_time + ", professional_introduce=" + professional_introduce
				+ ", professional_tuition=" + professional_tuition + ", development_direction=" + development_direction
				+ "]";
	}
	
	
	
	
}
