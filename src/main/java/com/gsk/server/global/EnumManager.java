package com.gsk.server.global;
/**
 * 枚举常量定义
 */
public class EnumManager {
	//群组类型
	public static enum CHAT_TYPE {
	    E_CHAT_TYP_SINGLE(1), 			//单聊
	    E_CHAT_TYP_GROUP_CHAT(2),		//群聊
	    E_CHAT_TYP_PRJ_GROUO_CHAT(3);	//项目群聊
	 
	    public int value;
	    
	    private CHAT_TYPE(int value) {
	        this.value = value;
	    }
	}
	
	//消息类型
	public static enum MESSAGE_TYPE {
		E_MESSAG_TYPE_TEXT(1), 			//文本
		E_MESSAG_TYPE_IMG(2), 			//图片
		E_MESSAG_TYPE_VOICE(3), 		//语音
		E_MESSAG_TYPE_VIDEO(4),			//视频
		E_MESSAG_TYPE_NOTIFY(5),		//提示消息
		E_MESSAG_TYPE_TASK_NOTIFY(6),	//提示消息,任务提醒
		E_MESSAG_TYPE_TASK_HELP(7),		//任务小助手
		E_MESSAG_TYPE_TASK_AVATOR(8);	//提示消息,项目、任务附件
	    
	    public int value;
	    
	    private MESSAGE_TYPE(int value) {
	        this.value = value;
	    }
	}
	
	//更新数据类型和push消息类型
	public static enum UPDATE_TYPE {
		E_UPDATE_TYP_ALL(1), 		//全量
		E_UPDATE_TYP_APPEND(2),		//增量
		E_UPDATE_TYP_DELETE(3);		//删除

	    
	    public int value;
	    
	    private UPDATE_TYPE(int value) {
	        this.value = value;
	    }
	}
	
	// 更新用户选项类型
	public static enum USER_FALG {
		E_USERSETTING_SEARCH(0x01), // 被搜索到
		E_USERSETTING_ADD(0x02), // 被加为好友
		E_USERSETTING_POSITION(0x04); //地理位置

		public int value;

		private USER_FALG(int value) {
			if (value >=0 || value <8)
				this.value |= value;
		}
	}
	
	public static enum PROJECT_TYPE{
		E_BUILDING_PROJECT(1), 		//建筑工程
		E_MUNICIPAL_PROJECT(2),		//市政工程
		E_POWER_PROJECT(3),			//电力工程
		E_RAILWAY_PROJECT(4),		//铁路工程
		E_ROAD_PROJECT(5),			//公路工程
		E_METALLURGY_PROJECT(6),	//冶金工程
		E_PETRIFACTION_PROJECT(7),	//石化工程
		E_OTHER_PROJECT(8);			//其他

	    
	    public int value;
	    
	    private PROJECT_TYPE(int value) {
	        this.value = value;
	    }
	}
	
	//任务类型
	public static enum TASK_TYPE {
		E_TASK_TYPE_CHECK(1), 			//验收项
		E_TASK_TYPE_QUESTION(2),		//问题项
		E_TASK_TYPE_NOTICE(3), 			//通知项
		E_TASK_TYPE_OTHERS(4);			//其他
	    
	    public int value;
	    
	    private TASK_TYPE(int value) {
	        this.value = value;
	    }
	}
	
	//任务描述类型
	public static enum TASK_DESC_TYPE {
		E_TASK_DESC_TYPE_TEXT(1), 			//文本
		E_TASK_DESC_TYPE_IMG(2), 			//图片
		E_TASK_DESC_TYPE_VOICE(3), 			//语音
		E_TASK_DESC_TYPE_VIDEO(4);			//视频
	    
	    public int value;
	    
	    private TASK_DESC_TYPE(int value) {
	        this.value = value;
	    }
	}
	
	//任务状态
	public static enum TASK_STATUS {
		E_TASK_STATUS_WROKING(0), 		//进行中
		E_TASK_STATUS_FINISHED(1),		//已完成
		E_TASK_STATUS_DELAY(2);			//延期
		
	    public int value;
	    
	    private TASK_STATUS(int value) {
	        this.value = value;
	    }
	}
	
	//任务提醒状态
	public static enum TASK_NOTIFY_TYPE {
		E_TASK_NOTIFY_TYPE_NO_CONF(0), 					//其他(不需要确认的通知)
		E_TASK_NOTIFY_TYPE_EXPIRE_REMIND(1),			//通知任务发起者即将到期提醒接收者
		E_TASK_NOTIFY_TYPE_EXPIRE_NOTICE(2),			//通知任务接收者即将到期
		E_TASK_NOTIFY_TYPE_CKECK_REMIND(3),				//通知任务发起者提醒接收者查看
		E_TASK_NOTIFY_TYPE_CKECK_NOTICE(4),				//通知任务接收者查看
		E_TASK_NOTIFY_TYPE_NEWTASK_NOTICE(5),			//新建任务通知
		E_TASK_NOTIFY_TYPE_FINISHED_NOTICE(6);			//任务完成通知
		
	    public int value;
	    
	    private TASK_NOTIFY_TYPE(int value) {
	        this.value = value;
	    }
	}
	
	//任务接收者操作状态
	public static enum TASK_OP_STATUS {
		E_TASK_OP_STATUS_DEFAULT(0), 					//操作默认状态
		E_TASK_OP_STATUS_CKECKEN(1);					//已读、已查看
		
	    public int value;
	    
	    private TASK_OP_STATUS(int value) {
	        this.value = value;
	    }
	}
}

