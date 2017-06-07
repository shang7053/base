<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-12
  Time: 下午5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form id="create_sink_form" action="javascript:;">
    <table style="width: 100%;">
        <tr>
            <td><lable>流向名称</lable></td>
            <td>
                <input type="text" id="create_sink_name_id" placeholder="如：db_172_16_41_151_3306_v3a_dbbase_v3a_oeminfo" name="sink_name">
            </td>
            <td></td>
        </tr>
        <tr>
        <td><lable>流向类型</lable></td>
        <td>
            <select id="create_sink_type_id" name="sink_type">
                <option value="0">DB</option>
                <option value="1">Kafka</option>
            </select>
        </td>
        <td></td>
        </tr>
        <tr id="create_ds_tr_id">
            <td><lable>数据源</lable></td>
            <td>
                <select id="ds_name_id_create" name="ds_id"></select>
            </td>
            <td></td>
        </tr>
        <tr id="create_tab_tr_id">
            <td><lable>流向表</lable></td>
            <td>
                <select id="tab_name_id_create" name="tab_id"></select>
            </td>
            <td></td>
        </tr>
        <tr id="create_iprow_id">
            <td><lable>IP</lable></td>
            <td>
                <input type="text" id="create_sink_ip_id" name="sink_ip">
            </td>
            <td></td>
        </tr>
        <tr id="create_portrow_id">
            <td><lable>端口</lable></td>
            <td>
                <input type="text" id="create_sink_port_id" name="sink_port"></input>
            </td>
            <td></td>
        </tr>

        <tr id="create_dsnamerow_id">
            <td><lable>库名/主题</lable></td>
            <td>
                <input type="text" id="create_sink_topic_id" placeholder="如：db_172_16_41_151_3306-v3a_dbbase-v3a_oeminfo" name="sink_topic">
            </td>
            <td></td>
        </tr>
        <tr id="create_unamerow_id">
            <td><lable>用户名</lable></td>
            <td>
                <input type="text" id="create_sink_username_id" name="sink_uname">
            </td>
            <td></td>
        </tr>
        <tr id="create_passwdtrow_id">
            <td><lable>密码</lable></td>
            <td>
                <input type="text" id="create_sink_passwd_id" name="sink_pwd">
            </td>
            <td></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    $("#create_iprow_id").hide();
    $("#create_portrow_id").hide();
    $("#create_dsnamerow_id").hide();
    $("#create_unamerow_id").hide();
    $("#create_passwdtrow_id").hide();
    $("#create_sink_type_id").change(function(){
        if($("#create_sink_type_id").val() == 0) {
            $("#create_iprow_id").hide();
            $("#create_portrow_id").hide();
            $("#create_dsnamerow_id").hide();
            $("#create_unamerow_id").hide();
            $("#create_passwdtrow_id").hide();
        } else {
            $("#create_iprow_id").show();
            $("#create_portrow_id").show();
            $("#create_dsnamerow_id").show();
            $("#create_unamerow_id").show();
            $("#create_passwdtrow_id").show();
        }
    });


    // 加载设置数据源名称
    loadDs();
    function loadDs(){
        $("#ds_name_id_create").load(
                "dataSourceController/queryDataSource.do",
                null,
                function(response) {
                    var json =  JSON.parse(response);
                    var data = json.aaData;
                    var resultStr="";
                    $.each(data, function(index, object){
                        if(object.ds_status==1 && object.is_on==1) {
                            resultStr += "<option value=" + object.ds_id + ">" + object.ds_name + "</option>";
                        }
                    });
                    $("#ds_name_id_create").append(resultStr);
                    // 出发加载表
                    changeDsGetTable();
                }
        );
    }

    //数据源变化出发改变表信息
    $("#ds_name_id_create").change(function(){
        changeDsGetTable();
    });

    function changeDsGetTable(){

        $("#tab_name_id_create").load(
//                "dataSourceController/queryDataSourceTables.do",
                "dataSourceTableController/queryAvaTableByDsId.do",
                {ds_id: $("#ds_name_id_create").val()},
                function (response) {
                    var result = "";
                    var responseJSON = JSON.parse(response);
                    $.each(responseJSON, function (index, json) {
                        if(json.is_on==1){
                            result += "<option value="+json.tab_id+">" + json.tab_name + "</option>";
                        }
//                        result+= "<option id=tabIdOption hidden=true  value="+json.tab_id+">";;
                    });
                    $("#tab_name_id_create").append(result);
                }
        );

    }
    //流向类型出发修改表单结构
    $("#create_sink_type_id").change(function(){
        if($("#create_sink_type_id").val() == 0){
            $("#create_ds_tr_id").show();
            $("#create_tab_tr_id").show();
        }else{
            $("#create_ds_tr_id").hide();
            $("#create_tab_tr_id").hide();
        }
    });


</script>