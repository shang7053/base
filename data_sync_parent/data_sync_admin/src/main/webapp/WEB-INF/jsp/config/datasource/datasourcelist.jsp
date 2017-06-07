<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="vooletag" uri="http://tag.voole.com/" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />
<link rel="stylesheet" href="media/css/DT_bootstrap.css" />
	<script src="media/js/jquery.validate.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="media/js/formvalidate.js"></script>
<!-- END PAGE LEVEL STYLES -->
<link rel="shortcut icon" href="media/image/favicon.ico" />
</head>
<!-- BEGIN BODY -->

<body class="page-header-fixed">

			<!-- BEGIN PAGE CONTAINER-->        

			<div class="container-fluid">

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box light-grey" style="min-height: 550px;">

							<div class="portlet-title" >

								<div class="caption"><i class="icon-globe"></i>数据源配置</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<table width="100%">
										<tr>
											<td width="80px;"><label>数据源名称：</label></td>
											<td><input type="text" id="ds_name"/></td>
											<td width="80px;"><label>IP：</label></td>
											<td><input type="text" id="ds_ip"/></td>
											<td align="right">
												<button id="search_setttings" class="btn green">

												查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
		
												</button>
											</td>
										</tr>
										<tr>
											<td width="80px;"><label>数据库名称：</label></td>
											<td><input type="text" id="ds_dbname"/></td>
											<td width="80px;"><label>状态：</label></td>
											<td>
												<select id="ds_status">
													<option value="">请选择</option>
													<option value="0">失效</option>
													<option value="1">正常</option>
												</select>
											</td>
											<td align="right">
											<vooletag:permission url="dataSourceController/turnCreateDataSource.do">
												<button id="create_datasource" class="btn green">

												新建 <i class="icon-plus"></i>
		
												</button>
											</vooletag:permission>
											</td>
										</tr>
									</table>

								</div>

								<table class="table table-striped table-bordered table-hover" id="sample_1">

									<thead>

										<tr>

											<th style="width:8px;">序号</th>

											<th>数据源名称</th>

											<th class="hidden-480">ip</th>
											<th class="hidden-480">端口</th>
											<th class="hidden-480">数据库名称</th>
											<th class="hidden-480">数据源状态</th>
											<th class="hidden-480">验证时间</th>

											<th class="hidden-480">是否启用</th>

											<th class="hidden-480">创建时间</th>
											<th>操作</th>
											<th style="display: none;">版本</th>
										</tr>

									</thead>

									<tbody>

									</tbody>

								</table>

							</div>

						</div>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>
				<!-- END PAGE CONTENT-->

			</div>

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script type="text/javascript" src="media/js/select2.min.js"></script>

	<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script> 

	<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>
<script src="media/js/datatableutil.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/table-managed.js"></script>     

	<script>
	var ruletablesettings=gettables("dataSourceController/queryDataSource.do",[
	                                                       	            {
	                                                    	                "mData" : "ds_id",
	                                                    	                "sWidth" : "28px",
	                                                    	                "bSortable" : false,
	                                                    	                "aTargets" : [ 0 ]
	                                                    	            },{
	                                                    	                "mData" : "ds_name",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 1 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "ds_ip",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 2 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "ds_port",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 3 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "ds_dbname",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 4 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "ds_status",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 5 ],
	                                                    	                "bSortable" : false,
	                                                    	                "mRender" :function(data,type,full){
	                                                    	                    var html='';
	                                                    	                    if(data == "0"){
	                                                    	                        html="<span style='color: red'>失效</span>";
	                                                    	                    }else{
	                                                    	                        html="<span style='color: green'>正常</span>";
	                                                    	                    }
	                                                    	                    return html;
	                                                    	                }
	                                                    	            },{
	                                                    	                "mData" : "validate_time",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 6 ],
	                                                    	                "bSortable" : false,
	                                                    	                "mRender" :function(data,type,full){
	                                                    	                    return formatDate(data,"yyyy-MM-dd HH:mm");
	                                                    	                }
	                                                    	            },{
	                                                    	                "mData" : "is_on",
	                                                    	                "sWidth" : "50px",
	                                                    	                "aTargets" : [ 7 ],
	                                                    	                "bSortable" : false,
	                                                    	                "mRender" :function(data,type,full){
	                                                    	                    var html='';
	                                                    	                    if(data == "0"){
	                                                    	                        html="<span style='color: red'>否</span>";
	                                                    	                    }else{
	                                                    	                        html="<span style='color: green'>是</span>";
	                                                    	                    }
	                                                    	                    return html;
	                                                    	                }
	                                                    	            },{
	                                                    	                "mData" : "create_time",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 8 ],
	                                                    	                "bSortable" : false,
	                                                    	                "mRender" :function(data,type,full){
	                                                    	                    return formatDate(data,"yyyy-MM-dd HH:mm");
	                                                    	                }
	                                                    	            },{
	                                                    	                "mData" : "ds_id",
	                                                    	                "sClass" : "center",
	                                                    	                "sWidth" : "40px",
	                                                    	                "aTargets" : [ 9 ],
	                                                    	                "bSortable" : false,
	                                                    	               	"mRender" : function(data, type,full) {
	                                                    	               		var dHtml = "";
	                                                    	          			dHtml+='<div class="btn-group">';
	                                                              				dHtml+='<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:;">';
	                                                           					dHtml+='工具 <i class="icon-angle-down"></i>';
	                                                       						dHtml+='</a>';
	                                                    						dHtml+='<ul class="dropdown-menu">';
	                                                    						dHtml+='<vooletag:permission url="dataSourceController/validate.do"><li><a href="javascript:void(0)" onclick="validate(\''+ data+'\',\''+full.ds_ip+ '\',\''+full.ds_port+'\',\''+full.ds_dbname+'\',\''+full.ds_uname+'\',\''+full.ds_pwd+'\',\''+full.version+'\');"><i class="icon-edit"></i>&nbsp验证</a></li></vooletag:permission>';
	                                                    						dHtml+='<vooletag:permission url="dataSourceController/turnDataSourceInfo.do"><li><a href="javascript:void(0)" onclick="showinfo(\''+ data+ '\',\''+full.version+'\');"><i class="icon-edit"></i>&nbsp查看</a></li></vooletag:permission>';
	                                                    						dHtml+='<vooletag:permission url="dataSourceController/changvalue.do"><li><a href="javascript:void(0)" onclick="changvalue(\''+ data+ '\',\''+full.version+'\');"><i class="icon-edit"></i>&nbsp编辑</a></li></vooletag:permission>';
	                                                    						if(full.is_on=="0"){
		                                                    						dHtml+='<vooletag:permission url="dataSourceController/startSettings.do"><li><a href="javascript:void(0)" onclick="startSettings(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ok"></i>&nbsp启用</a></li></vooletag:permission>';
	                                                    						}else{
		                                                    						dHtml+='<vooletag:permission url="dataSourceController/forbidden.do"><li><a href="javascript:void(0)" onclick="forbidden(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ban-circle"></i>&nbsp禁用</a></li></vooletag:permission>';
	                                                    						}
	                                                    						dHtml+='</ul>';
	                                                    						dHtml+='</div>';
	                                                    	                    return dHtml;
	                                                    	                }
	                                                    	            },{
	                                                    	            	"mData" : "version",
	                                                    	            	"aTargets" : [ 10 ],
	                                                    	            	"fnCreatedCell" : function(nTd, sData, oData, iRow, iCol) {
	                                                    	           			$(nTd).css('display', 'none');
	                                                    	           		}
	                                                    	            }],function(aoData) {//重要设置，可通过此设置添加额外查询参数
	                                                    		            aoData.push({
	                                                    		                "name" : "ds_name",
	                                                    		                "value" : $.trim($("#ds_name").val())
	                                                    		            },{
	                                                    		                "name" : "ds_dbname",
	                                                    		                "value" : $.trim($("#ds_dbname").val())
	                                                    		            },{
	                                                    		                "name" : "ds_ip",
	                                                    		                "value" : $.trim($("#ds_ip").val())
	                                                    		            },{
	                                                    		                "name" : "ds_status",
	                                                    		                "value" : $.trim($("#ds_status").val())
	                                                    		            });
	                                                    		        },'${tablesize == null ? 10 : tablesize}');
	$("#search_setttings").click(function(){
		$('#sample_1').dataTable( ruletablesettings).fnDraw();
	});
	function changvalue(id,version){
		$("#datasource_model").modal("show");
		$("#datasource_div").load("dataSourceController/turnDataSourceInfo.do",{"ds_id":id},function(){
			var formvalidate=bindformvalidate("#datasource_form",{
		         ds_ip: {
		             required: true,
		         },
				 ds_port: {
		             required: true,
		             digits:true
		         },
		         ds_dbname: {
		             required: true
		         },
		         ds_uname: {
		             required: true
		         },
		         ds_pwd: {
		             required: true
		         } 
			   });
		 $("#datasource_model .modal-footer button:first").show();
		 $("#datasource_model .modal-footer button:eq(1)").show();
		 $("#datasource_model .modal-footer button:first").unbind("click");
	     $("#datasource_model .modal-footer button:first").click(function(){
	    	 if(formvalidate.form()){
		    	 $.ajax({
					   type: "POST",
					   url: "dataSourceController/changvalue.do",
					   data: $("#datasource_form").serialize()+"&ds_id="+id+"&version="+version,
					   success: function(msg){
						   alert(msg.info);
						   if(msg.status){
							   $("#datasource_model").modal("hide");
							   $('#sample_1').dataTable( ruletablesettings).fnDraw();
						   }
					   }
					});
	    	 }
	     });
		});
	}
	function showinfo(id,version){
		$("#datasource_model").modal("show");
		$("#datasource_model .modal-title").html("详情");
		$("#datasource_div").load("dataSourceController/turnDataSourceInfo.do",{"ds_id":id},function(){
			$("#datasource_form tr:hidden").show();
			$("#datasource_model .modal-footer button:first").hide();
			$("#datasource_model .modal-footer button:eq(1)").hide();
		});
	}
	function validate(id,ds_ip,ds_port,ds_dbname,ds_uname,ds_pwd,version){
		$.ajax({
		   type: "POST",
		   url: "dataSourceController/validate.do",
		   data: "ds_id="+id+"&ds_ip="+ds_ip+"&ds_port="+ds_port+"&ds_dbname="+ds_dbname+"&ds_uname="+ds_uname+"&ds_pwd="+ds_pwd+"&version="+version,
		   success: function(msg){
			   alert(msg.info);
			   $('#sample_1').dataTable( ruletablesettings).fnDraw();
		   }
		});
	}
	$("#create_datasource_model .modal-footer button:eq(1)").click(function(){
		var ds_ip=$("#create_datasource_form input[name='ds_ip']").val();
		var ds_port=$("#create_datasource_form input[name='ds_port']").val();
		var ds_dbname=$("#create_datasource_form input[name='ds_dbname']").val();
		var ds_uname=$("#create_datasource_form input[name='ds_uname']").val();
		var ds_pwd=$("#create_datasource_form input[name='ds_pwd']").val();
		$.ajax({
			   type: "POST",
			   url: "dataSourceController/validate.do",
			   data: "ds_ip="+ds_ip+"&ds_port="+ds_port+"&ds_dbname="+ds_dbname+"&ds_uname="+ds_uname+"&ds_pwd="+ds_pwd,
			   success: function(msg){
				   alert(msg.info);
				   if(msg.status){
					   $("#create_datasource_form input[name='ds_status']").val("1");
				   }else{
					   $("#create_datasource_form input[name='ds_status']").val("0");
				   }
			   }
			});
	});
	$("#datasource_model .modal-footer button:eq(1)").click(function(){
		var ds_ip=$("#datasource_form input[name='ds_ip']").val();
		var ds_port=$("#datasource_form input[name='ds_port']").val();
		var ds_dbname=$("#datasource_form input[name='ds_dbname']").val();
		var ds_uname=$("#datasource_form input[name='ds_uname']").val();
		var ds_pwd=$("#datasource_form input[name='ds_pwd']").val();
		$.ajax({
			   type: "POST",
			   url: "dataSourceController/validate.do",
			   data: "ds_ip="+ds_ip+"&ds_port="+ds_port+"&ds_dbname="+ds_dbname+"&ds_uname="+ds_uname+"&ds_pwd="+ds_pwd,
			   success: function(msg){
				   alert(msg.info);
				   if(msg.status){
					   $("#datasource_form input[name='ds_status']").val("1");
				   }else{
					   $("#datasource_form input[name='ds_status']").val("0");
				   }
			   }
			});
	});
	function forbidden(id,version){
		if(confirm("确认禁用？")){
			$.ajax({
			   type: "POST",
			   url: "dataSourceController/changvalue.do",
			   data: "ds_id="+id+"&is_on=0&version="+version,
			   success: function(msg){
				   alert(msg.info);
				   if(msg.status){
					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
				   }
			   }
			});
		}
	}
	function startSettings(id,version){
		if(confirm("确认启用？")){
			$.ajax({
			   type: "POST",
			   url: "dataSourceController/changvalue.do",
			   data: "ds_id="+id+"&is_on=1&version="+version,
			   success: function(msg){
				   alert(msg.info);
				   if(msg.status){
					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
				   }
			   }
			});
		}
	}
	function delds(id,version){
		if(confirm("确认删除？")){
			$.ajax({
			   type: "POST",
			   url: "dataSourceController/delds.do",
			   data: "ds_id="+id+"&version="+version,
			   success: function(msg){
				   alert(msg.info);
				   if(msg.status){
					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
				   }
			   }
			});
		}
	}
	$("#create_datasource").click(function(){
		$("#create_datasource_model").modal("show");
		$("#create_datasource_model .modal-body").html("正在加载数据，请稍等……");
		$("#create_datasource_model .modal-body").load("dataSourceController/turnCreateDataSource.do",null,function(){
			var formvalidate=bindformvalidate("#create_datasource_form",{
				ds_name: {
					dsnameonly: true
		         },
		         ds_ip: {
		             required: true,
		         },
				 ds_port: {
		             required: true,
		             digits:true
		         },
		         ds_dbname: {
		             required: true
		         },
		         ds_uname: {
		             required: true
		         },
		         ds_pwd: {
		             required: true
		         } 
			   });
		   $("#create_datasource_model .modal-footer button:first").unbind("click");
		   $("#create_datasource_model .modal-footer button:first").click(function(){
			   if(formvalidate.form()){
				   $.ajax({
					   type: "POST",
					   url: "dataSourceController/addDataSource.do",
					   data:$("#create_datasource_form").serialize(),
					   success: function(msg){
						   alert(msg.info);
	       				   if(msg.status){
	       					   $("#create_datasource_model").modal("hide");
	       					   $("#create_datasource_model .modal-footer button:first").unbind("click");
	       					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
	       				   }
					   }
				   });
			   }
	   		});
		});
	});
	TableManaged.init(ruletablesettings);

	</script>
	<!-- 按钮触发模态框 -->
			<div class="modal fade" id="datasource_model" tabindex="-1" role="dialog" 
												   aria-labelledby="datasource_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="datasource_model_ModalLabel">
						更改配置
					</h4>
				 </div>
				 <div class="modal-body">
				 	<div id="datasource_div"></div>
				 </div>
				 <div class="modal-footer">
					<button type="button" class="btn btn-primary">
					   修改
					</button>
					<button type="button" class="btn btn-primary">
					   验证
					</button>
					<button type="button" class="btn btn-default" 
					   data-dismiss="modal">关闭
					</button>
				 </div>
			  </div><!-- /.modal-content -->
			</div><!-- /.modal -->
			</div>
	<!-- 按钮触发模态框 -->
			<div class="modal fade" id="create_datasource_model" tabindex="-1" role="dialog" 
												   aria-labelledby="create_datasource_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="create_datasource_model_ModalLabel">
						新增配置
					</h4>
				 </div>
				 <div class="modal-body">
				 </div>
				 <div class="modal-footer">
					<button type="button" class="btn btn-primary">
					   提交
					</button>
					<button type="button" class="btn btn-primary">
					   验证
					</button>
					<button type="button" class="btn btn-default" 
					   data-dismiss="modal">关闭
					</button>
				 </div>
			  </div><!-- /.modal-content -->
			</div><!-- /.modal -->
			</div>
</body>
<!-- END BODY -->
</html>