package com.teamwith.dto;

import org.springframework.stereotype.Component;

import com.teamwith.vo.MemberPraiseVO;

@Component
public class MemberPraiseDTO {
	private String actorMemberId;
	private String targetMemberId;
	private String praiseId;
	public MemberPraiseDTO() {
		super();
	}
	public MemberPraiseDTO(String actorMemberId, String targetMemberId, String praiseId) {
		super();
		this.actorMemberId = actorMemberId;
		this.targetMemberId = targetMemberId;
		this.praiseId = praiseId;
	}
	public String getActorMemberId() {
		return actorMemberId;
	}
	public String getTargetMemberId() {
		return targetMemberId;
	}
	public String getPraiseId() {
		return praiseId;
	}
	public void setActorMemberId(String actorMemberId) {
		this.actorMemberId = actorMemberId;
	}
	public void setTargetMemberId(String targetMemberId) {
		this.targetMemberId = targetMemberId;
	}
	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}
	
	public MemberPraiseVO toVO() {
		MemberPraiseVO vo = new MemberPraiseVO(actorMemberId, targetMemberId, praiseId);
		return vo;
	}
	
	public String toString() {
		return "MemberPraiseDTO [actorMemberId=" + actorMemberId + ", targetMemberId=" + targetMemberId + ", praiseId="
				+ praiseId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorMemberId == null) ? 0 : actorMemberId.hashCode());
		result = prime * result + ((praiseId == null) ? 0 : praiseId.hashCode());
		result = prime * result + ((targetMemberId == null) ? 0 : targetMemberId.hashCode());
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
		MemberPraiseDTO other = (MemberPraiseDTO) obj;
		if (actorMemberId == null) {
			if (other.actorMemberId != null)
				return false;
		} else if (!actorMemberId.equals(other.actorMemberId))
			return false;
		if (praiseId == null) {
			if (other.praiseId != null)
				return false;
		} else if (!praiseId.equals(other.praiseId))
			return false;
		if (targetMemberId == null) {
			if (other.targetMemberId != null)
				return false;
		} else if (!targetMemberId.equals(other.targetMemberId))
			return false;
		return true;
	}
	
}
