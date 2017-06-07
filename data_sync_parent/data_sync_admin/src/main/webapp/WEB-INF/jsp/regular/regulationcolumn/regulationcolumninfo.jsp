<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-11
  Time: 下午4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="regcolumn_form" action="javascript:;">
    <table style="width: 100%;">
        <tr>
            <td><lable>数据源</lable></td>
            <%--<td><input type="text" name="ds_name" value="${tableinfo.ds_name}"/></td>--%>
            <td>
                <select id="ds_name" name="ds_id" disabled>
                    <option value=${regcolumninfo.ds_id}>${regcolumninfo.ds_name}</option>
                </select>
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>表名称</lable></td>
            <%--<td><input type="text" name="tab_name" value="${fieldinfo.tab_name}"/></td>--%>
            <td>
            <select id="tab_name" name="tab_id" disabled>
                <option value=${regcolumninfo.tab_id}>${regcolumninfo.tab_name}</option>
            </select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>字段名</lable></td>
            <td>
                <select id="col_name" name="col_name" disabled>
                    <option value="${regcolumninfo.col_id}">${regcolumninfo.col_name}</option>
                </select>
            </td>
            <%--<td><input type="text" name="col_name" value="${regcolumninfo.col_name}"  /></td>--%>
            <td></td>
        </tr>
        <tr>
            <td><lable>字段规则名</lable></td>
            <td>
                <input type="text" name="col_reg_name" value="${regcolumninfo.col_reg_name}" />
                <%--<select id="col_reg_name" name="col_reg_name" disabled>--%>
                    <%--<option value="${regcolumninfo.col_reg_name}">${regcolumninfo.col_reg_name}</option>--%>
                <%--</select>--%>
            </td>
            <td></td>
        </tr>
    </table>

    <label>字段规则（只针对数值和字符类型数据）</label>
    <table class="table" style="width: 100%;">
        <tr>
            <td style="width: 70%;">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>运算</th>
                        <th>运算目标值</th>
                    </tr>
                    </thead>
                    <tbody id="info_regcolumn_rule_id">

                    </tbody>
                </table>
            </td>
            <td style="width: 20%;">
                <table class="table">
                    <thead>
                    <tr><th><button id="addColumnReg" disabled>增加</button></th></tr>
                    <tr><th><button id="deleteColumnReg" disabled>删除</button></th></tr>
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
            <%--<td><input type="text" value="${tableinfo.is_on == 0 ? '否' : '是' }"  /></td>--%>
            <td>
                <select id="is_on_id" name="is_on">
                    <option value=${regcolumninfo.is_on} selected>${regcolumninfo.is_on== 0 ? '否' : '是'}</option>
                    <option value="${1-regcolumninfo.is_on}">${(1-regcolumninfo.is_on) == 0 ? '否' : '是'}</option>
                </select>
            </td>
            <td></td>
        </tr>
        <tr style="display: none;">
            <td><lable>修改时间</lable></td>
            <td><input type="text"  value='<fmt:formatDate value="${regcolumninfo.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'/> </td>
            <td></td>
        </tr>
        <tr style="display: none;">
            <td><lable>创建时间</lable></td>
            <td><input type="text" value='<fmt:formatDate value="${regcolumninfo.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'  /></td>
            <td></td>
        </tr>
    </table>
</form>
<script>

    var symbolSelect= " <option value='0' name='equal' id='o0'>=</option>" +
            "<option value='1' name='notequal' id='o1'>!=</option>"+
            "<option value='2' name='bigger' id='o2'>></option>" +
            "<option value='3' name='less' id='o3'><</option>" +
            "<option value='4' name='biggerequal' id='o4'>>=</option>" +
            "<option value='5' name='lessequal' id='o5'><=</option> ";

    var addedLineBeforePart =      " <td>";
    var addedLineAfterPart=         "</td>" +
            "<td> ";
    var addedLineLastPart =
            " </td>" +
            "</tr> ";

    var num = 0;
    var numberOfLines = 0;
    function setColRegTable() {
        var colRegStr = "";

        colRegStr = ${regcolumninfo.col_reg};

        $.each(colRegStr, function(index, json){
//                alert(json.symbol + " : " + json.value);
            num++;
            var  linesCode = "<tr id=colRegLine"+num +"> "+ addedLineBeforePart+
                    "<select style='width:80px;' id=colReg"+num+" name='colReg"+num+"'> " +
                    symbolSelect+ " </select>"+addedLineAfterPart + "<input type=text id='input"+num+"' name='regval"+num+"'>"+addedLineLastPart;
            $("#info_regcolumn_rule_id").append(linesCode);
            var symbolVal = 0;
//            debugger
            if(json.symbol == "=") symbolVal = 0;
            else if($.trim(json.symbol) =="!=") symbolVal = 1;
            else if($.trim(json.symbol) ==">") symbolVal = 2;
            else if($.trim(json.symbol) =="<") symbolVal = 3;
            else if($.trim(json.symbol) ==">=") symbolVal = 4;
            else symbolVal = 5;

            $("#colRegLine"+num +" #o"+symbolVal).attr("selected","true");
            $("#colRegLine"+num +" #input"+num).attr("value", json.value);
        });
        numberOfLines = num;
    }


    //增加按钮事件
    $("#addColumnReg").click(function(){
//        debugger;
        numberOfLines++;
//        alert(numberOfLines)
        var lineCode = "<tr id=colRegLine"+numberOfLines +"> "+ addedLineBeforePart+
                "<select style='width:80px;' id=colReg"+numberOfLines+" name='colReg"+numberOfLines+"'> " +
                symbolSelect+ " </select>"+addedLineAfterPart + "<input type=text name='regval"+numberOfLines+"'>"+addedLineLastPart;
        $("#info_regcolumn_rule_id").append( lineCode);

    });

    //删除按钮事件

    $("#deleteColumnReg").click(function(){
//        alert(numberOfLines)
        if(numberOfLines ==0){
            alert("请先添加行！");
        }else{
            var idName="#colRegLine"+numberOfLines
            $(idName).remove();
            numberOfLines--;
        }
    });

    // 数据源变化出发函数
    $("#ds_name").change(function(){
        $("#tab_name").empty();
        $("#col_name").empty();
        changeTable();
    });
    // 表变化触发函数
    $("#tab_name").change(function(){
        $("#col_name").empty();
        changeColumn();
    });

    //数据源变化-改变表
    function changeTable(){
        $("#tab_name").load(
                "dataSourceTableController/queryAvaTableByDsId.do",
                {ds_id: $("#ds_name").val()},
                function (response) {
                    var result = "";
                    var responseJSON = JSON.parse(response);
                    $.each(responseJSON, function (index, json) {
                        if(json.is_on==1){
                            result += "<option value="+json.tab_id+">" + json.tab_name + "</option>";
                        }
                        result+= "<option id=tabIdOption hidden=true  value="+json.tab_id+">";;
                    });
                    $("#tab_name").append(result);
                    changeColumn();
                }
        );
    }
    //表变化查询字段
    function changeColumn(){
        //加载表中的字段信息
//        alert("change column")
        var result = "";
        $("#col_name").load(
                "tableFieldController/queryTableField.do" ,
                {tab_id:$("#tab_name").val()},
                function(response){
                    var temp = JSON.parse(response);
                    var data = temp.aaData;
                    $.each(data, function(index, json){
                        if(json.is_on ==1 ) {
                            result += "<option value=" + json.col_id + ">" + json.col_name + "</option>"
                        }
                    });
                    $("#col_name").empty();
                    $("#col_name").append(result);
                }
        );
    }
</script>