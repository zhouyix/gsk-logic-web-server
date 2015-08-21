package com.gsk.server.model;

import java.util.ArrayList;
import java.util.List;

public class BaseRecommendProject {
	
	private String prjId;
	
	private int recommendType;
	
	private List<Object> recommendInfo = new ArrayList<Object>();
	
	public BaseRecommendProject(String prjId, int recommendType) {
		this.prjId = prjId;
		this.recommendType = recommendType;
	}

	public String getPrjId() {
		return prjId;
	}

	public void setPrjId(String prjId) {
		this.prjId = prjId;
	}

	public int getRecommendType() {
		return recommendType;
	}

	public void setRecommendType(int recommendType) {
		this.recommendType = recommendType;
	}

	public List<Object> getRecommendInfo() {
		return recommendInfo;
	}

	public void setRecommendInfo(List<Object> recommendInfo) {
		this.recommendInfo = recommendInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prjId == null) ? 0 : prjId.hashCode());
		result = prime * result + recommendType;
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
		BaseRecommendProject other = (BaseRecommendProject) obj;
		if (prjId == null) {
			if (other.prjId != null)
				return false;
		} else if (!prjId.equals(other.prjId))
			return false;
		if (recommendType != other.recommendType)
			return false;
		return true;
	}
}
