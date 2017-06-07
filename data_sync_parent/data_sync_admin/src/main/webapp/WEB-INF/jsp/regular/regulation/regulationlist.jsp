<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-10
  Time: 下午1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="vooletag" uri="http://tag.voole.com/" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />
    <link rel="stylesheet" href="media/css/DT_bootstrap.css" />
    <script src="media/js/jquery.validate.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="media/js/formvalidate.js"></script>
    <!-- END PAGE LEVEL STYLES -->
    <link rel="shortcut icon" href="media/image/favicon.ico" />
</head>
<!-- BEGIN BODY -->

<body class="page-header-fixed">

<!-- BEGIN PAGE CONTAINER-->

<div class="container-fluid">

    <!-- BEGIN PAGE CONTENT-->

    <div class="row-fluid">

        <div class="span12">

            <!-- BEGIN EXAMPLE TABLE PORTLET-->

            <div class="portlet box light-grey" style="min-height: 550px;">

                <div class="portlet-title">

                    <div class="caption"><i class="icon-globe"></i>表配置</div>

                    <div class="tools">

                        <a href="javascript:;" class="collapse"></a>

                        <a href="javascript:;" class="remove"></a>

                    </div>

                </div>

                <div class="portlet-body">

                    <div class="clearfix">

                        <table width="100%">
                            <tr>
                                <td width="50px;"><label>规则名称：</label></td>
                                <td>
                                    <td><input type="text" id="search_reg_name_id"/></td>
                                </td>
                                <td width="50px;"><label>是否启用：</label></td>
                                <td>
                                    <select id="is_on_search_id">
                                        <option value="">请选择</option>
                                        <option value="1">是</option>
                                        <option value="0">否</option>
                                    </select>
                                </td>
                                <td></td>
                                <td align="right">
                                    <button id="search_setttings" class="btn green">
                                        查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td align="right">
                                    <vooletag:permission url="regularController/turnCreateRegular.do">
                                        <button id="create_regular" class="btn green">
                                            新&nbsp&nbsp&nbsp建 <i class="icon-plus"></i>
                                        </button>
                                    </vooletag:permission>
                                </td>
                            </tr>
                        </table>

                    </div>

                    <table class="table table-striped table-bordered table-hover" id="sample_1">

                        <thead>

                        <tr>

                            <th style="width:8px;">序号</th>
                            <th>规则名称</th>
                            <th class="hidden-480">数据源</th>
                            <th class="hidden-480">表名称</th>
                            <th class="hidden-480">状态</th>
                            <th>操作</th>
                        </tr>

                        </thead>

                        <tbody>

                        </tbody>

                    </table>

                </div>

            </div>

            <!-- END EXAMPLE TABLE PORTLET-->

        </div>

    </div>
    <!-- END PAGE CONTENT-->

</div>

<!-- END PAGE CONTAINER-->

</div>

<!-- END PAGE -->

</div>

<!-- END CONTAINER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

<!-- BEGIN PAGE LEVEL PLUGINS -->

<script type="text/javascript" src="media/js/select2.min.js"></script>

<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>

<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>
<script src="media/js/datatableutil.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->

<!-- BEGIN PAGE LEVEL SCRIPTS -->

<script src="media/js/table-managed.js"></script>


<script>

    // 加载设置数据源名称
    var optionStr = "";
    var optionAvaDsStr ="";
    $("#selectDs").load(
            "dataSourceController/queryDataSource.do",
            null,
            function(response) {
                var json =  JSON.parse(response);
                var data = json.aaData;
                var resultStr="";
                var result = "";
                $.each(data, function(index, object){
                    resultStr += "<option value=" +object.ds_id+ ">" +object.ds_name+ "</option>";
                    if(object.ds_status==1 && object.is_on==1){
                        result += "<option value=" +object.ds_id+ ">" +object.ds_name+ "</option>";
                    }
                });
                $("#selectDs").append("<option value=''>请选择</option>" + resultStr);
                $("#selectTs").append("<option value=''>请选择</option>");
                $("#search_colname_text_id").append("<option value=''>请选择</option>");
                optionStr=resultStr;
                optionAvaDsStr = result;
            }
    );

    //搜索框　数据源联动
    $("#selectDs").change(function(){
        $("#selectTs").empty();
        $("#search_colname_text_id").empty();
        $("#search_colname_text_id").append("<option value=''>请选择</option>");
        changeDs();
    });
    // 搜索框　表联动
//    $("#selectTs").change(function(){
//        $("#search_colname_text_id").empty();
////        changeTs();
//    });

    /**
     *
     * ds联动函数
     * */
    var optionTabStr="";
    function changeDs() {
        if ($("#selectDs").val() == "") {
            $("#selectTs").empty();
            $("#selectTs").append("<option value=''>请选择</option>");
        } else {
            $("#selectTs").load(
                    "dataSourceController/queryDataSourceTables.do",
                    {ds_id: $("#selectDs").val()},
                    function (response) {
                        var result = "";
                        var responseJSON = JSON.parse(response);
                        $.each(responseJSON, function (index, json) {
//                            debugger
                            result += "<option value="+json.tab_name+">" + json.tab_name + "</option>";
                        });
                        optionTabStr = result;
                        $("#selectTs").append("<option value=''>请选择</option>" + result);

                    }
            );
        }
    }

    /**
     * 查询表格数据
     * */
    var ruletablesettings=gettables("regularController/queryRegular.do",[
        {
            "mData" : "reg_id",
            "sWidth" : "50px",
            "bSortable" : false,
            "aTargets" : [ 0 ]
        },{
            "mData" : "reg_name",
            "sWidth" : "150px",
            "aTargets" : [ 1 ],
            "bSortable" : false
        },{
            "mData" : "ds_name",
            "sWidth" : "150px",
            "aTargets" : [ 2 ],
            "bSortable" : false
        },{
            "mData" : "tab_name",
            "sWidth" : "150px",
            "aTargets" : [ 3 ],
            "bSortable" : false
        },{
            "mData" : "is_on",
            "sWidth" : "100px",
            "aTargets" : [ 4 ],
            "bSortable" : false,
            "mRender" :function(data,type,full){
                var html='';
                if(data == "0"){
                    html="<span style='color: red'>未启用</span>";
                }else{
                    html="<span style='color: green'>启用</span>";
                }
                return html;
            }
        },{
            "mData" : "reg_id",
            "sClass" : "center",
            "sWidth" : "50px",
            "aTargets" : [ 5 ],
            "bSortable" : false,
            "mRender" : function(data, type,full) {
                var dHtml = "";
                dHtml+='<div class="btn-group">';
                dHtml+='<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:;">';
                dHtml+='工具 <i class="icon-angle-down"></i>';
                dHtml+='</a>';
                dHtml+='<ul class="dropdown-menu">';
                dHtml+='<vooletag:permission url="regularController/turnRegularInfo.do"><li><a href="javascript:void(0)" onclick="showinfo(\''+ data+ '\',\''+full.version+'\');"><i class="icon-info"></i>&nbsp详情</a></li></vooletag:permission>';
                if(full.is_on=="0"){
                    dHtml+='<vooletag:permission url="regularController/switchon.do"><li><a href="javascript:void(0)" onclick="startSettings(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ok"></i>&nbsp启用</a></li></vooletag:permission>';
                }else{
                    dHtml+='<vooletag:permission url="regularController/switchoff.do"><li><a href="javascript:void(0)" onclick="forbidden(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ban-circle"></i>&nbsp禁用</a></li></vooletag:permission>';
                }
                dHtml+='<vooletag:permission url="regularController/deleteRegularConfig.do"><li><a href="javascript:void(0)" onclick="deleteConfig(\''+ data+ '\',\''+full.version+'\');"><i class="icon-remove"></i>&nbsp删除</a></li></vooletag:permission>';
                <%--dHtml+='<vooletag:permission url="dataSourceTableController/deleteTableConfig.do"><li><a href="javascript:void(0)" onclick="deleteTableConfig(\''+ data+ '\',\''+full.version+'\');"><i class="icon-remove"></i>&nbsp删除</a></li></vooletag:permission>';--%>

                dHtml+='</ul>';
                dHtml+='</div>';
                return dHtml;
            }
        }],function(aoData) {//重要设置，可通过此设置添加额外查询参数
        aoData.push({
            "name" : "reg_name",
            "value" : $.trim($("#search_reg_name_id").val())
        },{
            "name" : "is_on",
            "value" : $.trim($("#is_on_search_id").val())
        });
    },'${tablesize == null ? 10 : tablesize}');

    /**
     * 查询点击事件
     * */
    $("#search_setttings").click(function(){
        $('#sample_1').dataTable( ruletablesettings).fnDraw();
    });

    /**
     * 显示表配置记录详情
     * @param id
     * @param version
     */
    function showinfo(id,version){

        $("#regular_model").modal("show");
        $("#regular_model .modal-title").html("详情");
        $("#regular_div").load("regularController/turnRegularInfo.do",{"reg_id":id},function(){
            $("#regular_model :hidden").show();
            $("#regular_model .modal-footer button:first").hide();
        });
    }



    function forbidden(id,version){
        if(confirm("确认禁用？")){
            $.ajax({
                type: "POST",
                url: "regularController/changvalue.do",
                data: "reg_id="+id+"&is_on=0&version="+version,
                success: function(msg){
                    alert(msg.info);
                    if(msg.status){
                        $('#sample_1').dataTable( ruletablesettings).fnDraw();
                    }
                }
            });
        }
    }


    function deleteConfig(id, version){
        if(confirm("确认删除？")){
//            alert(id + " " + version)
            $.ajax({
                type: "GET",
                url: "regularController/deleteRegularConfig.do",
                data: {"reg_id":id, "version":version},
                success:function(msg){
                    alert(msg.info);
//                    alert(msg.status)
                    if(msg.status) {
                        //debugger
                        $('#sample_1').dataTable( ruletablesettings).fnDraw();
                    }
                }
            });
        }
    }

    function startSettings(id,version){
        if(confirm("确认启用？")){
            $.ajax({
                type: "GET",
                url: "regularController/changvalue.do",
                data: "reg_id="+id+"&is_on=1&version="+version,
                success: function(msg){
                    alert(msg.info);
                    if(msg.status){
                        $('#sample_1').dataTable( ruletablesettings).fnDraw();
                    }
                }
            });
        }
    }
    function getLength(obj){
   	　　var count = 0;
   	　　for(var i in obj){
   	   　　count++;
   	　　}
   	　　return count;　　
   	}
    $("#create_regular").click(function(){

        $("#create_regular_model").modal("show");
        $("#create_regular_model .modal-body").html("正在加载数据，请稍等……");
        $("#create_regular_model .modal-body").load("regularController/turnCreateRegular.do",
                null,
                function(){
                    $("#create_regular_form #ds_name_id_create").append(optionAvaDsStr);
                    $("#create_regular_model .modal-footer button:first").unbind("click");
                    $("#create_regular_model .modal-footer button:first").click(function(){
                        var formvalidate=bindformvalidate("#create_regular_form",{
                            ds_id: {
                                required: true
                            },
                            tab_id: {
                                required: true
                            },
                            reg_name:{
                            	regnameonly: true
                            }
                        });

                        var params = decodeURIComponent($("#create_regular_form").serialize(),true);
                        var paramArr = params.split("&");
                        var paramMap = {};
                        $.each(paramArr, function(index, pair){
                            var pairArr = pair.split("=");
                            if(pairArr != null && pairArr.length == 2){
                                paramMap[pairArr[0]]=pairArr[1];
                            }
                        });
                        var chexboxMap = {};
                        var sinkMap = {};
                        var targetMap = {};
                        var tabRegMap = {};
                        var colNameMap = {};
                        $.each(paramMap, function(key, value){
                            if(key.indexOf("chexbox") == 0){
                                chexboxMap[key]=value;
                            } else if(key.indexOf("target") == 0 && value != null && value !="") {
                                targetMap[key]=value;
                            } else if(key.indexOf("sink") == 0) {
                                sinkMap[key]=value;
                            } else if(key.indexOf("tabRegSelect") == 0){
                                tabRegMap[key]=value;
                            } else if(key.indexOf("colName")==0){
                                colNameMap[key]=value;
                            }
                        });
                        var json = "";
                        if(getLength(chexboxMap)<2){
                        	alert("至少选择2个同步字段，并且其中包含主键!");
                        	return false;
                        }
                        $.each(chexboxMap, function(index, radioStr){
                            var arr = index.split("_");
                            if(arr != null && arr.length == 3){
                                var rowNum=arr[1];
                                var col_id=arr[2];
                                var target_col_name= (targetMap["target"+rowNum]);
                                var colName = colNameMap["colName-"+rowNum];
                                if(target_col_name == null || target_col_name == "") {
                                    target_col_name = colName;
                                }
                                json += "{\"src\":\""+colName+"\",\"target\":\""+target_col_name+"\"},";
                            }
                        });
                        json = "["+json.substr(0, json.length-1)+"]";
                        var syn_col = json;
                        var tab_id = paramMap["tab_id"];
                        var ds_id = paramMap["ds_id"];
                        var reg_name = paramMap["reg_name"];

//                        debugger;
                        var reg = "";
                        if(getLength(tabRegMap)==0){
                        	alert("未选择同步规则!");
                        	return false;
                        }
                        $.each(tabRegMap, function(key, value){
                            var arr = key.split("_");
                            var reg_tab_id = "";
                            var sink_id = "";
//                            debugger
                            if(arr != null && arr.length == 2){
                                var rowNum = arr[1];
                                reg_tab_id = value;

                                sink_id = sinkMap["sinkSelect_"+rowNum];
                            }
                            reg += "{\"reg_tab_id\":\""+reg_tab_id+"\",\"sink_id\":\""+sink_id+"\"},";
                        });
                        reg = "["+reg.substr(0,reg.length-1)+"]";
//                        debugger;
                        if(formvalidate.form()){
                            $.ajax({
                                type:"POST",
                                url:"regularController/addRegular.do",
                                data:{"reg_name":reg_name,"sync_col":syn_col,"reg":reg,"tab_id":tab_id,"ds_id":ds_id},
                                success: function(msg){
                                    if (msg.status) {
                                        $("#create_regular_model").modal("hide");
                                        alert(msg.info);
                                        $("#create_regular_model .modal-footer button:first").unbind("click");
                                        $('#sample_1').dataTable(ruletablesettings).fnDraw();
                                    } else {
                                        //                                $("#create_table_model").modal("hide");
                                        alert(msg.info)
                                    }
                                }
                            });
                        }
                    });
                });
    });
    TableManaged.init(ruletablesettings);


</script>
<!-- 按钮触发模态框 更改 -->
<div class="modal fade" id="regular_model" tabindex="-1" role="dialog"
     aria-labelledby="regular_model_ModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="regular_model_ModalLabel">
                    更改配置
                </h4>
            </div>
            <div class="modal-body">
                <div id="regular_div"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-green"
                        data-dismiss="modal">保存
                </button>
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">取消
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 按钮触发模态框　新增 -->
<div class="modal fade" id="create_regular_model" tabindex="-1" role="dialog"
     aria-labelledby="create_regular_model_ModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="create_regular_model_model_ModalLabel">
                    新增配置
                </h4>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">
                    提交
                </button>
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
<!-- END BODY -->
</html>