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
import com.gsk.server.service.MsgService;
@Service("msgService")
public class MsgServiceImpl implements MsgService{
	Logger log = LoggerFactory.getLogger(MsgServiceImpl.class);
	public Map<String, Object> getOfflineMsg(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_IM_OFFLINE_MSG);
		builder.addIArgs(Integer.parseInt(params[1]));//seqId
		builder.addIArgs(Integer.parseInt(params[2]));//pagesize
		builder.addSArgs(params[3]);//groupid
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_IM_OFFLINE_MSG);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getOfflineMsg:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	public Map<String, Object> sendMsg(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_IM_SEND_MSG);
		builder.addIArgs(Integer.parseInt(params[1]));//msgType 1文本消息
		builder.addIArgs(Integer.parseInt(params[2]));//groupType 1单聊，2群聊，3项目群聊
		builder.addSArgs(params[3]);//groupId
		builder.addSArgs(params[4]);//msg body
		builder.addSArgs(params[5]);//msgId
		
		if(params[2]=="2")
			builder.addSArgs(params[6]);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_IM_SEND_MSG);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("sendMsg:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

}
