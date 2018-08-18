package com.teamwith.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.teamwith.vo.PortfolioVO;

@Component
public class PortfolioDTO {
	private String portfolioId;
	private String portfolioTitle;
	private String portfolioIntro;
	private Date portfolioStartDate;
	private Date portfolioEndDate;
	private String portfolioTeamName;
	private int portfolioPeopleNum;
	private String portfolioRole;
	private String portfolioWork;
	private String portfolioSkill;
	private Date portfolioUpdateDate;
	private int portfolioBest;
	private String portfolioPic;
	private String projectCategoryId;
	private String memberId;

	public PortfolioDTO() {
		super();
	}

	public PortfolioDTO(String portfolioId, String portfolioTitle, String portfolioIntro, Date portfolioStartDate,
			Date portfolioEndDate, String portfolioTeamName, int portfolioPeopleNum, String portfolioRole,
			String portfolioWork, String portfolioSkill, Date portfolioUpdateDate, int portfolioBest,
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

	public Date getPortfolioStartDate() {
		return portfolioStartDate;
	}

	public void setPortfolioStartDate(Date portfolioStartDate) {
		this.portfolioStartDate = portfolioStartDate;
	}

	public Date getPortfolioEndDate() {
		return portfolioEndDate;
	}

	public void setPortfolioEndDate(Date portfolioEndDate) {
		this.portfolioEndDate = portfolioEndDate;
	}

	public String getPortfolioTeamName() {
		return portfolioTeamName;
	}

	public void setPortfolioTeamName(String portfolioTeamName) {
		this.portfolioTeamName = portfolioTeamName;
	}

	public int getPortfolioPeopleNum() {
		return portfolioPeopleNum;
	}

	public void setPortfolioPeopleNum(int portfolioPeopleNum) {
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

	public Date getPortfolioUpdateDate() {
		return portfolioUpdateDate;
	}

	public void setPortfolioUpdateDate(Date portfolioUpdateDate) {
		this.portfolioUpdateDate = portfolioUpdateDate;
	}

	public int getPortfolioBest() {
		return portfolioBest;
	}

	public void setPortfolioBest(int portfolioBest) {
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

	public PortfolioVO toVO() {
		PortfolioVO vo = new PortfolioVO(portfolioId, portfolioTitle, portfolioIntro, portfolioStartDate.toString(),
				portfolioEndDate.toString(), portfolioTeamName, portfolioPeopleNum+"", portfolioRole, portfolioWork, portfolioSkill,
				portfolioUpdateDate.toString(), portfolioBest+"", portfolioPic, projectCategoryId, memberId);
		return vo;
	}

	@Override
	public String toString() {
		return "PortfolioDTO [portfolioId=" + portfolioId + ", portfolioTitle=" + portfolioTitle + ", portfolioIntro="
				+ portfolioIntro + ", portfolioStartDate=" + portfolioStartDate + ", portfolioEndDate="
				+ portfolioEndDate + ", portfolioTeamName=" + portfolioTeamName + ", portfolioPeopleNum="
				+ portfolioPeopleNum + ", portfolioRole=" + portfolioRole + ", portfolioWork=" + portfolioWork
				+ ", portfolioSkill=" + portfolioSkill + ", portfolioUpdateDate=" + portfolioUpdateDate
				+ ", portfolioBest=" + portfolioBest + ", portfolioPic=" + portfolioPic + ", projectCategoryId="
				+ projectCategoryId + ", memberId=" + memberId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + portfolioBest;
		result = prime * result + ((portfolioEndDate == null) ? 0 : portfolioEndDate.hashCode());
		result = prime * result + ((portfolioId == null) ? 0 : portfolioId.hashCode());
		result = prime * result + ((portfolioIntro == null) ? 0 : portfolioIntro.hashCode());
		result = prime * result + portfolioPeopleNum;
		result = prime * result + ((portfolioPic == null) ? 0 : portfolioPic.hashCode());
		result = prime * result + ((portfolioRole == null) ? 0 : portfolioRole.hashCode());
		result = prime * result + ((portfolioSkill == null) ? 0 : portfolioSkill.hashCode());
		result = prime * result + ((portfolioStartDate == null) ? 0 : portfolioStartDate.hashCode());
		result = prime * result + ((portfolioTeamName == null) ? 0 : portfolioTeamName.hashCode());
		result = prime * result + ((portfolioTitle == null) ? 0 : portfolioTitle.hashCode());
		result = prime * result + ((portfolioUpdateDate == null) ? 0 : portfolioUpdateDate.hashCode());
		result = prime * result + ((portfolioWork == null) ? 0 : portfolioWork.hashCode());
		result = prime * result + ((projectCategoryId == null) ? 0 : projectCategoryId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortfolioDTO other = (PortfolioDTO) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (portfolioBest != other.portfolioBest)
			return false;
		if (portfolioEndDate == null) {
			if (other.portfolioEndDate != null)
				return false;
		} else if (!portfolioEndDate.equals(other.portfolioEndDate))
			return false;
		if (portfolioId == null) {
			if (other.portfolioId != null)
				return false;
		} else if (!portfolioId.equals(other.portfolioId))
			return false;
		if (portfolioIntro == null) {
			if (other.portfolioIntro != null)
				return false;
		} else if (!portfolioIntro.equals(other.portfolioIntro))
			return false;
		if (portfolioPeopleNum != other.portfolioPeopleNum)
			return false;
		if (portfolioPic == null) {
			if (other.portfolioPic != null)
				return false;
		} else if (!portfolioPic.equals(other.portfolioPic))
			return false;
		if (portfolioRole == null) {
			if (other.portfolioRole != null)
				return false;
		} else if (!portfolioRole.equals(other.portfolioRole))
			return false;
		if (portfolioSkill == null) {
			if (other.portfolioSkill != null)
				return false;
		} else if (!portfolioSkill.equals(other.portfolioSkill))
			return false;
		if (portfolioStartDate == null) {
			if (other.portfolioStartDate != null)
				return false;
		} else if (!portfolioStartDate.equals(other.portfolioStartDate))
			return false;
		if (portfolioTeamName == null) {
			if (other.portfolioTeamName != null)
				return false;
		} else if (!portfolioTeamName.equals(other.portfolioTeamName))
			return false;
		if (portfolioTitle == null) {
			if (other.portfolioTitle != null)
				return false;
		} else if (!portfolioTitle.equals(other.portfolioTitle))
			return false;
		if (portfolioUpdateDate == null) {
			if (other.portfolioUpdateDate != null)
				return false;
		} else if (!portfolioUpdateDate.equals(other.portfolioUpdateDate))
			return false;
		if (portfolioWork == null) {
			if (other.portfolioWork != null)
				return false;
		} else if (!portfolioWork.equals(other.portfolioWork))
			return false;
		if (projectCategoryId == null) {
			if (other.projectCategoryId != null)
				return false;
		} else if (!projectCategoryId.equals(other.projectCategoryId))
			return false;
		return true;
	}
}
