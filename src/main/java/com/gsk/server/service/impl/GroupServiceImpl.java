package com.gsk.server.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.googlecode.protobuf.format.JsonFormat;
import com.gsk.server.global.CommandManager;
import com.gsk.server.net.TcpClient;
import com.gsk.server.protobuf.GSKPackage;
import com.gsk.server.protobuf.PbGsk.PbCltUser;
import com.gsk.server.protobuf.PbGskReq.PbReqReq;
import com.gsk.server.protobuf.convert.PbReqReqCodec;
import com.gsk.server.service.GroupService;

@Service("groupService")
public class GroupServiceImpl implements GroupService {
	Logger log = LoggerFactory.getLogger(GroupServiceImpl.class);
	
	/**
	 * 用户群组列表
	 * @throws Exception 
	 */
	public Map<String, Object> listUserGroup(int uid) {
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_IM_GROUP_LIST);
		builder.addIArgs(uid);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_IM_GROUP_LIST);
		pack.setDwUin(uid);
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("listUserGroup:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}
	
	/**
	 * 创建群组
	 */
	public Map<String, Object> createGroup(String[] uids) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(uids.length < 2) {
			map.put("data", "创建群组至少输两个id号");
			return map;
		}
		
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_IM_GROUP_CREATE);
		for(String uid : uids) {
			builder.addIArgs(Integer.parseInt(uid));
		}
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_IM_GROUP_CREATE);
		pack.setDwUin(Integer.parseInt(uids[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("createGroup:", e);
		}
		
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}
/**
 * 报文格式：sargs["uid","操作者uid","groupId",群id,"groupName","群名"]
 */
	public Map<String, Object> editGroup(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_IM_GROUP_EDIT);
		builder.addSArgs("uid");
		builder.addSArgs(params[0]);
		builder.addSArgs("groupId");
		builder.addSArgs(params[1]);
		builder.addSArgs("groupName");
		builder.addSArgs(params[2]);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_IM_GROUP_EDIT);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("editGroup:", e);
		}
		
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}
/**
 * 获取群组信息
 */
	public Map<String, Object> getGroup(String[] uids) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_IM_GROUP_GET);
	    builder.addSArgs(uids[1]);//group id
	
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_IM_GROUP_GET);
		pack.setDwUin(Integer.parseInt(uids[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("GetGroup:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}
	
	
	/**邀请成员加入群组
	 * 报文格式：sargs["uid",groupId,"被添加者uid",......]
	 */
public Map<String, Object> inviteGroupUser(String[] params) {
	// TODO Auto-generated method stub
	Map<String, Object> map = new HashMap<String, Object>();
	if(params.length < 3) {
		map.put("data", "输入数据个数有误");
		return map;
	}
	TcpClient client = TcpClient.getInstance();
	PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
	builder.setCmd(CommandManager.CMD_IM_GROUP_USER_INVITE);
	for(String param : params) {
		builder.addSArgs(param);
	}
	
	GSKPackage pack = new GSKPackage();
	pack.setwCommand((short)CommandManager.CMD_IM_GROUP_USER_INVITE);
	pack.setDwUin(Integer.parseInt(params[0]));
	pack.setProtoBody(builder.build().toByteArray());
	GSKPackage b = client.send(pack);
	String json = "";
	try {
		PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
		json =JsonFormat.printToString(user);
	} catch (InvalidProtocolBufferException e) {
		log.error("GetGroup:", e);
	}
	map.put("data", json);
	map.put("result", b.getcResult());
	
	return map;
}

	public Map<String, Object> deleteGroupUser(String[] params) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_IM_GROUP_USER_DEL);
		int uid = Integer.parseInt(params[0]);//group id
		for(String param : params) {
			builder.addSArgs(param);
		}
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_IM_GROUP_USER_DEL);
		pack.setDwUin(uid);
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("deleteGroupUser:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	public Map<String, Object> editGroupUser(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_IM_GROUP_USER_EDIT);
		builder.addSArgs("uid");
		builder.addSArgs(params[0]);
		builder.addSArgs("groupId");
		builder.addSArgs(params[1]);
		builder.addSArgs(params[2]);//userRemark,is_screen,is_remind
		builder.addSArgs(params[3]);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_IM_GROUP_USER_EDIT);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("editGroupUser:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}
	
}
