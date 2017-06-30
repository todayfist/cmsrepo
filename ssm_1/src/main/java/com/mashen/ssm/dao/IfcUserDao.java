package com.mashen.ssm.dao;

import com.mashen.ssm.model.User;


public interface IfcUserDao {
	public void add(User user);
	public User login(User user);
}
