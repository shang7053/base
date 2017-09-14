<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="container" style="min-width: 910px; height: 400px">

</div>
<script>

		$(function() {
			buildHighcharts();
		});
		//渲染报表				
		function buildHighcharts() {
			var arrsCount = [];
			$.ajax({
				type : "post",
				url : 'home/getdata.do',
				success : function(data) {
					new Highcharts.Chart('container', {
						chart: {
					        type: 'column'
					    },
					    title: {
					        text: '今日支付对比'
					    },
					    subtitle: {
					        text: '数据来源：优朋云+'
					    },
					    xAxis: {
					        categories: [data.x]
					    },
					    yAxis: {
					        title: {
					            text: '元'
					        }
					    },
					    legend: {
					        enabled: false
					    },
					    series: [{
					        name: '今日总流水',
					        data:[data.total]
					    },{
					        name: '今日纯收入',
					        data:[data.receipt]
					    }]
				    });
				}
			});
		}
	</script>
