<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="lost_data_form" action="javascript:;">
    <table style="width: 100%;">
        <tr>
            <td><lable>同步码</lable></td>
            <td>
                <input type="text" value="${LostData.sync_code}">
            </td>
        </tr>

        <tr>
            <td><lable>丢失类型</lable></td>
            <td>
                <input type="text"  value="${LostData.lost_type == 0 ? '异常' : '未匹配规则' }">
            </td>
        </tr>

        <tr>
            <td><lable>流向名称</lable></td>
            <td><input type="text" value="${LostData.sink_name}"/></td>
        </tr>

        <tr>
            <td><lable>同步类型</lable></td>
            <td><textarea>${LostData.event_type}</textarea> </td>
        </tr>
        <tr>
            <td><lable>数据</lable></td>
            <td><textarea>${LostData.row_data}</textarea></td>
        <tr>
            <td><lable>异常信息</lable></td>
            <td><textarea>${LostData.ex}</textarea></td>
        </tr>
        <tr>
            <td><lable>数据状态</lable></td>
            <td>
               <input type="text"  value="${LostData.data_status == 0 ? '未处理' : '已处理' }">
            </td>
        </tr>
        <tr style="display: none;">
            <td><lable>创建时间</lable></td>
            <td><input type="text" value='<fmt:formatDate value="${LostData.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'  /></td>
        </tr>

    </table>
</form>