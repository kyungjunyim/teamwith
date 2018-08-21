package com.teamwith.dao;

import java.util.List;

import com.teamwith.util.Criteria;
import com.teamwith.vo.MemberSearchVO;

public interface MemberSearchDAO {
	public List<MemberSearchVO> searchMemberAll() throws Exception;

	public MemberSearchVO searchMemberByMemberId(String memberId) throws Exception;

	public List<MemberSearchVO> searchMemberByRoleRegion(Criteria cri) throws Exception;
	
	public List<MemberSearchVO> searchMemberIdByRoleList(Criteria cri) throws Exception;
	
	public List<MemberSearchVO> searchMemberIdByRegionList(Criteria cri) throws Exception;

	public List<MemberSearchVO> searchRecentMember(Criteria cri) throws Exception;

	public List<MemberSearchVO> searchMemberByPraiseCnt(Criteria cri) throws Exception;

	public List<MemberSearchVO> searchMember(Criteria cri) throws Exception;

}
