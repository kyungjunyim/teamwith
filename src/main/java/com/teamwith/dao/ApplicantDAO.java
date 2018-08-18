package com.teamwith.dao;

import java.util.List;

import com.teamwith.vo.ApplicantVO;

public interface ApplicantDAO {
	/** Ư�� ȸ���� ���� ���� ���� (���� ���� ���� ����)*/
	public List<ApplicantVO> searchApplicantByMemberId(String memberId) throws Exception;
	/** Ư�� ���� ������ �������� ���� ���� ���� (���� �� ������ ����)*/
	public List<ApplicantVO> searchApplicantByTeamId(String teamId) throws Exception;
	/** ��� application_member_view ���ڵ� �ҷ�����*/
	public List<ApplicantVO> searchApplicantAll() throws Exception;
}
