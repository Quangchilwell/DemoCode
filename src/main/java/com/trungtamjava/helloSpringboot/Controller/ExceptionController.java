package com.trungtamjava.helloSpringboot.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {
	
	// Xử lí cho lỗi 404
	@ExceptionHandler(value = { NoHandlerFoundException.class })
	public String exceptionHandler() {
		System.out.println("Co loi o day");
		return "Co loi";
	}
}
