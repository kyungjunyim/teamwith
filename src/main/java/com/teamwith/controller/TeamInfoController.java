//Writer : HWANG KYU JIN
package com.teamwith.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.teamwith.dto.InterviewQuestionDTO;
import com.teamwith.service.ApplicationService;
import com.teamwith.service.TeamService;
import com.teamwith.vo.ApplicantVO;
import com.teamwith.vo.FaqVO;
import com.teamwith.vo.InterviewVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.RecruitVO;
import com.teamwith.vo.RequireSkillVO;
import com.teamwith.vo.TeamDetailVO;
import com.teamwith.vo.TeamSimpleVO;

@Controller
@RequestMapping(value = "/teamInfo")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class TeamInfoController {
	@Inject
	private TeamService teamService;
	@Inject
	private ApplicationService applicationService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerTeamView(Model model) {
		return "teambuilding/jsp/teamRegister";
	}

	// 팀 등록시 모집을 등록할 개수만큼 먼저 추가하고 데이터를 입력해야합니다. 먼저 데이터 입력하고 추가하기를 누르면 첫 번재 모집 분야가
	// 사라집니다.
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerTeam(HttpSession session, TeamDetailVO teamInfo, String role1, String role2, String role3,
			String[] faqQuestions, String[] faqAnswers, String[] interviewQuestionContents, String[] skill1,
			String[] skill2, String[] skill3, String[] recruitPreferences, String[] recruitExplains,
			String[] recruitPeopleNum, MultipartFile teamPicFile) {
		String teamId = null;
		MemberSimpleVO login = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		String memberId = login.getMemberId();
		teamInfo.setMemberId(memberId);

		List<InterviewVO> interviewList = new ArrayList<InterviewVO>();
		for (String interview : interviewQuestionContents) {
			InterviewVO interviewQuestion = new InterviewVO();
			interviewQuestion.setInterviewQuestionContent(interview);
			interviewList.add(interviewQuestion);
		}

		List<FaqVO> faqList = new ArrayList<FaqVO>();
		for (int i = 0; i < faqQuestions.length; i++) {
			FaqVO faq = new FaqVO();
			faq.setFaqQuestion(faqQuestions[i]);
			faq.setFaqAnswer(faqAnswers[i]);
			faqList.add(faq);
		}

		List<RecruitVO> recruitList = new ArrayList<RecruitVO>();
		for (int i = 0; i < recruitPeopleNum.length; i++) {
			RecruitVO recruit = new RecruitVO();
			recruit.setRecruitPreference(recruitPreferences[i]);
			recruit.setRecruitExplain(recruitExplains[i]);
			recruit.setRecruitPeopleNum(recruitPeopleNum[i]);
			String role = null;
			switch (i) {
			case 0:
				role = role1;
				break;
			case 1:
				role = role2;
				break;
			case 2:
				role = role3;
				break;
			default:
				break;
			}
			if (role != null) {
				recruit.setRoleId(role);
			}
			recruitList.add(recruit);
		}

		List<RequireSkillVO> requireSkillList = new ArrayList<RequireSkillVO>();

		for (int i = 0; i < recruitPeopleNum.length; i++) {
			RequireSkillVO requireSkill = new RequireSkillVO();
			List<String> skillList = new ArrayList<String>();
			String[] skills = null;
			switch (i) {
			case 0:
				skills = skill1;
				break;
			case 1:
				skills = skill2;
				break;
			case 2:
				skills = skill3;
				break;
			default:
				break;
			}
			for (String skill : skills) {
				skillList.add(skill);
			}
			requireSkill.setSkillIds(skillList);
			requireSkillList.add(requireSkill);
		}
		String path = session.getServletContext().getRealPath("/") + "resources\\image\\team\\";
		try {
			teamId = teamService.registerTeam(applicationService, teamInfo, teamPicFile.getBytes(), path, interviewList,
					faqList, recruitList, requireSkillList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/teamSearch/" + teamId.substring(5);
	}

	@RequestMapping(value = "/applicant/{teamId}", method = RequestMethod.GET)
	public String showApplicant(@PathVariable("teamId") String teamId, Model model) {
		String key = "team-" + teamId;
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
		model.addAttribute("teamInfo", teamInfo);
		model.addAttribute("applicantList", applicantList);
		model.addAttribute("interviewMap", interviewMap);

		return "teambuilding/jsp/myApplicant";
	}

	@RequestMapping(value = "/edit/{teamId}", method = RequestMethod.GET)
	public String updateTeamView(@PathVariable("teamId") String teamId, Model model) {
		String key = "team-" + teamId;

		try {
			TeamDetailVO teamInfo = teamService.getTeamInfo(key);
			model.addAttribute("teamInfo", teamInfo);
			List<FaqVO> faqList = teamService.getFaq(key);
			model.addAttribute("faqList", faqList);
			List<InterviewQuestionDTO> interviewList = applicationService.getInterviewQuestion(key);
			model.addAttribute("interviewList", interviewList);
			List<RecruitVO> recruitList = teamService.getRecruitInfo(key);
			model.addAttribute("recruitList", recruitList);
			List<RequireSkillVO> requireSkillList = new ArrayList<RequireSkillVO>();

			for (RecruitVO recruitVO : recruitList) {
				String recruitId = recruitVO.getRecruitId();
				RequireSkillVO requireSkillVO = teamService.getRequireSkillsKyu(recruitId);
				requireSkillList.add(requireSkillVO);
			}
			model.addAttribute("requireSkillList", requireSkillList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "teambuilding/jsp/teamUpdate";
	}

	@RequestMapping(value = "/edit/{teamId}", method = RequestMethod.POST)
	public String updateTeam(HttpSession session, @PathVariable("teamId") String teamId, TeamDetailVO teamInfo,
			String role1, String role2, String role3, String[] faqQuestions, String[] faqAnswers,
			String[] interviewQuestionContents, String[] skill1, String[] skill2, String[] skill3,
			String[] recruitPreferences, String[] recruitExplains, String[] recruitPeopleNum, String[] faqIds,
			String[] recruitIds, MultipartFile teamPicFile) {
		String key = "team-" + teamId;
		String path = session.getServletContext().getRealPath("/") + "resources\\image\\team\\";

		List<InterviewVO> interviewList = new ArrayList<InterviewVO>();
		for (String interview : interviewQuestionContents) {
			InterviewVO interviewQuestion = new InterviewVO();
			interviewQuestion.setInterviewQuestionContent(interview);
			interviewQuestion.setTeamId(key);
			interviewList.add(interviewQuestion);
		}

		List<FaqVO> faqList = new ArrayList<FaqVO>();
		for (int i = 0; i < faqQuestions.length; i++) {
			FaqVO faq = new FaqVO();
			faq.setFaqQuestion(faqQuestions[i]);
			faq.setFaqAnswer(faqAnswers[i]);
			faq.setTeamId(key);
			faq.setFaqId(faqIds[i]);
			faqList.add(faq);
		}

		List<RecruitVO> recruitList = new ArrayList<RecruitVO>();
		for (int i = 0; i < recruitPeopleNum.length; i++) {
			RecruitVO recruit = new RecruitVO();
			recruit.setRecruitPreference(recruitPreferences[i]);
			recruit.setRecruitExplain(recruitExplains[i]);
			recruit.setRecruitPeopleNum(recruitPeopleNum[i]);
			recruit.setTeamId(key);
			String role = null;
			switch (i) {
			case 0:
				role = role1;
				break;
			case 1:
				role = role2;
				break;
			case 2:
				role = role3;
				break;
			default:
				break;
			}
			if (role != null) {
				recruit.setRoleId(role);
			}
			recruitList.add(recruit);
		}

		List<RequireSkillVO> requireSkillList = new ArrayList<RequireSkillVO>();

		for (int i = 0; i < recruitPeopleNum.length; i++) {
			RequireSkillVO requireSkill = new RequireSkillVO();
			List<String> skillList = new ArrayList<String>();
			String[] skills = null;
			switch (i) {
			case 0:
				skills = skill1;
				break;
			case 1:
				skills = skill2;
				break;
			case 2:
				skills = skill3;
				break;
			default:
				break;
			}
			for (String skill : skills) {
				skillList.add(skill);
			}
			requireSkill.setSkillIds(skillList);
			requireSkillList.add(requireSkill);
		}
		teamInfo.setTeamId(key);
		try {
			teamService.updateTeam(applicationService, teamInfo, teamPicFile.getBytes(), path, interviewList, faqList,
					recruitList, requireSkillList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/teamSearch/" + teamId;
	}

}
