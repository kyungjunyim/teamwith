//Writer : HWANG KYU JIN
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
import com.teamwith.util.Criteria;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MyApplicationVO;
import com.teamwith.vo.TeamSimpleVO;

@RestController
@RequestMapping(value = "/api/team", method = { RequestMethod.GET, RequestMethod.POST })
public class TeamRestController {
	@Inject
	private TeamService teamService;
	@Inject
	private ApplicationService applicationService;

	@RequestMapping(value = "myTeam", method = RequestMethod.GET)
	public HashMap<String, Object> myTeam(Criteria cri, HttpSession session) {
		List<TeamSimpleVO> myTeamList = null;
		HashMap<String, Object> result = new HashMap<String, Object>();

		MemberSimpleVO login=(MemberSimpleVO)session.getAttribute("memberSimpleVO");
		
		try {
			myTeamList = teamService.getMyTeam(cri, login.getMemberId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("myTeamList", myTeamList);
		return result;
	}
	
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
	
	public Map<String, Object> myApplicationList(HttpSession session) {
		Map<String, Object> myApplicationList = new HashMap<String, Object>();
		MemberSimpleVO memberSimpleVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		String memberId = memberSimpleVO.getMemberId();
		
		// 나의 지원 목록 가져오기
		List<MyApplicationVO> myApplication = applicationService.getMyApplication(memberId);
		
		myApplicationList.put("myApplicationList", myApplication);

		return myApplicationList;
	}

	@RequestMapping(value = "myHistory", method = RequestMethod.GET)
	public HashMap<String, Object> myHistory(Criteria cri, HttpSession session) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		HashMap<String, Object> myTeamList = myTeam(cri, session);
		Map<String, Object> myJoinedTeamList = joinedTeam(session);
		Map<String, Object> myApplicationList = myApplicationList(session);
		
		result.put("myTeamList", myTeamList.get("myTeamList"));
		result.put("myJoinedTeamList", myJoinedTeamList.get("joinedTeamList"));
		result.put("myApplicationList", myApplicationList.get("myApplicationList"));
		
		return result;
	}
}
