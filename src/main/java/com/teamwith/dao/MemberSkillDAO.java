package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.MemberSkillDTO;

public interface MemberSkillDAO {
	public int addMemberSkill(MemberSkillDTO dto) throws Exception;

	public int updateSkillLevel(MemberSkillDTO dto) throws Exception;

	public int reomveMemberSkill(MemberSkillDTO dto) throws Exception;

	public int reomveMemberAllSkill(String memberId) throws Exception;

	public List<MemberSkillDTO> searchSkillByMember(String memberId) throws Exception;

	public List<MemberSkillDTO> searchMemberBySkill(List<String> list) throws Exception;

	public List<MemberSkillDTO> searchAllMemberSkill() throws Exception;
}
