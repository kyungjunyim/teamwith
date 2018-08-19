package com.teamwith.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamwith.service.LoginService;
import com.teamwith.vo.MemberSimpleVO;

@Controller
public class LoginController {
	@Inject
	private LoginService loginService;
	@Inject
	private MemberSimpleVO memberSimpleVO;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("memberId") String memberId,
			@RequestParam("memberPassword") String memberPassword, HttpSession session, Model model, RedirectAttributes rttr) throws Exception {
		// 로그인 메소드 호출
		memberSimpleVO = loginService.login(memberId, memberPassword);
		session.setAttribute("memberSimpleVO", memberSimpleVO);
		if(memberSimpleVO == null) {
			rttr.addFlashAttribute("loginResult", "false");
		} else {
			rttr.addFlashAttribute("loginResult", "true");	
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		// 세션 무효화
		session.invalidate();
		
		return "redirect:/";
	}

}
