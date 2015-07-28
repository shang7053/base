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
	<script type="text/javascript" src="jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.2/themes/icon.css">
		<script type="text/javascript">
		$(function(){
		});
	</script>
  </head>
  
  <body>
   	<a href="javascript:void(0)" id="mb" class="easyui-menubutton"     
        data-options="menu:'#mm',iconCls:'icon-edit'">Edit</a>   
<div id="mm" style="width:150px;">   
    <div data-options="iconCls:'icon-undo'">Undo</div>   
    <div data-options="iconCls:'icon-redo'">Redo</div>   
    <div class="menu-sep"></div>   
    <div>Cut</div>   
    <div>Copy</div>   
    <div>Paste</div>   
    <div class="menu-sep"></div>   
    <div data-options="iconCls:'icon-remove'">Delete</div>   
    <div>Select All</div>   
</div>  


  </body>
</html>
