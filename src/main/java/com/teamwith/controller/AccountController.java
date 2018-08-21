package com.teamwith.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.ApplicationService;
import com.teamwith.vo.MemberSimpleVO;

@RequestMapping("/account")
@Controller
public class AccountController {

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String home(Model model, HttpSession session) {
		return null;
	}
}
