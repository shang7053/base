<%--
  Created by IntelliJ IDEA.
  User: mali
  Date: 17-5-11
  Time: 下午4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="regular_form" action="javascript:;">
    <table style="width: 100%;">
        <tr>
            <td><lable>规则名称</lable></td>
            <%--<td><input type="text" name="ds_name" value="${tableinfo.ds_name}"/></td>--%>
            <td>
                <select id="reg_name" name="ds_id" disabled>
                    <option value=${regularinfo.reg_id}>${regularinfo.reg_name}</option>
                </select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td><lable>数据源</lable></td>
            <%--<td><input type="text" name="ds_name" value="${tableinfo.ds_name}"/></td>--%>
            <td>
                <select id="ds_name" name="ds_id" disabled>
                    <option value=${regularinfo.ds_id}>${regularinfo.ds_name}</option>
                </select>
            </td>
            <td></td>
        </tr>

        <tr>
            <td><lable>表名称</lable></td>
            <%--<td><input type="text" name="tab_name" value="${fieldinfo.tab_name}"/></td>--%>
            <td>
            <select id="tab_name" name="tab_id" disabled>
                <option value=${regularinfo.tab_id}>${regularinfo.tab_name}</option>
            </select>
            </td>
            <td></td>
        </tr>
    </table>

    <label>同步字段</label>
    <table class="table" style="width: 100%;">
        <thead>
            <th>源库字段名</th>
            <th>目标库字段名（若与源库不一致可不填）</th>
        </thead>
        <tbody id="syn_col_tab_id">
		<c:forEach var="sc" items="${syncColVos }">
			<tr>
				<td><input type="text" value="${sc.src }" /></td>
				<td><input type="text" value="${sc.target }" /></td>
			</tr>
		</c:forEach>
        </tbody>
    </table>
    <label>同步规则</label>
    <table class="table" style="width: 100%;">
        <thead>
            <th>数据表规则</th>
            <th>流向</th>
            <th>操作</th>
        </thead>
        <tbody id="syn_rule_tab_id">
        <c:forEach var="reg" items="${regVos }">
			<tr>
				<td><input type="text" value="${reg.reg_tab_name }" /></td>
				<td><input type="text" value="${reg.sink_name }" /></td>
			</tr>
		</c:forEach>
        </tbody>
    </table>
    <table  style="width: 100%;">
        <tr>
            <td><lable>是否启用</lable></td>
            <%--<td><input type="text" value="${tableinfo.is_on == 0 ? '否' : '是' }"  /></td>--%>
            <td>
                <select id="is_on_id" name="is_on">
                    <option value=${regularinfo.is_on} selected>${regularinfo.is_on== 0 ? '否' : '是'}</option>
                    <option value="${1-regularinfo.is_on}">${(1-regularinfo.is_on) == 0 ? '否' : '是'}</option>
                </select>
            </td>
            <td></td>
        </tr>
        <tr style="display: none;">
            <td><lable>修改时间</lable></td>
            <td><input type="text"  value='<fmt:formatDate value="${regularinfo.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'/> </td>
            <td></td>
        </tr>
        <tr style="display: none;">
            <td><lable>创建时间</lable></td>
            <td><input type="text" value='<fmt:formatDate value="${regularinfo.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>'  /></td>
            <td></td>
        </tr>
    </table>
</form>
