package com.gsk.server.service;

import java.util.Map;

public interface ProjectService {
public Map<String,Object>  addProjectMem(String[] users);
public Map<String,Object>  createProject(String[] params);
public Map<String,Object>  getProList(int uid);
public Map<String,Object>  joinProject(String[] params);
public Map<String,Object>  queryProject(String[] params);
public Map<String,Object>  getProDetail(String[] params);
public Map<String,Object>  checkProMember(String[] params);
public Map<String,Object>  delProMember(String[] params);
public Map<String,Object>  getAllProMember(String[] params);
public Map<String,Object>  getProOverview(String[] params);
public Map<String,Object>  quitProject(String[] params);
public Map<String,Object>  getProInfo(String[] params);
public Map<String,Object>  getProWeather(String[] params);
public Map<String,Object>  uploadProFile(String[] params);
public Map<String,Object>  getProFile(String[] params);
public Map<String,Object>  editProInfo(String[] params);

}
