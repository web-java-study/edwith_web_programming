window.addEventListener('DOMContentLoaded', ()=> {
	add_evt();
	send_form();
});

/*
1. document.querySelector(#) → ID값으로
*/ 

function get_radio(){
	let data;
	let radio = document.getElementsByName("group1");
	for (let i=0; i<radio.length; i++) {
		if(radio[i].checked) {
			data = radio[i].value;
			console.log(radio[i].value);
		}
	}
	return data;	
}

function add_evt() {
	let btn = document.getElementById("sub_btn");
	btn.addEventListener("click", function(e){
		e.preventDefault();
		if(check()) {
			send_form();
		}
	})
}

function send_form() {
	let xhr = new XMLHttpRequest();
	
	let title = document.getElementById("title");
	let name = document.getElementById("name");
	let get_radio_value = get_radio();
	
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
	let chk = false;
	
	let get_radio_value = get_radio();
	let title = document.getElementById("title");
	let name = document.getElementById("name");
	
	if(title.value.trim().length===0) {
		alert("할 일을 입력해주세요.");
		return chk;
	} 	
	
	if(name.value.trim().length===0) {
		alert("이름을 정확히 입력해주세요.");
		return chk;
	} 
	
	if(get_radio_value === undefined) {
		alert("입력해주세요!!!!!!!!!!!");
		return chk;
	}
	
	return chk=true;
}