<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="setting_form" action="javascript:;">
 	<table style="width: 100%;">
 		<tr>
 			<td><lable>配置名称</lable></td>
 			<td><input type="text" name="config_name" value="${settingsinfo.config_name }"/></td>
 		</tr>
 		<tr>
 			<td><lable>配置值</lable></td>
 			<td><input type="text" name="config_value" value="${settingsinfo.config_value }"/></td>
 		</tr>
 		<tr>
 			<td><lable>说明</lable></td>
 			<td><input type="text" name="rmark" value="${settingsinfo.rmark }"/></td>
 		</tr>
 		<tr>
 			<td><lable>是否启用</lable></td>
 			<td>
 				<input type="radio" name="is_on" ${settingsinfo.is_on == 0 ? "checked=\"checked\"":"" } value="0"/>否
				<input type="radio" name="is_on" ${settingsinfo.is_on == 1 ? "checked=\"checked\"":"" } value="1"/>是
 			</td>
 		</tr>
 	</table>
</form>