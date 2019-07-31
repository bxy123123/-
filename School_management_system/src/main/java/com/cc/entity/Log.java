package com.cc.entity;

public class Log {

	public int log_id;
	public String log_name;
	private String log_role;
	private String log_function;
	private String log_creationtime;
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public String getLog_name() {
		return log_name;
	}
	public void setLog_name(String log_name) {
		this.log_name = log_name;
	}
	public String getLog_role() {
		return log_role;
	}
	public void setLog_role(String log_role) {
		this.log_role = log_role;
	}
	public String getLog_function() {
		return log_function;
	}
	public void setLog_function(String log_function) {
		this.log_function = log_function;
	}
	public String getLog_creationtime() {
		return log_creationtime;
	}
	public void setLog_creationtime(String log_creationtime) {
		this.log_creationtime = log_creationtime;
	}
	@Override
	public String toString() {
		return "Log [log_id=" + log_id + ", log_name=" + log_name + ", log_role=" + log_role + ", log_function="
				+ log_function + ", log_creationtime=" + log_creationtime + "]";
	}
	
	
	
}
