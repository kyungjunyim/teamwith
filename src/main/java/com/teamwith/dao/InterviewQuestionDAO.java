//�ۼ��� : Ȳ����
package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.InterviewQuestionDTO;

public interface InterviewQuestionDAO {
	/** ���� ���� �亯 �߰�*/
	public int addInterviewQuestion(InterviewQuestionDTO interviewQuestion) throws Exception;
	/** ���� ���� �亯 ����*/
	public int removeInterviewQuestion(String interviewQuestionId) throws Exception;
	/** interview_question_id�� �ش��ϴ� ���ڵ��� interview_question_content�� ���� (�̻��)*/
	public int updateInterviewQuestion(InterviewQuestionDTO interviewQuestion) throws Exception;
	/** interview_question_id�� �ش��ϴ� ���ڵ��� ��� �Ӽ��� ���� */
	public int updateInterviewQuestionAll(InterviewQuestionDTO interviewQuestion) throws Exception;
	/** Ư�� ���� ���� ���� ����*/
	public InterviewQuestionDTO searchInterviewQuestionByInterviewQuestionId(String interviewQuestionId) throws Exception;
	/** Ư�� ���� ��� ���� ���� ���� ���� */
	public List<InterviewQuestionDTO> searchInterviewQuestionByTeamId(String teamId) throws Exception;
	/** ���� ���� ������ ��� Ű�� �������� */
	public List<String> getInterviewQuestionId() throws Exception;
	public int removeInterviewQuestionByTeamId(String teamId) throws Exception;
}
