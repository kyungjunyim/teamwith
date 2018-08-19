package com.teamwith.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.ApplicationService;
import com.teamwith.service.MemberService;
import com.teamwith.service.TeamService;
import com.teamwith.vo.MyApplicationVO;

@Controller
@RequestMapping(value = "/praise")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class PraiseController {

	private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);

	@Inject
	private MemberService memberService;
	@Inject
	private ApplicationService applicationService;
	@Inject
	private TeamService teamService;
	
	@RequestMapping(value="/check",method=RequestMethod.GET)
	public String isAbleToPraise(Model model,String actor, String target) {
		
		List<MyApplicationVO> myList =applicationService.getMyApplication(actor);
		List<String> joinTeamIds = applicationService.getTeamMember(teamId);
		for(String id : joinTeamIds) {
			try {
				logger.info("teamId:"+teamService.getTeamSimple(id).getTeamEndDate());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "polog/jsp/pologMain";
			}
		}
		
		return "polog/jsp/pologMain";
	}
}
