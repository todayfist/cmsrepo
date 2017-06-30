package com.mashen.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerAciton {
	@RequestMapping("/admin")
	public String admin(){
		
		return "/today/Manager/login.jsp";
		}
}
