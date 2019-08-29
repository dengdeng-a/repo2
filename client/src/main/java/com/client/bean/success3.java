package com.client.bean;

import java.util.List;

public class success3 {

	private String fileId;
	private String filename;
	private String size;
	private String brief;
	private String tags;
	
//	private List<String> list;
	
	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public success3() {
		super();
		// TODO Auto-generated constructor stub
	}
	public success3(String fileId, String filename, String size, String brief, String tags) {
		super();
		this.fileId = fileId;
		this.filename = filename;
		this.size = size;
		this.brief = brief;
		this.tags = tags;
	}
	
	
}
