<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-11
  Time: 下午4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="canal_form" action="javascript:;">
    <table style="width: 100%;">
        <tr>
            <td><lable>名称</lable></td>
            <td>
                <input type="text" id="info_canal_name_id" readonly="readonly"  name="canal_name" value="${canalinfo.canal_name}">
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>canal ip</lable></td>
            <td>
                <input type="text" id="info_canal_ip_id" name="canal_ip" value="${canalinfo.canal_ip}">
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>canal port</lable></td>
            <td><input type="text" name="canal_port" id="info_canal_port_id" value="${canalinfo.canal_port}"/></td>
            <td></td>
        </tr>

        <tr>
            <td><lable>主题</lable></td>
            <td><input type="text" id="info_canal_destination_id" name="canal_destination" value="${canalinfo.canal_destination}"/></td>
            <td></td>
        </tr>


        <tr>
            <td><lable>过滤器</lable></td>
            <td>
                <input type="text" id="info_canal_subscribe_id" name="canal_subscribe" value="${canalinfo.canal_subscribe}"></input>
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>是否ZK</lable></td>
            <td>
                <select id="info_canal_is_zookeeper_id" name="is_zookeeper" disabled>
                    <option value="${canalinfo.is_zookeeper}" selected>${canalinfo.is_zookeeper == 0 ? '否' : '是' }</option>
                    <option value="${1-canalinfo.is_zookeeper}">${(1-canalinfo.is_zookeeper)==0 ? '否' : '是'}</option>
                </select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>是否启用</lable></td>
            <td>
                <select id="info_canal_is_on_id" name="is_on" disabled>
                    <option value="${canalinfo.is_on}" selected>${canalinfo.is_on== 0 ? '否' : '是'}</option>
                    <option value="${1-canalinfo.is_on}">${(1-canalinfo.is_on) == 0 ? '否' : '是'}</option>

                </select>
            </td>
            <td></td>
        </tr>

        <tr style="display: none;">
            <td><lable>修改时间</lable></td>
            <td><input type="text"  value='<fmt:formatDate value="${canalinfo.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'/> </td>
            <td></td>
        </tr>
        <tr style="display: none;">
            <td><lable>创建时间</lable></td>
            <td><input type="text" value='<fmt:formatDate value="${canalinfo.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'  /></td>
            <td></td>
        </tr>

    </table>
</form>
<script>


    //数据源变化出发改变表信息
    $("#ds_name").change(function(){
        changeDsGetTable();
    });

    function changeDsGetTable(){
        $("#tab_name").load(
//                "dataSourceController/queryDataSourceTables.do",
                "dataSourceTableController/queryAvaTableByDsId.do",
                {ds_id: $("#ds_name").val()},
                function (response) {
                    var result = "";
                    var responseJSON = JSON.parse(response);
                    $.each(responseJSON, function (index, json) {
                        if(json.is_on==1){
                            result += "<option value="+json.tab_id+">" + json.tab_name + "</option>";
                        }
                    });

                    $("#tab_name").append(result);
                }
        );

    }
    //流向类型出发修改表单结构
    $("#sink_type_info_id").change(function(){
        //alert("sinktype info changed " + $("#sink_type_info_id").val())
        if($("#sink_type_info_id").val() == 1){
            $("#show_ds_name_id").hide();
            $("#show_tab_name_id").hide();
        }else{
            $("#show_ds_name_id").show();
            $("#show_tab_name_id").show();
            loadDs();
        }
    });



    function loadDs(){
        $("#ds_name").load(
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
                    $("#ds_name").append(resultStr);
                    // 出发加载表
                    changeDsGetTable();
                }
        );
    }


</script>