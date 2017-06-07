<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-12
  Time: 下午5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="create_regcolumn_form" action="javascript:;">

    <table style="width: 100%;">
        <tr>
            <td><lable>数据源</lable></td>
            <td>
                <select id="ds_name_id_create" name="ds_id"></select>
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>表名称</lable></td>
            <td>
                <select id="tab_name_id_create" name="tab_id"></select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>字段名称</lable></td>
            <td>
                <select id="col_name_id_create" name="col_id"></select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>字段规则名称</lable></td>
            <td>
                <input type="text" id="col_reg_name_id_create" placeholder="如：大于100" name="col_reg_name"></input>
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
                    <tbody id="create_regcolumn_rule_id">
                    </tbody>
                </table>
            </td>
            <td style="width: 20%;">
                <table class="table">
                    <thead>
                        <tr><th><button id="addColumnReg-new">增加</button></th></tr>
                        <tr><th><button id="deleteColumnReg-new">删除</button></th></tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    $("#ds_name_id_create").change(function(){
        $("#tab_name_id_create").empty();
        $("#col_name_id_create").empty();
        changeCreateFieldDs();
    });


    $("#tab_name_id_create").change(function(){
        $("#col_name_id_create").empty();
        changeCreateFieldTs();
    });


    /***
     * 表联动
     * */
    function changeCreateFieldTs(){
        //加载表中的字段信息
        var result = "";
        $("#col_name_id_create").load(
            "tableFieldController/queryTableField.do" ,
            {tab_id:$("#tab_name_id_create").val()},
            function(response){
                var temp = JSON.parse(response);
                var data = temp.aaData;
                $.each(data, function(index, json){
                    if(json.is_on ==1 ) {
                        result += "<option value=" + json.col_id + ">" + json.col_name + "</option>"
                    }
                });
                $("#col_name_id_create").empty();
                $("#col_name_id_create").append(result);
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
                {ds_id: $("#ds_name_id_create").val()},
                function (response) {
                    var result = "";
                    var responseJSON = JSON.parse(response);
                    $.each(responseJSON, function (index, json) {
                        if(json.is_on==1){
                            result += "<option value="+json.tab_id+">" + json.tab_name + "</option>";
                        }
                        result+= "<option id=tabIdOption hidden=true  value="+json.tab_id+">";;
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

    var symbolSelect= " <option value='0' name='equal'>=</option>" +
                        "<option value='1' name='notequal'>!=</option>"+
                        "<option value='2' name='bigger'>></option>" +
                        "<option value='3' name='less'><</option>" +
                        "<option value='4' name='biggerequal'>>=</option>" +
                        "<option value='5' name='lessequal'><=</option> ";

    var addedLineBeforePart =      " <td>";
    var addedLineAfterPart=         "</td>" +
                                    "<td> ";
    var addedLineLastPart =
                                   " </td>" +
                              "</tr> ";
    var numberOfLines = 0;
    //增加按钮事件
    $("#addColumnReg-new").click(function(){
        numberOfLines++;
        var lineCode = "<tr id=colRegLine"+numberOfLines +"> "+ addedLineBeforePart+
                        "<select style='width:80px;' id=colReg"+numberOfLines+" name='colReg"+numberOfLines+"'> " +
                        symbolSelect+ " </select>"+addedLineAfterPart + "<input type=text name='regval"+numberOfLines+"'>"+addedLineLastPart;
        $("#create_regcolumn_rule_id").append( lineCode);

    });
    //删除按钮事件
    $("#deleteColumnReg-new").click(function(){
       if(numberOfLines ==0){
           alert("请先添加行！");
       }else{
           var idName="#colRegLine"+numberOfLines
           $(idName).remove();
           numberOfLines--;
       }

    });
</script>