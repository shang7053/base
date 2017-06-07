<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-12
  Time: 下午5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<form id="create_canal_form" action="javascript:;">
    <table style="width: 100%;">
        <tr>
            <td><lable>名称</lable></td>
            <td>
                <input type="text" id="create_canal_name_id" placeholder="如：172_16_41_151_1111_voole_global_res_cpinfo" name="canal_name">
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>canal ip</lable></td>
            <td>
                <input type="text" id="create_canal_ip_id" name="canal_ip">
            </td>
            <td></td>
        </tr>
        <tr>
        <td><lable>canal port</lable></td>
        <td>
            <input type="text" id="create_canal_port_id" name="canal_port">
        </td>
        <td></td>
        </tr>
        <tr>
            <td><lable>主题</lable></td>
            <td>
                <input type="text" id="create_canal_destination_id" placeholder="172_16_41_11_3306_voole_global_res_cpinfo" name="canal_destination">
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>过滤器</lable></td>
            <td>
                <input type="text" id="create_canal_subscribe_id" placeholder="voole_global.res_cpinfo" name="canal_subscribe">
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>是否ZooKeeper</lable></td>
            <td>
                <select id="create_is_zookeeper_id" name="is_zookeeper">
                    <option value="0">否</option>
                    <option value="1">是</option>
                </select>
            </td>
            <td></td>
        </tr>
    </table>
</form>
