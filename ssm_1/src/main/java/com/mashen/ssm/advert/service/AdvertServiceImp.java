package com.mashen.ssm.advert.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mashen.ssm.advert.dao.IAdvertDao;
import com.mashen.ssm.advert.model.Advert;
@Service("advertServiceImp")
public class AdvertServiceImp implements IAdvertService {
	@Resource(name="advertDao")
	IAdvertDao dao;

	@Override
	public int add(Advert advert) {
		// TODO Auto-generated method stub
		return dao.add(advert);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int update(Advert advert) {
		// TODO Auto-generated method stub
		return dao.update(advert);
	}

	@Override
	public List<Advert> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public Advert selectbyid(int id) {
		// TODO Auto-generated method stub
		return dao.selectbyid(id);
	}

}
