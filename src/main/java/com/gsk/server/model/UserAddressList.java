package com.gsk.server.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserAddressList  implements Serializable{
	private int fUin;
	
	private List<UserAddress> fUserAddressLlist;

	public int getfUin() {
		return fUin;
	}

	public void setfUin(Integer fUin) {
		this.fUin = fUin;
	}

	public List<UserAddress> getfUserAddressLlist() {
		return fUserAddressLlist;
	}

	public void setfUserAddressLlist(List<UserAddress> fUserAddressLlist) {
		this.fUserAddressLlist = fUserAddressLlist;
	}
	

	
	
}
