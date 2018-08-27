package com.teamwith.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.service.ApplicationService;
import com.teamwith.service.TeamService;
import com.teamwith.vo.ApplicantVO;
import com.teamwith.vo.InterviewVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.TeamSimpleVO;

@RestController
@RequestMapping(value = "/api/teamInfo")
public class TeamInfoRestController {
	@Inject
	private TeamService teamService;
	@Inject
	private ApplicationService applicationService;

	@RequestMapping(value = "joinedTeam", method = RequestMethod.GET)
	public Map<String, Object> joinedTeam(HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		MemberSimpleVO login = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		if (login == null) {
			return resultMap;
		}
		String loginId = login.getMemberId();
		List<TeamSimpleVO> result = new ArrayList<TeamSimpleVO>();
		try {
			List<String> teamIdList = applicationService.getJoinedTeamId(loginId);
			for (String teamId : teamIdList) {
				TeamSimpleVO teamSimpleVO = teamService.getTeamSimple(teamId);
				result.add(teamSimpleVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMap.put("joinedTeamList", result);
		return resultMap;
	}

	@RequestMapping(value = "/applicant/{teamId}", method = RequestMethod.GET)
	public Map<String, Object> showApplicant(@PathVariable("teamId") String teamId) {
		String key = "team-" + teamId;
		Map<String, Object> result = new HashMap<String, Object>();
		List<ApplicantVO> applicantList = applicationService.getApplicant(key);

		Map<String, List<InterviewVO>> interviewMap = null;
		if (applicantList != null) {
			interviewMap = new HashMap<String, List<InterviewVO>>();
			for (ApplicantVO applicant : applicantList) {
				interviewMap.put(applicant.getApplicationId(),
						applicationService.getMyInterview(applicant.getApplicationId()));
			}
		}
		TeamSimpleVO teamInfo = null;
		try {
			teamInfo = teamService.getTeamSimple(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("teamInfo", teamInfo);
		result.put("applicantList", applicantList);
		result.put("interviewMap", interviewMap);

		return result;
	}
}
