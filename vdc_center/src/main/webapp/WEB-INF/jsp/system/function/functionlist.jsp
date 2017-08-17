<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="media/js/dist/themes/default/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="media/js/dist/jstree.min.js"></script>
<script src="media/js/jquery.validate.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="media/js/formvalidate.js"></script>
	<script src="media/js/datatableutil.js" type="text/javascript"></script>
<script type="text/javascript">
	function inittree(){
		$.ajax({
			   type: "POST",
			   url: "functionController/getFunctions.do",
			   success: function(msg){
				   $('#jstree_demo').jstree({
					   "core" : {
						    'data' : msg
						    },
						  "types" : {
						    "#" : {
						      "max_depth" : 3,
						    }
						  },
						  "contextmenu":{  
						        "items":{  
						            "create":null,  
						            "rename":null,  
						            "remove":null,  
						            "ccp":null,  
						            "查看菜单":{  
						                "label":"查看菜单",  
						                "action":function(data){  
						                	$(".form-horizontal")[0].reset();
						                	$("#pfname").unbind("click");
						                    var inst = jQuery.jstree.reference(data.reference),  
						                    obj = inst.get_node(data.reference);  
						                    $.ajax({
					                    	   type: "POST",
					                    	   url: "functionController/queryFunction.do",
					                    	   data: "fid="+obj.id,
					                    	   success: function(msg){
					                    		   $("#fid").val(msg.fid);
					                    		   $("#fname").val(msg.fname);
					                    		   $("#furl").val(msg.furl);
					                    		   $("#pfid").val(msg.pfid);
					                    		   $("#menu_type").val(msg.menu_type);
					                    		   $("#sort").val(msg.sort);
					                    		   $("#is_on").val(msg.is_on);
					                    		   $("input[name='is_on']").each(function(){
					                    			   if($(this).val()==msg.is_on){
					                    				   $(this).attr("checked",'checked'); 
					                    			   }
					                    		   });
					                    		   $("#pfname").val(inst.get_node(inst.get_parent(data.reference)).text);
					                    	   }
					                    	});
						                }  
						            },  
						            "新建菜单":{  
						                "label":"新建菜单",  
						                "action":function(data){  
						                	$(".form-horizontal")[0].reset();
						                	$("#fid").val("");
						                    var inst = jQuery.jstree.reference(data.reference),  
						                    obj = inst.get_node(data.reference);  
						                    $.ajax({
						                    	   type: "POST",
						                    	   url: "functionController/queryFunction.do",
						                    	   data: "fid="+obj.id,
						                    	   success: function(msg){
						                    		   $("#pfid").val(null==msg.fid?"0":msg.fid);
						                    		   $("#menu_type").val((msg.menu_type+1)>4?4:(msg.menu_type+1));
						                    		   $("#is_on").val(1);
						                    		   $("input[name='is_on']").each(function(){
						                    			   if($(this).val()==1){
						                    				   $(this).attr("checked",'checked'); 
						                    			   }
						                    		   });
						                    		   $("#pfname").val(obj.text);
						                    		   $(".form-actions").show("fast");
						                    		   $(".caption").html('<i class="icon-reorder"></i>增加链接信息');
						                    	   }
						                    	});
						                    	$("#pfname").unbind("click");
							                    $("#pfname").click(function(){
								           			 chooseParent();
								           		 });
							                    var formvalidate=bindformvalidate(".form-horizontal",{
							                    	fname: {
							                            required: true
							                        },
							                        furl: {
							                            required: true
							                        },
							                        pfname:{
							                        	required: true
							                        },
							                        pfname:{
							                        	required: true
							                        },
							                        menu_type_name:{
							                        	required: true
							                        },							                        
							                        sort:{
							                        	required: true,
							                        	digits:true
							                        }
							               	   },{
							               	   });
						                    	$("button[type='submit']").unbind("click");
						                    	$("button[type='submit']").click(function(){
						                    		if(formvalidate.form()){
							                    		$.ajax({
						                    			   type: "POST",
						                    			   url: "functionController/insertFunction.do",
						                    			   data: $(".form-horizontal").serialize(),
						                    			   success: function(msg){
						                    				   if(msg.status){
							                    				   toastr.success(msg.info);
							                    			     inst.destroy();
							                    			     inittree();
							                    			     $(".form-actions").hide("fast");
							                    			     $(".form-horizontal")[0].reset();
							                    			     formvalidate.resetForm();
							                    			     $(".form-horizontal img[src='media/image/right_1.png']").parent().remove();
							                    			     $(".form-horizontal img[src='media/image/error.png']").parent().remove();
						                    				   }else{
						           	                        	toastr.error(msg.info);
						                                       }
						                    			   }
						                    			});
						                    		}
						                    	});
						                }  
						            },  
						            "删除菜单":{  
						                "label":"删除菜单",  
						                "action":function(data){  
						                	$(".form-horizontal")[0].reset();
						                	$("#pfname").unbind("click");
						                    var inst = jQuery.jstree.reference(data.reference),  
						                    obj = inst.get_node(data.reference);  
						                    if(inst.is_parent(obj)){
						                    	toastr.info("请先清空该菜单下所有子菜单");
						                    	return ;
						                    }
						                    if(confirm("确定要删除此菜单？删除后不可恢复。")){
						                    	$.ajax({
						                    	   type: "POST",
						                    	   url: "functionController/queryFunction.do",
						                    	   data: "fid="+obj.id,
						                    	   success: function(msg){
						                    		   $.ajax({
								                    	   type: "POST",
								                    	   url: "functionController/deleteFunction.do",
								                    	   data: "fid="+obj.id+"&version="+msg.version,
								                    	   success: function(msg){
								                    		   if(msg.status){  
								                    			   toastr.success(msg.info);  
									                                inst.destroy();
								                    			    inittree();
								                    			    $(".form-horizontal")[0].reset();
									                            }else{  
									                            	toastr.error(msg.info);  
									                            }
								                    	   }
								                    	});
						                    	   }
						                    	});
						                    }  
						                }  
						            },  
						            "修改菜单":{  
						                "label":"修改菜单",  
						                "action":function(data){  
						                	$(".form-horizontal")[0].reset();
						                    var inst = jQuery.jstree.reference(data.reference),  
						                    obj = inst.get_node(data.reference);  
						                    $.ajax({
						                    	   type: "POST",
						                    	   url: "functionController/queryFunction.do",
						                    	   data: "fid="+obj.id,
						                    	   success: function(msg){
						                    		   $("#fid").val(msg.fid);
						                    		   $("#fname").val(msg.fname);
						                    		   $("#furl").val(msg.furl);
						                    		   $("#pfid").val(msg.pfid);
						                    		   $("#menu_type").val(msg.menu_type);
						                    		   $("#sort").val(msg.sort);
						                    		   $("#is_on").val(msg.is_on);
						                    		   $("#version").val(msg.version);
						                    		   $("input[name='is_on']").each(function(){
						                    			   if($(this).val()==msg.is_on){
						                    				   $(this).attr("checked",'checked'); 
						                    			   }
						                    		   });
						                    		   $("#pfname").val(inst.get_node(inst.get_parent(data.reference)).text);
						                    		   $(".form-actions").show("fast");
						                    		   $(".caption").html('<i class="icon-reorder"></i>修改链接信息');
						                    	   }
						                    	});
						                    $("#pfname").unbind("click");
						                    $("#pfname").click(function(){
						           			 chooseParent();
						           		 	});
						                    var formvalidate=bindformvalidate(".form-horizontal",{
						                    	fname: {
						                            required: true
						                        },
						                        furl: {
						                            required: true
						                        },
						                        pfname:{
						                        	required: true
						                        },
						                        pfname:{
						                        	required: true
						                        },
						                        menu_type_name:{
						                        	required: true
						                        },							                        
						                        sort:{
						                        	required: true,
						                        	digits:true
						                        }
						               	   },{
						               	   });
						                    $("button[type='submit']").unbind("click");
					                    	$("button[type='submit']").click(function(){
					                    		if(formvalidate.form()){
						                    		$.ajax({
					                    			   type: "POST",
					                    			   url: "functionController/updateFunction.do",
					                    			   data: $(".form-horizontal").serialize(),
					                    			   success: function(msg){
					                    				   if(msg.status){
						                    				   toastr.success(msg.info);
						                    			     inst.destroy();
						                    			     inittree();
						                    			     $(".form-actions").hide("fast");
						                    			     $(".form-horizontal")[0].reset();
						                    			     formvalidate.resetForm();
						                    			     $(".form-horizontal img[src='media/image/right_1.png']").parent().remove();
						                    			     $(".form-horizontal img[src='media/image/error.png']").parent().remove();
					                    				   }else{
					           	                        	toastr.error(msg.info);
					                                       }
					                    			   }
					                    			});
					                    		}
					                    	});
						                }  
						            }  
						        }  
						      },
						  "plugins" : [
						    "contextmenu", "dnd", "search",
						    "state", "types", "wholerow"
						  ]
				   });
			   }
			});
	}
	
	function chooseParent(){
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
				   $('#choosenodetree').on("click.jstree",function(e, data) {
						var nodes = $.jstree.reference('#choosenodetree').get_selected(
								true);
						for (var i = 0; i < nodes.length; i++) {
								$('#choosenodetree').jstree(true).uncheck_all();
								$('#choosenodetree').jstree(true).check_node(
										$('#choosenodetree').jstree(true).get_node(
												nodes[i].id, true));
						}
					});
				   $("#function_model .modal-footer button:last").unbind("click");
				   $("#function_model .modal-footer button:last").click(function(){
					   var nodes = $.jstree.reference('#choosenodetree').get_selected(true);
					   if(nodes.length==1){
						   var node=nodes[0];
						   $("#pfid").val(node.id);
						   $("#pfname").val(node.text);
						   $("#function_model").modal('hide');
					   }
				   });
				$("#function_model").modal('show');
			   }
		   });
	}
	inittree();
	 $('#jstree_demo').on("ready.jstree",function(e, data) {
		$("#jstree_demo").jstree("close_all");
	});
</script>
	<div>
		<div id="jstree_demo" style="width: 30%;float: left;"></div>
		<div style="width: 40%;float:left;margin-left: 20%">
			<!-- BEGIN VALIDATION STATES-->

						<div class="portlet box blue">

							<div class="portlet-title">

								<div class="caption"><i class="icon-reorder"></i>链接信息</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form action="javascript:;" class="form-horizontal">

									<div class="control-group">

										<label class="control-label" for="inputWarning" style="width: 70px">链接名称</label>

										<div class="controls" style="margin-left:75px;">
											<input type="hidden" id="fid" name="fid">
											<input type="text" id="fname" name="fname" class="span6 m-wrap" id="inputWarning" style="width: 200px;"/>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label" for="inputError" style="width: 70px">链接url</label>

										<div class="controls" style="margin-left:75px;">

											<input type="text" id="furl" name="furl" class="span6 m-wrap" id="inputError" style="width: 200px;"/>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label" for="inputSuccess" style="width: 70px">父链接名称</label>

										<div class="controls" style="margin-left:75px;">
											<input type="hidden" id="pfid" name="pfid">
											<input type="text" id="pfname" name="pfname" class="span6 m-wrap" id="inputSuccess" style="width: 200px;"/>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label" style="width: 70px">菜单级别</label>

										<div class="controls input-icon" style="margin-left:75px;">
											<input type="hidden" id="version" name="version">
											<select name="menu_type" id="menu_type">
												<option value="1">一级菜单</option>
												<option value="2">二级菜单</option>
												<option value="3">三级菜单</option>
												<option value="4">控件菜单</option>
											</select>
										</div>

									</div>

									<div class="control-group">

										<label class="control-label" style="width: 70px">排序</label>

										<div class="controls input-icon" style="margin-left:75px;">

											<input type="text" id="sort" name="sort" class="span6 m-wrap" style="width: 200px;"/>
										</div>

									</div>
									<div class="control-group">

										<label class="control-label" style="width: 70px">是否启用</label>

										<div class="controls">

											<label class="radio line">

											<input type="radio" name="is_on" value="1" />

											启用

											</label>

											<label class="radio line">

											<input type="radio" name="is_on" value="0" />

											不启用

											</label> 

											<div id="form_2_membership_error"></div>

										</div>

									</div>

									<div class="form-actions" style="display: none;">

										<button type="submit" class="btn blue">保存</button>

										<button type="reset" class="btn">重置</button>

									</div>

								</form>

								<!-- END FORM-->

							</div>
							</div>
		</div>
	</div>
	<!-- 按钮触发模态框 -->
			<div class="modal fade" id="function_model" tabindex="-1" role="dialog" 
												   aria-labelledby="function_model_ModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			  <div class="modal-content">
				 <div class="modal-header">
					<button type="button" class="close" 
					   data-dismiss="modal" aria-hidden="true">
					</button>
					<h4 class="modal-title" id="function_model_ModalLabel">
						选择父级链接
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
