## JavaScript 적용

외부 파일 연결

```jsx
console.log("Hello World");

/*html 문서에 <script src="파일명.js"></script>로 삽입한다.*/
<script src="main.js"></script>

/*<script>와 외부 연결 파일 방식을 동시에 사용할 수 없다.
잘못된 외부 파일 연결의 예시*/
<script src="main.js">
		console.log("Hello world"); 
</script>
```

html 문서 <script> 안에 삽입

```jsx
<body>
	<script>
		console.log("Hello world");
	</script>
</body>
```

구글 크롬 console

```jsx
/*console tab*/
console.log("Hello world");
```

## Variables

```jsx
/*변수 선언, 할당 전이므로 값은 undefined*/
var boostCourse01;

/*선언한 변수에 값을 할당한다.*/
boostCourse01 = "Hello world";

/*변수 선언과 동시에 값을 할당*/
var boostCourse02 = "Hello world";

/*console.log 할당한 변수의 값 조회*/
console.log(boostCourse01);
console.log(boostCourse02);

/*복수개의 변수를 선언 및 초기화*/
var a, b, c;
var d = 10, c = 20, d = 30;
```

## Name of variable

Camel Case

- 컴퓨터가 띄어쓰기를 인식하지 못함
- 두 종류의 연속된 영어단어 **injectedscript → 읽기에 좋지 않음**
- 캐멀케이스 → **injectedScript**

## 데이터 타입

변수에 저장되는 데이터의 종류

- 데이터 타입은 원시 타입과 참조 타입으로 나누어진다.
    - 원시타입 : 숫자, 문자열, 논리, undefined, null, etc

    ```jsx
    /*String*/
    var boostCourse = "Hello world";
    console.log(boostCourse);

    /*Number*/
    var boostCourse = 10;
    console.log(int);

    /*null*/
    var boostCourse = null;
    console.log(boostCourse);

    /*undefined*/
    var boostCourse;
    console.log(boostCourse);
    ```

    - 참조타입 : 배열, 함수, 객체, 정규표현식

자바스크립트의 타입에는 선언할 때가 아닌, 실행 타임에 결정된다. 함수 안에서의 파라미터나 변수는 실행될 때 그 타입이 결정된다.

## null / undefined

undefined

- 값 미할당
- 존재하지 않는 객체의 프로퍼티를 읽으려고 시도할 때의 값이다.
- 존재하지 않는 배열의 요소를 읽으려고 시도할 때의 값이다.
- 아무것도 반환하지 않는 함수가 반환하는 값 등..

null

- 변수 선언을 하고 사용자가 임의로 빈 값을 삽입한 상태이다.

```jsx
/*null*/
var boostCourse01 = null;
console.log(boostCourse01);

/*undefined*/
var boostCourse02;
console.log(boostCourse02);

typeof boostCourse01;
 -> 실행결과 : "object"

typeof boostCourse02;
 -> 실행결과 : "undefined"

console.log(typeof null);
console.log(typeof undefined);

console.log(null == undefined);
console.log(null === undefined);

console.log(!null);
console.log(!!null);

console.log(!undefined);
console.log(!!undefined);
```

## 연산자

```jsx
/*or 연산자*/
var name ="crong";
var result = name || "codesquad";
console.log(result);
var name="";
var result = name || "codesquad";
console.log(result);
```

## 비교연산자

```jsx
/*비교 연산자에서 ==, ===*/
"1"==1 // true
"1"===1 // false, type 까지 비교
```

## 삼항연산자

```jsx
/*참일 경우 좌측의 값, 거짓일 경우 우측의 값*/
var codeSquad01 = 10;
var codeSquad02 = 20;
var result = (codeSquad01 > codeSquad02) ? "ok" : "fail";
/*fail*/
var result = (codeSquad01 < codeSquad02) ? "ok" : "fail";
/*ok*/
```

## etc.

```jsx
var a = 10;
var b = 20;

console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(a / b);
console.log(a % b);

/*문자열 연산*/
var firstName = "Doa";
var lastName = "Choi";

console.log(firstName + lastName);

/*문자열 및 숫자열 연산*/
var Name = "Choidoa";
var age = 24;

console.log(Name + age);

/*문자 10과 문자 20, 출력결과 1020*/
var a = "10";
var b = "20";

console.log(a + b);

/* ++, --, += */
var a = 10;

console.log(--a);
console.log(++a);

a += 40;
console.log(a);
```

## function

한 번 만들어놓으면 재사용이 가능한 형태를 가진 코드

```jsx
function boostCourse() {
	console.log('call boostCourse');
}

/*함수 호출*/
boostCourse();

/*Parameter, 전달된 값을 받아들이는 함수,
Argument, 어떤 함수를 호출시 전달되는 값*/
function myName(name) {
	console.log(name + "입니다.");
}

myName(choidoa);

function boostCourse(width, height) {
	var boost = width * height;
	console.log(boost);
}

boostCourse(100, 200);
 
/*return*/
function yourAge(age) {
	return age + "살입니다.";
}

var age = yourAge(24);
console.log(age);
```
