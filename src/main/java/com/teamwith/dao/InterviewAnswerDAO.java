//�ۼ��� : Ȳ����
package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.InterviewAnswerDTO;

public interface InterviewAnswerDAO {
	/** ���� ���� �亯 �߰� */
	public int addInterviewAnswer(InterviewAnswerDTO interviewAnswer) throws Exception;
	/** ���� ���� �亯 ����*/
	public int removeInterviewAnswerByInterviewAnswerId(String interviewAnswerId) throws Exception;
	/** interview_answer_id�� �ش��ϴ� ���ڵ��� interview_content�� �����Ѵ�.*/
	public int updateInterviewAnswer(InterviewAnswerDTO interviewAnswer) throws Exception;
	/** interview_answer_id�� �ش��ϴ� ���ڵ��� ��� �Ӽ��� �����Ѵ�.*/
	public int updateInterviewAnswerAll(InterviewAnswerDTO interviewAnswer) throws Exception;
	/** interviewAnswerId�� ��ġ�ϴ� �ϳ��� InterviewAnswerDTO ��ü ��ȯ*/
	public InterviewAnswerDTO searchInterviewAnswerByInterviewAnswerId(String interviewAnswerId) throws Exception;
	/** interviwe_question_id�� ��ġ�ϴ� ��� InterviewAnswerDTO ��ü ��ȯ*/
	public List<InterviewAnswerDTO> searchInterviewAnswerByInterviewQuestionId(String interviewQuestionId) throws Exception;
	/** application_id�� ��ġ�ϴ� ��� InterviewAnswerDTO ��ü ��ȯ*/
	public List<InterviewAnswerDTO> searchInterviewAnswerByApplicationId(String applicationId) throws Exception;
	/** interview_question_id�� application_id�� ��ġ�ϴ� InterviewAnswerDTO ��ü ��ȯ*/
	public InterviewAnswerDTO searchInterviewAnswer(InterviewAnswerDTO interviewAnswer) throws Exception;
	/** ��� ���� ���� �亯 ���ڵ� �ҷ�����*/
	public List<InterviewAnswerDTO> searchInterviewAnswerAll() throws Exception;
	/** ���� ���� �亯 Ű�� �ҷ����� */
	public List<String> getInterviewAnswerId() throws Exception;
} 
