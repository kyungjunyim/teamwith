//Writer : HWANG KYU JIN
package com.teamwith.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamwith.service.TeamService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.TeamSimpleVO;

@Controller
@RequestMapping(value="/team", method= {RequestMethod.GET,RequestMethod.POST})
public class TeamController {
	
	@Inject
	private TeamService teamService;
	
	@RequestMapping(value="/remove/{teamId}",method=RequestMethod.GET)
	public String removeTeam(HttpSession session,@PathVariable("teamId") String teamId ) {
		MemberSimpleVO login=(MemberSimpleVO)session.getAttribute("memberSimpleVO");
		//�꼫媛� ���옣�씠�땲? 瑜� 寃��궗�빐�빞�븳�떎. �뙆�씪誘명꽣濡� ���옣 �븘�씠�뵒瑜� �꽆寃⑥＜硫� 醫뗪쿋�떎.
		teamId="team-"+teamId;
		try {
			teamService.removeTeam(teamId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/close/{teamId}",method=RequestMethod.GET)
	public String closeTeam(@PathVariable("teamId") String teamId,RedirectAttributes rttr) {
		String key="team-"+teamId;
		try {
			teamService.changeTeamStatus(1, key);
		} catch (Exception e) {
			e.printStackTrace();
			rttr.addFlashAttribute("msg","error");
		}
		return "redirect:teamSearch/"+teamId;
	}
	
	@RequestMapping(value="/myTeam",method=RequestMethod.GET)
	public String myTeqam(HttpSession session,Model model) {
		List<TeamSimpleVO> myTeamList = null;
		MemberSimpleVO login=(MemberSimpleVO)session.getAttribute("memberSimpleVO");
		try {
			myTeamList = teamService.getMyTeam(new Criteria(1, 100), login.getMemberId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("myTeamList",myTeamList);
		return "teambuilding/jsp/myTeam";
	}
}
