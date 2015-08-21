<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<link href="indexCSS.css" rel="stylesheet" type="text/css"/>
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">

var arr = [
		   {id:0, name:'请选择...', type:'', uri:''},
           {id:1, name:'创建群组', type:'post', uri:'group/createGroup.do'},
           {id:2,name:'修改群组信息',type:'post',uri:'group/editGroup.do'},
           {id:3, name:'获取群组列表', type:'get',  uri:'group/listUserGroup.do'},
           {id:4,name:'添加成员',type:'post',uri:'group/inviteGroupUser.do'},
           {id:5,name:'删除成员',type:'post',uri:'group/deleteGroupUser.do'},
           {id:6,name:'修改群成员信息',type:'post',uri:'group/editGroupUser.do'},  
           {id:7,name:'获取群组信息',type:'post',uri:'group/getGroup.do'},
   
           {id:8,name:'添加项目成员',type:'post',uri:'project/addProjectMem.do'},
           {id:9,name:'创建项目',type:'post',uri:'project/createProject.do'},
           {id:10,name:'获取项目列表(无此消息)',type:'get',uri:'project/getProList.do'},
           {id:11,name:'加入项目',type:'post',uri:'project/joinProject.do'},
           {id:12,name:'查询项目(无此消息)',type:'post',uri:'project/queryProject.do'},
           {id:13,name:'获取项目详情',type:'post',uri:'project/getProDetail.do'},
           {id:14,name:'审核项目成员',type:'post',uri:'project/checkProMember.do'},
           {id:15,name:'删除项目成员',type:'post',uri:'project/delProMember.do'},
           {id:16,name:'获取项目所有成员',type:'post',uri:'project/getAllProMember.do'},
           {id:17,name:'获取项目概览',type:'post',uri:'project/getProOverview.do'},
           {id:18,name:'退出项目',type:'post',uri:'project/quitProject.do'},
           {id:19,name:'获取项目信息',type:'post',uri:'project/getProInfo.do'},
           {id:20,name:'获取项目天气',type:'post',uri:'project/getProWeather.do'},
           {id:21,name:'上传项目云文件',type:'post',uri:'project/uploadProFile.do'},
           {id:22,name:'获取项目文件',type:'post',uri:'project/getProFile.do'},
           {id:23,name:'修改项目信息',type:'post',uri:'project/editProInfo.do'},
           
          
           {id:24,name:'创建任务',type:'post',uri:'task/createTask.do'},
           {id:25,name:'项目任务列表',type:'post',uri:'task/listTask.do'},
           {id:26,name:'任务详情',type:'post',uri:'task/getTaskDetail.do'},
           {id:27,name:'任务汇报列表',type:'post',uri:'task/getReportList.do'},
           {id:28,name:'任务记录列表',type:'post',uri:'task/getViewList.do'},
           {id:29,name:'删除任务',type:'post',uri:'task/delTask.do'},
           {id:30,name:'任务通知查看',type:'post',uri:'task/notifyTaskCheck.do'},
           {id:31,name:'任务创建者通知成员查看',type:'post',uri:'task/notifyTask.do'},
           {id:32,name:'获取常用部位',type:'post',uri:'task/getPosition.do'},
           {id:33,name:'定时回调提醒任务',type:'post',uri:'task/scheduledNotifyTask.do'},
           {id:34,name:'创建任务汇报',type:'post',uri:'task/createTaskReport.do'},
           {id:35,name:'修改任务',type:'post',uri:'task/editTask.do'},
           
         
           {id:36,name:'创建用户',type:'post',uri:'user/createUser.do'},
           {id:37,name:'获取用户信息',type:'get',uri:'user/getUserInfo.do'},
           {id:38,name:'修改用户信息',type:'post',uri:'user/updateUserInfo.do'},
           {id:39,name:'上传通讯录',type:'post',uri:'user/uploadPhoneAddress.do'},
           {id:40,name:'通讯录推荐(无此消息)',type:'get',uri:'user/getAddressRecommend.do'},
           {id:41,name:'获取好友信息',type:'post',uri:'user/getFriInfo.do'},
           {id:42,name:'获取推荐项目',type:'post',uri:'user/getProRecommend.do'},
           {id:43,name:'添加好友',type:'post',uri:'user/addFriend.do'},
           {id:44,name:'删除好友',type:'post',uri:'user/delFriend.do'},
           {id:45,name:'是否添加同意好友',type:'post',uri:'user/addFriendIsAgree.do'},
           {id:46,name:'搜索好友',type:'post',uri:'user/searchFriend.do'},
           {id:47,name:'修改好友备注',type:'post',uri:'user/updateFriRemark.do'},
           
           {id:48,name:'客户端拉取消息同步',type:'post',uri:'msg/getOfflineMsg.do'},
           {id:49,name:'客户端发送IM消息',type:'post',uri:'msg/sendMsg.do'}
          ]
          
var newNum=[0,7,23,35,47,49];//消息数量
var apiDoc = [
          	 "", 
			 '["uid","uid"...]',
			 '["uid","groupId","groupName"]',
			 "uid=123",
			 '[uid","groupId","adduids"...]',
			 '["uid","groupId","deluid",......]',
			 '["uid","groupId","userRemark/is_screen/is_remind","newRemark/0 or 1/0 or 1"]',
			 '["uid","groupId"]',
			 '["uid","projectId","addphone/uids"...]',
			 '["uid","PrjName/PrjType(整数)/Province/City/PrjAddress/Area/PrjBegin/PrjEnd/JianzhuDanwei/JianliDanwei/ShigongDanwei/FenbaoDanwei/Lat(浮点数)/Lon(浮点数)...","xxx"]',
			 "uid=123",
			 '["uid","projectId","content"]',
			 '["uid","projectId"]',
			 '["uid","projectId"]',
			 '["uid","projectId","0/1","adduids"...]',
			 '["uid","projectId","deluids"...]',
			 '["uid","projectId"]',
			 '["uid","projectId"]',
			 '["uid","projectId"]',
			 '["uid","projectId"]',
			 '["uid","projectId"]',
			 '["uid","projectId","filename","filetype","fileurl","filesize","fileplaytime","f_pid"]',
			 '["uid","projectId"]',
			 '["uid","projectId","projectName","projectType","projectProvince","projectCity"]',
			'{"f_sponsor":{"f_uin":uin},"f_prj_id":"prjid","f_task_desc":"任务描述","f_position":"地点","f_members":[{"f_uin":uin},{"f_uin":uin}...]}',
			'["uid", "projectId", "pageNo", "pageSize","type"]',
			'["uid","taskId"]',
			'["uid", "taskId", "pageNo", "pageSize"]',
			'["uid", "taskId", "pageNo", "pageSize"]',
			'["uid","taskId"]',
			'["uid","taskId", "提醒类型",msgId]',
			'["uid", "任务id", "提醒类型", "receiverUid"]',
			'["uid", "projectId"]',
			'["uid","任务id", "提醒类型"]',
			'{"f_prj_id":"462530035a054b57a9dc448708c7141d","f_task_id":"123","f_task_end":1438060819,"f_sponsor":{"f_uin":70173531,"f_name":"xy"},"f_report_list":[{"f_title":"ww","f_content":"xx","f_reporter":{"f_uin":70173531,"f_name":"zy"},"f_reply_to":{"f_uin":13142799,"f_name":"trt"}}]}',
			'{"f_sponsor":{"f_uin":uin},"f_prj_id":"prjid","f_task_desc":"任务描述","f_position":"地点","f_members":[{"f_uin":uin},{"f_uin":uin}...],"f_task_begin":140302,"f_task_end":140512,"f_postion":"北京"}',
			'["uid","phone","province","city","jobtitle","company","companytitle","yearofworking","jobtype"]',
			"uid=xxx",
			'["uid","fProvince/fCity/fName","xx"....]',
			'["uid","phone"]',
			"uid=xxx",
			'["uid","friID"]',
			'["uid","page","pagesize"]',
			'["uid","friId","msg"]',
			'["uid","friId"]',
			'["uid","0/1","friId"]',
			'["uid","friPhone"]',
			'["uid","friId","remark"]',
			'["uid","seqId","pagesize","groupId"]',
			'["uid","1","1/2/3","groupId","msg body","msgId"]'
]




//加载功能列表
$(document).ready(function() { 
//	var selObj = $("#funcSelect");
    $("#outParam").css({"display":"none"});
    $("#funcSelect1").append("<option>请选择... </option>");
    $("#funcSelect2").append("<option>请选择... </option>");
    $("#funcSelect3").append("<option>请选择... </option>");
    $("#funcSelect4").append("<option>请选择... </option>");
    $("#funcSelect5").append("<option>请选择... </option>");
	for(var i = 1; i < arr.length; i++) {
		var item = arr[i];
		if(i>=1 && i<=newNum[1])
			$("#funcSelect1").append("<option value='"+item.id+"'>"+item.name+"</option>");
		if(i>newNum[1] && i<=newNum[2])
			$("#funcSelect2").append("<option value='"+item.id+"'>"+item.name+"</option>");
		if(i>newNum[2] && i<=newNum[3])
			$("#funcSelect3").append("<option value='"+item.id+"'>"+item.name+"</option>");
		if(i>newNum[3] && i<=newNum[4])
			$("#funcSelect4").append("<option value='"+item.id+"'>"+item.name+"</option>");
		if(i>newNum[4] && i<=newNum[5])
			$("#funcSelect5").append("<option value='"+item.id+"'>"+item.name+"</option>");
	}
	
	$('#funcSelect1').change(function(){  
		var id = $(this).children('option:selected').val();//这就是selected的值  
		var uri = arr[id].uri;
		var type = arr[id].type;
		if(type=='get') {
			$("#save").attr("onclick", 'getData("' + uri + '");');
		} else {
			$("#save").attr("onclick", 'postData("' + uri + '");');
		}
		$("#viewApi").attr("onclick", 'viewApi(' + id + ');');
		
		
		var text=apiDoc[id];//默认值输入到框中
		$("#inputParam").val(text);
		$("#outParam").val('');
	});
	
	$('#funcSelect2').change(function(){  
		var id = $(this).children('option:selected').val();//这就是selected的值
		var uri = arr[id].uri;
		var type = arr[id].type;
		if(type=='get') {
			$("#save").attr("onclick", 'getData("' + uri + '");');
		} else {
			$("#save").attr("onclick", 'postData("' + uri + '");');
		}
		$("#viewApi").attr("onclick", 'viewApi(' + id + ');');
		
		
		var text=apiDoc[id];//默认值输入到框中
		$("#inputParam").val(text);
		$("#outParam").val('');
	});
	
	$('#funcSelect3').change(function(){  
		var id = $(this).children('option:selected').val();//这就是selected的值  
		var uri = arr[id].uri;
		var type = arr[id].type;
		if(type=='get') {
			$("#save").attr("onclick", 'getData("' + uri + '");');
		} else {
			$("#save").attr("onclick", 'postData("' + uri + '");');
		}
		$("#viewApi").attr("onclick", 'viewApi(' + id + ');');
		
		
		var text=apiDoc[id];//默认值输入到框中
		$("#inputParam").val(text);
		$("#outParam").val('');
	});
	
	$('#funcSelect4').change(function(){  
		var id = $(this).children('option:selected').val();//这就是selected的值  
		var uri = arr[id].uri;
		var type = arr[id].type;
		if(type=='get') {
			$("#save").attr("onclick", 'getData("' + uri + '");');
		} else {
			$("#save").attr("onclick", 'postData("' + uri + '");');
		}
		$("#viewApi").attr("onclick", 'viewApi(' + id + ');');
		
		
		var text=apiDoc[id];//默认值输入到框中
		$("#inputParam").val(text);
		$("#outParam").val('');
	});
	
	$('#funcSelect5').change(function(){  
		var id = $(this).children('option:selected').val();//这就是selected的值  
		var uri = arr[id].uri;
		var type = arr[id].type;
		if(type=='get') {
			$("#save").attr("onclick", 'getData("' + uri + '");');
		} else {
			$("#save").attr("onclick", 'postData("' + uri + '");');
		}
		$("#viewApi").attr("onclick", 'viewApi(' + id + ');');
		
		
		var text=apiDoc[id];//默认值输入到框中
		$("#inputParam").val(text);
		$("#outParam").val('');
	});
	
});  

function postData(uri) {
	var param = trim($("#inputParam").val());
	if (param == '' || param == null || param == undefined) {
		alert("输入参数不能为空");
		return;
	}
	jQuery.ajax({
	 	type: 'POST',   
        data: param, 
        dataType: 'json',
        contentType:'application/json;charset=UTF-8',
		url : uri,
		success : function(data) {
			var res=JSON.stringify(data).replace(/\\/g,'');
			$("#outParam").val(res);
			window.open("result.jsp");
		},
		 error:function(){
		       alert("操作失败，重新输入数据");
		       $("#inputParam").val('');
		      }
	});
}

function getData(uri) {
	var param = trim($("#inputParam").val());
	if (param == '' || param == null || param == undefined) {
		alert("输入参数不能为空");
		return;
	}
	
	
	jQuery.ajax({
	 	type: 'GET',   
        data: param,
		url : uri,
		success : function(data) {
			$("#outParam").val(JSON.stringify(data).replace(/\\/g,''));
			window.open("result.jsp");
		},
		 error:function(){
		       alert("操作失败，重新输入数据");
		       $("#inputParam").val('');
		      }
	});
}

function viewApi(index) {
	var api = apiDoc[index];
	if (index > 0) {
		alert(api);
	}
}

function trim(str){ //删除左右两端的空格
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
</script>
</head>
<h2>接口测试平台</h2>
<body >
<div id="hint">此工具旨在帮助开发者验证接口时传入的参数是否正确在后台运行</div>
<br>
	<text class="text">step1.选择测试的消息 <text>
	<br>
	<br>
	<div id="first">
	              群组消息
	   <select id="funcSelect1">
	    </select>
    </div>
    <div id="second">
                     项目消息<select id="funcSelect2">
		</select>
	</div>
	<div id="third">
	 任务消息<select id="funcSelect3">
		</select>
	</div>
	<div id="fourth">
	  用户消息<select id="funcSelect4">
		</select>
	</div>	
	<div id="fifth">
	  会话消息<select id="funcSelect5">
		</select>
	</div>
	
	<table>
	<tr>
	<br>
	<br>
	<br>
   <td valign="top"><text class="text">step2.输入</text></td>
      <td><textarea  id="inputParam"  class="input">按照给出的提示填充相应字段</textarea></td>
	</tr>
	<tr>
	<textarea id="outParam" rows="10" cols="80"></textarea> 
    <br>
    <br>
	</tr>
	<tr>
	</tr>
		</table>
	<div class="text">step3:提交</div>
	<br>
     <button id="save" onclick='' >提交</button>




</body>
</html>
