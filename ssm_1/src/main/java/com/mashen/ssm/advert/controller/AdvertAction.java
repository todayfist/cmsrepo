package com.mashen.ssm.advert.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mashen.ssm.advert.model.Advert;
import com.mashen.ssm.advert.service.IAdvertService;

@Controller
@RequestMapping("/advert")
public class AdvertAction {
	@Resource(name="advertServiceImp")
	IAdvertService advertService;
	
	@RequestMapping(value="/advertadd")
	public String add(Advert advert,HttpServletRequest request,MultipartFile file) throws Exception{
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
        advert.setAdvertisings(path+uuid+fileName);
        advertService.add(advert);
		return "showadvert";
		
	}
	@RequestMapping("/advertdelete")
	public String delete(int id){
		Advert advert = advertService.selectbyid(id);
		File file = new File(advert.getAdvertisings());
		advertService.delete(id);
		file.delete();
		
		return "showadvert";
		
	}
	@RequestMapping("/advertbyid")
	public String select(int id,HttpServletRequest request){
		request.setAttribute("article", advertService.selectbyid(id));
		return "updateadvert";
		
	}
	@RequestMapping("/advertupdate")
	public String update(Advert advert,MultipartFile file) throws Exception{
		if(file.getOriginalFilename()!=null&&!file.getOriginalFilename().equals("")){
			
			File delfile = new File(advert.getAdvertisings());
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
	        advert.setAdvertisings(path+uuid+fileName);
	        advertService.update(advert);
			
		}else{
			advertService.update(advert);
		}
		return "showadvert";
		
	}
	@RequestMapping("/articleshow")
	public String select(HttpServletRequest request){
		List<Advert> list = advertService.select();
		request.setAttribute("advertlist", list);
		return "showadvert";
		
	}

}
