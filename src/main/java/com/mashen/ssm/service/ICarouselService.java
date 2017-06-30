package com.mashen.ssm.service;

import java.util.List;

import com.mashen.ssm.model.Carousel;

public interface ICarouselService {
	public void add(Carousel carousel);
	public List<Carousel> getAll();
}
