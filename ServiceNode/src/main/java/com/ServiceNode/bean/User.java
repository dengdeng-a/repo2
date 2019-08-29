package com.ServiceNode.bean;

public class User {
    private Integer uid;

    private Integer mid;

    private String uname;

    private String password;

    private Integer level;

    
    
    @Override
	public String toString() {
		return "User [uid=" + uid + ", mid=" + mid + ", uname=" + uname + ", password=" + password + ", level=" + level
				+ "]";
	}

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
        this.uname = uname == null ? null : uname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}