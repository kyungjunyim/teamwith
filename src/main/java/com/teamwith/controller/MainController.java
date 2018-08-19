package com.teamwith.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.MemberService;
import com.teamwith.service.TeamService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.MemberSearchVO;
import com.teamwith.vo.TeamSimpleVO;

@Controller
public class MainController {
	@Inject
	private TeamService teamService;
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		// 최근 팀 저장
		Criteria teamCri = new Criteria();
		List<TeamSimpleVO> recentTeamList = null;
		try {
			recentTeamList = teamService.getRecentTeam(teamCri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("recentTeamList", recentTeamList);
		
		// 우수 회원 저장
		Criteria memberCri = new Criteria(1, 4);
		List<MemberSearchVO> bestMemberList = null;
		try {
			bestMemberList = memberService.getBestMember(memberCri);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		model.addAttribute("bestMemberList", bestMemberList);
		
		return "teambuilding/jsp/main";
	}
	
}
