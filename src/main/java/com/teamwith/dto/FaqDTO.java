package com.teamwith.dto;

import org.springframework.stereotype.Component;

import com.teamwith.vo.FaqVO;

@Component
public class FaqDTO {
	private String faqId;
	private String faqQuestion;
	private String faqAnswer;
	private String teamId;
	public FaqDTO() {
		super();
	}
	public FaqDTO(String faqId, String faqQuestion, String faqAnswer, String teamId) {
		super();
		this.faqId = faqId;
		this.faqQuestion = faqQuestion;
		this.faqAnswer = faqAnswer;
		this.teamId = teamId;
	}
	public String getFaqId() {
		return faqId;
	}
	public void setFaqId(String faqId) {
		this.faqId = faqId;
	}
	public String getFaqQuestion() {
		return faqQuestion;
	}
	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}
	public String getFaqAnswer() {
		return faqAnswer;
	}
	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	
	public FaqVO toVO() {
		FaqVO vo = new FaqVO(faqId, faqQuestion, faqAnswer, teamId);
		return vo;
	}
	
	@Override
	public String toString() {
		return "FaqDTO [faqId=" + faqId + ", faqQuestion=" + faqQuestion + ", faqAnswer=" + faqAnswer + ", teamId="
				+ teamId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faqAnswer == null) ? 0 : faqAnswer.hashCode());
		result = prime * result + ((faqId == null) ? 0 : faqId.hashCode());
		result = prime * result + ((faqQuestion == null) ? 0 : faqQuestion.hashCode());
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
		FaqDTO other = (FaqDTO) obj;
		if (faqAnswer == null) {
			if (other.faqAnswer != null)
				return false;
		} else if (!faqAnswer.equals(other.faqAnswer))
			return false;
		if (faqId == null) {
			if (other.faqId != null)
				return false;
		} else if (!faqId.equals(other.faqId))
			return false;
		if (faqQuestion == null) {
			if (other.faqQuestion != null)
				return false;
		} else if (!faqQuestion.equals(other.faqQuestion))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		return true;
	}
}
