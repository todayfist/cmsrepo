package com.mashen.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import com.mashen.ssm.dao.ICarouselDao;
import com.mashen.ssm.model.Carousel;

public class CarouselServiceImp implements ICarouselService {
	
	@Resource(name="CarouselDaoImp")
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

	
}
