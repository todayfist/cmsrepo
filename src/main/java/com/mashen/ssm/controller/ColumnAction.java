package com.mashen.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mashen.ssm.dao.IColumnDao;
import com.mashen.ssm.model.Column;
import com.mashen.ssm.service.IColumnService;



@Controller
public class ColumnAction {
	@Autowired
	private IColumnService columnService;
//	private IColumnDao columnDao;
	@RequestMapping("/col")
	public String add(HttpServletRequest request){
		request.setAttribute("colList", columnService.query());
		System.out.println("hello");
		System.out.println(columnService.query());
		return "/today/todayfirst.jsp";
	}
	@RequestMapping("/colAdd")
		public String colAdd(String col_title){
			columnService.add(col_title);
			return "/today/Manager/column.jsp";
		}
	@RequestMapping("/colDelete")
	public String colDelete(){
		return "";
	}
	@RequestMapping("/colUpdate")
	public String colUpdate(){
		return "";
	}
	@RequestMapping("/colQuery")
	public String colQuery(){
		return "";
	}
	
}
