<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery-easyui-1.3.2/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.2/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.2/themes/icon.css">
		<script type="text/javascript">
		var familyJson = eval("("+'[{"age":50,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72418,"mobile":"13904168177","name":"唐军","relation":"b","type":0},{"age":49,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72419,"mobile":"13500465958","name":"敖鹏","relation":"c","type":0},{"age":50,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72420,"mobile":"13904168177","name":"唐军","relation":"b","type":0},{"age":49,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72421,"mobile":"13500465958","name":"敖鹏","relation":"c","type":0},{"age":50,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72422,"mobile":"13904168177","name":"唐军","relation":"b","type":0},{"age":49,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72423,"mobile":"13500465958","name":"敖鹏","relation":"c","type":0},{"age":50,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72424,"mobile":"13904168177","name":"唐军","relation":"b","type":0},{"age":49,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72425,"mobile":"13500465958","name":"敖鹏","relation":"c","type":0},{"age":50,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72426,"mobile":"13904168177","name":"唐军","relation":"b","type":0},{"age":49,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72427,"mobile":"13500465958","name":"敖鹏","relation":"c","type":0}]'==''?'[]':'[{"age":50,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72418,"mobile":"13904168177","name":"唐军","relation":"b","type":0},{"age":49,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72419,"mobile":"13500465958","name":"敖鹏","relation":"c","type":0},{"age":50,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72420,"mobile":"13904168177","name":"唐军","relation":"b","type":0},{"age":49,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72421,"mobile":"13500465958","name":"敖鹏","relation":"c","type":0},{"age":50,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72422,"mobile":"13904168177","name":"唐军","relation":"b","type":0},{"age":49,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72423,"mobile":"13500465958","name":"敖鹏","relation":"c","type":0},{"age":50,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72424,"mobile":"13904168177","name":"唐军","relation":"b","type":0},{"age":49,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72425,"mobile":"13500465958","name":"敖鹏","relation":"c","type":0},{"age":50,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72426,"mobile":"13904168177","name":"唐军","relation":"b","type":0},{"age":49,"company":"个体","customer_id":338596,"home_address":"锦州市凌河区南京路五段9号","id":72427,"mobile":"13500465958","name":"敖鹏","relation":"c","type":0}]'+")");
	</script>
  </head>
  
  <body>
   		<table id="family" class="easyui-datagrid" title="家庭成员信息"
						data-options="singleSelect:true,data:familyJson" style="width:auto">
					    <thead>   
					        <tr> 
					            <th data-options="width:80,field:'name'">姓名</th>   
					            <th data-options="width:100,field:'card_no'">身份证号</th>   
					            <th data-options="width:100,
					            	formatter: function(value,row){
										if(value=='b'){
											return '父亲';
										}else if(value=='c'){
											return '母亲';
										}else if(value=='e'){
											return '儿子';
										}else if(value=='f'){
											return '女儿';
										}else if(value=='g'){
											return '哥哥';
										}else if(value=='h'){
											return '姐姐';
										}else if(value=='i'){
											return '弟弟';
										}else if(value=='j'){
											return '妹妹';
										}
									},
						            editor:{
						            		type:'combobox',
								            options:{
								            	valueField: 'value',
												textField: 'text',
												editable:false,
												data: [{
													value: 'b',
													text: '父亲'
												},{
													value: 'c',
													text: '母亲'
												},{
													value: 'e',
													text: '儿子'
												},{
													value: 'f',
													text: '女儿'
												},{
													value: 'g',
													text: '哥哥'
												},{
													value: 'h',
													text: '姐姐'
												},{
													value: 'i',
													text: '弟弟'
												},{
													value: 'j',
													text: '妹妹'
												}]
								            }
						            },field:'relation'">与借款人关系</th>  
					            <th data-options="width:80,field:'age'">年龄</th>   
					            <th data-options="width:150,field:'company'">工作单位</th>   
					            <th data-options="width:150,field:'home_address'">家庭住址</th>
					            <th data-options="width:100,field:'mobile'">联系电话</th>
					            <th data-options="width:100,
					            	formatter: function(value,row){
										if(value==''){
											return '（空）';
										}else if(value=='1'){
											return '是';
										}else{
											return '否';
										}
									},field:'loan_informed'">是否知情</th>
					        </tr>   
					    </thead>   
					</table>
  </body>
</html>
