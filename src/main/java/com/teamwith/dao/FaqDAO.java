package com.teamwith.dao;

import java.util.List;
import java.util.Map;

import com.teamwith.dto.FaqDTO;

public interface FaqDAO {
	public int addFaq(FaqDTO faq) throws Exception;
	public int removeFaqByFaqId(String faqId) throws Exception;
	public int removeFaqByTeamId(String teamId) throws Exception;
	public int updateFaqQuestion(Map<String, Object> map) throws Exception;
	public int updateFaqAnswer(Map<String, Object> map) throws Exception;
	public int updateFaq(FaqDTO faq) throws Exception;
	public List<FaqDTO> searchFaqByFaqId(String faqId) throws Exception;
	public List<FaqDTO> searchFaqByTeamId(String teamId) throws Exception;
	public List<FaqDTO> searchFaqAll() throws Exception;
	public List<String> getId() throws Exception;
}
