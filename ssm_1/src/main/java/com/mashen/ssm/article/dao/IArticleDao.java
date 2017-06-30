package com.mashen.ssm.article.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mashen.ssm.article.model.Article;

@Repository("articleDao")
public interface IArticleDao {
	public int add(Article article);
	
	public int delete(int id);
	
	public int update(Article article);
	public List<Article> select();
	public List<Article> selectbyname(String headline);
	public Article selectbyid(int id);
	

}
