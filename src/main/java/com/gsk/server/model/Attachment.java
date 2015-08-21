package com.gsk.server.model;

import java.io.Serializable;

/**
 * 附件
 */
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;

	private String f_attach_name;
	private int f_attach_type;
	private String f_attach_url;
	private int f_attach_size;
	private int f_attach_playtime;
	private int f_attach_uploadtime;
	
	public Attachment() {
		
	}
	
	public Attachment(String f_attach_name,int f_attach_type, String f_attach_url, 
			int f_attach_size, int f_attach_playtime,int f_attach_uploadtime) {
		this.f_attach_name = f_attach_name;
		this.f_attach_type = f_attach_type;
		this.f_attach_url = f_attach_url;
		this.f_attach_size = f_attach_size;
		this.f_attach_playtime = f_attach_playtime;
		this.f_attach_uploadtime = f_attach_uploadtime;
	}
	
	public String getF_attach_name() {
		return f_attach_name;
	}

	public void setF_attach_name(String f_attach_name) {
		this.f_attach_name = f_attach_name;
	}

	public int getF_attach_type() {
		return f_attach_type;
	}

	public void setF_attach_type(int f_attach_type) {
		this.f_attach_type = f_attach_type;
	}

	public String getF_attach_url() {
		return f_attach_url;
	}

	public void setF_attach_url(String f_attach_url) {
		this.f_attach_url = f_attach_url;
	}

	public int getF_attach_size() {
		return f_attach_size;
	}

	public void setF_attach_size(int f_attach_size) {
		this.f_attach_size = f_attach_size;
	}

	public int getF_attach_playtime() {
		return f_attach_playtime;
	}

	public void setF_attach_playtime(int f_attach_playtime) {
		this.f_attach_playtime = f_attach_playtime;
	}

	public int getF_attach_uploadtime() {
		return f_attach_uploadtime;
	}

	public void setF_attach_uploadtime(int f_attach_uploadtime) {
		this.f_attach_uploadtime = f_attach_uploadtime;
	}
}
