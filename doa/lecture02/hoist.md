## Hoisting

**모든 변수의 선언은 Hoist 된다. 전역변수는 전역 영역의 최상위로, 지역변수는 함수의 최상위로 호이스트가 변경된다.**

 → 즉, 자바스크립트 함수는 실행되기 전에 함수 안에 필요한 값들을 미리 다 모아 선언한다. 함수 안에 있는 변수들을 모두 끌어올린다고 하여 hoisting 이이라고 함.

```jsx
boostCourse01();
function boostCourse01() {
	console.log("func");
}

boostCourse02();
// console.log(boostCourse02);
var boostCourse02() {
	console.log("func boostCourse");
};
```

## mechanism of hoisting

- 자바스크립트 파서가 함수 실행 전 해당 함수를 한 번 훑는다.
- 함수 안에 존재하는 변수/함수 선언에 대한 정보를 기억하고 있다가 실행

즉, 실제로 코드가 끌어올려지는 것은 아니나 자바스크립트 Parser가 내부적으로 끌어올려 처리하는 과정이다.

## 호이스팅 타겟

let/const 변수 선언과 함수표현식에서는 호이스팅이 일어나지 않는다.

var 변수 선언과 함수 선언문에서만 호이스팅이 일어난다. var 변수/함수의 선언만 위로 끌어올려지며, 변수의 값의 할당은 끌여올려지지 않는다.

아래는 함수선언문과 함수표현식에서의 호이스팅 예제이다.

```jsx
boostCourse01();
boostCourse02();

function boostCourse01() {
	console.log("함수선언문");
}
var boost = boostCourse02() {
	console.log("함수표현식");
}
```
