package com.teamwith.vo;

import org.springframework.stereotype.Component;

import com.teamwith.dto.FaqDTO;

@Component
public class FaqVO {
	private String faqId;
	private String faqQuestion;
	private String faqAnswer;
	private String teamId;
	public FaqDTO toDTO() {
		FaqDTO faqDTO = new FaqDTO();
		faqDTO.setFaqId(faqId);
		faqDTO.setFaqQuestion(faqQuestion);
		faqDTO.setFaqAnswer(faqAnswer);
		faqDTO.setTeamId(teamId);
		return faqDTO;
	}
	public FaqVO() {
		super();
	}
	public FaqVO(String faqId, String faqQuestion, String faqAnswer, String teamId) {
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
	@Override
	public String toString() {
		return "FaqVO [faqId=" + faqId + ", faqQuestion=" + faqQuestion + ", faqAnswer=" + faqAnswer + ", teamId="
				+ teamId + "]";
	}
}
