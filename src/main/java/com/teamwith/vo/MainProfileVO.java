package com.teamwith.vo;

import org.springframework.stereotype.Component;

@Component
public class MainProfileVO {
	private String memberId;
	private String memberName;
	private String memberPic;
	private String applicationCnt;
	private String teamCnt;
	public MainProfileVO() {
		super();
	}
	public MainProfileVO(String memberId, String memberName, String memberPic, String applicationCnt, String teamCnt) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPic = memberPic;
		this.applicationCnt = applicationCnt;
		this.teamCnt = teamCnt;
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
	public String getMemberPic() {
		return memberPic;
	}
	public void setMemberPic(String memberPic) {
		this.memberPic = memberPic;
	}
	public String getApplicationCnt() {
		return applicationCnt;
	}
	public void setApplicationCnt(String applicationCnt) {
		this.applicationCnt = applicationCnt;
	}
	public String getTeamCnt() {
		return teamCnt;
	}
	public void setTeamCnt(String teamCnt) {
		this.teamCnt = teamCnt;
	}
	@Override
	public String toString() {
		return "MainProfileVO [memberId=" + memberId + ", memberName=" + memberName + ", memberPic=" + memberPic
				+ ", applicationCnt=" + applicationCnt + ", teamCnt=" + teamCnt + "]";
	}
}
