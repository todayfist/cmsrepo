package com.mashen.ssm.advert.service;

import java.util.List;

import com.mashen.ssm.advert.model.Advert;

public interface IAdvertService {
	public int add(Advert advert);
	
	public int delete(int id);
	
	public int update(Advert advert);
	public List<Advert> select();

	public Advert selectbyid(int id);

}
