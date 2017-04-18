var notiescontextmap={};
var Index = function () {


    return {

        //main function to initiate the module
        init: function () {
        	
            App.addResponsiveHandler(function () {
                jQuery('.vmaps').each(function () {
                    var map = jQuery(this);
                    map.width(map.parent().width());
                });
            });
        },

        initIntro: function (basePath,sdate) {
        	var date=sdate;
        	if(null==sdate||""==sdate){
        		sdate="";
        	}else{
        		sdate=formatDate(sdate.getTime(),"yyyy-MM-dd HH:mm:ss");
        	}
        	$.ajax({
				   type: "POST",
				   url: basePath+"noticeController/querynotices.do",
				   data:"date="+sdate,
				   success: function(msg){
					   if(0==msg.countNotifications){
						   return;
					   }
					   var number = $('#header_notification_bar .badge').text();
			            number = parseInt(number);
			            number = number + msg.countNotifications;
			            $('#header_notification_bar .badge').text(number);
			            $('#notice_count').html("<p>你有"+number+"条未读系统消息</p>");
			            $('#header_notification_bar').pulsate({
			                color: "#66bce6",
			                repeat: 5
			            });
					   $.extend($.gritter.options, {
			                position: 'bottom-right'
			            });
					   	var notifications=msg.notifications;
					   	var tips=[];
					   	var html="";
					   	for(var i=0;i<notifications.length;i++){
					   		var context=notifications[i].context;
					   		if(context.length>20){
					   			context=context.substring(0,25)+"……";
					   		}
					   		var unique_id = $.gritter.add({
					   			// (string | mandatory) the heading of the notification
					   			title: notifications[i].title,
					   			// (string | mandatory) the text inside the notification
					   			text: context,
					   			// (string | optional) the image to display on the left
					   			image1: './media/image/image1.jpg',
					   			// (bool | optional) if you want it to fade out on its own or just sit there
					   			sticky: true,
					   			// (int | optional) the time you want it to be alive for before fading out
					   			time: '',
					   			// (string | optional) the class name you want to apply to that specific message
					   			class_name: 'my-sticky-class'
					   		});
					   		tips[i]=unique_id;
				            html+="<li id=\"notice_li_"+notifications[i].nid+"\">";
				            var key=notifications[i].nid;
				            notiescontextmap[key]=notifications[i].context;
				            html+="<a href=\"javascript:;\" onclick=\"shownotices('"+notifications[i].title+"',"+notifications[i].nid+","+notifications[i].version+")\">";
				            html+="&nbsp&nbsp<span class=\"label label-warning\"><i class=\"icon-bell\"></i></span>";
				            html+=notifications[i].title;
			            	html+="&nbsp&nbsp&nbsp<span class=\"time\">";
			            	html+=formatDate(notifications[i].create_time,"yyyy-MM-dd HH:mm:ss");
			            	html+=" </span>";
		            		html+="</a>";
	            			html+="</li>";
					   	}
					   	html+="<li class=\"external\">";
					   	html+="<a href=\"javascript:;\" onclick=\"turnnotice()\">查看全部消息 <i class=\"m-icon-swapright\"></i></a>";
					   	html+="</li>";
					   	$(".notification").append(html);
					   	var count=notifications.length;
				   		var timer =setInterval(function () {
				   			--count;
				   			if(count<1){
				   				clearInterval(timer);
				   			}
			                $.gritter.remove(tips[count], {
			                    fade: true,
			                    speed: 'slow'
			                });
			            }, 4000);
				   },
				   error:function(){
					   window.location="login.jsp";
				   }
			});
        }

    };

}();