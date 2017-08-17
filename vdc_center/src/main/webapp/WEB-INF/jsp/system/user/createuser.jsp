<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="create_user_form" action="javascript:;" class="create_user_form">
	<table style="width: 100%">
		<tr>
			<td width="20%">用户名：</td>
			<td><input type="text" name="username" /></td>
			<td></td>
		</tr>
		<tr>
			<td width="20%">真实姓名：</td>
			<td><input type="text" name="realname" /></td>
			<td></td>
		</tr>
		<tr>
			<td width="20%">邮箱：</td>
			<td><input type="text" name="email"/></td>
			<td></td>
		</tr>
		<tr>
			<td width="20%">手机号：</td>
			<td><input type="text" name="tel" /></td>
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
		<tr style="display: none;">
			<td width="20%">权限链接：</td>
			<td><div id="create_user_choosenodetree"></div></td>
			<td></td>
		</tr>
	</table>
</form>
