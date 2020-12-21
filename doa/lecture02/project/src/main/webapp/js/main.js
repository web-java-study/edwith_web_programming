/*
	1. container 라는 ID값을 가진 엘리먼트를 가져온다. (getElementByID)
	2. 버튼을 클릭하면 이벤트를 실행하기 위한 이벤트를 생성한다. (addEventListener)
	3. 버튼을 클릭할 때 창이 새로고침 되지 않도록 한다. (preventDefault)
	4. (todo) 첫 번째 자식 노드의 버튼을 클릭하면 두번째 자식 노드로 이동한다. (Node.insertBefore)
	5. (doing) 두 번째 자식 노드로 옮기고 첫 번째 자식 노드의 데이터를 삭제한다. (removeChild)
	6. (doing) 두 번째 노드의 버튼을 클릭하면 세 번째 자식 노드로 이동한다. (Node.insertBefore)
	7. (done) 세 번째 자식 노드로 옮기고 두 번째 자식 노드의 데이터를 삭제한다.
*/ 
 
/*
function change_type(target) {
	console.log("=====click=====");
	console.log(target);
	
	console.log("=====click elemnt=====");
	console.log(target.parentNode);
	
	console.log("=====click elemnt=====");
	console.log(target.parentNode.parentNode);
	
	console.log("=====click elemnt=====");
	console.log(target.parentNode.parentNode.parentNode);
	
	console.log("=====TYPE GET=====, 첫번째 방법");
	console.log(target.parentNode.parentNode.parentNode.firstElementChild.innerText);

	console.log("=====TYPE GET=====, 두번째 방법, ID값 가져오기");
	console.log(target.parentNode.parentNode.parentNode.getAttribute("id").toUpperCase());

	console.log(target.dataset.todoId);
}
*/

/*
	============ 문자열 유효성 체크 ==============
	1. dataset 으로 id, type 에 대한 값을 가져온다.
	2. id, type 값의 유효성 체크(검증)
	3. 유효성 체크가 false 라면 오류메세지, 아니라면 ajax
	4. true 일 경우 Ajax는 POST 방식 servlet 전송
*/

function change_type(target) {
	
	var id = target.dataset.todoId;
	var type = target.dataset.todoType;
	
	if(check(id, type)) {
		send_ajax();
	}
}

/* 
	1. xhr.responseText, 서블릿에서 보낸 텍스트를 창에 띄움
 */

function send_ajax(id, type) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		if(xhr.readyState===xhr.DONE){
			if(xhr.status===200 || xhr.status===201) {
				alert(xhr.responseText);
			}
		}
		
	}
	
	xhr.open('POST', '/todocheck');
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send('id='+encodeURIComponent(id)
		+'&type='+encodeURIComponent(type));
	}

function check(id, type) {
	
	var check = false;
	
	if (isNaN(id)) {
		alert("관리자 문의 (id)");
		return check;
	}
	
	if (type!=="TODO" && type!=="DOING" && type!=="DONE") {
		alert("관리자 문의 type");
		return check;
	}
	
	return true;
}




/*function change_type(target) {
	
	console.log(target.dataset.todoId);
	console.log(target.nextSiblingElement);
}
*/