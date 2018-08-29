package com.teamwith.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.teamwith.service.ApplicationService;
import com.teamwith.service.PologService;
import com.teamwith.service.ProfileService;
import com.teamwith.service.TeamService;
import com.teamwith.vo.MemberSearchVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MemberVO;
import com.teamwith.vo.TeamSimpleVO;

public class PologServiceInterceptor extends HandlerInterceptorAdapter {
	@Inject
	private PologService pologService;
	@Inject
	private ProfileService profileService;
	@Inject
	private ApplicationService applicationService;
	@Inject
	private TeamService teamService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("polog interceptor");

		// check if the polog is public

		String[] str = request.getRequestURI().split("/");
		String memberId = str[str.length - 1];
		MemberVO mem;
		if (memberId != null) {
			mem = profileService.getMyInfo(memberId);
			MemberSimpleVO memSession = (MemberSimpleVO) request.getSession().getAttribute("memberSimpleVO");

			// if the member does not exist
			if (mem == null) {
				response.sendRedirect("/nonExistentPolog");
				return true;
			}

			// private && not my polog
			if (!mem.getMemberPublic().equals("0")
					&& (memSession == null || !memberId.equals(memSession.getMemberId()))) {
				response.sendRedirect("/privatePolog");
				return true;
			}
		} else {
			return false;
		}

		// my polog or (public and existent member) -> set Attributes
		request.setAttribute("memberVO", mem);
		request.setAttribute("pologVO", pologService.getPologInfo(memberId));
		if (isTeamMember(mem.getMemberId(), memberId)) {

			request.setAttribute("teamMember", "true");
		}
		return true;
	}

	public boolean isTeamMember(String actor, String target) {
		List<String> joinTeamIds = applicationService.getJoinedTeamId(actor);
		try {
			List<TeamSimpleVO> teamVOs = teamService.getMyTeam(actor);
			for (TeamSimpleVO t : teamVOs) {
				joinTeamIds.add(t.getTeamId());

			}
			for (String id : joinTeamIds) {
				System.out.println("team name:" + id);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			for (String id : joinTeamIds) {

				// 같은 팀 멤버인지 확인, 모집날짜와 상관 없음.
				for (int i = 0; i < applicationService.getTeamMember(id).size(); i++) {
					List<MemberSearchVO> members = applicationService.getTeamMember(id);
					for (MemberSearchVO m : members) {
						if (m.getMemberId().equals(target)
								|| teamService.getTeamInfo(id).getMemberId().equals(target)) {
							return true;
						}

					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
