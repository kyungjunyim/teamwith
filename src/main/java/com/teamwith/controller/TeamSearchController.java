package com.teamwith.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.dto.InterviewQuestionDTO;
import com.teamwith.service.ApplicationService;
import com.teamwith.service.MemberService;
import com.teamwith.service.TeamService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.FaqVO;
import com.teamwith.vo.MemberRateVO;
import com.teamwith.vo.MemberSearchVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MemberSkillVO;
import com.teamwith.vo.RecruitVO;
import com.teamwith.vo.RequireSkillVO;
import com.teamwith.vo.TeamDetailVO;
import com.teamwith.vo.TeamRateVO;
import com.teamwith.vo.TeamSimpleVO;

@RequestMapping("/teamSearch")

@Controller
public class TeamSearchController {
	@Inject
	private TeamService teamService;
	@Inject
	private MemberService memberService;
	@Inject
	private ApplicationService applicationService;
	@Inject
	private MemberSimpleVO memberSimpleVO;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String teamSearch(HttpSession session, Model model) throws Exception {
		memberSimpleVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");

		List<TeamSimpleVO> recentTeamList = setRecentTeam();
		model.addAttribute("recentTeamList", recentTeamList);

		if (memberSimpleVO != null) {
			List<TeamRateVO> resultList = recommendTeam();
			model.addAttribute("recommendedTeamList", resultList);
		}
		model.addAttribute("isSearch", "false");
		return "teambuilding/jsp/teamSearch";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String teamSearch(HttpSession session, Model model, String[] region, String[] project, String[] role,
			String[] skill, String textCondition, String keyword) throws Exception {
		if (region == null && project == null && role == null && skill == null
				&& (keyword == null || keyword.trim().equals(""))) {
			return teamSearch(session, model);
		} else {
			model.addAttribute("isSearch", "true");
			model.addAttribute("recentTeamList", null);
			model.addAttribute("recommendedTeamList", null);
			List<String> resultIdList = null;
			List<TeamSimpleVO> resultTeamList = new ArrayList<TeamSimpleVO>();
			List<String> teamIdListByRegion = null;
			List<String> teamIdListByRole = null;
			List<String> teamIdListByCategory = null;
			List<String> teamIdListBySkill = null;
			List<String> teamIdListByKeyword = null;

			if (region != null) {
				Criteria regionCri = new Criteria();
				List<String> regionList = new ArrayList<String>();
				for (String regionStr : region) {
					regionList.add(regionStr);
				}
				regionCri.addCriteria("regionList", regionList);
				teamIdListByRegion = teamService.searchTeam(regionCri);
				if (teamIdListByRegion != null) {
					resultIdList = new ArrayList<String>();
					resultIdList.addAll(teamIdListByRegion);
				}
			}
			else {
				teamIdListByRegion = teamService.getTeamId();
				if (teamIdListByRegion != null) {
					resultIdList = new ArrayList<String>();
					resultIdList.addAll(teamIdListByRegion);
				}
			}

			if (role != null) {
				Criteria roleCri = new Criteria();
				List<String> roleList = new ArrayList<String>();
				for (String roleStr : role) {
					roleList.add(roleStr);
				}
				roleCri.addCriteria("roleList", roleList);
				teamIdListByRole = teamService.searchTeamDTO(roleCri);
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
				Criteria projectCri = new Criteria();
				List<String> projectCategoryList = new ArrayList<String>();
				for (String projectStr : project) {
					projectCategoryList.add(projectStr);
				}
				projectCri.addCriteria("projectCategoryList", projectCategoryList);
				teamIdListByCategory = teamService.searchTeam(projectCri);
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
				Criteria skillCri = new Criteria();
				skillCri.addCriteria("skillList", skillList);
				teamIdListBySkill = teamService.searchTeamDTO(skillCri);
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
				Criteria textCri = new Criteria();
				switch (textCondition) {
				case "teamName":
					textCri.addCriteria("teamName", keyword.trim());
					break;
				case "teamProjectName":
					textCri.addCriteria("teamProjectName", keyword.trim());
					break;
				case "teamContestName":
					textCri.addCriteria("teamContestName", keyword.trim());
					break;
				}
				teamIdListByKeyword = teamService.searchTeam(textCri);

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
			}

			for (String resultId : resultIdList) {
				if (!resultId.equals("empty")) {
					TeamSimpleVO teamSimpleVO = teamService.getTeamSimple(resultId);
					resultTeamList.add(teamSimpleVO);
				}
			}
			
			model.addAttribute("resultTeamList", resultTeamList);
			return "teambuilding/jsp/teamSearch";
		}

	}

	@RequestMapping(value = "{teamId}", method = RequestMethod.GET)
	public String teamSearch(@PathVariable("teamId") String teamId, HttpSession session, Model model) throws Exception {
		memberSimpleVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		teamId = "team-" + teamId;

		boolean canApply = true;
		TeamDetailVO teamInfo = teamService.getTeamInfo(teamId);
		model.addAttribute("teamInfo", teamInfo);

		List<RecruitVO> recruitInfo = teamService.getRecruitInfo(teamId);
		model.addAttribute("recruitInfo", recruitInfo);

		List<InterviewQuestionDTO> interviewInfo = applicationService.getInterviewQuestion(teamId);
		model.addAttribute("interviewInfo", interviewInfo);

		List<MemberSearchVO> teamMembers = applicationService.getTeamMember(teamId);
		model.addAttribute("teamMembers", teamMembers);

		// =================================================
		List<MemberRateVO> recommendedMemberList = getRecommendedMember(teamId);
		model.addAttribute("recommendedMemberList", recommendedMemberList);
		// =================================================

		List<RequireSkillVO> requireSkills = new ArrayList<RequireSkillVO>();
		if (recruitInfo != null) {
			for (RecruitVO recruit : recruitInfo) {
				requireSkills.addAll(teamService.getRequireSkills(recruit.getRecruitId()));
			}
		}
		model.addAttribute("requireSkills", requireSkills);

		if (teamMembers != null) {
			for (MemberSearchVO teamMember : teamMembers) {
				if (memberSimpleVO == null || teamMember.getMemberId().equals(memberSimpleVO.getMemberId())) {
					canApply = false;
				}
			}
		}

		if (memberSimpleVO == null) {
			canApply = false;
		}

		model.addAttribute("canApply", canApply);

		List<FaqVO> faqInfo = teamService.getFaq(teamId);
		model.addAttribute("faqInfo", faqInfo);

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
		model.addAttribute("dDay", dDay);

		return "teambuilding/jsp/teamDetail";
	}

	private List<MemberRateVO> getRecommendedMember(String teamId) throws Exception {
		int skillCnt = 0;
		List<String> teamRegionIdList = new ArrayList<String>();
		List<String> teamCategoryIdList = new ArrayList<String>();
		List<String> teamRoleIdList = new ArrayList<String>();
		List<String> teamSkillIdList = new ArrayList<String>();
		Map<String, Double> unsortedMemberList = new HashMap<String, Double>();
		Map<String, Double> sortedMemberList = new HashMap<String, Double>();
		List<MemberRateVO> recommendedMemberList = new ArrayList<MemberRateVO>();

		// 팀 정보들을 불러오기
		TeamDetailVO teamDetailVO = teamService.getTeamInfo(teamId);
		List<RecruitVO> recruitVOs = teamService.getRecruitInfo(teamId);
		teamRegionIdList.add(teamDetailVO.getRegionId());
		teamCategoryIdList.add(teamDetailVO.getProjectCategoryId());
		for (RecruitVO recruitVO : recruitVOs) {
			if (!teamRoleIdList.contains(recruitVO.getRoleId())) {
				teamRoleIdList.add(recruitVO.getRoleId());
			}
			List<RequireSkillVO> requireSkillVOs = teamService.getRequireSkills(recruitVO.getRecruitId());
			for (RequireSkillVO requireSkillVO : requireSkillVOs) {
				for (String skillId : requireSkillVO.getSkillIds()) {
					if (!teamSkillIdList.contains(skillId)) {
						teamSkillIdList.add(skillId);
					}
				}
			}
		}
		skillCnt = teamSkillIdList.size();

		// 지역을 기준으로 멤버 찾기
		Criteria regionCri = new Criteria(1, 100);
		regionCri.addCriteria("regionList", teamRegionIdList);
		List<MemberSimpleVO> memberSimpleVOs = memberService.getMemberByRoleRegion(regionCri);
		for (MemberSimpleVO memberSimpleVO : memberSimpleVOs) {
			if (!unsortedMemberList.containsKey(memberSimpleVO.getMemberId())) {
				unsortedMemberList.put(memberSimpleVO.getMemberId(), 1.0);
			}
		}

		// 카테고리를 기준으로 멤버 찾기
		List<String> memberIdListByCategory = memberService.getMemberByProjectCategoryId(teamCategoryIdList);
		for (String memberId : memberIdListByCategory) {
			if (unsortedMemberList.containsKey(memberId)) {
				Double temp = unsortedMemberList.get(memberId);
				unsortedMemberList.put(memberId, temp + 1.0);
			}
		}

		// 역할을 기준으로 멤버 찾기
		Criteria roleCri = new Criteria(1, 100);
		roleCri.addCriteria("roleList", teamRoleIdList);
		memberSimpleVOs.clear();
		memberSimpleVOs = memberService.getMemberByRoleRegion(roleCri);
		for (MemberSimpleVO memberSimpleVO : memberSimpleVOs) {
			if (unsortedMemberList.containsKey(memberSimpleVO.getMemberId())) {
				Double temp = unsortedMemberList.get(memberSimpleVO.getMemberId());
				unsortedMemberList.put(memberSimpleVO.getMemberId(), temp + 1.0);
			}
		}
		
		// 기술을 기준으로 멤버 찾기
		List<String> memberIdListBySkill = memberService.getMemberBySkillId(teamSkillIdList);
		Map<String, Double> tempSkillMap = new HashMap<String, Double>();
		for (String memberId : memberIdListBySkill) {
			if (tempSkillMap.containsKey(memberId)) {
				Double temp = tempSkillMap.get(memberId);
				tempSkillMap.put(memberId, temp + 1.0);
			} else {
				tempSkillMap.put(memberId, 1.0);
			}
		}
		Iterator<String> skillIterator = tempSkillMap.keySet().iterator();
		while(skillIterator.hasNext()) {
			String memberId = skillIterator.next();
			if(unsortedMemberList.containsKey(memberId)) {
				Double temp = unsortedMemberList.get(memberId);
				temp = temp + (tempSkillMap.get(memberId) / skillCnt);
				unsortedMemberList.put(memberId, temp);
			}
		}
		
		// 일치율을 기준으로 정렬하기
		sortedMemberList = sortByComparator(unsortedMemberList);
		
		// 회원 정보를 저장하기
		Iterator<String> sortIterator = sortedMemberList.keySet().iterator();
		int iteratorCnt = 0;
		while(sortIterator.hasNext()) {
			if(iteratorCnt >= 5) break;
			iteratorCnt++;
			String memberId = sortIterator.next();
			MemberSearchVO memberSearchVO = memberService.getMemberSearchInfo(memberId);
			MemberRateVO memberRateVO = new MemberRateVO();
			
			memberRateVO.setMemberId(memberSearchVO.getMemberId());
			memberRateVO.setMemberName(memberSearchVO.getMemberName());
			memberRateVO.setRoleId(memberSearchVO.getRoleId());
			memberRateVO.setMemberPic(memberSearchVO.getMemberPic());
			memberRateVO.setRate(sortedMemberList.get(memberId) / 4 * 100);
			
			recommendedMemberList.add(memberRateVO);
		}
		
		return recommendedMemberList;
	}

	private List<TeamSimpleVO> setRecentTeam() throws Exception {
		Criteria teamCri = new Criteria();
		return teamService.getRecentTeam(teamCri);
	}

	private List<TeamRateVO> recommendTeam() throws Exception {
		String memberId = memberSimpleVO.getMemberId();
		Map<String, Double> resultMap = new HashMap<String, Double>();
		List<String> teamIdListByRegion = null;
		List<String> teamIdListByRole = null;
		List<String> teamIdListByCategory = null;
		List<String> teamIdListBySkill = null;

		MemberSearchVO memberSearchVO = memberService.getMemberSearchInfo(memberId);
		List<String> memberProjectCategories = memberService.getMemberProjectCategory(memberId);
		MemberSkillVO memberSkillVO = memberService.getMemberSkill(memberId);

		String memberRole = memberSearchVO.getRoleId();
		String memberRegion1 = memberSearchVO.getRegionId1();
		String memberRegion2 = memberSearchVO.getRegionId2();

		Criteria regionCri = new Criteria();
		List<String> regionList = new ArrayList<String>();
		regionList.add(memberRegion1);
		regionList.add(memberRegion2);
		regionCri.addCriteria("regionList", regionList);

		teamIdListByRegion = teamService.searchTeam(regionCri);

		if (teamIdListByRegion == null) {
			return null;
		} else {
			for (String teamId : teamIdListByRegion) {
				if (resultMap.get(teamId) != null) {
					Double temp = resultMap.get(teamId);
					resultMap.put(teamId, temp + 1.0);
				} else {
					resultMap.put(teamId, 1.0);
				}
			}
		}
		
		Criteria categoryCri = new Criteria();
		if(memberProjectCategories.size() != 0) {
			categoryCri.addCriteria("projectCategoryList", memberProjectCategories);
			teamIdListByCategory = teamService.searchTeam(categoryCri);
		}

		if (teamIdListByCategory != null) {
			for (String teamId : teamIdListByCategory) {
				if (resultMap.get(teamId) == null) {
					continue;
				} else {
					Double temp = resultMap.get(teamId);
					resultMap.put(teamId, temp + 1.0);
				}
			}
		}

		List<String> roleList = new ArrayList<String>();
		roleList.add(memberRole);
		Criteria roleCri = new Criteria();
		roleCri.addCriteria("roleList", roleList);

		teamIdListByRole = teamService.searchTeamDTO(roleCri);

		if (teamIdListByRole != null) {
			for (String teamId : teamIdListByRole) {
				if (resultMap.get(teamId) == null) {
					continue;
				} else {
					Double temp = resultMap.get(teamId);
					if (temp < 3.0) {
						resultMap.put(teamId, temp + 1.0);
					}
				}
			}
		}

		List<String> skillList = new ArrayList<String>();
		String[] skillMap = memberSkillVO.getSkill();
		if (skillMap != null) {
			for (String skill : skillMap) {
				skillList.add(skill);
			}

			int skillSize = skillList.size();

			Criteria skillCri = new Criteria();
			skillCri.addCriteria("skillList", skillList);

			teamIdListBySkill = teamService.searchTeamDTO(skillCri);

			if (teamIdListBySkill != null) {
				Map<String, Integer> countMap = new HashMap<String, Integer>();
				for (String teamId : teamIdListBySkill) {
					if (countMap.get(teamId) == null) {
						countMap.put(teamId, 1);
					} else {
						int temp = countMap.get(teamId);
						temp += 1;
						countMap.put(teamId, temp);
					}
				}

				Iterator<String> skillIterator = countMap.keySet().iterator();
				while (skillIterator.hasNext()) {
					String key = skillIterator.next();
					if (resultMap.get(key) != null) {
						double temp = resultMap.get(key);
						temp += (double) countMap.get(key) / (double) skillSize;
						resultMap.put(key, temp);
					}
				}
			}
		}
		List<String> resultTeamId = new ArrayList<String>();
		Iterator<String> resultIterator = resultMap.keySet().iterator();
		while (resultIterator.hasNext()) {
			String key = resultIterator.next();
			double temp = resultMap.get(key);
			temp = temp / 4 * 100;
			resultMap.put(key, temp);
			resultTeamId.add(key);
		}

		Map<String, Double> sortedMap = sortByComparator(resultMap);
		List<TeamRateVO> resultList = new ArrayList<TeamRateVO>();

		Iterator<String> sortedIterator = sortedMap.keySet().iterator();
		while (sortedIterator.hasNext()) {
			String key = sortedIterator.next();
			TeamSimpleVO tempTeamSimpleVO = null;
			try {
				tempTeamSimpleVO = teamService.getTeamSimple(key);
			} catch (Exception e) {
				e.printStackTrace();
			}
			TeamRateVO teamRateVO = new TeamRateVO();

			teamRateVO.setTeamId(tempTeamSimpleVO.getTeamId());
			teamRateVO.setTeamPic(tempTeamSimpleVO.getTeamPic());
			teamRateVO.setTeamProjectName(tempTeamSimpleVO.getTeamProjectName());
			teamRateVO.setProjectCategoryId(tempTeamSimpleVO.getProjectCategoryId());
			teamRateVO.setTeamName(tempTeamSimpleVO.getTeamName());
			teamRateVO.setTeamEndDate(tempTeamSimpleVO.getTeamEndDate());
			teamRateVO.setTeamUpdateDate(tempTeamSimpleVO.getTeamUpdateDate());
			teamRateVO.setMemberId(tempTeamSimpleVO.getMemberId());
			teamRateVO.setMemberName(tempTeamSimpleVO.getMemberName());
			teamRateVO.setRate(sortedMap.get(key));

			resultList.add(teamRateVO);
		}

		return resultList;

	}

	private static Map<String, Double> sortByComparator(Map<String, Double> unsortMap) {

		List<Entry<String, Double>> list = new LinkedList<Entry<String, Double>>(unsortMap.entrySet());

		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<String, Double>>() {
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		// Maintaining insertion order with the help of LinkedList
		Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
		for (Entry<String, Double> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
}
