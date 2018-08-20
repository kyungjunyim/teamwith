package com.teamwith.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.teamwith.service.PologService;
import com.teamwith.vo.PortfolioContentVO;
import com.teamwith.vo.PortfolioVO;
@Controller
@RequestMapping(value="/portfolio")
@MultipartConfig(maxFileSize=1024*1024*10)
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
	//request,session는 테스트용
	@RequestMapping(value="/{portfolioId}",method=RequestMethod.GET)
	public String detailPortfolio(@PathVariable("portfolioId") String portfolioId,Model model) {
		logger.info("detailPortfolio Call....");
		model.addAttribute("memberSimpleVO","oh");
		if(portfolioId==null||portfolioId.isEmpty()){
			model.addAttribute("error","no portfolioId");
			return "/polog/jsp/detailPortfolio";
		}
		portfolioId="portfolio-"+portfolioId;
		PortfolioVO portfolio=pologService.getPortfolio(portfolioId);
		List<PortfolioContentVO> contentList=pologService.getPortfolioContent(portfolioId);
		if(portfolio==null){
			model.addAttribute("error","can't search Portfolio");
			return "/polog/jsp/detailPortfolio";
		}
		model.addAttribute("portfolio",portfolio);
		model.addAttribute("portfolioContent",contentList);
		return "/polog/jsp/detailPortfolio";
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerPortfolioPage(Model model) {
		return "/polog/jsp/registerPortfolio";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPortfolio(MultipartFile [] portfolioFile,String []portfolioURL,String []contentOrder,String [] contentIntro,
			String [] portfolioContentName,String [] layoutId,
			@ModelAttribute PortfolioVO portfolioVO,Model model,HttpSession session) {
		String rootPath = session.getServletContext().getRealPath("/"); //service가 이 경로를 받을것
		rootPath=rootPath.replace("\\", "/");
		String portfolioId=null;
		try {
			String memberId=(String)session.getAttribute("memberId");
			if(memberId==null||memberId.isEmpty()){
				model.addAttribute("error","not login status");
				return "/polog/jsp/errorPage";
			}
			if(portfolioVO.getPortfolioBest()==null){
				portfolioVO.setPortfolioBest("0");
			}else{
				portfolioVO.setPortfolioBest("1");
			}
			portfolioVO.setMemberId((String)session.getAttribute("memberId"));
			portfolioVO.setPortfolioUpdateDate("2018-08-19");
			
			
			int fileIndex=1;
			int urlIndex=0;
			Map<Object,MultipartFile> param=new HashMap<Object,MultipartFile>();
			if(portfolioFile[0]!=null) {
				param.put(portfolioVO, portfolioFile[0]);
			}
			else {
				param.put(portfolioVO, null);
			}
			//MultipartFile [] portfolioFile,String []portfolioURL,String []contentOrder,String [] contentIntro,
			//String [] portfolioContentName
			if(contentOrder!=null) {
				for(int i=0;i<contentOrder.length;i++) {
					PortfolioContentVO portfolioContent=null;
					if(portfolioContentName!=null&&portfolioContentName[i].equals("image")) {
						if(portfolioFile[fileIndex]!=null) {
							
					        portfolioContent=new PortfolioContentVO("","",Integer.toString(i+1),layoutId[i],portfolioContentName[i],"",contentIntro[i]);
					        param.put(portfolioContent,portfolioFile[fileIndex]);
						}
						else {
							portfolioContent=new PortfolioContentVO("","",Integer.toString(i+1),layoutId[i],portfolioContentName[i],"",contentIntro[i]);
					        param.put(portfolioContent,null);
						}
						fileIndex++;
					}else if(portfolioContentName!=null&&portfolioContentName[i].equals("ppt")) {
						if(portfolioFile[fileIndex]!=null) {
							portfolioContent=new PortfolioContentVO("","",Integer.toString(i+1),layoutId[i],portfolioContentName[i],"",contentIntro[i]);
					        param.put(portfolioContent,portfolioFile[fileIndex]);
						}
						else {
							portfolioContent=new PortfolioContentVO("","",Integer.toString(i+1),layoutId[i],portfolioContentName[i],"",contentIntro[i]);
					        param.put(portfolioContent,null);
						}
						fileIndex++;
					}else if(portfolioContentName!=null&&portfolioContentName[i].equals("media")){
						portfolioContent=new PortfolioContentVO("","",Integer.toString(i+1),layoutId[i],portfolioContentName[i],
								portfolioURL[urlIndex],contentIntro[i]);
				        param.put(portfolioContent,null);
				        urlIndex++;
					}
				}
			}
			
			
			portfolioId=pologService.registerPortfolioAndContent(param,rootPath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(portfolioId==null) {
			model.addAttribute("error","Failed register...");
			return "/polog/jsp/errorPage";
		}
		else {
			return "redirect:/portfolio/"+portfolioId.split("-")[1];
		}
		
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
		
		return "redirect:/polog/"+memberId;
	}
	
	
	
}
