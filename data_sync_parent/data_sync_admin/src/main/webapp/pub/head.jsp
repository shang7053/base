<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0"> 
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link rel="stylesheet" type="text/css" href="media/css/daterangepicker.css" />
<link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
<link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="media/css/style-metro.css" rel="stylesheet" type="text/css" />
<link href="media/css/style.css" rel="stylesheet" type="text/css" />
<link href="media/css/style-responsive.css" rel="stylesheet" type="text/css" />
<link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color" />
<link href="media/css/uniform.default.css" rel="stylesheet" type="text/css" />
<link href="media/css/base.css" rel="stylesheet" type="text/css" />
<link href="media/js/toastr/toastr.min.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN CORE PLUGINS -->
<script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="media/js/bootstrap.min.js" type="text/javascript"></script>
<!--[if lt IE 9]>
	<script src="media/js/excanvas.min.js"></script>
	<script src="media/js/respond.min.js"></script>  
	<![endif]-->
<script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>
<script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>
<script src="media/js/jquery.uniform.min.js" type="text/javascript"></script>
<script src="media/js/daterangepicker.js"></script>     
<script src="media/js/moment.js"></script>     
<script src="media/js/datautil.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<script src="media/js/jquery-1.8.3.min.js" type="text/javascript"></script>   
<script src="media/js/jquery.pulsate.min.js" type="text/javascript"></script>
<script src="media/js/toastr/toastr.min.js"></script>
<script>
    toastr.options.escapeHtml = true;
    toastr.options.closeButton = true;
    toastr.options.positionClass = 'toast-top-center';
    toastr.options.preventDuplicates=true;
</script>
