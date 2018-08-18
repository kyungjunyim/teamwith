//�ۼ��� : Ȳ����
package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.RequireSkillDTO;

public interface RequireSkillDAO {
	/** �䱸 ��� ���� �߰�*/
	public int addRequireSkill(RequireSkillDTO requireSkill) throws Exception;
	/** recruit_id�� skill_id�� ��� ��ġ�ؾ� ����*/
	public int removeRequireSkill(RequireSkillDTO requireSkill) throws Exception;
	/** recruitId�� �ش��ϴ� ��� ���ڵ� ����*/
	public int removeRequireSkillByRecruitId(String recruitId) throws Exception;
	/** �ش� ������ ��� �䱸 ��� �˻�*/
	public List<RequireSkillDTO> searchRequireSkillByRecruitId(String recruitId) throws Exception;
	public List<RequireSkillDTO> searchRequireSkillByTeamId(String teamId) throws Exception;
	/** �ش� ��ų�� �䱸�ϴ� ��� ���� �˻� */
	public List<RequireSkillDTO> searchRequireSkillBySkillId(String skillId) throws Exception;
	/** ��� �䱸 �ü� ���� �ҷ�����*/
	public List<RequireSkillDTO> searchRequireSkillAll() throws Exception;
}
