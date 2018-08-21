package com.teamwith.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.PologService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.PortfolioSimpleVO;
import com.teamwith.vo.TeamRateVO;
import com.teamwith.vo.TeamSimpleVO;

@Controller
@RequestMapping(value = "/portfolios")
public class PortfolioSearchController {

	private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);

	@Inject
	private PologService pologService;

	private List<PortfolioSimpleVO> setRecentPf() throws Exception {
		Criteria cri = new Criteria();
		return pologService.getRecentPortfolio(cri);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String searchPortfolio(HttpSession session, Model model) {

		List<PortfolioSimpleVO> recentPfList = null;
		try {
			recentPfList = setRecentPf();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("recentPortfolioList", recentPfList);
		return "teambuilding/jsp/searchPortfolio";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String searchPortfolio(HttpSession session, Model model, String[] projectCategoryId, String title)
			throws Exception {
		if (projectCategoryId == null && (title == null || title.trim().equals(""))) {
			return searchPortfolio(session, model);
		}

		// model.addAttribute("recentTeamList", null);
		// model.addAttribute("recommendedTeamList", null);
		List<PortfolioSimpleVO> resultPortfolio = null;

		Criteria projectCri = new Criteria();

		// title search
		if (title != null && !title.trim().equals("")) {
			projectCri.addCriteria("portfolioTitle", title);
		}

		// category search
		if (projectCategoryId != null) {

			List<String> projectCategoryList = new ArrayList<String>();
			for (String projectStr : projectCategoryId) {
				projectCategoryList.add(projectStr);
			}
			projectCri.addCriteria("projectCategory", projectCategoryList);
		}
		
		resultPortfolio = pologService.searchPortfolio(projectCri);

		model.addAttribute("result", "search");
		model.addAttribute("searchPortfolioList", resultPortfolio);
		return "teambuilding/jsp/searchPortfolio";

	}
}
