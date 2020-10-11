window.onload = function(){
//	alert("load");
//	checkBroswer();
	move_btn_add_event();
}	

function checkBroswer(){
    var agent = navigator.userAgent.toLowerCase(),
        name = navigator.appNamtooe,
        browser = '';
 
    // MS 계열 브라우저를 구분
    if(name === 'Microsoft Internet Explorer' || agent.indexOf('trident') > -1 || agent.indexOf('edge/') > -1) {
        browser = 'ie';
        if(name === 'Microsoft Internet Explorer') { // IE old version (IE 10 or Lower)
            agent = /msie ([0-9]{1,}[\.0-9]{0,})/.exec(agent);
            browser += parseInt(agent[1]);
        } else { // IE 11+
            if(agent.indexOf('trident') > -1) { // IE 11
                browser += 11;
            } else if(agent.indexOf('edge/') > -1) { // Edge
                browser = 'edge';
            }
        }
    } else if(agent.indexOf('safari') > -1) { // Chrome or Safari
        if(agent.indexOf('opr') > -1) { // Opera
            browser = 'opera';
        } else if(agent.indexOf('chrome') > -1) { // Chrome
            browser = 'chrome';
        } else { // Safari
            browser = 'safari';
        }
    } else if(agent.indexOf('firefox') > -1) { // Firefox
        browser = 'firefox';
    }

    alert(browser);
}



function move_btn_add_event(){

	var btn = document.getElementsByClassName("move_btn");
	
	for(var i=0;i<btn.length;i++){
		btn[i].addEventListener("click", function(e){
			console.log("작동");
			update_type(e.target);
		});
	}
//	for(var i=0;i<btn.length;i++){
//		if(btn[i].addEventListener){
//			btn[i].addEventListener("onclick", (e)=>{
//				alert("작동");
//				column_search(e.target, 5);
//			});
//		}else if(btn[i].attachEvent){
//			btn[i].attachEvent("onclick", (e)=>{
//				alert("작동");
//				column_search(e.target, 5);
//			});
//		}
//	}
}

function search_move(target, parent_count){
	var current_target = target;
	var card;
	for(var i=0;i<parent_count;i++){
		
		if(i==4){
			card = current_target;
		}
		current_target=current_target.parentNode;
	}

	if(current_target.getAttribute("class") !="column"){
		return alert("경로설정을 다시");
	}

	if(current_target.getAttribute("id")=="todo"){
		move_card("doing", card);

	}else if(current_target.getAttribute("id")=="doing"){
		move_card("done", card);
		target.setAttribute("type", "hidden");
	}	
}

function move_card(id, card){
	var column_id = document.getElementById(id);
	if(column_id == undefined){
		return alert("move_card(id--> 문제)");
	}

	column_id.appendChild(card);
}


function send_form(){
	var title = document.getElementById("title");
	var name = document.getElementById("name");
	var seq = document.getElementsByName("seq");
	var seq_value = seq_value(seq);
	
	function seq_value(seq){
		for(var i=0;i<seq.length;i++){
			if(seq[i].checked){
				return seq[i].value;
			}
		}
	}
	
	if(!(check_input(title) && check_input(name) && radio_check_input(seq))){
		return;
	}
	
	var xhr = new XMLHttpRequest();
		
	if(xhr.readyState ==xhr.DONE){
		alert("서버전송완료");
	}else{
		alert(xhr.responseText);
	}

	xhr.onreadystatechange  = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				location.href="/main";
			}else{
				alert("실패");
			}
		}
	}
	
	xhr.open("POST", "/add",true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("title="+title.value+"&name="+name.value+"&seq="+seq_value);

	return false;
}

function check_input(att){
	var check = false;
	
	if(att.getAttribute("type")=="text"){
		if(att.value.trim()==""){
			att.setAttribute("placeholder", "입력해주세요");
		}else{
			check=true;
		}
	}
	return check;
}

function radio_check_input(radio_btn){
	var check = false;
	
	for(var i=0;i<radio_btn.length;i++){
		if(radio_btn[i].checked){
			check=true;
			return check;
		}
	}
	
	if(check==false){
		radio_btn[0].parentNode.style.border= "1px solid red";
	}
	
	return check;
}

function recover_radio_btn(radio){
	var radio_btn = document.getElementsByName(radio);
	
	for(var i=0;i<radio_btn.length;i++){
		radio_btn[i].addEventListener(function (e){
			radio_btn[0].parentNode.style.border = "";
		});
	}
}

function update_type(event){
	var id = event.getAttribute("id");
	
	if(id=="" || id === undefined || id===null){
		return;
	}
	
	var xhr = new XMLHttpRequest();
	
	if(xhr.readyState ==xhr.DONE){
		console.log("DONE");
	}else{
		console.log("not done");
	}

	xhr.onreadystatechange  = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				alert("success");
				search_move(event, 5);
			}else{
				alert("실패");
			}
		}
	}
	
	xhr.open("POST", "/update",true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("id="+id);

	return false;
	
	
}