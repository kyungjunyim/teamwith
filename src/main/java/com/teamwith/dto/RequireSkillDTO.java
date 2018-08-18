package com.teamwith.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.teamwith.vo.RequireSkillVO;

@Component
public class RequireSkillDTO {
	private String recruitId;
	private String skillId;
	public RequireSkillDTO() {
		super();
	}
	public RequireSkillDTO(String recruitId, String skillId) {
		super();
		this.recruitId = recruitId;
		this.skillId = skillId;
	}
	public String getRecruitId() {
		return recruitId;
	}
	public String getSkillId() {
		return skillId;
	}
	public void setRecruitId(String recruitId) {
		this.recruitId = recruitId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	
	public RequireSkillVO toVO() {
		List<RequireSkillDTO> temp=new ArrayList<RequireSkillDTO>();
		temp.add(this);
		RequireSkillVO vo = new RequireSkillVO(temp);
		return vo;
	}
	
	public String toString() {
		return "RequireSkillDTO [recruitId=" + recruitId + ", skillId=" + skillId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recruitId == null) ? 0 : recruitId.hashCode());
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
		RequireSkillDTO other = (RequireSkillDTO) obj;
		if (recruitId == null) {
			if (other.recruitId != null)
				return false;
		} else if (!recruitId.equals(other.recruitId))
			return false;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		return true;
	}
	
}
