package com.mashen.ssm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.mashen.ssm.model.Carousel;

@Repository(value="CarouselDaoImp")
public class CarouselDaoImp implements ICarouselDao {

	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	private String name = "com.mashen.ssm.dao.ICarouselDao";
	
	@Override
	public void add(Carousel carousel) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert(name + ".add", carousel);
	}

	@Override
	public List<Carousel> getAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList(name + ".getAll", null);
	}

}
