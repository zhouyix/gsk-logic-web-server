package com.gsk.server.manager;

/**
 * 常量管理器
 * 
 * @author yongshengzhao@vip.qq.com
 * 
 */
public class ConstantManager {
	// =============================Pkg===========================================
	public final static byte	STX									= 0x2;
	public final static byte	ETX									= 0x3;
	
	public final static int		GSK_PKG_HEADER_SIZE					= 64;
	public final static int		GSK_PKG_MIN_SIZE					= 66;
	
	// =============================用户信息===========================================
	public final static int		USER_INFO_BASEINFO					= 0x0001;
	public final static int		USER_INFO_FRIEND_LIST				= 0x0002;
	public final static int		USER_INFO_VALIDATION_FRIEND_LIST	= 0x0004;
	public final static int		USER_INFO_RECOMMEND_FRIEND_LIST		= 0x0008;
	public final static int		USER_INFO_IM_GROUP_LIST				= 0x0010;
	public final static int		USER_FRIEND_BASEINFO				= 0x0020;
	public final static int		USER_INFO_PROJECT_LIST				= 0x0040;
	public final static int		USER_INFO_RECOMMEND_PROJECT_LIST	= 0x0080;
	
	// =============================process ret===========================================
	public final static int		RSP_PKG_TO_CLT						= 100;
	public final static int		RSP_PKG_TO_CLT_AND_SAVE_USERDATA	= 101;
	
	// =============================日志===========================================
	public final static String	LOG_SEPARATE						= " - ";									// 日志分隔符
	public final static String	LOG_SEPARATE_PARAMS					= "|";										// 日志参数分隔符
																												
	public final static String	SERVER_INFO							= "server_info" + LOG_SEPARATE;			// 服务器信息
	public final static String	CLIENT_SERVER_INFO					= "client_server_info" + LOG_SEPARATE;		// 客户端服务器信息
	public final static String	CLIENT_CONNECTED					= "client_connected" + LOG_SEPARATE;		// 客户端建立连接
	public final static String	CLIENT_DISCONNECTED					= "client_disconnected" + LOG_SEPARATE;	// 客户端断开连接
	public final static String	CLIENT_IDLE_TIMEOUT					= "client_idle_timeout" + LOG_SEPARATE;	// 客户端空闲超时
	public final static String	CLIENT_ILLEGAL						= "client_Illegal" + LOG_SEPARATE;			// 客户端非法
	public final static String	CLIENT_UNKNOWN_EVENT				= "client_unknown_event" + LOG_SEPARATE;	// 客户端不识别的事件
	public final static String	CLIENT_ERROR						= "client_error" + LOG_SEPARATE;			// 客户端错误
	public final static String	CLIENT_NO_HANDLER					= "client_no_handler" + LOG_SEPARATE;		// 没有对应的处理器
}
