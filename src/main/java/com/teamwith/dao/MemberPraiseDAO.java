package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.MemberPraiseDTO;
import com.teamwith.vo.MemberPraiseCntVO;

public interface MemberPraiseDAO {
	public int addMemberPraise(MemberPraiseDTO dto) throws Exception;

	public int removeMemberPraise(MemberPraiseDTO dto) throws Exception;

	public int removeMemberAllPraise(String memberId) throws Exception;

	public List<MemberPraiseDTO> searchMemberAllPraise(String memberId) throws Exception;

	public List<MemberPraiseDTO> searchMemberPraise(MemberPraiseDTO dto) throws Exception;

	public List<MemberPraiseCntVO> searchMemberPraiseCnt(String memberId) throws Exception;

	public List<MemberPraiseDTO> searchAllMemberPraise() throws Exception;
}
