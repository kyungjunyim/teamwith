package com.teamwith.dto;

import org.springframework.stereotype.Component;

@Component
public class MemberProjectCategoryDTO {
	private String memberId;
	private String projectCategoryId;
	public MemberProjectCategoryDTO() {
		super();
	}
	public MemberProjectCategoryDTO(String memberId, String projectCategoryId) {
		super();
		this.memberId = memberId;
		this.projectCategoryId = projectCategoryId;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getProjectCategoryId() {
		return projectCategoryId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setProjectCategoryId(String projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}
	
	public String toString() {
		return "MemberProjectCategoryDTO [memberId=" + memberId + ", projectCategoryId=" + projectCategoryId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
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
		MemberProjectCategoryDTO other = (MemberProjectCategoryDTO) obj;
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
		return true;
	}
	
}
