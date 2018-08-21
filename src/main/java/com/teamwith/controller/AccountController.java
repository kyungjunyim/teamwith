package com.teamwith.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamwith.service.AccountService;
import com.teamwith.service.LoginService;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MemberVO;

@RequestMapping("/account")
@Controller
public class AccountController {
	@Inject
	AccountService accountService;
	@Inject
	LoginService loginService;
	@Inject
	MemberSimpleVO memberSimpleVO;

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
	

	@RequestMapping(value="/findId", method=RequestMethod.POST)
	public String findId(Model model, String memberBirth, String memberEmail) throws Exception {
		
		model.addAttribute("msg", accountService.findAccount(memberBirth, memberEmail));
		
		return "teambuilding/jsp/findResult";
	}
	
	@RequestMapping(value="/findPwd", method=RequestMethod.POST)
	public String findPwd(Model model, String memberId, String memberBirth, String memberEmail) throws Exception {
		model.addAttribute("msg", accountService.findAccount(memberId, memberBirth, memberEmail));
		
		return "teambuilding/jsp/findResult";
  }
    
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(Model model, HttpSession session, String memberPassword) throws Exception {
		String memberId = ((MemberSimpleVO) session.getAttribute("memberSimpleVO")).getMemberId();
		if(login(memberId, memberPassword)) {
			accountService.hideMember(memberId);
			model.addAttribute("msg", "회원 탈퇴가 성공적으로 처리되었습니다!");
			session.invalidate();
		}
		else {
			model.addAttribute("msg", "회원 탈퇴에 실패하였습니다!");
		}
		return "teambuilding/jsp/findResult";
	}
	
	private boolean login(String memberId, String memberPassword) throws Exception {
		// 로그인 메소드 호출
		memberSimpleVO = loginService.login(memberId, memberPassword);
		if(memberSimpleVO == null) {
			return false;
		} else {
			return true;	
		}
	}
  
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePassword(Model model, String memberId, String memberPassword, String newPassword) {
		try {
			accountService.updatePassword(memberId, memberPassword, newPassword);
			model.addAttribute("msg", "비밀번호가 성공적으로 변경되었습니다!");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "비밀번호 변경에 실패하였습니다!");
		}
		return "teambuilding/jsp/findResult";
	}
}
