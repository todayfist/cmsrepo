package com.mashen.ssm.article.model;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Article implements Serializable{
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public int getHeadlineid() {
		return headlineid;
	}
	public void setHeadlineid(int headlineid) {
		this.headlineid = headlineid;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", categoryid=" + categoryid + ", headlineid=" + headlineid + ", viewcount="
				+ viewcount + ", headline=" + headline + ", content=" + content + ", headname=" + headname + ", thumb="
				+ thumb + ", headimg=" + headimg + ", creationtime=" + creationtime + "]";
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHeadname() {
		return headname;
	}
	public void setHeadname(String headname) {
		this.headname = headname;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	private int categoryid;
	private int headlineid;
	private int viewcount;
	private String headline;
	private String content;
	private String headname;
	private String thumb;
	private String headimg;
	public Timestamp getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(Timestamp creationtime) {
		this.creationtime = creationtime;
	}

	private Timestamp creationtime;
	

}
