package com.teamwith.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamwith.service.ApplicationService;
import com.teamwith.service.LoginService;
import com.teamwith.service.TeamService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MyApplicationVO;
import com.teamwith.vo.TeamSimpleVO;

@RequestMapping("/login")
@Controller
public class LoginController {
	@Inject
	private LoginService loginService;
	@Inject
	private ApplicationService applicationService;
	@Inject
	private TeamService teamService;
	@Inject
	private MemberSimpleVO memberSimpleVO;
	
	/*	public void login() {
		LoginService loginService = LoginService.getInstance();
		ApplicationService applicationService = ApplicationService.getInstance();
		TeamService teamService = TeamService.getInstance();

		loginService.openSession();
		
		MemberSimpleVO memberSimpleVO = null;
		try {
			memberSimpleVO = loginService.login(request.getParameter("memberId"), request.getParameter("memberPassword"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			loginService.closeSession();
		}

		// 로그인에 성공한 경우
		if (memberSimpleVO != null) {
			// 세션에 로그인한 멤버 정보 저장
			session.setAttribute("memberSimpleVO", memberSimpleVO);
			
			// 나의 지원 팀 개수 저장
			List<MyApplicationVO> myApplicationVOList = applicationService.getMyApplication(memberSimpleVO.getMemberId());
			request.setAttribute("myApplicationCnt", myApplicationVOList.size());
			
			// 내가 등록한 팀 개수 저장
			List<TeamSimpleVO> teamSimpleVOList = null;
			try {
				teamSimpleVOList = teamService.getMyTeam(new Criteria(1, 11), memberSimpleVO.getMemberId());
				request.setAttribute("myTeamList", teamSimpleVOList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}*/
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String login(@RequestParam("memberId") String memberId, @RequestParam("memberPassword") String memberPassword, HttpSession session, Model model) {
		try {
			// 로그인 메소드 호출
			memberSimpleVO = loginService.login(memberId, memberPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 로그인이 성공한 경우
		if(memberSimpleVO != null) {
			// 세션에 로그인한 멤버의 정보 저장
			session.setAttribute("memberSimpleVO", memberSimpleVO);
			
			// 나의 지원 팀 개수 저장
			List<MyApplicationVO> myApplicationVOList = applicationService.getMyApplication(memberId);
			model.addAttribute("myApplicationCnt", myApplicationVOList.size());
			
			// 내가 등록한 팀 개수 저장
			List<TeamSimpleVO> teamSimpleVOList = null;
			try {
				teamSimpleVOList = teamService.getMyTeam(new Criteria(1, 11), memberSimpleVO.getMemberId());
				model.addAttribute("myTeamList", teamSimpleVOList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "/";
	}
	
}
