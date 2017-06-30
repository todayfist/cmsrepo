package com.mashen.ssm.article.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;

import com.mashen.ssm.article.model.Article;
import com.mashen.ssm.article.service.IArticleService;

@Controller
@RequestMapping("/article")
public class ArticleAction {


	@Resource(name="articleServiceImp")
	IArticleService articleServiceImp;

	@RequestMapping(value="/articleadd")
	public String add(Article article,HttpServletRequest request,MultipartFile file) throws Exception{
		String uuid = UUID.randomUUID().toString();
		String path = "D:/test/";  
        String fileName = file.getOriginalFilename();  
        System.out.println(path);  
        File targetFile = new File(path, uuid+fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();//创建目录  
        }  
        //保存  
        file.transferTo(targetFile);  
        article.setThumb(path+uuid+fileName);
		articleServiceImp.add(article);
		return "show";
		
	}
	@RequestMapping("/articledelete")
	public String delete(int id){
		Article article = articleServiceImp.selectbyid(id);
		File file = new File(article.getThumb());
		articleServiceImp.delete(id);
		file.delete();
		
		return "show";
		
	}
	@RequestMapping("/articlebyid")
	public String select(int id,HttpServletRequest request){
		request.setAttribute("article", articleServiceImp.selectbyid(id));
		return "updatearticle";
		
	}
	@RequestMapping("/articleupdate")
	public String update(Article article,MultipartFile file) throws Exception{
		if(file.getOriginalFilename()!=null&&!file.getOriginalFilename().equals("")){
			
			File delfile = new File(article.getThumb());
			delfile.delete();
			String uuid = UUID.randomUUID().toString();
			String path = "D:/test/";  
	        String fileName = file.getOriginalFilename();  
	        System.out.println(path);  
	        File targetFile = new File(path, uuid+fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();//创建目录  
	        }  	
	        //保存  
	        file.transferTo(targetFile);  
	        article.setThumb(path+uuid+fileName);
	        articleServiceImp.update(article);
			
		}else{
			articleServiceImp.update(article);
		}
		return "show";
		
	}
	@RequestMapping("/articleshow")
	public String select(HttpServletRequest request){
		List<Article> list = articleServiceImp.select();
		request.setAttribute("articlelist", list);
		return "show";
		
	}

}
