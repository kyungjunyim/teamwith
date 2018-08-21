package com.teamwith.controller;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.teamwith.service.PologService;
import com.teamwith.util.UploadFileUtils;
import com.teamwith.vo.PologVO;

@RequestMapping(value = "/polog")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@Controller
public class PologController {
	private static final Logger logger = LoggerFactory.getLogger(PologController.class);

	String jspPath = "polog/jsp/";

	@Inject
	PologService pologService;

	@RequestMapping(value = "/edit/{memId}", method = RequestMethod.GET)
	public String pologEditView(@PathVariable(value = "memId") String memberId, Model model) {
		model.addAttribute("pologVO", pologService.getPologInfo(memberId));
		if (memberId != null) {
			// logger.info(pologService.getPologInfo(memberId).getPologIntro());
		} else {
			logger.info("mem null^^");
		}
		return jspPath + "pologEdit";
	}

	@RequestMapping(value = "/edit/{memId}", method = RequestMethod.POST)
	public String pologEdit(@PathVariable(value = "memId") String memId, PologVO vo, MultipartFile pologBgPicFile,
			Model model, HttpSession session) {
		logger.info(vo.getPologTitle() + vo.getPologIntro() + vo.getPologBgColor());
		String rootPath = session.getServletContext().getRealPath("/");
		String attachPath = "resources\\\\image\\\\polog\\\\" + memId;
		String filename = pologBgPicFile.getOriginalFilename();
		String newFilename = null;
		try {
			newFilename = uploadFile(rootPath, attachPath, filename, pologBgPicFile.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(newFilename);
		vo.setPologBgPic(newFilename);
		pologService.updatePolog(vo);
		return "redirect:/polog/" + memId;
	}

	private String uploadFile(String uploadPath, String attachPath, String originalName, byte[] fileData)
			throws Exception {
		String newFilename = attachPath + getNewFilename(originalName);
		String[] str = attachPath.split("\\\\");
		String memId = str[str.length-1];
		File dir = new File(uploadPath);
		if (!dir.exists()) {
			dir.mkdirs(); // 존재하지 않는 모든 폴더 생성
		}
		File target = new File(uploadPath, newFilename);
		FileCopyUtils.copy(fileData, target);
		return "/resources/image/polog/" + memId + getNewFilename(originalName);
	}

	private String getNewFilename(String filename) {
		if (filename.contains(".")) {
			return filename.substring(filename.indexOf('.'));
		}
		return null;
	}
}
