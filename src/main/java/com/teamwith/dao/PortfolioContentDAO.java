package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.PortfolioContentDTO;

public interface PortfolioContentDAO {
	public int addPortfolioContent(PortfolioContentDTO portfolioContent) ;
	public int updatePortfolioContent(PortfolioContentDTO portfolioContent);
	public int removePortfolioContentByPortfolioContentId(String elementId);
	public int removePortfolioContentByPortfolioId(String portfolioId);
	public List<PortfolioContentDTO> searchAllPortfolioList();
	public List<PortfolioContentDTO> searchPortfolioContentByPortfolioId(String portfolioId);
	public PortfolioContentDTO searchPortfolioContentByElementId(String elementId) ;
	public List<String> getId();
}

