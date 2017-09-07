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

								<div class="caption"><i class="icon-globe"></i>项目异常记录</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<table width="100%">
										<tr>
										<td width="80px;"><label>项目：</label></td>
											<td><input type="text" id="p_name"/></td>
											<td><label>主题：</label></td>
											<td><input type="text" id="sink_topic"/></td>
											<td width="80px;"><label>同步码：</label></td>
											<td><input type="text" id="sync_code"/>
								 			</td>
											
											</td>
											<td align="right">
												<button id="search_setttings" class="btn green">

												查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
		
												</button>
											</td>
										</tr>
										<tr>
											<td width="80px;"><label>时间:</label></td>
											<td>
												<input type="text" id="create_time"/>
												
											</td>
											<td width="80px;"><label></label></td>
											<td></td>
											<td width="80px;"><label></label></td>
											<td></td>
											<td align="right">
											
											</td>
										</tr>
									</table>

								</div>

								<table class="table table-striped table-bordered table-hover" id="sample_1">

									<thead>

										<tr>

											<th style="width:8px;">序号</th>
											<th class="hidden-480">同步码</th>
											<th class="hidden-480">操作类型</th>
											<th class="hidden-480">项目</th>
											<th class="hidden-480">主题</th>
											<th class="hidden-480">重发状态</th>
											<th class="hidden-480">同步时间</th>

											<th class="hidden-480">创建时间</th>
											
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
	$(function() {
		binddaterangepickerByTerm("#create_time","YYYY-MM-DD HH",true);
	});
	
	
	var ruletablesettings=gettables("errorController/queryError.do",[
																	           {
																	            "mData" : "id",
																	            "sWidth" : "28px",
																	            "bSortable" : false,
																	            "aTargets" : [ 0 ]
																	        },{
																	            "mData" : "sync_code",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 1 ],
																	            "bSortable" : false,
																	        },{
																	            "mData" : "action",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 2 ],
																	            "bSortable" : false
																	        },{
																	            "mData" : "p_name",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 3 ],
																	            "bSortable" : false,
																	            
																	        },{
																	            "mData" : "sink_topic",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 4 ],
																	            "bSortable" : false,
																	            
																	        },{
		                                                    	                "mData" : "resend_status",
		                                                    	                "sWidth" : "100px",
		                                                    	                "aTargets" : [ 5 ],
		                                                    	                "bSortable" : false,
		                                                    	                "mRender" :function(data,type,full){
		                                                    	                    var html='';
		                                                    	                    if(data == "0"){
		                                                    	                        html="<span style='color: red'>未重发</span>";
		                                                    	                    }else{
		                                                    	                        html="<span style='color: green'>已重发</span>";
		                                                    	                    }
		                                                    	                    return html;
		                                                    	                }
		                                                    	            },{
																	            "mData" : "sync_time",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 6 ],
																	            "bSortable" : false,
																	            "mRender" :function(data,type,full){
																	                return data;
																	            }
																	           
																	        },{
																	            "mData" : "create_time",
																	            "sWidth" : "100px",
																	            "aTargets" : [ 7 ],
																	            "bSortable" : false,
																	            "mRender" :function(data,type,full){
																	                return formatDate(data,"yyyy-MM-dd HH:mm");
																	            }
																	        },{
																	            "mData" : "id",
																	            "sClass" : "center",
																	            "sWidth" : "40px",
																	            "aTargets" : [ 8 ],
																	            "bSortable" : false,
																	           	"mRender" : function(data, type,full) {
																	           		var dHtml = "";
																	      			dHtml+='<div class="btn-group">';
																	  				dHtml+='<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:;">';
																						dHtml+='工具 <i class="icon-angle-down"></i>';
																						dHtml+='</a>';
																					dHtml+='<ul class="dropdown-menu">';
																					dHtml+='<vooletag:permission url="errorController/turnErrorInfo.do"><li><a href="javascript:void(0)" onclick="showinfo(\''+ data+ '\');"><i class="icon-info"></i>&nbsp详情</a></li></vooletag:permission>';
																					dHtml+='<vooletag:permission url="errorController/resend.do"><li><a href="javascript:void(0)" onclick="resend('+full.id+',\''+full.sink_topic+'\',\''+full.sync_msg+'\','+full.version+');"><i class="icon-info"></i>&nbsp重发</a></li></vooletag:permission>';
																					dHtml+='<vooletag:permission url="errorController/delError.do"><li><a href="javascript:void(0)" onclick="delds(\''+ data+ '\');"><i class="icon-edit"></i>&nbsp删除</a></li></vooletag:permission>';
																					dHtml+='</ul>';
																					dHtml+='</div>';
																	                return dHtml;
																	            }}
																	        	],function(aoData) {//重要设置，可通过此设置添加额外查询参数
																		            aoData.push({
																		                "name" : "p_name",
																		                "value" : $.trim($("#p_name").val())
																		            },{
																		                "name" : "sink_topic",
																		                "value" : $.trim($("#sink_topic").val()) 
																		            },{
																		                "name" : "sync_code",
																		                "value" : $.trim($("#sync_code").val()) 
																		            },{
																		                "name" : "query_time",
																		                "value" : $.trim($("#create_time").val()) 
																		            });
																		        },'${tablesize == null ? 10 : tablesize}');
$("#search_setttings").click(function(){
$('#sample_1').dataTable( ruletablesettings).fnDraw();
});


function binddaterangepickerByTermlyj(domid,fm,flag){
	$(domid).daterangepicker({
        dateLimit : {
            days : 30
        }, //起止时间的最大间隔
        singleDatePicker : true,
        showDropdowns : true,
        showWeekNumbers : false, //是否显示第几周
        timePicker : flag, //是否显示小时和分钟
        timePickerIncrement : 1, //时间的增量，单位为分钟
        timePicker12Hour : false, //是否使用12小时制来显示时间
        opens : 'right', //日期选择框的弹出位置
        buttonClasses : [ 'btn btn-default' ],
        applyClass : 'btn-small btn-primary blue',
        cancelClass : 'btn-small',
        format : fm, //控件中from和to 显示的日期格式
        separator : ' - ',
        locale : {
            applyLabel : '确定',
            cancelLabel : '取消',
            fromLabel : '起始时间',
            customRangeLabel : '自定义',
            daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
            monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
                '七月', '八月', '九月', '十月', '十一月', '十二月' ],
            firstDay : 1
        }
        
	}, function(start,end,label) {//格式化日期显示框
        $('#reportrange span').html(start.format('YYYY-MM-DD HH:mm:ss'));
    });
}


	function showinfo(id){
		$("#error_model").modal("show");
		$("#error_model .modal-title").html("详情");
		$("#error_div").load("errorController/turnErrorInfo.do",{"id":id},function(){
			$("#error_form tr:hidden").show();
			$("#error_model .modal-footer button:first").hide();
			$("#error_model .modal-footer button:eq(1)").hide();
		});
	}
	
	function delds(id){
		if(confirm("确认删除？")){
			$.ajax({
			   type: "POST",
			   url: "errorController/delError.do",
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
	function resend(id,sink_topic,sync_msg,version){
		if(confirm("确认重发？")){
			$.ajax({
			   type: "POST",
			   url: "errorController/resend.do",
			   data: {id:id,sink_topic:sink_topic,sync_msg:sync_msg,version:version},
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
	TableManaged.init(ruletablesettings);
	
	
	</script>
	<!-- 按钮触发模态框 -->
			<div class="modal fade" id="error_model" tabindex="-1" role="dialog" 
												   aria-labelledby="error_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="error_model_ModalLabel">
						更改配置
					</h4>
				 </div>
				 <div class="modal-body">
				 	<div id="error_div"></div>
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
			
</body>
</html>