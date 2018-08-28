package com.teamwith.restcontroller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.org.eclipse.jdt.core.dom.SynchronizedStatement;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.teamwith.service.MemberService;
import com.teamwith.service.ProfileService;
import com.teamwith.util.Criteria;
import com.teamwith.vo.MemberSearchVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MemberVO;

@RequestMapping("/api/member")
@RestController
public class MemberRestController {
	@Inject
	private MemberService memberService;

	@Inject
	private ProfileService profileService;

	@ResponseBody
	@RequestMapping(value = "/bestMember", method = RequestMethod.GET)
	public List<MemberSearchVO> getBestMember(Criteria cri) throws Exception {
		System.out.println("bestMember");
		List<MemberSearchVO> member = memberService.getBestMember(cri);
		for (MemberSearchVO m : member)
			System.out.println(m);
		return member;
	}

	@ResponseBody
	@RequestMapping(value = "/getEditInfo", method = RequestMethod.GET)
	public MemberVO memberEditInfo(HttpSession session) {
		try {
			MemberSimpleVO member = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
			return profileService.getMyInfo(member.getMemberId());

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/editInfo", method = RequestMethod.GET)
	public String memberEditInfoProcess(HttpSession session, String roleId, String regionId1, String regionId2,
			String memberIntro, String memberPic, HttpServletRequest req) {
		MemberSimpleVO msVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		String memberId;
		if (msVO == null) {
			return null;
		} else {
			memberId = msVO.getMemberId();
		}
		MemberVO member = new MemberVO();
		member.setMemberPic(memberPic);
		member.setMemberId(memberId);
		member.setRoleId(roleId);
		member.setRegionId1(regionId1);
		member.setRegionId2(regionId2);
		member.setMemberIntro(memberIntro);
		try {
			return "" + profileService.updateMemberInfo(member);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/image", method = RequestMethod.POST)
	public String file(HttpSession session, HttpServletRequest req) {
		MemberSimpleVO msVO = (MemberSimpleVO) session.getAttribute("memberSimpleVO");
		String memberId;
		if (msVO == null) {
			return null;
		} else {
			memberId = msVO.getMemberId();
		}

		String name = null;
		String fileName = null;
		String folderTypePath = "c:/data";
		int sizeLimit = 1000 * 1024 * 1024; // 5메가까지 제한 넘어서면 예외발생
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(req, folderTypePath, sizeLimit, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Enumeration files = multi.getFileNames();

		// 파일 정보가 있다면
		if (files.hasMoreElements()) {
			name = (String) files.nextElement();
			fileName = multi.getFilesystemName(name);
		}

		File file = multi.getFile(name);
		String newFilename = null;

		if (file != null) {
			String rootPath = session.getServletContext().getRealPath("/");
			String attachPath = "resources\\image\\member\\" + memberId;
			String filename = fileName;
			try {
				newFilename = uploadFile(rootPath, attachPath, filename, file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(newFilename);
		return newFilename;
	}

	private String uploadFile(String uploadPath, String attachPath, String originalName, File fileData)
			throws Exception {
		String newFilename = attachPath + ".png";

		String[] str = attachPath.split("\\\\");
		String memId = str[str.length - 1];
		File dir = new File(uploadPath);
		if (!dir.exists()) {
			dir.mkdirs(); // 존재하지 않는 모든 폴더 생성
		}
		File target = new File(uploadPath, newFilename);
		FileCopyUtils.copy(fileData, target);
		return "/resources/image/member/" + memId + ".png";
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<MemberSearchVO> member(Criteria cri, String[] region, String[] project, String[] role, String[] skill,
			String textCondition, String keyword) throws Exception {
		System.out.println("api member access");
		if (cri == null) {
			cri = new Criteria();
		}

		if (region == null && project == null && role == null && skill == null
				&& (keyword == null || keyword.trim().equals(""))) {

			return memberService.getRecentMember(cri);
		}

		else {
			List<String> resultIdList = null;
			List<MemberSearchVO> resultMemberList = new ArrayList<MemberSearchVO>();
			List<String> memberIdListByRegion = null;
			List<String> memberIdListByRole = null;
			List<String> memberIdListByCategory = null;
			List<String> memberIdListBySkill = null;
			List<String> memberIdListByKeyword = null;

			if (region != null) {
				Criteria regionCri = new Criteria();
				List<String> regionList = new ArrayList<String>();
				for (String regionStr : region) {
					regionList.add(regionStr);
				}
				System.out.println(regionList);
				regionCri.addCriteria("regionList", regionList);
				memberIdListByRegion = memberService.getMemberIdByRegionList(regionCri);
				System.out.println(memberIdListByRegion);
				if (memberIdListByRegion != null) {
					resultIdList = new ArrayList<String>();
					resultIdList.addAll(memberIdListByRegion);
				}
			}

			if (role != null) {
				Criteria roleCri = new Criteria();
				List<String> roleList = new ArrayList<String>();
				for (String roleStr : role) {
					roleList.add(roleStr);
				}
				roleCri.addCriteria("roleList", roleList);
				memberIdListByRole = memberService.getMemberIdByRoleList(roleCri);
				if (memberIdListByRole != null) {
					if (resultIdList == null) {
						resultIdList = new ArrayList<String>();
						for (String teamId : memberIdListByRole) {
							if (!resultIdList.contains(teamId)) {
								resultIdList.add(teamId);
							}
						}
					} else {
						for (int i = 0; i < resultIdList.size(); i++) {
							boolean flag = false;
							for (int j = 0; j < memberIdListByRole.size(); j++) {
								if (resultIdList.get(i).equals(memberIdListByRole.get(j))) {
									flag = true;
								}
							}
							if (flag == false) {
								resultIdList.set(i, "empty");
							}
						}
					}
				}
			}

			if (project != null) {
				List<String> projectCategoryId = new ArrayList<String>();
				for (String projectStr : project) {
					projectCategoryId.add(projectStr);
				}
				memberIdListByCategory = memberService.getMemberByProjectCategoryId(projectCategoryId);

				if (memberIdListByCategory != null) {
					if (resultIdList == null) {
						resultIdList = new ArrayList<String>();
						for (String memberId : memberIdListByCategory) {
							if (!resultIdList.contains(memberId)) {
								resultIdList.add(memberId);
							}
						}
					} else {
						for (int i = 0; i < resultIdList.size(); i++) {
							boolean flag = false;
							for (int j = 0; j < memberIdListByCategory.size(); j++) {
								if (resultIdList.get(i).equals(memberIdListByCategory.get(j))) {
									flag = true;
								}
							}
							if (flag == false) {
								resultIdList.set(i, "empty");
							}
						}
					}
				}
			}

			if (skill != null) {
				List<String> skillList = new ArrayList<String>();
				for (String skillStr : skill) {
					skillList.add(skillStr);
				}
				memberIdListBySkill = memberService.getMemberBySkillId(skillList);
				if (memberIdListBySkill != null) {
					if (resultIdList == null) {
						resultIdList = new ArrayList<String>();
						for (String teamId : memberIdListBySkill) {
							if (!resultIdList.contains(teamId)) {
								resultIdList.add(teamId);
							}
						}
					} else {
						for (int i = 0; i < resultIdList.size(); i++) {
							boolean flag = false;
							for (int j = 0; j < memberIdListBySkill.size(); j++) {
								if (resultIdList.get(i).equals(memberIdListBySkill.get(j))) {
									flag = true;
								}
							}
							if (flag == false) {
								resultIdList.set(i, "empty");
							}
						}
					}
				}
			}
			if (keyword != null) {
				if (!keyword.trim().equals("")) {
					Criteria textCri = new Criteria();
					textCri.addCriteria("memberName", keyword.trim());
					memberIdListByKeyword = memberService.getMemberIdByCondition(textCri);

					if (memberIdListByKeyword != null) {
						if (resultIdList == null) {
							resultIdList = new ArrayList<String>();
							for (String teamId : memberIdListByKeyword) {
								if (!resultIdList.contains(teamId)) {
									resultIdList.add(teamId);
								}
							}
						} else {
							for (int i = 0; i < resultIdList.size(); i++) {
								boolean flag = false;
								for (int j = 0; j < memberIdListByKeyword.size(); j++) {
									if (resultIdList.get(i).equals(memberIdListByKeyword.get(j))) {
										flag = true;
									}
								}
								if (flag == false) {
									resultIdList.set(i, "empty");
								}
							}
						}
					}
				}
			}

			for (String resultId : resultIdList) {
				if (!resultId.equals("empty")) {
					MemberSearchVO memberSearchVO = memberService.getMemberSearchInfo(resultId);
					if (memberSearchVO != null) {
						resultMemberList.add(memberSearchVO);
					}
				}
			}
			return resultMemberList;
		}
	}
}
