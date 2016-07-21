Date.prototype.pattern=function(fmt) {           
    var o = {           
    "M+" : this.getMonth()+1, //月份           
    "d+" : this.getDate(), //日           
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时           
    "H+" : this.getHours(), //小时           
    "m+" : this.getMinutes(), //分           
    "s+" : this.getSeconds(), //秒           
    "q+" : Math.floor((this.getMonth()+3)/3), //季度           
    "S" : this.getMilliseconds() //毫秒           
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
    oDate1  =  new  Date(aDate[1]  +  '/'  +  aDate[2]  +  '/'  +  aDate[0]);   //转换为dd-MM-YYYY  
    aDate  =  sDate2.split("-");
    oDate2  =  new  Date(aDate[1]  +  '/'  +  aDate[2]  +  '/'  +  aDate[0]);
    iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24); //把相差的毫秒数转换为天数  
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