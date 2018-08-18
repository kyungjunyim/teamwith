package com.teamwith.dto;

import org.springframework.stereotype.Component;

@Component
public class InterviewAnswerDTO {
	private String interviewAnswerId;
	private String interviewQuestionId;
	private String applicationId;
	private String interviewAnswerContent;
	public InterviewAnswerDTO() {
		super();
	}
	public InterviewAnswerDTO(String interviewAnswerId, String interviewQuestionId, String applicationId,
			String interviewAnswerContent) {
		super();
		this.interviewAnswerId = interviewAnswerId;
		this.interviewQuestionId = interviewQuestionId;
		this.applicationId = applicationId;
		this.interviewAnswerContent = interviewAnswerContent;
	}
	public String getInterviewAnswerId() {
		return interviewAnswerId;
	}
	public void setInterviewAnswerId(String interviewAnswerId) {
		this.interviewAnswerId = interviewAnswerId;
	}
	public String getInterviewQuestionId() {
		return interviewQuestionId;
	}
	public void setInterviewQuestionId(String interviewQuestionId) {
		this.interviewQuestionId = interviewQuestionId;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getInterviewAnswerContent() {
		return interviewAnswerContent;
	}
	public void setInterviewAnswerContent(String interviewAnswerContent) {
		this.interviewAnswerContent = interviewAnswerContent;
	}
	

	@Override
	public String toString() {
		return "InterviewAnswerDTO [interviewAnswerId=" + interviewAnswerId + ", interviewQuestionId="
				+ interviewQuestionId + ", applicationId=" + applicationId + ", interviewAnswerContent="
				+ interviewAnswerContent + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode());
		result = prime * result + ((interviewAnswerContent == null) ? 0 : interviewAnswerContent.hashCode());
		result = prime * result + ((interviewAnswerId == null) ? 0 : interviewAnswerId.hashCode());
		result = prime * result + ((interviewQuestionId == null) ? 0 : interviewQuestionId.hashCode());
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
		InterviewAnswerDTO other = (InterviewAnswerDTO) obj;
		if (applicationId == null) {
			if (other.applicationId != null)
				return false;
		} else if (!applicationId.equals(other.applicationId))
			return false;
		if (interviewAnswerContent == null) {
			if (other.interviewAnswerContent != null)
				return false;
		} else if (!interviewAnswerContent.equals(other.interviewAnswerContent))
			return false;
		if (interviewAnswerId == null) {
			if (other.interviewAnswerId != null)
				return false;
		} else if (!interviewAnswerId.equals(other.interviewAnswerId))
			return false;
		if (interviewQuestionId == null) {
			if (other.interviewQuestionId != null)
				return false;
		} else if (!interviewQuestionId.equals(other.interviewQuestionId))
			return false;
		return true;
	}
}