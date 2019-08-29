package com.ServiceNode.bean;

public class Type {
    private Integer tid;

    private String tname;
    
    private Integer cid;

    private Integer uid;

    private String ctitle;

    private String csrc;

    private String ctext;

    
    
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type(Integer tid, String tname, Integer cid, Integer uid, String ctitle, String csrc, String ctext) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.cid = cid;
		this.uid = uid;
		this.ctitle = ctitle;
		this.csrc = csrc;
		this.ctext = ctext;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
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

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCsrc() {
		return csrc;
	}

	public void setCsrc(String csrc) {
		this.csrc = csrc;
	}

	public String getCtext() {
		return ctext;
	}

	public void setCtext(String ctext) {
		this.ctext = ctext;
	}
    
    
   
}