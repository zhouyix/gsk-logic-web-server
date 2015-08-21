package com.gsk.server.service;

import java.util.Map;

public interface MsgService {

	public Map<String, Object> getOfflineMsg(String[] params);

	public Map<String, Object> sendMsg(String[] params);

}
