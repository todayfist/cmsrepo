package com.mashen.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLogin {
	@RequestMapping("/adminLogin")
	public String login(){
		System.out.println("haha");
		return "/today/index.jsp";
	}
}
