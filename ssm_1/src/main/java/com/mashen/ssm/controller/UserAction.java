package com.mashen.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mashen.ssm.model.User;
import com.mashen.ssm.service.IUserService;

@Controller
@RequestMapping(value="/user3")
public class UserAction {
	@Resource
	private IUserService userService;
	
	@RequestMapping("/login3")
	public String login(){
		
		//通过调用Service接口利用IOC或取与数据库连接的业务逻辑方法
		//这个方法的功能是判断用户是否存在
		//如果存在方法有返回值跳转到主页否则原页跳转
		System.out.println("跳转成功!"); 
		return "todayfirst";
	}
	/*
	 * @auther yaoming
	 * logincheck
	*/
	/*@RequestMapping("/userlogin")
	public String UserLogin(@ModelAttribute User user){
		Boolean checked = userService.login(user.getAccount(),user.getPassword());
		if(checked)
			return "";
		else
			return "Bootstrap/todayfirst";
		//System.out.println("跳转成功!"); 
		
	} */
}
