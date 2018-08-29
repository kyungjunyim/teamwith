package com.teamwith.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamwith.service.ApplicationService;
import com.teamwith.service.MemberService;
import com.teamwith.service.TeamService;
import com.teamwith.vo.MemberPraiseCntVO;
import com.teamwith.vo.MemberPraiseVO;
import com.teamwith.vo.MemberSearchVO;
import com.teamwith.vo.TeamSimpleVO;

@Controller
@RequestMapping(value = "/praise")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class PraiseController {

	private static final Logger logger = LoggerFactory.getLogger(PraiseController.class);

	@Inject
	private MemberService memberService;
	@Inject
	private ApplicationService applicationService;
	@Inject
	private TeamService teamService;

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public List<MemberPraiseCntVO> updatePraise(Model model, String actor, String target, String[] praise) {
		logger.info("praise null:" + (praise == null));
		List<MemberPraiseVO> pl = new ArrayList<MemberPraiseVO>();
		if (praise == null) {
			try {
				memberService.removeMemberPraise(actor, target);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			for (String p : praise) {
				pl.add(new MemberPraiseVO(actor, target, p));
			}
		}
		List<MemberPraiseCntVO> result = null;
		try {
			memberService.updateMemberPraise(pl);
			result = memberService.getMemberPraiseCnt(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> isAbleToPraise(Model model, String actor, String target) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		logger.info(sd.format(new Date()));
		List<String> joinTeamIds = applicationService.getJoinedTeamId(actor);
		try {
			List<TeamSimpleVO> teamVOs = teamService.getMyTeam(actor);
			for (TeamSimpleVO t : teamVOs) {
				joinTeamIds.add(t.getTeamId());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "false");

		try {
			for (String id : joinTeamIds) {

				// 모집 마감일이 지났거나, 팀 상태가 모집 마감이거나
				if (teamService.getTeamInfo(id).getTeamEndDate().compareTo(sd.format(new Date()).toString()) < 0
						|| teamService.getTeamInfo(id).getTeamStatus().equals("1")) {
					teamService.getTeamInfo(id).setTeamStatus("1");
					for (int i = 0; i < applicationService.getTeamMember(id).size(); i++) {
						List<MemberSearchVO> members = applicationService.getTeamMember(id);
						for (MemberSearchVO m : members) {
							logger.info(m.getMemberId() + "," + target);
							if (m.getMemberId().equals(target)|| teamService.getTeamInfo(id).getMemberId().equals(target)) {
								map.put("result", "true");
								logger.info("true");
								return map;
							}
						}
					}
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;

	}

	
}
