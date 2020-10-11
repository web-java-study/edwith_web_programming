<%@ page language="java" contentType=" text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge  chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="./css/index.css">
	<title>할일등록</title>
</head>
<body>
	<header>
		<div id="register">
			할일등록
		</div>
	</header>
	<section>
		<div id = "form">
			<form id="register_form" 
			onsubmit=" return false;">
				<div>
					<label for="">"어떤일인가요?</label>	
					<input name="title" id="title" type="text" size="30"/>
				</div>
				<div>
					<label for=""> "누가하나요?</label>
					<input name="name" id ="name" type="text" size="30"/>
				</div>
				<div>
					<label>우선순위를 선택하세요</label>
					<div>
						<input type="radio" name = "seq" value="1">
						<label for="1"> 1순위 </label>
							
						<input type="radio" name = "seq" value="2">
						<label for="2"> 2순위 </label>

						<input type="radio" name = "seq" value="3">
						<label for="3"> 3순위 </label>
					</div>		
				</div>

				<div>
					<div id="pre">
						<button id="pre_btn" onclick="location.href='/main'"> 이전 </button>
					</div>

					<div>
						<input type="submit" onclick= "send_form();" value="제출" />
						<input type="reset" value = "내용지우기" />
					</div>
				</div>

				
			</form>
		</div>
	</section>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index_func.js"></script>
	
</body>
</html>