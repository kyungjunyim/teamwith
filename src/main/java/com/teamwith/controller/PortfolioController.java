package com.teamwith.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamwith.service.PologService;
import com.teamwith.service.ProfileService;
import com.teamwith.vo.MemberVO;
import com.teamwith.vo.PortfolioContentVO;
import com.teamwith.vo.PortfolioVO;
@Controller
@RequestMapping(value="/portfolio")
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
		logger.info("detailPortfolio Call....");
		if(portfolioId==null||portfolioId.isEmpty()){
			model.addAttribute("error","no portfolioId");
			return "/polog/jsp/detailPortfolio";
		}
		PortfolioVO portfolio=pologService.getPortfolio(portfolioId);
		List<PortfolioContentVO> contentList=pologService.getPortfolioContent(portfolioId);
		if(portfolio==null){
			model.addAttribute("error","can't search Portfolio");
			return "/polog/jsp/detailPortfolio";
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
	public String registerPortfolio(Model model,HttpServletRequest request) {
		request.getSession().setAttribute("memberId","kim");
		
		try {
			
			String memberId=(String)request.getSession().getAttribute("memberId");
			System.out.println(memberId);
			if(memberId==null){
				model.addAttribute("error","not login status");
				return "/polog/jsp/detailPortfolio";
			}
			Part file=request.getPart("portfolioPic");
			
			String title=request.getParameter("portfolioTitle");
			String category=request.getParameter("projectCategory");
			String intro=request.getParameter("portfolioIntro");
			String skills=request.getParameter("portfolioSkills");
			String teamName=request.getParameter("portfolioTeamName");
			String peopleNumber=request.getParameter("portfolioPeopleNumber");
			String startDate=request.getParameter("portfolioStartDate");
			String endDate=request.getParameter("portfolioEndDate");
			String role=request.getParameter("portfolioRole");
			String work=request.getParameter("portfolioWork");
			String best=null;
			if(request.getParameter("portfolioBest")==null){
				best="0";
			}else{
				best="1";
			}
			
			//포폴 content
			String [] names=request.getParameterValues("portfolioContentName");
			String [] values=request.getParameterValues("portfolioContentValue");
			String [] intros=request.getParameterValues("portfolioContentIntro");
			String [] layout=request.getParameterValues("portfolioContentLayoutId");
			Collection<Part> files=request.getParts();
			/*for(Part p:files)
				System.out.println("''"+p.getSubmittedFileName());
			
			return;*/
		
			for(int i=0;i<names.length;i++){
				PortfolioContentVO cv=new PortfolioContentVO("","",Integer.toString(i+1),layout[i],names[i],values[i]);
				PortfolioContentVO cv2=new PortfolioContentVO("","",Integer.toString(i+1),layout[i],"text",intros[i]);
			}
			
			PortfolioVO pv=new PortfolioVO("", title, intro, startDate, endDate, teamName, peopleNumber, role, work, skills,"2018-08-15", best, file.getName(), category, memberId);
			System.out.println(pv);
			Map<Object,Part> param=new HashMap<Object,Part>();
			param.put(pv,file);
			pologService.registerPortfolioAndContent(param);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public String removePortfolio(@PathVariable("portfolioId") String portfolioId,String memberId,Model model) {
		logger.info("removePortfolio Call....");
		
		int res=pologService.removePortfolio(portfolioId);
		if(res!=1) {
			model.addAttribute("error","삭제 실패");
			return "redirect:/polog/jsp/errorPage";
		}
		return "redirect:/"+memberId;
	}
	
	
	
}
