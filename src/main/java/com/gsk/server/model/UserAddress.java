package com.gsk.server.model;

import java.io.Serializable;

public class UserAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	
	private String f_name;//好友名称
	
	private String f_phone ;//好友电话
	
	public UserAddress(String f_name, String f_phone) {
		super();
		this.f_name = f_name;
		this.f_phone = f_phone;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_phone() {
		return f_phone;
	}

	public void setF_phone(String f_phone) {
		this.f_phone = f_phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f_phone == null) ? 0 : f_phone.hashCode());
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
		UserAddress other = (UserAddress) obj;
		if (f_phone == null) {
			if (other.f_phone != null)
				return false;
		} else if (!f_phone.equals(other.f_phone))
			return false;
		return true;
	}

}
