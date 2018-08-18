package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.MemberTendencyDTO;

public interface MemberTendencyDAO {
	public int addMemberTendency(MemberTendencyDTO dto) throws Exception;

	public int updateTendencyFigure(MemberTendencyDTO dto) throws Exception;

	public int removeMemberTendency(String memberId) throws Exception;

	public List<MemberTendencyDTO> searchMemberTendency(String memberId) throws Exception;

	public List<MemberTendencyDTO> searchAllMemberTendency() throws Exception;
}
