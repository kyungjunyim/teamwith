package com.teamwith.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamwith.service.PologService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.PortfolioSimpleVO;
import com.teamwith.vo.PortfolioVO;

@RestController
@RequestMapping(value="/api/portfolioSearch")
public class PortfolioSearchRestController {
	
	@Inject
	PologService pologService;
	
	@ResponseBody
	@RequestMapping(value="/{portfolioId}",  method=RequestMethod.GET,produces = "application/json")
	public Map<String,Object> searchPortfolio(@PathVariable("portfolioId") String portfolioId,Model model)
	 						throws Exception{
		portfolioId="portfolio-"+portfolioId;
		Map<String,Object> result=new HashMap<String,Object>();
		PortfolioVO portfolio=pologService.getPortfolio(portfolioId);
		
		result.put("portfolio", portfolio);
		return result;
	}
	@ResponseBody
	@RequestMapping(value="/",method=RequestMethod.GET,produces = "application/json")
	public Map<String,Object> searchProtfolioList(Model model) throws Exception{
		Criteria cri=new Criteria();
		Map<String, Object> map=new HashMap<String, Object>();
		List<PortfolioSimpleVO> portfolioList=pologService.getRecentPortfolio(cri);
		map.put("portfolioList", portfolioList);
		
		return map;
	}
	
}
