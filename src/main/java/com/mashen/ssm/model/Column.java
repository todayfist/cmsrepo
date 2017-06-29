package com.mashen.ssm.model;

import java.sql.Timestamp;

public class Column {
	private Integer id;
	private String columnName;
	private Timestamp creationtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Timestamp getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(Timestamp creationtime) {
		this.creationtime = creationtime;
	}
	
	
	
}
