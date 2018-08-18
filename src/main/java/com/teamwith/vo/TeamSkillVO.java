package com.teamwith.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TeamSkillVO {
	private String teamId; 
	private String roleId; 
	private List<String> skillIds;
	
	public TeamSkillVO() {
		super();
		skillIds=new ArrayList<String>();
	}
	public TeamSkillVO(String teamId, String roleId, List<String> skillIds) {
		super();
		this.teamId = teamId;
		this.roleId = roleId;
		this.skillIds = skillIds;
	}
	public String getTeamId() {
		return teamId;
	}
	public String getRoleId() {
		return roleId;
	}
	public List<String> getSkillIds() {
		return skillIds;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public void setSkillIds(List<String> skillIds) {
		this.skillIds = skillIds;
	}
	@Override
	public String toString() {
		return "TeamSkillVO [teamId=" + teamId + ", roleId=" + roleId + ", skillIds=" + skillIds + "]";
	}

}
