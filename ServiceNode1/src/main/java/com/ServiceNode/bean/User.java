package com.ServiceNode.bean;

public class User {

	private Integer uid;
	private Integer mid;
	private String uname;
	private String password;
	private Integer level;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", mid=" + mid + ", uname=" + uname + ", password=" + password + ", level=" + level
				+ "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer uid, Integer mid, String uname, String password, Integer level) {
		super();
		this.uid = uid;
		this.mid = mid;
		this.uname = uname;
		this.password = password;
		this.level = level;
	}
	
	
}
