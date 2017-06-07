/**
 * @Description：hightcharts公共组件工具类
 * @author：Ma Zhen  
 */
CommonChart = {

	columnChart : function(arr, id) {
		$("#"+id).highcharts({
		       chart: {
		           type: 'column'
		       },
		       title: {
		           text: '今日同步数量'
		       },
		       subtitle: {
		           text: '数据来源：优朋云+'
		       },
		       credits: {
		          enabled:false
			   },
		       xAxis: {
		           type: 'category'
		       },
		       yAxis: {
		           title: {
		               text: '同步数量'
		           }
		       },
		       legend: {
		           enabled: false
		       },
		       plotOptions: {
		           series: {
		               borderWidth: 0,
		               dataLabels: {
		                   enabled: true,
		                   format: '{point.y:.1f}'
		               }
		           }
		       },
		       tooltip: {
		           headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
		           pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}</b> total<br/>'
		       },
		       series: [{
		           name: '今日同步数量',
		           colorByPoint: true,
		           data: arr
		       }]
		   });
	},
	
	 curveChart : function(id,title,xAxisArr,seriesArr) {
		 $("#"+id).highcharts({
		    title: {
		        text: title,
		        x: -20
		    },
		    subtitle: {
		        text: '数据来源: 优朋云+',
		        x: -20
		    },
		    credits: {
		          enabled:false
		    },
		    xAxis: {
		        categories: xAxisArr
		    },
		    yAxis: {
		        title: {
		            text: '同步数量'
		        },
		        plotLines: [{
		            value: 0,
		            width: 1,
		            color: '#808080'
		        }]
		    },
		    tooltip: {
		        valueSuffix: ''
		    },
		    legend: {
		        layout: 'vertical',
		        align: 'right',
		        verticalAlign: 'middle',
		        borderWidth: 0
		    },
		    series: seriesArr
		});
		
	}
	
}	