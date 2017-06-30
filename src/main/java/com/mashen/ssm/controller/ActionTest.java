package com.mashen.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActionTest {
	
	@RequestMapping("/test")
	public String test(){
		System.out.println("hello");
		return "/today/todayfirst.jsp";
	}
}
