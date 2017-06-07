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

								<div class="caption"><i class="icon-globe"></i>小时数据分析</div>

								<div class="tools">

									<a href="javascript:;" class="collapse"></a>

									<a href="javascript:;" class="remove"></a>

								</div>

							</div>

							<div class="portlet-body">

								<div class="clearfix">

									<table width="100%">
										<tr>
											<td width="80px;"><label>同步时间：</label></td>
											<td><input type="text" id="create_time"/>&nbsp;&nbsp;&nbsp;
												<button style="margin-bottom: 10px;" id="search_notices" class="btn green">
												分&nbsp&nbsp&nbsp析<i class="icon-search"></i>
												</button>
											</td>
											<td>
												
											</td>
										</tr>
									</table>
								</div>
								<br/>
								<br/>
								<!-- 报表 begin-->
								<div id="hour_container" style="height:400px"></div>
								<script type="text/javascript">
								
								$(function () {
									var time =new Date().toLocaleDateString()+" 00 - "+new Date().toLocaleDateString()+" 23";
									$("#create_time").val(new Date().toLocaleDateString()+" 00 - "+new Date().toLocaleDateString()+" 23");
									bulidxAxisArr(time);
									binddaterangepickerByTerm("#create_time","YYYY-MM-DD HH",true);
									$("#search_notices").click(function(){
										search();
									});
									hourtimer=setInterval(search,10000); 
									
								});
								function search(){
									var time=$.trim($("#create_time").val());
									bulidxAxisArr(time);
								}
								function bulidxAxisArr(time){
									var xAxisArr = [];
									$.ajax({
										type: "post",
										url:  'iSyncHour/querySyncTime.do',
										data: {sync_time:time},
										dataType: "json",
										success: function(data){
											$(data).each(function(i,item){
												xAxisArr.push(this.sync_time);
											});
											bulidSeries(xAxisArr,time);
										},
										error:function(data){
										}
									});
								}
								//数据构造
								function bulidSeries(xAxisArr,time){
									var seriesArr = [];
									$.ajax({
										type: "post",
										url:  'iSyncHour/querySyncHourDataList.do',
										data: {sync_time:time},
										dataType: "json",
										success: function(data){
											$(data).each(function(i,item){
												var arr = null;
												var strs=this.sco.split(","); //字符分割 
												var dataIntArr=[];//保存转换后的整型字符串  
											    strs.forEach(function(data,index,arr){  
											        dataIntArr.push(+data);  
											    });  
												//封装seriesArr数据
												arr={name: this.sync_code,data:dataIntArr};
												seriesArr.push(arr);
												
											});
											//曲线图渲染
											CommonChart.curveChart('hour_container','小时同步数量',xAxisArr,seriesArr)
										},
										error:function(data){
										}
									});
								}
								</script>
								<!-- 报表 end-->

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

	
</body>
<!-- END BODY -->
</html>