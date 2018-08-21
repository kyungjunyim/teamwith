package com.teamwith.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamwith.service.AccountService;
import com.teamwith.vo.MemberVO;

@RequestMapping("/account")
@Controller
public class AccountController {
	@Inject
	AccountService accountService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String accountRegister(Model model, MemberVO member, RedirectAttributes rttr) {
		try {
			accountService.registerMember(member);
			rttr.addFlashAttribute("regResult", "success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rttr.addFlashAttribute("regResult", "fail");
		}
		return "redirect:/";
	}
	@RequestMapping(value="/isDuple", method = RequestMethod.POST)
	public String isDuple(Model model, String memberId, String memberEmail) {

		return "redirect:/";
	}
}
