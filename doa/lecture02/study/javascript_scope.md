## 전역 변수와 지역 변수

- scope에 따라 전역변수와 지역변수로 구분
- 전역변수는 함수 외부에서 선언된 변수로 모든 영역에서 접근 가능
- 지역변수는 함수 내부에서 선언된 변수, 함수가 실행되면 생성되고 함수가 종료되면 소멸하게 됌. → 함수 외부에서 접근이 불가능

```jsx
var gv = "전역변수";

function func() {
	var lv = "지역변수";

	console.log(gv);
	console.log(lv);
}

func();
console.log(gv);
console.log(lv); // 함수가 종료되어 소멸, 즉 함수 외부에서 접근 불가
```

## 함수 내부에서 var를 생략하여 변수를 선언할 경우

var 를 생략하여 선언하는 경우 특정 function 내부에서 선언되었지만, scope가 전역변수처럼 인식

- **모든 전역변수는 window 객체의 프로퍼티**

```jsx
var gv = "전역변수";
console.log("first" + gv);

function func() {
    gv = "지역변수";
    console.log("2 " + gv);
}

func();
/*함수 내부에서 var 생략할 경우, 전역변수의 값을 변경*/
console.log("3 " + gv);
```

## Scope

변수에 접근하는 범위(Scope)

1. 전역 스코프와 지역스코프
2. 함수 바깥에 선언 → 전역 스코프
3. 함수 내부에 선언 → 함수 스코드(지역 스코프)
4. 함수는 서로의 스코프에 접근 불가

 `exam`

```jsx
// 전역스코프
var gv = "전역스코프";

function boostCourse01() {
	console.log(gv);
}

func();

// 지역스코프
function boostCourse02() {
	var lv = "지역스코프";
	console.log(lv);
}

// boostCourse02 소멸
console.log(lv);
```

**함수는 서로의 스코프에 접근이 불가능하다.**

- secondFunc() 함수에서 firstFunc() 함수 호출시.

```jsx
function firstFunc() {
    var boost01 = "firstFunc in javascript";
}

function secondFunc() {
    firstFunc();
    console.log(boost01);
}

secondFunc();
```

## Scope Chain

함수가 다른 함수 내부에서 정의 되었을 경우, 내부 함수는 외부 함수의 변수에 접근할 수 있으나, 외부 함수는 내부 함수의 변수에 접근 불가능

```jsx
function firstFunc() {
	var boost01 = "boostCourse";

	function secondFunc() {
		var boost02 = "boostCourse02";
		console.log(boost01);
	}

	secondFunc();
	console.log(boost02); // 외부함수에서 내부 함수 접근 불가능, 오류 출력
}

firstFunc();
```

## 스코프 체인 검색

스코프 체인은 boostCourse02 안쪽에서부터 위로 올라가므로, **스코프에 대한 검색은 아래에서 위는 가능하나 위에서 아래로는 불가능**

```jsx
var boost01 = 10;

function boostCourse01() {
    var boost02 = 20;

    function boostCourse02() {
        var boost03 = 30;
        console.log(boost01 + boost02 + boost03);
    }

    boostCourse02();
}

boostCourse01();
```
