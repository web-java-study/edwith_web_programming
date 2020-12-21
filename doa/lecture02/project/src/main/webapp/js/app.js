window.addEventListener('DOMContentLoaded', ()=> {
	add_evt();
});

// 1. 버튼에 이벤트, submit이 대신하고 있기 때문에 필요없음
/*function add_evt_radio() {
	var btn = document.getElementById("sub_btn");
	btn.addEventListener('click', function(e) {
		console.log(get_radio());
		if(get_radio()===undefined) {
			alert("버튼을 눌러주세요");
		}
	});
}*/

// 버튼의 값
function get_radio(){
	var data;
	var radio = document.getElementsByName("group1");
	for (var i=0; i<radio.length; i++) {
		if(radio[i].checked) {
			data = radio[i].value;
		}
	}
	return data;	
}

function add_evt() {
	var btn = document.querySelector("#sub_btn");
	btn.addEventListener("click", function(e){
		e.preventDefault();
		if(check()) {
			send_form();
		}
	})
}

function send_form() {
	var xhr = new XMLHttpRequest();
	
	var title = document.getElementById("title");
	var name = document.getElementById("name");
	var get_radio_value = get_radio();
	
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
	
	xhr.open("POST", "/TodoFormServlet");
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send('title=' + encodeURIComponent(title.value)
		+'&name='+encodeURIComponent(name.value)
		+'&sequence='+encodeURIComponent(get_radio_value));
}

function check() {
	var chk = false;
	
	var get_radio_value = get_radio();
	var title = document.getElementById("title");
	var name = document.getElementById("name");
	
	if(title.value.trim().length===0) {
		alert("할 일을 입력해주세요.");
		return chk;
	} 	
	
	if(name.value.trim().length===0) {
		alert("이름을 정확히 입력해주세요.");
		return chk;
	} 
	
	if(get_radio_value === undefined) {
		alert("우선순위를 입력해주세요.");
		return chk;
	}
	
	return chk=true;
}