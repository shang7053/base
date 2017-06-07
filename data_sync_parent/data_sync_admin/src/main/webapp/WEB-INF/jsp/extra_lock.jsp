<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8" />
<title>锁屏</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />

<meta content="" name="author" />

<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />

<link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

<link href="media/css/style-metro.css" rel="stylesheet" type="text/css" />

<link href="media/css/style.css" rel="stylesheet" type="text/css" />

<link href="media/css/style-responsive.css" rel="stylesheet" type="text/css" />

<link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color" />

<link href="media/css/uniform.default.css" rel="stylesheet" type="text/css" />

<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL STYLES -->

<link href="media/css/lock.css" rel="stylesheet" type="text/css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body>

	<div class="page-lock">

		<div class="page-logo">
			<img src="media/image/yplogo.png" alt="logo" width="20%" onclick="window.open('http://www.voole.com')" />
		</div>

		<div class="page-body">

			<img class="page-lock-img" src="media/image/profile.jpg" alt="">

			<div class="page-lock-info">

				<h1>${user.realname }</h1>

				<span>${user.email }</span> <span><em>锁定</em></span>

				<form class="form-search" onsubmit="return unlock(this)" method="post">

					<div class="input-append">

						<input type="password" name="passwordcode" class="m-wrap" placeholder="密码">
						<button type="submit" class="btn blue icn-only">
							<i class="m-icon-swapright m-icon-white"></i>
						</button>
						<div style="display: none;margin-top: 5px;">
							<span style="margin-top: 5px;">bob@keenthemes.com</span>
						</div>

					</div>

					<div class="relogin">

						<a href="tologin.do">不是${user.realname } ?</a>

					</div>

				</form>

			</div>

		</div>

	</div>

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

<script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<script src="media/js/jquery.backstretch.min.js" type="text/javascript"></script>
	<!-- END PAGE LEVEL PLUGINS -->

	<script src="media/js/app.js"></script>

	<script src="media/js/lock.js"></script>

	<script>
		function unlock(e){
			try{
				if(e.passwordcode.value==""){
					$(".page-lock-info .form-search .input-append span").css("color","red");
					$(".page-lock-info .form-search .input-append span").html("密码不能为空");
			    	$(".page-lock-info .form-search .input-append div").show();
			    	return false;
				}
				$.ajax({
				   type: "POST",
				   url: "loginController/unlock.do",
				   data: "passwordcode="+e.passwordcode.value,
				   success: function(msg){
				    if(msg.status){
				    	$(".page-lock-info .form-search .input-append span").css("color","white");
				    	$(".page-lock-info .form-search .input-append span").html(msg.info);
				    	$(".page-lock-info .form-search .input-append div").show("fast",function(){
				    		setTimeout(function () { 
								$("#extra_lock_div").hide();
								is_lock=false;
				    	    }, 1000);
				    	});
				    }else{
				    	$(".page-lock-info .form-search .input-append span").css("color","red");
				    	$(".page-lock-info .form-search .input-append span").html(msg.info);
				    	$(".page-lock-info .form-search .input-append div").show();
				    }
				   }
				});
				return false;
			}catch(e){
				console.log(e);
				return false;
			}
		}
		jQuery(document).ready(function() {    

		   App.init();

		   Lock.init();

		});

	</script>

	<!-- END JAVASCRIPTS -->

	<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script>
</body>
<!-- END BODY -->

</html>