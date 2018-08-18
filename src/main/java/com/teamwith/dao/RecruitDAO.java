//�ۼ��� : Ȳ����
package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.RecruitDTO;

public interface RecruitDAO {
	/** ���� ���� �߰�*/
	public int addRecruit(RecruitDTO recruit) throws Exception;
	/** ���� ���� ����*/
	public int removeRecruitByRecruitId(String recruitId) throws Exception;
	/** recruit_tb�� ��� ���� ����*/
	public int updateRecruitAll(RecruitDTO recruit) throws Exception;
	/** recruit_id�� �ش��ϴ� ���ڵ��� recruit_people_num, recruit_preference, recruit_explain, role_id ����*/
	public int updateRecruit(RecruitDTO recruit) throws Exception;
	/** recruit_id�� �ش��ϴ� ���ڵ��� recruit_people_num�� ����*/
	public int updateRecruitPeopleNum(RecruitDTO recruit) throws Exception;
	/** Ư�� recruit ���ڵ� �˻� */
	public RecruitDTO searchRecruitByRecruitId(String recruitId) throws Exception;
	/** Ư�� ���� ��� recruit ���ڵ� �˻�*/
	public List<RecruitDTO> searchRecruitByTeamId(String teamId) throws Exception;
	/** ��� recruit ���ڵ� �ҷ�����*/
	public List<RecruitDTO> searchRecruitAll() throws Exception;
	
	public List<String> getId() throws Exception;
}
