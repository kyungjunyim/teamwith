package com.teamwith.dao;

import java.util.List;

import com.teamwith.util.Criteria;
import com.teamwith.vo.PortfolioSimpleVO;

public interface PortfolioSimpleDAO {
	public List<PortfolioSimpleVO> searchPortfolioSimpleAll(Criteria cri) throws Exception;
	public List<PortfolioSimpleVO> searchPortfolioSimpleByMemberId(String memberId) throws Exception;
	
	public List<PortfolioSimpleVO> searchPortfolio(Criteria cri);
}
