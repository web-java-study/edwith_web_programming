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
		<button id="btnAdd">새로운 TODO 등록</button>
	</nav>
</header>

<div class="todolistbox">
	<table border="0">
		<th>TODO</th>
		<th>DOING</th>
		<th>DONE</th>
	</table>
</div>
	
<a href="/TodoFormServlet">TEST</a>
DOING
DONE
<%-- ContextRoot 경로, TODO 생략하고 보냄 <%=request.getContextPath()%>
 --%>
</body>
</html>
