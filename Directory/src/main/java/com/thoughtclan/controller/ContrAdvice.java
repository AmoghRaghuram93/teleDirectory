package com.thoughtclan.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContrAdvice {

	@ExceptionHandler({ Exception.class })
	public String errorHandler() {
		return "error";
	}

}
