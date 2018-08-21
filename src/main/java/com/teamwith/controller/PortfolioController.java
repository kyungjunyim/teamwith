package com.teamwith.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.plaf.synth.SynthSpinnerUI;

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
import com.teamwith.vo.MemberSimpleVO;
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
		System.out.println("컨트롤러 포폴 :"+portfolioVO);
		try {
			MemberSimpleVO memberSimpleVO=(MemberSimpleVO)session.getAttribute("memberSimpleVO");
			if(memberSimpleVO==null||memberSimpleVO.getMemberId().isEmpty()||memberSimpleVO.getMemberId()==null){
				model.addAttribute("error","not login status");
				return "/polog/jsp/errorPage";
			}
			if(portfolioVO.getPortfolioBest()==null){
				portfolioVO.setPortfolioBest("0");
			}else{
				portfolioVO.setPortfolioBest("1");
			}
			portfolioVO.setMemberId(memberSimpleVO.getMemberId());
			portfolioVO.setPortfolioUpdateDate("2018-08-19");
			
			System.out.println("파일정보");
			for(MultipartFile m:portfolioFile) {
				System.out.println("1");
				System.out.println(m.getOriginalFilename());
			}
			
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
						portfolioContent=new PortfolioContentVO("","",Integer.toString(i+1),layoutId[i],portfolioContentName[i],"",contentIntro[i]);
						
						if(portfolioFile[fileIndex]!=null) {
					        param.put(portfolioContent,portfolioFile[fileIndex]);
						}
						else {
					        param.put(portfolioContent,null);
						}
						fileIndex=fileIndex+1;
					}else if(portfolioContentName!=null&&portfolioContentName[i].equals("ppt")) {
						portfolioContent=new PortfolioContentVO("","",Integer.toString(i+1),layoutId[i],portfolioContentName[i],"",contentIntro[i]);
						
						if(portfolioFile[fileIndex]!=null) {
					        param.put(portfolioContent,portfolioFile[fileIndex]);
						}
						else {
					        param.put(portfolioContent,null);
						}
						fileIndex=fileIndex+1;
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
		PortfolioVO portfolio=pologService.getPortfolio(portfolioId);
		List<PortfolioContentVO> portfolioContentList=pologService.getPortfolioContent(portfolioId);
		
		model.addAttribute("portfolioVO",portfolio);
		model.addAttribute("portfolioContent",portfolioContentList);
		model.addAttribute("portfolioContentSize",portfolioContentList.size());
		return "/polog/jsp/editPortfolio";
	}
	@RequestMapping(value="/edit/{portfolioId}",method=RequestMethod.POST)
	public String editPortfolio(MultipartFile [] portfolioFile,String []portfolioURL,String []contentOrder,String [] contentIntro,
			String [] portfolioContentName,String [] layoutId,String [] oldContentImage,String [] oldContentPpt,String oldPortfolioPic,
			String [] portfolioContentId,String [] deleteContent,
			@ModelAttribute PortfolioVO portfolioVO,Model model,HttpSession session) {
		portfolioVO.setPortfolioPic(oldPortfolioPic);
		if(deleteContent!=null) {
			for(String s:deleteContent) {
				System.out.println("삭제 포폴컨텐츠 : "+s);
				pologService.removePortfolioContent(s);
			}
		}
		for(MultipartFile p:portfolioFile) {
			System.out.println(p.getContentType());
		}
		System.out.println("포폴Order 사이즈 "+contentOrder.length);
		String rootPath = session.getServletContext().getRealPath("/"); //service가 이 경로를 받을것
		rootPath=rootPath.replace("\\", "/");
		String portfolioId=portfolioVO.getPortfolioId();
		System.out.println("컨트롤러 포폴 :"+portfolioVO);
		try {
			MemberSimpleVO memberSimpleVO=(MemberSimpleVO)session.getAttribute("memberSimpleVO");
			if(memberSimpleVO==null||memberSimpleVO.getMemberId().isEmpty()||memberSimpleVO.getMemberId()==null){
				model.addAttribute("error","not login status");
				return "/polog/jsp/errorPage";
			}
			if(portfolioVO.getPortfolioBest()==null){
				portfolioVO.setPortfolioBest("0");
			}else{
				portfolioVO.setPortfolioBest("1");
			}
			portfolioVO.setMemberId(memberSimpleVO.getMemberId());
			portfolioVO.setPortfolioUpdateDate("2018-08-19");
			System.out.println("파일정보");
			for(MultipartFile m:portfolioFile) {
				System.out.println("1");
				System.out.println(m.getOriginalFilename());
			}
			
			int fileIndex=1;
			int imageIndex=0;
			int pptIndex=0;
			int urlIndex=0;
			Map<Object,MultipartFile> param=new HashMap<Object,MultipartFile>();
			if(portfolioFile[0].getSize()!=0) {
				pologService.updatePortfolio(portfolioVO, portfolioFile[0],rootPath);
			}
			else{
				pologService.updatePortfolio(portfolioVO, null,rootPath);
			}
			System.out.println("포폴수정성공");
			//MultipartFile [] portfolioFile,String []portfolioURL,String []contentOrder,String [] contentIntro,
			//String [] portfolioContentName
			System.out.println("@@@@@@@@@포폴컨텐츠 인트로");
			for(String s:contentIntro) {
				System.out.println(s);
			}
			if(contentOrder!=null) {
				for(int i=0;i<contentOrder.length;i++) {
					PortfolioContentVO portfolioContent=null;
					MultipartFile file=null;
					boolean old=true;
					if(portfolioContentName!=null&&portfolioContentName[i].equals("image")) {
						portfolioContent=new PortfolioContentVO("",portfolioId,contentOrder[i],layoutId[i],portfolioContentName[i],"",contentIntro[i]);
						
						if(portfolioContentId!=null) {
							if(i<portfolioContentId.length) {
								portfolioContent.setPortfolioContentId(portfolioContentId[i]);
								if(portfolioFile[fileIndex]==null||portfolioFile[fileIndex].getSize()==0) {
									portfolioContent.setPortfolioContentValue(oldContentImage[imageIndex]);
									imageIndex++;
								}
							}
						}
						
					}else if(portfolioContentName!=null&&portfolioContentName[i].equals("ppt")) {
						
						portfolioContent=new PortfolioContentVO("",portfolioId,Integer.toString(i+1),layoutId[i],portfolioContentName[i],"",contentIntro[i]);
						if(portfolioContentId!=null) {
							if(i<portfolioContentId.length) {
								portfolioContent.setPortfolioContentId(portfolioContentId[i]);
								if(portfolioFile[fileIndex]!=null&&portfolioFile[fileIndex].getSize()!=0) {
									portfolioContent.setPortfolioContentValue(oldContentPpt[pptIndex]);
									pptIndex++;
								}
							}
						}
					}else if(portfolioContentName!=null&&portfolioContentName[i].equals("media")){
						System.out.println(portfolioURL[urlIndex]);
								System.out.println(contentIntro[i]);
						System.out.println(portfolioContentName[i]);
						System.out.println(layoutId[i]);
						portfolioContent=new PortfolioContentVO("",portfolioId,Integer.toString(i+1),layoutId[i],portfolioContentName[i],
								portfolioURL[urlIndex],contentIntro[i]);
						if(portfolioContentId!=null) {
							if(i<portfolioContentId.length) {
								portfolioContent.setPortfolioContentId(portfolioContentId[i]);
							}
						}
						urlIndex++;
					}
					
					//서비스 메소드 호출
					if(portfolioContent.getPortfolioContentId().equals("")) {
						//새로등록
						if((portfolioContent.getPortfolioContentName().equals("ppt")||portfolioContent.getPortfolioContentName().equals("image"))&&
								portfolioFile.length>fileIndex&&portfolioFile[fileIndex]!=null&&portfolioFile[fileIndex].getSize()!=0) {
							pologService.registerPortfolioContent(portfolioContent, portfolioFile[fileIndex], rootPath);
							fileIndex=fileIndex+1;
						}else {
							pologService.registerPortfolioContent(portfolioContent, null, rootPath);
						}
						
						System.out.println("포포컬 수정");
					}
					else {
						//기존꺼수정
						if((portfolioContent.getPortfolioContentName().equals("ppt")||portfolioContent.getPortfolioContentName().equals("image"))&&
								portfolioFile.length>fileIndex&&portfolioFile[fileIndex]!=null&&portfolioFile[fileIndex].getSize()!=0) {
							pologService.updatePortfolioContent(portfolioContent,portfolioFile[fileIndex],rootPath);
							fileIndex=fileIndex+1;
						}else {
							pologService.updatePortfolioContent(portfolioContent,null,rootPath);
						}
						System.out.println("포포컬 수정");
					}
					
				}
			}
			
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
