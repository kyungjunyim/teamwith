package com.teamwith.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.teamwith.dto.LicenseDTO;

@Component
public class LicenseVO {
	private String licenseId;
	private String memberId;
	private String licenseName;
	private String licenseDate;
	private String licenseLevel;
	public LicenseDTO toDTO() throws Exception {
		LicenseDTO licenseDTO = new LicenseDTO();
		licenseDTO.setLicenseId(licenseId);
		licenseDTO.setMemberId(memberId);
		licenseDTO.setLicenseName(licenseName);
		licenseDTO.setLicenseDate(Date.valueOf(licenseDate));
		licenseDTO.setLicenseLevel(licenseLevel);
		return licenseDTO;
	}
	public LicenseVO() {
		super();
	}
	public LicenseVO(String licenseId, String memberId, String licenseName, String licenseDate, String licenseLevel) {
		super();
		this.licenseId = licenseId;
		this.memberId = memberId;
		this.licenseName = licenseName;
		this.licenseDate = licenseDate;
		this.licenseLevel = licenseLevel;
	}
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getLicenseName() {
		return licenseName;
	}
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	public String getLicenseDate() {
		return licenseDate;
	}
	public void setLicenseDate(String licenseDate) {
		this.licenseDate = licenseDate;
	}
	public String getLicenseLevel() {
		return licenseLevel;
	}
	public void setLicenseLevel(String licenseLevel) {
		this.licenseLevel = licenseLevel;
	}
	@Override
	public String toString() {
		return "LicenseVO [licenseId=" + licenseId + ", memberId=" + memberId + ", licenseName=" + licenseName
				+ ", licenseDate=" + licenseDate + ", licenseLevel=" + licenseLevel + "]";
	}
}
