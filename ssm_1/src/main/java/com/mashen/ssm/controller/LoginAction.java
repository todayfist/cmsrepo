package com.mashen.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mashen.ssm.model.User;
import com.mashen.ssm.service.IUserService;

@Controller
public class LoginAction {
	@Resource(name="userServiceImp")
	private IUserService userService;
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(@ModelAttribute User user){
		System.out.println(user.getAccount()+user.getPassword()+user.getName()+user.getId()+user.getClass());
		boolean isSuccess = userService.login(user);
		if(isSuccess)
			return "todayfirst";
		else
			return "todayfirst";
	} 
}
