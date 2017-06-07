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
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td align="right">
                                    <%--<vooletag:permission url="dataSourceController/turnCreateDataSource.do">--%>
                                    <vooletag:permission url="dataSourceTableController/turnCreateTable.do">
                                        <button id="create_table" class="btn green">
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
                            <th class="hidden-480">备注</th>
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
        var optionDsStr = "";
        var optionAvailableDsStr ="";
        $("#selectDs").load(
            "dataSourceController/queryDataSource.do",
             null,
            function(response) {
                var json =  JSON.parse(response);
                var data = json.aaData;
                var resultStr="";
                var resultStr1="";
                $.each(data, function(index, object){
                    resultStr += "<option value=" +object.ds_id+ ">" +object.ds_name+ "</option>";
                    //有效的并且启用的数据源
                    if(object.is_on==1 && object.ds_status==1){
                        resultStr1 += "<option value=" +object.ds_id+ ">" +object.ds_name+ "</option>";
                    }
                });
                $("#selectDs").append("<option value=''>请选择</option>" + resultStr);
                $("#selectTs").append("<option value=''>请选择</option>");
                optionDsStr=resultStr;
                optionAvailableDsStr = resultStr1;
            }
        );

    //有效数据源加载

    //搜索框选择数据源
    $("#selectDs").change(function(){
        $("#selectTs").empty();
        changeDs();
    });

    var optionTabStr="";
    /**
     * 改变数据源联动－改变表
     * */
    function changeDs(){
        if($("#selectDs").val() == ""){
            $("#selectTs").empty();
            $("#selectTs").append("<option value=''>请选择</option>");
        }else{
            $("#selectTs").load(
                    "dataSourceController/queryDataSourceTables.do",
                    {ds_id: $("#selectDs").val()},
                    function(response) {
                        var result = "";
                        var responseJSON = JSON.parse(response);
                        $.each(responseJSON, function(index, json){
                            result += "<option>" + json.tab_name + "</option>";
                        });
                        optionTabStr=result;
                        $("#selectTs").append("<option value=''>请选择</option>"+result);

                    }
            );
        }
    }

    /**
     * 查询表格数据
     * */
    var ruletablesettings=gettables("dataSourceTableController/queryDataSourceTable.do",[
        {
            "mData" : "tab_id",
            "sWidth" : "28px",
            "bSortable" : false,
            "aTargets" : [ 0 ]
        },{
            "mData" : "ds_name",
            "sWidth" : "100px",
            "aTargets" : [ 1 ],
            "bSortable" : false
        },{
            "mData" : "tab_name",
            "sWidth" : "100px",
            "aTargets" : [ 2 ],
            "bSortable" : false
        },{
            "mData" : "tab_note",
            "sWidth" : "100px",
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
            "mData" : "tab_id",
            "sClass" : "center",
            "sWidth" : "40px",
            "aTargets" : [ 5 ],
            "bSortable" : false,
            "mRender" : function(data, type,full) {
                var dHtml = "";
                dHtml+='<div class="btn-group">';
                dHtml+='<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:;">';
                dHtml+='工具 <i class="icon-angle-down"></i>';
                dHtml+='</a>';
                dHtml+='<ul class="dropdown-menu">';
                dHtml+='<vooletag:permission url="dataSourceTableController/turnDataSourceTableInfo.do"><li><a href="javascript:void(0)" onclick="showinfo(\''+ data+ '\',\''+full.version+'\');"><i class="icon-info"></i>&nbsp详情</a></li></vooletag:permission>';
                dHtml+='<vooletag:permission url="dataSourceTableController/changvalue.do"><li><a href="javascript:void(0)" onclick="changvalue(\''+ data+ '\',\''+full.version+'\');"><i class="icon-edit"></i>&nbsp修改</a></li></vooletag:permission>';
                if(full.is_on=="0"){
                    dHtml+='<vooletag:permission url="dataSourceTableController/switchon.do"><li><a href="javascript:void(0)" onclick="startSettings(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ok"></i>&nbsp启用</a></li></vooletag:permission>';
                }else{
                    dHtml+='<vooletag:permission url="dataSourceTableController/switchoff.do"><li><a href="javascript:void(0)" onclick="forbidden(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ban-circle"></i>&nbsp禁用</a></li></vooletag:permission>';
                }
                <%--dHtml+='<vooletag:permission url="dataSourceTableController/deleteTableConfig.do"><li><a href="javascript:void(0)" onclick="deleteTableConfig(\''+ data+ '\',\''+full.version+'\');"><i class="icon-remove"></i>&nbsp删除</a></li></vooletag:permission>--%>
                dHtml+='<vooletag:permission url="dataSourceTableController/deleteTableConfig.do"><li><a href="javascript:void(0)" onclick="deleteTableConfig(\''+ data+ '\',\''+full.version+'\');"><i class="icon-remove"></i>&nbsp删除</a></li></vooletag:permission>';

                dHtml+='</ul>';
                dHtml+='</div>';
                return dHtml;
            }
        }],function(aoData) {//重要设置，可通过此设置添加额外查询参数
        aoData.push({
            "name" : "ds_id",
            "value" : $.trim($("#selectDs").val())
        },{
            "name" : "tab_name",
            "value" : $.trim($("#selectTs").val())
        },{
            "name" : "is_on",
            "value" : $.trim($("#is_on_search_id").val())
        });
    },'${tablesize == null ? 10 : tablesize}');

    /**
     * 查询点击事件
     * */
    $("#search_setttings").click(function(){
//        alert($.trim($("#selectDs").val()) + " - " + $.trim($("#ds_tablename").val() + " - " + $.trim($("#is_on_search_id").val());
//       debugger
//        alert($.trim($("selectDs").val()) +" ....")
//        console.log()
        $('#sample_1').dataTable( ruletablesettings).fnDraw();
    });

    /**
     * 修改表配置
     * @param id
     * @param version
     */
    function changvalue(id,version){
        $("#table_model").modal("show");
        $("#table_model .modal-title").html("修改");
        $("#table_model .modal-footer :hidden").show();
        $("#table_div").load("dataSourceTableController/turnDataSourceTableInfo.do",{"tab_id":id},function(){

            $("#table_form #ds_name").removeAttr("disabled");
            $("#table_form #is_on_id").removeAttr("disabled");
            $("#table_form #tab_name").removeAttr("disabled");
            $("#table_form #ds_name").append(optionAvailableDsStr);
            $("#table_form #tab_name").append(optionTabStr);
            // $("#table_form #is_on_id").append("<option value=1> 是 </option> <option vlaue=0> 否 </option>" );

            $("#table_form #ds_name option").each(function(index, data){
                // alert(data.innerHTML + "- " + data.value +" - " + index);
                var val = $(this).val();
                if ( $("#table_form #ds_name option[value='" + val + "']").length > 1 )
                    $("#table_form #ds_name option[value='" + val + "']:gt(0)").remove();

            });

            var formvalidate=bindformvalidate("#table_form",{
                ds_name: {
                    required: true
                },
                tab_note: {
                    required: false
                }
            });

            $("#table_model .modal-footer button:first").unbind("click");
            $("#table_model .modal-footer button:first").click(function(){
                if(formvalidate.form()){
                    $.ajax({
                        type: "POST",
                        url: "dataSourceTableController/changvalue.do",
                        data: $("#table_form").serialize()+"&tab_id="+id+"&version="+version,
                        success: function(msg){
                            alert(msg.info);
                            if(msg.status){
                                $("#table_model").modal("hide");
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

        $("#table_model").modal("show");
        $("#table_model .modal-title").html("详情");
        $("#table_div").load("dataSourceTableController/turnDataSourceTableInfo.do",{"tab_id":id},function(){
            $("#table_model :hidden").show();
            if(${tableinfo.is_on == 0}) $("#is_on_id").find("option[text='否']").attr("selected", true);
            else $("#is_on_id").find("option[text='是']").attr("selected",true);
            $("#is_on_id").attr("disabled", true);
            $("#table_model .modal-footer button:first").hide();
        });
    }

    $("#table_model .modal-footer button:eq(1)").click(function(){
        // debugger
        var ds_name=$("#table_form input[name='ds_name']").val();
        var tb_name=$("#table_form input[name='tb_name']").val();
        var tb_note=$("#table_form input[name='tb_note']").val();
        var is_on=$("#table_form input[name='is_on']").val();
        var update_time=$("#table_form input[name='update_time']").val();
        var validate_time=$("#table_form input[name='validate_time']").val();
        var create_time=$("#table_form input[name='create_time']").val();
    });


    function forbidden(id,version){
        if(confirm("确认禁用？")){
            $.ajax({
                type: "GET",
                url: "dataSourceTableController/changvalue.do",
                data: "tab_id="+id+"&is_on=0&version="+version,
                success: function(msg){
                    alert(msg.info);
                    if(msg.status){
                        $('#sample_1').dataTable( ruletablesettings).fnDraw();
                    }
                }
            });
        }
    }


    function deleteTableConfig(id, version){
        if(confirm("确认删除？")){
//            alert(id + " " + version)
            $.ajax({
                type: "GET",
                url: "dataSourceTableController/deleteTableConfig.do",
                data:"tab_id="+id+"&version="+version,
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
                url: "dataSourceTableController/changvalue.do",
                data: "tab_id="+id+"&is_on=1&version="+version,
                success: function(msg){
                    alert(msg.info);
                    if(msg.status){
                        $('#sample_1').dataTable( ruletablesettings).fnDraw();
                    }
                }
            });
        }
    }
    $("#create_table").click(function(){

        $("#create_table_model").modal("show");
        $("#create_table_model .modal-body").html("正在加载数据，请稍等……");
        $("#create_table_model .modal-body").load("dataSourceTableController/turnCreateTable.do",null,function(){
            $("#create_table_form #ds_name_id_create").empty();
            $("#create_table_form #ds_name_id_create").append(optionAvailableDsStr);

            var formvalidate=bindformvalidate("#create_table_form",{
                ds_name: {
                    required: true
                },
                tab_name: {
                	tabnameonly: true
                },
                tab_note: {
                    required: false

                }
            });
            $("#create_table_model .modal-footer button:first").unbind("click");
            $("#create_table_model .modal-footer button:first").click(function(){
//                alert("点击提交" + $("#create_table_form").serialize());
                if(formvalidate.form()){
                    $.ajax({
                        type: "POST",
                        url: "dataSourceTableController/addTable.do",
                        data:$("#create_table_form").serialize()+"&vesion=0&ds_id="+$.trim($("#create_table_form #ds_name_id_create").val()),
                        success: function(msg){
                            if(msg.status){
                                $("#create_table_model").modal("hide");
                                alert(msg.info);
                                $("#create_table_model .modal-footer button:first").unbind("click");
                                $('#sample_1').dataTable( ruletablesettings).fnDraw();
                            }else{
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
<!-- 按钮触发模态框 -->
<div class="modal fade" id="table_model" tabindex="-1" role="dialog"
     aria-labelledby="table_model_ModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="table_model_ModalLabel">
                    更改配置
                </h4>
            </div>
            <div class="modal-body">
                <div id="table_div"></div>
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
<!-- 按钮触发模态框 -->
<div class="modal fade" id="create_table_model" tabindex="-1" role="dialog"
     aria-labelledby="create_table_model_ModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="create_table_model_ModalLabel">
                    新增配置
                </h4>
            </div>
            <div class="modal-body">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">
                    提交
                </button>
                <%--<button type="button" class="btn btn-primary">--%>
                <%--验证--%>
                <%--</button>--%>
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