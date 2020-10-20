var origin = [1,2,3,5];
var chaArray = [...origin, 2,3];

var fun = function(v){
	console.log(v);
}

console.log("?////")
chaArray.forEach(fun);

var mapped= chaArray.map(function(v){
	return v*2;
})

console.log(mapped);

//배열찾기
console.log(chaArray.indexOf(3));

//문자열로 변경
console.log(chaArray.join())

//합치기
console.log(chaArray.concat(2,3));



var newArr = ["apple","tomato"].map(function(value, index) {
	return index + "번째 과일은 " + value + "입니다";
});
console.log(newArr)


const myf = {key : "value", key2:"value"};
console.log(myf);

myf.key3 = "crong";

console.log(myf);

delete myf.key;
console.log(myf);

for(key in myf){
	console.log(myf[key]);
}



console.log(Object.keys(myf));


Object.keys(myf).forEach(function(v){
	console.log(myf[v]);	
});


