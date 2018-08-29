package com.teamwith.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.MemberService;
import com.teamwith.vo.Criteria;
import com.teamwith.vo.MemberSearchVO;

@RequestMapping("/member")
@Controller
public class MemberController {
	@Inject
	private MemberService memberService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String member(Model model) throws Exception {
		List<MemberSearchVO> bestMemberList = memberService.getBestMember(new Criteria());
		model.addAttribute("bestMemberList", bestMemberList);

		List<MemberSearchVO> recentMemberList = memberService.getRecentMember(new Criteria(1, 8));
		model.addAttribute("recentMemberList", recentMemberList);

		return "teambuilding/jsp/searchMember";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String member(Model model, String[] region, String[] project, String[] role, String[] skill,
			String textCondition, String keyword) throws Exception {
		if (region == null && project == null && role == null && skill == null
				&& (keyword == null || keyword.trim().equals(""))) {
			return member(model);
		} else {
			model.addAttribute("recentTeamList", null);
			model.addAttribute("recommendedTeamList", null);
			List<String> resultIdList = null;
			List<MemberSearchVO> resultMemberList = new ArrayList<MemberSearchVO>();
			List<String> memberIdListByRegion = null;
			List<String> memberIdListByRole = null;
			List<String> memberIdListByCategory = null;
			List<String> memberIdListBySkill = null;
			List<String> memberIdListByKeyword = null;

			if (region != null) {
				Criteria regionCri = new Criteria();
				List<String> regionList = new ArrayList<String>();
				for (String regionStr : region) {
					regionList.add(regionStr);
				}
				System.out.println(regionList);
				regionCri.addCriteria("regionList", regionList);
				memberIdListByRegion = memberService.getMemberIdByRegionList(regionCri);
				System.out.println(memberIdListByRegion);
				if (memberIdListByRegion != null) {
					resultIdList = new ArrayList<String>();
					resultIdList.addAll(memberIdListByRegion);
				}
			}

			if (role != null) {
				Criteria roleCri = new Criteria();
				List<String> roleList = new ArrayList<String>();
				for (String roleStr : role) {
					roleList.add(roleStr);
				}
				roleCri.addCriteria("roleList", roleList);
				memberIdListByRole = memberService.getMemberIdByRoleList(roleCri);
				if (memberIdListByRole != null) {
					if (resultIdList == null) {
						resultIdList = new ArrayList<String>();
						for (String teamId : memberIdListByRole) {
							if (!resultIdList.contains(teamId)) {
								resultIdList.add(teamId);
							}
						}
					} else {
						for (int i = 0; i < resultIdList.size(); i++) {
							boolean flag = false;
							for (int j = 0; j < memberIdListByRole.size(); j++) {
								if (resultIdList.get(i).equals(memberIdListByRole.get(j))) {
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
				List<String> projectCategoryId = new ArrayList<String>();
				for (String projectStr : project) {
					projectCategoryId.add(projectStr);
				}
				memberIdListByCategory = memberService.getMemberByProjectCategoryId(projectCategoryId);

				if (memberIdListByCategory != null) {
					if (resultIdList == null) {
						resultIdList = new ArrayList<String>();
						for (String memberId : memberIdListByCategory) {
							if (!resultIdList.contains(memberId)) {
								resultIdList.add(memberId);
							}
						}
					} else {
						for (int i = 0; i < resultIdList.size(); i++) {
							boolean flag = false;
							for (int j = 0; j < memberIdListByCategory.size(); j++) {
								if (resultIdList.get(i).equals(memberIdListByCategory.get(j))) {
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
				memberIdListBySkill = memberService.getMemberBySkillId(skillList);
				if (memberIdListBySkill != null) {
					if (resultIdList == null) {
						resultIdList = new ArrayList<String>();
						for (String teamId : memberIdListBySkill) {
							if (!resultIdList.contains(teamId)) {
								resultIdList.add(teamId);
							}
						}
					} else {
						for (int i = 0; i < resultIdList.size(); i++) {
							boolean flag = false;
							for (int j = 0; j < memberIdListBySkill.size(); j++) {
								if (resultIdList.get(i).equals(memberIdListBySkill.get(j))) {
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

			if (!keyword.trim().equals("")) {
				Criteria textCri = new Criteria();
				textCri.addCriteria("memberName", keyword.trim());
				memberIdListByKeyword = memberService.getMemberIdByCondition(textCri);

				if (memberIdListByKeyword != null) {
					if (resultIdList == null) {
						resultIdList = new ArrayList<String>();
						for (String teamId : memberIdListByKeyword) {
							if (!resultIdList.contains(teamId)) {
								resultIdList.add(teamId);
							}
						}
					} else {
						for (int i = 0; i < resultIdList.size(); i++) {
							boolean flag = false;
							for (int j = 0; j < memberIdListByKeyword.size(); j++) {
								if (resultIdList.get(i).equals(memberIdListByKeyword.get(j))) {
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
					MemberSearchVO memberSearchVO = memberService.getMemberSearchInfo(resultId);
					resultMemberList.add(memberSearchVO);
				}
			}

			model.addAttribute("resultMemberList", resultMemberList);
			return "teambuilding/jsp/searchMember";
		}
	}
}
