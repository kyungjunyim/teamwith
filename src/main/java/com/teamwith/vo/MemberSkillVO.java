package com.teamwith.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.teamwith.dto.MemberSkillDTO;

@Component
public class MemberSkillVO {
	private String memberId;
	private String[] skill;

	public List<MemberSkillDTO> toDTO() {
		List<MemberSkillDTO> result = new ArrayList<MemberSkillDTO>();
		for (String key : skill) {
			MemberSkillDTO dto = new MemberSkillDTO(memberId, key);
			result.add(dto);
		}
		return result;
	}

	public MemberSkillVO() {

	}

	public MemberSkillVO(List<MemberSkillDTO> dto) {
		if (dto != null && !dto.isEmpty()) {
			memberId = dto.get(0).getMemberId();
			skill = new String[dto.size()];
			for (int i = 0; i < dto.size(); i++) {
				skill[i] = dto.get(i).getSkillId();
			}
		}
	}

	public MemberSkillVO(String memberId, String[] skill) {
		super();
		this.memberId = memberId;
		this.skill = skill;
	}

	public final String getMemberId() {
		return memberId;
	}

	public final String[] getSkill() {
		return skill;
	}

	public final void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public final void setSkill(String[] skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "MemberSkillVO [memberId=" + memberId + ", skill=" + skill + "]";
	}

}
