package com.teamwith.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.teamwith.vo.MemberVO;

@Component
public class MemberDTO {
	private String memberId;
	private String memberName;
	private String memberPassword;
	private String memberEmail;
	private Date memberBirth;
	private String memberPic;
	private int memberActive;
	private String memberPhone;
	private int memberPublic;
	private String memberIntro;
	private Date memberOutDate;
	private int memberAuth;
	private String roleId;
	private String regionId1;
	private String regionId2;

	public MemberDTO() {
		super();
	}

	public MemberDTO(String memberId, String memberName, String memberPassword, String memberEmail, Date memberBirth,
			String memberPic, int memberActive, String memberPhone, int memberPublic, String memberIntro,
			Date memberOutDate, int memberAuth, String roleId, String regionId1, String regionId2) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
		this.memberBirth = memberBirth;
		this.memberPic = memberPic;
		this.memberActive = memberActive;
		this.memberPhone = memberPhone;
		this.memberPublic = memberPublic;
		this.memberIntro = memberIntro;
		this.memberOutDate = memberOutDate;
		this.memberAuth = memberAuth;
		this.roleId = roleId;
		this.regionId1 = regionId1;
		this.regionId2 = regionId2;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public Date getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberPic() {
		return memberPic;
	}

	public void setMemberPic(String memberPic) {
		this.memberPic = memberPic;
	}

	public int getMemberActive() {
		return memberActive;
	}

	public void setMemberActive(int memberActive) {
		this.memberActive = memberActive;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public int getMemberPublic() {
		return memberPublic;
	}

	public void setMemberPublic(int memberPublic) {
		this.memberPublic = memberPublic;
	}

	public String getMemberIntro() {
		return memberIntro;
	}

	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}

	public Date getMemberOutDate() {
		return memberOutDate;
	}

	public void setMemberOutDate(Date memberOutDate) {
		this.memberOutDate = memberOutDate;
	}

	public int getMemberAuth() {
		return memberAuth;
	}

	public void setMemberAuth(int memberAuth) {
		this.memberAuth = memberAuth;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRegionId1() {
		return regionId1;
	}

	public void setRegionId1(String regionId1) {
		this.regionId1 = regionId1;
	}

	public String getRegionId2() {
		return regionId2;
	}

	public void setRegionId2(String regionId2) {
		this.regionId2 = regionId2;
	}

	public MemberVO toVO() {
		MemberVO vo = new MemberVO(memberId, memberName, memberPassword, memberEmail, memberBirth.toString(), memberPic,
				memberActive + "", memberPhone, memberPublic + "", memberIntro, null, memberAuth + "", roleId,
				regionId1, regionId2);
		if (memberOutDate != null) {
			vo.setMemberOutDate(memberOutDate.toString());
		}
		return vo;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberName=" + memberName + ", memberPassword=" + memberPassword
				+ ", memberEmail=" + memberEmail + ", memberBirth=" + memberBirth + ", memberPic=" + memberPic
				+ ", memberActive=" + memberActive + ", memberPhone=" + memberPhone + ", memberPublic=" + memberPublic
				+ ", memberIntro=" + memberIntro + ", memberOutDate=" + memberOutDate + ", memberAuth=" + memberAuth
				+ ", roleId=" + roleId + ", regionId1=" + regionId1 + ", regionId2=" + regionId2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + memberActive;
		result = prime * result + memberAuth;
		result = prime * result + ((memberBirth == null) ? 0 : memberBirth.hashCode());
		result = prime * result + ((memberEmail == null) ? 0 : memberEmail.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberIntro == null) ? 0 : memberIntro.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberOutDate == null) ? 0 : memberOutDate.hashCode());
		result = prime * result + ((memberPassword == null) ? 0 : memberPassword.hashCode());
		result = prime * result + ((memberPhone == null) ? 0 : memberPhone.hashCode());
		result = prime * result + ((memberPic == null) ? 0 : memberPic.hashCode());
		result = prime * result + memberPublic;
		result = prime * result + ((regionId1 == null) ? 0 : regionId1.hashCode());
		result = prime * result + ((regionId2 == null) ? 0 : regionId2.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		MemberDTO other = (MemberDTO) obj;
		if (memberActive != other.memberActive)
			return false;
		if (memberAuth != other.memberAuth)
			return false;
		if (memberBirth == null) {
			if (other.memberBirth != null)
				return false;
		} else if (!memberBirth.equals(other.memberBirth))
			return false;
		if (memberEmail == null) {
			if (other.memberEmail != null)
				return false;
		} else if (!memberEmail.equals(other.memberEmail))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberIntro == null) {
			if (other.memberIntro != null)
				return false;
		} else if (!memberIntro.equals(other.memberIntro))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberOutDate == null) {
			if (other.memberOutDate != null)
				return false;
		} else if (!memberOutDate.equals(other.memberOutDate))
			return false;
		if (memberPassword == null) {
			if (other.memberPassword != null)
				return false;
		} else if (!memberPassword.equals(other.memberPassword))
			return false;
		if (memberPhone == null) {
			if (other.memberPhone != null)
				return false;
		} else if (!memberPhone.equals(other.memberPhone))
			return false;
		if (memberPic == null) {
			if (other.memberPic != null)
				return false;
		} else if (!memberPic.equals(other.memberPic))
			return false;
		if (memberPublic != other.memberPublic)
			return false;
		if (regionId1 == null) {
			if (other.regionId1 != null)
				return false;
		} else if (!regionId1.equals(other.regionId1))
			return false;
		if (regionId2 == null) {
			if (other.regionId2 != null)
				return false;
		} else if (!regionId2.equals(other.regionId2))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}
}
