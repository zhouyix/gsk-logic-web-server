package com.gsk.server.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.gsk.server.protobuf.PbGskReq;
import com.gsk.server.protobuf.PbGskReq.PbReqReq;
import com.gsk.server.protobuf.PbGskReq.PbReqUser;
import com.gsk.server.protobuf.convert.PbReqReqCodec;
import com.gsk.server.service.ProjectService;
@Service("projectService")
public class ProjectServiceImpl implements ProjectService{
	Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	public Map<String,Object>  addProjectMem(String[] users) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		if(users.length < 3) {
			map.put("data", "输入数据个数有误");
			return map;
		}
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_ADD_MEMBER);
		List memList = new ArrayList<PbReqUser>();
		
		for(int i=2;i<users.length;i++)
		{
		PbGskReq.PbReqUser.Builder user=PbReqUser.newBuilder();
		if(users.length>8)
		  user.setPhone(users[i]);
		else
			user.setUin(Integer.parseInt(users[i]));
		
		memList.add(user.build());
		}
		builder.addSArgs(users[1]);//project id
		builder.addAllPrjMember(memList);
		
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_ADD_MEMBER);
		pack.setDwUin(Integer.parseInt(users[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("addProjectMem:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	public Map<String, Object> createProject(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		if(params.length > 29 || params.length <3) {
			map.put("data", "输入数据个数有误");
			return map;
		}
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_INFO_CREATE);
		
		PbGskReq.PbReqProject.Builder projectBuilder=PbGskReq.PbReqProject.newBuilder();
		for(int i=1;i<params.length-1;i=i+1)
		{
			int t=i+1;
			switch(params[i])
			{
			case "PrjName":
				projectBuilder.setPrjName(params[++i]);
				break;
			case "PrjType":
				projectBuilder.setPrjType(Integer.parseInt(params[t]));
				break;
			case "Province":
				projectBuilder.setProvince(params[t]);
				break;
			case "City":
				projectBuilder.setCity(params[t]);
				break;
			case "PrjAddress":
				projectBuilder.setPrjAddress(params[t]);
				break;
			case "Area":
				projectBuilder.setFloorArea(Integer.parseInt(params[t]));
				break;
			case "PrjBegin":
				projectBuilder.setPrjBegin(Integer.parseInt(params[t]));
				break;	
			case "PrjEnd":
				projectBuilder.setPrjEnd(Integer.parseInt(params[t]));
				break;
			case "JianzhuDanwei":
				projectBuilder.setJianzhuDanwei(params[t]);
				break;
			case "ShigongDanwei":
				projectBuilder.setShigongDanwei(params[t]);
				break;	
			case "JianliDanwei":
				projectBuilder.setJianliDanwei(params[t]);
				break;	
			case "FenbaoDanwei":
				projectBuilder.setFenbaoDanwei(params[t]);
				break;	
			case "Lat":
				projectBuilder.setLat(Double.parseDouble(params[t]));
				break;
			case "Lon":
				projectBuilder.setLon(Double.parseDouble(params[i+1]));
				break;
			}
		}
		
		
		builder.setProject(projectBuilder.build());
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_INFO_CREATE);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("createProject:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
		
	}

	
	//无handler
	public Map<String, Object> getProList(int uid) {
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_MY_LIST);
		
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_MY_LIST);
		pack.setDwUin(uid);
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getProList:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
		
	}

	public Map<String, Object> joinProject(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_JOIN);
		
		PbGskReq.PbReqUser.Builder userBuilder=PbReqUser.newBuilder();
		userBuilder.setUin(Integer.parseInt(params[0]));
		userBuilder.setJoinContent(params[2]);
		builder.addSArgs(params[1]);//项目id
		builder.addPrjMember(userBuilder.build());
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_JOIN);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("joinProject:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
		
	}

	
	//无handler
	public Map<String, Object> queryProject(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_QUERY);
		builder.addSArgs(params[1]);//project id
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_QUERY);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("queryProject:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
		
	}

	public Map<String, Object> getProDetail(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_DETAIL);
		builder.addSArgs(params[1]);
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_DETAIL);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getProDetail:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
		
	}

	public Map<String, Object> checkProMember(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_CHECK_MEMBER);
		builder.addSArgs(params[1]);//project id
		builder.addIArgs(Integer.parseInt(params[2]));//是否同意0不通过
		for(int i=3;i<params.length;i++)//users id
		{
		 PbReqUser.Builder userBuilder=PbReqUser.newBuilder();
		 userBuilder.setUin(Integer.parseInt(params[i]));
		 builder.addPrjMember(userBuilder.build());
		}
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_CHECK_MEMBER);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("checkProMember:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	public Map<String, Object> delProMember(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_DEL_MEMBER);
		List memList = new ArrayList<PbReqUser>();
		
		for(int i=2;i<params.length;i++)
		{
		PbGskReq.PbReqUser.Builder user=PbReqUser.newBuilder();
		user.setUin(Integer.parseInt((params[i])));
		memList.add(user.build());
		}
		builder.addSArgs(params[1]);//project id
		builder.addAllPrjMember(memList);
		
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_DEL_MEMBER);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("delProMember:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	public Map<String, Object> getAllProMember(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_ALL_MEMBER);
		builder.addSArgs(params[1]);//project id
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_ALL_MEMBER);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getAllProMember:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	public Map<String, Object> getProOverview(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_OVER_VIEW);
		builder.addSArgs(params[1]);//project id
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_OVER_VIEW);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getProOverview:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	public Map<String, Object> quitProject(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_QUIT);
		builder.addSArgs(params[1]);//project id
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_QUIT);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("quitProject:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	public Map<String, Object> getProInfo(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_INFO);
		builder.addSArgs(params[1]);//project id
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_INFO);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getProInfo:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	public Map<String, Object> getProWeather(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_WEATHER);
		builder.addSArgs(params[1]);//project id
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_WEATHER);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getProWeather:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	
	//f_pid是什么？？未测
	public Map<String, Object> uploadProFile(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_UPLOAD_FILE);
		
		PbGskReq.PbReqAttach.Builder fileBuilder=PbGskReq.PbReqAttach.newBuilder();
	    //project id,filename,filetype,fileurl,filesize,fileplaytime,f_pid
		builder.addSArgs(params[1]);//project id
		fileBuilder.setAttachName(params[2]);
		fileBuilder.setAttachType(Integer.parseInt(params[3]));
		fileBuilder.setAttachUrl(params[4]);
		fileBuilder.setAttachSize(Integer.parseInt(params[5]));
		fileBuilder.setAttachPlaytime(Integer.parseInt(params[6]));
		builder.addAttch(fileBuilder.build());
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_UPLOAD_FILE);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("uploadProFile:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	public Map<String, Object> getProFile(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_GET_FILE);
		builder.addSArgs(params[1]);//project id
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_GET_FILE);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getProFile:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	public Map<String, Object> editProInfo(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_PROJECT_INFO_EDIT);
		
		PbGskReq.PbReqProject.Builder projectBuilder=PbGskReq.PbReqProject.newBuilder();
		for(int i=2;i<params.length-1;i=i+2)
		{
			switch(params[i])
			{
			case "PrjName":
				projectBuilder.setPrjName(params[i+1]);
				break;
			case "PrjType":
				projectBuilder.setPrjType(Integer.parseInt(params[i+1]));
				break;
			case "Province":
				projectBuilder.setProvince(params[i+1]);
				break;
			case "City":
				projectBuilder.setCity(params[i+1]);
				break;
			case "PrjAddress":
				projectBuilder.setPrjAddress(params[i+1]);
				break;
			case "Area":
				projectBuilder.setFloorArea(Integer.parseInt(params[i+1]));
				break;
			case "PrjBegin":
				projectBuilder.setPrjBegin(Integer.parseInt(params[i+1]));
				break;	
			case "PrjEnd":
				projectBuilder.setPrjEnd(Integer.parseInt(params[i+1]));
				break;
			case "JianzhuDanwei":
				projectBuilder.setJianzhuDanwei(params[i+1]);
				break;
			case "ShigongDanwei":
				projectBuilder.setShigongDanwei(params[i+1]);
				break;	
			case "JianliDanwei":
				projectBuilder.setJianliDanwei(params[i+1]);
				break;	
			case "FenbaoDanwei":
				projectBuilder.setFenbaoDanwei(params[i+1]);
				break;	
			case "Lat":
				projectBuilder.setLat(Double.parseDouble(params[i+1]));
				break;
			case "Lon":
				projectBuilder.setLon(Double.parseDouble(params[i+1]));
				break;
			}
		}
		
		builder.setProject(projectBuilder.build());
		builder.addSArgs(params[1]);//project id
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_PROJECT_INFO_EDIT);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("editProInfo:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
		
	}
}
