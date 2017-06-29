package com.mashen.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mashen.ssm.dao.IColumnDao;

@Controller
public class ColumnAction {
	@Resource
	private IColumnDao columnDao;
	@RequestMapping("/columnList")
	public String add(HttpServletRequest request){
		request.setAttribute("columnList", columnDao.add(column););
		System.out.println("hello");
		return "todayfirst";
	}
}
