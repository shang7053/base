<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form id="setting_form" action="javascript:;">
 	<table style="width: 100%;">
 		<tr>
 			<td><lable>cannal配置信息</lable></td>
 		</tr>
 		<tr>
 			<td><lable>$&nbsp;{CANAL_PATH}/conf/canal.properties</lable></td>
 		</tr>
 		<tr>
 			<td><lable>$&nbsp;注：若已存在，则将对应配置追加在原有配置后面，以逗号分割。</lable></td>
 		</tr>
 		</br>
 		<tr>
 			<td><lable>#################################################</br>

						#########&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;destinations&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;#############</br>
						
						#################################################</br></lable></td>
 		</tr>
 		<tr>
 			<!-- 数据源的ip和端口 -->
 			<td><lable>canal.destinations= ${syncqc.canal_destination }</lable></td>
 		</tr>
		<tr>
 			<td><lable>&nbsp;</lable></td>
 		</tr>	
		<tr><!-- 数据源的ip和端口 -->
 			<td><lable>$&nbsp;{CANAL_PATH}/conf/${syncqc.canal_destination }/instance.properties</lable></td>
 		</tr>
		<tr>
 			<td><lable>&nbsp;</lable></td>
 		</tr>
 		<tr><!-- 数据源的ip和端口 reg_dsid_datasource -->
 			<td><lable>#################################################</lable></td>
 		</tr>	
 		<tr>
 			<td><lable>## mysql serverId</lable></td>
 		</tr>
 		<tr>
 			<td><lable>canal.instance.mysql.slaveId = ${syncqc.sync_id }</lable></td>
 		</tr>
 		<tr><!-- 数据源的ip和端口 reg_dsid/tab_id对应_datasource table -->
 			<td><lable># position info</lable></td>
 		</tr>
 		<tr><!-- 数据源的ip和端口 reg_dsid_datasource -->
 			<td><lable>canal.instance.master.address = ${syncqc.ds_ip}:${syncqc.ds_port}</lable></td>
 		</tr>	
 		<tr><!-- 数据源的ip和端口 reg_dsid_datasource -->
 			<td><lable>canal.instance.master.journal.name =</lable></td>
 		</tr>	
 		<tr><!-- 数据源的ip和端口 reg_dsid_datasource -->
 			<td><lable>canal.instance.master.position =</lable></td>
 		</tr>	
 		<tr><!-- 数据源的ip和端口 reg_dsid_datasource -->
 			<td><lable>canal.instance.master.timestamp =</lable></td>
 		</tr>	
 		<tr>
 			<td><lable>&nbsp;</lable></td>
 		</tr>	
 		<tr><!-- 数据源的ip和端口 reg_dsid_datasource -->
 			<td><lable>#canal.instance.standby.address =</lable></td>
 		</tr>	
 		<tr><!-- 数据源的ip和端口 reg_dsid_datasource -->
 			<td><lable>#canal.instance.standby.journal.name =</lable></td>
 		</tr>	
 		<tr><!-- 数据源的ip和端口 reg_dsid_datasource -->
 			<td><lable>#canal.instance.standby.position =</lable></td>
 		</tr>	
 		<tr><!-- 数据源的ip和端口 reg_dsid_datasource -->
 			<td><lable>#canal.instance.standby.timestamp =</lable></td>
 		</tr>	
 		<tr>
 			<td><lable>&nbsp;</lable></td>
 		</tr>
 		<tr><!-- 数据源的ip和端口 reg_dsid_datasource -->
 			<td><lable># username/password</lable></td>
 		</tr>	
 		<tr>
 			<td><lable>canal.instance.dbUsername = canal</lable></td>
 		</tr>
 		<tr>
 			<td><lable>canal.instance.dbPassword = canal</lable></td>
 		</tr>
 		<tr>
 			<td><lable>canal.instance.defaultDatabaseName =</lable></td>
 		</tr>
 		<tr>
 			<td><lable>canal.instance.connectionCharset = UTF-8</lable></td>
 		</tr>
 		<tr>
 			<td><lable>&nbsp;</lable></td>
 		</tr>
 		<tr>
 			<td><lable># table regex</lable></td>
 		</tr>
 		<tr><!-- 数据源的ip和端口 reg_dsid/tab_id对应_datasource table -->
 			<td><lable>canal.instance.filter.regex = ${syncqc.ds_dbname }.${syncqc.tab_name }</lable></td>
 		</tr>
 		<tr>
 			<td><lable># table black regex</lable></td>
 		</tr>
 		<tr><!-- 数据源的ip和端口 reg_dsid/tab_id对应_datasource table -->
 			<td><lable>anal.instance.filter.black.regex =</lable></td>
 		</tr>
 		<tr><!-- 数据源的ip和端口 reg_dsid_datasource -->
 			<td><lable>#################################################</lable></td>
 		</tr>
 		<tr>
 			<td><lable>&nbsp;</lable></td>
 		</tr>
 		<tr>
 			<td><lable>flume配置</lable></td>
 		</tr>
 		<tr>
 			<td><lable>$&nbsp;{FLUME_PATH}/conf/${syncqc.sync_code}.properties</lable></td>
 		</tr>
 		<tr>
 			<td><lable>&nbsp;</lable></td>
 		</tr>
 		<tr>
 			<td>
 				<lable>
 				agent.sources=s1</br>
				agent.sinks=k1</br>
				agent.channels=c1</br>
				agent.sinks.k1.channel=c1</br>
				</lable>
			</td>
 		</tr>
 		<tr>
 			<td><lable>&nbsp;</lable></td>
 		</tr>
 		<tr>
 			<td>
	 			<lable>
	 				agent.sources.s1.type=com.voole.flume.source.CanalSource</br>
					agent.sources.s1.datasync_plugin_version=${sync_version}</br>
					agent.sources.s1.sync_code=${syncqc.sync_code}</br>
					agent.sources.s1.channels=c1</br>
	 			</lable>
 			</td>
 		</tr>
 		<tr>
 			<td><lable>&nbsp;</lable></td>
 		</tr>
 		<tr>
 			<td>
 				<lable>
 					agent.channels.c1.type=file</br>
					agent.channels.c1.checkpointDir=/opt/flume/logs/${syncqc.sync_code}/checkpoint.out</br>
					agent.channels.c1.dataDirs=/opt/flume/logs/${syncqc.sync_code}/data.out</br>
 				</lable>
 			</td>
 		</tr>
 		<tr>
 			<td><lable>&nbsp;</lable></td>
 		</tr>
 		<tr>
 			<td>
 				<lable>
 					agent.sinks.k1.type=com.voole.flume.sink.CanalSqlSink</br>
					agent.sinks.k1.datasync_plugin_version=${sync_version}</br>
					agent.sinks.k1.sync_code=${syncqc.sync_code}</br>
					</br>
					</br>
					启动命令</br>
					{FLUME_PATH}/bin/flume-ng agent --conf conf --conf-file conf/${syncqc.sync_code}.properties --name agent &</br>
 					
 				</lable>
 			</td>
 		</tr>
		


		 		
 		
 	</table>
</form>