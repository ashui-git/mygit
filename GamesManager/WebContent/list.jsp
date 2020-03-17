<%@page import="com.cssl.entity.Games"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="css/list.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">

</script>
</head>
<body>

<table id="mytable">
	<tr id="h3tr" >
	<th><h2>游戏列表</h2></th>
	<th></th>
	<th></th>
	<th><a href="index.jsp">返回主界面</a></th>
	</tr>
	<tr id="titledr">
		<th>游戏名称</th>
		<th>游戏类型</th>
		<th>发行公司</th>
		<th>发行年份</th>
	</tr>
	<c:forEach var="g" items="${list }">
		<tr>
			<td><c:out value="${g.gameName }"/></td>
			<td><c:out value="${g.gameType }"/></td>
			<td><c:out value="${g.gameCompany }"/></td>
			<td><c:out value="${g.gameYear }"/></td>
		</tr>
	</c:forEach>			
</table>
</body>
</html>