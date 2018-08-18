package com.teamwith.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.teamwith.vo.ApplicationVO;

@Component
public class ApplicationDTO {
	private String applicationId;
	private String memberId;
	private Date applicationDate;
	private int applicationStatus;
	private String applicationFreewriting;
	private String teamId;
	private String roleId;
	public ApplicationDTO() {
		super();
	}
	public ApplicationDTO(String applicationId, String memberId, Date applicationDate, int applicationStatus,
			String applicationFreewriting, String teamId, String roleId) {
		super();
		this.applicationId = applicationId;
		this.memberId = memberId;
		this.applicationDate = applicationDate;
		this.applicationStatus = applicationStatus;
		this.applicationFreewriting = applicationFreewriting;
		this.teamId = teamId;
		this.roleId = roleId;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public int getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(int applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public String getApplicationFreewriting() {
		return applicationFreewriting;
	}
	public void setApplicationFreewriting(String applicationFreewriting) {
		this.applicationFreewriting = applicationFreewriting;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public ApplicationVO toVO() {
		ApplicationVO vo = new ApplicationVO(applicationId,memberId,applicationDate.toString(),
				applicationStatus+"",applicationFreewriting,teamId,roleId);
		return vo;
	}
	
	@Override
	public String toString() {
		return "ApplicationDTO [applicationId=" + applicationId + ", memberId=" + memberId + ", applicationDate="
				+ applicationDate + ", applicationStatus=" + applicationStatus + ", applicationFreewriting="
				+ applicationFreewriting + ", teamId=" + teamId + ", roleId=" + roleId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationDate == null) ? 0 : applicationDate.hashCode());
		result = prime * result + ((applicationFreewriting == null) ? 0 : applicationFreewriting.hashCode());
		result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode());
		result = prime * result + applicationStatus;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
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
		ApplicationDTO other = (ApplicationDTO) obj;
		if (applicationDate == null) {
			if (other.applicationDate != null)
				return false;
		} else if (!applicationDate.equals(other.applicationDate))
			return false;
		if (applicationFreewriting == null) {
			if (other.applicationFreewriting != null)
				return false;
		} else if (!applicationFreewriting.equals(other.applicationFreewriting))
			return false;
		if (applicationId == null) {
			if (other.applicationId != null)
				return false;
		} else if (!applicationId.equals(other.applicationId))
			return false;
		if (applicationStatus != other.applicationStatus)
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		return true;
	}
}
