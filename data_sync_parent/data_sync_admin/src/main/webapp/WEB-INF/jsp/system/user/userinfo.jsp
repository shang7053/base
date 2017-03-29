<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table style="width: 100%">
	<tr>
		<td width="20%">用户名：</td>
		<td>${userinfo.username }</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">真实姓名：</td>
		<td>${userinfo.realname }</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">邮箱：</td>
		<td>${userinfo.email}</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">手机号：</td>
		<td>${userinfo.tel }</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">是否启用：</td>
		<td>${userinfo.is_on == 0 ? "否" : "是" }</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">密错重试次数：</td>
		<td>${userinfo.error_pw_count }</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">创建时间：</td>
		<td><fmt:formatDate value="${userinfo.create_time }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">更新时间：</td>
		<td><fmt:formatDate value="${userinfo.update_time }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">上次登录时间：</td>
		<td><fmt:formatDate value="${userinfo.login_time }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">角色列表：</td>
		<td><div id="rule_list">
		</div></td>
		<td></td>
	</tr>
</table>
