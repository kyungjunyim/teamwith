package com.teamwith.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.teamwith.vo.CommentVO;

@Component
public class CommentDTO {
	private String commentId;
	private String commentContent;
	private Date commentUpdateDate;
	private String memberId;
	private String teamId;
	private String parentCommentId;
	public CommentDTO() {
		super();
	}
	public CommentDTO(String commentId, String commentContent, Date commentUpdateDate, String memberId, String teamId,
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
	public Date getCommentUpdateDate() {
		return commentUpdateDate;
	}
	public void setCommentUpdateDate(Date commentUpdateDate) {
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
	
	public CommentVO toVO() {
		CommentVO vo = new CommentVO(commentId, commentContent, commentUpdateDate.toString(), memberId, teamId, parentCommentId);
		return vo;
	}
	@Override
	public String toString() {
		return "CommentDTO [commentId=" + commentId + ", commentContent=" + commentContent + ", commentUpdateDate="
				+ commentUpdateDate + ", memberId=" + memberId + ", teamId=" + teamId + ", parentCommentId="
				+ parentCommentId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentContent == null) ? 0 : commentContent.hashCode());
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
		result = prime * result + ((commentUpdateDate == null) ? 0 : commentUpdateDate.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((parentCommentId == null) ? 0 : parentCommentId.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
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
		CommentDTO other = (CommentDTO) obj;
		if (commentContent == null) {
			if (other.commentContent != null)
				return false;
		} else if (!commentContent.equals(other.commentContent))
			return false;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		if (commentUpdateDate == null) {
			if (other.commentUpdateDate != null)
				return false;
		} else if (!commentUpdateDate.equals(other.commentUpdateDate))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (parentCommentId == null) {
			if (other.parentCommentId != null)
				return false;
		} else if (!parentCommentId.equals(other.parentCommentId))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		return true;
	}
}
