$.extend($.validator.messages, {
	required : "不能为空",
	remote : "请修正此字段",
	email : "请输入有效的电子邮件地址",
	url : "请输入有效的网址",
	date : "请输入有效的日期",
	dateISO : "请输入有效的日期 (YYYY-MM-DD)",
	number : "请输入有效的数字",
	digits : "只能输入数字",
	creditcard : "请输入有效的信用卡号码",
	equalTo : "你的输入不相同",
	extension : "请输入有效的后缀",
	maxlength : $.validator.format("最多可以输入 {0} 个字符"),
	minlength : $.validator.format("最少要输入 {0} 个字符"),
	rangelength : $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
	range : $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
	max : $.validator.format("请输入不大于 {0} 的数值"),
	min : $.validator.format("请输入不小于 {0} 的数值")
});
jQuery.validator.addMethod("synccodeonly", function(value, element) {
	if ("" == value||null==value) {
		return false;
	}
	try {
		var ret = false;
		$.ajax({  
	         type : "post",  
	          url : "iSync/validate_Sync_code.do",  
	          data : "sync_code=" + value,  
	          async : false,  
	          success : function(data){  
	        	  ret = data.status;
	          }  
	     }); 
		return ret;
	} catch (e) {
		return false;
	}
}, "同步码不能为空或已被使用");
jQuery.validator.addMethod("dsnameonly", function(value, element) {
	if ("" == value||null==value) {
		return false;
	}
	try {
		var ret = false;
		$.ajax({  
			type : "post",  
			url : "dataSourceController/validate_ds_name.do",  
			data : "ds_name=" + value,  
			async : false,  
			success : function(data){  
				ret = data.status;
			}  
		}); 
		return ret;
	} catch (e) {
		return false;
	}
}, "数据源名称不能为空或已被使用");
jQuery.validator.addMethod("tabnameonly", function(value, element) {
	if ("" == value||null==value) {
		return false;
	}
	try {
		var ret = false;
		$.ajax({  
			type : "post",  
			url : "dataSourceTableController/validate_tab_name.do",  
			data : "tab_name=" + value+"&ds_id="+$(element).parent().parent().prev().find("select").val(),  
			async : false,  
			success : function(data){  
				ret = data.status;
			}  
		}); 
		return ret;
	} catch (e) {
		return false;
	}
}, "表名称不能为空或已创建表");
jQuery.validator.addMethod("colnameonly", function(value, element) {
	if ("" == value||null==value) {
		return false;
	}
	try {
		var ret = false;
		$.ajax({  
			type : "post",  
			url : "tableFieldController/validate_tab_id.do",  
			data : "tab_id=" + value,  
			async : false,  
			success : function(data){  
				ret = data.status;
			}  
		}); 
		return ret;
	} catch (e) {
		return false;
	}
}, "该表已建立字段");
jQuery.validator.addMethod("sinknameonly", function(value, element) {
	if ("" == value||null==value) {
		return false;
	}
	try {
		var ret = false;
		$.ajax({  
			type : "post",  
			url : "sinkController/validate_sink_name.do",  
			data : "sink_name=" + value,  
			async : false,  
			success : function(data){  
				ret = data.status;
			}  
		}); 
		return ret;
	} catch (e) {
		return false;
	}
}, "流向名称不能为空或已被使用");
jQuery.validator.addMethod("canalnameonly", function(value, element) {
	if ("" == value||null==value) {
		return false;
	}
	try {
		var ret = false;
		$.ajax({  
			type : "post",  
			url : "canalController/validate_canal_name.do",  
			data : "canal_name=" + value,  
			async : false,  
			success : function(data){  
				ret = data.status;
			}  
		}); 
		return ret;
	} catch (e) {
		return false;
	}
}, "canal名称不能为空或已被使用");
jQuery.validator.addMethod("regcolnameonly", function(value, element) {
	if ("" == value||null==value) {
		return false;
	}
	try {
		var ret = false;
		$.ajax({  
			type : "post",  
			url : "regularColumnController/validate_col_reg_name.do",
			data : "col_reg_name=" + value,  
			async : false,  
			success : function(data){  
				ret = data.status;
			}  
		}); 
		return ret;
	} catch (e) {
		return false;
	}
}, "字段规则名称不能为空或已被使用");
jQuery.validator.addMethod("regtabnameonly", function(value, element) {
	if ("" == value||null==value) {
		return false;
	}
	try {
		var ret = false;
		$.ajax({  
			type : "post",  
			url : "regularTableController/validate_reg_tab_name.do",   
			data : "reg_tab_name=" + value,  
			async : false,  
			success : function(data){  
				ret = data.status;
			}  
		}); 
		return ret;
	} catch (e) {
		return false;
	}
}, "表规则名称不能为空或已被使用");
jQuery.validator.addMethod("regnameonly", function(value, element) {
	if ("" == value||null==value) {
		return false;
	}
	try {
		var ret = false;
		$.ajax({  
			type : "post",  
			url : "regularController/validate_reg_name.do",  
			data : "reg_name=" + value,  
			async : false,  
			success : function(data){  
				ret = data.status;
			}  
		}); 
		return ret;
	} catch (e) {
		return false;
	}
}, "同步规则名称不能为空或已被使用");
jQuery.validator.addMethod("pkeyonly", function(value, element) {
	if ("" == value||null==value) {
		return false;
	}
	try {
		var ret = false;
		$.ajax({  
			type : "post",  
			url : "projectController/validate_p_key.do",  
			data : "p_key=" + value,  
			async : false,  
			success : function(data){  
				ret = data.status;
			}  
		}); 
		return ret;
	} catch (e) {
		return false;
	}
}, "项目标识不能为空或已被使用");
jQuery.validator.addMethod("ip_ports", function(value, element) {   
    var isjarfile = /((\d|[1-9]\d|1\d{2}|2[0-5][0-5])\.(\d|[1-9]\d|1\d{2}|2[0-5][0-5])\.(\d|[1-9]\d|1\d{2}|2[0-5][0-5])\.(\d|[1-9]\d|1\d{2}|2[0-5][0-5])(\:)(\d{1,5}))(,((\d|[1-9]\d|1\d{2}|2[0-5][0-5])\.(\d|[1-9]\d|1\d{2}|2[0-5][0-5])\.(\d|[1-9]\d|1\d{2}|2[0-5][0-5])\.(\d|[1-9]\d|1\d{2}|2[0-5][0-5])(\:)(\d{1,5})))*$/;
    return this.optional(element) || (isjarfile.test(value));
}, "请填写正确地址格式");
function bindformvalidate(selector, rules, messages) {
	return $(selector)
			.validate(
					{
						onfocusout : function(element) {
							$(element).valid();
						},
						rules : rules,
						// messages:messages,
						errorPlacement : function(error, element) {
							if ("" != error.html()
									&& element.parent().parent()
											.find("td:last").html() == "") {
								element.parent().parent().find("td:last").html(
										"<span style=\"width: 40%;color: red;\"><img src=\"media/image/error.png\"/>"
												+ error.html() + "</span>");
							} else if ("" != error.html()
									&& element.parent().parent()
											.find("td:last").html() != "") {
								element.parent().parent().find("td:last").html(
										"");
								element.parent().parent().find("td:last").html(
										"<span style=\"width: 40%;color: red;\"><img src=\"media/image/error.png\"/>"
												+ error.html() + "</span>");
							} else if ("" == error.html()
									&& element.parent().parent()
											.find("td:last").html() == "") {
								element
										.parent()
										.parent()
										.find("td:last")
										.html(
												"<span style=\"width: 40%;color: green;\"><img src=\"media/image/right_1.png\"/>验证成功</span>");
							} else if ("" == error.html()
									&& element.parent().parent()
											.find("td:last").html() != "") {
								element.parent().parent().find("td:last").html(
										"");
								element
										.parent()
										.parent()
										.find("td:last")
										.html(
												"<span style=\"width: 40%;color: green;\"><img src=\"media/image/right_1.png\"/>验证成功</span>");
							}
						},
						success : function(label) {
						}
					});
}