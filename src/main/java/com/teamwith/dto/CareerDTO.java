package com.teamwith.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.teamwith.vo.CareerVO;

@Component
public class CareerDTO {
	private String careerId;
	private String memberId;
	private String careerName;
	private Date careerStartDate;
	private Date careerEndDate;
	private String careerRole;
	private String careerExplain;

	public CareerDTO() {
		super();
	}

	public CareerDTO(String careerId, String memberId, String careerName, Date careerStartDate, Date careerEndDate,
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

	public Date getCareerStartDate() {
		return careerStartDate;
	}

	public void setCareerStartDate(Date careerStartDate) {
		this.careerStartDate = careerStartDate;
	}

	public Date getCareerEndDate() {
		return careerEndDate;
	}

	public void setCareerEndDate(Date careerEndDate) {
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

	public CareerVO toVO() {
		CareerVO vo = new CareerVO(careerId, memberId, careerName, careerStartDate+"", careerEndDate+"",
				careerRole, careerExplain);
		return vo;
	}

	@Override
	public String toString() {
		return "CareerDTO [careerId=" + careerId + ", memberId=" + memberId + ", careerName=" + careerName
				+ ", careerStartDate=" + careerStartDate + ", careerEndDate=" + careerEndDate + ", careerRole="
				+ careerRole + ", careerExplain=" + careerExplain + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((careerEndDate == null) ? 0 : careerEndDate.hashCode());
		result = prime * result + ((careerExplain == null) ? 0 : careerExplain.hashCode());
		result = prime * result + ((careerId == null) ? 0 : careerId.hashCode());
		result = prime * result + ((careerName == null) ? 0 : careerName.hashCode());
		result = prime * result + ((careerRole == null) ? 0 : careerRole.hashCode());
		result = prime * result + ((careerStartDate == null) ? 0 : careerStartDate.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CareerDTO other = (CareerDTO) obj;
		if (careerEndDate == null) {
			if (other.careerEndDate != null)
				return false;
		} else if (!careerEndDate.equals(other.careerEndDate))
			return false;
		if (careerExplain == null) {
			if (other.careerExplain != null)
				return false;
		} else if (!careerExplain.equals(other.careerExplain))
			return false;
		if (careerId == null) {
			if (other.careerId != null)
				return false;
		} else if (!careerId.equals(other.careerId))
			return false;
		if (careerName == null) {
			if (other.careerName != null)
				return false;
		} else if (!careerName.equals(other.careerName))
			return false;
		if (careerRole == null) {
			if (other.careerRole != null)
				return false;
		} else if (!careerRole.equals(other.careerRole))
			return false;
		if (careerStartDate == null) {
			if (other.careerStartDate != null)
				return false;
		} else if (!careerStartDate.equals(other.careerStartDate))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
}
