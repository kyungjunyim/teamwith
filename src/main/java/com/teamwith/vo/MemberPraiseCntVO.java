package com.teamwith.vo;

import org.springframework.stereotype.Component;

@Component
public class MemberPraiseCntVO {
	private String memberId;
	private String praiseId;
	private String praiseCnt;
	public MemberPraiseCntVO() {
		super();
	}
	public MemberPraiseCntVO(String memberId, String praiseId, String praiseCnt) {
		super();
		this.memberId = memberId;
		this.praiseId = praiseId;
		this.praiseCnt = praiseCnt;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPraiseId() {
		return praiseId;
	}
	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}
	public String getPraiseCnt() {
		return praiseCnt;
	}
	public void setPraiseCnt(String praiseCnt) {
		this.praiseCnt = praiseCnt;
	}
	@Override
	public String toString() {
		return "MemberPraiseVO [memberId=" + memberId + ", praiseId=" + praiseId + ", praiseCnt=" + praiseCnt + "]";
	}
}
