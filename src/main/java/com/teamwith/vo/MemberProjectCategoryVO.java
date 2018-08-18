package com.teamwith.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.teamwith.dto.MemberProjectCategoryDTO;

@Component
public class MemberProjectCategoryVO {
	private String memberId;
	private List<String> projectCategoryId;

	public MemberProjectCategoryVO() {
		super();
		projectCategoryId = new ArrayList<String>();
	}

	public MemberProjectCategoryVO(List<MemberProjectCategoryDTO> dto) {
		this();
		if (dto != null && !dto.isEmpty()) {

			this.memberId = dto.get(0).getMemberId();
			for (MemberProjectCategoryDTO p : dto) {
				addProjectCategoryId(p.getProjectCategoryId());
			}
		}
	}

	public MemberProjectCategoryVO(String memberId, String[] projectCategoryId) {
		super();
		this.memberId = memberId;
		this.projectCategoryId = new ArrayList<String>();
		if (projectCategoryId != null) {
			for (String ct : projectCategoryId) {
				this.projectCategoryId.add(ct);
			}
		}
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

	public String getMemberId() {
		return memberId;
	}

	public List<String> getProjectCategoryId() {
		return projectCategoryId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setProjectCategoryId(List<String> projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}

	public void addProjectCategoryId(String projectCategoryId) {
		this.projectCategoryId.add(projectCategoryId);
	}

	public void removeProjectCategoryId(String projectCategoryId) {
		this.projectCategoryId.remove(projectCategoryId);
	}

	@Override
	public String toString() {
		return "MemberProjectCategoryVO [memberId=" + memberId + ", projectCategoryId=" + projectCategoryId + "]";
	}

}
