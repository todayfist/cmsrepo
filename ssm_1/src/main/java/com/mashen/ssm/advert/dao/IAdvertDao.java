package com.mashen.ssm.advert.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mashen.ssm.advert.model.Advert;
@Repository("advertDao")
public interface IAdvertDao {
	public int add(Advert advert);
	
	public int delete(int id);
	
	public int update(Advert advert);
	public List<Advert> select();

	public Advert selectbyid(int id);
}
