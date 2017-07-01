package com.mashen.ssm.advert.model;

import java.sql.Date;

public class Advert {
	private int id;
	private String advertisings;
	private String adLinks;
	private Date creationtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdvertisings() {
		return advertisings;
	}
	public void setAdvertisings(String advertisings) {
		this.advertisings = advertisings;
	}
	public String getAdLinks() {
		return adLinks;
	}
	public void setAdLinks(String adLinks) {
		this.adLinks = adLinks;
	}
	public Date getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(Date creationtime) {
		this.creationtime = creationtime;
	}

}
