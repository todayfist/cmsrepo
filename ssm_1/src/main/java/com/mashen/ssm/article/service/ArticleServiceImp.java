package com.mashen.ssm.article.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashen.ssm.article.dao.IArticleDao;
import com.mashen.ssm.article.model.Article;
@Transactional(rollbackFor=java.lang.Exception.class)
@Service("articleServiceImp")
public class ArticleServiceImp implements IArticleService {
	
	@Resource(name="articleDao")
	IArticleDao articleDao;

	@Override
	public void add(Article article) {
		articleDao.add(article);

	}

	@Override
	public void delete(int id) {
		articleDao.delete(id);

	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		articleDao.update(article);
	}

	@Override
	public List<Article> select() {
		// TODO Auto-generated method stub
		return articleDao.select();
	}

	@Override
	public List<Article> selectbyname(String headline) {
		// TODO Auto-generated method stub
		return articleDao.selectbyname(headline);
	}

	@Override
	public Article selectbyid(int id) {
		System.out.println(articleDao.selectbyid(id));
		// TODO Auto-generated method stub
		return articleDao.selectbyid(id);
	}


}
