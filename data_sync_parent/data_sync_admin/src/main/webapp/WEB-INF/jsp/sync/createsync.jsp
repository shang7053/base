<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form id="create_setting_form" action="javascript:;">
 	<table style="width: 100%;">
 		<tr>
 			<td><lable>同步码</lable></td>
 			<td><input type="text" placeholder="如：项目简称_库_表" name="sync_code"/></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>canal</lable></td>
 			<td>
 				<select id="canalSelect" name="canal_id">
	 				<c:forEach var="item" items="${canalList}" varStatus="status">
					        <option value=${item.canal_id }>${item.canal_name }</option> 
					</c:forEach> 
 				</select>
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>规则</lable></td>
 			<td>
 				<select id="ruleSelect" name="reg_id" >
 					<c:forEach var="item" items="${rulesList}" varStatus="status">
				         <option value=${item.reg_id }>${item.reg_name }</option> 
					</c:forEach> 
 				</select>
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>邮件收件人</lable></td>
 			<td>
 				<input type="text" name="recive_email" placeholder="多个收件人用逗号分隔"/>
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>备注</lable></td>
 			<td>
 				<input type="text" name="sync_note" />
 			</td>
 			<td></td>
 		</tr>
 	</table>
</form>