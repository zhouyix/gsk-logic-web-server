package com.gsk.server.controllers;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsk.server.model.Task;
import com.gsk.server.model.TaskReport;
import com.gsk.server.service.ProjectService;
import com.gsk.server.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskControllers {
	
Logger log = LoggerFactory.getLogger(TaskControllers.class);
	
	@Resource(name="taskService")
	private TaskService taskService;
	
	
	@RequestMapping(value = "createTask", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createTask(@RequestBody Task task) {
		System.out.println(task.getF_sponsor());
		System.out.println(task.getF_members());
		Map<String, Object> map = taskService.createTask(task);
		return map;
	}
	
	@RequestMapping(value = "listTask", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> listTask(@RequestBody String[] params) {
		Map<String, Object> map = taskService.listTask(params);
		return map;
	}
	
	@RequestMapping(value = "getTaskDetail", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getTaskDetail(@RequestBody String[] params) {
		Map<String, Object> map = taskService.getTaskDetail(params);
		return map;
	}
	
	@RequestMapping(value = "getReportList", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getReportList(@RequestBody String[] params) {
		Map<String, Object> map = taskService.getReportList(params);
		return map;
	}


	@RequestMapping(value = "getViewList", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getViewList(@RequestBody String[] params) {
		Map<String, Object> map = taskService.getViewList(params);
		return map;
	}
	
	@RequestMapping(value = "delTask", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delTask(@RequestBody String[] params) {
		Map<String, Object> map = taskService.delTask(params);
		return map;
	}

	@RequestMapping(value = "notifyTaskCheck", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> notifyTaskCheck(@RequestBody String[] params) {
		Map<String, Object> map = taskService.notifyTaskCheck(params);
		return map;
	}
	
	@RequestMapping(value = "notifyTask", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> notifyTask(@RequestBody String[] params) {
		Map<String, Object> map = taskService.notifyTask(params);
		return map;
	}

	@RequestMapping(value = "getPosition", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getPosition(@RequestBody String[] params) {
		Map<String, Object> map = taskService.getPosition(params);
		return map;
	}
	
	@RequestMapping(value = "scheduledNotifyTask", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> scheduledNotifyTask(@RequestBody String[] params) {
		Map<String, Object> map = taskService.scheduledNotifyTask(params);
		return map;
	}
	
	@RequestMapping(value = "createTaskReport", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createTaskReport(@RequestBody Task task) {
		Map<String, Object> map = taskService.createTaskReport(task);
		return map;
	}
	
	@RequestMapping(value = "editTask", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> editTask(@RequestBody Task task) {
		Map<String, Object> map = taskService.editTask(task);
		return map;
	}
}