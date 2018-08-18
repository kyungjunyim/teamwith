package com.teamwith.dao;

import java.util.List;
import java.util.Map;

import com.teamwith.dto.MemberDTO;
import com.teamwith.vo.MemberSimpleVO;

public interface MemberDAO {
	public int addMember(MemberDTO dto) throws Exception;

	public int addAdminMember(MemberDTO dto) throws Exception;

	public int updateMemberStatus(String memberId) throws Exception;

	public int updateNonMember(String memberId) throws Exception;

	public int updateMember(MemberDTO dto) throws Exception;

	public int updatePassword(Map<String, String> map) throws Exception;
	
	public int updateTempPassword(Map<String, String> map) throws Exception;

	public List<MemberDTO> searchAll() throws Exception;

	public String searchMailOrId(Map<String, String> map) throws Exception;

	public MemberDTO searchMember(Map<String, String> map) throws Exception;

	public MemberDTO searchMemberInfo(String memberId) throws Exception;

	public List<MemberDTO> searchMemberWithCondition(Map<String, String> map) throws Exception;

	public List<MemberSimpleVO> searchMemberByRoleRegion(Map<String, String> map) throws Exception;

	public MemberSimpleVO searchMemberForSimpleView(String memberId) throws Exception;
	
	public String searchMemberAccount(Map<String, String> map) throws Exception;
}
