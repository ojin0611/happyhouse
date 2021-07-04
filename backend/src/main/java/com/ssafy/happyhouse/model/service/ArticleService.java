package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.ArticleDto;

public interface ArticleService {

	public int writeArticle(ArticleDto articleDto) throws Exception;
	public List<ArticleDto> listArticle() throws Exception;
	
	public ArticleDto getArticle(int articleno) throws Exception;
	public int modifyArticle(ArticleDto articleDto) throws Exception;
	public int deleteArticle(int articleno) throws Exception;
	
}
