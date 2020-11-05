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


