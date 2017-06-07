<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="create_datasource_form" action="javascript:;">
 	<table style="width: 100%;">
 		<tr>
 			<td><lable>数据源名称</lable></td>
 			<td><input type="text" placeholder="如：172_16_41_151_3306_v3a_dbbase" name="ds_name"/></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>IP</lable></td>
 			<td>
 			<input type="hidden" name="ds_status"/>
 			<input type="text" name="ds_ip" /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>端口</lable></td>
 			<td><input type="number" name="ds_port" /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>数据库名称</lable></td>
 			<td><input type="text" name="ds_dbname" /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>用户名</lable></td>
 			<td><input type="text" name="ds_uname" /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>密码</lable></td>
 			<td><input type="text" name="ds_pwd" /></td>
 			<td></td>
 		</tr>
 	</table>
</form>