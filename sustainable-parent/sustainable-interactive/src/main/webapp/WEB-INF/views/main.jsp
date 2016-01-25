<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery.timers.js"></script>
<title>提示</title>
<script type="text/javascript">
	$(function() {
		$('body').oneTime('1s', function() {
			$.ajax({
				type : "POST",
				url : "UserController/validateRegist.do",
				data : "uname=${registUser.uname}&password=${registUser.password}",
				success : function(msg) {
					$("p").html(msg.data);
					$('body').oneTime('3s', function() {
						if(msg.status=="y"){
							document.location="UserController/toLogin.do?uname=${registUser.uname}&password=${registUser.password}";
						}else{
							document.location="UserController/toRegist.do?uname=${registUser.uname}&password=${registUser.password}";
						}
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<p>${message }</p>
</body>
</html>