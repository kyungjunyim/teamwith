package com.teamwith.dao;

import java.util.List;

import com.teamwith.vo.InterviewVO;

public interface InterviewDAO {
	public List<InterviewVO> searchInterview(String applicationId);
	public List<InterviewVO> searchInterviewAll(String teamId);
}
