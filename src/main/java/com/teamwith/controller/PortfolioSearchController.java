package com.teamwith.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.PologService;

@Controller
@RequestMapping(value = "/portfolios")
public class PortfolioSearchController {

	private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);

	@Inject
	private PologService pologService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String searchPortfolio(Model model) {
		return "teambuilding/jsp/searchPortfolio";
	}
}
