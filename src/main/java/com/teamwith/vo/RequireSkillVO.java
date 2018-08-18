package com.teamwith.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.teamwith.dto.RequireSkillDTO;

@Component
public class RequireSkillVO {
	private String recruitId;
	private List<String> skillIds;
	
	public List<RequireSkillDTO> toDTO() {
		List<RequireSkillDTO> result=new ArrayList<RequireSkillDTO>();
		for(String skill : skillIds) {
			RequireSkillDTO dto=new RequireSkillDTO(recruitId,skill);
			result.add(dto);
		}
		
		return result;
	}
	public RequireSkillVO() {
		super();
		skillIds=new ArrayList<String>();
	}
	public RequireSkillVO(List<RequireSkillDTO> dtos) {
		skillIds=new ArrayList<String>();
		if(dtos!=null) {
			for(RequireSkillDTO dto : dtos) {
				recruitId=dto.getRecruitId();
				skillIds.add(dto.getSkillId());
			}
		}
	}
	public RequireSkillVO(String recruitId, List<String> skillIds) {
		this.recruitId=recruitId;
		this.skillIds=skillIds;
	}
	public String getRecruitId() {
		return recruitId;
	}
	public List<String> getSkillIds() {
		return skillIds;
	}
	public void setRecruitId(String recruitId) {
		this.recruitId = recruitId;
	}
	public void setSkillIds(List<String> skillIds) {
		this.skillIds = skillIds;
	}
	@Override
	public String toString() {
		return "RequireSkillVO [recruitId=" + recruitId + ", skillIds=" + skillIds + "]";
	}
	
}
