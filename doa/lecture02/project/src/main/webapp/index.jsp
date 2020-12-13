<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
			<title>투두리스트</title>
		<!--<link rel="stylesheet" type="text/css" href="./css/global.css">
		 -->
	</head>

<body>
<header>
	<h1>나의 해야할 일들</h1>
	<nav class="topMenu">
 	<button id="btnAdd" type="submit" onclick="location.href='/TodoFormServlet' ">새로운 TODO 등록</button>
	</nav>
</header>
 
 <div>
	<table>
		<th>
			<div>TODO</div>
		</th>
		<th>
			<div>DOING</div>
		</th>
		<th>
			<div>DONE</div>
		</th>	
		<c:forEach var="types" items="${list}">
		<tr bgcolor="skyblue">
			<td>${types.title} <br/> 
				등록날짜 ${types.regdate}
				${types.name},
				우선순위 ${types.sequence}</td>
			<td></td>
			<td></td>
		</tr>
		</c:forEach>
	</table>
</div>

<script type="text/javascript" src="./js/main.js"></script>	

</body>
</html>
