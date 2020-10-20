var count = 50;
var el = document.querySelector(".outside1");
el.style.left="0";

function run(){
	if(count>1000){
		return;
	}

	count = count+10;
	el.style.left=count+"px";
	requestAnimationFrame(run);
}

requestAnimationFrame(run);




//transition 
var el2 = document.querySelector(".outside2");
el2.style.transform="scale(2)";
el2.style.left="500px";


el2.style.transform="scale(4)";

var btn = document.querySelector("button");

btn.addEventListener("click", function(){
	var pre = parseInt(el2.style.left);
	el2.style.left=pre+10+"px";
});


document.addEventListener("DOMContentLoaded", function(){
	console.log("window loaded");
});

document.addEventListener("DOMContentLoaded", function(){
	console.log("dom loaded");
});
