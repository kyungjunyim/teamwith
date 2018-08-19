package com.teamwith.controller;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.MemberService;

@Controller
@RequestMapping(value = "/..")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class PraiseController {

	private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String searchPortfolio(Model model) {
		
		//memberService.updateMemberPraise(praise);
		return null;
	}
}
