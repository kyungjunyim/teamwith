package com.teamwith.dao;

import java.util.List;

import com.teamwith.vo.MainProfileVO;

public interface MainProfileDAO {
	public MainProfileVO searchMainProfile(String memberId) throws Exception;
	public List<MainProfileVO> searchAllMainProfile() throws Exception;
}
