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
                                        <select class="form-control" id="search_regtab_selectds_id">
                                        </select>
                                    </td>
                                    <td width="50px;"><label>表名称：</label></td>
                                    <td>
                                        <select class="form-control" id="search_regtab_selectts_id">
                                        </select>
                                    </td>
                                    <td width="50px;"><label>是否启用：</label></td>
                                    <td>
                                        <select id="search_regtab_is_on_id">
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
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td align="right">
                                        <vooletag:permission url="regularTableController/turnCreateRegularTable.do">
                                            <button id="create_regtable" class="btn green">
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
                                    <th class="hidden-480">规则名称</th>
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


    <script type="text/javascript" src="media/js/select2.min.js"></script>
    <script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="media/js/DT_bootstrap.js"></script>
    <script src="media/js/datatableutil.js" type="text/javascript"></script>
    <script src="media/js/table-managed.js"></script>

<script>

    // 加载设置数据源名称
    var optionStr = ""; // 所有数据源
    var optionAvaDsStr =""; //is_on and status = 1数据源
    $("#search_regtab_selectds_id").load(
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
                $("#search_regtab_selectds_id").append("<option value=''>请选择</option>" + resultStr);
                $("#search_regtab_selectts_id").append("<option value=''>请选择</option>");
                optionStr=resultStr;
                optionAvaDsStr = result;
            }
    );

    //搜索框　数据源联动
    $("#search_regtab_selectds_id").change(function(){
        $("#search_regtab_selectts_id").empty();
        changeDs();
    });

    /**
     *
     * ds联动函数
     * */
    var optionTabStr="";
    function changeDs() {
        if ($("#search_regtab_selectds_id").val() == "") {
            $("#search_regtab_selectts_id").empty();
            $("#search_regtab_selectts_id").append("<option value=''>请选择</option>");
        } else {
            $("#search_regtab_selectts_id").load(
                    "dataSourceController/queryDataSourceTables.do",
                    {ds_id: $("#search_regtab_selectds_id").val()},
                    function (response) {
                        var result = "";
                        var responseJSON = JSON.parse(response);
                        $.each(responseJSON, function (index, json) {
                            result += "<option value="+json.tab_name+">" + json.tab_name + "</option>";
                        });
                        optionTabStr = result;
                        $("#search_regtab_selectts_id").append("<option value=''>请选择</option>" + result);

                    }
            );
        }
    }

    /**
     * 查询表格数据
     * */
    var ruletablesettings=gettables("regularTableController/queryRegularTable.do",[
        {
            "mData" : "reg_tab_id",
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
            "mData" : "reg_tab_name",
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
            "mData" : "reg_tab_id",
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
                dHtml+='<vooletag:permission url="regularTableController/turnRegularTableInfo.do"><li><a href="javascript:void(0)" onclick="showinfo(\''+ data+ '\',\''+full.version+'\');"><i class="icon-info"></i>&nbsp详情</a></li></vooletag:permission>';
                if(full.is_on=="0"){
                    dHtml+='<vooletag:permission url="regularTableController/switchon.do"><li><a href="javascript:void(0)" onclick="startSettings(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ok"></i>&nbsp启用</a></li></vooletag:permission>';
                }else{
                    dHtml+='<vooletag:permission url="regularTableController/switchoff.do"><li><a href="javascript:void(0)" onclick="forbidden(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ban-circle"></i>&nbsp禁用</a></li></vooletag:permission>';
                }
                dHtml+='<vooletag:permission url="regularTableController/deleteRegularTableConfig.do"><li><a href="javascript:void(0)" onclick="deleteConfig(\''+ data+ '\',\''+full.version+'\');"><i class="icon-remove"></i>&nbsp删除</a></li></vooletag:permission>';
                dHtml+='</ul>';
                dHtml+='</div>';
                return dHtml;
            }
        }],function(aoData) {//重要设置，可通过此设置添加额外查询参数
        aoData.push({
            "name" : "ds_id",
            "value" : $.trim($("#search_regtab_selectds_id").val())
        },{
            "name" : "tab_name",
            "value" : $.trim($("#search_regtab_selectts_id").val())
        },{
            "name" : "is_on",
            "value" : $.trim($("#search_regtab_is_on_id").val())
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
        $("#regtable_model").modal("show");
        $("#regtable_model .modal-title").html("详情");
        $("#regtable_div").load("regularTableController/turnRegTableInfo.do",{"reg_tab_id":id},function(){
            $("#regtable_model :hidden").show();
            setTabRegTable();
            if(${regtableinfo.is_on == 0}) $("#is_on_id").find("option[text='否']").attr("selected", true);
            else $("#is_on_id").find("option[text='是']").attr("selected",true);
            $("#is_on_id").attr("disabled", true);
            $("#regtable_model .modal-footer button:first").hide();
        });
    }



    function forbidden(id,version){
        if(confirm("确认禁用？")){
            $.ajax({
                type: "POST",
                url: "regularTableController/changvalue.do",
                data: "reg_tab_id="+id+"&is_on=0&version="+version,
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
                url: "regularTableController/deleteRegTableConfig.do",
                data: {"reg_tab_id":id, "version":version},
                success:function(msg){
                    alert(msg.info);
                    if(msg.status) {
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
                url: "regularTableController/changvalue.do",
                data: "reg_tab_id="+id+"&is_on=1&version="+version,
                success: function(msg){
                    alert(msg.info);
                    if(msg.status){
                        $('#sample_1').dataTable( ruletablesettings).fnDraw();
                    }
                }
            });
        }
    }

    $("#create_regtable").click(function(){

        $("#create_regtable_model").modal("show");
        $("#create_regtable_model .modal-body").html("正在加载数据，请稍等……");
        $("#create_regtable_model .modal-body").load("regularTableController/turnCreateRegularTable.do",
                null,
                function(){
                    $("#create_regtable_form #create_regtab_selectds_id").append(optionAvaDsStr);
                    changeCreateRegTabDs();
                    $("#create_regtable_model .modal-footer button:first").unbind("click");
                    var formvalidate=bindformvalidate("#create_regtable_form",{
                        ds_id: {
                            required: true
                        },
                        tab_id: {
                            required: true
                        },
                        reg_tab_name:{
                        	regtabnameonly: true
                        }
                    });
                    $("#create_regtable_model .modal-footer button:first").click(function(){
                        var params = decodeURIComponent($("#create_regtable_form").serialize(),true);
                        var paramArr = params.split("&");
                        var reg_col_ids = "";
                        var regColIdMap={};
                        $.each(paramArr, function(index, pair){
                            var pairArr = pair.split("=");
                            if(pairArr!= null && pairArr.length == 2){
                                if(pairArr[0].indexOf("reg_col_id") == 0 && pairArr[1] !="") {
                                    reg_col_ids += pairArr[1] +",";
                                }
                            }
                        });
                        reg_col_ids = reg_col_ids.substr(0, reg_col_ids.length - 1);
                        if(formvalidate.form()) {
                            $.ajax({
                                type: "POST",
                                url: "regularTableController/addRegTable.do",
                                data: params+"&reg_col_ids="+reg_col_ids,
                                success: function (msg) {
                                    if (msg.status) {
                                        $("#create_regtable_model").modal("hide");
                                        alert(msg.info);
                                        $("#create_regtable_model .modal-footer button:first").unbind("click");
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
<div class="modal fade" id="regtable_model" tabindex="-1" role="dialog"
     aria-labelledby="regtable_model_ModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="regtable_model_ModalLabel">
                    更改配置
                </h4>
            </div>
            <div class="modal-body">
                <div id="regtable_div"></div>
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
<div class="modal fade" id="create_regtable_model" tabindex="-1" role="dialog"
     aria-labelledby="create_regtable_model_ModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="create_regtable_model_ModalLabel">
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