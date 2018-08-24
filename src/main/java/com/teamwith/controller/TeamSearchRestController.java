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
import com.teamwith.util.Criteria;
import com.teamwith.vo.FaqVO;
import com.teamwith.vo.MemberSearchVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.RecruitVO;
import com.teamwith.vo.RequireSkillVO;
import com.teamwith.vo.TeamDetailVO;
import com.teamwith.vo.TeamRateVO;
import com.teamwith.vo.TeamSimpleVO;

@RestController
@RequestMapping(value = "/api/teamSearch")
public class TeamSearchRestController {
	@Inject
	TeamService teamService;
	@Inject
	ApplicationService applicationService;

	@ResponseBody
	@RequestMapping(value = "/recent", method = RequestMethod.GET)
	public List<TeamSimpleVO> recentTeamList(Criteria cri) throws Exception {
		if (cri == null) {
			cri = new Criteria();
		}
		return teamService.getRecentTeam(cri);
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<TeamSimpleVO> teamList(Criteria cri, String[] region, String[] project, String[] role, String[] skill,
			String textCondition, String keyword) throws Exception {
		if (cri == null) {
			cri = new Criteria();
		}
		if (region == null && project == null && role == null && skill == null
				&& (keyword == null || keyword.trim().equals(""))) {
			return recentTeamList(cri);
		}

		List<String> resultIdList = null;
		List<TeamSimpleVO> resultTeamList = new ArrayList<TeamSimpleVO>();
		List<String> teamIdListByRegion = null;
		List<String> teamIdListByRole = null;
		List<String> teamIdListByCategory = null;
		List<String> teamIdListBySkill = null;
		List<String> teamIdListByKeyword = null;

		if (region != null) {
			List<String> regionList = new ArrayList<String>();
			for (String regionStr : region) {
				regionList.add(regionStr);
			}
			cri.addCriteria("regionList", regionList);
			teamIdListByRegion = teamService.searchTeam(cri);
			if (teamIdListByRegion != null) {
				resultIdList = new ArrayList<String>();
				resultIdList.addAll(teamIdListByRegion);
			}
		}

		if (role != null) {
			List<String> roleList = new ArrayList<String>();
			for (String roleStr : role) {
				roleList.add(roleStr);
			}
			cri.addCriteria("roleList", roleList);
			teamIdListByRole = teamService.searchTeamDTO(cri);
			if (teamIdListByRole != null) {
				if (resultIdList == null) {
					resultIdList = new ArrayList<String>();
					for (String teamId : teamIdListByRole) {
						if (!resultIdList.contains(teamId)) {
							resultIdList.add(teamId);
						}
					}
				} else {
					for (int i = 0; i < resultIdList.size(); i++) {
						boolean flag = false;
						for (int j = 0; j < teamIdListByRole.size(); j++) {
							if (resultIdList.get(i).equals(teamIdListByRole.get(j))) {
								flag = true;
							}
						}
						if (flag == false) {
							resultIdList.set(i, "empty");
						}
					}
				}
			}
		}

		if (project != null) {
			List<String> projectCategoryList = new ArrayList<String>();
			for (String projectStr : project) {
				projectCategoryList.add(projectStr);
			}
			cri.addCriteria("projectCategoryList", projectCategoryList);
			teamIdListByCategory = teamService.searchTeam(cri);
			if (teamIdListByCategory != null) {
				if (resultIdList == null) {
					resultIdList = new ArrayList<String>();
					for (String teamId : teamIdListByCategory) {
						if (!resultIdList.contains(teamId)) {
							resultIdList.add(teamId);
						}
					}
				} else {
					for (int i = 0; i < resultIdList.size(); i++) {
						boolean flag = false;
						for (int j = 0; j < teamIdListByCategory.size(); j++) {
							if (resultIdList.get(i).equals(teamIdListByCategory.get(j))) {
								flag = true;
							}
						}
						if (flag == false) {
							resultIdList.set(i, "empty");
						}
					}
				}
			}
		}

		if (skill != null) {
			List<String> skillList = new ArrayList<String>();
			for (String skillStr : skill) {
				skillList.add(skillStr);
			}
			cri.addCriteria("skillList", skillList);
			teamIdListBySkill = teamService.searchTeamDTO(cri);
			if (teamIdListBySkill != null) {
				if (resultIdList == null) {
					resultIdList = new ArrayList<String>();
					for (String teamId : teamIdListBySkill) {
						if (!resultIdList.contains(teamId)) {
							resultIdList.add(teamId);
						}
					}
				} else {
					for (int i = 0; i < resultIdList.size(); i++) {
						boolean flag = false;
						for (int j = 0; j < teamIdListBySkill.size(); j++) {
							if (resultIdList.get(i).equals(teamIdListBySkill.get(j))) {
								flag = true;
							}
						}
						if (flag == false) {
							resultIdList.set(i, "empty");
						}
					}
				}
			}
		}

		if (keyword != null && !keyword.trim().equals("")) {

			cri.addCriteria("keyword", keyword.trim());
		}

		teamIdListByKeyword = teamService.searchTeamByKeyword(cri);

		if (teamIdListByKeyword != null) {
			if (resultIdList == null) {
				resultIdList = new ArrayList<String>();
				for (String teamId : teamIdListByKeyword) {
					if (!resultIdList.contains(teamId)) {
						resultIdList.add(teamId);
					}
				}
			} else {
				for (int i = 0; i < resultIdList.size(); i++) {
					boolean flag = false;
					for (int j = 0; j < teamIdListByKeyword.size(); j++) {
						if (resultIdList.get(i).equals(teamIdListByKeyword.get(j))) {
							flag = true;
						}
					}
					if (flag == false) {
						resultIdList.set(i, "empty");
					}
				}
			}
		}

		for (

		String resultId : resultIdList) {
			if (!resultId.equals("empty")) {
				TeamSimpleVO teamSimpleVO = teamService.getTeamSimple(resultId);
				if (teamSimpleVO != null) {
					resultTeamList.add(teamSimpleVO);
				}
			}
		}

		return resultTeamList;

	}

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
