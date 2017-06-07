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

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i>同步列表</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<table width="100%">
										<tr>
											<td width="80px;"><label>同步码：</label></td>
											<td><input type="text" id="cannl_code"/></td>
											<td width="80px;"><label>是否启用：</label></td>
											<td>
												<select id="isOnSelect">
												  <option value ="">请选择</option>
												  <option value ="1">是</option>
												  <option value="0">否</option>
												</select>
											</td>
											<td align="right">
												<button id="search_setttings" class="btn green">

												查&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
		
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

												新建同步 <i class="icon-plus"></i>
		
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

											<th>同步码</th>

											<th class="hidden-480">canal名称</th>
											<th class="hidden-480">规则名称</th>

											<th class="hidden-480">备注</th>

											<th class="hidden-480">状态</th>
											<th>操作</th>
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
	var ruletablesettings=gettables("iSync/querySyncList.do",[
	                                                       	            {
	                                                    	                "mData" : "sync_id",
	                                                    	                "sWidth" : "28px",
	                                                    	                "bSortable" : false,
	                                                    	                "aTargets" : [ 0 ]
	                                                    	            },{
	                                                    	                "mData" : "sync_code",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 1 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "canal_name",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 2 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "reg_name",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 3 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "sync_note",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 4 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "is_on",
	                                                    	                "sWidth" : "50px",
	                                                    	                "aTargets" : [ 5 ],
	                                                    	                "bSortable" : false,
	                                                    	                "mRender" :function(data,type,full){
	                                                    	                    var html='';
	                                                    	                    if(data == "0"){
	                                                    	                        html="<span style='color: red'>未启用</span>";
	                                                    	                    }else{
	                                                    	                        html="<span style='color: green'>启用</span>";
	                                                    	                    }
	                                                    	                    return html;
	                                                    	                }
	                                                    	            },{
	                                                    	                "mData" : "sync_id",
	                                                    	                "sClass" : "center",
	                                                    	                "sWidth" : "40px",
	                                                    	                "aTargets" : [ 6 ],
	                                                    	                "bSortable" : false,
	                                                    	               	"mRender" : function(data, type,full) {
	                                                    	               		var dHtml = "";
	                                                    	               		var dHtml = "";
	                                                    	          			dHtml+='<div class="btn-group">';
	                                                              				dHtml+='<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:;">';
	                                                           					dHtml+='工具 <i class="icon-angle-down"></i>';
	                                                       						dHtml+='</a>';
	                                                    						dHtml+='<ul class="dropdown-menu">';
	                                                    						dHtml+='<vooletag:permission url="iSync/toSyncConfigInfo.do"><li><a href="javascript:void(0)" onclick="turnmodalConditioninfo(\''+ data+ '\');"><i class="icon-edit"></i>&nbsp配置</a></li></vooletag:permission>';
	                                                    						dHtml+='<vooletag:permission url="iSync/toSyncinfo.do"><li><a href="javascript:void(0)" onclick="turnmodalgetinfo(\''+ data+ '\');"><i class="icon-edit"></i>&nbsp详情</a></li></vooletag:permission>';
	                                                    						dHtml+='<vooletag:permission url="iSync/toEditSync.do"><li><a href="javascript:void(0)" onclick="changvalue(\''+ data+ '\',\''+full.version+'\');"><i class="icon-edit"></i>&nbsp修改</a></li></vooletag:permission>';
	                                                    						if(full.is_on=="0"){
                                                                                    dHtml+='<vooletag:permission url="iSync/startSettings.do"><li><a href="javascript:void(0)" onclick="startSettings(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ok"></i>&nbsp启用</a></li></vooletag:permission>';
                                                                                }else{
		                                                    						dHtml+='<vooletag:permission url="iSync/forbidden.do"><li><a href="javascript:void(0)" onclick="forbidden(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ban-circle"></i>&nbsp禁用</a></li></vooletag:permission>';
                                                                                }
	                                                    						dHtml+='<vooletag:permission url="iSync/deleteSync.do"><li><a href="javascript:void(0)" onclick="deletesync(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ok"></i>&nbsp删除</a></li></vooletag:permission>';
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
	                                                    		                "name" : "sync_code",
	                                                    		                "value" : $.trim($("#cannl_code").val())
	                                                    		            },{
		                                                		                "name" : "is_on",
		                                                		                "value" : $.trim($("#isOnSelect").val())
	                                                		            });
	                                                    		        },'${tablesize == null ? 10 : tablesize}');
	$("#search_setttings").click(function(){
		$('#sample_1').dataTable( ruletablesettings).fnDraw();
	});
	function changvalue(id){
		$("#settings_model").modal("show");
		$("#settings_div").load("iSync/toEditSync.do",{"sync_id":id},function(){
			var formvalidate=bindformvalidate("#setting_form",{
				sync_code: {
		             required: true,
					synccodeonly: true
		         },
		         canal_id: {
		             required: true,
		         },
		         reg_id: {
		             required: true,
		         }
			   });
		 $("#settings_model .modal-footer button:last").unbind("click");
	     $("#settings_model .modal-footer button:last").click(function(){
	    	 if(formvalidate.form()){
		    	 $.ajax({
					   type: "POST",
					   url: "iSync/editSync.do",
					   data: $("#setting_form").serialize(),
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
			   url: "iSync/editSync.do",
			   data: "sync_id="+id+"&is_on=0&version="+version,
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
 			   url: "iSync/editSync.do",
 			   data: "sync_id="+id+"&is_on=1&version="+version,
 			   success: function(msg){
 				   alert(msg.info);
 				   if(msg.status){
 					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
 				   }
 			   }
 			});
        }
    }
	function deletesync(id,version){
		if(confirm("确认删除？")){
			$.ajax({
			   type: "POST",
			   url: "iSync/deleteSync.do",
			   data: "sync_id="+id+"&version="+version,
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
		$("#create_settings_model .modal-body").load("iSync/toCreateSync.do",null,function(){
			var formvalidate=bindformvalidate("#create_setting_form",{
				sync_code: {
					synccodeonly: true
		         },
		         canal_id: {
		             required: true,
		         },
		         reg_id: {
		             required: true,
		         }
			   });
		   $("#create_settings_model .modal-footer button:last").unbind("click");
		   $("#create_settings_model .modal-footer button:last").click(function(){
			   if(formvalidate.form()){
				   $.ajax({
					   type: "POST",
					   url: "iSync/addSync.do",
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
	
	function turnmodalgetinfo(id){
			$("#rule_info_model .modal-body").html("正在加载数据，请稍等……");
			$("#rule_info_model .modal-body").load("iSync/toSyncinfo.do",{"sync_id":id},function(){
				$("#rule_info_model").modal("show");
			});
	}
	
	function turnmodalConditioninfo(id){
			$("#con_info_model .modal-body").html("正在加载数据，请稍等……");
			$("#con_info_model .modal-body").load("iSync/toSyncConfigInfo.do",{"sync_id":id},function(){
				$("#con_info_model").modal("show");
			});
	}
	
	
	

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
						修改同步
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
						新增同步
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
			
			<!-- 按钮触发模态框 -->
			<div class="modal fade" id="rule_info_model" tabindex="-1" role="dialog" 
												   aria-labelledby="rule_info_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="rule_info_model_ModalLabel">
						同步信息
					</h4>
				 </div>
				 <div class="modal-body">
				 </div>
				 <div class="modal-footer">
					<button type="button" class="btn btn-default" 
					   data-dismiss="modal">关闭
					</button>
				 </div>
			  </div><!-- /.modal-content -->
			</div><!-- /.modal -->
			</div>
			
			
			
			<!-- 按钮触发模态框 -->
			<div class="modal fade" id="con_info_model" tabindex="-1" role="dialog" 
												   aria-labelledby="rule_info_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="rule_info_model_ModalLabel">
						配置信息
					</h4>
				 </div>
				 <div class="modal-body">
				 </div>
				 <div class="modal-footer">
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