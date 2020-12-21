<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
			<title>투두리스트</title>
		<link rel="stylesheet" type="text/css" href="./css/global.css">
		<link rel="shortcut icon" href="#">
	</head>
	<body>
		<header>
			<h1>나의 해야할 일들</h1>
			<nav class="topMenu">
		 		<button id="btnAdd" type="submit" onclick="location.href='/TodoFormServlet' ">새로운 TODO 등록</button>
			</nav>
		</header>
		<div id="container">
			<div id="todo">
				<div class="list">TODO</div>
					<c:forEach var="list" items="${dataList}">
						<c:if test="${list.type eq 'TODO'}">
							<div class="list">
								<!-- begin end 
								========= Scope =========
								 ApplicationScope 전체 범위, 큰 단위임
								 SessionScope default root
								 RequestScope request (forward)
								 PageScope page 내에서만
								-->
								<p>
									${list.title}
								</p>
								<p>
									<span>등록날짜 ${list.regDate}</span>
									<span>${list.name}</span>
									<span>우선순위 ${list.sequence}</span>
									<input type="button" data-todo-id="${list.id}" data-todo-type="${list.type}" value="→" onclick="change_type(this)" />
								</p>
							</div>
						</c:if>
					</c:forEach>
				</div>
			
			<div id="doing">
				<div class="list">DOING</div>
					<c:forEach var="list" items="${dataList}">
						<c:if test="${list.type eq 'DOING'}">
							<div class="list">
								<p>
									${list.title}
								</p>
								<p>
									<span>등록날짜 ${list.regDate}</span>
									<span>${list.name}</span>
									<span>우선순위 ${list.sequence}</span>
									<input type="button" data-todo-id="${list.id}" data-todo-type="${list.type}" value="→" onclick="change_type(this)" /></p>
							</div>
						</c:if>
					</c:forEach>
				</div>
			
			<div id="done">
				<div class="list">DONE</div>
					<c:forEach var="list" items="${dataList}">
						<c:if test="${list.type eq 'DONE'}">
							<div class="list">
								<p>
									자바스크립트 공부하기
								</p>
								<p>
									<span>등록날짜 2018.08.13</span>
									<span>홍길동</span>
									<span>우선순위</span>
								</p>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>	
		</body>
	<script type="text/javascript" src="./js/main.js"></script>	
</html>