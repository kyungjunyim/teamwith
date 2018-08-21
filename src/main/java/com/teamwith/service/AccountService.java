package com.teamwith.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.teamwith.vo.MemberTendencyVO;
import com.teamwith.vo.MemberVO;
import com.teamwith.vo.MyApplicationVO;

@Service
public class AccountService {

	@Inject
	private MemberService memberService;
	@Inject
	private PologService pologService;
	@Inject
	private ProfileService profileService;
	@Inject
	private ApplicationService applicationService;

	private AccountService() {
	}

	public boolean isDuple(String memberId, String memberEmail) {
		return false;

	}

	public int updatePassword(String memberId, String memberPassword, String newPassword) throws Exception {
		if (memberId == null || memberPassword == null || newPassword == null) {
			return -1;
			// ����� �ͼ��� ó���ϸ� ���� ��
		}
		Map<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("memberId", memberId);
		loginInfo.put("memberPassword", memberPassword);
		loginInfo.put("newPassword", newPassword);
		return profileService.updatePassword(loginInfo);
	}

	public String findAccount(String memberId, String memberBirth, String memberEmail) throws Exception {
		if (memberBirth == null || memberEmail == null) {
			return null;
			// ����� �ͼ��� ó���ϸ� ���� ��
		}
		Map<String, String> accountInfo = new HashMap<String, String>();
		accountInfo.put("memberId", memberId);
		accountInfo.put("memberBirth", memberBirth);
		accountInfo.put("memberEmail", memberEmail);

		return profileService.searchMemberAccount(accountInfo);
	}

	public String findAccount(String memberBirth, String memberEmail) throws Exception {
		return findAccount(null, memberBirth, memberEmail);
	}

	public void registerMember(MemberVO member) throws Exception {
		profileService.registerMember(member);
		pologService.createPolog(member.getMemberId());
		profileService.initTendency(member.getMemberId());
	}

	public void hideMember(String memberId) {
		profileService.hideMember(memberId);
		List<MyApplicationVO> myApp = applicationService.getMyApplication(memberId);
		List<String> appIds = new ArrayList<String>();
		for (MyApplicationVO m : myApp) {
			if (m.getApplicationStatus().equals("0")) {
				appIds.add(m.getApplicationId());
			}
		}
		for (String appId : appIds) {
			applicationService.changeApplicationStatus(3, appId);
		}
	}

	public void removeMember(String memberId) throws Exception {
		memberService.removeMemberAllPraise(memberId);
		memberService.removeMemberProjectCategory(memberId);
		memberService.removeMemberSkill(memberId);
		profileService.removeMemberCareer(memberId);
		profileService.removeMemberLicense(memberId);
		profileService.removeMemberTendency(memberId);
		pologService.removePortfolio(memberId, 0);
		pologService.removePolog(memberId);
		profileService.removeMember(memberId);
	}

}
