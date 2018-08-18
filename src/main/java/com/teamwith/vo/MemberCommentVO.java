package com.teamwith.vo;

import org.springframework.stereotype.Component;

@Component
public class MemberCommentVO {
	private String commentId;
	private String commentContent;
	private String commentUpdateDate;
	private String memberId;
	private String teamId;
	private String parentCommentId;
	private String memberPic;
	private String memberName;
	public MemberCommentVO() {
		super();
	}
	public MemberCommentVO(String commentId, String commentContent, String commentUpdateDate, String memberId,
			String teamId, String parentCommentId, String memberPic, String memberName) {
		super();
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentUpdateDate = commentUpdateDate;
		this.memberId = memberId;
		this.teamId = teamId;
		this.parentCommentId = parentCommentId;
		this.memberPic = memberPic;
		this.memberName = memberName;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentUpdateDate() {
		return commentUpdateDate;
	}
	public void setCommentUpdateDate(String commentUpdateDate) {
		this.commentUpdateDate = commentUpdateDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(String parentCommentId) {
		this.parentCommentId = parentCommentId;
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
	@Override
	public String toString() {
		return "MemberCommentVO [commentId=" + commentId + ", commentContent=" + commentContent + ", commentUpdateDate="
				+ commentUpdateDate + ", memberId=" + memberId + ", teamId=" + teamId + ", parentCommentId="
				+ parentCommentId + ", memberPic=" + memberPic + ", memberName=" + memberName + "]";
	}
}
