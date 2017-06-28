package com.mashen.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user3")
public class UserAction {
	@RequestMapping("/login3")
	public String login(){
		System.out.println("跳转成功!"); 
		return "success";
	}
	/*
	 * @auther yaoming
	 * logincheck
	*/
	@RequestMapping("/userlogin")
	public String UserLogin(){
		System.out.println("跳转成功!"); 
		return "Bootstrap/todayfirst";
	}
}
