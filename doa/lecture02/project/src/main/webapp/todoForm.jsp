<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>할 일 등록</title>
</head>
<link rel="shortcut icon" href="#">
 
<body>
	<form id="work">
		<div>
			<h1>할 일 등록</h1>
		</div>
		<div>
			<label for="title">어떤 일인가요?</label><br/>
			<input name="title" type="text" id="title"/>
		</div>
		<div>
			<label for="name">누가 할일인가요?</label><br/>
			<input name="name" type="text" id="name"/>
		</div>
		<div>
		<!-- 대량으로 데이터를 묶어서 서버에 보낼 때는 form 으로 묶어서 보내야한다. 
		input == label 1:1, name 으로 그룹핑하는 것 -->
			<p>우선순위를 선택하세요.</p>
			<input name="group1" type="radio" value="1" id="sequence1">
			<label for="sequence1">1순위</label>
			<input name="group1" type="radio" value="2" id="sequence2">
			<label for="sequence2">2순위</label>
			<input name="group1" type="radio" value="3" id="sequence3">
			<label for="sequence3">3순위</label>
		</div>
		<div>
			<input id="sub_btn" type="submit" value="전송"/>
		</div>
	</form>
	<button type="button" onclick="location.href='/'">&lt; 이전</button>
	<script src="/js/todoForm.js"></script>
</body>
</html>