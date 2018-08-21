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
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(Model model, String memberId, RedirectAttributes rttr) {
		try {
			accountService.hideMember(memberId);
			rttr.addFlashAttribute("removeResult", "success");
		} catch (Exception e) {
			e.printStackTrace();
			rttr.addFlashAttribute("removeResult", "fail");
		}
		return "redirect:/";
	}
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(Model model, String memberId, String memberPassword, String newPassword, RedirectAttributes rttr) {
		try {
			accountService.updatePassword(memberId, memberPassword, newPassword);
			rttr.addFlashAttribute("chnagePwdResult", "success");
		} catch (Exception e) {
			e.printStackTrace();
			rttr.addFlashAttribute("chnagePwdResult", "fail");
		}
		return "redirect:/";
	}
}
