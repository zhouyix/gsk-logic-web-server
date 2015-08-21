package com.gsk.server.model;

import java.io.Serializable;

/**
 * 查看记录
 */
public class ViewRecord implements Serializable, Comparable<ViewRecord> {
	private static final long serialVersionUID = 1L;

	private int f_uin;
	private String f_user_name;
	private String f_user_avatar;
	private int f_time;

	public int getF_uin() {
		return f_uin;
	}

	public void setF_uin(int f_uin) {
		this.f_uin = f_uin;
	}

	public String getF_user_name() {
		return f_user_name;
	}

	public void setF_user_name(String f_user_name) {
		this.f_user_name = f_user_name;
	}

	public String getF_user_avatar() {
		return f_user_avatar;
	}

	public void setF_user_avatar(String f_user_avatar) {
		this.f_user_avatar = f_user_avatar;
	}

	public int getF_time() {
		return f_time;
	}

	public void setF_time(int f_time) {
		this.f_time = f_time;
	}

	public int compareTo(ViewRecord view) {
		return new Integer(view.getF_time()).compareTo(new Integer(this.getF_time()));
	}
}
