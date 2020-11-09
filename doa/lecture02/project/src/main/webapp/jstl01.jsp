<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	request.setAttribute("n", 10);
--%>
<c:set var="n" scope="request" value="10"/>
<c:set var="score" scope="request" value="90"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>el 표기법과 jstl </title>
<body>

성 : ${value1 } <br>
<c:remove var="value1" scope="request"/>
성 : ${value1 } <br>

<!-- 흐름제어 태그 if문 -->
<c:if test="${n == 0}">
n과 0은 같습니다.<br>
</c:if>
<c:if test="${n == 10}">
n과 10은 같습니다.<br>
</c:if>

<!-- if else 문과 비슷하다고 보면 됌. -->
<c:choose>
	<c:when test="${n == 1}">
		n의 값은 1 입니다.<br>
	</c:when>
	<c:when test="${n == 10}">
		n의 값은 10 입니다. <br>
	</c:when>
	<c:otherwise>
		일치하는 조건이 없습니다.
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${score >= 90}">
		A학점입니다.
	</c:when>
	<c:when test="${score >= 80}">
		B학점입니다.
	</c:when>
	<c:when test="${score >= 70}">
		C학점입니다.
	</c:when>
	<c:when test="${score >= 60}">
		D학점입니다.
	</c:when>
	<c:otherwise>
		F학점입니다.
	</c:otherwise>
</c:choose>

</body>
</head>
</html>