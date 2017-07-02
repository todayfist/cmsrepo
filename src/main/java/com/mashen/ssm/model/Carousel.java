package com.mashen.ssm.model;

public class Carousel {
	private int id;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Carousel [id=" + id + ", name=" + name + ", url=" + url + ", imgorder=" + imgorder + ", description="
				+ description + "]";
	}
	private String name;
	private String url;
	private int imgorder;
	private String description;
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the imgorder
	 */
	public int getImgorder() {
		return imgorder;
	}
	/**
	 * @param imgorder the imgorder to set
	 */
	public void setImgorder(int imgorder) {
		this.imgorder = imgorder;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
