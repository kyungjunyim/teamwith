package com.teamwith.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.teamwith.service.MemberService;
import com.teamwith.service.ProfileService;
import com.teamwith.vo.MemberProjectCategoryVO;
import com.teamwith.vo.MemberSkillVO;
import com.teamwith.vo.MemberTendencyVO;
import com.teamwith.vo.MemberVO;
import com.teamwith.vo.TendencyVO;

@RequestMapping(value = "/profile")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@Controller
public class ProfileController {

	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

	String jspPath = "polog/jsp/";

	@Inject
	ProfileService profileService;
	@Inject
	MemberService memberService;

	@RequestMapping(value = "/edit/{memId}", method = RequestMethod.GET)
	public String profileEditView(@PathVariable(value = "memId") String memberId, Model model) {
		try {
			MemberVO mem = profileService.getMyInfo(memberId);

			List<String> projectCategory = memberService.getMemberProjectCategory(memberId);
			MemberSkillVO skill = memberService.getMemberSkill(memberId);
			MemberTendencyVO tendency = profileService.getMemberTendency(memberId);

			model.addAttribute("memberVO", mem);
			model.addAttribute("memberProjectCategoryList", projectCategory);
			model.addAttribute("skillVO", skill);
			model.addAttribute("tendencyVO", tendency);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jspPath + "profileEdit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String profileEdit(MemberVO updateMemberInfo, MultipartFile file, String[] regionId, String[] skill,
			String[] categoryId, Model model, TendencyVO tendency, HttpSession session) {

		String memberId = updateMemberInfo.getMemberId();
		if (regionId != null) {
			updateMemberInfo.setRegionId1(regionId[0]);
			if (regionId.length == 2) {
				updateMemberInfo.setRegionId2(regionId[1]);
			}
		}

		try {
			if (file != null && !file.getOriginalFilename().trim().equals("")) {
				String rootPath = session.getServletContext().getRealPath("/");
				String attachPath = "resources\\image\\member\\" + memberId;
				String filename = file.getOriginalFilename();
				String newFilename = uploadFile(rootPath, attachPath, filename, file.getBytes());
				updateMemberInfo.setMemberPic(newFilename);
			}
			/* memberInfo */
			profileService.updateMemberInfo(updateMemberInfo);

			MemberProjectCategoryVO pcVO = new MemberProjectCategoryVO(memberId, categoryId);
			memberService.updateMemberProjectCategory(pcVO);

			memberService.updateMemberSkill(new MemberSkillVO(memberId, skill));

			Map<String, String> tdMap = new HashMap<String, String>();
			tdMap.put("tendency-1", tendency.getTendency1());
			tdMap.put("tendency-2", tendency.getTendency2());
			tdMap.put("tendency-3", tendency.getTendency3());
			tdMap.put("tendency-4", tendency.getTendency4());
			tdMap.put("tendency-5", tendency.getTendency5());

			MemberTendencyVO memberTendency = new MemberTendencyVO(memberId, tdMap);
			profileService.updateMemberTendency(memberTendency);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/polog/" + memberId;

	}

	private String uploadFile(String uploadPath, String attachPath, String originalName, byte[] fileData)
			throws Exception {
		String newFilename = attachPath + getNewFilename(originalName);

		File dir = new File(uploadPath);
		if (!dir.exists()) {
			dir.mkdirs(); // 존재하지 않는 모든 폴더 생성
		}
		File target = new File(uploadPath, newFilename);
		FileCopyUtils.copy(fileData, target);
		return "\\" + newFilename;
	}

	private String getNewFilename(String filename) {
		if (filename.contains(".")) {
			return filename.substring(filename.indexOf('.'));
		}
		return null;
	}

}
