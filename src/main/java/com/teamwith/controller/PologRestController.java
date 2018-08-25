package com.teamwith.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.service.MemberService;
import com.teamwith.service.PologService;
import com.teamwith.service.ProfileService;
import com.teamwith.vo.MemberPraiseCntVO;
import com.teamwith.vo.MemberSkillVO;
import com.teamwith.vo.MemberTendencyVO;
import com.teamwith.vo.MemberVO;
import com.teamwith.vo.PologVO;

@RestController
@RequestMapping(value="/api/polog")
public class PologRestController {

	@Inject
	PologService pologService;
	@Inject
	ProfileService profileService;
	@Inject
	MemberService memberService;
	@ResponseBody
	@RequestMapping(value="/{memberId}")
	public Map<String,Object> getPolog(@PathVariable("memberId") String memberId ) throws Exception{
		
		Map<String,Object> params=new HashMap<String,Object>();
		PologVO polog=pologService.getPologInfo(memberId);
		MemberVO member=profileService.getMemberInfo(memberId);
		List<String> projectCategory=memberService.getMemberProjectCategory(memberId);
		List<MemberPraiseCntVO> praise=memberService.getMemberPraiseCnt(memberId);
		MemberTendencyVO tendency=profileService.getMemberTendency(memberId);
		MemberSkillVO skills=memberService.getMemberSkill(memberId);
		params.put("polog", polog);
		params.put("member", member);
		params.put("category", projectCategory);
		params.put("praise", praise);
		params.put("tendency", tendency);
		params.put("skills", skills);
		
		
		return params;
		
		
		
	}
	
}
