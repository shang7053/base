<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="error_form" action="javascript:;">
 	<table style="width: 100%;">
 		<tr>
 			<td><lable>id</lable></td>
 			<td><input type="text" name="id" readonly="readonly" value="${errorinfo.id}" /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>同步码</lable></td>
 			<td><input type="text" name="sync_code" value="${errorinfo.sync_code}"  /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>topic</lable></td>
 			<td><input type="text" name="sink_topic" value="${errorinfo.sink_topic}"  /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>操作类型</lable></td>
 			<td><input type="text" name="action" value="${errorinfo.action}" /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>项目</lable></td>
 			<td><input type="text" name="p_key" value="${errorinfo.p_name}" /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>同步时间</lable></td>
 			<td><input type="text" name="sync_time" value="${errorinfo.sync_time}" /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>创建时间</lable></td>
 			<td><input type="text" name="create_time" value="${errorinfo.create_time}"  /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>重发时间</lable></td>
 			<td><input type="text" name="resend_time" value="${errorinfo.resend_time}"  /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>消息内容</lable></td>
 			<td><input type="text" name="sync_msg" value="${errorinfo.sync_msg}"  /></td>
 			<td></td>
 		</tr>
 	</table>
</form>