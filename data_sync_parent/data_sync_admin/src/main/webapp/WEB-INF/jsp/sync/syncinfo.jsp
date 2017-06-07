<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<form id="setting_form" action="javascript:;">
 	<table style="width: 100%;">
 		<tr>
 			<td><lable>同步码</lable></td>
 			<td>
 				${syncqc.sync_code }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>canal名称</lable></td>
 			<td>
 				${syncqc.canal_name }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>canal Ip</lable></td>
 			<td>
 				${syncqc.canal_ip }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>canal端口</lable></td>
 			<td>
 				${syncqc.canal_port }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>canal实例</lable></td>
 			<td>
 				${syncqc.canal_destination }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>canal主题</lable></td>
 			<td>
 				${syncqc.canal_subscribe }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>源库名称</lable></td>
 			<td>
 				${syncqc.ds_name }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>源库IP</lable></td>
 			<td>
 				${syncqc.ds_ip }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>源库端口</lable></td>
 			<td>
 				${syncqc.ds_port }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>源表名称</lable></td>
 			<td>
 				${syncqc.tab_name }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>规则名称</lable></td>
 			<td>
 				${syncqc.reg_name }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>邮件收件人</lable></td>
 			<td>
 				${syncqc.recive_email }
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>是否启用</lable></td>
 			<td>
 				${syncqc.is_on == 0 ? "未启用" : "启用" }
 			</td>
 			<td></td>
 		</tr>
 		
 		<tr>
 			<td><lable>修改时间</lable></td>
 			<td>
 				<fmt:formatDate value='${syncqc.update_time}' pattern='yyyy-MM-dd HH:mm:ss'/>
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>创建时间</lable></td>
 			<td>
 				<fmt:formatDate value='${syncqc.create_time}' pattern='yyyy-MM-dd HH:mm:ss'/>
 			</td>
 			<td></td>
 		</tr>
 		
 		
 		<tr>
 			<td><lable>备注</lable></td>
 			<td>
 				${syncqc.sync_note }
 			</td>
 			<td></td>
 		</tr>
 	</table>
</form>