package com.teamwith.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.dto.InterviewQuestionDTO;
import com.teamwith.service.ApplicationService;
import com.teamwith.service.TeamService;
import com.teamwith.vo.FaqVO;
import com.teamwith.vo.MemberSearchVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.RecruitVO;
import com.teamwith.vo.RequireSkillVO;
import com.teamwith.vo.TeamDetailVO;

@RestController
@RequestMapping(value="/api/teamSearch")
public class TeamSearchRestController {
	@Inject
	TeamService teamService;
	@Inject
	ApplicationService applicationService;

	@ResponseBody
	@RequestMapping(value = "{teamId}", method = RequestMethod.GET)
	public HashMap<String, Object> teamSearch(@PathVariable("teamId") String teamId, HttpSession session, Model model)
			throws Exception {
		MemberSimpleVO memberSimpleVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		teamId = "team-" + teamId;
		HashMap<String, Object> result = new HashMap<String, Object>();

		boolean canApply = true;
		TeamDetailVO teamInfo = teamService.getTeamInfo(teamId);
		result.put("teamInfo", teamInfo);

		List<RecruitVO> recruitInfo = teamService.getRecruitInfo(teamId);
		result.put("recruitInfo", recruitInfo);

		List<InterviewQuestionDTO> interviewInfo = applicationService.getInterviewQuestion(teamId);
		result.put("interviewInfo", interviewInfo);

		List<MemberSearchVO> teamMembers = applicationService.getTeamMember(teamId);
		result.put("teamMembers", teamMembers);

		List<RequireSkillVO> requireSkills = new ArrayList<RequireSkillVO>();
		if (recruitInfo != null) {
			for (RecruitVO recruit : recruitInfo) {
				requireSkills.addAll(teamService.getRequireSkills(recruit.getRecruitId()));
			}
		}
		result.put("requireSkills", requireSkills);

		if (teamMembers != null) {
			for (MemberSearchVO teamMember : teamMembers) {
				if (teamMember.getMemberId().equals(memberSimpleVO.getMemberId())) {
					canApply = false;
				}
			}
		}

		if (memberSimpleVO == null) {
			canApply = false;
		}
		result.put("canApply", canApply);

		List<FaqVO> faqInfo = teamService.getFaq(teamId);
		result.put("faqInfo", faqInfo);

		String teamEndDate = teamInfo.getTeamEndDate();
		int endYear = Integer.parseInt(teamEndDate.substring(0, 4));
		int endMonth = Integer.parseInt(teamEndDate.substring(5, 7));
		int endDate = Integer.parseInt(teamEndDate.substring(8, 10));
		GregorianCalendar endDay = new GregorianCalendar();
		endDay.set(endYear, endMonth, endDate);
		GregorianCalendar today = new GregorianCalendar();
		Date oneMonthAgo = today.getTime();
		oneMonthAgo.setMonth(oneMonthAgo.getMonth() + 1);
		today.setTime(oneMonthAgo);
		long dDay = (today.getTimeInMillis() / (24 * 60 * 60 * 1000))
				- (endDay.getTimeInMillis() / (24 * 60 * 60 * 1000));
		result.put("dDay", dDay);

		return result;
	}
}
