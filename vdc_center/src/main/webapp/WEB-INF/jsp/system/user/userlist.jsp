<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="vooletag" uri="http://tag.voole.com/" %>  
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />
<link rel="stylesheet" href="media/css/DT_bootstrap.css" />
<!-- END PAGE LEVEL STYLES -->
<link rel="shortcut icon" href="media/image/favicon.ico" />
<!-- BEGIN BODY -->
			<!-- BEGIN PAGE CONTAINER-->        

			<div class="container-fluid" style="min-height: 600px;">

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box light-grey">

							<div class="portlet-title">

								<div class="caption"><i class="icon-globe"></i>用户管理 </div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<table width="100%">
										<tr>
											<td width="80px;"><label>用户名：</label></td>
											<td><input type="text" id="username"/></td>
											<td><label>真实姓名：</label></td>
											<td><input type="text" id="realname"/></td>
											<td align="right">
												<button id="search_rule" class="btn green">

												查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
		
												</button>
											</td>
										</tr>
										<tr>
											<td><label>邮箱：</label></td>
											<td><input type="text" id="email"/></td>
											<td><label>手机号：</label></td>
											<td><input type="text" id="tel"/></td>
											<td align="right">
												<vooletag:permission url="userlist/createuser.do">
													<button id="create_user" class="btn green">
	
													新用户 <i class="icon-plus"></i>
			
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

											<th>用户名</th>

											<th class="hidden-480">真实姓名</th>

											<th class="hidden-480">邮箱</th>

											<th class="hidden-480">是否启用</th>
											<th class="hidden-480">上次登录时间</th>
											<th>操作</th>
											<th style="display: none;">版本</th>
										</tr>

									</thead>

									<tbody>

										<!-- <tr class="odd gradeX">

											<td><input type="checkbox" class="checkboxes" value="1" /></td>

											<td>shuxer</td>

											<td class="hidden-480"><a href="mailto:shuxer@gmail.com">shuxer@gmail.com</a></td>

											<td class="hidden-480">120</td>

											<td class="center hidden-480">12 Jan 2012</td>

											<td ><span class="label label-success">Approved</span></td>

										</tr> -->
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
	var ruletablesettings=gettables("userController/queryUser.do",[
		          {
		             "mData" : "uid",
		             "sWidth" : "28px",
		             "bSortable" : false,
		             "aTargets" : [ 0 ]
		         },{
		             "mData" : "username",
		             "sWidth" : "80px",
		             "aTargets" : [ 1 ],
		             "bSortable" : false
		         },{
		             "mData" : "realname",
		             "sWidth" : "80px",
		             "aTargets" : [ 2 ],
		             "bSortable" : false
		         },{
		             "mData" : "email",
		             "sWidth" : "80px",
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
		             "mData" : "login_time",
		             "sWidth" : "80px",
		             "aTargets" : [ 5 ],
		             "bSortable" : false,
		             "mRender" :function(data,type,full){
		                 return formatDate(data,"yyyy-MM-dd HH:mm");
		             }
		         },{
		             "mData" : "uid",
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
							dHtml+='<vooletag:permission url="userlist/turnmodalgetinfo.do"><li><a href="javascript:void(0)" onclick="turnmodalgetinfo(\''+ data+ '\',this);"><i class="icon-reorder"></i>&nbsp查看</a></li></vooletag:permission>';
							dHtml+='<vooletag:permission url="userlist/turnmodal.do"><li><a href="javascript:void(0)" onclick="turnmodal(\''+ data+ '\',this);"><i class="icon-edit"></i>&nbsp赋予</a></li></vooletag:permission>';
							dHtml+='<vooletag:permission url="userlist/freezeuser.do"><li><a href="javascript:void(0)" onclick="freezeuser(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ban-circle"></i>&nbsp禁用</a></li></vooletag:permission>';
							dHtml+='<vooletag:permission url="userlist/startuser.do"><li><a href="javascript:void(0)" onclick="startuser(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ok"></i>&nbsp启用</a></li></vooletag:permission>';
							dHtml+='<vooletag:permission url="userlist/restpassword.do"><li><a href="javascript:void(0)" onclick="restpassword(\''+ data+ '\',\''+full.version+'\');"><i class="icon-retweet"></i>&nbsp重置密码</a></li></vooletag:permission>';
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
			                "name" : "username",
			                "value" : $.trim($("#username").val())
			            },{
			                "name" : "realname",
			                "value" : $.trim($("#realname").val())
			            },{
			                "name" : "email",
			                "value" : $.trim($("#email").val())
			            },{
			                "name" : "tel",
			                "value" : $.trim($("#tel").val())
			            });
			        },'${tablesize == null ? 10 : tablesize}');
	function turnmodalgetinfo(uid,dom){
		$("#user_info_model .modal-body").html("正在加载数据，请稍等……");
		$("#user_info_model .modal-body").load("userController/turnUserInfo.do",{"uid":uid},function(){
			$.ajax({
				   type: "POST",
				   url: "userController/queryUserRules.do",
				   data: "uid="+uid+"&is_on="+1,
				   success: function(msg){
					   var html="";
					   for(var i=0;i<msg.length;i++){
						   html+=msg[i].rname+","
					   }
					   if(""!=html){
						   html=html.substring(0, html.length-1);
					   }
					   $("#rule_list").html(html);
				   }
				});
			$("#user_info_model").modal("show");
		});
	}
	function turnmodal(uid,dom){
		$.ajax({
		   type: "POST",
		   url: "userController/queryUserRules.do",
		   data: "uid=${user.uid}&is_on=1",
		   success: function(msg){
			   $("#user_model").modal("show");
			   var html="<table style=\"width:100%\">";
			   for(var i=1;i<=msg.length;i++){
				   if(i/4==0){
					   html+="<tr>";
				   }
				   html+='<td><input type="checkbox" name="rules" value="'+msg[i-1].rid+'"/>'+msg[i-1].rname+"</td>";
				   if(i%5==0){
					   html+="</tr>";
				   }
			   }
			   html+="</table>";
			   $("#chooserules").html(html);
			   $.ajax({
				   type: "POST",
				   url: "userController/queryUserRules.do",
				   data: "uid="+uid+"&is_on="+1,
				   success: function(msg){
					   for(var i=0;i<msg.length;i++){
						   $("#chooserules input[name='rules'][value='"+msg[i].rid+"']").attr("checked","checked");
					   }
				   }
				});
			   $("#user_model .modal-footer button:last").unbind("click");
			   $("#user_model .modal-footer button:last").click(function(){
				   var rids="";
				   $("#chooserules input[name='rules']:checked").each(function(){
					   rids+=$(this).val()+",";
				   });
				   $.ajax({
					   type: "POST",
					   url: "userController/addUserRule.do",
					   data:"uid="+uid+"&rids="+rids,
					   success: function(msg){
						   alert(msg.info);
        				   if(msg.status){
        					   $("#user_model").modal("hide");
        					   $("#user_model .modal-footer button:last").unbind("click");
        				   }
					   }
				   });
			   }); 
			   $("#user_model").modal("show");
		   }
	   });
	}
function freezeuser(uid,version){
	if(confirm("确认禁用？")){
		$.ajax({
		   type: "POST",
		   url: "userController/changeuser.do",
		   data: "is_on=0&uid="+uid+"&version="+version,
		   success: function(msg){
			   alert(msg.info);
			   if(msg.status){
				   $('#sample_1').dataTable( ruletablesettings).fnDraw();
			   }
		   }
		});
	}
}
function startuser(uid,version){
	if(confirm("确认启用？")){
		$.ajax({
		   type: "POST",
		   url: "userController/changeuser.do",
		   data: "is_on=1&uid="+uid+"&version="+version,
		   success: function(msg){
			   alert(msg.info);
			   if(msg.status){
				   $('#sample_1').dataTable( ruletablesettings).fnDraw();
			   }
		   }
		});
	}
}
function restpassword(uid,version){
	$("#rest_pw_model").modal("show");
	var formvalidate=bindformvalidate(".reset_pw",{
		 passwordcode: {
             required: true
         },
         passwordcode2: {
             required: true,
             equalTo: "#passwordcode"
         }
	   },{
		   passwordcode: {
             required: "密码不能为空"
         },
          passwordcode2: {
             required: "密码不能为空",
           	 equalTo: "两次密码输入不一致"
         } 
	   });
	  $("#rest_pw_model .modal-footer button:last").unbind("click");
	   $("#rest_pw_model .modal-footer button:last").click(function(){
		   if(formvalidate.form()){
			   if(confirm("确认重置？")){
				   if($("#passwordcode").val()!=""&&$("#passwordcode").val()!=$("#passwordcode2").val()){
					   alert("不允许空密码或两次密码不一致！");
				   }
					$.ajax({
					   type: "POST",
					   url: "userController/changeuser.do",
					   data: "uid="+uid+"&passwordcode="+$("#passwordcode").val()+"&version="+version,
					   success: function(msg){
						   alert(msg.info);
						   if(msg.status){
							   $('#sample_1').dataTable( ruletablesettings).fnDraw();
						   }
					   }
					});
				}
		   }
	   });
}
$("#search_rule").click(function(){
	$('#sample_1').dataTable( ruletablesettings).fnDraw();
});
$("#create_user").click(function(){
	$("#create_user_model").modal("show");
	$("#create_user_model .modal-body").html("正在加载数据，请稍等……");
	$("#create_user_model .modal-body").load("userController/turnCreateUser.do",null,function(){
		$.ajax({
			   type: "POST",
			   url: "userController/queryUserRules.do",
			   data: "uid=${user.uid}&is_on=1",
			   success: function(msg){
				   var html="<table style=\"width:100%\">";
				   for(var i=1;i<=msg.length;i++){
					   if(i/4==0){
						   html+="<tr>";
					   }
					   html+='<td><input type="checkbox" name="rules" value="'+msg[i-1].rid+'"/>'+msg[i-1].rname+"</td>";
					   if(i%5==0){
						   html+="</tr>";
					   }
				   }
				   html+="</table>";
				   $("#create_user_choosenodetree").html(html);
				   var formvalidate=bindformvalidate(".create_user_form",{
					   username: {
		                    required: true,
		                    maxlength:10
		                },
		                realname: {
		                    required: true,
		                    maxlength:10
		                },
		                email: {
		                    required: true,
		                    maxlength:100,
		                    email: true
		                },
		                tel: {
		                    required: true,
		                    maxlength:11
		                },
		                is_on: {
		                    required: true,
		                    maxlength:1
		                }
				   },{
					   username: {
		                    required: "用户名不能为空"
		                },
		                realname: {
		                    required: "密码不能为空"
		                } 
				   });
				   $("#create_user_model .modal-footer button:last").unbind("click");
				   $("#create_user_model .modal-footer button:last").click(function(){
					   if(formvalidate.form()){
						   var rids="";
						   $("#chooserules input[name='rules']:checked").each(function(){
							   rids+=$(this).val()+",";
						   });
						   $.ajax({
							   type: "POST",
							   url: "userController/addUser.do",
							   data:$("#create_user_form").serialize()+"&rids="+rids,
							   success: function(msg){
								   alert(msg.info);
	            				   if(msg.status){
	            					   $("#create_user_model").modal("hide");
	            					   $("#create_user_model .modal-footer button:last").unbind("click");
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
			<div class="modal fade" id="user_model" tabindex="-1" role="dialog" 
												   aria-labelledby="user_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="user_model_ModalLabel">
						赋予
					</h4>
				 </div>
				 <div class="modal-body">
				 	<div id="chooserules">
				 	</div>
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
			<div class="modal fade" id="user_info_model" tabindex="-1" role="dialog" 
												   aria-labelledby="user_info_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="user_info_model_ModalLabel">
						用户信息
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
			<div class="modal fade" id="create_user_model" tabindex="-1" role="dialog" 
												   aria-labelledby="create_user_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="create_user_model_ModalLabel">
						创建用户
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
			<!-- 按钮触发模态框 -->
			<div class="modal fade" id="rest_pw_model" tabindex="-1" role="dialog" 
												   aria-labelledby="rest_pw_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="rest_pw_model_ModalLabel">
						重置密码
					</h4>
				 </div>
				 <div class="modal-body">
					<form id="reset_pw" action="javascript:;" class="reset_pw">
					 	<table style="width: 100%">
					 		<tr>
					 			<td><label>密码：</label></td>
					 			<td><input type="password" name="passwordcode" id="passwordcode" /></td>
					 			<td></td>
					 		</tr>
					 		<tr>
					 			<td><label>确认密码：</label></td>
					 			<td><input type="password" name="passwordcode2" id="passwordcode2" /></td>
					 			<td></td>
					 		</tr>
					 	</table>
				 	</form>
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
