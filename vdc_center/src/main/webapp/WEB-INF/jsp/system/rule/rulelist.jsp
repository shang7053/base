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
<!-- END PAGE LEVEL STYLES -->
<link rel="shortcut icon" href="media/image/favicon.ico" />
<link href="media/js/dist/themes/default/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="media/js/dist/jstree.min.js"></script>
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
											<td width="80px;"><label>角色名称：</label></td>
											<td><input type="text" id="rname"/></td>
											<td></td>
											<td></td>
											<td align="right">
												<vooletag:permission url="rulelist/createrule.do">
												<button id="search_rule" class="btn green">

												查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
		
												</button>
												</vooletag:permission>
											</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td align="right">
												<button id="create_rule" class="btn green">

												新角色 <i class="icon-plus"></i>
		
												</button>
											</td>
										</tr>
									</table>

								</div>

								<table class="table table-striped table-bordered table-hover" id="sample_1">

									<thead>

										<tr>

											<th style="width:8px;">序号</th>

											<th>角色名称</th>

											<th class="hidden-480">是否启用</th>

											<th class="hidden-480">是否接收消息</th>

											<th class="hidden-480">创建时间</th>
											<th class="hidden-480">更新时间</th>
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
<script src="media/js/jquery.validate.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="media/js/formvalidate.js"></script>
<script src="media/js/datatableutil.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/table-managed.js"></script>     

	<script>
	var ruletablesettings=gettables("ruleController/queryRule.do",[
	                                               	            {
	                                            	                "mData" : "rid",
	                                            	                "sWidth" : "28px",
	                                            	                "bSortable" : false,
	                                            	                "aTargets" : [ 0 ]
	                                            	            },{
	                                            	                "mData" : "rname",
	                                            	                "sWidth" : "100px",
	                                            	                "aTargets" : [ 1 ],
	                                            	                "bSortable" : false
	                                            	            },{
	                                            	                "mData" : "is_on",
	                                            	                "sWidth" : "50px",
	                                            	                "aTargets" : [ 2 ],
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
	                                            	                "mData" : "is_recive_notice",
	                                            	                "sWidth" : "50px",
	                                            	                "aTargets" : [ 3 ],
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
	                                            	                "aTargets" : [ 4 ],
	                                            	                "bSortable" : false,
	                                            	                "mRender" :function(data,type,full){
	                                            	                    return formatDate(data,"yyyy-MM-dd HH:mm");
	                                            	                }
	                                            	            },{
	                                            	                "mData" : "update_time",
	                                            	                "sWidth" : "100px",
	                                            	                "aTargets" : [ 5 ],
	                                            	                "bSortable" : false,
	                                            	                "mRender" :function(data,type,full){
	                                            	                    return formatDate(data,"yyyy-MM-dd HH:mm");
	                                            	                }
	                                            	            },{
	                                            	                "mData" : "rid",
	                                            	                "sClass" : "center",
	                                            	                "sWidth" : "40px",
	                                            	                "aTargets" : [ 6 ],
	                                            	                "bSortable" : false,
	                                            	               	"mRender" : function(data, type,full) {
	                                            	          			var dHtml = "";
	                                            	          			dHtml+='<div class="btn-group">';
	                                                      				dHtml+='<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:;">';
	                                                   					dHtml+='工具 <i class="icon-angle-down"></i>';
	                                               						dHtml+='</a>';
	                                            						dHtml+='<ul class="dropdown-menu">';
	                                            						dHtml+='<vooletag:permission url="rulelist/turnmodalgetinfo.do"><li><a href="javascript:void(0)" onclick="turnmodalgetinfo(\''+ data+ '\',this);"><i class="icon-reorder"></i>&nbsp查看</a></li></vooletag:permission>';
	                                            						dHtml+='<vooletag:permission url="rulelist/turnmodal.do"><li><a href="javascript:void(0)" onclick="turnmodal(\''+ data+ '\',this);"><i class="icon-edit"></i>&nbsp赋予</a></li></vooletag:permission>';
	                                            						dHtml+='<vooletag:permission url="rulelist/freezerule.do"><li><a href="javascript:void(0)" onclick="freezerule(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ban-circle"></i>&nbsp禁用</a></li></vooletag:permission>';
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
	                                            	            }],function(oSettings) {
	                                            		            var that = this;
	                                            		            this.$('td:first-child', {"filter" : "applied"}).each(function(i) {
	                                            		                that.fnUpdate(i + 1,this.parentNode, 0,false, false);
	                                            		            });
	                                            		            jQuery('#sample_1_wrapper .dataTables_filter input').addClass("m-wrap medium"); // modify table search input
	                                            		            jQuery('#sample_1_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
	                                            		            jQuery('#sample_1_wrapper .dataTables_length select').select2(); // initialzie select2 dropdown
	                                            		        },'${tablesize == null ? 10 : tablesize}');
		function turnmodalgetinfo(rid,dom){
			$("#rule_info_model .modal-body").html("正在加载数据，请稍等……");
			$("#rule_info_model .modal-body").load("ruleController/turnRuleInfo.do",{"rid":rid},function(){
				if($('#rule_info_choosenodetree').jstree(true)){
					$('#rule_info_choosenodetree').jstree(true).destroy();
				}
				$.ajax({
					   type: "POST",
					   url: "functionController/getFunctions.do",
					   success: function(msg){
						   $('#rule_info_choosenodetree').jstree({
							   'checkbox' : {
									'three_state' : false,
								},
								'plugins' : [ "wholerow", "checkbox" ],
								'core' : {
									'data' : msg,
									'themes' : {
										'icons' : false
									}

								}
							});
						   $('#rule_info_choosenodetree').on("ready.jstree",function(e, data) {
							   $.ajax({
								   type: "POST",
								   url: "functionController/queryFunctionIds.do",
								   data:"rid="+rid,
								   success: function(msg){
										$("#rule_info_choosenodetree").jstree("open_all");
									   for(var i=0;i<msg.length;i++){
											$('#rule_info_choosenodetree').jstree(true).check_node(msg[i].fid);
									   }
										$("#rule_info_choosenodetree").jstree("close_all");
								   }
								});
							});
						   $("#rule_info_model").modal("show");
					   }
				   });
			});
		}
		function turnmodal(rid,dom){
			if($('#choosenodetree').jstree(true)){
				$('#choosenodetree').jstree(true).destroy();
			}
			$.ajax({
			   type: "POST",
			   url: "functionController/getFunctions.do",
			   success: function(msg){
				   $('#choosenodetree').jstree({
					   'checkbox' : {
							'three_state' : false,
						},
						'plugins' : [ "wholerow", "checkbox" ],
						'core' : {
							'data' : msg,
							'themes' : {
								'icons' : false
							}

						}
					});
				   $('#choosenodetree').on("ready.jstree",function(e, data) {
					   $.ajax({
						   type: "POST",
						   url: "functionController/queryFunctionIds.do",
						   data:"rid="+rid,
						   success: function(msg){
								$("#choosenodetree").jstree("open_all");
							   for(var i=0;i<msg.length;i++){
									$('#choosenodetree').jstree(true).check_node(msg[i].fid);
							   }
								$("#choosenodetree").jstree("close_all");
						   }
						});
					});
				   $("#rule_model .modal-footer button:last").unbind("click");
				   $("#rule_model .modal-footer button:last").click(function(){
					   var nodes = $.jstree.reference('#choosenodetree').get_selected(true);
					   var ids="";
					   for(var i=0;i<nodes.length;i++){
						   ids+=getnodeids(nodes[i],"choosenodetree");
					   }
					   $.ajax({
						   type: "POST",
						   url: "ruleController/addRuleFunction.do",
						   data:"rid="+rid+"&fids="+ids,
						   success: function(msg){
							   alert(msg.info);
            				   if(msg.status){
            					   $("#rule_model").modal("hide");
            					   $("#rule_model .modal-footer button:last").unbind("click");
            				   }
						   }
					   });
				   });
				   $("#rule_model").modal("show");
			   }
		   });
		}
	function getnodeids(node,nodeid){
		if(node.id==0){
			return "";
		}else{
			return node.id+","+getnodeids($.jstree.reference('#'+nodeid).get_node(node.parent));
		}
	}
	function freezerule(rid,version){
		if(confirm("确认冻结？")){
			$.ajax({
			   type: "POST",
			   url: "ruleController/freeze.do",
			   data: "rid="+rid+"&version="+version,
			   success: function(msg){
				   alert(msg.info);
				   if(msg.status){
					   $('#sample_1').dataTable( tablesettings).fnDraw();
				   }
			   }
			});
		}
	}
	$("#search_rule").click(function(){
		$('#sample_1').dataTable( ruletablesettings).fnDraw();
	});
	$("#create_rule").click(function(){
		$("#create_rule_model").modal("show");
		$("#create_rule_model .modal-body").html("正在加载数据，请稍等……");
		$("#create_rule_model .modal-body").load("ruleController/turnCreateRule.do",null,function(){
			$.ajax({
				   type: "POST",
				   url: "functionController/getFunctions.do",
				   success: function(msg){
					   $('#create_rule_choosenodetree').jstree({
						   'checkbox' : {
								'three_state' : false,
							},
							'plugins' : [ "wholerow", "checkbox" ],
							'core' : {
								'data' : msg,
								'themes' : {
									'icons' : false
								}

							}
						});
					   var formvalidate=bindformvalidate("#create_rule_form",{
						   	rname: {
				             	required: true
					         }
						   });
					   $("#create_rule_model .modal-footer button:last").unbind("click");
					   $("#create_rule_model .modal-footer button:last").click(function(){
						   if(formvalidate.form()){
							   var nodes = $.jstree.reference('#create_rule_choosenodetree').get_selected(true);
							   var ids="";
							   for(var i=0;i<nodes.length;i++){
								   ids+=getnodeids(nodes[i],"create_rule_choosenodetree");
							   }
							   $.ajax({
								   type: "POST",
								   url: "ruleController/addRuleAndFunction.do",
								   data:$("#create_rule_form").serialize()+"&fids="+ids,
								   success: function(msg){
									   alert(msg.info);
		            				   if(msg.status){
		            					   $("#create_rule_model").modal("hide");
		            					   $("#create_rule_model .modal-footer button:last").unbind("click");
		            					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
		            				   }
								   }
							   });
							   }
						   });
				   }
			   });
			
		});
	});
	TableManaged.init(ruletablesettings);

	</script>
	<!-- 按钮触发模态框 -->
			<div class="modal fade" id="rule_model" tabindex="-1" role="dialog" 
												   aria-labelledby="rule_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="rule_model_ModalLabel">
						赋予
					</h4>
				 </div>
				 <div class="modal-body">
				 	<div id="choosenodetree"></div>
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
						角色信息
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
			<div class="modal fade" id="create_rule_model" tabindex="-1" role="dialog" 
												   aria-labelledby="create_rule_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="create_rule_model_ModalLabel">
						创建角色
					</h4>
				 </div>
				 <div class="modal-body">
				 </div>
				 <div class="modal-footer">
					<button type="button" class="btn btn-default" 
					   data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary">
					   提交
					</button>
				 </div>
			  </div><!-- /.modal-content -->
			</div><!-- /.modal -->
			</div>
</body>
<!-- END BODY -->
</html>