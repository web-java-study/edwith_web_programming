// 함수의 호출.
function printName(firstname) {
    var myname = "Junhyeok";
    return myname + " ," +  firstname;
}

function run(firstname) {
   firstname = firstname || "False"; // 왼쪽이 True면 사용, False면 "Youn"이 사용됨.
   var result = printName(firstname);
   console.log(result);
}

run('Yang'); //시작 > 7 8 9(printName) (2 3 4 5) 9(result) 10 11 
run();

function foo(b){
    var a = 5;
    return a * b + 10;
} 

function bar(x){
    var y = 3;
    return foo(x * y);
}

console.log(bar(6));

// function printName(firstname){

//     var inner = function(){
//         return 'inner';
//     }

//     var result = inner();
//     console.log("Name is " + result);
 
// }

// printName();

// function printName2(firstname){

//     var result = inner();
//     console.log(typeof inner);
//     console.log("Name is " + result);

//     function inner() {
//         return 'inner';
//     }

// }

// printName2();


// function a(){

// }

// console.log(a())

// const o = {}
// o.f = function(){
//     console.log("o test")
// }
// o.f()

// const arr = [1, 2, 3]
// arr[1] = function(){
//     console.log("arr test")
// }
// arr[1]()