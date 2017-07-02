package com.mashen.ssm.service;

import java.util.List;

import com.mashen.ssm.model.Carousel;

public interface ICarouselService {
	public void add(Carousel carousel);
	public void update(Carousel carousel);
	public void delete(Integer id);
	public List<Carousel> getAll();
}
