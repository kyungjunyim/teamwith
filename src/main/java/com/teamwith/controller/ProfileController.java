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

@RequestMapping(value = "/profile")
@Controller
public class ProfileController {

	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

	String jspPath = "polog/jsp/";

	@Inject
	ProfileService profileService;
	@Inject
	MemberService memberService;

	@RequestMapping(value = "/edit/{memberId}", method = RequestMethod.GET)
	public String profileEditView(@PathVariable(value = "memberId") String memberId, Model model) {
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

	@RequestMapping(value = "/edit/{memberId}", method = RequestMethod.POST)
	public String profileEdit(MemberVO updateMemberInfo, String[] regionId, Model model) {
		try {
			System.out.println(regionId);
			/* memberInfo */
			profileService.updateMemberInfo(updateMemberInfo, null);
/*
			// project category 
			MemberProjectCategoryVO pcVO = new MemberProjectCategoryVO(memberId, categories);
			memberService.updateMemberProjectCategory(pcVO);

			// skill 
			Map<String, String> skillMap = new HashMap<String, String>();
			if (skills != null) {
				for (String sk : skills) {
					System.out.println(sk);
					skillMap.put(sk, "1");
				}
			}
			memberService.updateMemberSkill(new MemberSkillVO(memberId, skillMap));

			// tendency 
			Map<String, String> tdMap = new HashMap<String, String>();
			for (int i = 1; i <= 5; i++) {
				tdMap.put("tendency-", tendencies[i - 1]);
			}
			MemberTendencyVO memberTendency = new MemberTendencyVO(memberId, tdMap);
			profileService.updateMemberTendency(memberTendency);
*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/" + jspPath + "pologMain";

	}

}
