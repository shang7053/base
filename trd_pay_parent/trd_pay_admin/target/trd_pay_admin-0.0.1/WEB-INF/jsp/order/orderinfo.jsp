<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form id="setting_form" action="javascript:;">
 	<table style="width: 100%;">
 		<tr>
 			<td><lable>订单号</lable></td>
 			<td><input type="text" value="${orderinfo.orderNum }"/></td>
 		</tr>
 		<tr>
 			<td title="当退款时，生成新订单号。此属性记录原订单号"><lable>原订单号</lable></td>
 			<td><input type="text" value="${orderinfo.origOrderNum }"/></td>
 		</tr>
 		</tr>
 			<td><lable>订单状态</lable></td>
 			<td><input type="text" value="${orderinfo.order_status }"/></td>
 		</tr>
 		<tr>
 			<td><lable>订单名称</lable></td>
 			<td><input type="text" value="${orderinfo.order_name }"/></td>
 		</tr>
 		<tr>
 			<td><lable>订单类型</lable></td>
 			<td><input type="text" value="${orderinfo.order_type == 0 ? '单点' : '套餐' }"/></td>
 		</tr>
 		</tr>
 			<td><lable>支付渠道</lable></td>
 			<td><input type="text" value="${orderinfo.chcd }"/></td>
 		</tr>
 		</tr>
 			<td><lable>金额</lable></td>
 			<td><input type="text" value="${orderinfo.amt/ 100.00 }"/>元</td>
 		</tr>
 		</tr>
 			<td><lable>渠道交易号</lable></td>
 			<td><input type="text" value="${orderinfo.channelOrderNum }"/></td>
 		</tr>
 		</tr>
 			<td><lable>渠道优惠</lable></td>
 			<td><input type="text" value="${orderinfo.chcdDiscount }"/></td>
 		</tr>
 		</tr>
 			<td><lable>商户优惠</lable></td>
 			<td><input type="text" value="${orderinfo.merDiscount }"/></td>
 		</tr>
 		</tr>
 			<td><lable>用户支付银行标识</lable></td>
 			<td><input type="text" value="${orderinfo.bankType }"/></td>
 		</tr>
 		</tr>
 			<td><lable>用户账号</lable></td>
 			<td><input type="text" value="${orderinfo.consumerAccount }"/></td>
 		</tr>
 		<tr>
 			<td><lable>设备类型（oemid）</lable></td>
 			<td><input type="text" value="${orderinfo.oemid }"/></td>
 		</tr>
 		<tr>
 			<td><lable>设备编号（hid）</lable></td>
 			<td><input type="text" value="${orderinfo.hid }"/></td>
 		</tr>
 		<tr>
 			<td><lable>用户ID（uid）</lable></td>
 			<td><input type="text" value="${orderinfo.uid }"/></td>
 		</tr>
 		</tr>
 			<td><lable>回调交易结果</lable></td>
 			<td><input type="text" value="${orderinfo.respcd }"/></td>
 		</tr>
 		</tr>
 			<td><lable>错误信息</lable></td>
 			<td><input type="text" value="${orderinfo.errorDetail }"/></td>
 		</tr>
 		</tr>
 			<td><lable>操作时间</lable></td>
 			<td><input type="text" value='<fmt:formatDate value="${orderinfo.transTime }" pattern="yyyy-MM-dd HH:mm:ss"/>'/></td>
 		</tr>
 		</tr>
 			<td><lable>生成二维码时间</lable></td>
 			<td><input type="text" value="<fmt:formatDate value="${orderinfo.qr_transTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
 		</tr>
 		</tr>
 			<td><lable>支付时间</lable></td>
 			<td><input type="text" value="<fmt:formatDate value="${orderinfo.aply_transTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
 		</tr>
 		</tr>
 			<td><lable>退款时间</lable></td>
 			<td><input type="text" value="<fmt:formatDate value="${orderinfo.cancel_transTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
 		</tr>
 		</tr>
 			<td><lable>支付串</lable></td>
 			<td><input type="text" value="${orderinfo.qrcode }"/></td>
 		</tr>
 		</tr>
 			<td><lable>订单创建时间</lable></td>
 			<td><input type="text" value="<fmt:formatDate value="${orderinfo.create_time }" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
 		</tr>
 	</table>
</form>