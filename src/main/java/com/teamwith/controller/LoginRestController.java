package com.teamwith.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.service.LoginService;
import com.teamwith.vo.MemberSimpleVO;

@RestController
@RequestMapping("/api")
public class LoginRestController {
	@Inject
	private LoginService loginService;
	@Inject
	private MemberSimpleVO memberSimpleVO;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(@RequestBody Map<String, String> param, HttpSession session) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		memberSimpleVO = loginService.login(param.get("memberId"), param.get("memberPassword"));
		session.setAttribute("memberSimpleVO", memberSimpleVO);
		
		if(memberSimpleVO == null) {
			result.put("result", "false");
		} else {
			result.put("result", "true");
			result.put("memberSimpleVO", memberSimpleVO);
		}
		return result;
	}

}
