package com.mashen.ssm.service;

import java.util.List;

import com.mashen.ssm.model.Column;

public interface IColumnService {
	public void add(String col_title);
	public void delete();
	public void update();
	public List<Column> query();
}
