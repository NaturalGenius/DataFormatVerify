<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收货者信息</title>
</head>
<body>
	<table border="1" cellpadding="8" cellspacing="0" width="800px" >
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>地址</td>
			<td>电话</td>
			<td>邮箱</td>
			<td>邮编</td>
			<td>创建日期</td>
		</tr>
			<c:if test="${empty page.pages }">
				<tr>
					<td colspan="7">没有收货者信息</td>
				</tr>
			</c:if>
			<c:if test="${!empty page.pages }">
				<c:forEach items="${page.pages }" var="consignee">
				<fmt:formatDate value="${consignee.createTime }" type="both" var="date"/>
					<tr>
						<td>${consignee.id }</td>
						<td>${consignee.name }</td>
						<td>${consignee.address }</td>
						<td>${consignee.tel }</td>
						<td>${consignee.email }</td>
						<td>${consignee.postcode }</td>
						<td>${date }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="7">
					<c:set value="getPageConsignee" scope="page" var="url"></c:set>
					<%@ include file="/static/ref/basePage.jsp" %>
					</td>
				</tr>
			</c:if>
			
	</table>
</body>
</html>