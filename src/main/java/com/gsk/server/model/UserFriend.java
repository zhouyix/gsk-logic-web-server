package com.gsk.server.model;

import java.io.Serializable;

import com.gsk.server.utils.WordSpellingInfo;

public class UserFriend implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int f_uin;//好友Id
	
	private String f_name;//冗余用户昵称
	
	private String f_remark ="";//好友备注
	
	private String f_phone ="";//好友电话
	
	private String f_msg = "";//请求好友的验证信息
	
	private int f_flag;//好友状态
	
	private String f_initial;//首字母
	
	private int f_weight;//排序的权重
	
	private String f_name_pinyin  ;  //昵称全拼
	
	private String f_name_pinyin_j  ; //昵称简拼
	
	private String f_remark_pinyin  ;  //备注全拼
	
	private String f_remark_pinyin_j ; //备注简拼
	
	private static WordSpellingInfo word  = new WordSpellingInfo("");
	
	public UserFriend(int f_uin, String f_name, String f_remark,String f_phone,
			String f_msg, int f_flag, String f_initial, int f_weight) {
		super();
		this.f_uin = f_uin;
		this.f_name = f_name;
		this.f_remark = f_remark;
		this.f_phone = f_phone;
		this.f_msg = f_msg;
		this.f_flag = f_flag;
		this.f_initial = f_initial;
		this.f_weight = f_weight;
		word.setWord(f_name);
		this.f_name_pinyin = word.getSpelling();
		this.f_name_pinyin_j = word.getShortspelling();
		word.setWord(f_remark);
		this.f_remark_pinyin = word.getSpelling();
		this.f_remark_pinyin_j = word.getShortspelling();
	}

	public int getF_uin() {
		return f_uin;
	}

	public void setF_uin(int f_uin) {
		this.f_uin = f_uin;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
		word.setWord(f_name);
		this.f_name_pinyin = word.getSpelling();
		this.f_name_pinyin_j = word.getShortspelling();
	}

	public String getF_remark() {
		return f_remark;
	}

	public void setF_remark(String f_remark) {
		this.f_remark = f_remark;
		word.setWord(f_remark);
		this.f_remark_pinyin = word.getSpelling();
		this.f_remark_pinyin_j = word.getShortspelling();
	}
	
	public String getF_phone() {
		if(f_phone == null)
			f_phone = "";
		return f_phone;
	}

	public void setF_phone(String f_phone) {
		this.f_phone = f_phone;
	}

	public String getF_msg() {
		return f_msg;
	}

	public void setF_msg(String f_msg) {
		this.f_msg = f_msg;
	}

	public int getF_flag() {
		return f_flag;
	}

	public void setF_flag(int f_flag) {
		this.f_flag = f_flag;
	}
	

	public String getF_initial() {
		return f_initial;
	}

	public void setF_initial(String f_initial) {
		this.f_initial = f_initial;
	}

	public int getF_weight() {
		return f_weight;
	}

	public void setF_weight(int f_weight) {
		this.f_weight = f_weight;
	}

	public String getF_name_pinyin() {
		return f_name_pinyin;
	}

	public void setF_name_pinyin(String f_name_pinyin) {
		this.f_name_pinyin = f_name_pinyin;
	}

	public String getF_name_pinyin_j() {
		return f_name_pinyin_j;
	}

	public void setF_name_pinyin_j(String f_name_pinyin_j) {
		this.f_name_pinyin_j = f_name_pinyin_j;
	}

	public String getF_remark_pinyin() {
		return f_remark_pinyin;
	}

	public void setF_remark_pinyin(String f_remark_pinyin) {
		this.f_remark_pinyin = f_remark_pinyin;
	}

	public String getF_remark_pinyin_j() {
		return f_remark_pinyin_j;
	}

	public void setF_remark_pinyin_j(String f_remark_pinyin_j) {
		this.f_remark_pinyin_j = f_remark_pinyin_j;
	}



	
}
