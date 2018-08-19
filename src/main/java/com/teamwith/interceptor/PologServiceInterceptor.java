package com.teamwith.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.teamwith.service.PologService;
import com.teamwith.service.ProfileService;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MemberVO;

public class PologServiceInterceptor extends HandlerInterceptorAdapter {
	@Inject
	private PologService pologService;
	@Inject
	private ProfileService profileService;

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

		return true;
	}

}
