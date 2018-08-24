package com.teamwith.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.service.ApplicationService;
import com.teamwith.vo.ApplicationVO;
import com.teamwith.vo.InterviewVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MyApplicationVO;


@RestController
@RequestMapping("/api/application")
public class ApplicationRestController {
	@Inject
	private ApplicationService applicationService;
	@Inject
	private MemberSimpleVO memberSimpleVO;

	@RequestMapping(value = "/apply/{teamId}", method = RequestMethod.POST)
	public Boolean apply(@PathVariable("teamId") String teamId, HttpSession session, String[] interviewAnswer,
			String[] interviewQuestionId, String applicationFreewriting, String roleId) {
		memberSimpleVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		teamId = "team-" + teamId;

		ApplicationVO applicationVO = new ApplicationVO();
		applicationVO.setMemberId(memberSimpleVO.getMemberId());
		applicationVO.setApplicationStatus("0");
		applicationVO.setApplicationFreewriting(applicationFreewriting);
		applicationVO.setTeamId(teamId);
		applicationVO.setRoleId(roleId);

		List<InterviewVO> interviewAnswerList = new ArrayList<InterviewVO>();
		if (interviewAnswer != null) {
			for (int i = 0; i < interviewAnswer.length; i++) {
				InterviewVO interviewVO = new InterviewVO();
				interviewVO.setTeamId(teamId);
				interviewVO.setInterviewAnswerContent(interviewAnswer[i]);
				interviewVO.setInterviewQuestionId(interviewQuestionId[i]);
				interviewAnswerList.add(interviewVO);
			}
		}

		applicationService.applyTeam(applicationVO, interviewAnswerList);

		return true;
	}

}
