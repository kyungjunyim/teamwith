package com.teamwith.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.teamwith.dto.PortfolioDTO;

@Component
public class PortfolioVO {
	private String portfolioId;
	private String portfolioTitle;
	private String portfolioIntro;
	private String portfolioStartDate;
	private String portfolioEndDate;
	private String portfolioTeamName;
	private String portfolioPeopleNum;
	private String portfolioRole;
	private String portfolioWork;
	private String portfolioSkill;
	private String portfolioUpdateDate;
	private String portfolioBest;
	private String portfolioPic;
	private String projectCategoryId;
	private String memberId;
	public PortfolioDTO toDTO() throws Exception {
		PortfolioDTO portfolioDTO = new PortfolioDTO();
		portfolioDTO.setPortfolioId(portfolioId);
		portfolioDTO.setPortfolioTitle(portfolioTitle);
		portfolioDTO.setPortfolioIntro(portfolioIntro);
		portfolioDTO.setPortfolioStartDate(Date.valueOf(portfolioStartDate));
		portfolioDTO.setPortfolioEndDate(Date.valueOf(portfolioEndDate));
		portfolioDTO.setPortfolioPeopleNum(Integer.parseInt(portfolioPeopleNum));
		portfolioDTO.setPortfolioRole(portfolioRole);
		portfolioDTO.setPortfolioWork(portfolioWork);
		portfolioDTO.setPortfolioSkill(portfolioSkill);
		portfolioDTO.setPortfolioUpdateDate(Date.valueOf(portfolioUpdateDate));
		portfolioDTO.setPortfolioBest(Integer.parseInt(portfolioBest));
		portfolioDTO.setPortfolioPic(portfolioPic);
		portfolioDTO.setProjectCategoryId(projectCategoryId);
		portfolioDTO.setMemberId(memberId);
		return portfolioDTO;
	}
	public PortfolioVO() {
		super();
	}
	public PortfolioVO(String portfolioId, String portfolioTitle, String portfolioIntro, String portfolioStartDate,
			String portfolioEndDate, String portfolioTeamName, String portfolioPeopleNum, String portfolioRole,
			String portfolioWork, String portfolioSkill, String portfolioUpdateDate, String portfolioBest,
			String portfolioPic, String projectCategoryId, String memberId) {
		super();
		this.portfolioId = portfolioId;
		this.portfolioTitle = portfolioTitle;
		this.portfolioIntro = portfolioIntro;
		this.portfolioStartDate = portfolioStartDate;
		this.portfolioEndDate = portfolioEndDate;
		this.portfolioTeamName = portfolioTeamName;
		this.portfolioPeopleNum = portfolioPeopleNum;
		this.portfolioRole = portfolioRole;
		this.portfolioWork = portfolioWork;
		this.portfolioSkill = portfolioSkill;
		this.portfolioUpdateDate = portfolioUpdateDate;
		this.portfolioBest = portfolioBest;
		this.portfolioPic = portfolioPic;
		this.projectCategoryId = projectCategoryId;
		this.memberId = memberId;
	}
	public String getPortfolioId() {
		return portfolioId;
	}
	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}
	public String getPortfolioTitle() {
		return portfolioTitle;
	}
	public void setPortfolioTitle(String portfolioTitle) {
		this.portfolioTitle = portfolioTitle;
	}
	public String getPortfolioIntro() {
		return portfolioIntro;
	}
	public void setPortfolioIntro(String portfolioIntro) {
		this.portfolioIntro = portfolioIntro;
	}
	public String getPortfolioStartDate() {
		return portfolioStartDate;
	}
	public void setPortfolioStartDate(String portfolioStartDate) {
		this.portfolioStartDate = portfolioStartDate;
	}
	public String getPortfolioEndDate() {
		return portfolioEndDate;
	}
	public void setPortfolioEndDate(String portfolioEndDate) {
		this.portfolioEndDate = portfolioEndDate;
	}
	public String getPortfolioTeamName() {
		return portfolioTeamName;
	}
	public void setPortfolioTeamName(String portfolioTeamName) {
		this.portfolioTeamName = portfolioTeamName;
	}
	public String getPortfolioPeopleNum() {
		return portfolioPeopleNum;
	}
	public void setPortfolioPeopleNum(String portfolioPeopleNum) {
		this.portfolioPeopleNum = portfolioPeopleNum;
	}
	public String getPortfolioRole() {
		return portfolioRole;
	}
	public void setPortfolioRole(String portfolioRole) {
		this.portfolioRole = portfolioRole;
	}
	public String getPortfolioWork() {
		return portfolioWork;
	}
	public void setPortfolioWork(String portfolioWork) {
		this.portfolioWork = portfolioWork;
	}
	public String getPortfolioSkill() {
		return portfolioSkill;
	}
	public void setPortfolioSkill(String portfolioSkill) {
		this.portfolioSkill = portfolioSkill;
	}
	public String getPortfolioUpdateDate() {
		return portfolioUpdateDate;
	}
	public void setPortfolioUpdateDate(String portfolioUpdateDate) {
		this.portfolioUpdateDate = portfolioUpdateDate;
	}
	public String getPortfolioBest() {
		return portfolioBest;
	}
	public void setPortfolioBest(String portfolioBest) {
		this.portfolioBest = portfolioBest;
	}
	public String getPortfolioPic() {
		return portfolioPic;
	}
	public void setPortfolioPic(String portfolioPic) {
		this.portfolioPic = portfolioPic;
	}
	public String getProjectCategoryId() {
		return projectCategoryId;
	}
	public void setProjectCategoryId(String projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "PortfolioVO [portfolioId=" + portfolioId + ", portfolioTitle=" + portfolioTitle + ", portfolioIntro="
				+ portfolioIntro + ", portfolioStartDate=" + portfolioStartDate + ", portfolioEndDate="
				+ portfolioEndDate + ", portfolioTeamName=" + portfolioTeamName + ", portfolioPeopleNum="
				+ portfolioPeopleNum + ", portfolioRole=" + portfolioRole + ", portfolioWork=" + portfolioWork
				+ ", portfolioSkill=" + portfolioSkill + ", portfolioUpdateDate=" + portfolioUpdateDate
				+ ", portfolioBest=" + portfolioBest + ", portfolioPic=" + portfolioPic + ", projectCategoryId="
				+ projectCategoryId + ", memberId=" + memberId + "]";
	}
}
