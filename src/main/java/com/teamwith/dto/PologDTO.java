package com.teamwith.dto;

import org.springframework.stereotype.Component;

import com.teamwith.vo.PologVO;

@Component
public class PologDTO {
	private String memberId;
	private String pologTitle;
	private String pologTitlePosition;
	private String pologIntroPic;
	private String pologThemeColor;
	private String pologBgColor;
	private String pologBgPic;
	private String pologMenuPosition;
	private String pologIntro;
	public PologDTO() {
		super();
	}
	public PologDTO(String memberId, String pologTitle, String pologTitlePosition, String pologIntroPic,
			String pologThemeColor, String pologBgColor, String pologBgPic, String pologMenuPosition,
			String pologIntro) {
		super();
		this.memberId = memberId;
		this.pologTitle = pologTitle;
		this.pologTitlePosition = pologTitlePosition;
		this.pologIntroPic = pologIntroPic;
		this.pologThemeColor = pologThemeColor;
		this.pologBgColor = pologBgColor;
		this.pologBgPic = pologBgPic;
		this.pologMenuPosition = pologMenuPosition;
		this.pologIntro = pologIntro;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPologTitle() {
		return pologTitle;
	}
	public void setPologTitle(String pologTitle) {
		this.pologTitle = pologTitle;
	}
	public String getPologTitlePosition() {
		return pologTitlePosition;
	}
	public void setPologTitlePosition(String pologTitlePosition) {
		this.pologTitlePosition = pologTitlePosition;
	}
	public String getPologIntroPic() {
		return pologIntroPic;
	}
	public void setPologIntroPic(String pologIntroPic) {
		this.pologIntroPic = pologIntroPic;
	}
	public String getPologThemeColor() {
		return pologThemeColor;
	}
	public void setPologThemeColor(String pologThemeColor) {
		this.pologThemeColor = pologThemeColor;
	}
	public String getPologBgColor() {
		return pologBgColor;
	}
	public void setPologBgColor(String pologBgColor) {
		this.pologBgColor = pologBgColor;
	}
	public String getPologBgPic() {
		return pologBgPic;
	}
	public void setPologBgPic(String pologBgPic) {
		this.pologBgPic = pologBgPic;
	}
	public String getPologMenuPosition() {
		return pologMenuPosition;
	}
	public void setPologMenuPosition(String pologMenuPosition) {
		this.pologMenuPosition = pologMenuPosition;
	}
	public String getPologIntro() {
		return pologIntro;
	}
	public void setPologIntro(String pologIntro) {
		this.pologIntro = pologIntro;
	}
	public PologVO toVO() {
		PologVO vo = new PologVO(memberId, pologTitle, pologTitlePosition, pologIntroPic, 
				pologThemeColor, pologBgColor, pologBgPic, pologMenuPosition, pologIntro);
		return vo;
	}
	@Override
	public String toString() {
		return "PologDTO [memberId=" + memberId + ", pologTitle=" + pologTitle + ", pologTitlePosition="
				+ pologTitlePosition + ", pologIntroPic=" + pologIntroPic + ", pologThemeColor=" + pologThemeColor
				+ ", pologBgColor=" + pologBgColor + ", pologBgPic=" + pologBgPic + ", pologMenuPosition="
				+ pologMenuPosition + ", pologIntro=" + pologIntro + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((pologBgColor == null) ? 0 : pologBgColor.hashCode());
		result = prime * result + ((pologBgPic == null) ? 0 : pologBgPic.hashCode());
		result = prime * result + ((pologIntro == null) ? 0 : pologIntro.hashCode());
		result = prime * result + ((pologIntroPic == null) ? 0 : pologIntroPic.hashCode());
		result = prime * result + ((pologMenuPosition == null) ? 0 : pologMenuPosition.hashCode());
		result = prime * result + ((pologThemeColor == null) ? 0 : pologThemeColor.hashCode());
		result = prime * result + ((pologTitle == null) ? 0 : pologTitle.hashCode());
		result = prime * result + ((pologTitlePosition == null) ? 0 : pologTitlePosition.hashCode());
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
		PologDTO other = (PologDTO) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (pologBgColor == null) {
			if (other.pologBgColor != null)
				return false;
		} else if (!pologBgColor.equals(other.pologBgColor))
			return false;
		if (pologBgPic == null) {
			if (other.pologBgPic != null)
				return false;
		} else if (!pologBgPic.equals(other.pologBgPic))
			return false;
		if (pologIntro == null) {
			if (other.pologIntro != null)
				return false;
		} else if (!pologIntro.equals(other.pologIntro))
			return false;
		if (pologIntroPic == null) {
			if (other.pologIntroPic != null)
				return false;
		} else if (!pologIntroPic.equals(other.pologIntroPic))
			return false;
		if (pologMenuPosition == null) {
			if (other.pologMenuPosition != null)
				return false;
		} else if (!pologMenuPosition.equals(other.pologMenuPosition))
			return false;
		if (pologThemeColor == null) {
			if (other.pologThemeColor != null)
				return false;
		} else if (!pologThemeColor.equals(other.pologThemeColor))
			return false;
		if (pologTitle == null) {
			if (other.pologTitle != null)
				return false;
		} else if (!pologTitle.equals(other.pologTitle))
			return false;
		if (pologTitlePosition == null) {
			if (other.pologTitlePosition != null)
				return false;
		} else if (!pologTitlePosition.equals(other.pologTitlePosition))
			return false;
		return true;
	}
}
