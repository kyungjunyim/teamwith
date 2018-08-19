//Writer : HWANG KYU JIN
package com.teamwith.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
@MultipartConfig(maxFileSize=1024*1024*10)
public class TeamInfoController {
	@Inject
	private TeamService teamService;
	@Inject
	private ApplicationService applicationService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerTeamView(Model model) {
		return "teambuilding/jsp/teamRegister";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerTeam(HttpSession session, TeamDetailVO teamInfo, String role1, String role2, String role3,
			String[] faqQuestions, String[] faqAnswers, String[] interviewQuestionContents, String[] skill1,
			String[] skill2, String[] skill3, String[] recruitPreferences, String[] recruitExplains,
			String[] recruitPeopleNum, MultipartFile teamPicFile) {
		String teamId=null;
		MemberSimpleVO login=(MemberSimpleVO)session.getAttribute("memberSimpleVO");
		String memberId=login.getMemberId();
		try {
			teamInfo.setMemberId(memberId);
			
			if (teamPicFile != null && !teamPicFile.getOriginalFilename().trim().equals("")) {
				String rootPath = session.getServletContext().getRealPath("/");
				String attachPath = "resources\\image\\member\\" + memberId;
				String filename = teamPicFile.getOriginalFilename();
				String newFilename = uploadFile(rootPath, attachPath, filename, teamPicFile.getBytes());
				teamInfo.setTeamPic(newFilename);
			}
			
			String path=session.getServletContext().getRealPath("/")+"resources\\image\\team\\";
			teamId = teamService.registerTeam(teamInfo,teamPicFile.getBytes(),path);
			
			List<InterviewVO> interviewList = new ArrayList<InterviewVO>();
			for (String interview : interviewQuestionContents) {
				InterviewVO interviewQuestion = new InterviewVO();
				interviewQuestion.setInterviewQuestionContent(interview);
				interviewQuestion.setTeamId(teamId);
				interviewList.add(interviewQuestion);
			}
			applicationService.registerInteviewQuestion(interviewList);

			List<FaqVO> faqList = new ArrayList<FaqVO>();
			for (int i = 0; i < faqQuestions.length; i++) {
				FaqVO faq = new FaqVO();
				faq.setFaqQuestion(faqQuestions[i]);
				faq.setFaqAnswer(faqAnswers[i]);
				faq.setTeamId(teamId);
				faqList.add(faq);
			}
			teamService.registerFaq(faqList);

			List<RecruitVO> recruitList = new ArrayList<RecruitVO>();
			for (int i = 0; i < recruitPeopleNum.length; i++) {
				RecruitVO recruit = new RecruitVO();
				recruit.setRecruitPreference(recruitPreferences[i]);
				recruit.setRecruitExplain(recruitExplains[i]);
				recruit.setRecruitPeopleNum(recruitPeopleNum[i]);
				recruit.setTeamId(teamId);
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
			List<String> recruitIds=teamService.registerRecruit(recruitList);

			for(int i=0;i<recruitIds.size();i++) {
				RequireSkillVO requireSkill=new RequireSkillVO();
				requireSkill.setRecruitId(recruitIds.get(i));
				List<String> skillList=new ArrayList<String>();
				String[] skills=null;
				switch(i) {
					case 0:
						skills=skill1;
						break;
					case 1:
						skills=skill2;
						break;
					case 2:
						skills=skill3;
						break;
					default:
						break;
				}
				for(String skill: skills) {
					skillList.add(skill);
				}
				requireSkill.setSkillIds(skillList);
				teamService.registerRequireSkill(requireSkill);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/teamSearch/"+teamId.substring(5);
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
	
	private String uploadFile(String uploadPath, String attachPath, String originalName, byte[] fileData)
			throws Exception {
		String newFilename = attachPath + getNewFilename(originalName);

		File dir = new File(uploadPath);
		if (!dir.exists()) {
			dir.mkdirs(); // 존재하지 않는 모든 폴더 생성
		}
		File target = new File(uploadPath, newFilename);
		FileCopyUtils.copy(fileData, target);
		return "\\" + newFilename;
	}

	private String getNewFilename(String filename) {
		if (filename.contains(".")) {
			return filename.substring(filename.indexOf('.'));
		}
		return null;
	}
}
