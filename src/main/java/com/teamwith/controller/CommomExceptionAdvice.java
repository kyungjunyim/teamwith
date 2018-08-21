package com.teamwith.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommomExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommomExceptionAdvice.class);

	@ExceptionHandler(Exception.class)
	public ModelAndView common(Exception e) {
		ModelAndView mnv = new ModelAndView("/teambuilding/jsp/error");
		logger.info(e.toString());
		e.printStackTrace();
		mnv.addObject("exception", e);

		return mnv;
	}
}