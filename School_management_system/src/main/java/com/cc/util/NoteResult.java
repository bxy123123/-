package com.cc.util;

public class NoteResult {
	public static final int SUCCESS=1;
    public static final int ERROR=0;
	private int status;//返回的状态
	private String msg;//返回的消息
	private Object data;//返回的数据
	
	public NoteResult() {
		this.status=SUCCESS;
		this.msg="ok";
	}
	public NoteResult(Object data) {
		this();
		this.data=data;
	}
	public NoteResult(Throwable e){
		this.status=ERROR;
		this.msg=e.getMessage();
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
