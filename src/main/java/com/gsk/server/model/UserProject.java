package com.gsk.server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserProject implements Serializable{
	private static final long serialVersionUID = 4L;
	private String f_prj_id;// 冗余用户昵称

	private Integer f_add_time;
	
	private String f_job_type;
	
	private List<String> f_owner_create_task;
	
	private List<String> f_owner_work_task;
	
	public UserProject(String f_prj_id, Integer f_add_time, String f_job_type) {
		super();
		this.f_prj_id = f_prj_id;
		this.f_add_time = f_add_time;
		this.f_job_type = f_job_type;
		f_owner_create_task = new ArrayList<String>();
		f_owner_work_task = new ArrayList<String>();
	}

	public String getF_prj_id() {
		return f_prj_id;
	}

	public void setF_prj_id(String f_prj_id) {
		this.f_prj_id = f_prj_id;
	}

	public Integer getF_add_time() {
		return f_add_time;
	}

	public void setF_add_time(Integer f_add_time) {
		this.f_add_time = f_add_time;
	}

	public String getF_job_type() {
		return f_job_type;
	}

	public void setF_job_type(String f_job_type) {
		this.f_job_type = f_job_type;
	}

	public List<String> getF_owner_create_task() {
		return f_owner_create_task;
	}

	public void setF_owner_create_task(List<String> f_owner_create_task) {
		this.f_owner_create_task = f_owner_create_task;
	}

	public List<String> getF_owner_work_task() {
		return f_owner_work_task;
	}

	public void setF_owner_work_task(List<String> f_owner_work_task) {
		this.f_owner_work_task = f_owner_work_task;
	}

	//发起者type为2 接受者type为1
	public boolean addOwnerTask(String taskid,int type) {
		if (type == 1) {
			if (f_owner_work_task == null)
				f_owner_work_task = new ArrayList<String>();
			if (!f_owner_work_task.contains(taskid)) {
				f_owner_work_task.add(taskid);
				return true;
			}
		}
		else if (type == 2){
			if (f_owner_create_task == null)
				f_owner_create_task = new ArrayList<String>();
			if (!f_owner_create_task.contains(taskid)) {
				f_owner_create_task.add(taskid);
				return true;
			}
		}
		return false;
	}
	//发起者type为2 接受者type为1
	public boolean delOwnerTask(String taskid,int type) {
		if (type == 1) {
			if (f_owner_work_task == null) {
				f_owner_work_task = new ArrayList<String>();
				return true;
			}
			if (!f_owner_work_task.contains(taskid)) {
				f_owner_work_task.remove(taskid);
				return true;
			}
		}
		else if (type == 2){
			if (f_owner_create_task == null) {
				f_owner_create_task = new ArrayList<String>();
				return true;
			}
			if (!f_owner_create_task.contains(taskid)) {
				f_owner_create_task.remove(taskid);
				return true;
			}
		}
		return false;
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
		UserProject other = (UserProject) obj;
		if (f_prj_id == null) {
			if (other.f_prj_id != null)
				return false;
		} else if (!f_prj_id.equals(other.f_prj_id))
			return false;
		return true;
	}
}
