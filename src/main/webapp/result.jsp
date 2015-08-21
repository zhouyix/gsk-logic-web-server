<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<script src='js/jquery-1.9.1.min.js' type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(
		function showResult()
		{
		   var str=window.opener.document.getElementById("outParam").value;
		  str=str.replace(/\"/g,"");
		   $("#result").val(str);
		}
		);
	</script>
	<h2 style="font-size:32px;color:blue;text-align:center">测试结果</h2>
</head>
<body style="text-align:center">
<textarea id="result" rows="80" cols="200" style="font-size:15px"></textarea> 
</body>
</html>