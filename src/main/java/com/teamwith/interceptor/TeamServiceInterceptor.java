package com.teamwith.interceptor;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.teamwith.service.ApplicationService;
import com.teamwith.service.PologService;
import com.teamwith.service.TeamService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MyApplicationVO;
import com.teamwith.vo.PortfolioSimpleVO;
import com.teamwith.vo.TeamSimpleVO;

public class TeamServiceInterceptor extends HandlerInterceptorAdapter {
	@Inject
	private PologService pologService;
	@Inject
	private ApplicationService applicationService;
	@Inject
	private TeamService teamService;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);

		HttpSession session = request.getSession();

		// 최근 포트폴리오 등록
		Criteria portfolioCri = new Criteria();
		portfolioCri.addCriteria("condition", "recent");
		List<PortfolioSimpleVO> recentPortfolioList = pologService.getRecentPortfolio(portfolioCri);
		request.setAttribute("recentPortfolioList", recentPortfolioList);

		// 세션 정보 조회
		MemberSimpleVO memberSimpleVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		if (memberSimpleVO != null) {
			// 나의 지원 내역 가져오기
			List<MyApplicationVO> myApplicationVOList = applicationService
					.getMyApplication(memberSimpleVO.getMemberId());
			request.setAttribute("myApplicationCnt", myApplicationVOList.size());

			// 나의 등록 팀 가져오기
			List<TeamSimpleVO> teamSimpleVOList = null;
			try {
				teamSimpleVOList = teamService.getMyTeam(new Criteria(1, 11), memberSimpleVO.getMemberId());
				request.setAttribute("myTeamList", teamSimpleVOList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
