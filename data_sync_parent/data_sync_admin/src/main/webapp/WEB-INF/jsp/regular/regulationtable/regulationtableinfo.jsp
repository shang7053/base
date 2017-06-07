<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-11
  Time: 下午4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="regtable_form" action="javascript:;">
    <table style="width: 100%;">
        <tr>
            <td><lable>数据源</lable></td>
            <%--<td><input type="text" name="ds_name" value="${tableinfo.ds_name}"/></td>--%>
            <td>
                <select id="ds_name" name="ds_id" disabled>
                    <option value=${regtableinfo.ds_id}>${regtableinfo.ds_name}</option>
                </select>
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>表名称</lable></td>
            <%--<td><input type="text" name="tab_name" value="${fieldinfo.tab_name}"/></td>--%>
            <td>
            <select id="tab_name" name="tab_id" disabled>
                <option value=${regtableinfo.tab_id}>${regtableinfo.tab_name}</option>
            </select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>表规则名称</lable></td>
            <td>
                <input type="text" name="col_reg_name" value="${regtableinfo.reg_tab_name}" />
            </td>
            <td></td>
        </tr>
    </table>

    <label>字段规则</label>
    <table class="table" style="width: 100%;">
        <tr>
            <td style="width: 70%;">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>字段名称</th>
                        <th>字段规则</th>
                    </tr>
                    </thead>
                    <tbody id="info_regtable_rule_id">

                    </tbody>
                </table>
            </td>
            <td style="width: 20%;">
                <table class="table">
                    <thead>
                    <tr><th><button id="addTableReg" disabled>增加</button></th></tr>
                    <tr><th><button id="deletTableReg" disabled>删除</button></th></tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </td>
        </tr>
    </table>
    <table  style="width: 100%;">
        <tr style="display: none;">
            <td><lable>是否启用</lable></td>
            <td>
                <select id="is_on_id" name="is_on">
                    <option value=${regtableinfo.is_on} selected>${regtableinfo.is_on== 0 ? '否' : '是'}</option>
                    <option value="${1-regtableinfo.is_on}">${(1-regtableinfo.is_on) == 0 ? '否' : '是'}</option>
                </select>
            </td>
            <td></td>
        </tr>
        <tr style="display: none;">
            <td><lable>修改时间</lable></td>
            <td><input type="text"  value='<fmt:formatDate value="${regtableinfo.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'/> </td>
            <td></td>
        </tr>
        <tr style="display: none;">
            <td><lable>创建时间</lable></td>
            <td><input type="text" value='<fmt:formatDate value="${regtableinfo.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'  /></td>
            <td></td>
        </tr>
    </table>
</form>
<script>


    function setTabRegTable() {
        var colRegStr = "";
        var regColIdsStr = "${regtableinfo.reg_col_ids}";
        regColIdsStr = "(" +regColIdsStr.replace("_",",") +")";
        $.ajax({
            url: "regularTableController/queryColRegInfoByColIdList.do",
            data:{"regColIdList": regColIdsStr},
            success : function(response) {
                var rowStr ="";
                $.each(response, function(index, obj){

                    rowStr +="<tr><td><select style='width:120px;' disabled><option>"+obj.col_name+"</option></select></td>" +
                                 "<td><select style='width:250px;' disabled><option>"+obj.col_reg_name+"</option></td>"+
                            "<tr>"
                });
                $("#info_regtable_rule_id").append(rowStr);
            }
        });

    }



</script>