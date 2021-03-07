window.addEventListener('DOMContentLoaded', ()=> {
	add_evt();
	init();
	add_evt_radio();
});

/*
1. btn을 id값으로 가져오기(getElementByID)
2. btn 에 Event 부여하기 (addEventListener)
*/

/*
// 버튼에 이벤트
function add_evt_radio() {
	var btn = document.getElementById("get_btn");
	btn.addEventListener('click', function(e) {
		// call back 함수
		console.log(get_radio());
		if(get_radio()===undefined) {
			alert("버튼을 눌러주세요");
		}
	});
}
*/
/*function get_radio() {
	var data;	// undefined → 값이 들어가지 않으면 해당 값이 리턴 됌.
	var radio = document.getElementsByName("seq");
	for(var i=0; i<radio.length; i++) {
		if(radio[i].checked) {
			data = radio[i].value;		
		}
	}
	return data;
}*/

/*
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
*/
/*// 서버쪽에 데이터를 바로 보내지 않음.
// preventDefault 서버에 데이터를 일단 전송하지 말라는 것
// 아이디나 데이터를 검증도 안하고 X
function add_evt() {
	var btn = document.getElementById("sub_btn");
	btn.addEventListener("click", function(e){
		e.preventDefault();
		if(check()) {
			send_form();	
		}
	})
}
*/
// FORM to AJAX 
// method = POST
// path = /api/post
// func = send_ajax
/*function send_form() {
	var xhr = new XMLHttpRequest();
	
	var id = document.getElementById("id2");
	var pw = document.getElementById("pw2");
	
	xhr.onreadystatechange=function() {
		// 통신이 완료되면
		if(xhr.readyState===xhr.DONE){
			if(xhr.status===200 || xhr.status===201) {
				alert("성공");
			} else {
				alert("err");
			}
		}
	}
	
	// Change, get or post
	xhr.open("POST", "/api/post");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	// Change, 특수문자 제외 인코딩 encodeURIComponent
	xhr.send('id=' + encodeURIComponent(id.value)+'&pw='+encodeURIComponent(pw.value));
}*/

function init(){
	var input_tag = document.getElementsByTagName("input");
	
	for(var i=0; i<input_tag.length; i++) {
		input_tag[i].addEventListener('change', function(e) {
			var temp = e.currentTarget.style
			e.currentTarget.style = temp;
		})
	}
}

/* 
Check Function
1. NullSpace Check
2. 
*/

function check(){
	var chk = false;
	var id = document.getElementById("id2");
	var pw = document.getElementById("pw2");
	
	// value, 공백 제거하고 제거한 다음 길이가 0이면 다시 입력하라는 문구 띄움
	// 특수문자 정규식 강의
	// return → 다음 구문인 if 문 검사를 또 하지 않도록 return 
	if(id.value.trim().length===0 || id.value.includes(" ")) {
		alert("아이디를 다시 입력해주세요.");
		console.log(id.style);
		id.style.border = "1px solid red";
		return;
	} 
	
	if(pw.value.trim().length===0 || pw.value.includes(" ")) {
		alert("비밀번호를 다시 입력해주세요.");
		pw.style.border = "1px solid red";
		return chk;
	}
	
	// true 라면 send_form () 실행	
	return chk=true;
}
