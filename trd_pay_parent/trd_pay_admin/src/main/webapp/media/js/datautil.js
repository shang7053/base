Date.prototype.pattern=function(fmt) {           
    var o = {           
    "M+" : this.getMonth()+1, //鏈堜唤           
    "d+" : this.getDate(), //鏃�          
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //灏忔椂           
    "H+" : this.getHours(), //灏忔椂           
    "m+" : this.getMinutes(), //鍒�          
    "s+" : this.getSeconds(), //绉�          
    "q+" : Math.floor((this.getMonth()+3)/3), //瀛ｅ害           
    "S" : this.getMilliseconds() //姣           
    };           
    var week = {           
    "0" : "/u65e5",           
    "1" : "/u4e00",           
    "2" : "/u4e8c",           
    "3" : "/u4e09",           
    "4" : "/u56db",           
    "5" : "/u4e94",           
    "6" : "/u516d"          
    };           
    if(/(y+)/.test(fmt)){           
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));           
    }           
    if(/(E+)/.test(fmt)){           
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);           
    }           
    for(var k in o){           
        if(new RegExp("("+ k +")").test(fmt)){           
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));           
        }           
    }           
    return fmt;           
}         
function formatDate(longdate,partten){
	return null==longdate?"":new Date(longdate).pattern(partten);
}
function  DateDiffs(id,days){
	var time = $("#"+id).val();
	var sDate1 = time.split(" - ")[0];
	var sDate2 = time.split(" - ")[1];
    var  aDate,  oDate1,  oDate2,iDays  ;
    aDate  =  sDate1.split("-");
    oDate1  =  new  Date(aDate[1]  +  '/'  +  aDate[2]  +  '/'  +  aDate[0]);   //杞崲涓篸d-MM-YYYY  
    aDate  =  sDate2.split("-");
    oDate2  =  new  Date(aDate[1]  +  '/'  +  aDate[2]  +  '/'  +  aDate[0]);
    iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24); //鎶婄浉宸殑姣鏁拌浆鎹负澶╂暟  
    if(days<iDays){
    	return false;
    }
    return true;
}
function addDate(date,days){ 
	var d=new Date(date); 
	d.setDate(d.getDate()+days); 
	var month=d.getMonth()+1; 
	var day = d.getDate(); 
	if(month<10){ 
	month = "0"+month; 
	} 
	if(day<10){ 
	day = "0"+day; 
	} 
	return d; 
}
function binddaterangepicker(domid){
	$(domid).daterangepicker(
		{
		},
		function(start, end, label) {
			$("#queryStart").val(formatDate(start._d.getTime(),"yyyy-MM-dd")+" 00:00:00");
			$("#queryEnd").val(formatDate(end._d.getTime(),"yyyy-MM-dd")+" 23:29:59");
		}
	);
	var startdate=formatDate(addDate(new Date(),-7).getTime(),"yyyy-MM-dd");
	var enddate=formatDate(new Date().getTime(),"yyyy-MM-dd");
	$(domid).val(startdate+" - "+enddate);
	$("#queryStart").val(startdate+" 00:00:00");
	$("#queryEnd").val(enddate+" 23:29:59");
	$(domid).data('daterangepicker').setStartDate(startdate);
	$(domid).data('daterangepicker').setEndDate(enddate);
}

function binddaterangepickerByTerm(domid,fm,flag){
	$(domid).daterangepicker({
        dateLimit : {
            days : 30
        }, //起止时间的最大间隔
        showDropdowns : true,
        showWeekNumbers : false, //是否显示第几周
        timePicker : flag, //是否显示小时和分钟
        timePickerIncrement : 60, //时间的增量，单位为分钟
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
            toLabel : '结束时间',
            customRangeLabel : '自定义',
            daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
            monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
                '七月', '八月', '九月', '十月', '十一月', '十二月' ],
            firstDay : 1
        }
    }, function(start, end, label) {//格式化日期显示框
        $('#reportrange span').html(start.format('YYYY-MM-DD HH:mm:ss') + ' - ' + end.format('YYYY-MM-DD HH:mm:ss'));
    });
}