<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="container1" style="min-width: 910px; height: 400px"></div>
<script>
		$(function() {
			buildHighcharts();
			hometimer = setInterval(buildHighcharts, 10000);
		});
		//渲染报表				
		function buildHighcharts() {
			var arrsCount = [];
			$.ajax({
				type : "post",
				url : 'iSyncHome/querySyncHourList.do',
				dataType : "json",
				success : function(data) {
					$(data).each(function(i, item) {
						var arr = null;
						arr = {
							name : this.sync_code,
							y : this.count
						};
						arrsCount.push(arr);

					});
					//柱状图渲染	
					CommonChart.columnChart(arrsCount, 'container1');
				},
				error : function(data) {
				}
			});

		}
	</script>
