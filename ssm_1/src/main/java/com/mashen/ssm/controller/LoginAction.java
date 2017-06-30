package com.mashen.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mashen.ssm.model.Admin;
import com.mashen.ssm.model.User;
import com.mashen.ssm.service.IfcAdminService;
import com.mashen.ssm.service.IfcUserService;

@Controller
public class LoginAction {
	@Resource(name="userServiceImp")
	private IfcUserService userService;
	@Resource(name="adminServiceImp")
	private IfcAdminService adminService;
	
	
	@RequestMapping(value="/userLogin",method = RequestMethod.POST)
	public String userLogin(@ModelAttribute User user){
		System.out.println(user.getAccount()+user.getPassword()+user.getName()+user.getId()+user.getClass());
		boolean isSuccess = userService.login(user);
		/*
		 * 未指定返回页面
		*/
		if(isSuccess)
			return "todayfirst";
		else
			return "todayfirst";
	} 
	@RequestMapping(value="/adminLogin",method = RequestMethod.POST)
	public String adminLogin(@ModelAttribute Admin admin){
		System.out.println(admin.getAccount()+admin.getPassword()+admin.getName()+admin.getId()+admin.getClass());
		boolean isSuccess = adminService.login(admin);
		/*
		 * 未指定返回页面
		*/
		if(isSuccess)
			return "todayfirst";
		else
			return "todayfirst";
	} 
}
