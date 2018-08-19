package com.teamwith.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.MemberService;
import com.teamwith.service.ProfileService;
import com.teamwith.vo.MemberProjectCategoryVO;
import com.teamwith.vo.MemberSkillVO;
import com.teamwith.vo.MemberTendencyVO;
import com.teamwith.vo.MemberVO;
import com.teamwith.vo.TendencyVO;

@RequestMapping(value = "/profile")
@Controller
public class ProfileController {

	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

	String jspPath = "polog/jsp/";

	@Inject
	ProfileService profileService;
	@Inject
	MemberService memberService;

	@RequestMapping(value = "/edit/{memId}", method = RequestMethod.GET)
	public String profileEditView(@PathVariable(value = "memId") String memberId, Model model) {
		try {
			MemberVO mem = profileService.getMyInfo(memberId);

			List<String> projectCategory = memberService.getMemberProjectCategory(memberId);
			MemberSkillVO skill = memberService.getMemberSkill(memberId);
			MemberTendencyVO tendency = profileService.getMemberTendency(memberId);

			model.addAttribute("memberVO", mem);
			model.addAttribute("memberProjectCategoryList", projectCategory);
			model.addAttribute("skillVO", skill);
			model.addAttribute("tendencyVO", tendency);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jspPath + "profileEdit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String profileEdit(MemberVO updateMemberInfo, String[] regionId, String[] skill, String[] categoryId,
			Model model, TendencyVO tendency) {
		
		String memberId = updateMemberInfo.getMemberId();
		try {

			/* memberInfo */
			profileService.updateMemberInfo(updateMemberInfo, null);

			MemberProjectCategoryVO pcVO = new MemberProjectCategoryVO(memberId, categoryId);
			memberService.updateMemberProjectCategory(pcVO);

			memberService.updateMemberSkill(new MemberSkillVO(memberId, skill));

			Map<String, String> tdMap = new HashMap<String, String>();
			tdMap.put("tendency-1", tendency.getTendency1());
			tdMap.put("tendency-2", tendency.getTendency2());
			tdMap.put("tendency-3", tendency.getTendency3());
			tdMap.put("tendency-4", tendency.getTendency4());
			tdMap.put("tendency-5", tendency.getTendency5());
			MemberTendencyVO memberTendency = new MemberTendencyVO(memberId, tdMap);
			profileService.updateMemberTendency(memberTendency);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/" + memberId;

	}

}
