package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.ApplicationDTO;

public interface ApplicationDAO {	
	/** Appliction_tb�� ���ڵ� �߰�*/
	public int addApplication(ApplicationDTO application) throws Exception;
	/** application_id�� �ش��ϴ� ���ڵ� ����*/
	public int removeApplicationByApplicationId(String applicationId) throws Exception;
	/** application_id�� �ش��ϴ� ���ڵ��� application_status�� ���� */
	public int updateApplicationStatusByApplicationId(ApplicationDTO application) throws Exception;
	/** application_id�� �ش��ϴ� ���ڵ��� ��� �Ӽ��� ����*/
	public int updateApplicationAll(ApplicationDTO application) throws Exception;
	/** application_id�� �ش��ϴ� ���ڵ� �˻� */
	public ApplicationDTO searchApplicationByApplicationId(String applicationId) throws Exception;
	/** Ư�� ȸ���� �������� �˻� (�� �������� �˻��� ���)*/
	public List<ApplicationDTO> searchApplicationByMemberId(String memberId) throws Exception;
	/** Ư�� ���� ������ �������� �������� �˻� (�� �� ������ ���⿡ ���)*/
	public List<ApplicationDTO> searchApplicationByTeamId(String teamId) throws Exception;
	/** ��� �������� �ҷ�����*/
	public List<ApplicationDTO> searchApplicationAll() throws Exception;
	public List<String> getApplicationId() throws Exception;
}
