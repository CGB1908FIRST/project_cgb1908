package com.cy.res.sys.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.res.sys.vo.JsonResult;

@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		//输出异常信息
		e.printStackTrace();
		//封装异常信息
		return new JsonResult(e);
	}
}
