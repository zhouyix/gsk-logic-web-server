package com.gsk.server.service;

import java.util.Map;

import com.gsk.server.model.UserInfo;

public interface UserService {
	public Map<String, Object> createUser(String[] params);

	public Map<String, Object> getUserInfo(int uid);

	public  Map<String, Object> updateUserInfo(String[] params);

	public  Map<String, Object>  uploadPhoneAddress(String[] params);

	public Map<String, Object> getAddressRecommend(int uid);

	public  Map<String, Object> getFriInfo(String[] params);

	public  Map<String, Object>  getProRecommend(String[] params);

	public Map<String, Object>addFriend(String[] params);

	public Map<String, Object> delFriend(String[] params);

	public Map<String, Object> addFriendIsAgree(String[] params);

	public Map<String, Object> searchFriend(String[] params);

	public  Map<String, Object>  updateFriRemark(String[] params);

	
}
