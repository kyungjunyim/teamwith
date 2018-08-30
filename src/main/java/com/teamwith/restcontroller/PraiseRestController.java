package com.teamwith.restcontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.service.ApplicationService;
import com.teamwith.service.MemberService;
import com.teamwith.service.TeamService;
import com.teamwith.vo.MemberPraiseCntVO;
import com.teamwith.vo.MemberPraiseVO;
import com.teamwith.vo.MemberSearchVO;
import com.teamwith.vo.MemberSimpleVO;

@RestController
@RequestMapping(value = "/api/praise")
public class PraiseRestController {

	private static final Logger logger = LoggerFactory.getLogger(PraiseRestController.class);

	@Inject
	private MemberService memberService;
	@Inject
	private ApplicationService applicationService;
	@Inject
	private TeamService teamService;

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public List<MemberPraiseCntVO> updatePraise(HttpSession session, String target, String[] praise) {
		logger.info("praise null:" + (praise == null));
		MemberSimpleVO msVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		if (msVO == null) {
			return null;
		}
		String actor = msVO.getMemberId();
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
	public Map<String, List<MemberPraiseVO>> isAbleToPraise(HttpSession session, String target) {
		MemberSimpleVO msVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		Map<String, List<MemberPraiseVO>> map = new HashMap<String, List<MemberPraiseVO>>();

		// 로그인한 사용자가 요청한건지 체크
		if (msVO != null) {
			String actor = msVO.getMemberId();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

			// 사용자의 합류팀 목록 조회
			List<String> joinTeamIds = applicationService.getJoinedTeamId(actor);

			// 사용자와 칭찬 타겟이 같은 팀이었는지 체크
			try {
				for (String id : joinTeamIds) {

					if (teamService.getTeamInfo(id).getTeamEndDate().compareTo(sd.format(new Date()).toString()) < 0) {

						for (int i = 0; i < applicationService.getTeamMember(id).size(); i++) {
							List<MemberSearchVO> members = applicationService.getTeamMember(id);
							for (MemberSearchVO m : members) {
								System.out.println(
										m.getMemberId() + ",team leader:" + teamService.getTeamInfo(id).getMemberId());
								// 사용자와 칭찬 타겟이 같은 팀이었다면
								if (m.getMemberId().equals(target)
										|| teamService.getTeamInfo(id).getMemberId().equals(target)) {
									// 사용자가 이전에 타겟을 칭찬한 내역 정보를 불러와서 반환
									// 여기까지 못 오는 경우 null반환
									List<MemberPraiseVO> myPraiseList = memberService.getMemberPriase(actor, target);

									// 같은 팀원은 맞지만 한번도 칭찬한 적이 없어서 칭찬 내역이 없을 경우
									if (myPraiseList == null || myPraiseList.isEmpty()) {
										myPraiseList = new ArrayList<MemberPraiseVO>();
										MemberPraiseVO vo = new MemberPraiseVO();
										vo.setPraiseId("never");
										myPraiseList.add(vo);
									}
									map.put("myPraiseList", myPraiseList);
									return map;
								}
							}
						}
					}

				}
				System.out.println("같은 팀원아님");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return map;

	}
}
