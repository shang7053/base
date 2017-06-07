<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-12
  Time: 下午5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id=create_regtable_form action="javascript:;">

    <table style="width: 100%;">
        <tr>
            <td><lable>数据源</lable></td>
            <td>
                <select id="create_regtab_selectds_id" name="ds_id"></select>
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>表名称</lable></td>
            <td>
                <select id="create_regtab_selectts_id" name="tab_id"></select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>表规则名称</lable></td>
            <td>
                <input type="text" id="create_regtab_regname_id" placeholder="如：id大于100name等于张三" name="reg_tab_name">
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
                    <tbody id="create_table_rule_id">
                       <%--<tr></tr>--%>
                    </tbody>
                </table>
            </td>
            <td style="width: 20%;">
                <table class="table">
                    <thead>
                        <tr><th><button id="addTableReg-new">增加</button></th></tr>
                        <tr><th><button id="deleteTableReg-new">删除</button></th></tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript">

    $("#create_regtab_selectds_id").change(function(){
        $("#create_regtab_selectts_id").empty();
        changeCreateRegTabDs();
    });


    $("#create_regtab_selectts_id").change(function(){
        changeCreateRegTabTs();
    });

    var regColOptionStr="";
    var colRegNameOptionStr="";
    var regColNameMap = {};
    var regColMap = {};

    /***
     * 表联动
     * */
    function changeCreateRegTabTs(){
        //
        $("#create_table_rule_id").find("tr").remove();
        //加载表中的字段信息
        var result = "";
        numberOfLines = 0;
        $.ajax({
                url: "regularColumnController/queryColRegInfoByTabId.do",
                data:{"tab_id":$("#create_regtab_selectts_id").val()},
                success: function(response) {
                    regColOptionStr="";
                    regColNameMap={};
                    $.each(response, function(index, object) {
                        regColNameMap[object.col_name] = object.col_id;
                        var colId = object.col_id;
                        var reg_col_id = object.reg_col_id;
                        var col_reg_name = object.col_reg_name;
                        if(regColMap["id"+colId] == null){
                            var tempMap = {};
                            tempMap[col_reg_name]=reg_col_id;
                            regColMap["id"+colId] = tempMap;
                        } else {
                            (regColMap["id"+colId])[col_reg_name]=reg_col_id;
                        }
                    });
                    $.each(regColNameMap, function(key, value){
                        regColOptionStr += "<option style='width:70px;' value='"+value+"' name='col_id'> " +key+ "</option>"
                    });

                }

        });
    }



    /**
     *
     * ds联动函数
     * */

    function changeCreateRegTabDs() {
        if ($("#create_regtab_selectds_id").val() == "") {
            $("#create_regtab_selectts_id").empty();
        } else {
            $("#create_regtab_selectts_id").load(
                "dataSourceTableController/queryAvaTableByDsId.do",
                {ds_id: $("#create_regtab_selectds_id").val()},
                function (response) {
                    var result = "";
                    var responseJSON = JSON.parse(response);
                    $.each(responseJSON, function (index, json) {
                        if(json.is_on==1){
                            result += "<option value="+json.tab_id+">" + json.tab_name + "</option>";
                        }
                    });
                    $("#create_regtab_selectts_id").append(result);
                    changeCreateRegTabTs();
                }
            );
        }
    }

    //行数技数器
    var numberOfLines = 0;
    //增加按钮事件
    $("#addTableReg-new").click(function(){
        if(regColOptionStr != ""){
            numberOfLines++;
            var lineCode = "<tr id='tabRegLine"+numberOfLines+"'>" +
                                    "<td>"+
                                        "<select style='width:120px;' id='select_col_name"+numberOfLines+"' name='col_id' onchange=changeColRegName("+numberOfLines+")>" +
                                                "<option value='-100'>请选择</option>" +
                                                regColOptionStr+
                                        "<select>" +
                                     "</td> " +
                                    "<td>"+
                                        "<select style='width:250px;' id='select_col_reg_id"+numberOfLines+"' name='reg_col_id"+numberOfLines+"'>"+
                                        "</select>"+
                                    "</td>" +
                            "</tr>";
//            alert(lineCode)
            $("#create_table_rule_id").append(lineCode);
        } else {
            alert("请先为该字段配置规则");
        }
    });

    //删除按钮事件
    $("#deleteTableReg-new").click(function(){
       if(numberOfLines ==0){
           alert("请先添加行！");
       }else{
           var idName="#tabRegLine"+numberOfLines;
           $(idName).remove();
           numberOfLines--;
       }
    });

    function changeColRegName(lineNumber){
        var col_id = $("#select_col_name"+lineNumber).val();
        var str ="";
        $("#select_col_reg_id"+lineNumber).empty();
        if(col_id !=-100){
            var colRegObj =regColMap["id"+col_id];
            if(colRegObj == null) {
                alert("请先为该字段建立规则！");
            } else {
                $.each(colRegObj, function (col_reg_name, reg_col_id) {
//                    alert("id " + reg_col_id + " name " + col_reg_name)
                    str+="<option  value='"+reg_col_id+"' name='reg_col_id'>"+col_reg_name+"</option>";
                });
                $("#select_col_reg_id"+lineNumber).append(str);
            }
        }
    }
</script>