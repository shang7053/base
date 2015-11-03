<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="static_resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			   type: "POST",
			   url: "list",
			   success: function(msg){
					for(var i=0;i<msg.length;i++){
						document.write(msg[i]+"<br/>");
					}
			   }
			});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>