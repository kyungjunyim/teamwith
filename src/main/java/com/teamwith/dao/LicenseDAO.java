package com.teamwith.dao;

import java.util.List;

import com.teamwith.dto.LicenseDTO;

public interface LicenseDAO {
	public int addLicense(LicenseDTO dto) throws Exception;
	public int updateLicense(LicenseDTO dto) throws Exception;
	public int removeLicense(String licenseId) throws Exception;
	public int removeLicenseByMember(String memberId) throws Exception;
	public List<LicenseDTO> searchLicense(String memberId) throws Exception;
	public List<LicenseDTO> searchAllLicense() throws Exception;
	public List<String> getId() throws Exception;
}
