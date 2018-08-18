package com.teamwith.dao;

import java.util.List;

import com.teamwith.vo.TeamLeaderVO;

public interface TeamLeaderDAO {
	public List<TeamLeaderVO> searchTeamLeader(String teamId);
}
