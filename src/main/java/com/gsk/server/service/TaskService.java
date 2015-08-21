package com.gsk.server.service;

import java.util.Map;

import com.gsk.server.model.Task;
import com.gsk.server.model.TaskReport;

public interface TaskService {
	public Map<String,Object> createTask(Task task);

	public Map<String, Object> listTask(String[] params);

	public Map<String, Object> getTaskDetail(String[] params);

	public Map<String, Object> getReportList(String[] params);

	public Map<String, Object> getViewList(String[] params);

	public Map<String, Object> delTask(String[] params);

	public Map<String, Object> notifyTaskCheck(String[] params);

	public Map<String, Object> notifyTask(String[] params);

	public Map<String, Object> getPosition(String[] params);

	public Map<String, Object> scheduledNotifyTask(String[] params);

	public Map<String, Object> createTaskReport(Task task);

	public Map<String, Object> editTask(Task task);
}
