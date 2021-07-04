package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.ArticleDto;

public interface ArticleMapper {

	public void writeArticle(ArticleDto articleDto) throws SQLException;
	public int findAfterAdd();
	
	public List<ArticleDto> listArticle() throws SQLException;
	public ArticleDto getArticle(int articleno) throws SQLException;
	
	public void modifyArticle(ArticleDto articleDto) throws SQLException;
	
	public void deleteArticle(int articleno) throws SQLException;
	
}
