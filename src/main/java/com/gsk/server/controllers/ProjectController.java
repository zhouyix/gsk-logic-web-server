package com.gsk.server.controllers;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsk.server.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
Logger log = LoggerFactory.getLogger(GroupControllers.class);
	
	@Resource(name="projectService")
	private ProjectService projectService;
	
	
	@RequestMapping(value = "addProjectMem", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> addProjectMem(@RequestBody String[] users) {
		Map<String, Object> map = projectService.addProjectMem(users);
		return map;
	}
	
	@RequestMapping(value = "createProject", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createProject(@RequestBody String[] params) {
		Map<String, Object> map = projectService.createProject(params);
		return map;
	}
	
	@RequestMapping(value = "getProList", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> createProject(@RequestParam int uid) {
		Map<String, Object> map = projectService.getProList(uid);
		return map;
	}
	
	@RequestMapping(value = "joinProject", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> joinProject(@RequestBody String[] params) {
		Map<String, Object> map = projectService.joinProject(params);
		return map;
	}
	
	@RequestMapping(value = "queryProject", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> queryProject(@RequestBody String[] params) {
		Map<String, Object> map = projectService.queryProject(params);
		return map;
	}
	
	@RequestMapping(value = "getProDetail", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getProDetail(@RequestBody String[] params) {
		Map<String, Object> map = projectService.getProDetail(params);
		return map;
	}
	
	@RequestMapping(value = "checkProMember", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> checkProMember(@RequestBody String[] params) {
		Map<String, Object> map = projectService.checkProMember(params);
		return map;
	}
	
	@RequestMapping(value = "delProMember", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delProMember(@RequestBody String[] params) {
		Map<String, Object> map = projectService.delProMember(params);
		return map;
	}
	
	@RequestMapping(value = "getAllProMember", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAllProMember(@RequestBody String[] params) {
		Map<String, Object> map = projectService.getAllProMember(params);
		return map;
	}
	
	@RequestMapping(value = "getProOverview", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getProOverview(@RequestBody String[] params) {
		Map<String, Object> map = projectService.getProOverview(params);
		return map;
	}
	
	@RequestMapping(value = "quitProject", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> quitProject(@RequestBody String[] params) {
		Map<String, Object> map = projectService.quitProject(params);
		return map;
	}
	
	@RequestMapping(value = "getProInfo", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getProInfo(@RequestBody String[] params) {
		Map<String, Object> map = projectService.getProInfo(params);
		return map;
	}
	
	@RequestMapping(value = "getProWeather", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getProWeather(@RequestBody String[] params) {
		Map<String, Object> map = projectService.getProWeather(params);
		return map;
	}
	

	@RequestMapping(value = "uploadProFile", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> uploadProFile(@RequestBody String[] params) {
		Map<String, Object> map = projectService.uploadProFile(params);
		return map;
	}
	
	@RequestMapping(value = "getProFile", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getProFile(@RequestBody String[] params) {
		Map<String, Object> map = projectService.getProFile(params);
		return map;
	}
	
	@RequestMapping(value = "editProInfo", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> editProInfo(@RequestBody String[] params) {
		Map<String, Object> map = projectService.editProInfo(params);
		return map;
	}
}
