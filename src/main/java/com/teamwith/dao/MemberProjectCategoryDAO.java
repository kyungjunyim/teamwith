package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.MemberProjectCategoryDTO;

public interface MemberProjectCategoryDAO {
	public int addMemberProjectCategory(MemberProjectCategoryDTO dto) throws Exception;

	public int removeMemberProjectCategory(MemberProjectCategoryDTO dto) throws Exception;

	public int removeMemberProjectCategoryByMemberId(String memberId) throws Exception;

	public List<MemberProjectCategoryDTO> searchProjectCategoryByMember(String memberId) throws Exception;

	public List<MemberProjectCategoryDTO> searchMemberByProjectCategory(List<String> projectCategoryId) throws Exception;

	public List<MemberProjectCategoryDTO> searchAllMemberProjectCategory() throws Exception;
}
