package com.myWeb.www.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.myWeb.www.domain.commentVO;
import com.myWeb.www.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/comment/*")
@Slf4j
public class CommentController 
{
	@Inject
	private CommentService csv;
	
	private int isOk;

	
	@PostMapping(value="/post",consumes = "application/json")
	public ResponseEntity<String> postComment(@RequestBody commentVO cvo)
	{
		isOk=csv.postComment(cvo);
		return isOk>0? new ResponseEntity<String>("1",HttpStatus.OK):new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/{bno}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<commentVO>> getCommentList(@PathVariable("bno")int bno)
	{
		log.info("getList check");
		List<commentVO> list=csv.getList(bno);
		log.info("list"+list);
		return new ResponseEntity<List<commentVO>>(list,HttpStatus.OK);
	}
	@DeleteMapping(value = "/{cno}",produces =MediaType.TEXT_PLAIN_VALUE )
	public ResponseEntity<String> deleteComment(@PathVariable("cno")int cno)
	{
		log.info("deleteComment check");
		isOk=csv.removeComment(cno);
		return isOk>0? new ResponseEntity<String>("1",HttpStatus.OK):new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
