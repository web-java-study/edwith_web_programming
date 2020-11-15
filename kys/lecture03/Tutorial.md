# Spring initializr 를 사용하여 스프링 부트로 웹개발 환경 구축하기

> [Spring initializr](https://start.spring.io/)  

자바와 스프링을 공부하던중에 아주 쉽고 편하게 초기 프로젝트 세팅을 할 수 있는 방법을 알게 되었는데 Spring initializr 를 사용하는 방법이다. 튜토리얼이 있을까 싶어서 이것저것 뒤져보다가 딱 맘에 드는게 없어서 직접 이것저것 좀 알아보면서 세팅을 해 나가며 정리를 하려고 한다.

## 필요한것들
- 코드작성도구는 Intelij 를 사용
- Spring JDBC 사용
- MVC 패턴 사용
- MySql 사용
- 웹 프로젝트 진행
- 코드수정시 오토업데이트가 되었으면 좋겠음
- Edwith 와 인프런과 생활코딩의 강좌들을 참고

## 프로젝트 세팅화면
![](https://i.ibb.co/NNGTR7n/2020-11-05-10-42-42.png)  

- gradle 로 프로젝트를 생성하고 의존성 라이브러리 관리
- 언어는 JAVA
- 부트버전은 기본으로 설정된 버전으로
- 빌드압축 확장자는 JAR
- JAVA 버전도 안정적인 11
- 의존성 도구들
  - Spring Boot DevTools 코드수정시 자동 업데이트 등의 편리한 기능 제공
  - Spring Web 웹 프로젝트를 위해서는 필수적으로 포함되어야함
  - Thymeleaf 를 사용하면 JSP 파일이 아닌 html 파일에도 class로 작성한 코드의 값들을 주입하여 사용할 수 있도록 해준다.
  - MySQL Driver MySQL 을 사용하기위해 필요한 의존성 도구
  - JDBC API sql 문 작성시 JDBC로 작성하기 위해 필요


## build.gradle
설정완료하고 다운받은 압축폴더를 열면 설정한대로 세팅된 프로젝트폴더가 생긴다 IDE 로 해당 프로젝트를 오픈하고 build.gradle 파일을 열어보면 의존성도구를 추가했던 목록이 나오는걸 확인 할 수 있다.  
![](https://i.ibb.co/gPTDwty/2020-11-06-8-52-29.png)

## application.properties
내장 h2 데이터 베이스가 아닌 mysql 을 사용하려면 `application.properties` 에서 별도의 설정을 작성해 주어야 한다.

```java
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/DBName?serverTimezone=Asia/Seoul&useSSL=false
spring.datasource.username=root
spring.datasource.password=123412341234
```


## 프로젝트 동작 테스트
프로젝트를 생성하고 세팅까지 대충 진행했는데 이게 제대로 실행이 되는건지 확인을 해 보려고 한다.
  
MVC 패턴을 사용해 프로젝트구조를 구성하려고한다. 우선 `com.example.reservation` 하위에 controller 라는 패키지를 생성하고 테스트를 진행할 JAVA class 파일을 생성한다.
  
```java
package com.example.reservation.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HelloTest {
}

```
HelloTest 라는 이름으로 클래스파일을 하나 생성하고 controller 라는걸 나타내기위해 `@Controller` Annotation 을 작성한다. 해당 어노테이션을 표시하게되면 컨트롤러에서 View를 반환하겠다 라고 선언하는것과 같다.
  
그럼 View를 반환하는 코드를 작성해보도록 하겠다.

## View 작성
우선 위에서 생성한 HelloTest class 내부에 접근할 페이지 네임과 어떤 View 를 리턴할지에 대한 코드를 작성해야한다.

```java
package com.example.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloTest {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello");
        return "hello";
    }
}
```

`@GetMapping` 은 `localhost:8080` 뒤에 입력하여 접근한 url mapping name 이다. `localhost:8080/hello` 를 입력해서 접근하면된다. 실행을 해보면 아래와 같은 화면이 나오면 정상이다.
![](https://i.ibb.co/GMP52q4/2020-11-07-9-05-22.png)  

  
hello 라는 함수의 로직은 hello 라는 스트링을 리턴해주고있는데 아직 연결할 html 파일이 존재하지않기때문에 위와같이 화면이 나오게된다.  
  
해당 url 접근시 원하는 View 화면을 보여주기위해서는 `resources > templates` 내부에 리턴하는 스트링네임과 동일한 네이밍으로 html 파일을 생성해주면된다.

templates 폴더내에 hello.html 을 생성해주고 hello world를 찍고 프로젝트를 재실행한 후에 다시 localhost:8080/hello 에 접근하면 hellow world 가 찍힌 화면을 볼 수 있다.
  

templates  이외에도 static 폴더가 존재하는데 여기는 정적인 컨텐츠들이 포함된다.

## 동적 데이터 전달
Controller 는 View를 단순히 리턴해주는것뿐만아니라 값을 전달하여 동적으로 그것을 화면에 보여줄 수도있다.
```java
model.addAttribute("data", "Hello");
```
HelloTest 에서 작성한 hello 함수를 보면 위와같은 코드가 한줄이 있는데 해당 코드를 통해서 html에 특정 데이터를 전달해 줄 수 있다.
  
전달된 값을 html 에서 받아서 사용하기 위해서
```html
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
```
위와같이 작성해 주어야하고 해당 기능은 초기세팅때 의존성도구로 추가했던 `thymeleaf` 덕분에 사용할 수 있는 기능이다.

```html
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>hello</title>
</head>
<body>
<div th:text="${data} + 'hello' ">test</div>
</body>
</html>
```

값을 받아 보여주려는 태그에 attribute 에 추가해주면 contoller 에서 전달된 데이터를 보여주는것을 확인 할 수 있다. 하드코딩으로 작성된 test 라는 스트링은 contoller 에서 전달된 값으로 대체되어 표시된다.

**parameter 값이 있을때**
@GetMapping 은 프론트가 서버에 요청할때 보내는 메소드 get, post 요청과 동일한 뜻을 가진다. @GetMapping 일때 외부에서 파라미터를 전달 받을 수 있는데 이 전달받은 파라미터도 컨트롤러에서 처리해주고 View 에 뿌려줄 수 있다.

```java
 @GetMapping("param-test")
public String getParam(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "paramTest";
}
```
localhost:8080/param-test 에 접근했을때 실행할 함수를 생성하고 @RequestParam 으로 어떤 파라미터 키값을 받을지 이름을 지정한다.  

**templates/paramTest.html**
```html
<!DOCTYPE html>
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div th:text="${name} + ' hello' ">test</div>
</body>
</html>
```

View 를 보여줄 html 파일을 하나 생성하고 `localhost:8080/param-test?name=kang` 를 입력하면 화면에 파라미터로 넘겨받은 name 값이 출력되는걸 확인 할 수 있다.

## API
JSON 형태로 반환하는 방법
```java
@GetMapping("hello-api")
@ResponseBody
public Todos helloApi(@RequestParam("name") String name) {
    Todos todos = new Todos();
    todos.setName(name);
    return todos;
}
```
`@ResponseBody` Annotaion을 사용하게 되면 프론트로 리턴해줄때 JSON 형식으로 데이터를 반환시켜줄 수 있다.

## 데이터 조회하기
컨트롤러와 뷰를 연결했고 연결한 디비에서 데이터목록을 조회해보려고 한다. 우선 domain 이란 이름을 가진 package 파일을 생성하고 todos 라는 이름으로 java class를 생성하려고 한다.  
  
todos 에는 이전에 실습했던 투두목록 만들기에서 사용했던 데이터로 스프링부트로 디비연결과 데이터 조회하는 샘플코드를 작성하기 위해서 사용한다.  
  
domain 패키지에는 모델을 작성하게된다.

**domain > Todos**
```java
package com.example.reservation.domain;

public class Todos {
    private String title;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
```

title 과 name 에 대한 모델을 작성하였다.

