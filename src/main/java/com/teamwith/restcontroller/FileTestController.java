package com.teamwith.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/file2")
@RestController
public class FileTestController {
	@Inject
	private ServletContext servletContext;

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public A file(HttpServletRequest req) {

		Map<String, Map<String, String[]>> result = new HashMap<String, Map<String, String[]>>();
		List<Map<String, String>> strList = new ArrayList<Map<String, String>>();

		Map<String, String> praises = (Map<String, String>) req.getServletContext().getAttribute("praiseList");
		Map<String, Object> projects = (Map<String, Object>) req.getServletContext().getAttribute("projectList");
		Map<String, Object> regions = (Map<String, Object>) req.getServletContext().getAttribute("regionList");
		Map<String, Object> roles = (Map<String, Object>) req.getServletContext().getAttribute("roleList");
		Map<String, Object> developerSkills = (Map<String, Object>) req.getServletContext()
				.getAttribute("developerSkillList");
		Map<String, Object> plannerSkills = (Map<String, Object>) req.getServletContext()
				.getAttribute("plannerSkillList");
		Map<String, Object> designerSkills = (Map<String, Object>) req.getServletContext()
				.getAttribute("designerSkillList");
		Map<String, Object> etcSkills = (Map<String, Object>) req.getServletContext().getAttribute("etcSkillList");
		Map<String, String[]> skills = (Map<String, String[]>) req.getServletContext().getAttribute("skillList");
		Map<String, Object> tendencies = (Map<String, Object>) req.getServletContext().getAttribute("tendencyList");

		strList.add(praises);
		result.put("skillList", skills);
		A a = new A();
		a.a = result;
		a.b = strList;
		return a;
		/*
		 * result.put("projectList", projects); result.put("regionList", regions);
		 * result.put("roleList", roles); result.put("developerSkillList",
		 * developerSkills); result.put("plannerSkillList", plannerSkills);
		 * result.put("designerSkillList", designerSkills); result.put("etcSkillList",
		 * etcSkills); result.put("skillList", skills); result.put("tendencyList",
		 * tendencies);
		 */
		//return result;
	}

	class A {
		Map<String, Map<String, String[]>> a;
		List<Map<String, String>> b;
	}
}