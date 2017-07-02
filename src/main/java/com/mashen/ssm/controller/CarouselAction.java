package com.mashen.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;

import com.mashen.ssm.model.Carousel;
import com.mashen.ssm.service.ICarouselService;

@Controller
@RequestMapping(value="/carousel")
public class CarouselAction {

	private static final String UrlPrefix = "/today/carousel/upload/";
	
	@Resource
	ICarouselService carouselService;
	
	@RequestMapping("/add")
	public String add(Carousel carousel) {
		System.out.println("/carousel/add");
		
		
		//carousel.setUrl(fileName);
		//carousel.setName(multipartFile.getOriginalFilename());
		
		System.out.println("++++++++++++++++" + carousel);
		
		carouselService.add(carousel);
		return "redirect:index";
	}
	
	@RequestMapping("/index")
	public String list(HttpServletRequest httpRequest) {
		System.out.println("/carousel/index");
		List<Carousel> carouselList = carouselService.getAll();
		//url的前缀，如果图片保存文件夹的映射路径改变了，需要更改这个设置
		httpRequest.setAttribute("urlPrefix", "today/carousel/upload");
		httpRequest.setAttribute("carouselList", carouselList);
		return "carousel/adv";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) {
		System.out.println("/carousel/delete");
		carouselService.delete(id);
		return "redirect:index";
	}
	
	@RequestMapping("/update")
	public String Update(Carousel carousel) {
		System.out.println("/carousel/update");
		carouselService.update(carousel);
		return "redirect:index";
	}
	
	@RequestMapping("upload")
	public void upload(@RequestParam(value="imageFile")MultipartFile multipartFile, HttpServletResponse httpServletResponse) {
		System.out.println("——————————————————————————————————————upload");
		System.out.println("+++++++++++++++++++++" + "originalFileName" + multipartFile.getOriginalFilename());
		String message = null;
		if (multipartFile.getSize() == 0) {
//			message = "不能上传空文件";
			message = "no empty file allowed";
		} else {
			String physicalPath = System.getProperty("ssm_1Web.root") + CarouselAction.UrlPrefix;
//			System.out.println("----------------------" + physicalPath);
			String fileName = setFileName(multipartFile.getOriginalFilename(), generateRandomFileName());
			try {
				multipartFile.transferTo(new File(physicalPath + fileName));
				message = CarouselAction.UrlPrefix + fileName;
				System.out.println("++++++++______________+++++++++++" + "save file done");
			} catch (IllegalStateException e) {
				e.printStackTrace();
//				message = "服务器错误，上传失败";
				message = "server got error,upload failed";
			} catch (IOException e) {
				e.printStackTrace();
//				message = "服务器错误，上传失败";
				message = "server got error,upload failed";
			}
		}
		
		
		try {
			httpServletResponse.setStatus(200);
			httpServletResponse.getWriter().write(message);
			httpServletResponse.flushBuffer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String setFileName(String originFileName, String newFileName) {
		int index = originFileName.lastIndexOf('.');
		return newFileName + originFileName.substring(index >= 0 ? index : 0);
	}
	
	private String generateRandomFileName() {
		return UUID.randomUUID().toString();
	}
}
