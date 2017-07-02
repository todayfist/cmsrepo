package com.mashen.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashen.ssm.dao.ICarouselDao;
import com.mashen.ssm.model.Carousel;

@Transactional(rollbackFor=java.lang.Exception.class)
@Service
public class CarouselServiceImp implements ICarouselService {
	@Autowired
	@Resource
	ICarouselDao carouselDao;
	
	@Override
	public void add(Carousel carousel) {
		System.out.println("CarouselServiceImp.add");
		carouselDao.add(carousel);
	}

	@Override
	public List<Carousel> getAll() {
		System.out.println("CarouselServiceImp.getAll");
		List<Carousel> carouselList = carouselDao.getAll();
		return carouselList;
	}

	@Override
	public void delete(Integer id) {
		System.out.println("CarouselServiceImp.delete");
		carouselDao.delete(id);
	}

	@Override
	public void update(Carousel carousel) {
		System.out.println("CarouselServiceImp.update");
		carouselDao.update(carousel);
	}
}
