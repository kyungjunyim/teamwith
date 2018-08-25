package com.teamwith.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.service.ApplicationService;
import com.teamwith.vo.ApplicationVO;
import com.teamwith.vo.InterviewVO;
import com.teamwith.vo.MemberSimpleVO;

@RestController
@RequestMapping("/api/application")
public class ApplicationRestController {
	@Inject
	private ApplicationService applicationService;
	@Inject
	private MemberSimpleVO memberSimpleVO;

	@RequestMapping(value = "/apply/{teamId}", method = RequestMethod.POST)
	public Boolean apply(@PathVariable("teamId") String teamId, @RequestBody Map<String, Object> param, HttpSession session) {
		memberSimpleVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		String roleId = (String) param.get("roleId");
		String applicationFreewriting = (String) param.get("applicationFreewriting");
		List<String> interviewQuestionId = (List<String>) param.get("interviewQuestionId");
		List<String> interviewAnswer = (List<String>) param.get("interviewAnswer");
		teamId = "team-" + teamId;
		ApplicationVO applicationVO = new ApplicationVO();
		applicationVO.setMemberId(memberSimpleVO.getMemberId());
		applicationVO.setApplicationStatus("0");
		applicationVO.setApplicationFreewriting(applicationFreewriting);
		applicationVO.setTeamId(teamId);
		applicationVO.setRoleId(roleId);

		List<InterviewVO> interviewAnswerList = new ArrayList<InterviewVO>();
		if (interviewAnswer != null) {
			for (int i = 0; i < interviewAnswer.size(); i++) {
				InterviewVO interviewVO = new InterviewVO();
				interviewVO.setTeamId(teamId);
				interviewVO.setInterviewAnswerContent(interviewAnswer.get(i));
				interviewVO.setInterviewQuestionId(interviewQuestionId.get(i));
				interviewAnswerList.add(interviewVO);
			}
		}

		applicationService.applyTeam(applicationVO, interviewAnswerList);

		return true;
	}

}
