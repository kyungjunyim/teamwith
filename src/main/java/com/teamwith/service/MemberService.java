package com.teamwith.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.teamwith.dao.MainProfileDAO;
import com.teamwith.dao.MemberPraiseDAO;
import com.teamwith.dao.MemberProjectCategoryDAO;
import com.teamwith.dao.MemberSearchDAO;
import com.teamwith.dao.MemberSkillDAO;
import com.teamwith.dto.MemberPraiseDTO;
import com.teamwith.dto.MemberProjectCategoryDTO;
import com.teamwith.dto.MemberSkillDTO;
import com.teamwith.vo.Criteria;
import com.teamwith.vo.MainProfileVO;
import com.teamwith.vo.MemberPraiseCntVO;
import com.teamwith.vo.MemberPraiseVO;
import com.teamwith.vo.MemberProjectCategoryVO;
import com.teamwith.vo.MemberSearchVO;
import com.teamwith.vo.MemberSimpleVO;
import com.teamwith.vo.MemberSkillVO;

@Service
public class MemberService {

	@Inject
	private MainProfileDAO mainProfileDAO;
	@Inject
	private MemberPraiseDAO memberPraiseDAO;
	@Inject
	private MemberProjectCategoryDAO memberProjectCategoryDAO;
	@Inject
	private MemberSearchDAO memberSearchDAO;
	@Inject
	private MemberSkillDAO memberSkillDAO;

	public MemberService() {
	}

	public MainProfileVO getMainProfile(String memberId) throws Exception {
		MainProfileVO result = mainProfileDAO.searchMainProfile(memberId);
		return result;
	}

	public MemberSearchVO getMemberSearchInfo(String memberId) throws Exception {
		if (memberId == null) {
			return null;
		}
		MemberSearchVO result = memberSearchDAO.searchMemberByMemberId(memberId);

		return result;
	}

	public List<MemberSearchVO> getBestMember(Criteria cri) throws Exception {
		if (cri == null) {
			return null;
		}
		List<MemberSearchVO> result = memberSearchDAO.searchMemberByPraiseCnt(cri);
		return result;
	}

	public List<MemberSearchVO> getRecentMember(Criteria cri) throws Exception {
		if (cri == null) {
			return null;
		}
		List<MemberSearchVO> result = memberSearchDAO.searchRecentMember(cri);
		return result;
	}

	public List<String> getMemberByProjectCategoryId(List<String> projectCategoryId) throws Exception {
		if (projectCategoryId == null) {
			return null;
		}
		List<MemberProjectCategoryDTO> temp = memberProjectCategoryDAO.searchMemberByProjectCategory(projectCategoryId);
		List<String> result = new ArrayList<String>();
		for (MemberProjectCategoryDTO m : temp) {
			result.add(m.getMemberId());
		}
		return result;
	}

	public List<MemberSimpleVO> getMemberByRoleRegion(Criteria cri) throws Exception {
		if (cri == null) {
			return null;
		}
		List<MemberSearchVO> temp = memberSearchDAO.searchMemberByRoleRegion(cri);
		List<MemberSimpleVO> result = new ArrayList<MemberSimpleVO>();
		for (MemberSearchVO m : temp) {
			MemberSimpleVO ms = new MemberSimpleVO();
			ms.setMemberId(m.getMemberId());
			ms.setMemberName(m.getMemberName());
			ms.setMemberPic(m.getMemberPic());
			result.add(ms);
		}
		return result;
	}
	
	public List<String> getMemberIdByRegionList(Criteria cri) throws Exception {
		if(cri == null) {
			return null;
		}
		List<MemberSearchVO> temp = memberSearchDAO.searchMemberIdByRegionList(cri);
		List<String> result = new ArrayList<String>();
		
		for(MemberSearchVO memberSearchVO : temp) {
			result.add(memberSearchVO.getMemberId());
		}
		return result;
	}
	
	public List<String> getMemberIdByRoleList(Criteria cri) throws Exception {
		if(cri == null) {
			return null;
		}
		List<MemberSearchVO> temp = memberSearchDAO.searchMemberIdByRoleList(cri);
		List<String> result = new ArrayList<String>();
		
		for(MemberSearchVO memberSearchVO : temp) {
			result.add(memberSearchVO.getMemberId());
		}
		return result;
	}
	
	public List<String> getMemberIdByCondition(Criteria cri) throws Exception {
		if(cri == null) {
			return null;
		}
		List<MemberSearchVO> temp = memberSearchDAO.searchMember(cri);
		List<String> result = new ArrayList<String>();
		
		for(MemberSearchVO memberSearchVO : temp) {
			result.add(memberSearchVO.getMemberId());
		}
		return result;
	}
	
	public List<String> getMemberBySkillId(List<String> skillId) throws Exception {
		if (skillId == null) {
			return null;
		}
		List<MemberSkillDTO> temp = memberSkillDAO.searchMemberBySkill(skillId);
		List<String> result = new ArrayList<String>();
		for (MemberSkillDTO m : temp) {
			result.add(m.getMemberId());
		}
		return result;
	}

	public Criteria searchMemberRoleRegion(String memberId) throws Exception {
		if (memberId == null) {
			return null;
		}
		MemberSearchVO temp = memberSearchDAO.searchMemberByMemberId(memberId);
		Criteria result = new Criteria();
		result.addCriteria("memberRegion1", temp.getRegionId1());
		result.addCriteria("memberRegion2", temp.getRegionId2());
		result.addCriteria("memberRole", temp.getRoleId());

		return result;
	}

	public List<String> getMemberProjectCategory(String memberId) throws Exception {
		if (memberId == null) {
			return null;
		}
		List<MemberProjectCategoryDTO> temp = memberProjectCategoryDAO.searchProjectCategoryByMember(memberId);
		List<String> result = new ArrayList<String>();
		for (MemberProjectCategoryDTO m : temp) {
			result.add(m.getProjectCategoryId());
		}

		return result;
	}

	public MemberSkillVO getMemberSkill(String memberId) throws Exception {
		if (memberId == null) {
			return null;
		}
		List<MemberSkillDTO> temp = memberSkillDAO.searchSkillByMember(memberId);
		MemberSkillVO result = new MemberSkillVO(temp);

		return result;
	}

	public List<MemberPraiseCntVO> getMemberPraiseCnt(String memberId) throws Exception {
		if (memberId == null) {
			return null;
		}
		List<MemberPraiseCntVO> result = memberPraiseDAO.searchMemberPraiseCnt(memberId);
		if (result.isEmpty()) {
			for (int i = 1; i <= 5; i++) {
				result.add(new MemberPraiseCntVO(memberId, "praise-" + i, "0"));
			}
		}
		if (result.size() < 5) {
			for (int j = 1; j <= 5; j++) {
				for (int i = 1; i <= result.size(); i++) {
					if (result.get(i).getPraiseId().equals("praise-" + j)) {
						break;
					}
					result.add(new MemberPraiseCntVO(memberId, "praise-" + j, "0"));
				}
			}
		}

		return result;
	}

	public int removeMemberProjectCategory(String memberId) throws Exception {
		if (memberId == null) {
			return -1;
		}
		int result = memberProjectCategoryDAO.removeMemberProjectCategoryByMemberId(memberId);

		return result;
	}

	public int updateMemberProjectCategory(MemberProjectCategoryVO memberProjectCategory) throws Exception {
		if (memberProjectCategory == null) {
			return -1;
		}
		if (memberProjectCategory != null) {
			int result = memberProjectCategoryDAO
					.removeMemberProjectCategoryByMemberId(memberProjectCategory.getMemberId());

			for (MemberProjectCategoryDTO m : memberProjectCategory.toDTO()) {
				memberProjectCategoryDAO.addMemberProjectCategory(m);
			}
		}
		return 0;
	}

	public int removeMemberSkill(String memberId) throws Exception {
		if (memberId == null) {
			return -1;
		}
		int result = memberSkillDAO.reomveMemberAllSkill(memberId);

		return result;
	}

	public int updateMemberSkill(MemberSkillVO memberSkill) throws Exception {
		if (memberSkill == null) {
			return -1;
		}
		int result = removeMemberSkill(memberSkill.getMemberId());
		for (MemberSkillDTO m : memberSkill.toDTO()) {
			memberSkillDAO.addMemberSkill(m);
		}

		return result;
	}

	public int updateMemberPraise(List<MemberPraiseVO> praise) throws Exception {
		if (praise == null || praise.isEmpty()) {
			return -1;
		}

		int result = memberPraiseDAO.removeMemberPraise(praise.get(0).toDTO());
		for (MemberPraiseVO m : praise) {
			result = memberPraiseDAO.addMemberPraise(m.toDTO());
			if (result != 1) {
				return -1;
			}
		}

		return result;
	}

	public void removeMemberPraise(String actor, String target) throws Exception {
		memberPraiseDAO.removeMemberPraise(new MemberPraiseDTO(actor, target, null));
	}

	public int removeMemberAllPraise(String memberId) throws Exception {
		if (memberId == null) {
			return -1;
		}
		int result = memberPraiseDAO.removeMemberAllPraise(memberId);

		return result;
	}

	public List<MemberPraiseVO> getMemberPriase(String actor, String target) throws Exception {
		if (actor == null || target == null) {
			return null;
		}
		List<MemberPraiseDTO> temp = memberPraiseDAO.searchMemberPraise(new MemberPraiseDTO(actor, target, ""));
		List<MemberPraiseVO> result = new ArrayList<MemberPraiseVO>();
		for (MemberPraiseDTO m : temp) {
			result.add(m.toVO());
		}
		return result;
	}

}
