package com.gsk.server.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsk.server.service.GroupService;


@Controller
@RequestMapping("/group")
public class GroupControllers {
	Logger log = LoggerFactory.getLogger(GroupControllers.class);
	
	@Resource(name="groupService")
	private GroupService groupService;
	
	/**
	 * 用户群组列表
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "listUserGroup", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> listUserGroup(@RequestParam int uid) {
		Map<String, Object> map = groupService.listUserGroup(uid);
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("data", "data");
		//map.put("result", 1);
		return map;
	}
	
	/**
	 * 群组创建
	 * @param uids
	 * @return
	 */
	
	@RequestMapping(value = "createGroup", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createGroup(@RequestBody String[] uids) {
		Map<String, Object> map = groupService.createGroup(uids);
		return map;
	}
	
	/**
	 * 修改群组信息 报文格式：sargs["uid","操作者uid","groupId",群id,"groupName","群名"]
	 * @param uids
	 * @return
	 */
	
	@RequestMapping(value = "editGroup", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> editGroup(@RequestBody String[] params) {
		Map<String, Object> map = groupService.editGroup(params);
		return map;
	}
	
	/**
	 * 获取群组信息  
	 * @param uids
	 * @return
	 */
	
	@RequestMapping(value = "getGroup", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getGroup(@RequestBody String[] uids) {
	
		//String[] uids={user.getUid(),user.getGroupId()};
		for(int i=0;i<uids.length;i++)
			System.out.println(uids[i]);
		Map<String, Object> map = groupService.getGroup(uids);
		return map;
	}
	
	/**邀请成员加入群组
	 * 报文格式：sargs["uid",groupId,"被添加者uid",......]
	 */
	@RequestMapping(value = "inviteGroupUser", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> inviteGroupUser(@RequestBody String[] params) {
		Map<String, Object> map = groupService.inviteGroupUser(params);
		
		return map;
	}
	@RequestMapping(value = "deleteGroupUser", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteGroupUser(@RequestBody String[] uids) {
		if(uids == null && uids.length < 3) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", -1);
			return map;
		}
		
		Map<String, Object> map = groupService.deleteGroupUser(uids);
		
		return map;
	}
	
	@RequestMapping(value = "editGroupUser", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> editGroupUser(@RequestBody String[] params ){
			//String[] params={request.getUid(),request.getGroupId()};
			//System.out.println("输出接收值");
		//	for(int i=0;i<params.length;i++)
			//	System.out.println(params[i]);
		Map<String, Object>  map = groupService.editGroupUser(params);
			 return map;
		
	
	}
}
