package com.mashen.ssm.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.mashen.ssm.model.User;

@Repository(value="userDaoImp")
public class UserDaoImp implements IUserDao{
	
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	private String name = "com.mashen.ssm.dao.IUserDao";
	@Override
	public void add(User user) {
		SqlSession s = sqlSessionFactory.openSession();
		s.insert(name+".add",user);
	}

}
