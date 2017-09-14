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
				url : 'analysis/getdata.do',
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
					        categories: ['累计']
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
					        name: '累计总流水',
					        data:[data.total]
					    },{
					        name: '累计纯收入',
					        data:[data.receipt]
					    }]
				    });
				}
			});
		}
	</script>
