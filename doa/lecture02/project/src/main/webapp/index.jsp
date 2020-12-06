<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
			<title>투두리스트</title>
		<link rel="stylesheet" type="text/css" href="./css/global.css">
	</head>

<body>
<header>
	<h1>나의 해야할 일들</h1>
	<nav class="topMenu">
 	<button id="btnAdd" type="submit" onclick="location.href='/Todo/TodoFormServlet' ">새로운 TODO 등록</button>
	</nav>
</header>
<%-- <%=
	request.getAttribute("list")
%>
 --%>
 <%-- 
<c:forEach var="type" items="${list}">id=${type.title} name=${type.name} sequence=${type.sequence} regdate=${type.regdate}</br></c:forEach>
 --%>
 
 	<div class="todolistbox">
	<table border="0" bordercolor="blue" width="500" height="300">
		<th>TODO</th>
		<th>DOING</th>
		<th>DONE</th>	
		<c:forEach var="types" items="${list}">
		<tr	align="center" bgcolor="skyblue">
			<td>${types.id}</td>
			<td>${types.name}</td>
			<td>${types.sequence}</td>
		</tr>
		</c:forEach>
	</table>
</div>

<script type="text/javascript" src="./js/app.js"></script>	
</body>
</html>
