package com.mashen.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mashen.ssm.model.Carousel;
import com.mashen.ssm.service.ICarouselService;

@Controller
@RequestMapping(value="/carousel")
public class CarouselAction {
	
	@Resource(name="CarouselServiceImp")
	ICarouselService carouselService;
	
	@RequestMapping("/add")
	public String add(Carousel carousel) {
		System.out.println("/carousel/add");
		carousel.setImgorder(23);
		carousel.setName("bbbbb");
		carousel.setUrl("cccccc");
		carouselService.add(carousel);
		return "carousel/adv";
	}
	
	@RequestMapping("/index")
	public String list(HttpRequest httpRequest) {
		System.out.println("/carousel/index");
		List<Carousel> carouselList = carouselService.getAll();
		return null;
		
		
	}
}
