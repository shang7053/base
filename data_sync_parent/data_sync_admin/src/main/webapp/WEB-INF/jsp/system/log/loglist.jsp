<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

								<div class="caption"><i class="icon-globe"></i>日志查询</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<table width="100%">
										<tr>
											<td width="80px;"><label>登录名：</label></td>
											<td><input type="text" id="username"/></td>
											<td><label>真实姓名：</label></td>
											<td><input type="text" id="realname"/></td>
											<td><label>手机号：</label></td>
											<td><input type="text" id="tel"/></td>
											<td></td>
											<td align="right" rowspan="2">
												<button id="search_notices" class="btn green">

												查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
		
												</button>
											</td>
										</tr>
										<tr>
											<td><label>操作时间：</label></td>
											<td>
												<input type="text" id="create_time"/>
												<input type="hidden" id="queryStart"/>
												<input type="hidden" id="queryEnd"/>
											</td>
											<td><label>URL：</label></td>
											<td><input type="text" id="url"/></td>
											<td><label>参数：</label></td>
											<td><input type="text" id="param"/></td>
										</tr>
									</table>
								</div>

								<table class="table table-striped table-bordered table-hover" id="sample_1">

									<thead>

										<tr>

											<th style="width:8px;">序号</th>

											<th>用户id</th>

											<th class="hidden-480">url</th>

											<th class="hidden-480">参数</th>
											<th class="hidden-480">创建时间</th>
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
	binddaterangepicker("#create_time");
	var ruletablesettings=gettables("systemLogsController/querySystemLogs.do",[
	                                                   	            {
	                                                	                "mData" : "lid",
	                                                	                "sWidth" : "28px",
	                                                	                "bSortable" : false,
	                                                	                "aTargets" : [ 0 ]
	                                                	            },{
	                                                	                "mData" : "uid",
	                                                	                "sWidth" : "100px",
	                                                	                "aTargets" : [ 1 ],
	                                                	                "bSortable" : false
	                                                	            },{
	                                                	                "mData" : "url",
	                                                	                "sWidth" : "50px",
	                                                	                "aTargets" : [ 2 ],
	                                                	                "bSortable" : false,
	                                                	            },{
	                                                	                "mData" : "param",
	                                                	                "sWidth" : "100px",
	                                                	                "aTargets" : [ 3 ],
	                                                	                "bSortable" : false,
	                                                	            },{
	                                                	                "mData" : "create_time",
	                                                	                "sWidth" : "100px",
	                                                	                "aTargets" : [ 4 ],
	                                                	                "bSortable" : false,
	                                                	                "mRender" :function(data,type,full){
	                                                	                    return formatDate(data,"yyyy-MM-dd HH:mm");
	                                                	                }
	                                                	            }],function(aoData) {//重要设置，可通过此设置添加额外查询参数
	                                                		            aoData.push({
	                                                		                "name" : "username",
	                                                		                "value" : $.trim($("#username").val())
	                                                		            },{
	                                                		                "name" : "realname",
	                                                		                "value" : $.trim($("#realname").val())
	                                                		            },{
	                                                		                "name" : "tel",
	                                                		                "value" : $.trim($("#tel").val())
	                                                		            },{
	                                                		                "name" : "url",
	                                                		                "value" : $.trim($("#url").val())
	                                                		            },{
	                                                		                "name" : "param",
	                                                		                "value" : $.trim($("#param").val())
	                                                		            },{
	                                                		                "name" : "queryStart",
	                                                		                "value" : $.trim($("#queryStart").val())
	                                                		            },{
	                                                		                "name" : "queryEnd",
	                                                		                "value" : $.trim($("#queryEnd").val())
	                                                		            });
	                                                		        },'${tablesize == null ? 10 : tablesize}');
		$("#search_notices").click(function(){
			$('#sample_1').dataTable( ruletablesettings).fnDraw();
		});
		TableManaged.init(ruletablesettings);

	</script>
</body>
<!-- END BODY -->
</html>