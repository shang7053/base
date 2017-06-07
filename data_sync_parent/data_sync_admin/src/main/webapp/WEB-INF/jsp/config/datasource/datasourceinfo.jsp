<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="datasource_form" action="javascript:;">
 	<table style="width: 100%;">
 		<tr>
 			<td><lable>数据源名称</lable></td>
 			<td><input type="text" name="ds_name" readonly="readonly" value="${datasourceinfo.ds_name}" /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>IP</lable></td>
 			<td><input type="text" name="ds_ip" value="${datasourceinfo.ds_ip}"  /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>端口</lable></td>
 			<td><input type="number" name="ds_port" value="${datasourceinfo.ds_port}"  /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>数据库名称</lable></td>
 			<td><input type="text" name="ds_dbname" value="${datasourceinfo.ds_dbname}"  /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>用户名</lable></td>
 			<td><input type="text" name="ds_uname" value="${datasourceinfo.ds_uname}"  /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>密码</lable></td>
 			<td>
 			<input type="hidden" name="ds_status"/>
 			<input type="text" name="ds_pwd" value="${datasourceinfo.ds_pwd}"  /></td>
 			<td></td>
 		</tr>
 		<tr style="display: none;">
 			<td><lable>数据源状态</lable></td>
 			<td><input type="text" value="${datasourceinfo.ds_status == 1 ? '正常' : '失效' }"  /></td>
 			<td></td>
 		</tr>
 		<tr style="display: none;">
 			<td><lable>是否启用</lable></td>
 			<td><input type="text" value="${datasourceinfo.is_on == 0 ? '否' : '是' }"  /></td>
 			<td></td>
 		</tr>
 		<tr style="display: none;">
 			<td><lable>验证时间</lable></td>
 			<td><input type="text"  value='<fmt:formatDate value="${datasourceinfo.validate_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'/> </td>
 			<td></td>
 		</tr>
 		<tr style="display: none;">
 			<td><lable>创建时间</lable></td>
 			<td><input type="text" value='<fmt:formatDate value="${datasourceinfo.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'  /></td>
 			<td></td>
 		</tr>
 		<tr style="display: none;">
 			<td><lable>修改时间</lable></td>
 			<td><input type="text"  value='<fmt:formatDate value="${datasourceinfo.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'/> </td>
 			<td></td>
 		</tr>
 	</table>
</form>