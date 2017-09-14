function gettables(url,aoColumnDefs,fnServerParams,defaultsize){
	return {
			"oLanguage": {
				"oAria":{
			      "sSortAscending": " - click/return to sort ascending",
			      "sSortDescending": " - click/return to sort descending"
			    },
				"sProcessing": "正在加载数据...",
				"sZeroRecords": "没有数据显示！",
				"sEmptyTable": "没有数据显示！",
				"sLoadingRecords": "请稍候 ,数据正在加载...",
				"sLengthMenu": "每页显示 _MENU_ 条",
				"sInfo":"显示  _START_ 到 _END_ 共 _TOTAL_ 条记录",
				"sInfoEmpty":"记录数为 0 ",
				"oPaginate": {
					"sFirst": "首页",
					"sLast": "尾页",
					"sNext": "下一页",
					"sPrevious": "上一页"
				}
			},
	        "bServerSide": true,
	        "bStateSave": false,
	        "bFilter": false,
	        "bDestroy":true,
	        "bRetrieve": true,
	        "bProcessing":true,
	        "iDisplayLength": parseInt(defaultsize),
	        "bAutoWidth":false,
	        'bPaginate': true,
	        "aoColumnDefs" :aoColumnDefs ,
	        "sAjaxSource" : url,
	        "fnServerData" : function(sSource, aoData,fnCallback) {
	            $.ajax({
	                "dataType" : 'json',
	                "type" : "get",
	                "url" : sSource,
	                "data" : aoData,
	                "success" : function(data){
	                    fnCallback(data);
	                }
	            });
	        },
	        "fnServerParams" : fnServerParams,
	        //生成序号
	        "fnDrawCallback" : function(oSettings) {
	            var that = this;
	            this.$('td:first-child', {"filter" : "applied"}).each(function(i) {
	                that.fnUpdate(i + 1,this.parentNode, 0,false, false);
	            });
	            jQuery('#sample_1_wrapper .dataTables_filter input').addClass("m-wrap medium"); // modify table search input
	            jQuery('#sample_1_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
	            jQuery('#sample_1_wrapper .dataTables_length select').select2(); // initialzie select2 dropdown
	        }	
	}
}