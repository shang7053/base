<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form action="UserController/login.do">
		<table>
			<tr>
				<td>
					用户名				
				</td>
				<td>
					<input name="uname" value="${registUser.uname }"/>
				</td>
			</tr>
			<tr>
				<td>
					密码				
				</td>
				<td>
					<input type="password" name="password" value="${registUser.password }"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交"/>				
				</td>
				<td>
					<a href="UserController/toRegist.do">注册</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>