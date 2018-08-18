//�ۼ��� : Ȳ����
package com.teamwith.vo;

import org.springframework.stereotype.Component;

@Component
public class TeamRateVO {
	private String teamId;
	private String teamPic;
	private String teamProjectName;
	private String projectCategoryId;
	private String teamName;
	private String teamEndDate;
	private String teamUpdateDate;
	private String memberId;
	private String memberName;
	private double rate;
	public TeamRateVO() {
		super();
	}
	public TeamRateVO(String teamId, String teamPic, String teamProjectName, String projectCategoryId, String teamName,
			String teamEndDate, String teamUpdateDate, String memberId, String memberName, double rate) {
		super();
		this.teamId = teamId;
		this.teamPic = teamPic;
		this.teamProjectName = teamProjectName;
		this.projectCategoryId = projectCategoryId;
		this.teamName = teamName;
		this.teamEndDate = teamEndDate;
		this.teamUpdateDate = teamUpdateDate;
		this.memberId = memberId;
		this.memberName = memberName;
		this.rate = rate;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamPic() {
		return teamPic;
	}
	public void setTeamPic(String teamPic) {
		this.teamPic = teamPic;
	}
	public String getTeamProjectName() {
		return teamProjectName;
	}
	public void setTeamProjectName(String teamProjectName) {
		this.teamProjectName = teamProjectName;
	}
	public String getProjectCategoryId() {
		return projectCategoryId;
	}
	public void setProjectCategoryId(String projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamEndDate() {
		return teamEndDate;
	}
	public void setTeamEndDate(String teamEndDate) {
		this.teamEndDate = teamEndDate;
	}
	public String getTeamUpdateDate() {
		return teamUpdateDate;
	}
	public void setTeamUpdateDate(String teamUpdateDate) {
		this.teamUpdateDate = teamUpdateDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "TeamRateVO [teamId=" + teamId + ", teamPic=" + teamPic + ", teamProjectName=" + teamProjectName
				+ ", projectCategoryId=" + projectCategoryId + ", teamName=" + teamName + ", teamEndDate=" + teamEndDate
				+ ", teamUpdateDate=" + teamUpdateDate + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", rate=" + rate + "]";
	}
	
}
