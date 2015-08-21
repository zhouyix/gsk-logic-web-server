package com.gsk.server.model;

import java.io.Serializable;
import java.util.List;

/**
 * 工作汇报
 */
public class TaskReport implements Serializable, Comparable<TaskReport> {
	private static final long serialVersionUID = 1L;

	private String f_report_id;
	private String f_title;
	private String f_content;
	private TaskUser f_reporter;
	private TaskUser f_reply_to;
	private List<Attachment> f_attach_list;
//	private Map<String, Object> f_reporter;
//	private List<Map<String, Object>> f_attach_list;
	private int f_content_type; // 汇报内容；1:文字,2:语音
	private int f_playtime;		//语音播放时长
	private int f_report_time;

	public String getF_report_id() {
		return f_report_id;
	}

	public void setF_report_id(String f_report_id) {
		this.f_report_id = f_report_id;
	}

	public String getF_title() {
		return f_title;
	}

	public void setF_title(String f_title) {
		this.f_title = f_title;
	}

	public String getF_content() {
		return f_content;
	}

	public void setF_content(String f_content) {
		this.f_content = f_content;
	}
	
//	public List<Map<String, Object>> getF_attach_list() {
//		return f_attach_list;
//	}
//
//	public void setF_attach_list(List<Map<String, Object>> f_attach_list) {
//		this.f_attach_list = f_attach_list;
//	}
//	
//	public Map<String, Object> getF_reporter() {
//		return f_reporter;
//	}
//
//	public void setF_reporter(Map<String, Object> f_reporter) {
//		this.f_reporter = f_reporter;
//	}
	
	public TaskUser getF_reporter() {
		return f_reporter;
	}

	public void setF_reporter(TaskUser f_reporter) {
		this.f_reporter = f_reporter;
	}

	public TaskUser getF_reply_to() {
		return f_reply_to;
	}

	public void setF_reply_to(TaskUser f_reply_to) {
		this.f_reply_to = f_reply_to;
	}

	public List<Attachment> getF_attach_list() {
		return f_attach_list;
	}

	public void setF_attach_list(List<Attachment> f_attach_list) {
		this.f_attach_list = f_attach_list;
	}

	public int getF_content_type() {
		return f_content_type;
	}

	public void setF_content_type(int f_content_type) {
		this.f_content_type = f_content_type;
	}

	public int getF_playtime() {
		return f_playtime;
	}

	public void setF_playtime(int f_playtime) {
		this.f_playtime = f_playtime;
	}

	public int getF_report_time() {
		return f_report_time;
	}

	public void setF_report_time(int f_report_time) {
		this.f_report_time = f_report_time;
	}

	public int compareTo(TaskReport report) {
//		return new Integer(this.getF_report_time()).compareTo(new Integer(report.getF_report_time()));
		return new Integer(report.getF_report_time()).compareTo(new Integer(this.getF_report_time()));
	}
}
