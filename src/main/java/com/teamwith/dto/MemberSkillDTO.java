package com.teamwith.dto;

import org.springframework.stereotype.Component;

@Component
public class MemberSkillDTO {
	private String memberId;
	private String skillId;
	public MemberSkillDTO() {
		super();
	}
	public MemberSkillDTO(String memberId, String skillId) {
		super();
		this.memberId = memberId;
		this.skillId = skillId;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getSkillId() {
		return skillId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public String toString() {
		return "MemberSkillDTO [memberId=" + memberId + ", skillId=" + skillId +"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
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
		MemberSkillDTO other = (MemberSkillDTO) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		return true;
	}
	
}
