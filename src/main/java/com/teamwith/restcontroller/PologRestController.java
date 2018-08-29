package com.teamwith.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.service.ApplicationService;
import com.teamwith.service.MemberService;
import com.teamwith.service.PologService;
import com.teamwith.service.ProfileService;
import com.teamwith.service.TeamService;
import com.teamwith.vo.MemberPraiseCntVO;
import com.teamwith.vo.MemberSearchVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MemberSkillVO;
import com.teamwith.vo.MemberTendencyVO;
import com.teamwith.vo.MemberVO;
import com.teamwith.vo.PologVO;
import com.teamwith.vo.TeamSimpleVO;

@RestController
@RequestMapping(value = "/api/polog")
public class PologRestController {

	@Inject
	PologService pologService;
	@Inject
	ProfileService profileService;
	@Inject
	MemberService memberService;
	@Inject
	private ApplicationService applicationService;
	@Inject
	private TeamService teamService;

	@ResponseBody
	@RequestMapping(value = "/{memberId}")
	public Map<String, Object> getPolog(@PathVariable("memberId") String memberId, HttpSession session)
			throws Exception {
		MemberSimpleVO memSession = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		MemberVO member = profileService.getMemberInfo(memberId);

		if (memSession != null) {
			String actor = memSession.getMemberId();
			// 같은 팀 멤버가 아니면 전화번호 생년월일 비공개
			if (!isTeamMember(actor, memberId)) {
				member.setMemberBirth("비공개");
				member.setMemberPhone("비공개");
			}
		}

		Map<String, Object> params = new HashMap<String, Object>();
		PologVO polog = pologService.getPologInfo(memberId);

		List<String> projectCategory = memberService.getMemberProjectCategory(memberId);
		List<MemberPraiseCntVO> praise = memberService.getMemberPraiseCnt(memberId);
		MemberTendencyVO tendency = profileService.getMemberTendency(memberId);
		MemberSkillVO skills = memberService.getMemberSkill(memberId);
		params.put("polog", polog);
		params.put("member", member);
		params.put("category", projectCategory);
		params.put("praise", praise);
		params.put("tendency", tendency);
		params.put("skills", skills);

		return params;

	}

	public boolean isTeamMember(String actor, String target) {
		List<String> joinTeamIds = applicationService.getJoinedTeamId(actor);
		try {
			List<TeamSimpleVO> teamVOs = teamService.getMyTeam(actor);
			for (TeamSimpleVO t : teamVOs) {
				joinTeamIds.add(t.getTeamId());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			for (String id : joinTeamIds) {

				// 같은 팀 멤버인지 확인, 모집날짜와 상관 없음.
				for (int i = 0; i < applicationService.getTeamMember(id).size(); i++) {
					List<MemberSearchVO> members = applicationService.getTeamMember(id);
					for (MemberSearchVO m : members) {
						if (m.getMemberId().equals(target)) {
							return true;
						}

					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
