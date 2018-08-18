package com.teamwith.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.teamwith.dto.CommentDTO;

@Component
public class CommentVO {
	private String commentId;
	private String commentContent;
	private String commentUpdateDate;
	private String memberId;
	private String teamId;
	private String parentCommentId;
	public CommentDTO toDTO() throws Exception {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setCommentId(commentId);
		commentDTO.setCommentContent(commentContent);
		commentDTO.setCommentUpdateDate(Date.valueOf(commentUpdateDate));
		commentDTO.setMemberId(memberId);
		commentDTO.setTeamId(teamId);
		commentDTO.setParentCommentId(parentCommentId);
		return commentDTO;
	}
	public CommentVO() {
		super();
	}
	public CommentVO(String commentId, String commentContent, String commentUpdateDate, String memberId, String teamId,
			String parentCommentId) {
		super();
		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentUpdateDate = commentUpdateDate;
		this.memberId = memberId;
		this.teamId = teamId;
		this.parentCommentId = parentCommentId;
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
	@Override
	public String toString() {
		return "CommentVO [commentId=" + commentId + ", commentContent=" + commentContent + ", commentUpdateDate="
				+ commentUpdateDate + ", memberId=" + memberId + ", teamId=" + teamId + ", parentCommentId="
				+ parentCommentId + "]";
	}
}
