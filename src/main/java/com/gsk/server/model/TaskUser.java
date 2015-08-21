package com.gsk.server.model;

import java.io.Serializable;

public class TaskUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private int f_uin; // 用户id
	private String f_name = ""; // 昵称
	private String f_phone; // 手机号
	private int f_operate_status; //任务查看状态；0:默认,1:已查看
	private String f_job_type;
	private int f_join_time;

	public int getF_uin() {
		return f_uin;
	}

	public void setF_uin(int f_uin) {
		this.f_uin = f_uin;
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

	public int getF_operate_status() {
		return f_operate_status;
	}

	public void setF_operate_status(int f_operate_status) {
		this.f_operate_status = f_operate_status;
	}

	public String getF_job_type() {
		return f_job_type;
	}

	public void setF_job_type(String f_job_type) {
		this.f_job_type = f_job_type;
	}

	public int getF_join_time() {
		return f_join_time;
	}

	public void setF_join_time(int f_join_time) {
		this.f_join_time = f_join_time;
	}

}
