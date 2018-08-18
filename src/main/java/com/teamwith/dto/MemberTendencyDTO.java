package com.teamwith.dto;

import org.springframework.stereotype.Component;

@Component
public class MemberTendencyDTO {
	private String memberId;
	private String tendencyId;
	private int tendencyFigure;
	public MemberTendencyDTO() {
		super();
	}
	public MemberTendencyDTO(String memberId, String tendencyId, int tendencyFigure) {
		super();
		this.memberId = memberId;
		this.tendencyId = tendencyId;
		this.tendencyFigure = tendencyFigure;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTendencyId() {
		return tendencyId;
	}
	public void setTendencyId(String tendencyId) {
		this.tendencyId = tendencyId;
	}
	public int getTendencyFigure() {
		return tendencyFigure;
	}
	public void setTendencyFigure(int tendencyFigure) {
		this.tendencyFigure = tendencyFigure;
	}

	@Override
	public String toString() {
		return "MemberTendencyDTO [memberId=" + memberId + ", tendencyId=" + tendencyId + ", tendencyFigure="
				+ tendencyFigure + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + tendencyFigure;
		result = prime * result + ((tendencyId == null) ? 0 : tendencyId.hashCode());
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
		MemberTendencyDTO other = (MemberTendencyDTO) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (tendencyFigure != other.tendencyFigure)
			return false;
		if (tendencyId == null) {
			if (other.tendencyId != null)
				return false;
		} else if (!tendencyId.equals(other.tendencyId))
			return false;
		return true;
	}
}
