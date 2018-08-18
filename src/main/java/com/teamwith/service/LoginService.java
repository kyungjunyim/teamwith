package com.teamwith.service;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.teamwith.dao.MemberDAO;
import com.teamwith.dto.MemberDTO;
import com.teamwith.vo.MemberSimpleVO;
@Service
public class LoginService {
	@Inject
	private MemberDAO memberDAO;


	private LoginService() {
	}

	public MemberSimpleVO login(String memberId, String memberPassword) throws Exception {
		if (memberId == null || memberPassword == null) {
			return null;
		}
		Map<String, String> loginInfo = new HashMap<String, String>();
		loginInfo.put("memberId", memberId);
		loginInfo.put("memberPassword", memberPassword);
		MemberDTO mem = memberDAO.searchMember(loginInfo);
		MemberSimpleVO result = null;
		if (mem != null) {
			result = new MemberSimpleVO(memberId, mem.getMemberName(), mem.getMemberPic(), mem.getMemberAuth() + "");
		}
		return result;
	}

}
