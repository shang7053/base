<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table style="width: 100%">
	<tr>
		<td width="20%">角色名称：</td>
		<td>${rule.rname }</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">是否启用：</td>
		<td>${rule.is_on == 0 ? "否" : "是" }</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">是否接收消息：</td>
		<td>${rule.is_recive_notice == 0 ? "否" : "是" }</td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">创建时间：</td>
		<td><fmt:formatDate value="${rule.create_time }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">更新时间：</td>
		<td><fmt:formatDate value="${rule.update_time }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td></td>
	</tr>
	<tr>
		<td width="20%">权限链接：</td>
		<td><div id="rule_info_choosenodetree"></div></td>
		<td></td>
	</tr>
</table>
