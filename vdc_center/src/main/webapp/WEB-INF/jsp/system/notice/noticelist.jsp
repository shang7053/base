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

								<div class="caption"><i class="icon-globe"></i>异常审计</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<table width="100%">
										<tr>
											<td width="80px;"><label>标题：</label></td>
											<td><input type="text" id="title"/></td>
											<td><label>内容：</label></td>
											<td><input type="text" id="context"/></td>
											<td align="right">
												<button id="search_notices" class="btn green">

												查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
		
												</button>
											</td>
										</tr>
										<tr>
											<td><label>是否已读：</label></td>
											<td>
												<select id="is_read">
													<option selected="selected" value="">全部</option>
													<option value="0">否</option>
													<option value="1">是</option>
												</select>
											</td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</table>
								</div>

								<table class="table table-striped table-bordered table-hover" id="sample_1">

									<thead>

										<tr>

											<th style="width:8px;">序号</th>

											<th>标题</th>

											<th class="hidden-480">是否已读</th>

											<th class="hidden-480">创建时间</th>
											<th class="hidden-480">已读时间</th>
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
<!-- 按钮触发模态框 -->
			<div class="modal fade" id="notice_model" tabindex="-1" role="dialog" 
												   aria-labelledby="notice_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="notice_model_ModalLabel">
						数据审计
					</h4>
				 </div>
				 <div class="modal-body">
				 </div>
				 <div class="modal-footer">
					<button type="button" class="btn btn-default" 
					   data-dismiss="modal">关闭
					</button>
			  </div><!-- /.modal-content -->
			</div><!-- /.modal -->
			</div>
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
	var number = $('#header_notification_bar .badge').text();
    $('#header_notification_bar .badge').text("");
    $('#notice_count').html("<p>暂无未读系统消息</p>");
    $('#header_notification_bar').pulsate({
        color: "#66bce6",
        repeat: 5
    });
    $(".notification li[id^='notice_li_']").remove();
	var ruletablesettings=gettables("noticeController/queryNotice.do",[
	                                                   	            {
	                                                	                "mData" : "nid",
	                                                	                "sWidth" : "28px",
	                                                	                "bSortable" : false,
	                                                	                "aTargets" : [ 0 ]
	                                                	            },{
	                                                	                "mData" : "title",
	                                                	                "sWidth" : "100px",
	                                                	                "aTargets" : [ 1 ],
	                                                	                "bSortable" : false
	                                                	            },{
	                                                	                "mData" : "is_read",
	                                                	                "sWidth" : "50px",
	                                                	                "aTargets" : [ 2 ],
	                                                	                "bSortable" : false,
	                                                	                "mRender" :function(data,type,full){
	                                                	                    var html='';
	                                                	                    if(data == 0){
	                                                	                        html="<span style='color: red'>否</span>";
	                                                	                    }else{
	                                                	                        html="<span style='color: green'>是</span>";
	                                                	                    }
	                                                	                    return html;
	                                                	                }
	                                                	            },{
	                                                	                "mData" : "create_time",
	                                                	                "sWidth" : "100px",
	                                                	                "aTargets" : [ 3 ],
	                                                	                "bSortable" : false,
	                                                	                "mRender" :function(data,type,full){
	                                                	                    return formatDate(data,"yyyy-MM-dd HH:mm");
	                                                	                }
	                                                	            },{
	                                                	                "mData" : "read_time",
	                                                	                "sWidth" : "100px",
	                                                	                "aTargets" : [ 4 ],
	                                                	                "bSortable" : false,
	                                                	                "mRender" :function(data,type,full){
	                                                	                    return formatDate(data,"yyyy-MM-dd HH:mm");
	                                                	                }
	                                                	            },{
	                                                	                "mData" : "nid",
	                                                	                "sClass" : "center",
	                                                	                "sWidth" : "40px",
	                                                	                "aTargets" : [ 5 ],
	                                                	                "bSortable" : false,
	                                                	               	"mRender" : function(data, type,full) {
	                                                	                    var dHtml = "";
		                                            	          			dHtml+='<div class="btn-group">';
		                                                      				dHtml+='<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:;">';
		                                                   					dHtml+='工具 <i class="icon-angle-down"></i>';
		                                               						dHtml+='</a>';
		                                            						dHtml+='<ul class="dropdown-menu">';
		                                            						dHtml+='<vooletag:permission url="noticeController/turnNoticesInfo.do"><li><a href="javascript:void(0)" onclick="turnmodalgetinfo(\''+ data+ '\',this);"><i class="icon-reorder"></i>&nbsp查看</a></li></vooletag:permission>';
		                                            						dHtml+='<vooletag:permission url="noticelist/setread.do"><li><a href="javascript:void(0)" onclick="setread(\''+data+'\',\''+full.version+"\',"+full.is_read+');"><i class="icon-ban-circle"></i>&nbsp设为已读</a></li></vooletag:permission>';
		                                            						dHtml+='</ul>';
		                                            						dHtml+='</div>';
		                                            	                    return dHtml;
	                                                	                }
	                                                	            },{
	                                                	            	"mData" : "version",
	                                                	            	"aTargets" : [ 6 ],
	                                                	            	"fnCreatedCell" : function(nTd, sData, oData, iRow, iCol) {
	                                                	           			$(nTd).css('display', 'none');
	                                                	           		}
	                                                	            }],function(aoData) {//重要设置，可通过此设置添加额外查询参数
	                                                		            aoData.push({
	                                                		                "name" : "title",
	                                                		                "value" : $.trim($("#title").val())
	                                                		            },{
	                                                		                "name" : "context",
	                                                		                "value" : $.trim($("#context").val())
	                                                		            },{
	                                                		                "name" : "is_read",
	                                                		                "value" : $.trim($("#is_read").val())
	                                                		            });
	                                                		        },'${tablesize == null ? 10 : tablesize}');
		function setread(nid,version,is_read){
			if(is_read==1){
				alert("已读消息无法重复设置为已读");
				return ;
			}
			$.ajax({
			   type: "POST",
			   url: "noticeController/setRead.do",
			   data: "nid="+nid+"&version="+version,
			   success: function(msg){
				   alert(msg.info);
				   if(msg.status){
					   $('#sample_1').dataTable( ruletablesettings).fnDraw();
				   }
			   }
			});
		}
		$("#search_notices").click(function(){
			$('#sample_1').dataTable( ruletablesettings).fnDraw();
		});
		TableManaged.init(ruletablesettings);
		function turnmodalgetinfo(nid,dom){
			$("#notice_model .modal-body").html("正在加载数据，请稍等……");
			$("#notice_model .modal-body").load("noticeController/turnNoticesInfo.do",{"nid":nid},function(){
				$("#notice_model").modal("show");
			});
		}
	</script>
</body>
<!-- END BODY -->
</html>