package com.gsk.server.model;

import java.io.Serializable;

public class UserGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private String f_group_id;// 冗余用户昵称

	private int f_is_remind;
	
	private int f_is_screen;

	private String f_remark;
	
	private int f_init_seqid;
	
	private int f_read_seqid;
	public UserGroup(String f_group_id, int f_is_remind,int f_is_screen,String f_remark,
			int f_init_seqid,int f_read_seqid) {
		super();
		this.f_group_id = f_group_id;
		this.f_is_remind = f_is_remind;
		this.f_is_screen = f_is_screen;
		this.f_remark = f_remark;
		this.f_init_seqid = f_init_seqid;
		this.f_read_seqid = f_read_seqid;
	}

	public String getF_group_id() {
		return f_group_id;
	}

	public void setF_group_id(String f_group_id) {
		this.f_group_id = f_group_id;
	}
	
	public int getF_is_remind() {
		return f_is_remind;
	}

	public void setF_is_remind(int f_is_remind) {
		this.f_is_remind = f_is_remind;
	}

	public int getF_is_screen() {
		return f_is_screen;
	}

	public void setF_is_screen(int f_is_screen) {
		this.f_is_screen = f_is_screen;
	}

	public String getF_remark() {
		return f_remark;
	}

	public void setF_remark(String f_remark) {
		this.f_remark = f_remark;
	}

	public int getF_init_seqid() {
		
		return f_init_seqid;
	}

	public void setF_init_seqid(int f_init_seqid) {
		this.f_init_seqid = f_init_seqid;
	}

	public int getF_read_seqid() {
		return f_read_seqid;
	}

	public void setF_read_seqid(int f_read_seqid) {
		this.f_read_seqid = f_read_seqid;
	}

	
	

}
