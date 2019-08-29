package com.client.bean;

public class fasle1 {

	private String errorCode;
	private String msg;
	private String detail;
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public fasle1(String errorCode, String msg, String detail) {
		super();
		this.errorCode = errorCode;
		this.msg = msg;
		this.detail = detail;
	}
	public fasle1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
