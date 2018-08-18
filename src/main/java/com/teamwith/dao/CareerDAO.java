package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.CareerDTO;

public interface CareerDAO {
	public int addCareer(CareerDTO dto) throws Exception;

	public int updateCareer(CareerDTO dto) throws Exception;

	public int removeCareer(String careerId) throws Exception;

	public int removeCareerByMember(String memberId) throws Exception;

	public List<CareerDTO> searchCareer(String memberId) throws Exception;

	public List<CareerDTO> searchAllCareer() throws Exception;

	public List<String> getId() throws Exception;
}
