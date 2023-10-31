package com.myWeb.www.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice //exception 핸들러를 사용할수있는 어노테이션
public class CommonExceptionAdvice 
{
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex)
	{
		log.info("오류!!");
		return "custom404";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handler404(NoHandlerFoundException ex) //CommonExceptionAdvice 404에서 사용되는 객체
	{
		return "custom404";
	}

}
