package com.teamwith.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.MemberService;
import com.teamwith.service.ProfileService;
import com.teamwith.vo.MemberPraiseCntVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MemberSkillVO;
import com.teamwith.vo.MemberTendencyVO;
import com.teamwith.vo.MemberVO;

@Controller
public class PologMainController {

	private static final Logger logger = LoggerFactory.getLogger(PologMainController.class);

	@Inject
	ProfileService profileService;
	@Inject
	MemberService memberService;

	@RequestMapping(value = "/{memberId}", method = RequestMethod.GET)
	public String home(@PathVariable(value = "memberId") String memberId, Model model, HttpSession session) {
		String sessionMemId = null;
		MemberSimpleVO msVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		if (msVO != null) {
			sessionMemId = msVO.getMemberId();
		}
		try {
			MemberVO mem = profileService.getMemberInfo(memberId);
			/* 鍮꾧났媛? ?쉶?썝?씠硫? */
			if (mem == null) {
				/* 鍮꾧났媛쒖?留? 蹂몄씤?씠 ?슂泥??븯硫? ?젙蹂? 蹂댁뿬以? */
				if (memberId.equals(sessionMemId)) {
					mem = profileService.getMyInfo(memberId);
				} else {
					return "polog/jsp/privatePolog";
				}
			}

			List<MemberPraiseCntVO> result = memberService.getMemberPraiseCnt(memberId);
			List<String> projectCategory = memberService.getMemberProjectCategory(memberId);
			MemberSkillVO skill = memberService.getMemberSkill(memberId);
			MemberTendencyVO tendency = profileService.getMemberTendency(memberId);

			model.addAttribute("memberVO", mem);
			model.addAttribute("memberProjectCategoryList", projectCategory);
			model.addAttribute("praiseCntList", result);
			model.addAttribute("skillVO", skill);
			model.addAttribute("tendencyVO", tendency);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "polog/jsp/pologMain";
	}

}
