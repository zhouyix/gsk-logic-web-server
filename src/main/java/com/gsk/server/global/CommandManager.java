package com.gsk.server.global;

public class CommandManager {
	
	//----------------用户信息，通讯录
	public final static int	CMD_USER_CREATE					= 0x0100;	//创建用户
	public final static int	CMD_USER_INFO					= 0x0101;	//获取用户数据
	public final static int	CMD_USER_UPDATE_INFO			= 0x0102;	//更新用户信息
	public final static int	CMD_USER_UPLOAD_PHONE_ADDRESS	= 0x0103;	//上传通讯录
	public final static int CMD_USER_ADDRESS_RECOMMEND      = 0x0104;   //通讯录推荐
	public final static int CMD_USER_FRIEND_INFO		    = 0x0105;   //获取用户好友信息
	public final static int CMD_USER_REMMEND_PROJECT		= 0x0106;	//获取推荐项目
	
	//----------------好友关系
	public final static int CMD_USER_FRIEND_ADD             = 0x0150;   //添加好友
	public final static int CMD_USER_FRIEND_DEL             = 0x0151;   //删除好友
	public final static int CMD_USER_FRIEND_YES_NO          = 0x0152;   //同意或者拒绝好友
	public final static int CMD_USER_FRIEND_SEARCH          = 0x0153;   //搜索好友
	public final static int CMD_USER_FRIEND_REMARK_UPDATE   = 0x0154;   //修改好友备注
	
	public final static int CMD_IM_SEND_MSG					=0x0201;	//客户端发送IM消息，包括group消息和单聊消息
	
	public final static int CMD_IM_OFFLINE_MSG				=0x0202;	//客户端拉取离线消息或增量消息同步
	
	public final static int CMD_IM_GROUP_CREATE				=0x0203;	//创建群组
	public final static int CMD_IM_GROUP_EDIT				=0x0204;	//修改群组信息
	public final static int CMD_IM_GROUP_GET				=0x0205;	//获取群组信息
	public final static int CMD_IM_GROUP_LIST				=0x0206;	//获取用户群组列表
	public final static int CMD_IM_GROUP_USER_INVITE		=0x0207;	//群组添加成员
	public final static int CMD_IM_GROUP_USER_DEL			=0x0208;	//群组删除成员
	public final static int CMD_IM_GROUP_USER_EDIT			=0x0209;	//修改群成员信息
	public final static int CMD_IM_GROUP_REPORT_READ_SEQ	=0x0210;	//上报群阅读最大seqid
	
	public final static int CMD_PUSH						=0xEEEE;	//消息push
	
	
	//项目有关cmd
	public final static int CMD_PROJECT_INFO_CREATE			=0x0301;//创建项目
	
	public final static int CMD_PROJECT_MY_LIST				=0x0302;//我的项目列表

	public final static int CMD_PROJECT_JOIN				=0x0303;//加入项目
	
	public final static int CMD_PROJECT_QUERY				=0x0304;//查询项目列表
	
	public final static int CMD_PROJECT_DETAIL				=0x0305;//项目详情
	
	public final static int CMD_PROJECT_IM_GROUP_CREATE		=0x0306;//创建项目群聊
	
	public final static int CMD_PROJECT_MANAGE				=0x0307;//项目管理
	
	public final static int CMD_PROJECT_MESSAGE				=0x0308;//项目消息
	
	public final static int CMD_PROJECT_ADD_MEMBER			=0x0309;//添加项目成员
	
	public final static int CMD_PROJECT_CHECK_MEMBER		=0x0310;//审核项目成员
	
	public final static int CMD_PROJECT_DEL_MEMBER			=0x0311;//删除项目成员
	
	public final static int CMD_PROJECT_ALL_MEMBER			=0x0312;//获取项目成员
	
	public final static int CMD_PROJECT_OVER_VIEW			=0x0313;//项目概览
	
	public final static int CMD_PROJECT_QUIT				=0x0314;//退出项目
	
	public final static int CMD_PROJECT_INFO				=0x0315;//项目信息
	
	public final static int CMD_PROJECT_WEATHER				=0x0316;//项目天气
	
	public final static int CMD_PROJECT_UPLOAD_FILE			=0x0317;//项目上传云文件
	
	public final static int CMD_PROJECT_GET_FILE			=0x0318;//获取项目云文件
	
	public final static int CMD_PROJECT_INFO_EDIT			=0x0319;//编辑项目信息
	
	
	//项目任务cmd
	public final static int CMD_TASK_CREATE					=0x0351;//创建任务
	public final static int CMD_TASK_EDIT					=0x0352;//修改任务
	public final static int CMD_TASK_LIST					=0x0353;//项目任务列表
	public final static int CMD_TASK_DETAIL					=0x0354;//任务详情
	public final static int CMD_TASK_REPORT_CREATE			=0x0355;//添加任务汇报
	public final static int CMD_TASK_REPORT_LIST			=0x0356;//任务汇报列表
	public final static int CMD_TASK_VIEW_CREATE			=0x0357;//添加任务查看记录
	public final static int CMD_TASK_VIEW_LIST				=0x0358;//任务查看记录列表
	public final static int CMD_TASK_NOTIFY_CHECK			=0x0359;//任务到期、查看通知(知道了)
	public final static int CMD_TASK_DEL					=0x035A;//删除任务
	public final static int CMD_TASK_TIMER_CALL				=0x035B;//定时器回调
	public final static int CMD_TASK_NOTIFY					=0x035C;//小助手通知；如：发起者提醒成员查看
	public final static int CMD_POSITION_LIST				=0x035D;//常用部位
	
	
	
	//工具类Cmd
	public final static int CMD_UTIL_RELOAD_VERSION			=0x7001;//清空版本缓存
	public final static int CMD_UTIL_ADD_VERSION			=0x7002;//添加版本
	
	
	public final static int CMD_UTIL_USER_ACCOUNT			=0x7101;//添加版本
}
