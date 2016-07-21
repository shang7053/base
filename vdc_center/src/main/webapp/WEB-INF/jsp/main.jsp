<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />
<jsp:include page="${basePath }/pub/head.jsp"></jsp:include>
	<title>云数据管理中心系统</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="云数据管理中心系统" />

	<meta content="" name="author" />

	<!-- BEGIN PAGE LEVEL STYLES --> 

	<link href="media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/daterangepicker.css" rel="stylesheet" type="text/css" />

	<link href="media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>

	<link href="media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="media/image/favicon.ico" />
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="media/js/jquery.vmap.js" type="text/javascript"></script>   

	<script src="media/js/jquery.vmap.russia.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.world.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.europe.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.germany.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.usa.js" type="text/javascript"></script>

	<script src="media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  

	<script src="media/js/jquery.flot.js" type="text/javascript"></script>

	<script src="media/js/jquery.flot.resize.js" type="text/javascript"></script>

	<script src="media/js/jquery.pulsate.min.js" type="text/javascript"></script>

	<script src="media/js/date.js" type="text/javascript"></script>

	<script src="media/js/daterangepicker.js" type="text/javascript"></script>     

	<script src="media/js/jquery.gritter.js" type="text/javascript"></script>

	<script src="media/js/fullcalendar.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>

	<script src="media/js/jquery.sparkline.min.js" type="text/javascript"></script>  

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js" type="text/javascript"></script>

	<script src="media/js/index.js" type="text/javascript"></script>        

	<!-- END PAGE LEVEL SCRIPTS -->  
	<script type="text/javascript">
		var is_lock=${lockstatus};
		function lock(){
			$("#extra_lock_div").load("extra_lock.do",function(){
				$("#extra_lock_div").show();
				is_lock=true;
			});
		}
		var locktimer=null;
		function jumppage(furl){
			if("javascript:;"!=furl&&"javascript:void(0);"!=furl){
				$("#dashboard").load(furl,function(responseTxt,statusTxt,xhr){
					if(statusTxt=="success"){
				    return;
				   }else{
					   window.location="extra_404_option3.jsp";
				   }
				  });
				if(null!=locktimer){
					clearInterval(locktimer);
				}
				locktimer=setInterval(function(){
					if(!is_lock){
						lock();
					}
				},600000);
				 
			}
		}
		function shownotices(title,context,nid,version){
			$("#notice_model_ModalLabel").html(title);
			$("#notice_model .modal-body").html(context);
			$("#notice_model .modal-footer button:gt(0)").unbind("click");
			$("#notice_model .modal-footer button:gt(0)").click(function(){
				$.ajax({
				   type: "POST",
				   url: "noticeController/setRead.do",
				   data: "nid="+nid+"&version="+version,
				   success: function(msg){
					   if(msg.status){
						    var number = $('#header_notification_bar .badge').text();
				            number = parseInt(number);
				            number = number -1;
				            $('#header_notification_bar .badge').text(number);
				            $('#notice_count').html("<p>你有"+number+"条未读系统消息</p>");
				            $('#header_notification_bar').pulsate({
				                color: "#66bce6",
				                repeat: 5
				            });
				            $("#notice_li_"+nid).remove();
							$("#notice_model").modal('hide');
					   }else{
						   window.location="login.jsp";
					   }
				   }
				});
			}); 
			$("#notice_model").modal('show');
		}
		$(function(){
			if(is_lock){
				lock();
			}
			$("#extra_lock").click(function(){
				lock();
			});
			setInterval(function(){
				$.ajax({
				   type: "POST",
				   url: "heartbeat.do",
				   success: function(msg){
					   if(!msg.status){
						   window.location="login.jsp";
					   }
				   },
				   error:function(){
					   window.location="login.jsp";
				   }
				});
			},300000); 
		});
		function turnnotice(){
			$(".page-sidebar-menu").find("a[aurl='noticeController/turnnotice.do']").trigger("click");
			var number = $('#header_notification_bar .badge').text();
            $('#header_notification_bar .badge').text("");
            $('#notice_count').html("<p>暂无未读系统消息</p>");
            $('#header_notification_bar').pulsate({
                color: "#66bce6",
                repeat: 5
            });
            $(".notification li[id^='notice_li_']").remove();
		}
	</script>
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">
	<div id="error_container" style="width: 100%;height: 100%;position:fixed; top:0; left: 0;z-index: 1;z-index: 20000;display: none;"></div>
	<div id="extra_lock_div" style="width: 100%;height: 100%;position:fixed; top:0; left: 0;z-index: 1;z-index: 20000;display: none;">
	</div>
	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<div class="container-fluid">

				<!-- BEGIN LOGO -->

				<a class="brand" href="index.html">

				<img src="media/image/yplogo.png" alt="logo" style="width: 50%;height: 5%;margin-top: -4%;" onclick="window.open('http://www.voole.com')"/>

				</a>

				<!-- END LOGO -->

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

				<img src="media/image/menu-toggler.png" alt="" />

				</a>          

				<!-- END RESPONSIVE MENU TOGGLER -->            

				<!-- BEGIN TOP NAVIGATION MENU -->              

				<ul class="nav pull-right">
					<!-- BEGIN NOTIFICATION DROPDOWN -->   

					<li class="dropdown" id="header_notification_bar">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

						<i class="icon-warning-sign"></i>

						<span class="badge">
							0
						</span>

						</a>

						<ul class="dropdown-menu extended notification">

							<li id="notice_count" >
								<p>暂无未读系统消息</p>
							</li>
						</ul>
					</li>

					<!-- END NOTIFICATION DROPDOWN -->

					<!-- BEGIN USER LOGIN DROPDOWN -->

					<li class="dropdown user">

						<a href="#" class="dropdown-toggle" data-toggle="dropdown">

						<img alt="" src="media/image/avatar1_small.jpg" />

						<span class="username">${user.realname }</span>

						<i class="icon-angle-down"></i>

						</a>

						<ul class="dropdown-menu">

							<li><a href="extra_profile.html"><i class="icon-user"></i> 个人信息</a></li>

							<li class="divider"></li>

							<li><a href="javascript:void(0)" id="extra_lock"><i class="icon-lock"></i> 锁屏</a></li>

							<li><a href="loginController/loginout.do"><i class="icon-key"></i> 退出</a></li>

						</ul>

					</li>

					<!-- END USER LOGIN DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU --> 

			</div>

		</div>

		<!-- END TOP NAVIGATION BAR -->

	</div>

	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->

	<div class="page-container">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->        

			<ul class="page-sidebar-menu">

				<li>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

					<div class="sidebar-toggler hidden-phone"></div>

					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

				</li>

				<!-- <li>

					BEGIN RESPONSIVE QUICK SEARCH FORM

					<form action="javascript:;" class="sidebar-search">

						<div class="input-box">

							<a href="javascript:;" class="remove"></a>

							<input type="text" id="searchfunction" placeholder="Search..." />

							<input type="button" class="submit" value=" " />

						</div>

					</form>

					END RESPONSIVE QUICK SEARCH FORM

				</li> -->
				<li class="start active ">
					<a href="javascript:;" aname="<i class='icon-home'></i> 主页" aurl="javascript:;">
					<i class="icon-home"></i> 
					<span class="title">主页</span>
					<span class="selected"></span>
					</a>
				</li>
				<c:forEach var="func_1" items="${user.functions }">
					<li class="">
						<a href="javascript:;" aname="<i class='icon-cogs'></i> ${func_1.fname }" aurl="${func_1.furl }"  onclick="jumppage('${func_1.furl }')">
							<i class="icon-cogs"></i> 
							<span class="title">${func_1.fname }</span>
							<c:if test="${!empty func_1.childFuncs}">
								<span class="arrow"></span>
							</c:if>
						</a>
						<c:if test="${!empty func_1.childFuncs}">
							<ul class="sub-menu">
								<c:forEach var="func_2" items="${func_1.childFuncs }">
									<li >
										<a href="javascript:;" aname="${func_2.fname }" aurl="${func_2.furl }" onclick="jumppage('${func_2.furl }')">
											${func_2.fname }
											<c:if test="${!empty func_2.childFuncs}">
												<span class="arrow"></span>
											</c:if>
										</a>
										<c:if test="${!empty func_2.childFuncs}">
											<ul class="sub-menu">
												<c:forEach var="func_3" items="${func_2.childFuncs }">
													<li >
														<a href="javascript:;" aname="${func_3.fname }" aurl="${func_3.furl }" onclick="jumppage('${func_3.furl }')">
															${func_3.fname }
														</a>
													</li>
												</c:forEach>
											</ul>
										</c:if>
									</li>
								</c:forEach>
							</ul>
						</c:if>
					</li>
				</c:forEach>
			</ul>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12" style="margin-top: 10px;">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="index.html">主页</a> 
							</li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<div id="dashboard">
						


			<!-- END PAGE CONTAINER-->    

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->
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
						系统消息
					</h4>
				 </div>
				 <div class="modal-body">
				 </div>
				 <div class="modal-footer">
					<button type="button" class="btn btn-default" 
					   data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary">
					   设为已读
					</button>
				 </div>
			  </div><!-- /.modal-content -->
			</div><!-- /.modal -->
			</div>
			</div>
	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">

			2016 &copy; power by scc.

		</div>

		<div class="footer-tools">

			<span class="go-top">

			<i class="icon-angle-up"></i>

			</span>

		</div>

	</div>

	<!-- END FOOTER -->
	<script>
		var lastnoticetime=null;
		jQuery(document).ready(function() {    

		   App.init(); // initlayout and core plugins

		   Index.init();
		   Index.initIntro('${basePath}',lastnoticetime);
		   lastnoticetime=new Date();
		   setInterval(function () {
			   Index.initIntro('${basePath}',lastnoticetime);
			   lastnoticetime=new Date();
       	   }, 600000);

		});

	</script>

	<!-- END JAVASCRIPTS -->

<!-- END BODY -->

</html>