//�ۼ��� : Ȳ����
package com.teamwith.dao;

import java.util.List;

import com.teamwith.vo.TeamDetailVO;

public interface TeamDetailDAO {
	/** Ư�� ���� ���� �� �� ���� �˻�*/
	public TeamDetailVO searchTeamDetailByTeamId(String teamId) throws Exception;
	/** ��� �� �� ���� �ҷ�����*/
	public List<TeamDetailVO> searchTeamDetailAll() throws Exception;
}
