package com.teamwith.vo;

import org.springframework.stereotype.Component;

@Component
public class MemberRateVO {
	private String memberId;
	private String memberPic;
	private String memberName;
	private String roleId;
	private String memberRegisterDate;
	private String regionId1;
	private String regionId2;
	private String totalPraiseCnt;
	private double rate;
	public MemberRateVO() {
		super();
	}
	public MemberRateVO(String memberId, String memberPic, String memberName, String roleId, String memberRegisterDate,
			String regionId1, String regionId2, String totalPraiseCnt, double rate) {
		super();
		this.memberId = memberId;
		this.memberPic = memberPic;
		this.memberName = memberName;
		this.roleId = roleId;
		this.memberRegisterDate = memberRegisterDate;
		this.regionId1 = regionId1;
		this.regionId2 = regionId2;
		this.totalPraiseCnt = totalPraiseCnt;
		this.rate = rate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPic() {
		return memberPic;
	}
	public void setMemberPic(String memberPic) {
		this.memberPic = memberPic;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMemberRegisterDate() {
		return memberRegisterDate;
	}
	public void setMemberRegisterDate(String memberRegisterDate) {
		this.memberRegisterDate = memberRegisterDate;
	}
	public String getRegionId1() {
		return regionId1;
	}
	public void setRegionId1(String regionId1) {
		this.regionId1 = regionId1;
	}
	public String getRegionId2() {
		return regionId2;
	}
	public void setRegionId2(String regionId2) {
		this.regionId2 = regionId2;
	}
	public String getTotalPraiseCnt() {
		return totalPraiseCnt;
	}
	public void setTotalPraiseCnt(String totalPraiseCnt) {
		this.totalPraiseCnt = totalPraiseCnt;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "MemberRateVO [memberId=" + memberId + ", memberPic=" + memberPic + ", memberName=" + memberName
				+ ", roleId=" + roleId + ", memberRegisterDate=" + memberRegisterDate + ", regionId1=" + regionId1
				+ ", regionId2=" + regionId2 + ", totalPraiseCnt=" + totalPraiseCnt + ", rate=" + rate + "]";
	}
}

