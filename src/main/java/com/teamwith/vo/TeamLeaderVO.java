package com.teamwith.vo;

import org.springframework.stereotype.Component;

@Component
public class TeamLeaderVO {
	private String teamId;
	private String memberId;
	private String memberPic;
	private String memberName;
	private String roleId;
	public TeamLeaderVO() {
		super();
	}
	public TeamLeaderVO(String teamId, String memberId, String memberPic, String memberName, String roleId) {
		super();
		this.teamId = teamId;
		this.memberId = memberId;
		this.memberPic = memberPic;
		this.memberName = memberName;
		this.roleId = roleId;
	}
	public String getTeamId() {
		return teamId;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getMemberPic() {
		return memberPic;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setMemberPic(String memberPic) {
		this.memberPic = memberPic;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "TeamDetail4View [teamId=" + teamId + ", memberId=" + memberId + ", memberPic=" + memberPic
				+ ", memberName=" + memberName + ", roleId=" + roleId + "]";
	}
	
}
