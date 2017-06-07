<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-12
  Time: 下午5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="create_field_form" action="javascript:;">
    <table style="width: 100%;">
        <tr>
            <td><lable>数据源</lable></td>
            <td>
                <select id="ds_name_id_create" name="ds_name"></select>
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>表名称</lable></td>
            <td>
                <select id="tab_name_id_create" name="tab_name"></select>
            </td>
            <td></td>
        </tr>
    </table>
    <table  id="create_field_table_id" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>字段名</th><th>备注</th>
                        </tr>
                    </thead>
                    <tbody id="field_config_id">
                    </tbody>
    </table>
</form>
<script type="text/javascript">
    $("#ds_name_id_create").change(function(){
        $("#tab_name_id_create").empty();
        $("#field_config_id").empty();
        changeCreateFieldDs();
    });

    $("#tab_name_id_create").change(function(){
        $("#field_config_id").empty();
        changeCreateFieldTs();
    });


    /***
     * 表联动
     * */
    function changeCreateFieldTs(){
        //加载表中的字段信息
//        $("#tabIdOption").attr("value")
        var result = "";
        $("#field_config_id").load(
            "dataSourceController/queryTablesFields.do" ,
            {tabName:$("#tab_name_id_create option:selected").text(), dsId: $("#ds_name_id_create").val()},
            function(response){
                $.each(JSON.parse(response), function(index, json){
                    result += "<tr>" +
//                        "          <td name=col_name"　+　index　+　" value=" + json.col_name+">"+json.col_name+"</td>" +
                        "          <td><input  style='height:15px;' readonly=true type=text name=col_name value="+json.col_name+"></td>" +
                        "          <td><input  style='height:15px;' type=text name=col_note ></td>" +
                        "  　　</tr>";
                });
                $("#field_config_id").empty();
                $("#field_config_id").html(result);
            }
        );
    }

    /**
     *
     * ds联动函数
     * */

    function changeCreateFieldDs() {
        if ($("#ds_name_id_create").val() == "") {
            $("#tab_name_id_create").empty();
        } else {

            $("#tab_name_id_create").load(
//                "dataSourceController/queryDataSourceTables.do",
                "dataSourceTableController/queryAvaTableByDsId.do",
                {ds_id: $("#ds_name_id_create").val(),is_on:1},
                function (response) {
                    var result = "<option>请选择</option>";
                    var responseJSON = JSON.parse(response);
                    $.each(responseJSON, function (index, json) {
                        result += "<option value="+json.tab_id+">" + json.tab_name + "</option>";
                    });
                    $("#tab_name_id_create").append(result);
                    changeCreateFieldTs();
                }
            );
        }
    }

    $("#ds_name_id_create").load(
        "dataSourceController/queryDataSource.do",
        null,
        function(response) {
            var json =  JSON.parse(response);
            var data = json.aaData;
            var resultStr="";
            $.each(data, function(index, object){
                if(object.is_on==1){
                    resultStr += "<option value=" +object.ds_id+ ">" +object.ds_name+ "</option>";
                }
            });
            $("#ds_name_id_create").append(resultStr);
            changeCreateFieldDs();
        }
    );
</script>