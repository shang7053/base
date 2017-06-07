<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-11
  Time: 下午4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="table_form" action="javascript:;">
    <table style="width: 100%;">
        <tr>
            <td><lable>数据源</lable></td>
            <%--<td><input type="text" name="ds_name" value="${tableinfo.ds_name}"/></td>--%>
            <td>
                <select id="ds_name" name="ds_id" disabled>
                    <option value=${tableinfo.ds_id}>${tableinfo.ds_name}</option>
                </select>
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>表名称</lable></td>
            <td>
                <%--<input type="text" name="tab_name" value="${tableinfo.tab_name}"/>--%>
                <select id="tab_name" name="tab_id" disabled>
                        <option value=${tableinfo.tab_id}>${tableinfo.tab_name}</option>
                </select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>表备注</lable></td>
            <td><input type="text" name="tab_note" value="${tableinfo.tab_note}"  /></td>
            <td></td>
        </tr>
        <tr>
            <td><lable>是否启用</lable></td>
            <%--<td><input type="text" value="${tableinfo.is_on == 0 ? '否' : '是' }"  /></td>--%>
            <td>
                <select id="is_on_id" name="is_on">
                    <option value=${tableinfo.is_on} selected>${tableinfo.is_on== 0 ? '否' : '是'}</option>
                    <option value="${1-tableinfo.is_on}">${(1-tableinfo.is_on) == 0 ? '否' : '是'}</option>
                </select>
                    <%--<select id="is_on_id" name="is_on">--%>
                        <%--<option value=1>是</option>--%>
                        <%--<option value=0>否</option>--%>
                    <%--</select>--%>
            </td>
            <td></td>
        </tr>
        <tr style="display: none;">
            <td><lable>修改时间</lable></td>
            <td><input type="text"  value='<fmt:formatDate value="${tableinfo.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'/> </td>
            <td></td>
        </tr>
        <%--<tr style="display: none;">--%>
            <%--<td><lable>验证时间</lable></td>--%>
            <%--<td><input type="text"  value='<fmt:formatDate value="${tableinfo.validate_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'/> </td>--%>
            <%--<td></td>--%>
        <%--</tr>--%>
        <tr style="display: none;">
            <td><lable>创建时间</lable></td>
            <td><input type="text" value='<fmt:formatDate value="${tableinfo.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'  /></td>
            <td></td>
        </tr>

    </table>
</form>
<script type="text/javascript">
    //创建框选择数据源
    $("#ds_name").change(function(){
        changeModifyDs()
    });
    function changeModifyDs(){
        if($("#tab_name").val() == ""){
            $("#tab_name").empty();
        }else{
            $("#tab_name").load(
                "dataSourceController/queryDataSourceTables.do",
                {ds_id: $("#ds_name").val()},
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
                        $("#tab_name").append(result);
                    }
                }
            );
        }
    }
</script>