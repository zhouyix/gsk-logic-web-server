package com.gsk.server.service;

import java.util.Map;

public interface GroupService {
	/**
	 * 用户群组列表
	 * @param uid
	 * @return
	 */
	public Map<String, Object> listUserGroup(int uid);
	
	/**
	 * 创建群组
	 * @param uid
	 * @return
	 */
	public Map<String, Object> createGroup(String[] uids);
/**
 * 修改群组信息
 * @param params
 * @return
 */
	public Map<String, Object> editGroup(String[] params);
/**
 * 获取群组信息  sargs["uid","操作者uid","groupId",群id,"groupName","群名"]
 * @param uid
 * @param groupId 
 * @return
 */
public Map<String, Object> getGroup(String[] uids);

public Map<String, Object> inviteGroupUser(String[] params);
public Map<String, Object> deleteGroupUser(String[] params);
/**
 * 修改群组成员信息
 * 
 * 报文格式：sargs["uid","操作者uid","groupId",群id,"userRemark","用户群昵称","is_screen","0/1","is_remind","0/1"];
 * is_remind:是否提醒消息 0:不提醒,1:提醒，is_screen:是否屏蔽群消息 0:不,1:是
 */
public Map<String, Object> editGroupUser(String[] params);

}
