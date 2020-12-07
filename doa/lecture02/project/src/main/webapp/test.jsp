<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
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
    </section>
    <script src="/js/api.js"></script>
</body>
</html>