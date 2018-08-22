package com.teamwith.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamwith.dao.CommentDAO;
import com.teamwith.dao.FaqDAO;
import com.teamwith.dao.RecruitDAO;
import com.teamwith.dao.RequireSkillDAO;
import com.teamwith.dao.TeamDAO;
import com.teamwith.dao.TeamDetailDAO;
import com.teamwith.dao.TeamSimpleDAO;
import com.teamwith.dao.TeamSkillDAO;
import com.teamwith.dto.CommentDTO;
import com.teamwith.dto.FaqDTO;
import com.teamwith.dto.RecruitDTO;
import com.teamwith.dto.RequireSkillDTO;
import com.teamwith.dto.TeamDTO;
import com.teamwith.dto.TeamSkillDTO;
import com.teamwith.util.Criteria;
import com.teamwith.util.UploadFileUtils;
import com.teamwith.vo.CommentVO;
import com.teamwith.vo.FaqVO;
import com.teamwith.vo.InterviewVO;
import com.teamwith.vo.RecruitVO;
import com.teamwith.vo.RequireSkillVO;
import com.teamwith.vo.TeamDetailVO;
import com.teamwith.vo.TeamSimpleVO;
import com.teamwith.vo.TeamSkillVO;

@Service
public class TeamService {
	@Inject
	private FaqDAO faqDAO;
	@Inject
	private TeamSimpleDAO teamSimpleDAO;
	@Inject
	private RequireSkillDAO requireSkillDAO;
	@Inject
	private RecruitDAO recruitDAO;
	@Inject
	private CommentDAO commentDAO;
	@Inject
	private TeamDAO teamDAO;
	@Inject
	private TeamSkillDAO teamSkillDAO;
	@Inject
	private TeamDetailDAO teamDetailDAO;

	public List<FaqVO> getFaq(String teamId) throws Exception {
		List<FaqDTO> result = faqDAO.searchFaqByTeamId(teamId);
		List<FaqVO> faq = new ArrayList<FaqVO>();

		for (FaqDTO faqDTO : result) {
			faq.add(faqDTO.toVO());
		}
		return faq;
	}

	public List<TeamSimpleVO> getMyTeam(Criteria cri, String memberId) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("memberId", memberId);
		paramMap.put("page", cri.getPage());
		paramMap.put("perPageNum", cri.getPerPageNum());
		List<TeamSimpleVO> result = teamSimpleDAO.searchTeamSimpleAllByMemberId(paramMap);

		return result;
	}

	public TeamSimpleVO getTeamSimple(String teamId) throws Exception {
		TeamSimpleVO result = teamSimpleDAO.searchTeamSimple(teamId);
		return result;
	}

	public List<TeamSimpleVO> getJoinedTeam(Criteria cri) throws Exception {
		List<TeamSimpleVO> result = teamSimpleDAO.searchTeamSimpleAllByTeamId(cri);

		return result;
	}

	public List<RequireSkillVO> getRequireSkills(String recruitId) throws Exception {
		List<RequireSkillDTO> list = requireSkillDAO.searchRequireSkillByRecruitId(recruitId);
		List<RequireSkillVO> result = new ArrayList<RequireSkillVO>();

		for (RequireSkillDTO obj : list) {
			result.add(obj.toVO());
		}

		return result;
	}

	public RequireSkillVO getRequireSkillsKyu(String recruitId) throws Exception {
		RequireSkillVO result = new RequireSkillVO();
		List<RequireSkillDTO> skills = requireSkillDAO.searchRequireSkillByRecruitId(recruitId);
		List<String> convert = new ArrayList<String>();
		for (RequireSkillDTO dto : skills) {
			convert.add(dto.getSkillId());
		}
		result.setRecruitId(recruitId);
		result.setSkillIds(convert);
		return result;
	}

	// 이 메소드.. 뭔가 이상하오..
	public List<RequireSkillVO> getRequireSkillsByTeamId(String teamId) throws Exception {
		List<RequireSkillDTO> list = requireSkillDAO.searchRequireSkillByRecruitId(teamId);
		List<RequireSkillVO> result = new ArrayList<RequireSkillVO>();

		for (RequireSkillDTO obj : list) {
			result.add(obj.toVO());
		}

		return result;
	}

	public List<RecruitVO> getRecruitInfo(String teamId) throws Exception {
		List<RecruitDTO> list = recruitDAO.searchRecruitByTeamId(teamId);
		List<RecruitVO> result = new ArrayList<RecruitVO>();

		for (RecruitDTO obj : list) {
			result.add(obj.toVO());
		}

		return result;
	}

	public int registerComment(CommentVO comment) throws Exception {
		List<String> commentId = commentDAO.getId();

		String generatedId = generateId(commentId, "comment");
		comment.setCommentId(generatedId);
		int result = commentDAO.addComment(comment.toDTO());

		return result;
	}

	public int removeCommnet(String commentId) throws Exception {
		int result = commentDAO.removeCommentByCommentId(commentId);

		return result;
	}

	public int updateComment(String commentId, String commentContent) throws Exception {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("commentId", commentId);
		paramMap.put("commentContent", commentContent);

		int result = commentDAO.updateCommentContent(paramMap);

		return result;
	}

	public List<CommentVO> getComments(String teamId) throws Exception {
		List<CommentDTO> list = commentDAO.searchCommentByTeamId(teamId);
		List<CommentVO> result = new ArrayList<CommentVO>();

		for (CommentDTO obj : list) {
			result.add(obj.toVO());
		}

		return result;
	}

	public List<TeamSimpleVO> getRecentTeam(Criteria cri) throws Exception {
		List<TeamSimpleVO> result = teamSimpleDAO.searchRecentTeamSimple(cri);

		return result;
	}

	public List<String> searchTeam(Criteria cri) throws Exception {
		List<String> result = new ArrayList<String>();

		List<TeamDTO> list = teamDAO.searchTeamByCondition(cri);

		for (TeamDTO obj : list) {
			result.add(obj.getTeamId());
		}

		return result;
	}

	public List<String> searchTeamByRoleSkill(Criteria cri) throws Exception {
		List<String> result = new ArrayList<String>();

		List<TeamSkillVO> list = teamSkillDAO.searchTeamByRoleSkill(cri);

		for (TeamSkillVO obj : list) {
			result.add(obj.getTeamId());
		}

		return result;
	}

	public List<String> searchTeamDTO(Criteria cri) throws Exception {
		List<String> result = new ArrayList<String>();

		List<TeamSkillDTO> list = teamSkillDAO.searchTeamDTOByRoleSkill(cri);

		for (TeamSkillDTO obj : list) {
			result.add(obj.getTeamId());
		}

		return result;
	}

	public List<TeamSimpleVO> getTeamListByTeamId(Criteria cri) throws Exception {
		List<TeamSimpleVO> result = teamSimpleDAO.searchTeamSimpleAllByTeamId(cri);

		return result;
	}

	public int registerFaq(List<FaqVO> faq) throws Exception {
		int result = 0;

		for (FaqVO obj : faq) {
			List<String> faqId = faqDAO.getId();

			String generatedId = generateId(faqId, "faq");
			obj.setFaqId(generatedId);

			result += faqDAO.addFaq(obj.toDTO());
		}

		return result;
	}

	public List<String> registerRecruit(List<RecruitVO> recruit) throws Exception {
		List<String> result = new ArrayList<String>();

		for (RecruitVO obj : recruit) {
			List<String> recruitId = recruitDAO.getId();

			String genereatedId = generateId(recruitId, "recruit");
			obj.setRecruitId(genereatedId);
			result.add(genereatedId);

			recruitDAO.addRecruit(obj.toDTO());
		}

		return result;
	}

	public int registerRequireSkill(RequireSkillVO requireSkill) throws Exception {
		int result = 0;

		for (RequireSkillDTO obj : requireSkill.toDTO()) {
			result += requireSkillDAO.addRequireSkill(obj);
		}

		return result;
	}

	@Transactional
	public String registerTeam(ApplicationService applicationService, TeamDetailVO teamInfo, byte[] file, String path,
			List<InterviewVO> interviewList, List<FaqVO> faqList, List<RecruitVO> recruitList,
			List<RequireSkillVO> requireSkillList) throws Exception {
		List<String> teamId = teamDAO.getId();
		String generatedId = generateId(teamId, "team");

		TeamDTO team = new TeamDTO();

		team.setTeamId(generatedId);
		team.setTeamProjectName(teamInfo.getTeamProjectName());
		team.setTeamName(teamInfo.getTeamName());
		team.setTeamSummary(teamInfo.getTeamSummary());
		team.setTeamContent(teamInfo.getTeamContent());
		team.setProjectCategoryId(teamInfo.getProjectCategoryId());
		team.setRegionId(teamInfo.getRegionId());
		team.setTeamEndDate(Date.valueOf(teamInfo.getTeamEndDate()));
		team.setTeamContestName(teamInfo.getTeamContestName());
		team.setTeamContestLink(teamInfo.getTeamContestLink());
		team.setMemberId(teamInfo.getMemberId());

		String teamPicPath = UploadFileUtils.uploadFile2(path, generatedId + ".jpg", file);

		team.setTeamPic("/resources/image/team/" + generatedId + ".jpg");

		teamDAO.addTeam(team);

		for (InterviewVO interview : interviewList) {
			interview.setTeamId(generatedId);
		}
		applicationService.registerInteviewQuestion(interviewList);

		for (FaqVO faq : faqList) {
			faq.setTeamId(generatedId);
		}
		registerFaq(faqList);

		for (RecruitVO recruit : recruitList) {
			recruit.setTeamId(generatedId);
		}
		List<String> recruitIds = registerRecruit(recruitList);

		for (int i = 0; i < requireSkillList.size(); i++) {
			RequireSkillVO requireSkillVO = requireSkillList.get(i);
			requireSkillVO.setRecruitId(recruitIds.get(i));
			registerRequireSkill(requireSkillVO);
		}
		return generatedId;
	}

	public int removeTeam(String teamId) throws Exception {
		int result = teamDAO.removeTeamByTeamId(teamId);

		return result;
	}

	public TeamDetailVO getTeamInfo(String teamId) throws Exception {
		TeamDetailVO result = teamDetailDAO.searchTeamDetailByTeamId(teamId);

		return result;
	}

	public int updateFaq(List<FaqVO> faq) throws Exception {
		int result = 0;

		if (faq != null && !faq.isEmpty()) {
			faqDAO.removeFaqByTeamId(faq.get(0).getTeamId());
			for (FaqVO obj : faq) {
				List<String> faqId = faqDAO.getId();
				String generatedId = generateId(faqId, "faq");
				obj.setFaqId(generatedId);
				result += faqDAO.addFaq(obj.toDTO());
			}
		}
		return result;
	}

	public List<String> updateRecruit(List<RecruitVO> recruit) throws Exception {
		List<String> result = new ArrayList<String>();

		if (recruit != null && !recruit.isEmpty()) {
			String teamId = recruit.get(0).getTeamId();
			recruitDAO.removeRecruitByTeamId(teamId);
			for (RecruitVO obj : recruit) {
				String generatedId = generateId(recruitDAO.getId(), "team");
				obj.setRecruitId(generatedId);
				recruitDAO.addRecruit(obj.toDTO());
				result.add(obj.getRecruitId());
			}
		}
		return result;
	}

	public List<RequireSkillDTO> removeRequireSkill(RequireSkillVO requireSkill) throws Exception {
		List<RequireSkillDTO> result = new ArrayList<RequireSkillDTO>();

		for (RequireSkillDTO obj : requireSkill.toDTO()) {
			requireSkillDAO.removeRequireSkill(obj);
			result.add(obj);
		}

		return result;
	}

	public int updateRequireSkill(RequireSkillVO requireSkill) throws Exception {
		return registerRequireSkill(requireSkill);
	}
	@Transactional
	public String updateTeam(ApplicationService applicationService,TeamDetailVO teamInfo, byte[] file, String path, List<InterviewVO> interviewList,
			List<FaqVO> faqList, List<RecruitVO> recruitList, List<RequireSkillVO> requireSkillList) throws Exception {
		
		TeamDTO team = new TeamDTO();

		team.setTeamId(teamInfo.getTeamId());
		team.setTeamProjectName(teamInfo.getTeamProjectName());
		team.setTeamName(teamInfo.getTeamName());
		team.setTeamSummary(teamInfo.getTeamSummary());
		team.setTeamContent(teamInfo.getTeamContent());
		team.setProjectCategoryId(teamInfo.getProjectCategoryId());
		team.setRegionId(teamInfo.getRegionId());
		team.setTeamEndDate(Date.valueOf(teamInfo.getTeamEndDate()));
		team.setTeamPic(teamInfo.getTeamPic());
		team.setTeamContestName(teamInfo.getTeamContestName());
		team.setTeamContestLink(teamInfo.getTeamContestLink());
		team.setMemberId(teamInfo.getMemberId());

		if (file != null) {
			String teamPicPath = UploadFileUtils.uploadFile2(path, team.getTeamId() + ".jpg", file);
			team.setTeamPic("/resources/image/team/" + team.getTeamId() + ".jpg");
		}
		
		teamDAO.updateTeam(team);
		applicationService.updateInterviewQuestion(interviewList);
		updateFaq(faqList);
		List<String> recruitIds=updateRecruit(recruitList);
		for(int i=0;i<requireSkillList.size();i++) {
			RequireSkillVO requireSkill=requireSkillList.get(i);
			requireSkill.setRecruitId(recruitIds.get(i));
			updateRequireSkill(requireSkill);
		}
		return team.getTeamId();
	}

	public int changeTeamStatus(int status, String teamId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", status);
		map.put("teamId", teamId);

		int result = teamDAO.updateTeamStatus(map);

		return result;
	}

	private String generateId(List<String> id, String tableName) {
		if (id == null) {
			return tableName + "-" + 1;
		}

		int maxCnt = -1;

		for (String str : id) {
			if (maxCnt < Integer.parseInt(str.split("-")[1])) {
				maxCnt = Integer.parseInt(str.split("-")[1]);
			}
		}

		return tableName + "-" + (maxCnt + 1);
	}

}
