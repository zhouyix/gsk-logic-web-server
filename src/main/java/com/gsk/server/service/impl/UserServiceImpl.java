package com.gsk.server.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.googlecode.protobuf.format.JsonFormat;
import com.gsk.server.global.CommandManager;
import com.gsk.server.model.UserInfo;
import com.gsk.server.net.TcpClient;
import com.gsk.server.protobuf.GSKPackage;
import com.gsk.server.protobuf.PbGsk.PbCltUser;
import com.gsk.server.protobuf.PbGskReq.PbReqReq;
import com.gsk.server.protobuf.convert.PbReqReqCodec;
import com.gsk.server.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	public Map<String, Object> createUser(String[] params) {
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_USER_CREATE);
		builder.addSArgs("fUin");
		builder.addSArgs(params[0]);
		builder.addSArgs("fphone");
		builder.addSArgs(params[1]);
		builder.addSArgs("fProvince");
		builder.addSArgs(params[2]);
		builder.addSArgs("fCity");
		builder.addSArgs(params[3]);
		builder.addSArgs("fCompany");
		builder.addSArgs(params[4]);
		builder.addSArgs("fCompanyType");
		builder.addSArgs(params[5]);
		builder.addSArgs("fYearsOfWorking");
		builder.addSArgs(params[6]);
		builder.addSArgs("fJobTitle");
		builder.addSArgs(params[7]);
		builder.addSArgs("fJobType");
		builder.addSArgs(params[8]);
		
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_USER_CREATE);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("createUser:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
		
	}

	public Map<String, Object> getUserInfo(int uid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_USER_INFO);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_USER_INFO);
		pack.setDwUin(uid);
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getUserInfo:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
		
	}

	public Map<String,Object>updateUserInfo(String[] params) {
		// TODO Auto-generated method stub\
		//第一个为uid，后面是修改项和修改值
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_USER_UPDATE_INFO);
		for(int i=1;i<params.length-1;i++)
		{
			switch(params[i])
			{
			case "fProvince":
				builder.addSArgs("fProvince");
				builder.addSArgs(params[i+1]);
				break;
			case "fCity":
				builder.addSArgs("fCity");
				builder.addSArgs(params[i+1]);
				break;
			case "fPhone":
				builder.addSArgs("fPhone");
				builder.addSArgs(params[i+1]);
				break;
			case "fName":
				builder.addSArgs("fName");
				builder.addSArgs(params[i+1]);
				break;
			case "fCompanyType":
				builder.addSArgs("fCompanyType");
				builder.addSArgs(params[i+1]);
				break;
			case "fCompany":
				builder.addSArgs("fCompany");
				builder.addSArgs(params[i+1]);
				break;
			case "fYearsOfWorking":
				builder.addSArgs("fYearsOfWorking");
				builder.addSArgs(params[i+1]);
				break;
			case "fJobType":
				builder.addSArgs("fJobType");
				builder.addSArgs(params[i+1]);
				break;
			case "fJobTitle":
				builder.addSArgs("fJobTitle");
				builder.addSArgs(params[i+1]);
				break;
			}
		}
		
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_USER_UPDATE_INFO);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
			
		} catch (InvalidProtocolBufferException e) {
			log.error("updateUserInfo:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	@Override
	public Map<String,Object> uploadPhoneAddress(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_USER_UPLOAD_PHONE_ADDRESS);
		builder.addSArgs("fphone");
		builder.addSArgs(params[1]);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_USER_UPLOAD_PHONE_ADDRESS);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("uploadPhoneAddress:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	@Override
	public Map<String, Object> getAddressRecommend(int uid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_USER_ADDRESS_RECOMMEND);
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_USER_ADDRESS_RECOMMEND);
		pack.setDwUin(uid);
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getAddressRecommend:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	@Override
	public Map<String, Object> getFriInfo(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_USER_FRIEND_INFO);
		builder.addSArgs("friendId");
		builder.addSArgs(params[1]);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_USER_FRIEND_INFO);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
			//log.info(json);
			
		} catch (InvalidProtocolBufferException e) {
			log.error("getFriInfo:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	@Override
	public  Map<String, Object>  getProRecommend(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_USER_REMMEND_PROJECT);
		builder.addSArgs("page");
		builder.addSArgs(params[1]);
		builder.addSArgs("pagesize");
		builder.addSArgs(params[2]);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_USER_REMMEND_PROJECT);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getProRecommend:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	@Override
	public Map<String, Object>  addFriend(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_USER_FRIEND_ADD);
		builder.addSArgs("friendId");
		builder.addSArgs(params[1]);
		builder.addSArgs("message");
		builder.addSArgs(params[2]);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_USER_FRIEND_ADD);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("addFriend:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	@Override
	public Map<String, Object>  delFriend(String[] params) {
		
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_USER_FRIEND_DEL);
		builder.addSArgs("friendId");
		builder.addSArgs(params[1]);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_USER_FRIEND_DEL);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("delFriend:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}


	@Override
	public Map<String, Object> addFriendIsAgree(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_USER_FRIEND_YES_NO);
		builder.addSArgs("flag");
		builder.addSArgs(params[1]);
		builder.addSArgs("friendId");
		builder.addSArgs(params[2]);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_USER_FRIEND_YES_NO);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("addFriendIsAgree:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	@Override
	public Map<String, Object> searchFriend(String[] params) {
		// TODO Auto-generated method stub
				Map<String, Object> map = new HashMap<String, Object>();
				TcpClient client = TcpClient.getInstance();
				PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
				builder.setCmd(CommandManager.CMD_USER_FRIEND_SEARCH);
				builder.addSArgs("phone");
				builder.addSArgs(params[1]);
				GSKPackage pack = new GSKPackage();
				pack.setwCommand((short)CommandManager.CMD_USER_FRIEND_SEARCH);
				pack.setDwUin(Integer.parseInt(params[0]));
				pack.setProtoBody(builder.build().toByteArray());
				GSKPackage b = client.send(pack);
				String json = "";
				try {
					PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
					json =JsonFormat.printToString(user);
				} catch (InvalidProtocolBufferException e) {
					log.error("searchFriend:", e);
				}
				map.put("data", json);
				map.put("result", b.getcResult());
				
				return map;
		
	}

	@Override
	public Map<String, Object> updateFriRemark(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_USER_FRIEND_REMARK_UPDATE);
		builder.addSArgs("friendId");
		builder.addSArgs(params[1]);
		builder.addSArgs("remark");
		builder.addSArgs(params[2]);
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_USER_FRIEND_REMARK_UPDATE);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("updateFriRemark:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}




	
}
