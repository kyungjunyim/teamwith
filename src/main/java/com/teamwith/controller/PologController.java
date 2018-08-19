package com.teamwith.controller;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.PologService;

@RequestMapping(value = "/polog")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@Controller
public class PologController {
	private static final Logger logger = LoggerFactory.getLogger(PologController.class);

	String jspPath = "polog/jsp/";

	@Inject
	PologService pologService;

	@RequestMapping(value = "/edit/{memId}", method = RequestMethod.GET)
	public String pologEditView(@PathVariable(value = "memId") String memberId, Model model) {

		return "";
	}
	@RequestMapping(value = "/edit/{memId}", method = RequestMethod.POST)
	public String pologEdit(@PathVariable(value = "memId") String memberId, Model model) {

		return "";
	}
}
