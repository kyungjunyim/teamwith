package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.PologDTO;

public interface PologDAO {
	public int addPologByMemberId(String memberId) ;
	public int addPologByAllInfo(PologDTO polog);
	public int updatePolog(PologDTO polog) ;
	public int removePolog(String memberId) ;
	public List<PologDTO> searchAllPologList();
	public PologDTO searchPologByMemberId(String memberId);
}
