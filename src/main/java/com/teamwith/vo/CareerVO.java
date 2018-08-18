package com.teamwith.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.teamwith.dto.CareerDTO;

@Component
public class CareerVO {
	private String careerId;
	private String memberId;
	private String careerName;
	private String careerStartDate;
	private String careerEndDate;
	private String careerRole;
	private String careerExplain;

	public CareerDTO toDTO() throws Exception {
		CareerDTO careerDTO = new CareerDTO();
		careerDTO.setCareerId(careerId);
		careerDTO.setMemberId(memberId);
		careerDTO.setCareerName(careerName);
		if (careerStartDate != null) {
			careerDTO.setCareerStartDate(Date.valueOf(careerStartDate));
		}
		if (careerEndDate != null) {
			careerDTO.setCareerEndDate(Date.valueOf(careerEndDate));
		}
		careerDTO.setCareerRole(careerRole);
		careerDTO.setCareerExplain(careerExplain);
		return careerDTO;
	}

	public CareerVO() {
		super();
	}

	public CareerVO(String careerId, String memberId, String careerName, String careerStartDate, String careerEndDate,
			String careerRole, String careerExplain) {
		super();
		this.careerId = careerId;
		this.memberId = memberId;
		this.careerName = careerName;
		this.careerStartDate = careerStartDate;
		this.careerEndDate = careerEndDate;
		this.careerRole = careerRole;
		this.careerExplain = careerExplain;
	}

	public String getCareerId() {
		return careerId;
	}

	public void setCareerId(String careerId) {
		this.careerId = careerId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCareerName() {
		return careerName;
	}

	public void setCareerName(String careerName) {
		this.careerName = careerName;
	}

	public String getCareerStartDate() {
		return careerStartDate;
	}

	public void setCareerStartDate(String careerStartDate) {
		this.careerStartDate = careerStartDate;
	}

	public String getCareerEndDate() {
		return careerEndDate;
	}

	public void setCareerEndDate(String careerEndDate) {
		this.careerEndDate = careerEndDate;
	}

	public String getCareerRole() {
		return careerRole;
	}

	public void setCareerRole(String careerRole) {
		this.careerRole = careerRole;
	}

	public String getCareerExplain() {
		return careerExplain;
	}

	public void setCareerExplain(String careerExplain) {
		this.careerExplain = careerExplain;
	}

	@Override
	public String toString() {
		return "CareerVO [careerId=" + careerId + ", memberId=" + memberId + ", careerName=" + careerName
				+ ", careerStartDate=" + careerStartDate + ", careerEndDate=" + careerEndDate + ", careerRole="
				+ careerRole + ", careerExplain=" + careerExplain + "]";
	}
}
