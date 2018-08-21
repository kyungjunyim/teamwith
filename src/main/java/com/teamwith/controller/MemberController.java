package com.teamwith.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.MemberService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.MemberSearchVO;

@RequestMapping("/member")
@Controller
public class MemberController {
	@Inject
	private MemberService memberService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String member(Model model) throws Exception {
		List<MemberSearchVO> bestMemberList = memberService.getBestMember(new Criteria());
		model.addAttribute("bestMemberList", bestMemberList);
		
		List<MemberSearchVO> recentMemberList = memberService.getRecentMember(new Criteria(1, 8));
		model.addAttribute("recentMemberList", recentMemberList);

		return "teambuilding/jsp/searchMember";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String member(Model model, String[] region, String[] project, String[] role,
			String[] skill, String textCondition, String keyword) throws Exception {
		if (region == null && project == null && role == null && skill == null && keyword.trim().equals("")) {
			return member(model);
		} else {
			model.addAttribute("recentTeamList", null);
			model.addAttribute("recommendedTeamList", null);
			List<String> resultIdList = null;
			List<MemberSearchVO> resultMemberList = new ArrayList<MemberSearchVO>();
			List<String> memberIdListByRegion = null;
			List<String> memberIdListByRole = null;
			List<String> memberIdListByCategory = null;
			List<String> memberIdListBySkill = null;
			List<String> memberIdListByKeyword = null;
			
			memberIdListByCategory = memberService.getMemberByProjectCategoryId(projectCategoryId);
			
			return null;
		}
	}
}
