<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css?ver=1">
	<title>ToDoProject</title>
</head>
<body>
	<header>
		<div class="index_top">
			<div>나의 해야할 일들</div>
			<div>
				<input type="button" value="새로운 TODO 등록" onclick="location.href='/add'" / >
			</div>
		</div>
	</header>
	<section>
		<div class="todo_table">
			<div class="column" id="todo">
				<div class="todo" >
					TO DO
				</div>
				<c:forEach var ="list" items = "${requestScope.list}">
					<c:if test="${list.type eq 'TODO' }">
						<div class="content">
							<div class="list">
								<p class="list_title">${list.title}</p>
								<p>
									<span>등록날짜 :${list.reg_date} ${list.name} 우선순위 ${list.seq}</span>
									<span>
										
										<input class ="move_btn" id="${list.id}" type="button" value="→"/>
									</span>	
	
								</p>						
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<div class="column" id="doing">
				<div class="doing">
					DOING
				</div>
				<c:forEach var ="list" items = "${requestScope.list}">
					<c:if test="${list.type eq 'DOING' }">
						<div class="content">
							<div class="list">
								<p class="list_title">${list.title}</p>
								<p>
									<span>등록날짜 :${list.reg_date} ${list.name} 우선순위 ${list.seq}</span>
									<span>
										<input class ="move_btn" id="${list.id}" type="button" value="→"/>
									</span>	
	
								</p>						
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<div class="column" id="done">
				<div class="done">
					DONE
				</div>

				<c:forEach var ="list" items = "${requestScope.list}">
					<c:if test="${list.type eq 'DONE' }">
						<div class="content">
							<div class="list">
								<p class="list_title">${list.title}</p>
								<p>
									<span>등록날짜 :${list.reg_date} ${list.name} 우선순위 ${list.seq}</span>
									<span>
										<input class ="move_btn" id="${list.id}" type="hidden" value="→"/>
									</span>	
	
								</p>						
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index_func.js"></script>

</body>
</html>