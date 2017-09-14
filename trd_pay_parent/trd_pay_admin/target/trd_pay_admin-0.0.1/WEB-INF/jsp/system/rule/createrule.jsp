<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="create_rule_form" action="javascript:;">
	<table style="width: 100%">
		<tr>
			<td width="20%">角色名称：</td>
			<td><input type="text" name="rname"/></td>
			<td></td>
		</tr>
		<tr>
			<td width="20%">是否启用：</td>
			<td>
				<input type="radio" name="is_on" value="0"/>否
				<input type="radio" name="is_on" checked="checked" value="1"/>是
			</td>
			<td></td>
		</tr>
		<tr>
			<td width="20%">是否接收消息：</td>
			<td>
				<input type="radio" name="is_recive_notice" value="0"/>否
				<input type="radio" name="is_recive_notice" checked="checked" value="1"/>是
			</td>
			<td></td>
		</tr>
		<tr>
			<td width="20%">权限链接：</td>
			<td><div id="create_rule_choosenodetree"></div></td>
			<td></td>
		</tr>
	</table>
</form>
