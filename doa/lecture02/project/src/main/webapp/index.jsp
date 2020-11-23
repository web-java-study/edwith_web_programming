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
	<table border="0" bordercolor="blue" width="500" height="300">
		<th>TODO</th>
		<th>DOING</th>
		<th>DONE</th>	
		<tr	align="center" bgcolor="skyblue">
			<td>Test</td>
			<td>Test</td>
			<td>Test</td>
		</tr>
		<tr>
			<td>Test</td>
			<td>Test</td>
			<td>Test</td>
		</tr>
		<tr>
			<td>Test</td>
			<td>Test</td>
			<td>Test</td>
		</tr>
	</table>
</div>
	
<a href="/TodoFormServlet">TEST</a>

<%-- ContextRoot 경로, TODO 생략하고 보냄 <%=request.getContextPath()%>
 --%>
<!-- <script type="text/javascript">

var tr = document.createElement("tr");
console.log(tr);
var str = document.createTextNode("테스트입니다.");
str.appendChild(str);

$0;
$0.appendChild(tr);
 -->
<div id="setTable"></div>

<script type="text/javascript" src="./js/app.js"></script>	
</body>
</html>
