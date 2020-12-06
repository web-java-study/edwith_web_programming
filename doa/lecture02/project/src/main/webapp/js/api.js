function api_get() {
	
	var test = document.querySelector("h1");
	// xhr 객체를 생성
	var xhr = new XMLHttpRequest();
	// 통신상태가 완료되었을 때 성공이라는 메세지를 띄운다.
	xhr.onreadystatechange=function() {
		// 통신이 완료되면
		if(xhr.readyState===xhr.DONE){
			if(xhr.status===200 || xhr.status===201) {
				// Change
				alert("성공");
				test.append(xhr.responseText);
			} else {
				// Change
				alert("err");
			}
		}
	}
	
	// Change, get or post
	xhr.open("POST", "/api/test");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	// Change, 특수문자 제외 인코딩 encodeURIComponent
	xhr.send('check=' + encodeURIComponent(0));
	
	// 1. 비동기 통신
	// 2. 응답메세지 제시 (status code)
	// 3. 페이지는 그대로, 데이터 호출
}