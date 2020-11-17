<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
     <% pageContext.setAttribute("contentsList", new String[]{"TODO", "DOING", "DONE"}); %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="./css/main.css"></link>
</head>
<body>
    <div id="wrap">
		<div class="header">
			<button class="move_write_btn">새로운 TODO 등록</button>
		</div>
		<div class="contents_area">
			<c:forEach var="contentTitle" items="${contentsList}">
				<div>
					<div class="list_title">${contentTitle}</div>
					<ul class="${contentTitle}"></ul>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<script type="text/javascript" src="./js/app.js"></script>
</body>
</html>