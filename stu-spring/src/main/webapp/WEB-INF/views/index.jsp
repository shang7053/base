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
<title>Insert title here</title>
</head>
<body>
	<table>
		<sf:form method="post"  action="add" modelAttribute="testVo">
			<fieldset>
				<tr>
					<td><sf:label path="name">姓名</sf:label></td>
					<td><sf:input path="name"/><br/>
						<sf:errors path="name"></sf:errors>
					</td>
				</tr>				
				<tr>
					<td><sf:label path="age">年龄</sf:label></td>
					<td><sf:input path="age"/><br/>
						<sf:errors path="age"></sf:errors>
					</td>
				</tr>				
				<tr>
					<td><input type="submit" value="submit"/> </td>
					<td><input type="reset" value="reset"/>
					</td>
				</tr>				
			</fieldset>
		</sf:form>
	</table>
</body>
</html>