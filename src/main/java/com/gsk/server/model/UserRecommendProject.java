package com.gsk.server.model;

import java.io.Serializable;

public class UserRecommendProject implements Serializable{
	private static final long serialVersionUID = 5L;
	private String f_prj_id;// pid

	private Integer f_type;
	
	private Integer f_weight;
	
	private String f_other_info;
	
	public UserRecommendProject(String f_prj_id, Integer f_type,
			Integer f_weight, String f_other_info) {
		super();
		this.f_prj_id = f_prj_id;
		this.f_type = f_type;
		this.f_weight = f_weight;
		this.f_other_info = f_other_info;
	}

	public String getF_prj_id() {
		return f_prj_id;
	}

	public void setF_prj_id(String f_prj_id) {
		this.f_prj_id = f_prj_id;
	}

	public Integer getF_type() {
		return f_type;
	}

	public void setF_type(Integer f_type) {
		this.f_type = f_type;
	}

	public Integer getF_weight() {
		return f_weight;
	}

	public void setF_weight(Integer f_weight) {
		this.f_weight = f_weight;
	}

	public String getF_other_info() {
		return f_other_info;
	}

	public void setF_other_info(String f_other_info) {
		this.f_other_info = f_other_info;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((f_prj_id == null) ? 0 : f_prj_id.hashCode());
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
		UserRecommendProject other = (UserRecommendProject) obj;
		if (f_prj_id == null) {
			if (other.f_prj_id != null)
				return false;
		} else if (!f_prj_id.equals(other.f_prj_id))
			return false;
		return true;
	}
}
