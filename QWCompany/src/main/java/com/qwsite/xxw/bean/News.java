package com.qwsite.xxw.bean;

public class News {
    private Integer nid;

    private String title;

    private String context;

    private String createtime;

    private String htmltext;

    private String sources;

    @Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", context=" + context + ", createtime=" + createtime
				+ ", htmltext=" + htmltext + ", sources=" + sources + "]";
	}

	public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getHtmltext() {
        return htmltext;
    }

    public void setHtmltext(String htmltext) {
        this.htmltext = htmltext == null ? null : htmltext.trim();
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources == null ? null : sources.trim();
    }
}