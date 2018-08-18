//�ۼ��� : Ȳ����
package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.TeamSkillDTO;
import com.teamwith.util.Criteria;
import com.teamwith.vo.TeamSkillVO;

public interface TeamSkillDAO {
	/** Ư�� ���� ���� ��� ������ �䱸 ��� ���� �˻�*/
	public List<TeamSkillVO> searchTeamSkillByTeamId(String teamId) throws Exception;
	/** Ư�� ������ ���� ��� �䱸 ��� ���� �˻�*/
	public List<TeamSkillVO> searchTeamSkillByRecruitId(String recruitId) throws Exception;
	/** ��� �䱸 ��� ���� �ҷ�����*/
	public List<TeamSkillVO> searchTeamSkillAll() throws Exception;
	
	public List<TeamSkillVO> searchTeamByRoleSkill(Criteria cri) throws Exception;
	
	public List<TeamSkillDTO> searchTeamDTOByRoleSkill(Criteria cri) throws Exception;
}
