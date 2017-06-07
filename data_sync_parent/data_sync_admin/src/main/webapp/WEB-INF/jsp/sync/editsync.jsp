<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form id="setting_form" action="javascript:;">
 	<table style="width: 100%;">
 		<tr>
 			<td><lable>同步码</lable></td>
 			<td>
 				<input type="hidden" name="sync_id" value="${syncqc.sync_id }" />
 				<input type="hidden" name="version" value="${syncqc.version }" />
 				<input type="text" name="sync_code" disabled="disabled" value="${syncqc.sync_code }"/>
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>canal</lable></td>
 			<td>
 				<select id="canalSelect" name="canal_id">
	 				<c:forEach var="item" items="${canalList}" varStatus="status">
					        <option value=${item.canal_id } <c:if test="${item.canal_id == syncqc.canal_id}">selected</c:if>>${item.canal_name }</option>
					</c:forEach> 
 				</select>
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>规则</lable></td>
 			<td>
 				<select id="ruleSelect" name="reg_id">
 					<c:forEach var="item" items="${rulesList}" varStatus="status">
				          <option value=${item.reg_id } <c:if test="${item.reg_id == syncqc.reg_id}">selected</c:if>>${item.reg_name }</option>
					</c:forEach> 
 				</select>
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>邮件收件人</lable></td>
 			<td>
 				<input type="text" name="recive_email" placeholder="多个收件人用逗号分隔" value="${syncqc.recive_email }"/>
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>备注</lable></td>
 			<td>
 				<input type="text" name="sync_note" value="${syncqc.sync_note }"/>
 			</td>
 			<td></td>
 		</tr>
 	</table>
</form>