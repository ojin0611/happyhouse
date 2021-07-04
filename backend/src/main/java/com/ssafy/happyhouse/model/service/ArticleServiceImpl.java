package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.ArticleDto;
import com.ssafy.happyhouse.model.mapper.ArticleMapper;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	@Transactional
	public int writeArticle(ArticleDto articleDto) throws Exception {
		if(articleDto.getSubject() == null || articleDto.getContent() == null) {
			throw new Exception();
		}
		sqlSession.getMapper(ArticleMapper.class).writeArticle(articleDto);
		return sqlSession.getMapper(ArticleMapper.class).findAfterAdd();
	}

//	@Override
//	public List<ArticleDto> listArticle(String key, String word) throws Exception {
//		key = key == null ? "" : key;
//		word = word == null ? "" : word;
//		return articleDao.listArticle(key, word);
//	}

	@Override
	public List<ArticleDto> listArticle() throws Exception {
		return sqlSession.getMapper(ArticleMapper.class).listArticle();
	}
	
	@Override
	public ArticleDto getArticle(int articleno) throws Exception {
		return sqlSession.getMapper(ArticleMapper.class).getArticle(articleno);
	}

	@Override
	@Transactional
	public int modifyArticle(ArticleDto articleDto) throws Exception {
		if(articleDto.getSubject() == null || articleDto.getContent() == null) {
			throw new Exception();
		}
		sqlSession.getMapper(ArticleMapper.class).modifyArticle(articleDto);
		return articleDto.getArticleno();
	}

	@Override
	@Transactional
	public int deleteArticle(int articleno) throws Exception {
		sqlSession.getMapper(ArticleMapper.class).deleteArticle(articleno);
		return articleno;
	}

}
