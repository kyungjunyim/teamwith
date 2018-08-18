package com.teamwith.dao;

import java.util.List;

import com.teamwith.vo.MyApplicationVO;

public interface MyApplicationDAO {
	public List<MyApplicationVO> searchMyApplication(String memberId) throws Exception;
}
