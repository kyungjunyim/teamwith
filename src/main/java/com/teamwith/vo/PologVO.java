package com.teamwith.vo;

import org.springframework.stereotype.Component;

import com.teamwith.dto.PologDTO;

@Component
public class PologVO {
	private String memberId;
	private String pologTitle;
	private String pologTitlePosition;
	private String pologIntroPic;
	private String pologThemeColor;
	private String pologBgColor;
	private String pologBgPic;
	private String pologMenuPosition;
	private String pologIntro;
	public PologDTO toDTO() {
		PologDTO pologDTO = new PologDTO();
		pologDTO.setMemberId(memberId);
		pologDTO.setPologTitle(pologTitle);
		pologDTO.setPologTitlePosition(pologTitlePosition);
		pologDTO.setPologIntroPic(pologIntroPic);
		pologDTO.setPologThemeColor(pologThemeColor);
		pologDTO.setPologBgColor(pologBgColor);
		pologDTO.setPologBgPic(pologBgPic);
		pologDTO.setPologMenuPosition(pologMenuPosition);
		pologDTO.setPologIntro(pologIntro);
		return pologDTO;
	}
	public PologVO() {
		super();
	}
	public PologVO(String memberId, String pologTitle, String pologTitlePosition, String pologIntroPic,
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
	@Override
	public String toString() {
		return "PologVO [memberId=" + memberId + ", pologTitle=" + pologTitle + ", pologTitlePosition="
				+ pologTitlePosition + ", pologIntroPic=" + pologIntroPic + ", pologThemeColor=" + pologThemeColor
				+ ", pologBgColor=" + pologBgColor + ", pologBgPic=" + pologBgPic + ", pologMenuPosition="
				+ pologMenuPosition + ", pologIntro=" + pologIntro + "]";
	}
}
