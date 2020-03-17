<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/games.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
function addgames(){
	location.href='add_games.jsp';
}
</script>
</head>
<body>
<div id="fdiv">
<h3><span></span>游戏查询</h3>
<form action="GamesServlet?opr=select" method="post">
	<table>
		<tr>
			<td>游戏名称：</td>
			<td><input  type="text" name="name" id="name"/></td>
		</tr>
		<tr>
			<td>游戏类别：</td>
			<td><input  type="text" name="type" id="type"/></td>
		</tr>
		<tr>
			<td>发行公司：</td>
			<td><input  type="text" name="com" id="com"/></td>
		</tr>
		<tr>
			<td>发行年份：</td>
			<td><input  type="text" name="year" id="year"/></td>
			<td><div>四位数字</div></td>
		</tr>
		<tr>
			<td></td>
			<td><input  type="submit"  value="查询"/>
			<input  type="button" value="新增" onclick="addgames()"/></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
