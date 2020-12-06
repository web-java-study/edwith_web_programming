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
		<h1>TEST</h1>
			<button onclick="api_get()">JS파일로 구현하는 방식, Ajax 통신</button>
			<a href="/api/test">HTML구현 a 태그, 주로 페이지 이동</a>
    </section>
    <script src="/js/api.js"></script>
</body>
</html>