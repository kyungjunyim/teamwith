//�ۼ���: Ȳ���� 
package com.teamwith.dao;

import java.util.List;
import java.util.Map;

import com.teamwith.dto.CommentDTO;

public interface CommentDAO {
	/** CommentDTO ��ü�� �޾Ƽ� ���ڵ带 �߰��Ѵ�.*/
	public int addComment(CommentDTO comment) throws Exception;
	/** commentId�� �ش��ϴ� ���ڵ带 �����Ѵ�.*/
	public int removeCommentByCommentId(String commentId) throws Exception;
	/** Ư�� ȸ���� ��� Comment_tb ���ڵ带 �����Ѵ�.*/
	public int removeCommentByMemberId(String memberId) throws Exception;
	/** comment_id�� �ش��ϴ� ���ڵ��� comment_content�� �����Ѵ�. (������Ʈ ��¥�� ���� ��¥�� �ٲ��.)*/
	public int updateComment(CommentDTO comment) throws Exception;
	/** comment_id�� �ش��ϴ� ���ڵ��� ��� �Ӽ��� �����Ѵ�.*/
	public int updateCommentAll(CommentDTO comment) throws Exception;
	/** ���� �޸� ��� comment ã��*/
	public List<CommentDTO> searchCommentByTeamId(String teamId) throws Exception;
	/** Ư�� ��ۿ� �޸� ���� ã��*/
	public List<CommentDTO> searchCommentByParentCommentId(String parentCommentId) throws Exception;
	/** ��� ��� ���ڵ� �ҷ�����*/
	public List<CommentDTO> searchCommentAll() throws Exception;
	
	public List<String> getId() throws Exception;
	
	public int updateCommentContent(Map<String, String> paramMap) throws Exception;
}
