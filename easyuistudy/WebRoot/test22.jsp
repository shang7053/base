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
   	<table class="easyui-datagrid">   
    <thead>   
        <tr>   
            <th data-options="field:'code'">编码</th>   
            <th data-options="field:'name'">名称</th>   
            <th data-options="field:'price'">价格</th>   
        </tr>   
    </thead>   
    <tbody>   
        <tr>   
            <td>001</td><td>name1</td><td>2323</td>   
        </tr>   
        <tr>   
            <td>002</td><td>name2</td><td>4612</td>   
        </tr>   
    </tbody>   
</table>  


  </body>
</html>
