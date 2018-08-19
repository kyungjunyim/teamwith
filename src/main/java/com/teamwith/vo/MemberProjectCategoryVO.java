package com.teamwith.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.teamwith.dto.MemberProjectCategoryDTO;

@Component
public class MemberProjectCategoryVO {
	private String memberId;
	private String[] projectCategoryId;

	public MemberProjectCategoryVO() {
		super();
	}

	public MemberProjectCategoryVO(List<MemberProjectCategoryDTO> dto) {
		this();
		if (dto != null && !dto.isEmpty()) {

			this.memberId = dto.get(0).getMemberId();
			projectCategoryId = new String[dto.size()];
			for (int i = 0; i < projectCategoryId.length; i++) {
				projectCategoryId[i] = dto.get(i).getProjectCategoryId();
			}
		}
	}

	public MemberProjectCategoryVO(String memberId, String[] projectCategoryId) {
		super();
		this.memberId = memberId;
		this.projectCategoryId = projectCategoryId;
	}

	public List<MemberProjectCategoryDTO> toDTO() {
		List<MemberProjectCategoryDTO> result = new ArrayList<MemberProjectCategoryDTO>();
		if (projectCategoryId != null) {
			for (String p : projectCategoryId) {
				result.add(new MemberProjectCategoryDTO(memberId, p));
			}
		}
		return result;

	}

	public final String getMemberId() {
		return memberId;
	}

	public final String[] getProjectCategoryId() {
		return projectCategoryId;
	}

	public final void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public final void setProjectCategoryId(String[] projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}

	@Override
	public String toString() {
		return "MemberProjectCategoryVO [memberId=" + memberId + ", projectCategoryId=" + projectCategoryId + "]";
	}

}
