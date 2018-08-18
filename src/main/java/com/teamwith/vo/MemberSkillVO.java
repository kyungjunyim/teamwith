package com.teamwith.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.teamwith.dto.MemberSkillDTO;

@Component
public class MemberSkillVO {
	private String memberId;
	private Map<String, String> skill;

	public List<MemberSkillDTO> toDTO() {
		List<MemberSkillDTO> result = new ArrayList<MemberSkillDTO>();
		for (String key : skill.keySet()) {
			MemberSkillDTO dto = new MemberSkillDTO(memberId, key, Integer.parseInt(skill.get(key)));
			result.add(dto);
		}
		return result;
	}

	public MemberSkillVO() {
		super();
		skill = new HashMap<String, String>();
	}

	public MemberSkillVO(List<MemberSkillDTO> dto) {
		this();
		if (dto != null && !dto.isEmpty()) {
			memberId = dto.get(0).getMemberId();
			for (MemberSkillDTO s : dto) {
				addSkill(s.getSkillId(), s.getSkillLevel() + "");
			}
		}
	}

	public MemberSkillVO(String memberId, Map<String, String> skill) {
		super();
		this.memberId = memberId;
		this.skill = skill;
	}

	public String getMemberId() {
		return memberId;
	}

	public Map<String, String> getSkill() {
		return skill;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setSkill(Map<String, String> skill) {
		this.skill = skill;
	}

	public void addSkill(String skillId, String skillLevel) {
		this.skill.put(skillId, skillLevel);
	}

	public void removeSkill(String skillId) {
		this.skill.remove(skillId);
	}

	@Override
	public String toString() {
		return "MemberSkillVO [memberId=" + memberId + ", skill=" + skill + "]";
	}

}
