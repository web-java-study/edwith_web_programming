//event bubbling
//클릭한 지점이 하위 엘리먼트라 하여도, 그것을 감싸고 있는 상위 엘레멘트의 이벤트 리스너를 찾아서 찾는 과정이다.

//event capturing 
//버블링과 반대의 개념
//이벤트리스너 3번째 인자에 true 를 적용하면 댐

//HTML Templating
//정적인 HTML이 서버에서 받은 데이터로 화면에 변경을 주는것


var data = {
	title : "hello",
	content : " lorem",
	price : 2000
	}


var data2 = [
	
	{
	title : "hello",
	content : " lorem",
	price : 2000
	}
	,
	{
		title : "hello",
		content : " lorem",
		price : 2000
	}
]


//var btn = document.getElementsByTagName("button");
//console.log(btn);

function change(){
	var html = "<li><h4>{title}</h4></li><li><h4>{content}</h4></li><li><h4>{price}</h4></li>";

	var text = html.replace("{title}", data.title)
	.replace("{content}", data.content)
	.replace("{price}", data.price);
	console.log("C");

	console.log(text);
}

change();