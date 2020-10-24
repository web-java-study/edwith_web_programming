<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div id="write_wrap">
		<h1>할일 등록</h1>
		<form method="POST" action="/todo/todos">
			<div>
				<p>어떤 일인가요?</p>
				<input 
					placeholder="swift 공부하기 (24자까지)"
					type="text"
					name="title"
				/>
			</div>
			<div>
				<p>누가 할일인가요?</p>
				<input 
					placeholder="홍길"
					type="text"
					name="name"
				/>
			</div>
			<div>
				<p>우선순위를 선택하세요</p>
				<div class="radio_area">
					<div class="radio_group">
						<input name="sequence" value=1 type="radio" id="first" />
						<label for="first">1순위</label>
					</div>
					<div class="radio_group">
						<input name="sequence" value=2 type="radio" id="second" />
						<label for="second">2순위</label>
					</div>
					<div class="radio_group">
						<input name="sequence" value=3 type="radio" id="third" />
						<label for="third">3순위</label>
					</div>
				</div>
			</div>
			<div class="button_area">
				<button type="button" class="prev_page">< 이전</button>
				<div>
					<button type="submit">제출</button>
					<button type="reset">내용지우기</button>
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>