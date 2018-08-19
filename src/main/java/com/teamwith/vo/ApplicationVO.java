package com.teamwith.vo;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.teamwith.dto.ApplicationDTO;

@Component
public class ApplicationVO {
	private String applicationId;
	private String memberId;
	private String applicationDate;
	private String applicationStatus;
	private String applicationFreewriting;
	private String teamId;
	private String roleId;

	public ApplicationDTO toDTO() throws Exception {
		ApplicationDTO applicationDTO = new ApplicationDTO();
		if (applicationId != null) {
			applicationDTO.setApplicationId(applicationId);
		}
		if (memberId != null) {
			applicationDTO.setMemberId(memberId);
		}
		
		LocalDate localDate = LocalDate.now();
		applicationDTO.setApplicationDate(Date.valueOf(localDate));
		
		if (applicationStatus != null) {
			applicationDTO.setApplicationStatus(Integer.parseInt(applicationStatus));
		}
		if (applicationFreewriting != null) {
			applicationDTO.setApplicationFreewriting(applicationFreewriting);
		}
		if (teamId != null) {
			applicationDTO.setTeamId(teamId);
		}
		if (roleId != null) {
			applicationDTO.setRoleId(roleId);
		}
		return applicationDTO;
	}

	public ApplicationVO() {
		super();
	}

	public ApplicationVO(String applicationId, String memberId, String applicationDate, String applicationStatus,
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

	public String getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
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

	@Override
	public String toString() {
		return "ApplicationVO [applicationId=" + applicationId + ", memberId=" + memberId + ", applicationDate="
				+ applicationDate + ", applicationStatus=" + applicationStatus + ", applicationFreewriting="
				+ applicationFreewriting + ", teamId=" + teamId + ", roleId=" + roleId + "]";
	}
}
