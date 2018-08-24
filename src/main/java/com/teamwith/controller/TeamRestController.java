//Writer : HWANG KYU JIN
package com.teamwith.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.service.TeamService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.TeamSimpleVO;

@RestController
@RequestMapping(value="/api/team", method= {RequestMethod.GET,RequestMethod.POST})
public class TeamRestController {
	@Inject
	private TeamService teamService;
	
	@RequestMapping(value="myTeam",method=RequestMethod.GET)
	public HashMap<String,Object> myTeqam(@RequestParam("cri") Criteria cri, HttpSession session,Model model) {
		List<TeamSimpleVO> myTeamList = null;
		HashMap<String,Object> result=new HashMap<String,Object>();
		
		//MemberSimpleVO login=(MemberSimpleVO)session.getAttribute("memberSimpleVO");
		try {
			myTeamList = teamService.getMyTeam(cri, "jo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("myTeamList",myTeamList);
		return result;
	}
}
