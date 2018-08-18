package com.teamwith.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.teamwith.dto.MemberTendencyDTO;

@Component
public class MemberTendencyVO {
	private String memberId;
	private Map<String, String> tendency;

	public List<MemberTendencyDTO> toDTO() {
		List<MemberTendencyDTO> result = new ArrayList<MemberTendencyDTO>();
		for (String key : tendency.keySet()) {
			MemberTendencyDTO dto = new MemberTendencyDTO(memberId, key, Integer.parseInt(tendency.get(key)));
			result.add(dto);
		}
		return result;
	}

	public MemberTendencyVO() {
		super();
		tendency = new HashMap<String, String>();
	}

	public MemberTendencyVO(List<MemberTendencyDTO> dto) {
		this();
		if (dto != null && !dto.isEmpty()) {
			memberId = dto.get(0).getMemberId();
			for (MemberTendencyDTO s : dto) {
				addTendency(s.getTendencyId(), s.getTendencyFigure()+"");
			}
		}
	}
	
	public MemberTendencyVO(String memberId, Map<String, String> tendency) {
		super();
		this.memberId = memberId;
		this.tendency = tendency;
	}

	public String getMemberId() {
		return memberId;
	}

	public Map<String, String> getTendency() {
		return tendency;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setTendency(Map<String, String> tendency) {
		this.tendency = tendency;
	}
	
	public void addTendency(String tendencyId,String tendencyFigure) {
		this.tendency.put(tendencyId,tendencyFigure);
	}

	public void removeTendency(String tendencyId) {
		this.tendency.remove(tendencyId);
	}
	@Override
	public String toString() {
		return "MemberTendencyVO [memberId=" + memberId + ", tendency=" + tendency + "]";
	}

	
}
