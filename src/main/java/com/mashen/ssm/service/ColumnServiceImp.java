package com.mashen.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashen.ssm.dao.IColumnDao;
import com.mashen.ssm.model.Column;



@Transactional(rollbackFor=java.lang.Exception.class)
@Service
public class ColumnServiceImp implements IColumnService {
	@Autowired
	@Resource
	private IColumnDao columnDao;
	@Override
	public void add(String col_title) {
		
			Column col = new Column();
			col.setColumnName(col_title);
			columnDao.add(col);
	}
	
	@Override
	public void delete() {
		columnDao.delete(14);
	}
	@Override
	public void update() {
		Column col = new Column();
		col.setColumnName("佐鸣");
		col.setId(14);
		columnDao.update(col);
	}
	@Override
	public List<Column> query() {
		List columnList = columnDao.listByName(null);
		System.out.println(columnList);
		return columnList;
	}
}
