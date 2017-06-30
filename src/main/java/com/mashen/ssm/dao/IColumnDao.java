package com.mashen.ssm.dao;

import java.util.List;

import com.mashen.ssm.model.Column;

public interface IColumnDao {
	public void add(Column column);
	public void delete(Integer id);
	public void update(Column column);
	public List<Column> listByName(String name);
}
