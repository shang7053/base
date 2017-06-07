<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-12
  Time: 下午5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="create_regular_form" action="javascript:;">

    <table style="width: 100%;">
        <tr>
        <td><lable>规则名称</lable></td>
        <td>
            <input type="text" id="reg_name_id_create" placeholder="如：黑广oeminfo同步规则" name="reg_name">
        </td>
        <td></td>
        </tr>
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
    </table>
    <label>同步字段(<a href="javascript:void(0);" id="selectall">全选</a>)</label>
    <table class="table" style="width: 100%;">
        <tr>
            <td style="width: 70%;">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th></th>
                            <th>源字段名</th>
                            <th>目标字段名(若与源库一致可不填)</th>
                        </tr>
                    </thead>
                    <tbody id="create_regular_col_select_id" style='height:15px;'>
                    </tbody>
                </table>
            </td>
        </tr>
    </table>
    <label>同步规则</label>
    <table class="table" style="width: 100%;">

    </table>
    <table class="table" style="width: 100%;">
        <tr>
            <td style="width: 76%;">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>数据表规则</th>
                        <th>流向</th>
                    </tr>
                    </thead>
                    <tbody id="create_regular_rule_id" style='height:15px;'>
                    </tbody>
                </table>
            </td>
            <td style="width: 14%;">
                <table class="table">
                    <thead>
                    <tr><th><button id="addRegular-new">增加</button></th></tr>
                    <tr><th><button id="deleteRegular-new">删除</button></th></tr>
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
        changeCreateFieldDs();
    });


    $("#tab_name_id_create").change(function(){
        changeCreateFieldTs();
    });

	$("#selectall").click(function(){
		if("全选"==$(this).html().trim()){
			$(this).html("反选");
			$("#create_regular_col_select_id input[type='checkbox']").attr("checked","true"); 
		}else{
			$(this).html("全选");
			$("#create_regular_col_select_id input[type='checkbox']").removeAttr("checked");
		}
	});
    var tabRegularOptionStr ="";
    /***
     * 表联动
     * */
    function changeCreateFieldTs(){
        //加载表中的字段信息
        var result = "";
        $("#create_regular_col_select_id").empty();
        $("#create_regular_rule_id").empty();
        $.ajax({
                url:"tableFieldController/queryTableField.do" ,
                data:{tab_id:$("#tab_name_id_create").val(), "is_on":1},
                success: function(response){
                    var data = response.aaData;
                    var tableTrStr = "";
                    var i = 0;
                    $.each(data, function(index, json){
                        if(json.is_on ==1 ) {
                            i++;
                            tableTrStr +=   " <tr>" +
                                                "<td><input type='checkbox' name='chexbox_"+i+"_"+json.col_id+"'></td>"+
                                                "<td><input type='text' value='"+json.col_name+"' name='colName-"+i+"' readonly> </td>"+
                                                "<td><input type=text name='target" + i + "' </td>"+
                                             "</tr> ";
                        }
                    });
                    $("#create_regular_col_select_id").append(tableTrStr);

                }
        });
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
                "dataSourceTableController/queryAvaTableByDsId.do",
                {ds_id: $("#ds_name_id_create").val()},
                function (response) {
                    var result = "";
                    var responseJSON = JSON.parse(response);
                    $.each(responseJSON, function (index, json) {
                        if(json.is_on==1){
                            result += "<option value="+json.tab_id+">" + json.tab_name + "</option>";
                        }
                        result+= "<option id=tabIdOption hidden=true  value="+json.tab_id+">";
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


    var tableRegularOptionStr = "";
    var sinkOptionStr = "";
    //根据表名称 流向
    $.ajax({
        url:"sinkController/querySink.do",
        data:{"is_on":1},
        success: function(response){
            var data = response.aaData;
            var cal = 0;
            $.each(data, function(index, obj){
                cal++;
                sinkOptionStr += "<option name='sink"+cal+"' value='"+obj.sink_id+"'>"+obj.sink_name+"</option>";
            });
        }
    });

    var numberOfLines = 0;
    var rowStr ="";
    //增加按钮事件

    $("#addRegular-new").click(function(){
        //加载表规则列表
        numberOfLines++;
        LoadTableReg();

    });

    function LoadTableReg(){
        tableRegularOptionStr= "";
        $.ajax({
            url:"regularTableController/queryRegularTable.do",
            data:{"is_on":1, "tab_id":$("#tab_name_id_create").val()},
            success: function(response){
                var data = response.aaData;
                var cal = 0;
                $.each(data, function(index, obj){
                    cal++;
                    tableRegularOptionStr += " <option name='tabreg"+cal+"' value='"+obj.reg_tab_id+"'>"+obj.reg_tab_name+" </option>";
                });
                rowStr = "<tr id='row"+numberOfLines+"'>" +
                        "<td><select style='width:180px;' id='tabRegSelect"+numberOfLines+"' name='tabRegSelect_"+numberOfLines+"'>"+tableRegularOptionStr+"</select></td>" +
                        "<td><select style='width:180px;' id='tabRegSelect"+numberOfLines+"' name='sinkSelect_"+numberOfLines+"'>"+sinkOptionStr+"</select></td>"+
                        "</tr>";
                $("#create_regular_rule_id").append(rowStr);
            }
        });
    }
    //删除按钮事件
    $("#deleteRegular-new").click(function(){
        if(numberOfLines ==0){
            alert("请先添加行！");
        }else{
            var id = "#row"+numberOfLines;
            $(id).remove();
            numberOfLines--;
        }

    });






</script>