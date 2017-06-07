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
                                <td width="50px;"><label>数据源：</label></td>
                                <td>
                                    <select class="form-control" id="selectDs">
                                    </select>
                                </td>
                                <td width="50px;"><label>表名称：</label></td>
                                <%--<td><input type="text" id="ds_tablename"/></td>--%>
                                <td>
                                    <select class="form-control" id="selectTs">
                                    </select>
                                </td>
                                <td width="50px;"><label>是否启用：</label></td>
                                <td>
                                    <select id="is_on_search_id">
                                        <option value="">请选择</option>
                                        <option value="1">是</option>
                                        <option value="0">否</option>
                                    </select>
                                </td>
                                <td align="right">
                                    <button id="search_setttings" class="btn green">
                                        查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td width="50px;"><label>字段名称：</label></td>
                                <%--<td><input type="text" name="col_name" id="search_colname_text_id"></td>--%>
                                <td>
                                    <input type="text" id="search_colname_text_id" name="col_name">
                                    <%--<select class="form-control" id="search_colname_text_id" name="col_name">--%>
                                    <%--</select>--%>
                                </td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td align="right">
                                    <%--<vooletag:permission url="dataSourceController/turnCreateDataSource.do">--%>
                                    <vooletag:permission url="regularColumnController/turnCreateRegularColumn.do">
                                        <button id="create_regcolumn" class="btn green">
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

                            <th>数据源名称</th>

                            <th class="hidden-480">表名称</th>
                            <th class="hidden-480">字段规则名称</th>
                            <th class="hidden-480">是否启用</th>
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
     * 表联动函数
     * */
//    function changeTs() {
////            alert("表选择联动");
//        if($("#selectTs").val() ==""){
//            $("#search_colname_text_id").empty();
//            $("#search_colname_text_id").append("<option value=''>请选择</option>");
//        } else{
//            var tabName = $("#selectTs").val();
//            var dsId = $("#selectDs").val();
////                alert(dsId + " " + tabName);
//            $("#search_colname_text_id").empty();
//            $("#search_colname_text_id").append("<option>请选择</option>");
//            //加载数据
//
//            $("#search_colname_text_id").load(
//                    "dataSourceController/queryTablesFields.do",
//                    {tabName:tabName, dsId: dsId},
//                    function(response) {
//                        var resJson = JSON.parse(response);
////                        alert(resJson);
//                        var result = "";
//                        $.each(resJson, function(index, json){
//                            result += "<option>" + json.col_name + "</option>"
//                        });
//                        $("#search_colname_text_id").append("<option>请选择</option>"+result);
//                    }
//            );
//        }
//    }

    /**
     * 查询表格数据
     * */
    var ruletablesettings=gettables("regularColumnController/queryRegularColumn.do",[
        {
            "mData" : "reg_col_id",
            "sWidth" : "50px",
            "bSortable" : false,
            "aTargets" : [ 0 ]
        },{
            "mData" : "ds_name",
            "sWidth" : "150px",
            "aTargets" : [ 1 ],
            "bSortable" : false
        },{
            "mData" : "tab_name",
            "sWidth" : "150px",
            "aTargets" : [ 2 ],
            "bSortable" : false
        },{
            "mData" : "col_reg_name",
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
            "mData" : "reg_col_id",
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
                dHtml+='<vooletag:permission url="regularColumnController/turnRegularColumnInfo.do"><li><a href="javascript:void(0)" onclick="showinfo(\''+ data+ '\',\''+full.version+'\');"><i class="icon-info"></i>&nbsp详情</a></li></vooletag:permission>';
                dHtml+='<vooletag:permission url="regularColumnController/changvalue.do"><li><a href="javascript:void(0)" onclick="changvalue(\''+ data+ '\',\''+full.version+'\');"><i class="icon-edit"></i>&nbsp修改</a></li></vooletag:permission>';
                if(full.is_on=="0"){
                    dHtml+='<vooletag:permission url="regularColumnController/switchon.do"><li><a href="javascript:void(0)" onclick="startSettings(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ok"></i>&nbsp启用</a></li></vooletag:permission>';
                }else{
                    dHtml+='<vooletag:permission url="regularColumnController/switchoff.do"><li><a href="javascript:void(0)" onclick="forbidden(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ban-circle"></i>&nbsp禁用</a></li></vooletag:permission>';
                }
                dHtml+='<vooletag:permission url="regularColumnController/deleteRegularColumnConfig.do"><li><a href="javascript:void(0)" onclick="deleteConfig(\''+ data+ '\',\''+full.version+'\');"><i class="icon-remove"></i>&nbsp删除</a></li></vooletag:permission>';
                <%--dHtml+='<vooletag:permission url="dataSourceTableController/deleteTableConfig.do"><li><a href="javascript:void(0)" onclick="deleteTableConfig(\''+ data+ '\',\''+full.version+'\');"><i class="icon-remove"></i>&nbsp删除</a></li></vooletag:permission>';--%>

                dHtml+='</ul>';
                dHtml+='</div>';
                return dHtml;
            }
        }],function(aoData) {//重要设置，可通过此设置添加额外查询参数
        aoData.push({
            "name" : "ds_id",
            "value" : $.trim($("#selectDs").val())
//                                                                                                    "value" : $.trim($("#selectDs").val())
        },{
            "name" : "tab_name",
            "value" : $.trim($("#selectTs").val())
        },{
            "name" : "is_on",
            "value" : $.trim($("#is_on_search_id").val())
        },{
            "name" : "col_name",
            "value" :$.trim($("#search_colname_text_id").val())
        });
    },'${tablesize == null ? 10 : tablesize}');

    /**
     * 查询点击事件
     * */
    $("#search_setttings").click(function(){
        $('#sample_1').dataTable( ruletablesettings).fnDraw();
    });

    /**
     * 修改表配置
     * @param id
     * @param version
     */
    function changvalue(id,version){
        $("#regcolumn_model").modal("show");
        $("#regcolumn_model .modal-title").html("修改");
        $("#regcolumn_model .modal-footer :hidden").show();
        $("#regcolumn_div").load("regularColumnController/turnRegColumnInfo.do",{"reg_col_id":id},function(){

            $("#regcolumn_form #ds_name").removeAttr("disabled");
            $("#regcolumn_form #tab_name").removeAttr("disabled");
            $("#regcolumn_form #col_name").removeAttr("disabled");
            $("#regcolumn_form #is_on_id").removeAttr("disabled");
            $("#regcolumn_form #addColumnReg").removeAttr("disabled");
            $("#regcolumn_form #addColumnReg").removeAttr("disabled");
            $("#regcolumn_form #deleteColumnReg").removeAttr("disabled");
            $("#regcolumn_form #ds_name").append(optionAvaDsStr);
            // $("#table_form #is_on_id").append("<option value=1> 是 </option> <option vlaue=0> 否 </option>" );
            changeTable();
            setColRegTable();
            $("#regcolumn_form #ds_name option").each(function(index, data){
                // alert(data.innerHTML + "- " + data.value +" - " + index);
                var val = $(this).val();
                if ( $("#regcolumn_form #ds_name option[value='" + val + "']").length > 1 )
                    $("#regcolumn_form #ds_name option[value='" + val + "']:gt(0)").remove();

            });



            $("#regcolumn_model .modal-footer button:first").unbind("click");
            $("#regcolumn_model .modal-footer button:first").click(function(){
                var params = decodeURIComponent($("#regcolumn_form").serialize(), true);
                var map={};
                var array = params.split("&");
                var num = 0;
                $.each(array, function(index, data) {
                    num++;
                    var pair =  data.split("=");
                    if(pair.length == 2){
                        map[pair[0]]=pair[1];
                    }
                });
//                        alert(params)
                var numberOfReg = (num-4)/2;
                var col_reg ="";
                var col_reg_middle = "";
                for(var i = 1; i<=numberOfReg; i++) {
                    var symbolVal = map["colReg"+i];
                    var symbol = "=";
                    if(symbolVal == 0) symbol = "=";
                    else if(symbolVal == 1) symbol = "!=";
                    else if(symbolVal == 2) symbol = ">";
                    else if(symbolVal == 3) symbol = "<";
                    else if(symbolVal == 4) symbol = ">=";
                    else symbol = "<=";
                    col_reg_middle += "{\"symbol\":\""+symbol+"\",\"value\":\""+map["regval"+i]+"\"},";
                }
//                        debugger
                if(col_reg_middle != ""){
                    col_reg = "["+col_reg_middle.substr(0, col_reg_middle.length-1) + "]";
                }
                var col_id = map["col_name"];
                var col_reg_name = map["col_reg_name"];
                debugger
                if(true){
                    $.ajax({
                        type: "POST",
                        url: "regularColumnController/changvalue.do",
                        data: {"col_reg":col_reg, "col_id":col_id,"col_reg_name":col_reg_name,"is_on":$("#regcolumn_form #is_on_id").val(), "reg_col_id":id,"version": version},
                        success: function(msg){
                            alert(msg.info);
                            if(msg.status){
                                $("#regcolumn_model").modal("hide");
                                $('#sample_1').dataTable( ruletablesettings).fnDraw();
                            }
                        }
                    });
                }
            });
        });
    }
    /**
     * 显示表配置记录详情
     * @param id
     * @param version
     */
    function showinfo(id,version){

        $("#regcolumn_model").modal("show");
        $("#regcolumn_model .modal-title").html("详情");
        $("#regcolumn_div").load("regularColumnController/turnRegColumnInfo.do",{"reg_col_id":id},function(){
            $("#regcolumn_model :hidden").show();
            setColRegTable()
            if(${regcolumninfo.is_on == 0}) $("#is_on_id").find("option[text='否']").attr("selected", true);
            else $("#is_on_id").find("option[text='是']").attr("selected",true);
            <%--if(${regcolumninfo.is_on == 0}) {alert("is on = 0");} else {alert("is on = 1"); }--%>
            $("#is_on_id").attr("disabled", true);
            $("#regcolumn_model .modal-footer button:first").hide();
        });
    }



    function forbidden(id,version){
        if(confirm("确认禁用？")){
            $.ajax({
                type: "POST",
                url: "regularColumnController/changvalue.do",
                data: "reg_col_id="+id+"&is_on=0&version="+version,
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
                url: "regularColumnController/deleteRegColumnConfig.do",
                data: {"reg_col_id":id, "version":version},
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
                url: "regularColumnController/changvalue.do",
                data: "reg_col_id="+id+"&is_on=1&version="+version,
                success: function(msg){
                    alert(msg.info);
                    if(msg.status){
                        $('#sample_1').dataTable( ruletablesettings).fnDraw();
                    }
                }
            });
        }
    }

    $("#create_regcolumn").click(function(){

        $("#create_regcolumn_model").modal("show");
        $("#create_regcolumn_model .modal-body").html("正在加载数据，请稍等……");
        $("#create_regcolumn_model .modal-body").load("regularColumnController/turnCreateRegularColumn.do",
                null,
                function(){
                    $("#create_regcolumn_form #ds_name_id_create").append(optionAvaDsStr);
                    $("#create_regcolumn_model .modal-footer button:first").unbind("click");
                    var formvalidate=bindformvalidate("#create_regcolumn_form",{
                        ds_id: {
                            required: true
                        },
                        tab_id: {
                            required: true
                        },
                        col_id: {
                            required: true
                        },
                        col_reg_name:{
                        	regcolnameonly: true
                        }
                    });
                    $("#create_regcolumn_model .modal-footer button:first").click(function(){

//                        alert($("#create_regcolumn_form").serialize());
                        var params = decodeURIComponent($("#create_regcolumn_form").serialize(),true);
                        var map={};
                        var array = params.split("&");
                        var num = 0;
                        $.each(array, function(index, data) {
                            num++;
                            var pair =  data.split("=");
                            if(pair.length == 2){
                                map[pair[0]]=pair[1];
                            }
                        });
//                        alert(params)
                        var numberOfReg = (num-4)/2;
                        var col_reg ="";
                        var col_reg_middle = "";
                        for(var i = 1; i<=numberOfReg; i++) {
                            var symbolVal = map["colReg"+i];
                            var symbol = "=";
                            if(symbolVal == 0) symbol = "=";
                            else if(symbolVal == 1) symbol = "!=";
                            else if(symbolVal == 2) symbol = ">";
                            else if(symbolVal == 3) symbol = "<";
                            else if(symbolVal == 4) symbol = ">=";
                            else symbol = "<=";
                            col_reg_middle += "{\"symbol\":\"" + symbol + "\",\"value\":\"" + map["regval" + i] + "\"},";

                        }
                        if(col_reg_middle != ""){
                            col_reg = "["+col_reg_middle.substr(0, col_reg_middle.length-1) + "]";
                        }
                        var col_id = map["col_id"];
                        var col_reg_name = map["col_reg_name"];
                        if(formvalidate.form()) {
                            $.ajax({
                                type: "POST",
                                url: "regularColumnController/addRegColumn.do",
                                data: "col_reg="+col_reg+"&col_id="+col_id+"&col_reg_name="+col_reg_name+"&vesion=0",
                                success: function (msg) {
                                    if (msg.status) {
                                        $("#create_regcolumn_model").modal("hide");
                                        alert(msg.info);
                                        $("#create_regcolumn_model .modal-footer button:first").unbind("click");
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
<div class="modal fade" id="regcolumn_model" tabindex="-1" role="dialog"
     aria-labelledby="regcolumn_model_ModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="regcolumn_model_ModalLabel">
                    更改配置
                </h4>
            </div>
            <div class="modal-body">
                <div id="regcolumn_div"></div>
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
<div class="modal fade" id="create_regcolumn_model" tabindex="-1" role="dialog"
     aria-labelledby="create_regcolumn_model_ModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="create_regcolumn_model_ModalLabel">
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