package com.gsk.server.model;

import java.io.Serializable;

public class UserRecommendFriend implements Serializable{
	private static final long serialVersionUID = 6L;

	private Integer f_uin;// pid
	
	private String f_name;
	
    private Integer f_type;
	
	private Integer f_weight;
	
	private String f_name_pinyin;
	
	private String f_name_pinyin_j;
	
	private String f_company_type;
	
	private String f_company;
	
	private String f_other_info;

	public Integer getF_uin() {
		return f_uin;
	}

	public void setF_uin(Integer f_uin) {
		this.f_uin = f_uin;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public Integer getF_type() {
		return f_type;
	}

	public void setF_type(Integer f_type) {
		this.f_type = f_type;
	}

	public Integer getF_weight() {
		return f_weight;
	}

	public void setF_weight(Integer f_weight) {
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

	public String getF_company_type() {
		return f_company_type;
	}

	public void setF_company_type(String f_company_type) {
		this.f_company_type = f_company_type;
	}

	public String getF_company() {
		return f_company;
	}

	public void setF_company(String f_company) {
		this.f_company = f_company;
	}

	public String getF_other_info() {
		return f_other_info;
	}

	public void setF_other_info(String f_other_info) {
		this.f_other_info = f_other_info;
	}

}
