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

            <div class="portlet box light-grey"  style="min-height: 550px;">

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
                                <td width="50px;"><label>名称：</label></td>
                                <td>
                                    <input type="text" id="canal_name_search_id" name="canal_name">
                                </td>
                                <td width="50px;"><label>IP：</label></td>
                                <td>
                                    <input type="text" id="canal_ip_search_id" name="canal_ip">
                                </td>
                                <td width="50px;"><label>主题：</label></td>
                                <td>
                                    <input type="text" id="canal_destination_search_id" name="canal_destination">
                                </td>
                                <td align="right">
                                    <button id="search_setttings" class="btn green">
                                        查&nbsp&nbsp&nbsp询 <i class="icon-search"></i>
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <td width="50px;"><label>过滤器：</label></td>
                                <td>
                                    <input type="text" id="canal_subscribe_search_id" name="canal_subscribe">
                                </td>
                                <td width="50px;"><label>是否ZK：</label></td>
                                <td>
                                    <select id="is_zookeeper_search_id" name="is_zookeeper">
                                        <option value="">请选择</option>
                                        <option value="1">是</option>
                                        <option value="0">否</option>
                                    </select>
                                </td>
                                <td width="50px;"><label>是否启用：</label></td>
                                <td>
                                    <select id="is_on_search_id" name="is_on">
                                        <option value="">请选择</option>
                                        <option value="1">是</option>
                                        <option value="0">否</option>
                                    </select>
                                </td>
                                <td align="right">
                                    <vooletag:permission url="canalController/turnCreateCanal.do">
                                        <button id="create_canal" class="btn green">
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
                            <th class="hidden-480">名称</th>
                            <th class="hidden-480">IP</th>
                            <th class="hidden-480">端口</th>
                            <th class="hidden-480">主题</th>
                            <th class="hidden-480">过滤器</th>
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


    /**
     * 查询表格数据
     * */
    var ruletablesettings=gettables("canalController/queryCanal.do",[
                                                                                            {
                                                                                                "mData" : "canal_id",
                                                                                                "sWidth" : "30px",
                                                                                                "bSortable" : false,
                                                                                                "aTargets" : [ 0 ]
                                                                                            },{
                                                                                                "mData" : "canal_name",
                                                                                                "sWidth" : "100px",
                                                                                                "aTargets" : [ 1 ],
                                                                                                "bSortable" : false,

                                                                                                "mRender" :function(data,type,full){
                                                                                                	var html="";
                                                                                                	if(null!=data){
                                                                                                		if(data.length>15){
                                                                                                			html="<p title='"+data+"'>"+data.substring(0,15)+"……</p>"
                                                                                                		}else{
                                                                                                			html=data;
                                                                                                		}
                                                                                                	}
                                                                                                	return html;
                                                                                                }
                                                                                            },{
                                                                                                "mData" : "canal_ip",
                                                                                                "sWidth" : "100px",
                                                                                                "aTargets" : [ 2 ],
                                                                                                "bSortable" : false
                                                                                            },{
                                                                                                "mData" : "canal_port",
                                                                                                "sWidth" : "100px",
                                                                                                "aTargets" : [ 3 ],
                                                                                                "bSortable" : false
                                                                                            },{
                                                                                                "mData" : "canal_destination",
                                                                                                "sWidth" : "50px",
                                                                                                "aTargets" : [ 4 ],
                                                                                                "bSortable" : false,

                                                                                                "mRender" :function(data,type,full){
                                                                                                	var html="";
                                                                                                	if(null!=data){
                                                                                                		if(data.length>15){
                                                                                                			html="<p title='"+data+"'>"+data.substring(0,15)+"……</p>"
                                                                                                		}else{
                                                                                                			html=data;
                                                                                                		}
                                                                                                	}
                                                                                                	return html;
                                                                                                }
                                                                                            },{
                                                                                                "mData" : "canal_subscribe",
                                                                                                "sWidth" : "150px",
                                                                                                "aTargets" : [ 5 ],
                                                                                                "bSortable" : false
                                                                                            },{
                                                                                                "mData" : "is_on",
                                                                                                "sWidth" : "100px",
                                                                                                "aTargets" : [ 6 ],
                                                                                                "bSortable" : false,

                                                                                                "mRender" :function(data,type,full){
                                                                                                    var html='';
                                                                                                    if(data == "0"){
                                                                                                        html="<span style='color: red'>禁用</span>";
                                                                                                    }else{
                                                                                                        html="<span style='color: green'>启用</span>";
                                                                                                    }
                                                                                                    return html;
                                                                                                }
                                                                                             },{
                                                                                                "mData" : "canal_id",
                                                                                                "sClass" : "center",
                                                                                                "sWidth" : "50px",
                                                                                                "aTargets" : [ 7 ],
                                                                                                "bSortable" : false,
                                                                                                "mRender" : function(data, type,full) {
                                                                                                    var dHtml = "";
                                                                                                    dHtml+='<div class="btn-group">';
                                                                                                    dHtml+='<a class="btn dropdown-toggle" data-toggle="dropdown" href="javascript:;">';
                                                                                                    dHtml+='工具 <i class="icon-angle-down"></i>';
                                                                                                    dHtml+='</a>';
                                                                                                    dHtml+='<ul class="dropdown-menu">';
                                                                                                    dHtml+='<vooletag:permission url="canalController/turnCanalInfo.do"><li><a href="javascript:void(0)" onclick="showinfo(\''+ data+ '\',\''+full.version+'\');"><i class="icon-info"></i>&nbsp详情</a></li></vooletag:permission>';
                                                                                                    dHtml+='<vooletag:permission url="canalController/changevalue.do"><li><a href="javascript:void(0)" onclick="changvalue(\''+ data+ '\',\''+full.version+'\');"><i class="icon-edit"></i>&nbsp修改</a></li></vooletag:permission>';
                                                                                                    if(full.is_on=="0"){
                                                                                                        dHtml+='<vooletag:permission url="canalController/switchon.do"><li><a href="javascript:void(0)" onclick="startSettings(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ok"></i>&nbsp启用</a></li></vooletag:permission>';
                                                                                                    }else{
                                                                                                        dHtml+='<vooletag:permission url="canalController/switchoff.do"><li><a href="javascript:void(0)" onclick="forbidden(\''+ data+ '\',\''+full.version+'\');"><i class="icon-ban-circle"></i>&nbsp禁用</a></li></vooletag:permission>';
                                                                                                    }
                                                                                                    dHtml+='<vooletag:permission url="canalController/deleteCanalConfig.do"><li><a href="javascript:void(0)" onclick="deleteConfig(\''+ data+ '\',\''+full.version+'\');"><i class="icon-remove"></i>&nbsp删除</a></li></vooletag:permission>';
                                                                                                    <%--dHtml+='<vooletag:permission url="dataSourceTableController/deleteTableConfig.do"><li><a href="javascript:void(0)" onclick="deleteTableConfig(\''+ data+ '\',\''+full.version+'\');"><i class="icon-remove"></i>&nbsp删除</a></li></vooletag:permission>';--%>

                                                                                                    dHtml+='</ul>';
                                                                                                    dHtml+='</div>';
                                                                                                    return dHtml;
                                                                                                }
                                                                                            }],function(aoData) {//重要设置，可通过此设置添加额外查询参数
                                                                                                aoData.push({
                                                                                                    "name" : "canal_name",
                                                                                                    "value" : $.trim($("#canal_name_search_id").val())
                                                                                                },{
                                                                                                    "name" : "canal_ip",
                                                                                                    "value" : $.trim($("#canal_ip_search_id").val())
                                                                                                },{
                                                                                                    "name" : "canal_destination",
                                                                                                    "value" : $.trim($("#canal_destination_search_id").val())
                                                                                                },{
                                                                                                    "name" : "canal_subscribe",
                                                                                                    "value" : $.trim($("#canal_subscribe_search_id").val())
                                                                                                },{
                                                                                                    "name" : "is_zookeeper",
                                                                                                    "value" : $.trim($("#is_zookeeper_search_id").val())
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
     * 修改表配置
     * @param id
     * @param version
     */
    function changvalue(id,version){
        $("#canal_model").modal("show");
        $("#canal_model .modal-title").html("修改");
        $("#canal_model .modal-footer :hidden").show();
        $("#canal_div").load("canalController/turnCanalInfo.do",{"canal_id":id},function(){
            $("#canal_form #info_canal_is_zookeeper_id").removeAttr("disabled");
            $("#canal_form #info_canal_is_on_id").removeAttr("disabled");

            var formvalidate=bindformvalidate("#canal_form",{
                canal_ip: {
                    required: true
                },
                canal_port: {
                    required: true,
                    digits: true
                },
                canal_destination:{
                    required: true
                },
                canal_subscribe: {
                    required: true

                },
                is_zookeeper: {
                    required: true

                }
            });

            $("#canal_model .modal-footer button:first").unbind("click");
            $("#canal_model .modal-footer button:first").click(function(){

                if(formvalidate.form()){
                    $.ajax({
                        type: "POST",
                        url: "canalController/changvalue.do",
                        data: $("#canal_form").serialize()+"&canal_id="+id+"&version="+version,
                        success: function(msg){
                            alert(msg.info);
                            if(msg.status){
                                $("#canal_model").modal("hide");
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
        $("#canal_model").modal("show");
        $("#canal_model .modal-title").html("详情");
        $("#canal_div").load("canalController/turnCanalInfo.do",{"canal_id":id},function(){
            $("#canal_model :hidden").show();
	        $("#canal_model .modal-footer button:first").hide();
        });
    }



    function forbidden(id,version){
        if(confirm("确认禁用？")){
            $.ajax({
                type: "POST",
                url: "canalController/changvalue.do",
                data: "canal_id="+id+"&is_on=0&version="+version,
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
                url: "canalController/deleteSCanalConfig.do",
                data:"canal_id="+id+"&version="+version,
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
                url: "canalController/changvalue.do",
                data: "canal_id="+id+"&is_on=1&version="+version,
                success: function(msg){
                    alert(msg.info);
                    if(msg.status){
                        $('#sample_1').dataTable( ruletablesettings).fnDraw();
                    }
                }
            });
        }
    }
    $("#create_canal").click(function(){
//         alert("new field ");
        $("#create_canal_model").modal("show");
        $("#create_canal_model .modal-body").html("正在加载数据，请稍等……");
        $("#create_canal_model .modal-body").load("canalController/turnCreateCanal.do",null,function(){

            var formvalidate=bindformvalidate("#create_canal_form",{
                canal_name:{
                	canalnameonly: true
                },
                canal_ip: {
                    required: true
                },
                canal_port: {
                    required: true,
                    digits: true
                },
                canal_destination:{
                    required: true
                },
                canal_subscribe: {
                    required: true

                },
                is_zookeeper: {
                    required: true

                }
            });
            $("#create_canal_model .modal-footer button:first").unbind("click");
            $("#create_canal_model .modal-footer button:first").click(function(){
//                 alert("点击提交" + $("#create_canal_form").serialize());
                if(formvalidate.form()){
                    $.ajax({
                        type: "POST",
                        url: "canalController/addCanal.do",
                        data:$("#create_canal_form").serialize()+"&vesion=0",
                        success: function(msg){
                            if(msg.status){
                                $("#create_canal_model").modal("hide");
                                alert(msg.info);
                                $("#create_canal_model .modal-footer button:first").unbind("click");
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
<!-- 按钮触发模态框 更改 -->
<div class="modal fade" id="canal_model" tabindex="-1" role="dialog"
     aria-labelledby="canal_model_ModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="canal_model_ModalLabel">
                    更改配置
                </h4>
            </div>
            <div class="modal-body">
                <div id="canal_div"></div>
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
<div class="modal fade" id="create_canal_model" tabindex="-1" role="dialog"
     aria-labelledby="create_sink_canal_ModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                </button>
                <h4 class="modal-title" id="create_canal_model_ModalLabel">
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