<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			   type: "POST",
			   url: "test",
			   data: 'jsondata={"pageinfo":[{"pagesize":"10","pageno":"1"}],"schoolid":"CN350104008000001001","opertype":"query","services":"serv_schoolstyle_query_two_info","sign":""}',
			   success: function(msg){
			     alert( "Data Saved: " + msg );
			   }
			});
	});
</script>
<title>Insert title here</title>
</head>
<body>
ewrwerewr
</body>
</html>