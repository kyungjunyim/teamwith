//Writer : HWANG KYU JIN
package com.teamwith.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.ApplicationService;
import com.teamwith.service.TeamService;
import com.teamwith.vo.ApplicantVO;
import com.teamwith.vo.InterviewVO;
import com.teamwith.vo.TeamDetailVO;
import com.teamwith.vo.TeamSimpleVO;

@Controller
@RequestMapping(value="/teamInfo")
public class TeamInfoController {
	@Inject
	private TeamService teamService;
	@Inject
	private ApplicationService applicationService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerTeamView(Model model) {
		return "teambuilding/jsp/teamRegister";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerTeam(HttpSession session,TeamDetailVO teamInfo,String[] faqQuestions,String[] faqAnswers,String[] interviewQuestionContents,String[] skill1,String[] skill2,String[] skill3,String[] recruitPreferencecs,String[] recruitExplains, String[] recruitPeopleNum) {
		//		teamService.registerTeam(teamInfo, file);
		return null;
	}
	
	@RequestMapping(value="/applicant/{teamId}",method=RequestMethod.GET)
	public String showApplicant(@PathVariable("teamId") String teamId,Model model) {
		String key="team-"+teamId;
		List<ApplicantVO> applicantList=applicationService.getApplicant(key);
		
		Map<String, List<InterviewVO>> interviewMap = null;
		if(applicantList != null) {
			interviewMap = new HashMap<String, List<InterviewVO>>();
			for(ApplicantVO applicant : applicantList) {
				interviewMap.put(applicant.getApplicationId(), applicationService.getMyInterview(applicant.getApplicationId()));
			}
		}
		
		TeamSimpleVO teamInfo = null;
		try {
			teamInfo = teamService.getTeamSimple(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("teamInfo",teamInfo);
		model.addAttribute("applicantList",applicantList);
		model.addAttribute("interviewMap",interviewMap);
		
		return "teambuilding/jsp/myApplicant";
	}
}
