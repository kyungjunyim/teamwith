package com.teamwith.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.service.ApplicationService;
import com.teamwith.service.TeamService;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.TeamSimpleVO;

@RestController
@RequestMapping("/api/teamInfo")
public class TeamInfoRestController {
	@Inject
	private TeamService teamService;
	@Inject
	private ApplicationService applicationService;

	@RequestMapping(value = "joinedTeam", method = RequestMethod.GET)
	public Map<String, Object> joinedTeam(HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		MemberSimpleVO login = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
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
}
