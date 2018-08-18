package com.teamwith.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class TeamDTO {
	private String teamId;
	private String teamProjectName;
	private String teamName;
	private String teamSummary;
	private String teamContent;
	private String projectCategoryId;
	private String regionId;
	private Date teamEndDate;
	private int teamStatus;
	private Date teamUpdateDate;
	private String teamPic;
	private String teamContestName;
	private String teamContestLink;
	private String memberId;
	public TeamDTO() {
		super();
	}
	public TeamDTO(String teamId, String teamProjectName, String teamName, String teamSummary, String teamContent,
			String projectCategoryId, String regionId, Date teamEndDate, int teamStatus, Date teamUpdateDate,
			String teamPic, String teamContestName, String teamContestLink, String memberId) {
		super();
		this.teamId = teamId;
		this.teamProjectName = teamProjectName;
		this.teamName = teamName;
		this.teamSummary = teamSummary;
		this.teamContent = teamContent;
		this.projectCategoryId = projectCategoryId;
		this.regionId = regionId;
		this.teamEndDate = teamEndDate;
		this.teamStatus = teamStatus;
		this.teamUpdateDate = teamUpdateDate;
		this.teamPic = teamPic;
		this.teamContestName = teamContestName;
		this.teamContestLink = teamContestLink;
		this.memberId = memberId;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamProjectName() {
		return teamProjectName;
	}
	public void setTeamProjectName(String teamProjectName) {
		this.teamProjectName = teamProjectName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamSummary() {
		return teamSummary;
	}
	public void setTeamSummary(String teamSummary) {
		this.teamSummary = teamSummary;
	}
	public String getTeamContent() {
		return teamContent;
	}
	public void setTeamContent(String teamContent) {
		this.teamContent = teamContent;
	}
	public String getProjectCategoryId() {
		return projectCategoryId;
	}
	public void setProjectCategoryId(String projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public Date getTeamEndDate() {
		return teamEndDate;
	}
	public void setTeamEndDate(Date teamEndDate) {
		this.teamEndDate = teamEndDate;
	}
	public int getTeamStatus() {
		return teamStatus;
	}
	public void setTeamStatus(int teamStatus) {
		this.teamStatus = teamStatus;
	}
	public Date getTeamUpdateDate() {
		return teamUpdateDate;
	}
	public void setTeamUpdateDate(Date teamUpdateDate) {
		this.teamUpdateDate = teamUpdateDate;
	}
	public String getTeamPic() {
		return teamPic;
	}
	public void setTeamPic(String teamPic) {
		this.teamPic = teamPic;
	}
	public String getTeamContestName() {
		return teamContestName;
	}
	public void setTeamContestName(String teamContestName) {
		this.teamContestName = teamContestName;
	}
	public String getTeamContestLink() {
		return teamContestLink;
	}
	public void setTeamContestLink(String teamContestLink) {
		this.teamContestLink = teamContestLink;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	@Override
	public String toString() {
		return "TeamDTO [teamId=" + teamId + ", teamProjectName=" + teamProjectName + ", teamName=" + teamName
				+ ", teamSummary=" + teamSummary + ", teamContent=" + teamContent + ", projectCategoryId="
				+ projectCategoryId + ", regionId=" + regionId + ", teamEndDate=" + teamEndDate + ", teamStatus="
				+ teamStatus + ", teamUpdateDate=" + teamUpdateDate + ", teamPic=" + teamPic + ", teamContestName="
				+ teamContestName + ", teamContestLink=" + teamContestLink + ", memberId=" + memberId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((projectCategoryId == null) ? 0 : projectCategoryId.hashCode());
		result = prime * result + ((regionId == null) ? 0 : regionId.hashCode());
		result = prime * result + ((teamContent == null) ? 0 : teamContent.hashCode());
		result = prime * result + ((teamContestLink == null) ? 0 : teamContestLink.hashCode());
		result = prime * result + ((teamContestName == null) ? 0 : teamContestName.hashCode());
		result = prime * result + ((teamEndDate == null) ? 0 : teamEndDate.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
		result = prime * result + ((teamPic == null) ? 0 : teamPic.hashCode());
		result = prime * result + ((teamProjectName == null) ? 0 : teamProjectName.hashCode());
		result = prime * result + teamStatus;
		result = prime * result + ((teamSummary == null) ? 0 : teamSummary.hashCode());
		result = prime * result + ((teamUpdateDate == null) ? 0 : teamUpdateDate.hashCode());
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
		TeamDTO other = (TeamDTO) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (projectCategoryId == null) {
			if (other.projectCategoryId != null)
				return false;
		} else if (!projectCategoryId.equals(other.projectCategoryId))
			return false;
		if (regionId == null) {
			if (other.regionId != null)
				return false;
		} else if (!regionId.equals(other.regionId))
			return false;
		if (teamContent == null) {
			if (other.teamContent != null)
				return false;
		} else if (!teamContent.equals(other.teamContent))
			return false;
		if (teamContestLink == null) {
			if (other.teamContestLink != null)
				return false;
		} else if (!teamContestLink.equals(other.teamContestLink))
			return false;
		if (teamContestName == null) {
			if (other.teamContestName != null)
				return false;
		} else if (!teamContestName.equals(other.teamContestName))
			return false;
		if (teamEndDate == null) {
			if (other.teamEndDate != null)
				return false;
		} else if (!teamEndDate.equals(other.teamEndDate))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		if (teamPic == null) {
			if (other.teamPic != null)
				return false;
		} else if (!teamPic.equals(other.teamPic))
			return false;
		if (teamProjectName == null) {
			if (other.teamProjectName != null)
				return false;
		} else if (!teamProjectName.equals(other.teamProjectName))
			return false;
		if (teamStatus != other.teamStatus)
			return false;
		if (teamSummary == null) {
			if (other.teamSummary != null)
				return false;
		} else if (!teamSummary.equals(other.teamSummary))
			return false;
		if (teamUpdateDate == null) {
			if (other.teamUpdateDate != null)
				return false;
		} else if (!teamUpdateDate.equals(other.teamUpdateDate))
			return false;
		return true;
	}
}
