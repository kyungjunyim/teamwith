//Writer : HWANG KYU JIN
package com.teamwith.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.TeamService;
import com.teamwith.vo.TeamDetailVO;

@Controller
@RequestMapping(value="/teamInfo")

public class TeamInfoController {
	@Inject
	private TeamService teamService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerTeamView() {
		return "teambuilding/jsp/teamRegister";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerTeam(HttpSession session,TeamDetailVO teamInfo) {
//		teamService.registerTeam(teamInfo, file);
		return null;
		
	}
}
