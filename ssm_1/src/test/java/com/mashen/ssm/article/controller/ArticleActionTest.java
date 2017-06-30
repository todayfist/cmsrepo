package com.mashen.ssm.article.controller;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mashen.ssm.article.model.Article;
import com.mashen.ssm.article.service.IArticleService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:applicationContext.xml"))
public class ArticleActionTest {
	
	@Resource(name="articleServiceImp")
	IArticleService articleServiceImp;

	@Test
	public void testAdd() {
		Article article = new Article();
		article.setCategoryid(2);
		article.setContent("qwe");
		article.setHeadimg("dddd");
		article.setHeadline("sad");
		article.setHeadlineid(1);
		article.setHeadname("asdasd");
		article.setId(7);
		article.setThumb("dsad");
		article.setViewcount(1);
		articleServiceImp.add(article);
	}
	@Test
	public void test1() {
		
		articleServiceImp.delete(1);
	}
	@Test
	public void test2() {
		Article article = new Article();
		article.setId(2);
		article.setCategoryid(2);
		article.setContent("aa");
		article.setHeadimg("aa");
		article.setHeadline("aa");
		article.setHeadlineid(1);
		article.setHeadname("aa");

		article.setThumb("aa");
		article.setViewcount(1);
		articleServiceImp.update(article);
	}
	@Test
	public void test3() {
		Article article =articleServiceImp.selectbyid(2);
		
		
		System.out.println(article.toString());
	}
	@Test
	public void test4() {
	List<Article> list = articleServiceImp.selectbyname("sad");
		System.out.println(list.toString());
	}
	@Test
	public void test5() {
		List<Article> list=articleServiceImp.select();
		System.out.println(list.toString());
	}

}
