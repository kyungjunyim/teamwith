package com.teamwith.interceptor;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.teamwith.service.ApplicationService;
import com.teamwith.service.TeamService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MyApplicationVO;
import com.teamwith.vo.PortfolioSimpleVO;
import com.teamwith.vo.TeamSimpleVO;
import com.teamwith15.service.PologService;

public class TeamServiceInterceptor extends HandlerInterceptorAdapter {
	@Inject
	private PologService pologService;
	
	private static final Logger logger = LoggerFactory.getLogger(TeamServiceInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();

		PologService pologService = PologService.getInstance();
		ApplicationService applicationService = ApplicationService.getInstance();
		TeamService teamService = TeamService.getInstance();
		pologService.openSession();

		// 최근 포트폴리오 등록
		Criteria portfolioCri = new Criteria();
		portfolioCri.addCriteria("condition", "recent");
		List<PortfolioSimpleVO> recentPortfolioList = pologService.getRecentPortfolio(portfolioCri);
		request.setAttribute("recentPortfolioList", recentPortfolioList);
		pologService.closeSession();

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
