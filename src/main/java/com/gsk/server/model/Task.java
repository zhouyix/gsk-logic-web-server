package com.gsk.server.model;

import java.io.Serializable;
import java.util.List;

/**
 * 任务
 */
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String f_task_id;
	
	private String f_prj_id;
	
	private int f_task_type;
	
	private String f_task_desc;
	
	private int f_task_desc_type;			//任务描述分类；1:文字,2:语音
	
	private int f_playtime;					//语音播放时长
	
	private TaskUser f_sponsor;  //发起人
	
	private List<TaskUser> f_members;//任务接收者
	
	private int f_task_status;				//完成状态，默认0,1:完成
	
	private String f_position;
	
	private List<Attachment> f_attach_list;
	
	private int f_task_begin;
	
	private int f_task_end;
	
	private List<TaskReport> f_report_list;
	
	private List<ViewRecord> f_view_list;

	public String getF_task_id() {
		return f_task_id;
	}

	public void setF_task_id(String f_task_id) {
		this.f_task_id = f_task_id;
	}

	public String getF_prj_id() {
		return f_prj_id;
	}

	public void setF_prj_id(String f_prj_id) {
		this.f_prj_id = f_prj_id;
	}

	public int getF_task_type() {
		return f_task_type;
	}

	public void setF_task_type(int f_task_type) {
		this.f_task_type = f_task_type;
	}

	public String getF_task_desc() {
		return f_task_desc;
	}

	public void setF_task_desc(String f_task_desc) {
		this.f_task_desc = f_task_desc;
	}

	public int getF_task_desc_type() {
		return f_task_desc_type;
	}

	public void setF_task_desc_type(int f_task_desc_type) {
		this.f_task_desc_type = f_task_desc_type;
	}

	public int getF_playtime() {
		return f_playtime;
	}

	public void setF_playtime(int f_playtime) {
		this.f_playtime = f_playtime;
	}

	public TaskUser getF_sponsor() {
		return f_sponsor;
	}

	public void setF_sponsor(TaskUser f_sponsor) {
		this.f_sponsor = f_sponsor;
	}

	public List<TaskUser> getF_members() {
		return f_members;
	}

	public void setF_members(List<TaskUser> f_members) {
		this.f_members = f_members;
	}

	public int getF_task_status() {
		return f_task_status;
	}

	public void setF_task_status(int f_task_status) {
		this.f_task_status = f_task_status;
	}

	public String getF_position() {
		if(f_position == null) {
			return "";
		}
		return f_position;
	}

	public void setF_position(String f_position) {
		this.f_position = f_position;
	}

	public List<Attachment> getF_attach_list() {
		return f_attach_list;
	}

	public void setF_attach_list(List<Attachment> f_attach_list) {
		this.f_attach_list = f_attach_list;
	}

	public int getF_task_begin() {
		return f_task_begin;
	}

	public void setF_task_begin(int f_task_begin) {
		this.f_task_begin = f_task_begin;
	}

	public int getF_task_end() {
		return f_task_end;
	}

	public void setF_task_end(int f_task_end) {
		this.f_task_end = f_task_end;
	}

	public List<TaskReport> getF_report_list() {
		return f_report_list;
	}

	public void setF_report_list(List<TaskReport> f_report_list) {
		this.f_report_list = f_report_list;
	}

	public List<ViewRecord> getF_view_list() {
		return f_view_list;
	}

	public void setF_view_list(List<ViewRecord> f_view_list) {
		this.f_view_list = f_view_list;
	}
}
