<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-11
  Time: 下午4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="sink_form" action="javascript:;">
    <table style="width: 100%;">
        <tr>
            <td><lable>流向名称</lable></td>
            <td>
                <input type="text" id="sink_name_info_id" readonly="readonly"  name="sink_name" value="${sinkinfo.sink_name}">
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>流向类型</lable></td>
            <td>
                <select id="sink_type_info_id" name="sink_type" disabled>
                        <option value="${sinkinfo.sink_type}" selected>${sinkinfo.sink_type== 0 ? 'DB' : 'Kafka'}</option>
                        <option value="${1-sinkinfo.sink_type}">${(1-sinkinfo.sink_type) == 0 ? 'DB' : 'Kafka'}</option>
                </select>

            </td>
            <td></td>
        </tr>

        <tr id="show_ds_name_id">
            <td><lable>数据源</lable></td>
            <%--<td><input type="text" name="ds_name" value="${tableinfo.ds_name}"/></td>--%>
            <td>
                <select id="ds_name" name="ds_id" disabled>
                    <option value=${sinkinfo.ds_id}>${sinkinfo.ds_name}</option>
                </select>
            </td>
            <td></td>
        </tr>

        <tr id="show_tab_name_id">
            <td><lable>流向表</lable></td>
            <%--<td><input type="text" name="ds_name" value="${tableinfo.ds_name}"/></td>--%>
            <td>
                <select id="tab_name" name="tab_id" disabled>
                    <option value="${sinkinfo.tab_id}">${sinkinfo.tab_name}</option>
                </select>
            </td>
            <td></td>
        </tr>


        <tr id="show_ip_id">
            <td><lable>IP</lable></td>
            <td>
                <input type="text" id="sink_ip_info_id" name="sink_ip" value="${sinkinfo.sink_ip}"></input>
            </td>
            <td></td>
        </tr>

        <tr  id="show_port_id">
            <td><lable>端口</lable></td>
            <td>
                <input type="text" id="sink_port_info_id" name="sink_port" value="${sinkinfo.sink_port}"></input>
            </td>
            <td></td>
        </tr>

        <tr  id="show_topic_id">
            <td><lable>库名/主题</lable></td>
            <td>
                <input type="text" id="sink_topic_info_id" name="sink_topic" value="${sinkinfo.sink_topic}">
            </td>
            <td></td>
        </tr>
        <tr  id="show_uname_id">
            <td><lable>用户名</lable></td>
            <td>
              <input type="text" id="sink_username_info_id" name="sink_uname" value="${sinkinfo.sink_uname}">
            </td>
            <td></td>
        </tr>
        <tr id="show_psswd_id">
            <td><lable>密码</lable></td>
            <td>
             <input type="text" id="sink_passwd_info_id" name="sink_pwd" value="${sinkinfo.sink_pwd}">
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>是否启用</lable></td>
            <%--<td><input type="text" value="${tableinfo.is_on == 0 ? '否' : '是' }"  /></td>--%>
            <td>
                <select id="sink_is_on_info_id" name="is_on">
                    <%--<option value=${sinkinfo.is_on}>${sinkinfo.is_on== 0 ? '否' : '是'}</option>--%>
                    <option value="${sinkinfo.is_on}" selected>${sinkinfo.is_on== 0 ? '否' : '是'}</option>
                    <option value="${1-sinkinfo.is_on}">${(1-sinkinfo.is_on) == 0 ? '否' : '是'}</option>

                </select>
            </td>
            <td></td>
        </tr>
        <tr style="display: none;">
            <td><lable>修改时间</lable></td>
            <td><input type="text"  value='<fmt:formatDate value="${sinkinfo.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'/> </td>
            <td></td>
        </tr>
        <tr style="display: none;">
            <td><lable>创建时间</lable></td>
            <td><input type="text" value='<fmt:formatDate value="${sinkinfo.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'  /></td>
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
            $("#show_ip_id").show();
            $("#show_port_id").show();
            $("#show_topic_id").show();
            $("#show_uname_id").show();
            $("#show_psswd_id").show();
            $("#sink_ip_info_id").attr("value","");
            $("#sink_port_info_id").attr("value","");
            $("#sink_topic_info_id").attr("value","");
            $("#sink_username_info_id").attr("value","");
            $("#sink_passwd_info_id").attr("value","");
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