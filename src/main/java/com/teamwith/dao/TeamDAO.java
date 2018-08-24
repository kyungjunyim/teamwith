package com.teamwith.dao;

import java.util.List;
import java.util.Map;

import com.teamwith.dto.TeamDTO;
import com.teamwith.util.Criteria;

public interface TeamDAO {
	public int addTeam(TeamDTO team) throws Exception;
	public int removeTeamByTeamId(String teamId) throws Exception;
	public int removeTeamByMemberId(String memberId) throws Exception;
	public int updateTeamInfoByCondition(Map<String, Object> map) throws Exception;
	public int updateTeamUpdateDate(String teamId) throws Exception;
	public int updateTeamStatus(Map<String, Object> map) throws Exception;
	public int updateTeam(TeamDTO team) throws Exception;
	public List<TeamDTO> searchTeamByStatus(int teamStatus) throws Exception;
	public List<TeamDTO> searchTeamByCondition(Criteria cri) throws Exception;
	public List<TeamDTO> searchTeamByKeyword(Criteria cri) throws Exception;
	public List<TeamDTO> searchTeamAll() throws Exception;
	public List<String> getId() throws Exception;
}