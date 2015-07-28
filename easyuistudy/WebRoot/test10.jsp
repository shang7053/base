<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<script type="text/javascript" src="jquery-easyui-1.3.2/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.2/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.2/themes/icon.css">
		<script type="text/javascript">
		$(function(){
		});
	</script>
  </head>
  
  <body>
   	<div id="aa" class="easyui-accordion" style="width:300px;height:200px;">   
    <div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">   
        <h3 style="color:#0099FF;">Accordion for jQuery</h3>   
        <p>Accordion is a part of easyui framework for jQuery.     
        It lets you define your accordion component on web page more easily.</p>   
    </div>   
    <div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">   
        content2    
    </div>   
    <div title="Title3">   
        content3    
    </div>   
</div>  


  </body>
</html>
