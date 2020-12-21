// DOMContentLoaded => HTML과 Script가 로드된 시점에 발생하는 이벤트
window.addEventListener('DOMContentLoaded', ()=> {
	
});

/* 
	==================== 버튼 우선순위  ======================
	1. group1 이라는 Name 을 가진 태그를 가져온다. (getElementByName)
	2. radio 에 저장된 값보다 작으면 i의 값을 1가져옴 (radio.length = 3)
	3. checked 의 값(=선택한 버튼)이 true이면 data에 우선순위(value의 값)를 저장함
*/
function get_radio() {
	let data;
	let radio = document.getElementByName("group1");
	for (let i=0; i<radio.length; i++) {
		if(radio[i].checked) {
			data = radio[i].value;				
		}
	}
	return data;
}

/*
	=================== 제출 버튼 이벤트 ======================
	<input id="sub_btn" type="submit" value="전송"/>
	1. sub_btn 이라는 ID 값의 엘리먼트를 가져온다. (getElementById)
	2. btn 에 담아 이벤트를 만든다. (addEventListener)
	3. 이벤트 리스너를 사용해 등록된 click 이벤트가 발생하면 이벤트를 실행한다.
	4. submit 버튼을 눌러도 창이 새로고침되지 않도록 막는다 (preventDefault)
	5. 하단의 click 함수에서 빈 값 없이 모두 입력이 되면 조건식의 값은 참이 되므로
	   send_form 함수를 호출하여 데이터를 전송한다.
	*/
function add_evt() {
	let btn = document.getElementById("sub_btn");
	btn.addEventListener("click", function(e){
		e.preventDefault();
		if(check()) {
			send_form();
		}
	}) 
}

/*
	====================== 데이터 전송 =======================
	1. 서버에 데이터를 요청하기 위해 XMLHttpRequest 객체를 생성한다.
	2. onreadystatechange 이벤트를 작성한다. → Ajax 비동기 통신에 해당된다.
	3. readyState 상태값에 따라 조건식을 수행한다. 
	4. 서버의 응답에 따른 로직에 대해서 작성한다. (200 or 201)
	5. open() 메소드를 이용해 첫 번째 파라미터로 Request Method 방식을 작성 → POST 방식으로 보낸다.
	6. open() 메소드를 이용해 TodoFormServlet 서블릿을 호출한다.
	7. 데이터를 전달하기 전에 encodeURIComponent() 함수로 데이터를 인코딩한다.
	8. 데이터를 인코딩한 후 send() 함수를 이용해 요청한 값을 서버에 전송한다.
*/
function send_from() {
	let xhr = new XMLHttpRequest();
	let title = document.getElementById("title");
	let name = documnet.getElementById("name");
	let get_radio_value = get_radio();
	
	xhr.onreadystatechange=function() {
		if(xhr.readyState===xhr.DONE){
			if(xhr.status===200 || xhr.status===201) {
				alert("서버로부터 응답 받음");
			} else {
				alert("서버로부터 응답을 받지 못함");
			}
		}
	}
	
	xhr.open("POST", "/TodoFormServlet");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send('title=' + encodeURIComponent(name.value)
		+'&name='+encodeURIComponent(name.value)
		+'&sequence='+encodeURIComponent(get_radio_value));
}

/*
	======================= 입력값 검사 ========================
	1. get_radio() 함수의 data 변수의 값을 가져와 get_radio_value) 에 담는다. (라디오 버튼)
	2. title 이라는 ID값을 가진 엘리먼트를 가져온다. (어떤 일인가요 ?)
	3. name 이라는 ID값을 가진 엘리먼트를 가져온다. (누가 할 일인가요?)
	4. 각 엘리먼트에 값이 없으면 조건식의 문장을 수행한다.
	5. 조건식이 거짓이면 모든 문장을 실행하지 않고 chk에 true을 담아 리턴한다.
*/
function check() {
	let chk = false;
	
	let get_radio_value = get_radio();
	let title = document.getElementById("title");
	let name = documnet.getElementById("name");
	
	if(title.value.trim().length===0) {
		alert("할 일을 입력해주세요.");
		return chk;
	}
	
	if(name.value.trim().length===0) {
		alert("이름을 정확히 입력해주세요.");
		return chk;
	}
	
	if(get_radio_value === undefined) {
		alert("버튼을 선택해주세요.");
		return chk;
	}
	
	return chk=true;
}