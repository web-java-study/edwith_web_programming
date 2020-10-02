## OOP(Object Oriented Programming)

변수나 함수 등을 작성하여 재사용 할 수 있도록 작성하는 것이다. 어떠한 기능을 만들고 이 **기능을 다양한 곳으로 사용하기 위해 재사용을 고려하여 개발**하는 것을 OOP라고 함

## 클래스(생성자 함수)

생성자 함수란 객체를 생성하는 함수, 즉 **C언어에서의 구조체와 비슷한 것 같음**

생성된 클래스를 재사용하고 싶다면 new 연산자를 사용하여 새로운 객체인 인스턴스를 생성하면 된다. 

→ **클래스는 일반 함수와 구분하기 위해 대문자로 작성(관례적으로 이러한 생성자 함수는 첫 글자를 대문자로 쓰는 파스칼 표기법에 따른다.)** this는 생성자 함수 자신을 가리키고 this에 저장된 내용물은 new를 통해 객체를 만들 때 해당 객체에 적용

```jsx
function Person(firstName, lastName) {
	this.firstName = firstName;
	this.lastName = lastName;

	this.fullName = function() {
		console.log(this.firstName + " " + this.lastName);
	}
}

var choi = new Person("Doa", "Choi");
var park = new Person("David", "Park");

choi.fullName();
park.fullName();

console.log(choi);
console.log(park);
```

위 예제의 경우 fullName()을 인스턴스별로 따로 생성하고 있다. 즉, 불필요하게 자원을 낭비하게 되므로 prototype 프로퍼티를 이용하여 함수를 생성하면 인스턴스별로 함수를 생성하지 않아 불필요한 자원 낭비를 줄인다.

## prototype

인스턴스별로 함수를 생성하지 않아 메모리를 세이브

```jsx
function Person(firstName, lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
}

Person.prototype.fullName = function() {
	console.log(this.firstName + " " + this.lastName);
};

var choi = new Person("doa", "choi");
var park = new Person("david", "park");

choi.fullName();
park.fullName();

console.log(choi);
console.log(park);
```
