<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="jquery-easyui-1.3.2/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.3.2/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.3.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.3.2/themes/icon.css">
	<script type="text/javascript">
		$(function(){
			$('#dd').draggable({ 
				//handle:'#title' 
			}); 
		});
	</script>
</head>

<body>
	<!-- <div id="dd" class="easyui-draggable" data-options="handle:'#title'"
		style="width:100px;height:100px;">
		<div id="title" style="background:#ccc;">title</div>
	</div> -->
	<div id="dd" style="width:100px;height:100px;">
		<!-- <div id="title" style="background:#ccc;">title</div> -->
	</div>

</body>
</html>
