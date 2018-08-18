package com.teamwith.dao;

import java.util.List;

import com.teamwith.vo.MemberCommentVO;

public interface MemberCommentDAO {
	// ��� ��������
	public List<MemberCommentVO> searchMemberComment() throws Exception;
}
