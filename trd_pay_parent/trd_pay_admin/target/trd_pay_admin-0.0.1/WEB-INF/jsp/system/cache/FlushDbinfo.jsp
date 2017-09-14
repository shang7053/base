<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="flushdb_form" action="javascript:;">
 	<table style="width: 100%;">
 		<tr style="display: none;">
 			<td><lable>编号</lable></td>
 			<td><input type="text" name="id" readonly="readonly" value="${FlushDbinfo.id}"  /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>上次ping通时间</lable></td>
 			<td><input type="text" name="last_ping_date" value="new Date().getTime()"  id="create_time""  /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>间隔时间失效时间</lable></td>
 			<td><input type="text" name="flush_cache_interval" value="${FlushDbinfo.flush_cache_interval}"  /></td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>间隔时间失效单位</lable></td>
 			<td>
 				<select name="interval_unit" >
 			  		<option value="1">年</option>
 					<option value="2">月</option>
 					<option value="3">周</option>
 					<option value="5">天</option> 
 					<option value="10">小时</option>
 					<option value="12">分钟</option>
 					<option value="13">秒</option>
 				</select>
 			</td>
 			<td></td>
 		</tr>
 		<tr>
 			<td><lable>是否启动</lable></td>
 			<td><select name="is_on" >
 				<option value="0">否</option>
 				<option value="1">是</option>
 				</select>
 			</td>
 			<td></td>
 		</tr>
 		<tr style="display: none;">
 			<td><lable>创建时间</lable></td>
 			<td><input type="text" value='<fmt:formatDate value="${FlushDbinfo.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'  /></td>
 			<td></td>
 		</tr>
 		<tr style="display: none;">
 			<td><lable>修改时间</lable></td>
 			<td><input type="text"  value='<fmt:formatDate value="${FlushDbinfo.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'/> </td>
 			<td></td>
 		</tr>
 	</table>
</form>
<script type="text/javascript">
$(function () {
	var time =formatDate(new Date().getTime(),"yyyy-MM-dd HH:mm:ss");
	$("#create_time").val(time);
	binddaterangepickerByTermlyj("#create_time","YYYY-MM-DD HH:mm:ss",true);
})

function binddaterangepickerByTermlyj(domid,fm,flag){
	$(domid).daterangepicker({
        dateLimit : {
            days : 30
        }, //起止时间的最大间隔
        singleDatePicker : true,
        showDropdowns : true,
        showWeekNumbers : false, //是否显示第几周
        timePicker : flag, //是否显示小时和分钟
        timePickerIncrement : 1, //时间的增量，单位为分钟
        timePicker12Hour : false, //是否使用12小时制来显示时间
        opens : 'right', //日期选择框的弹出位置
        buttonClasses : [ 'btn btn-default' ],
        applyClass : 'btn-small btn-primary blue',
        cancelClass : 'btn-small',
        format : fm, //控件中from和to 显示的日期格式
        separator : ' - ',
        locale : {
            applyLabel : '确定',
            cancelLabel : '取消',
            fromLabel : '起始时间',
            customRangeLabel : '自定义',
            daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
            monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
                '七月', '八月', '九月', '十月', '十一月', '十二月' ],
            firstDay : 1
        }
        
	}, function(start,end,label) {//格式化日期显示框
        $('#reportrange span').html(start.format('YYYY-MM-DD HH:mm:ss'));
    });
}


</script>
<style>
.daterangepicker.dropdown-menu {
  
  z-index: 10500;
}
</style>
