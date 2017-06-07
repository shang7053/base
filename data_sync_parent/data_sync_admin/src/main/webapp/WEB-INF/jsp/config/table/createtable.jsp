<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-12
  Time: 下午5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="create_table_form" action="javascript:;">
    <table style="width: 100%;">
        <tr>
            <td><lable>数据源</lable></td>
            <td>
                <select id="ds_name_id_create"></select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>表名称</lable></td>
            <td>
                <%--<input type="text" name="tab_name"/></td>--%>
                <select id="tab_name_id_create" placeholder="如：172_16_41_151_3306_v3a_dbbase_v3a_oeminfo" name="tab_name"></select>
            <td></td>
        </tr>
        <tr>
            <td><lable>表备注</lable></td>
            <%--<td><input type="textarea" name="tab_note"/></td>--%>
            <td><textarea class="form-control" name="tab_note" rows="3"></textarea> </td>
            <td></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    //创建框选择数据源
    $("#ds_name_id_create").change(function(){
        changeCreateDs()
    });
    function changeCreateDs(){
        if($("#ds_name_id_create").val() == ""){
            $("#tab_name_id_create").empty();
            $("#tab_name_id_create").append("<option value=''>请选择</option>");
        }else{
            $("#tab_name_id_create").load(
                "dataSourceController/queryDataSourceTables.do",
                {ds_id: $("#ds_name_id_create").val()},
                function(response) {
                    var result = "";
                    var responseJSON = JSON.parse(response);
                    var length = 0;
                    $.each(responseJSON, function(index, json){
                        length = length + 1;
                    });
                    if(length > 0){
                        $.each(responseJSON, function(index, json){
                            result += "<option>" + json.tab_name + "</option>";
                        });
                        $("#tab_name_id_create").append(result);
                    } else {
//                        $("#tab_name_id_create").append("<option>请选择</option>");
                    }
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
                if(object.is_on==1 && object.ds_status==1){
                    resultStr += "<option value=" +object.ds_id+ ">" +object.ds_name+ "</option>";
                }
            });
            $("#ds_name_id_create").append(resultStr);
            changeCreateDs();
        }
    );
</script>