package com.teamwith.dao;

import java.util.List;
import java.util.Map;

import com.teamwith.vo.Criteria;
import com.teamwith.vo.PortfolioSimpleVO;

public interface PortfolioSimpleDAO {
	public List<PortfolioSimpleVO> searchPortfolioSimpleAll(Criteria cri) throws Exception;
	public List<PortfolioSimpleVO> searchPortfolioSimpleByMemberId(Map<String,Object> param) throws Exception;
	
	public List<PortfolioSimpleVO> searchPortfolio(Criteria cri);
}
