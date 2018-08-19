package com.teamwith.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.teamwith.service.PologService;
import com.teamwith.util.FileLoaderListener;
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
	public String registerPortfolio(MultipartFile [] portfolioFile,String []portfolioURL,String []contentOrder,String [] contentIntro,
			String [] portfolioContentName,@ModelAttribute PortfolioVO portfolioVO,Model model,HttpSession session) {
		
		session.setAttribute("memberId","kim"); //테스트용
		if(portfolioFile[1]==null) {
			System.out.println("널");
		}
		else {
			System.out.println("널 아님");
		}
		System.out.println("contentOrders");
		for(int i=0;i<contentOrder.length;i++) {
			System.out.println(contentOrder[i]);
		}
		for(int i=0;i<portfolioURL.length;i++) {
			System.out.println(portfolioURL[i]);
			if(portfolioURL[i]==null||portfolioURL[i].isEmpty()) {
				System.out.println("날이넹");
			}else {
				System.out.println("널아니넹");
			}
		}
		System.out.println(portfolioFile[1]);
		for(int i=0;i<portfolioFile.length;i++) {
			System.out.println(portfolioFile[i].getSize());
		}
		
		try {
			String memberId=(String)session.getAttribute("memberId");
			System.out.println(memberId);
			if(memberId==null){
				model.addAttribute("error","not login status");
				return "/polog/jsp/detailPortfolio";
			}
			
			if(portfolioVO.getPortfolioBest()==null){
				portfolioVO.setPortfolioBest("0");
			}else{
				portfolioVO.setPortfolioBest("1");
			}
			portfolioVO.setMemberId((String)session.getAttribute("memberId"));
			System.out.println(portfolioVO);
			
			
			int fileIndex=1;
			int urlIndex=0;
			//MultipartFile [] portfolioFile,String []portfolioURL,String []contentOrder,String [] contentIntro,
			//String [] portfolioContentName
			for(int i=0;i<contentOrder.length;i++) {
				if(portfolioContentName[i].equals("image")) {
					
				}else if(portfolioContentName[i].equals("ppt")) {
					
				}else {
					
				}
			}
			
			
			
			
			
			
			
			
			
			//포폴 content
//			String [] names=request.getParameterValues("portfolioContentName");
//			String [] values=request.getParameterValues("portfolioContentValue");
//			String [] intros=request.getParameterValues("portfolioContentIntro");
//			String [] layout=request.getParameterValues("portfolioContentLayoutId");
//			Collection<Part> files=request.getParts();
//			/*for(Part p:files)
//				System.out.println("''"+p.getSubmittedFileName());
//			
//			return;*/
//		
//			for(int i=0;i<names.length;i++){
//				PortfolioContentVO cv=new PortfolioContentVO("","",Integer.toString(i+1),layout[i],names[i],values[i]);
//				PortfolioContentVO cv2=new PortfolioContentVO("","",Integer.toString(i+1),layout[i],"text",intros[i]);
//			}
//			
//			PortfolioVO pv=new PortfolioVO("", title, intro, startDate, endDate, teamName, peopleNumber, role, work, skills,"2018-08-15", best, file.getName(), category, memberId);
//			System.out.println(pv);
			Map<Object,Part> param=new HashMap<Object,Part>();
//			param.put(portfolioVO,file);
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
