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

						<div class="portlet box light-grey">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i>角色管理</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<table width="100%">
										<tr>
											<td width="80px;"><label>配置名称：</label></td>
											<td><input type="text" id="config_name"/></td>
											<td></td>
											<td></td>
											<td align="right">
												<button id="search_setttings" class="btn green">

												查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
		
												</button>
											</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td align="right">
											<vooletag:permission url="settingslist/createsettings.do">
												<button id="create_settings" class="btn green">

												新配置 <i class="icon-plus"></i>
		
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

											<th>配置名称</th>

											<th class="hidden-480">配置值</th>
											<th class="hidden-480">说明</th>

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
	var ruletablesettings=gettables("settingsController/querySettings.do",[
	                                                       	            {
	                                                    	                "mData" : "id",
	                                                    	                "sWidth" : "28px",
	                                                    	                "bSortable" : false,
	                                                    	                "aTargets" : [ 0 ]
	                                                    	            },{
	                                                    	                "mData" : "config_name",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 1 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "config_value",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 2 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "rmark",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 3 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "is_on",
	                                                    	                "sWidth" : "50px",
	                                                    	                "aTargets" : [ 4 ],
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
	                                                    	                "aTargets" : [ 5 ],
	                                                    	                "bSortable" : false,
	                                                    	                "mRender" :function(data,type,full){
	                                                    	                    return formatDate(data,"yyyy-MM-dd HH:mm");
	                                                    	                }
	                                                    	            },{
	                                                    	                "mData" : "id",
	                                                    	                "sClass" : "center",
	                                                    	                "sWidth" : "40px",
	                                                    	                "aTargets" : [ 6 ],
	                                                    	                "bSortable" : false,
	                                                    	               	"mRender" : function(data, type,full) {
	                                                    	               		var dHtml = "<a href=\"javascript:void(0)\" onclick=\"changvalue('+ data+ ','+full.version+');\" class=\"btn mini purple\"><i class=\"icon-edit\"></i>修改</a>";
	                                                    	               		var dHtml = "";
	                                                    	          			dHtml+='<div class="btn-group">';
	                                                              				dHtml+='<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:;">';
	                                                           					dHtml+='工具 <i class="icon-angle-down"></i>';
	                                                       						dHtml+='</a>';
	                                                    						dHtml+='<ul class="dropdown-menu">';
	                                                    						dHtml+='<vooletag:permission url="settingslist/changvalue.do"><li><a href="javascript:void(0)" onclick="changvalue(\''+ data+ '\',\''+full.version+'\');"><i class="icon-edit"></i>&nbsp编辑</a></li></vooletag:permission>';
	                                                    						dHtml+='<vooletag:permission url="settingslist/forbidden.do"><li><a href="javascript:void(0)" onclick="forbidden(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ban-circle"></i>&nbsp禁用</a></li></vooletag:permission>';
	                                                    						dHtml+='<vooletag:permission url="settingslist/startSettings.do"><li><a href="javascript:void(0)" onclick="startSettings(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ok"></i>&nbsp启用</a></li></vooletag:permission>';
	                                                    						dHtml+='</ul>';
	                                                    						dHtml+='</div>';
	                                                    	                    return dHtml;
	                                                    	                }
	                                                    	            },{
	                                                    	            	"mData" : "version",
	                                                    	            	"aTargets" : [ 7 ],
	                                                    	            	"fnCreatedCell" : function(nTd, sData, oData, iRow, iCol) {
	                                                    	           			$(nTd).css('display', 'none');
	                                                    	           		}
	                                                    	            }],function(aoData) {//重要设置，可通过此设置添加额外查询参数
	                                                    		            aoData.push({
	                                                    		                "name" : "config_name",
	                                                    		                "value" : $.trim($("#config_name").val())
	                                                    		            });
	                                                    		        },'${tablesize == null ? 10 : tablesize}');
	$("#search_setttings").click(function(){
		$('#sample_1').dataTable( ruletablesettings).fnDraw();
	});
	function changvalue(id,version){
		$("#settings_model").modal("show");
		$("#settings_div").load("settingsController/turnSettingsInfo.do",{"id":id},function(){
			var formvalidate=bindformvalidate("#setting_form",{
				config_name: {
		             required: true
		         },
		         config_value: {
		             required: true,
		         },
				   rmark: {
		             required: true
		         },
		         is_on: {
		             required: true,
		             digits:true
		         } 
			   });
		 $("#settings_model .modal-footer button:last").unbind("click");
	     $("#settings_model .modal-footer button:last").click(function(){
	    	 if(formvalidate.form()){
		    	 $.ajax({
					   type: "POST",
					   url: "settingsController/changvalue.do",
					   data: $("#setting_form").serialize()+"&id="+id+"&version="+version,
					   success: function(msg){
						   alert(msg.info);
						   if(msg.status){
							   $("#settings_model").modal("hide");
							   $('#sample_1').dataTable( ruletablesettings).fnDraw();
						   }
					   }
					});
	    	 }
	     });
		});
	}
	function forbidden(id,version){
		if(confirm("确认禁用？")){
			$.ajax({
			   type: "POST",
			   url: "settingsController/changvalue.do",
			   data: "id="+id+"&is_on=0&version="+version,
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
			   url: "settingsController/changvalue.do",
			   data: "id="+id+"&is_on=1&version="+version,
			   success: function(msg){
				   alert(msg.info);
				   if(msg.status){
					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
				   }
			   }
			});
		}
	}
	$("#create_settings").click(function(){
		$("#create_settings_model").modal("show");
		$("#create_settings_model .modal-body").html("正在加载数据，请稍等……");
		$("#create_settings_model .modal-body").load("settingsController/turnCreateSettings.do",null,function(){
			var formvalidate=bindformvalidate("#create_setting_form",{
				config_name: {
		             required: true
		         },
		         config_value: {
		             required: true,
		         }
			   },{
				   rmark: {
		             required: true
		         },
		         is_on: {
		             required: true,
		             digits:true
		         } 
			   });
		   $("#create_settings_model .modal-footer button:last").unbind("click");
		   $("#create_settings_model .modal-footer button:last").click(function(){
			   if(formvalidate.form()){
				   var rids="";
				   $("#chooserules input[name='rules']:checked").each(function(){
					   rids+=$(this).val()+",";
				   });
				   $.ajax({
					   type: "POST",
					   url: "settingsController/addSettings.do",
					   data:$("#create_setting_form").serialize(),
					   success: function(msg){
						   alert(msg.info);
	       				   if(msg.status){
	       					   $("#create_settings_model").modal("hide");
	       					   $("#create_settings_model .modal-footer button:last").unbind("click");
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
			<div class="modal fade" id="settings_model" tabindex="-1" role="dialog" 
												   aria-labelledby="settings_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="settings_model_ModalLabel">
						更改配置
					</h4>
				 </div>
				 <div class="modal-body">
				 	<div id="settings_div"></div>
				 </div>
				 <div class="modal-footer">
					<button type="button" class="btn btn-default" 
					   data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary">
					   确定
					</button>
				 </div>
			  </div><!-- /.modal-content -->
			</div><!-- /.modal -->
			</div>
	<!-- 按钮触发模态框 -->
			<div class="modal fade" id="create_settings_model" tabindex="-1" role="dialog" 
												   aria-labelledby="create_settings_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="create_settings_model_ModalLabel">
						新增配置
					</h4>
				 </div>
				 <div class="modal-body">
				 </div>
				 <div class="modal-footer">
					<button type="button" class="btn btn-default" 
					   data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary">
					   确定
					</button>
				 </div>
			  </div><!-- /.modal-content -->
			</div><!-- /.modal -->
			</div>
</body>
<!-- END BODY -->
</html>