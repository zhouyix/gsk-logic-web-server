package com.gsk.server.global;

import com.gsk.server.properties.Properties;


/**
 * 存放文件配置信息或者全局变量配置信息
 */
public class Global {
	// 包头长度
	public static int PACK_HEARD_LENGTH = 64;
	// 包起始标识
	public static byte HEARD_START_TAG = 0x2;
	// 包起始标识
	public static byte HEARD_END_TAG = 0x3;
	//gsk server ip
	public static String GSK_SERVER_IP;
	//gsk server port
	public static int GSK_SERVER_PORT;
	//客户端uid
	public static int CLIENT_UIN;
	//消息头crc码
	public static int GSK_HEAD_CRC;
	
	static {
		Properties properties = Properties.getInstance();
		GSK_SERVER_IP = properties.getValue("gsk.tcp.server.ip", null);
		GSK_SERVER_PORT = properties.getIntValue("gsk.tcp.server.port");
		CLIENT_UIN = properties.getIntValue("tcp.client.uin");
		GSK_HEAD_CRC = properties.getIntValue("tcp.head.crc");
	}
}
