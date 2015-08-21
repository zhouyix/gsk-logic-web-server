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
import com.gsk.server.global.EnumManager;
import com.gsk.server.model.Task;
import com.gsk.server.model.TaskReport;
import com.gsk.server.model.TaskUser;
import com.gsk.server.net.TcpClient;
import com.gsk.server.protobuf.GSKPackage;
import com.gsk.server.protobuf.PbGsk.PbCltUser;
import com.gsk.server.protobuf.PbGskReq;
import com.gsk.server.protobuf.PbGskReq.PbReqReq;
import com.gsk.server.protobuf.PbGskReq.PbReqTask;
import com.gsk.server.protobuf.convert.PbReqReqCodec;
import com.gsk.server.service.TaskService;
@Service("taskService")
public class TaskServiceImpl implements TaskService {

	Logger log = LoggerFactory.getLogger(TaskService.class);
	@Override
	public Map<String, Object> createTask(Task task) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_TASK_CREATE);
		//创建任务
		PbGskReq.PbReqTask.Builder pbReqTaskBuilder =PbGskReq.PbReqTask.newBuilder();
		pbReqTaskBuilder.setTaskId(task.getF_task_id());
		pbReqTaskBuilder.setPrjId(task.getF_prj_id());
		//pbReqTaskBuilder.setTaskType(task.getF_task_type());//任务类型
		pbReqTaskBuilder.setTaskDesc(task.getF_task_desc());//任务描述
		pbReqTaskBuilder.setTaskDescType(EnumManager.TASK_DESC_TYPE.E_TASK_DESC_TYPE_TEXT.value);
		//pbReqTaskBuilder.setTaskBegin(task.getF_task_begin());
		//pbReqTaskBuilder.setTaskEnd(task.getF_task_end());
		pbReqTaskBuilder.setPosition(task.getF_position());
		//pbReqTaskBuilder.setTaskStatus(task.getF_task_status());//任务状态
		//创建者
		PbGskReq.PbReqUser.Builder pbReqUser = PbGskReq.PbReqUser.newBuilder();
		pbReqUser.setUin(task.getF_sponsor().getF_uin());
		pbReqUser.setName(task.getF_sponsor().getF_name());
		pbReqTaskBuilder.setSponsor(pbReqUser.build());
		//成员
		
		int length=task.getF_members().size();
		for(int i=0;i<length;i++)
		{
			PbGskReq.PbReqUser.Builder pbReqMemUser = PbGskReq.PbReqUser.newBuilder();
			pbReqMemUser.setUin(task.getF_members().get(i).getF_uin());
			pbReqMemUser.setName(task.getF_members().get(i).getF_name());
			pbReqTaskBuilder.addMembers(pbReqMemUser.build());
		}
		builder.setTask(pbReqTaskBuilder.build());
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_TASK_CREATE);
		pack.setDwUin(task.getF_sponsor().getF_uin());
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("createTask:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	@Override
	public Map<String, Object> listTask(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_TASK_LIST);
		//builder.addSArgs(params[0]);//uid
		//builder.addSArgs(params[1]);//project id
		//type:任务类型; 0:全部,1:未完成,2:延期,3:我的全部,4:我的未完成,5:我的延期
		for(int i=0;i<params.length;i++)
			builder.addSArgs(params[i]);
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_TASK_LIST);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("listTask:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
		
	}

	@Override
	
	public Map<String, Object> getTaskDetail(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_TASK_DETAIL);
		builder.addSArgs(params[0]);//uid
		builder.addSArgs(params[1]);//task id
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_TASK_DETAIL);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getTaskDetail:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
		
	}

	@Override
	public Map<String, Object> getReportList(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_TASK_REPORT_LIST);
		for(int i=0;i<params.length;i++)
		  builder.addSArgs(params[i]);
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_TASK_REPORT_LIST);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getReportList:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	@Override
	public Map<String, Object> getViewList(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_TASK_VIEW_LIST);
		for(int i=0;i<params.length;i++)
		  builder.addSArgs(params[i]);
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_TASK_VIEW_LIST);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getViewList:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	@Override
	public Map<String, Object> delTask(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_TASK_DEL);
		for(int i=0;i<params.length;i++)
		  builder.addSArgs(params[i]);
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_TASK_DEL);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("delTask:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	@Override
	//返回数据少
	public Map<String, Object> notifyTaskCheck(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_TASK_NOTIFY_CHECK);
		for(int i=0;i<params.length;i++)
		  builder.addSArgs(params[i]);
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_TASK_NOTIFY_CHECK);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("notifyTaskCheck:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	@Override
	//返回数据少
	public Map<String, Object> notifyTask(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_TASK_NOTIFY);
		for(int i=0;i<params.length;i++)
		  builder.addSArgs(params[i]);//uid,taskid,tasktype,receiverid
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_TASK_NOTIFY);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("notifyTaskCheck:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	@Override
	public Map<String, Object> getPosition(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_POSITION_LIST);
		for(int i=0;i<params.length;i++)
		  builder.addSArgs(params[i]);//uid,projectid
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_POSITION_LIST);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("getPosition:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	@Override
	public Map<String, Object> scheduledNotifyTask(String[] params) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_TASK_TIMER_CALL);
		
		  builder.addSArgs(params[1]);//taskid,tasktype
		  builder.addSArgs(params[2]);
		  
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_TASK_TIMER_CALL);
		pack.setDwUin(Integer.parseInt(params[0]));
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("scheduledNotifyTask:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		return map;
	}

	@Override
	public Map<String, Object> createTaskReport(Task task) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_TASK_REPORT_CREATE);
		//任务
		PbGskReq.PbReqTask.Builder pbReqTaskBuilder =PbGskReq.PbReqTask.newBuilder();
		pbReqTaskBuilder.setPrjId(task.getF_prj_id());
		pbReqTaskBuilder.setTaskId(task.getF_task_id());
		pbReqTaskBuilder.setTaskEnd(task.getF_task_end());
		//任务创建人
		PbGskReq.PbReqUser.Builder pbReqUser = PbGskReq.PbReqUser.newBuilder();
		pbReqUser.setUin(task.getF_sponsor().getF_uin());
		pbReqUser.setName(task.getF_sponsor().getF_name());
		pbReqTaskBuilder.setSponsor(pbReqUser.build());
		//项目成员
		//PbGskReq.PbReqUser.Builder pbReqMemUser = PbGskReq.PbReqUser.newBuilder();
		//pbReqTaskBuilder.addMembers(pbReqMemUser.build());
		//汇报
		
		PbGskReq.PbReqTaskReport.Builder pbReqReportBuilder = PbGskReq.PbReqTaskReport.newBuilder();
		pbReqReportBuilder.setTitle(task.getF_report_list().get(0).getF_title());
		pbReqReportBuilder.setContent(task.getF_report_list().get(0).getF_content());
		pbReqReportBuilder.setContentType(task.getF_report_list().get(0).getF_content_type());
		//汇报创建人
		PbGskReq.PbReqUser.Builder pbReqUser1 = PbGskReq.PbReqUser.newBuilder();
		pbReqUser1.setUin(task.getF_report_list().get(0).getF_reporter().getF_uin());
		pbReqUser1.setName(task.getF_report_list().get(0).getF_reporter().getF_name());
		pbReqReportBuilder.setSponsor(pbReqUser1.build());
		
		//汇报接收者
		PbGskReq.PbReqUser.Builder pbReqUser2 = PbGskReq.PbReqUser.newBuilder();
	    pbReqUser2.setUin(task.getF_report_list().get(0).getF_reply_to().getF_uin());
	    pbReqUser2.setName(task.getF_report_list().get(0).getF_reply_to().getF_name());
	    pbReqReportBuilder.setReplyTo(pbReqUser2);
		
		
		pbReqTaskBuilder.addReportList( pbReqReportBuilder.build());
		builder.setTask(pbReqTaskBuilder.build());
	   
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_TASK_REPORT_CREATE);
		pack.setDwUin(task.getF_report_list().get(0).getF_reporter().getF_uin());
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("createTaskReport:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}

	@Override
	public Map<String, Object> editTask(Task task) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		TcpClient client = TcpClient.getInstance();
		PbReqReq.Builder builder = PbReqReqCodec.getReqReqBuilder();
		builder.setCmd(CommandManager.CMD_TASK_EDIT);
	
		PbGskReq.PbReqTask.Builder pbReqTaskBuilder =PbGskReq.PbReqTask.newBuilder();
		pbReqTaskBuilder.setTaskId(task.getF_task_id());
		pbReqTaskBuilder.setPrjId(task.getF_prj_id());
		//pbReqTaskBuilder.setTaskType(task.getF_task_type());//任务类型
		pbReqTaskBuilder.setTaskDesc(task.getF_task_desc());//任务描述
		pbReqTaskBuilder.setTaskDescType(EnumManager.TASK_DESC_TYPE.E_TASK_DESC_TYPE_TEXT.value);
		pbReqTaskBuilder.setTaskBegin(task.getF_task_begin());
		pbReqTaskBuilder.setTaskEnd(task.getF_task_end());
		pbReqTaskBuilder.setPosition(task.getF_position());
		//pbReqTaskBuilder.setTaskStatus(task.getF_task_status());//任务状态
		//创建者
		PbGskReq.PbReqUser.Builder pbReqUser = PbGskReq.PbReqUser.newBuilder();
		pbReqUser.setUin(task.getF_sponsor().getF_uin());
		pbReqUser.setName(task.getF_sponsor().getF_name());
		pbReqTaskBuilder.setSponsor(pbReqUser.build());
		//成员
		
		int length=task.getF_members().size();
		for(int i=0;i<length;i++)
		{
			PbGskReq.PbReqUser.Builder pbReqMemUser = PbGskReq.PbReqUser.newBuilder();
			pbReqMemUser.setUin(task.getF_members().get(i).getF_uin());
			pbReqMemUser.setName(task.getF_members().get(i).getF_name());
			pbReqTaskBuilder.addMembers(pbReqMemUser.build());
		}
		
		builder.setTask(pbReqTaskBuilder.build());
		
		GSKPackage pack = new GSKPackage();
		pack.setwCommand((short)CommandManager.CMD_TASK_EDIT);
		pack.setDwUin(task.getF_sponsor().getF_uin());
		pack.setProtoBody(builder.build().toByteArray());
		GSKPackage b = client.send(pack);
		String json = "";
		try {
			PbCltUser user = PbCltUser.parseFrom(b.getProtoBody());
			json =JsonFormat.printToString(user);
		} catch (InvalidProtocolBufferException e) {
			log.error("editTask:", e);
		}
		map.put("data", json);
		map.put("result", b.getcResult());
		
		return map;
	}
	
	
}
