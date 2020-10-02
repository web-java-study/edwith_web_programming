## 비동기 처리

자바스크립트의 비동기 처리란, 특정 코드의 연산이 끝날 때까지 코드의 실행을 멈추지 않고 다음 코드를 먼저 실행하는 자바스크립트의 특성(콜스택)

## Callback 함수

즉시 실행되지 않고, 나중에 필요한 시점에 실행되거나, 실행이 되지 않을 수 있다.

callback의 의미를 단어에서 좀 더 유추해보면 호출한(call) 대상에서 되부름(call back)이 되기 때문에 callback 이라고 한다.

[reference] 1) window 객체(setTimeout)

## 비동기 처리의 사례

비동기 처리의 가장 흔한 사례는 jQuery의 Ajax이다. 제이쿼리로 실제 웹 서비스를 개발할 때 Ajax 통신을  빼놓을 수 없는데, 보통 화면에 표시할 이미지나 데이터를 서버에서 불러와 표시해야 하는데 이때 Ajax 통신으로 해당 데이터를 서버로부터 가져올 수 있다.

## setTimeout()

window.setTimeout() window 는 전역객체이므로 생략이 가능하다.

setTimeout()과 같은 함수는 비동기적으로 실행되는데, 동기적인 다른 실행이 끝나고 난 후에 실행이 된다.

#1.example 

아래의 예제를 보자.

```jsx
function run() {
	console.log("run start");
	
	setTimeout(function() {
		var msg = "hello codesquad";
		console.log(msg);
		console.log("run ...ing");
	}, 2000);

	console.log("run end");
}

run(); 
```

해당 코드의 처리 메커니즘은 다음과 같다.

1. 호출스택에main(), setTimeout()이 쌓인다.
2. setTimeout() 실행시 콜백 run은 백그라운드로 이동
3. 백그라운드에서 2000ms(2초) 후에 태스크 큐로 이동한다.
4. 호출 스택 실행이 끝나 비워지면, 이벤트 루프가 태스크 큐의 콜백을 호출스택으로 올린다.
5. run 함수가 실행되고 호출 스택에서 소멸
6. 이벤트루프는 태스크 큐에 새로운 함수가 들어올 때까지 대기한다.

[reference]([https://www.zerocho.com/category/JavaScript/post/597f34bbb428530018e8e6e2](https://www.zerocho.com/category/JavaScript/post/597f34bbb428530018e8e6e2))

따라서 출력 결과는 run start, run end, hello codesquad, run end 순서이다.

#2.example

```jsx
function run() {
	setTimeout(function() {
		var msg = "hello codesquad";
		console.log(msg);
		console.log("run ....ing");
	}, 2000);
}

console.log("run start");
run();
console.log("run end");
```

이것이 비동기 콜백함수의 특징이다. 즉, 스택이 모두 비워지고 나서 비동기는 이벤트 큐에 보관되고 있다가 나중에 실행이 된다.

## Ajax

하나의 페이지를 로드하기 위해선 여러번 서버와 통신이 필요할 수 있는데 그때마다 모든 페이지를 불러오는 건 상당히 비효율적이다.

***만일 하나의 웹페이지를 구성하는 파일이 천 개가 넘는다면..? 각 페이지들의 용량이 굉장히 크다면..?***

구성이 위와 같다면 자원 소모가 엄청날 것이다.

이때, **Ajax**를 이용하면 원하는 부분만 가져올 수 있도록 한다.

→ 고정되는 것과 바뀔 수 있는 부분을 구분, 바뀔 수 있는 부분만 동적으로 처리
