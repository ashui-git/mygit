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
function namedate(){
	var name=$('#name').val();	
	if(name==""||name==null){
		$('#namediv').html('游戏名字不能为空！');
	}else{
		//alert("年份");	
		xmlHttpRequest=createXMLHttpRequest();	
		xmlHttpRequest.onreadystatechange=callback;
		var url="GamesServlet?name="+name;
		xmlHttpRequest.open("get",url,true);
		xmlHttpRequest.send(null);
		
		function callback(){
			if(xmlHttpRequest.readyState==4){
				if(xmlHttpRequest.status==200){
					//正确响应！
					var date=xmlHttpRequest.responseText;
					if(date=="true"){
						$('#namediv').html('游戏名字可用！');
					}else{
						$('#namediv').html('游戏名字已存在！');
					}					
				}else if(xmlHttpRequest.status==404){
					$('#namediv').html('页面不存在！');
				}else if(xmlHttpRequest.status==500){
					$('#namediv').html('服务器端错误！');
				}else{
					$('#namediv').html('其他错误！');
				}		
			}else{
				$('#namediv').html('查询中！');
			}
		}
	}
	
}
function createXMLHttpRequest(){
	if(window.XMLHttpRequest){
		return new XMLHttpRequest();
	}else{
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
	
}
$(function(){
	$('#gyear').blur(function (){
		//alert("年份");
		var year=$('#gyear').val();
		if(year>2010||year<1900){
			$('#yeardiv').html("年份输入错误");
		}else{
			$('#yeardiv').html("年份验证成功");
		}
	})
})
</script>
</head>
<body>
<div id="fdiv">
<h3><span></span>游戏新增</h3>
<form action="GamesServlet?opr=add" method="post">
<!-- <input  type="hidden" name="opr" value="add"/> -->
	<table>
		<tr>
			<td>游戏名称</td>
			<td><input  type="text" name="name" id="name" onblur="namedate()"/></td>
			<td><div id="namediv" style="display:inline"></div></td>
		</tr>
		<tr>
			<td>游戏类别：</td>
			<td><input  type="text" name="gtype" id=""/></td>
		</tr>
		<tr>
			<td>发行公司：</td>
			<td><input  type="text" name="gcom" id=""/></td>
		</tr>
		<tr>
			<td>发行年份：</td>
			<td><input  type="text" name="gyear" id="gyear" /></td>
			<td><div id="yeardiv" style="display:inline"></div></td>
		</tr>
		<tr>
		<td><span></span></td>
			<td><input  type="submit" name="" id="" value="添加"/></td>
			<td><input  type="button" name="" id="" value="返回"/></td>
		</tr>
	</table>
</form>
魔兽争霸
</div>
</body>
</html>