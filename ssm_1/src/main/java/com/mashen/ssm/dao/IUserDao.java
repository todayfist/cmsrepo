package com.mashen.ssm.dao;

import com.mashen.ssm.model.User;


public interface IUserDao {
	public void add(User user);
	public User login(User user);
}
