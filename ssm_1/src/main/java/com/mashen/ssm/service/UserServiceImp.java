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
	private IUserDao userDao;
	@Override
	public void add(){
		User user = new User();
		userDao.add(user);
	}
	
	@Override
	public Boolean login(String account, String password){
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		User result = userDao.login(user);
		if(result==null)
			return false;
		else
			return true;
	}

	
	}
	


