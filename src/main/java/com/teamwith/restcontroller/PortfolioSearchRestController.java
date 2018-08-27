package com.teamwith.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.service.PologService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.PortfolioContentVO;
import com.teamwith.vo.PortfolioSimpleVO;
import com.teamwith.vo.PortfolioVO;

@RestController
@RequestMapping(value = "/api/portfolioSearch")
public class PortfolioSearchRestController {

	@Inject
	PologService pologService;

	@ResponseBody
	@RequestMapping(value = "/{portfolioId}", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> searchPortfolio(@PathVariable("portfolioId") String portfolioId) throws Exception {
		portfolioId = "portfolio-" + portfolioId;
		Map<String, Object> result = new HashMap<String, Object>();
		PortfolioVO portfolio = pologService.getPortfolio(portfolioId);

		result.put("portfolio", portfolio);
		List<PortfolioContentVO> portfolioContentList=pologService.getPortfolioContent(portfolioId);
		result.put("portfolioContent",portfolioContentList);
		return result;
	}
	

	@ResponseBody
	@RequestMapping(value = "/recent", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> searchProtfolioRecentList(Criteria cri) throws Exception {
		if (cri == null) {
			cri = new Criteria();
		}
		System.out.println("recent");
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<PortfolioSimpleVO> list = pologService.getRecentPortfolio(cri);
		map.put("portfolioList", list);

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> searchProtfolioList(Criteria cri, String[] project, String keyword) throws Exception {
		if (cri == null) {
			cri = new Criteria();
		}
		cri.addCriteria("projectCategory", project);
		if (keyword != null && !keyword.trim().equals("")) {
			cri.addCriteria("portfolioTitle", keyword);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<PortfolioSimpleVO> portfolioList = pologService.searchPortfolio(cri);
		map.put("portfolioList", portfolioList);

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/member/{memberId}", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> searchMemberProtfolioList(@PathVariable String memberId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PortfolioSimpleVO> portfolioList = pologService.getPortfolioList(memberId, false);
		map.put("portfolioList", portfolioList);

		return map;
	}

}
