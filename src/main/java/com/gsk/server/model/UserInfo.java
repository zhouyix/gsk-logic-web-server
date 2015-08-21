package com.gsk.server.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * 用户信息,好友，群组信息
 * @author wangy-ae	
 *
 */
public class UserInfo implements Serializable{
	private int fUin;
	
	
	private String fProvince;
	
	
	private String fCity;
	
	
	private String fPhone;
	
	
	private String fName;
	
	
	private String fCompany;
	
	
	private String fCompanyType;
	
	
	private String fYearsOfWorking;
	
	
	private String fJobType;

	
	private String fJobTitle;
	

	private int fSetting;
	
	
	private String fNamePinyin;
	
	
	private String fNamePinyinJ;
	
	
	private List<UserFriend> fFriendList;//好友列表
	private List<UserFriend> fFriendValidationList;//好友验证列表
	private List<UserRecommendFriend> fFriendRecommendList;//通讯录好友推荐列表
	private List<UserGroup> fUserGroupList;//groupliebiao
	private List<UserProject> fUserProjectList; //项目列表
	private List<UserRecommendProject> fUserRecommendProjectList; //项目推荐列表
	public int getfUin() {
		return fUin;
	}
	public void setfUin(int fUin) {
		this.fUin = fUin;
	}
	public String getfProvince() {
		return fProvince;
	}
	public void setfProvince(String fProvince) {
		this.fProvince = fProvince;
	}
	public String getfCity() {
		return fCity;
	}
	public void setfCity(String fCity) {
		this.fCity = fCity;
	}
	public String getfPhone() {
		return fPhone;
	}
	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfCompany() {
		return fCompany;
	}
	public void setfCompany(String fCompany) {
		this.fCompany = fCompany;
	}
	public String getfCompanyType() {
		return fCompanyType;
	}
	public void setfCompanyType(String fCompanyType) {
		this.fCompanyType = fCompanyType;
	}
	public String getfYearsOfWorking() {
		return fYearsOfWorking;
	}
	public void setfYearsOfWorking(String fYearsOfWorking) {
		this.fYearsOfWorking = fYearsOfWorking;
	}
	public String getfJobType() {
		return fJobType;
	}
	public void setfJobType(String fJobType) {
		this.fJobType = fJobType;
	}
	public String getfJobTitle() {
		return fJobTitle;
	}
	public void setfJobTitle(String fJobTitle) {
		this.fJobTitle = fJobTitle;
	}
	public int getfSetting() {
		return fSetting;
	}
	public void setfSetting(int fSetting) {
		this.fSetting = fSetting;
	}
	public String getfNamePinyin() {
		return fNamePinyin;
	}
	public void setfNamePinyin(String fNamePinyin) {
		this.fNamePinyin = fNamePinyin;
	}
	public String getfNamePinyinJ() {
		return fNamePinyinJ;
	}
	public void setfNamePinyinJ(String fNamePinyinJ) {
		this.fNamePinyinJ = fNamePinyinJ;
	}
	public List<UserFriend> getfFriendList() {
		return fFriendList;
	}
	public void setfFriendList(List<UserFriend> fFriendList) {
		this.fFriendList = fFriendList;
	}
	public List<UserFriend> getfFriendValidationList() {
		return fFriendValidationList;
	}
	public void setfFriendValidationList(List<UserFriend> fFriendValidationList) {
		this.fFriendValidationList = fFriendValidationList;
	}
	public List<UserRecommendFriend> getfFriendRecommendList() {
		return fFriendRecommendList;
	}
	public void setfFriendRecommendList(
			List<UserRecommendFriend> fFriendRecommendList) {
		this.fFriendRecommendList = fFriendRecommendList;
	}
	public List<UserGroup> getfUserGroupList() {
		return fUserGroupList;
	}
	public void setfUserGroupList(List<UserGroup> fUserGroupList) {
		this.fUserGroupList = fUserGroupList;
	}
	public List<UserProject> getfUserProjectList() {
		return fUserProjectList;
	}
	public void setfUserProjectList(List<UserProject> fUserProjectList) {
		this.fUserProjectList = fUserProjectList;
	}
	public List<UserRecommendProject> getfUserRecommendProjectList() {
		return fUserRecommendProjectList;
	}
	public void setfUserRecommendProjectList(
			List<UserRecommendProject> fUserRecommendProjectList) {
		this.fUserRecommendProjectList = fUserRecommendProjectList;
	}
	
	
	
}
