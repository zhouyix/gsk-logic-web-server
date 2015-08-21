package com.gsk.server.model;

import java.util.ArrayList;
import java.util.List;

public class BaseRecommendFriend {
	private int fuin;
	
	private int recommendType;
	
	private List<Object> recommendInfo = new ArrayList<Object>();

	public BaseRecommendFriend(int fuin, int recommendType) {
		this.fuin = fuin;
		this.recommendType = recommendType;
	}

	public int getFuin() {
		return fuin;
	}

	public void setFuin(int fuin) {
		this.fuin = fuin;
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
		result = prime * result + fuin;
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
		BaseRecommendFriend other = (BaseRecommendFriend) obj;
		if (fuin != other.fuin)
			return false;
		if (recommendType != other.recommendType)
			return false;
		return true;
	}
	
}
