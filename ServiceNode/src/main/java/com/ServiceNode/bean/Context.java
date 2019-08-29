package com.ServiceNode.bean;

public class Context {
    private Integer cid;

    private Integer uid;

    private Integer tid;

    private String ctitle;

    private String csrc;

    private String ctext;
    


    public Context(Integer cid, Integer uid, Integer tid, String ctitle, String csrc, String ctext) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.tid = tid;
		this.ctitle = ctitle;
		this.csrc = csrc;
		this.ctext = ctext;
	}

	public Context() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle == null ? null : ctitle.trim();
    }

    public String getCsrc() {
        return csrc;
    }

    public void setCsrc(String csrc) {
        this.csrc = csrc == null ? null : csrc.trim();
    }

    public String getCtext() {
        return ctext;
    }

    public void setCtext(String ctext) {
        this.ctext = ctext == null ? null : ctext.trim();
    }
}