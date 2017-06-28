package com.mashen.ssm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashen.ssm.dao.IUserDao;
import com.mashen.ssm.model.User;

@Transactional(rollbackFor=java.lang.Exception.class)
@Service(value="userServiceImp")
public class UserServiceImp implements IUserService {
	@Resource
	private IUserDao userDaoImp;
	@Override
	public void add(){
		User user = new User();
		user.setUserId(4);
		user.setUserName("admin");
		userDaoImp.add(user);
	}

	
	}
	


