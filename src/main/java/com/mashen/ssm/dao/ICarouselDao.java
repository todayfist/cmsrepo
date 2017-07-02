package com.mashen.ssm.dao;

import java.util.List;

import com.mashen.ssm.model.Carousel;

public interface ICarouselDao {
	public void update(Carousel carousel);
	public void delete(Integer id);
	public void add(Carousel carousel);
	public List<Carousel> getAll();
}
