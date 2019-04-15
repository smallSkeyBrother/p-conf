package com.xiaotiangege.web.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 小天哥哥 
 * @mailto 361807535@qq.com  
 * @Description 全局异常拦截处理 
 * @createDate 2019年4月15日 下午2:42:50 
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	@ResponseBody
	public String exceptionHandler(Exception e) {
		return e.getMessage();
	}
	
}
