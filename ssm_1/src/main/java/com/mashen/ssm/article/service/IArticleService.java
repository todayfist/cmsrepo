package com.mashen.ssm.article.service;

import java.util.List;

import com.mashen.ssm.article.model.Article;

public interface IArticleService {
public void add(Article article);
	
	public void delete(int id);
	
	public void update(Article article);
	
	public List<Article> select();
	public List<Article> selectbyname(String headline);
	public Article selectbyid(int id);
}
