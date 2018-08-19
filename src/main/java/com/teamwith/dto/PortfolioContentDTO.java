package com.teamwith.dto;

import org.springframework.stereotype.Component;

import com.teamwith.vo.PortfolioContentVO;

@Component
public class PortfolioContentDTO {
	private String portfolioContentId;
	private String portfolioId;
	private int portfolioContentOrder;
	private String layoutId;
	private String portfolioContentName;
	private String portfolioContentValue;
	private String portfolioContentIntro;

	public PortfolioContentVO toVO() {
		PortfolioContentVO vo = new PortfolioContentVO(portfolioContentId, portfolioId, 
				portfolioContentOrder+"", layoutId, portfolioContentName, portfolioContentValue,portfolioContentIntro);
		return vo;
	}

	public PortfolioContentDTO() {
		super();
	}

	public PortfolioContentDTO(String portfolioContentId, String portfolioId, int portfolioContentOrder,
			String layoutId, String portfolioContentName, String portfolioContentValue,String portfolioContentIntro) {
		super();
		this.portfolioContentId = portfolioContentId;
		this.portfolioId = portfolioId;
		this.portfolioContentOrder = portfolioContentOrder;
		this.layoutId = layoutId;
		this.portfolioContentName = portfolioContentName;
		this.portfolioContentValue = portfolioContentValue;
		this.portfolioContentIntro =portfolioContentIntro;
	}

	public String getPortfolioContentId() {
		return portfolioContentId;
	}

	public String getPortfolioId() {
		return portfolioId;
	}

	public int getPortfolioContentOrder() {
		return portfolioContentOrder;
	}

	public String getLayoutId() {
		return layoutId;
	}

	public String getPortfolioContentName() {
		return portfolioContentName;
	}
	
	public String getPortfolioContentIntro() {
		return portfolioContentIntro;
	}

	public void setPortfolioContentIntro(String portfolioContentIntro) {
		this.portfolioContentIntro = portfolioContentIntro;
	}

	public String getPortfolioContentValue() {
		return portfolioContentValue;
	}

	public void setPortfolioContentId(String portfolioContentId) {
		this.portfolioContentId = portfolioContentId;
	}

	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}

	public void setPortfolioContentOrder(int portfolioContentOrder) {
		this.portfolioContentOrder = portfolioContentOrder;
	}

	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}

	public void setPortfolioContentName(String portfolioContentName) {
		this.portfolioContentName = portfolioContentName;
	}

	public void setPortfolioContentValue(String portfolioContentValue) {
		this.portfolioContentValue = portfolioContentValue;
	}

	@Override
	public String toString() {
		return "PortfolioContentDTO [portfolioContentId=" + portfolioContentId + ", portfolioId=" + portfolioId
				+ ", portfolioContentOrder=" + portfolioContentOrder + ", layoutId=" + layoutId
				+ ", portfolioContentName=" + portfolioContentName + ", portfolioContentValue=" + portfolioContentValue
				+ ", portfolioContentIntro=" + portfolioContentIntro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((layoutId == null) ? 0 : layoutId.hashCode());
		result = prime * result + ((portfolioContentId == null) ? 0 : portfolioContentId.hashCode());
		result = prime * result + ((portfolioContentIntro == null) ? 0 : portfolioContentIntro.hashCode());
		result = prime * result + ((portfolioContentName == null) ? 0 : portfolioContentName.hashCode());
		result = prime * result + portfolioContentOrder;
		result = prime * result + ((portfolioContentValue == null) ? 0 : portfolioContentValue.hashCode());
		result = prime * result + ((portfolioId == null) ? 0 : portfolioId.hashCode());
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
		PortfolioContentDTO other = (PortfolioContentDTO) obj;
		if (layoutId == null) {
			if (other.layoutId != null)
				return false;
		} else if (!layoutId.equals(other.layoutId))
			return false;
		if (portfolioContentId == null) {
			if (other.portfolioContentId != null)
				return false;
		} else if (!portfolioContentId.equals(other.portfolioContentId))
			return false;
		if (portfolioContentIntro == null) {
			if (other.portfolioContentIntro != null)
				return false;
		} else if (!portfolioContentIntro.equals(other.portfolioContentIntro))
			return false;
		if (portfolioContentName == null) {
			if (other.portfolioContentName != null)
				return false;
		} else if (!portfolioContentName.equals(other.portfolioContentName))
			return false;
		if (portfolioContentOrder != other.portfolioContentOrder)
			return false;
		if (portfolioContentValue == null) {
			if (other.portfolioContentValue != null)
				return false;
		} else if (!portfolioContentValue.equals(other.portfolioContentValue))
			return false;
		if (portfolioId == null) {
			if (other.portfolioId != null)
				return false;
		} else if (!portfolioId.equals(other.portfolioId))
			return false;
		return true;
	}

}
