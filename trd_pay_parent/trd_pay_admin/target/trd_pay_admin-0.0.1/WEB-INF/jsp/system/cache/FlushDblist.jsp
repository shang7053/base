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

								<div class="caption"><i class="icon-globe"></i>心跳缓存配置</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<table width="100%">
										<tr>
											<td width="80px;"><label>心跳间隔单位：</label></td>
											<td><select id="interval_unit" >
								 			  		<option value="">请选择</option>
								 			  		<option value="1">年</option>
								 					<option value="2">月</option>
								 					<option value="3">周</option>
								 					<option value="5">天</option>
								 					<option value="10">小时</option>
								 					<option value="12">分钟</option>
								 					<option value="13">秒</option>
								 				</select>
								 			</td>
											
											<td width="80px;"><label>是否启动：</label></td>
											<td>
												<select id="is_on">
													<option value="">请选择</option>
													<option value="0">失效</option>
													<option value="1">正常</option>
												</select>
											</td>
											<td align="right">
												<button id="search_setttings" class="btn green">

												查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
		
												</button>
											</td>
										</tr>
										<tr>
									
											<td width="80px;"><label></label></td>
											<td></td>
											<td width="80px;"><label></label></td>
											<td></td>
											<td align="right">
											<vooletag:permission url="flushdbController/addFlushDb.do">
												<button id="create_flushdb" class="btn green">

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

											
											<th class="hidden-480">上次ping通时间</th>
											<th class="hidden-480">心跳间隔</th>
											<th class="hidden-480">心跳间隔单位</th>
			

											<th class="hidden-480">是否启用</th>

											<th class="hidden-480">创建时间</th>
											<th class="hidden-480">修改时间</th>
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
	var ruletablesettings=gettables("flushdbController/queryFlushDb.do",[
																	           {
																	            "mData" : "id",
																	            "sWidth" : "28px",
																	            "bSortable" : false,
																	            "aTargets" : [ 0 ]
																	        },{
																	            "mData" : "last_ping_date",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 1 ],
																	            "bSortable" : false,
																	            "mRender" :function(data,type,full){
																	                return formatDate(data,"yyyy-MM-dd HH:mm");
																	            }
																	        },{
																	            "mData" : "flush_cache_interval",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 2 ],
																	            "bSortable" : false
																	        },{
																	            "mData" : "interval_unit",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 3 ],
																	            "bSortable" : false,
																	            "mRender" :function(data,type,full){
																	            	var html='';
																	            	switch(data){
																	            	 case 1: 
																	            		 html="<span style='color: green'>年</span>";
																	            		 return html;
																	            		 break;
																	            	 case 2:  
																	            		 html="<span style='color: green'>月</span>";
																	            		 return html;
																	            		 break;
																	            	 case 3:  
																	            		 html="<span style='color: green'>周</span>";
																	            		 return html;
																	            		 break;    
																	            	 case 5:  
																	            		 html="<span style='color: green'>天</span>";
																	            		 return html;
																	            		 break;
																	            	 case 10:  
																	            		 html="<span style='color: green'>小时</span>";
																	            		 return html;
																	            		 break;
																	            	 case 12:  
																	            		 html="<span style='color: green'>分钟</span>";
																	            		 return html;
																	            		 break;
																	            	 case 13:  
																	            		 html="<span style='color: green'>秒</span>";
																	            		 return html;
																	            		 break;
																	            	 default:  
																	            		 return html;
																	            	     break;
																	            	}
																	            }
																	            
																	        },{
																	            "mData" : "is_on",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 4 ],
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
																	            "mData" : "create_time",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 5 ],
																	            "bSortable" : false,
																	            "mRender" :function(data,type,full){
																	                return formatDate(data,"yyyy-MM-dd HH:mm");
																	            }
																	           
																	        },{
																	            "mData" : "update_time",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 6 ],
																	            "bSortable" : false,
																	            "mRender" :function(data,type,full){
																	                return formatDate(data,"yyyy-MM-dd HH:mm");
																	            }
																	        },{
																	            "mData" : "id",
																	            "sClass" : "center",
																	            "sWidth" : "40px",
																	            "aTargets" : [ 7 ],
																	            "bSortable" : false,
																	           	"mRender" : function(data, type,full) {
																	           		var dHtml = "";
																	      			dHtml+='<div class="btn-group">';
																	  				dHtml+='<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:;">';
																						dHtml+='工具 <i class="icon-angle-down"></i>';
																						dHtml+='</a>';
																					dHtml+='<ul class="dropdown-menu">';
																					
																					dHtml+='<vooletag:permission url="syncstatisticsController/turnsyncstatisticsInfo.do"><li><a href="javascript:void(0)" onclick="showinfo(\''+ data+ '\');"><i class="icon-info"></i>&nbsp详情</a></li></vooletag:permission>';
																					dHtml+='<vooletag:permission url="flushdbController/changvalue.do"><li><a href="javascript:void(0)" onclick="changvalue(\''+ data+ '\');"><i class="icon-edit"></i>&nbsp编辑</a></li></vooletag:permission>';
																					if(full.is_on=="0"){
																						dHtml+='<vooletag:permission url="flushdbController/startSettings.do"><li><a href="javascript:void(0)" onclick="startSettings(\''+ data+ '\');"><i class="icon-ok"></i>&nbsp启用</a></li></vooletag:permission>';
																					}else{
																						dHtml+='<vooletag:permission url="flushdbController/forbidden.do"><li><a href="javascript:void(0)" onclick="forbidden(\''+ data+ '\');"><i class="icon-ban-circle"></i>&nbsp禁用</a></li></vooletag:permission>';
																					}
																					dHtml+='<vooletag:permission url="flushdbController/delFlushDb.do"><li><a href="javascript:void(0)" onclick="delds(\''+ data+ '\');"><i class="icon-edit"></i>&nbsp删除</a></li></vooletag:permission>';
																					dHtml+='</ul>';
																					dHtml+='</div>';
																	                return dHtml;
																	            }}
																		        ],function(aoData) {//重要设置，可通过此设置添加额外查询参数
																		            aoData.push({
																		                "name" : "interval_unit",
																		                "value" : $.trim($("#interval_unit").val())
																		            },{
																		                "name" : "is_on",
																		                "value" : $.trim($("#is_on").val())
																		            });
																		        },'${tablesize == null ? 10 : tablesize}');
$("#search_setttings").click(function(){
$('#sample_1').dataTable( ruletablesettings).fnDraw();
});
	function changvalue(id){
		$("#flushdb_model").modal("show");
		$("#flushdb_div").load("flushdbController/turnFlushDbInfo.do",{"id":id},function(){
			var formvalidate=bindformvalidate("#flushdb_form",{
				
		         last_ping_date: {
		             required: true
		            
		         },
		         flush_cache_interval: {
		             required: true,
		             digits:true
		         },
		         interval_unit: {
		             required: true
		            
		         },
		         is_on: {
		             required: true,
		             digits:true
		         }
			   });
		 $("#flushdb_model .modal-footer button:first").show();
		 $("#flushdb_model .modal-footer button:eq(1)").show();
		 $("#flushdb_model .modal-footer button:first").unbind("click");
	     $("#flushdb_model .modal-footer button:first").click(function(){
	    	 if(formvalidate.form()){
		    	 $.ajax({
					   type: "POST",
					   url: "flushdbController/changvalue.do",
					   data: $("#flushdb_form").serialize()+"&id="+id,
					   success: function(mve){
						   if(mve.status){
							   toastr.success(mve.info);
							   $("#flushdb_model").modal("hide");
							   $('#sample_1').dataTable( ruletablesettings).fnDraw();
						   }else{
	                        	toastr.error(mve.info);
                           }
					   }
					});
	    	 }
	     });
		});
	}
	function showinfo(id){
		$("#flushdb_model").modal("show");
		$("#flushdb_model .modal-title").html("详情");
		$("#flushdb_div").load("flushdbController/turnFlushDbInfo.do",{"id":id},function(){
			$("#flushdb_form tr:hidden").show();
			$("#flushdb_model .modal-footer button:first").hide();
			$("#flushdb_model .modal-footer button:eq(1)").hide();
		});
	}
	function forbidden(id){
		if(confirm("确认禁用？")){
			$.ajax({
			   type: "POST",
			   url: "flushdbController/changvalue.do",
			   data: "id="+id+"&is_on=0",
			   success: function(mve){
				   if(mve.status){
					   toastr.success(mve.info);
					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
				   }else{
                   	toastr.error(mve.info);
                   }
			   }
			});
		}
	}
	function startSettings(id){
		if(confirm("确认启用？")){
			$.ajax({
			   type: "POST",
			   url: "flushdbController/changvalue.do",
			   data: "id="+id+"&is_on=1",
			   success: function(mve){
				   if(mve.status){
					   toastr.success(mve.info);
					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
				   }else{
                   	toastr.error(mve.info);
                   }
			   }
			});
		}
	}
	function delds(id){
		if(confirm("确认删除？")){
			$.ajax({
			   type: "POST",
			   url: "flushdbController/delFlushDb.do",
			   data: "id="+id,
			   success: function(mve){
				   if(mve.status){
					   toastr.success(mve.info);
					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
				   }else{
                   	toastr.error(mve.info);
                   }
			   }
			});
		}
	}
	$("#create_flushdb").click(function(){
		$("#create_flushdb_model").modal("show");
		$("#create_flushdb_model .modal-body").html("正在加载数据，请稍等……");
		$("#create_flushdb_model .modal-body").load("flushdbController/turnCreateFlushDb.do",null,function(){
			var formvalidate=bindformvalidate("#create_flushdb_form",{
				last_ping_date: {
					required: true,
		         },
		         flush_cache_interval: {
		             required: true,
		         },
		         is_on: {
		             required: true,
		             digits:true
		         },
		         interval_unit: {
		             required: true,
		             digits:true
		         }
			   });
		   $("#create_flushdb_model .modal-footer button:first").unbind("click");
		   $("#create_flushdb_model .modal-footer button:first").click(function(){
			  
				   $.ajax({
					   type: "POST",
					   url: "flushdbController/addFlushDb.do",
					   data:$("#create_flushdb_form").serialize(),
					   success: function(mve){
						   if(mve.status){
							   toastr.success(mve.info);
	       					   $("#create_flushdb_model").modal("hide");
	       					   $("#create_flushdb_model .modal-footer button:first").unbind("click");
	       					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
	       				   }else{
	                        	toastr.error(mve.info);
                           }
					   }
			   });
			   
	   		});
		});
	});
	TableManaged.init(ruletablesettings);
	
	
	</script>
	<!-- 按钮触发模态框 -->
			<div class="modal fade" id="flushdb_model" tabindex="-1" role="dialog" 
												   aria-labelledby="flushdb_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="flushdb_model_ModalLabel">
						更改配置
					</h4>
				 </div>
				 <div class="modal-body">
				 	<div id="flushdb_div"></div>
				 </div>
				 <div class="modal-footer">
					<button type="button" class="btn btn-primary">
					   修改
					</button>
					<button type="button" class="btn btn-default" 
					   data-dismiss="modal">关闭
					</button>
				 </div>
			  </div><!-- /.modal-content -->
			</div><!-- /.modal -->
			</div>
	<!-- 按钮触发模态框 -->
			<div class="modal fade" id="create_flushdb_model" tabindex="-1" role="dialog" 
												   aria-labelledby="create_flushdb_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="create_flushdb_model_ModalLabel">
						新增配置
					</h4>
				 </div>
				 <div class="modal-body">
				 </div>
				 <div class="modal-footer">
					<button type="button" class="btn btn-primary">
					   提交
					</button>
					<button type="button" class="btn btn-default" 
					   data-dismiss="modal">关闭
					</button>
				 </div>
			  </div><!-- /.modal-content -->
			</div><!-- /.modal -->
			</div>
</body>
</html>