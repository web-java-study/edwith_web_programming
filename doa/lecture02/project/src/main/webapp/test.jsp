<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" href="#">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
     --%>
     <title>API Controller</title>
</head>
<body>
    <header>

    </header>
    <section>
		<h1>GET</h1>
		<h1>
			<button onclick="api_get()">JS파일로 구현하는 방식, Ajax 통신</button>
			<!-- function api_get() {} → JS파일에서 호출, 함수를 호출하는 것
				자바스크립트로 사용하는 Get 방식은.. 페이지 전환이 아니라 일부분만 전환하고 싶을 때 주로 사용된다.  -->
			<button onclick="Location.href='/api/get'">HTML로 구현하는 방식, 주로 페이지 이동</button>
			<a href="/api/get">HTML구현 a 태그, 주로 페이지 이동</a>
		</h1>
		<h1>POST FORM</h1>
		<!-- 
		form method default = > GET
		form > input["name=xxx"] = queryString -> path?xxx=xxx
		 -->
		<form action="/api/post" method="post">
		<div>
			<label for="id">아이디</label>
			<input name="id" type="text" id="id"/>
		</div>
			<!-- for 하고 input의 id 하고 같은 값이어야 함 -->
			<label for="password">비밀번호</label>
			<input name="password" type="password" id="password"/>
		<div>
			<label for="address">주소</label>
			<input name="address" type="text" id="address"/>
		</div>
		<div>
			<label for="email">이메일</label>
			<input name="email" type="text" id="email"/>
		</div>
		<div>
			<input type="submit" value="전송"/>
		</div>
		</form>
		<p></p>
		
		<!-- 데이터를 보내기 전에 일단 먼저 자바스크립트로 호출 -->
		<div>
		<h1>FORM AJAX</h1>
		</div>
		<form id="send_form">
		<div>
			<label for="id2">아이디</label>
			<input name="id" type="text" id="id2"/>
		</div>
		<div>
			<!-- for 하고 input의 id 하고 같은 값이어야 함 -->
			<label for="password2">비밀번호</label>
			<input name="password" type="password" id="pw2"/>
		</div>
		<div>
			<input id="sub_btn" type="submit" value="전송"/>
		</div>
		
		<h1>RADIO BUTTON</h1>
		<div>
			<input type="radio" id="one" name="seq" value="1">
			<label for="huey">1순위</label>
		
			<input type="radio" id="two" name="seq" value="2">
			<label for="huey">2순위</label>
			
			<input type="radio" id="three" name="seq" value="3">
			<label for="huey">3순위</label>
		</div>
		<div>
		<!-- button 으로 보내야 함, console.log 는 value 값.... -->
			<input id="get_btn" type="button" value="전송"/>
		</div>
		</form>
    </section>
    <script src="/js/api.js"></script>
</body>
</html>