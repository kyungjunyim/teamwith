package com.teamwith.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@ResponseBody
	@RequestMapping(value = "/myApplication", method = RequestMethod.GET)
	public Map<String, Object> myApplication(HttpSession session) {
		memberSimpleVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		String memberId = memberSimpleVO.getMemberId();
		Map<String, Object> result = new HashMap<String, Object>();

		// 나의 지원 목록 가져오기
		List<MyApplicationVO> myApplicationList = applicationService.getMyApplication(memberId);
		result.put("myApplicationList", myApplicationList);

		// 지원 별로 인터뷰 목록 가져오기
		Map<String, List<InterviewVO>> interviewMap = new HashMap<String, List<InterviewVO>>();
		for (MyApplicationVO myApplication : myApplicationList) {
			List<InterviewVO> interviewVOList = applicationService.getMyInterview(myApplication.getApplicationId());
			interviewMap.put(myApplication.getApplicationId(), interviewVOList);
		}
		result.put("interviewMap", interviewMap);

		return result;

	}

	@RequestMapping(value = "/cancel/{applicationId}", method = RequestMethod.GET)
	public String cancel(@PathVariable("applicationId") String applicationId, HttpSession session) {
		System.out.println("취소하러 왓냐");
		memberSimpleVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		String memberId = memberSimpleVO.getMemberId();
		for (MyApplicationVO a : applicationService.getMyApplication(memberId)) {
			if (a.getApplicationId().equals(applicationId)) {
				applicationService.changeApplicationStatus(3, applicationId);
				return "\"result\":\"true\"";
			}
		}

		return "\"result\":\"false\"";
	}

	@RequestMapping(value = "/apply/{teamId}", method = RequestMethod.POST)
	public Boolean apply(@PathVariable("teamId") String teamId, @RequestBody Map<String, Object> param,
			HttpSession session) {
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
