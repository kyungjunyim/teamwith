package com.teamwith.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.PologService;
import com.teamwith.vo.PortfolioContentVO;
import com.teamwith.vo.PortfolioVO;
@Controller
@RequestMapping("/portfolio")
public class PortfolioController {
	
	private static final Logger logger=LoggerFactory.getLogger(PortfolioController.class);
	
	@Inject
	private PologService pologService;
	/*@RequestMapping(value="/all/{bno}",method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(
		@PathVariable("bno") Integer bno){*/
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String searchPortfolio(Model model) {
		return null;
	}
	@RequestMapping(value="/{portfolioId}",method=RequestMethod.GET)
	public String detailPortfolio(@PathVariable("portfolioId") String portfolioId,Model model) {
		if(portfolioId==null||portfolioId.isEmpty()){
			model.addAttribute("error","no portfolioId");
			return "/polog/jsp/errorPage";
		}
		PortfolioVO portfolio=pologService.getPortfolio(portfolioId);
		List<PortfolioContentVO> contentList=pologService.getPortfolioContent(portfolioId);
		if(portfolio==null){
			model.addAttribute("error","can't search Portfolio");
			return "/polog/jsp/errorPage";
		}
		model.addAttribute("portfolio",portfolio);
		if(contentList!=null&&!contentList.isEmpty()){
			model.addAttribute("portfolioContent",contentList);
		}
		return "/polog/jsp/detailPortfolio";
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerPortfolioPage(Model model) {
		return "/polog/jsp/registerPortfolio";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPortfolio(Model model) {
		
		return "/polog/jsp/detailPortfolio";
	}
	@RequestMapping(value="/edit/{portfolioId}",method=RequestMethod.GET)
	public String editPortfolioPage(@PathVariable("portfolioId") String portfolioId,Model model) {
		
		return "/polog/jsp/editPortfolio";
	}
	@RequestMapping(value="/edit/{portfolioId}",method=RequestMethod.POST)
	public String editPortfolio(@PathVariable("portfolioId") String portfolioId,Model model) {
		
		return "/polog/jsp/detailPortfolio";
	}
	@RequestMapping(value="/remove/{portfolioId}",method=RequestMethod.POST)
	public String removePortfolio(@PathVariable("portfolioId") String portfolioId,Model model) {
		String memberId=null;
		return "redirect:/"+memberId;
	}
	
	
	
}
