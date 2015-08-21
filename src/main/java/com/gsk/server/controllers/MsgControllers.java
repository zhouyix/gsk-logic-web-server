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

import com.gsk.server.service.MsgService;

@Controller
@RequestMapping("/msg")
public class MsgControllers {
	Logger log = LoggerFactory.getLogger(MsgControllers.class);
	
	@Resource(name="msgService")
	private MsgService msgService;
	
	/**
	 *离线消息
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "getOfflineMsg", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getOfflineMsg(@RequestBody String[] params) {
		Map<String, Object> map = msgService.getOfflineMsg(params);
		return map;
	}
	/**
	 * 发送消息
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "sendMsg", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> sendMsg(@RequestBody String[] params) {
		Map<String, Object> map = msgService.sendMsg(params);
		return map;
	}
	
}