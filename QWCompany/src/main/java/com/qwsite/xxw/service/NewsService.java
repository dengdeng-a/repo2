package com.qwsite.xxw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwsite.xxw.bean.News;
import com.qwsite.xxw.dao.NewsMapper;

@Service
public class NewsService {

	@Autowired
	NewsMapper newsMapper;
	
	public List<News> getAll() {
		
		return newsMapper.selectByExample(null);
	}

	public void saveNews(News news) {
		newsMapper.insertSelective(news);
		
	}

	public News getOneNew(Integer id) {
		News news = newsMapper.selectByPrimaryKey(id);
		return news;
	}


	public void updateEmp(News news) {
		newsMapper.updateByPrimaryKeySelective(news);
	
	}

	public void deleteNews(Integer id) {
		newsMapper.deleteByPrimaryKey(id);
		System.out.println("444444444444");
	}

	
}
