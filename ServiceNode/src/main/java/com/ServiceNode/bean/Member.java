package com.ServiceNode.bean;

public class Member {
    private Integer mid;

    private String mtime;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime == null ? null : mtime.trim();
    }
}