package com.gsk.server.controllers;

import java.util.HashMap;
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

import com.gsk.server.model.UserInfo;
import com.gsk.server.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createUser(@RequestBody String[] params) {
		Map<String, Object> map = new HashMap<String, Object>();
		map=userService.createUser(params);
		return map;
	}
	
	@RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getUserInfo(@RequestParam int uid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map=userService.getUserInfo(uid);
		return map;
	}
	
	@RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateUserInfo(@RequestBody String[] params) {
		Map<String, Object> map = new HashMap<String, Object>();
		map=userService.updateUserInfo(params);
		return map;
	}
	
	@RequestMapping(value = "uploadPhoneAddress", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> guploadUserPhoneAddress(@RequestBody String[] params) {
		Map<String, Object> map = new HashMap<String, Object>();
		map=userService.uploadPhoneAddress(params);
		return map;
	}
	
	@RequestMapping(value = "getAddressRecommend", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object>getUserAddressRecommend(@RequestParam int uid) {
		Map<String, Object> map = new HashMap<String, Object>();
		 map =userService.getAddressRecommend(uid);
		return map;
	}
	
	@RequestMapping(value = "getFriInfo", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getFriInfo(@RequestBody String[] params) {
		Map<String, Object> map = userService.getFriInfo(params);
		return map;
	}
	
	@RequestMapping(value = "getProRecommend", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getProRecommend(@RequestBody String[] params) {
		Map<String, Object> map = new HashMap<String, Object>();
		 map =userService.getProRecommend(params);
		return map;
	}
	
	@RequestMapping(value = "addFriend", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> addFriend(@RequestBody String[] params) {
		Map<String, Object> map = new HashMap<String, Object>();
		 map =userService.addFriend(params);
		return map;
	}
	
	@RequestMapping(value = "delFriend", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> delFriend(@RequestBody String[] params) {
		Map<String, Object> map = new HashMap<String, Object>();
		 map =userService.delFriend(params);
		return map;
	}
	
	@RequestMapping(value = "addFriendIsAgree", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> addFriendIsAgree(@RequestBody String[] params) {
		Map<String, Object> map = new HashMap<String, Object>();
		 map =userService.addFriendIsAgree(params);
		return map;
	}
	
	@RequestMapping(value = "searchFriend", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> searchFriend(@RequestBody String[] params) {
		Map<String, Object> map = new HashMap<String, Object>();
		 map =userService.searchFriend(params);
		return map;
	}
	
	@RequestMapping(value = "updateFriRemark", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateFriRemark(@RequestBody String[] params) {
		Map<String, Object> map = new HashMap<String, Object>();
		 map =userService.updateFriRemark(params);
		return map;
	}
	
	
	
	
}
