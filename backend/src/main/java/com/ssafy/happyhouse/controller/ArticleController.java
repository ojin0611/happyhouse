package com.ssafy.happyhouse.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.help.NumberResult;
import com.ssafy.happyhouse.model.ArticleDto;
import com.ssafy.happyhouse.model.service.ArticleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/article")
@Api("Article Controller API V1")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired
	private ArticleService articleService;
	
	
	// 글 읽기
	@GetMapping(value = "/{articleno}")
	public ResponseEntity<ArticleDto> read(@PathVariable("articleno") int articleno) throws Exception {
		ArticleDto article = articleService.getArticle(articleno);
		// article 없을 때 어떻게 처리할까?
		if(article == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<ArticleDto>(article, HttpStatus.OK);
	}
	// 글 전체 읽기
	@GetMapping(value = "/")
	public ResponseEntity<List<ArticleDto>> readAll() throws Exception {
		List<ArticleDto> list = articleService.listArticle();
		return new ResponseEntity<List<ArticleDto>>(list, HttpStatus.OK);
	}
	
	// 글 작성하기
    @ApiOperation(value = " 새로운 글을 입력한다. 그리고 그 글의 번호를 반환한다.", response = NumberResult.class)
	@PostMapping(value = "/")
	public ResponseEntity<NumberResult> write(@RequestBody ArticleDto articleDto) throws Exception {
		// List<ArticleDto> list = articleService.getGugunInSido(sido);
   		logger.info("5-------------addArticle-----------------------------"+new Date());
   		logger.info("5-------------addArticle-----------------------------"+articleDto);
   		
   		int total = articleService.writeArticle(articleDto);
   		NumberResult nr=new NumberResult();
   		nr.setCount(total);
   		nr.setName("addArticle");
   		nr.setState("succ");
   		
   		if (total<=0) {
   			nr.setCount(-1);
   	   		nr.setName("addArticle");
   	   		nr.setState("fail");
   			//return new ResponseEntity(HttpStatus.NO_CONTENT);
   			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   		}
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);

	}
	
	// 글 수정하기
    @ApiOperation(value = " 글을 수정한다. 그리고 수정된 글의 번호를 반환한다. 실패 시 [500 error] 또는 [-1 반환]중 어떤것을 할지 고민중", response = NumberResult.class)
    @PutMapping(value="/")
    public ResponseEntity<NumberResult> update(@RequestBody ArticleDto articleDto) throws Exception {
    	// update에 성공한 개수
    	int total = articleService.modifyArticle(articleDto);
    	
   		NumberResult nr=new NumberResult();
   		nr.setCount(total);
   		nr.setName("updateArticle");
   		nr.setState("succ");
   		
   		if (total<=0) {
   			nr.setCount(-1);
   	   		nr.setName("updateArticle");
   	   		nr.setState("fail");
   			//return new ResponseEntity(HttpStatus.NO_CONTENT);
   			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   		}
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
    }
    
    // 글 삭제하기
    @ApiOperation(value = " 글을 삭제한다. 그리고 삭제된 글의 번호를 반환한다.", response = NumberResult.class)
    @DeleteMapping(value="/{articleno}")
    public ResponseEntity<NumberResult> delete(@PathVariable("articleno") int articleno) throws Exception {
    	// update에 성공한 개수
    	int total = articleService.deleteArticle(articleno);
    	
   		NumberResult nr=new NumberResult();
   		nr.setCount(total);
   		nr.setName("deleteArticle");
   		nr.setState("succ");
   		
   		if (total<=0) {
   			nr.setCount(-1);
   	   		nr.setName("deleteArticle");
   	   		nr.setState("fail");
   			//return new ResponseEntity(HttpStatus.NO_CONTENT);
   			return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   		}
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
    }
    
    

}
