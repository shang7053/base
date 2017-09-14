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

								<div class="caption"><i class="icon-globe"></i>订单</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<table width="100%">
										<tr>
											<td width="80px;"><label>订单号：</label></td>
											<td><input type="text" id="orderNum"/></td>
											<td width="80px;"><label>原订单号：</label></td>
											<td><input type="text" id="origOrderNum"/></td>
											<td width="80px;"><label>终端型号：</label></td>
											<td><input type="text" id="oemid"/></td>
											<td align="right">
												<button id="search_setttings" class="btn green">

												查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
		
												</button>
											</td>
										</tr>
										<tr>
											<td width="80px;"><label>操作时间：</label></td>
											<td>
												<input type="text" id="transTime"/>
												<input type="hidden" id="queryStart"/>
												<input type="hidden" id="queryEnd"/>
											</td>
											</td>
											<td width="80px;"><label>终端编号：</label></td>
											<td><input type="text" id="hid"/></td>
											<td width="80px;"><label>用户ID：</label></td>
											<td><input type="text" id="uid"/></td>
										</tr>
										<tr>
											<td width="80px;"><label>订单状态：</label></td>
											<td>
												<select id="order_status">
													<option value="">---------------请选择---------------</option>
													<option value="0">待支付</option>
													<option value="1">已支付</option>
													<option value="2">已退款</option>
													<option value="3">失败</option>
												</select>
											</td>
											<td width="80px;"><label>订单类型：</label></td>
											<td>
												<select id="order_type">
													<option value="">---------------请选择---------------</option>
													<option value="0">单点</option>
													<option value="1">套餐</option>
												</select>
											</td>
											<td width="80px;"><label>支付渠道：</label></td>
											<td>
												<select id="chcd">
													<option value="">---------------请选择---------------</option>
													<option value="ALP">支付宝</option>
													<option value="WXP">微信</option>
													<option value="BDP">百度钱包</option>
												</select>
											</td>
										</tr>
									</table>

								</div>

								<table class="table table-striped table-bordered table-hover" id="sample_1">

									<thead>

										<tr>

											<th style="width:8px;">序号</th>

											<th>订单号</th>

											<th class="hidden-480">终端型号（oemid）</th>
											<th class="hidden-480">终端编号（hid）</th>

											<th class="hidden-480">用户ID（uid）</th>

											<th class="hidden-480">订单类型</th>
											<th class="hidden-480">产品名称</th>
											<th class="hidden-480">订单状态</th>
											<th class="hidden-480">状态描述</th>
											<th class="hidden-480">操作时间</th>
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
	binddaterangepicker("#transTime");
	var ordertablesettings=gettables("order/queryOrder.do",[
	                                                       	            {
	                                                    	                "mData" : "id",
	                                                    	                "sWidth" : "28px",
	                                                    	                "bSortable" : false,
	                                                    	                "aTargets" : [ 0 ]
	                                                    	            },{
	                                                    	                "mData" : "orderNum",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 1 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "oemid",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 2 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "hid",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 3 ],
	                                                    	                "bSortable" : false,
	                                                    	                "mRender" :function(data,type,full){
                                                                            	var html="";
                                                                            	if(null!=data){
                                                                           			html="<p title='"+data+"'>"+data.substring(0,12)+"……</p>"
                                                                            	}
                                                                            	return html;
                                                                            }
	                                                    	            },{
	                                                    	                "mData" : "uid",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 4 ],
	                                                    	                "bSortable" : false
	                                                    	            },{
	                                                    	                "mData" : "order_type",
	                                                    	                "sWidth" : "50px",
	                                                    	                "aTargets" : [ 5],
	                                                    	                "bSortable" : false,
	                                                    	                "mRender" :function(data,type,full){
	                                                    	                    var html='';
	                                                    	                    if(data == "0"){
	                                                    	                        html="<span>单点</span>";
	                                                    	                    }else if(data == "1"){
	                                                    	                        html="<span>套餐</span>";
	                                                    	                    }
	                                                    	                    return html;
	                                                    	                }
	                                                    	            },{
	                                                    	                "mData" : "order_name",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 6 ],
	                                                    	                "bSortable" : false,
	                                                    	                "mRender" :function(data,type,full){
                                                                            	var html="";
                                                                            	if(null!=data){
                                                                            		if(data.length>12){
	                                                                           			html="<p title='"+data+"'>"+data.substring(0,12)+"……</p>"
                                                                            		}else{
                                                                            			html+=data;
                                                                            		}
                                                                            	}
                                                                            	return html;
                                                                            }
	                                                    	            },{
	                                                    	                "mData" : "order_status",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 7 ],
	                                                    	                "bSortable" : false,
	                                                    	                "mRender" :function(data,type,full){
	                                                    	                    var html='';
	                                                    	                    if(data == "0"){
	                                                    	                        html="<span style='color: gray'>待支付</span>";
	                                                    	                    }else if(data == "1"){
	                                                    	                        html="<span style='color: green'>已支付</span>";
	                                                    	                    }else if(data == "2"){
	                                                    	                        html="<span style='color: gray'>已退款</span>";
	                                                    	                    }else{
	                                                    	                        html="<span style='color: red'>失败</span>";
	                                                    	                    }
	                                                    	                    return html;
	                                                    	                }
	                                                    	            },{
	                                                    	                "mData" : "errorDetail",
	                                                    	                "sWidth" : "100px",
	                                                    	                "aTargets" : [ 8 ],
	                                                    	                "bSortable" : false,
	                                                    	                "mRender" :function(data,type,full){
                                                                            	var html="";
                                                                            	if(null!=data){
                                                                            		if(data.length>15){
                                                                            			html="<p title='"+data+"'>"+data.substring(0,15)+"……</p>"
                                                                            		}else{
                                                                            			html=data;
                                                                            		}
                                                                            	}
                                                                            	return html;
                                                                            }
	                                                    	            },{
	                                                    	                "mData" : "transTime",
	                                                    	                "sClass" : "center",
	                                                    	                "sWidth" : "40px",
	                                                    	                "aTargets" : [ 9 ],
	                                                    	                "bSortable" : false,
	    	                                            	                "mRender" :function(data,type,full){
	    	                                            	                    return formatDate(data,"yyyy-MM-dd HH:mm");
	    	                                            	                }
	                                                    	            },{
	                                                    	                "mData" : "orderNum",
	                                                    	                "sClass" : "center",
	                                                    	                "sWidth" : "40px",
	                                                    	                "aTargets" : [ 10 ],
	                                                    	                "bSortable" : false,
	                                                    	               	"mRender" : function(data, type,full) {
	                                                    	               		var dHtml = "<a href=\"javascript:void(0)\" onclick=\"changvalue('+ data+ ','+full.version+');\" class=\"btn mini purple\"><i class=\"icon-edit\"></i>修改</a>";
	                                                    	               		var dHtml = "";
	                                                    	          			dHtml+='<div class="btn-group">';
	                                                              				dHtml+='<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:;">';
	                                                           					dHtml+='工具 <i class="icon-angle-down"></i>';
	                                                       						dHtml+='</a>';
	                                                    						dHtml+='<ul class="dropdown-menu">';
	                                                    						dHtml+='<vooletag:permission url="order/turnOrderInfo.do"><li><a href="javascript:void(0)" onclick="turnmodalgetinfo(\''+ data+'\');"><i class="icon-info"></i>&nbsp详情</a></li></vooletag:permission>';
	                                                    						if(full.order_status==1){
		                                                    						dHtml+='<vooletag:permission url="order/cancel.do"><li><a href="javascript:void(0)" onclick="cancel(\''+ data+'\');"><i class="icon-edit"></i>&nbsp退款</a></li></vooletag:permission>';
	                                                    						}
	                                                    						dHtml+='</ul>';
	                                                    						dHtml+='</div>';
	                                                    	                    return dHtml;
	                                                    	                }
	                                                    	            }],function(aoData) {//重要设置，可通过此设置添加额外查询参数
	                                                    		            aoData.push({
	                                                    		                "name" : "oemid",
	                                                    		                "value" : $.trim($("#oemid").val())
	                                                    		            },{
	                                                    		                "name" : "hid",
	                                                    		                "value" : $.trim($("#hid").val())
	                                                    		            },{
	                                                    		                "name" : "uid",
	                                                    		                "value" : $.trim($("#uid").val())
	                                                    		            },{
	                                                    		                "name" : "orderNum",
	                                                    		                "value" : $.trim($("#orderNum").val())
	                                                    		            },{
	                                                    		                "name" : "order_type",
	                                                    		                "value" : $.trim($("#order_type").val())
	                                                    		            },{
	                                                    		                "name" : "order_status",
	                                                    		                "value" : $.trim($("#order_status").val())
	                                                    		            },{
		                                                		                "name" : "queryStart",
		                                                		                "value" : $.trim($("#queryStart").val())
		                                                		            },{
		                                                		                "name" : "queryEnd",
		                                                		                "value" : $.trim($("#queryEnd").val())
		                                                		            },{
		                                                		                "name" : "chcd",
		                                                		                "value" : $.trim($("#chcd").val())
		                                                		            },{
		                                                		                "name" : "origOrderNum",
		                                                		                "value" : $.trim($("#origOrderNum").val())
		                                                		            });
	                                                    		        },'${tablesize == null ? 10 : tablesize}');
	$("#search_setttings").click(function(){
		$('#sample_1').dataTable( ordertablesettings).fnDraw();
	});
	function turnmodalgetinfo(orderNum){
		$("#order_info_model .modal-body").html("正在加载数据，请稍等……");
		$("#order_info_model").modal("show");
		$("#order_info_model .modal-body").load("order/turnOrderInfo.do",{"orderNum":orderNum});
	}
	function cancel(orderNum){
		if(confirm("确认退款？")){
			$.ajax({
			   type: "POST",
			   url: "order/cancel.do",
			   data: "orderNum="+orderNum,
			   success: function(msg){
				   if(msg.status){
					   toastr.success(msg.info);
					   $('#sample_1').dataTable( ordertablesettings).fnDraw();
				   }else{
                   	toastr.error(msg.info);
                   }
			   }
			});
		}
	}
	TableManaged.init(ordertablesettings);

	</script>
	<!-- 按钮触发模态框 -->
			<div class="modal fade" id="order_info_model" tabindex="-1" role="dialog" 
												   aria-labelledby="settings_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="order_info_model_ModalLabel">
						订单详情
					</h4>
				 </div>
				 <div class="modal-body">
				 	<div id="settings_div"></div>
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