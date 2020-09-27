
## Servlet 과 JSP 의 연동
Servlet 은 로직을 수행하기에 적합하고 JSP 는 결과를 출력하기에 적합하다. 때문에 두 파일의 장점을 살려서 연동하여 사용할 수 있다. html 에는 정적인 요소들만 가질 수 있기때문에 JSP 파일을 사용하면 html 내부에서 동적인 요소의 결과들을 편하게 출력 할 수 있다.


**LogicServlet**
```java
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int v1 = (int)(Math.random() * 100) + 1;
	int v2 = (int)(Math.random() * 100) + 1;
	int result = v1 + v2;
	
	request.setAttribute("v1", v1); // setAttribute 로 request 에 값을 v1 이란 이름으로 저장
	request.setAttribute("v2", v2);
	request.setAttribute("result", result);
	
	RequestDispatcher rd = request.getRequestDispatcher("/result.jsp"); // 어떤 JSP 파일과 연결해줄지 지정
	rd.forward(request, response); // 지정한 JSP 파일로 request 와 response 를 포워드
}

```

**Result.jsp**
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 int v1 = (int)request.getAttribute("v1"); // getAttribute 로 저장했던 값을 불러옴
 int v2 = (int)request.getAttribute("v2");
 int result = (int)request.getAttribute("result");
%>
<%=v1 %> + <%=v2 %> = <%=result %> <!-- 해당 결과 값들을 출력 -->
</body>
</html>
```

## Page Scope
자바에는 여러종류의 스코프가 존재하는데 스코프는 정해진 영역안에서 사용되는 변수나 메소드를 포함하고있는 일정한 범위 라고 볼 수 있다. 그중에 PageScope 에 대해서 알아보려고 한다.
  
Page scope 는 pageContext 라는 내장객체로 JSP 에서 사용가능하며 foward 가 될 경웨 Page scope 에 지정된 변수는 사용할 수 없다. 지역변수와 성격이 비슷하다고 볼 수 있다. 정해진 페이지 영역안에서만 변수 사용이 허용된다.

**사용법**
```java
pageContext.setAttribute
pageContext.getAttribute
```

## Request Scope
http 요청을 WAS 가 받아서 웹 브라우저에게 응답할때까지 변수값을 유지해야할 경우 사용한다.  
HttpServletRequest 객체를 사용한다.  
JSP 에서는 request 내장변수를 사용한다.  

**사용법**
```java
request.getAttribute
request.setAttribute
```

## Session Scope
웹 브라우저 별로 변수를 관리하고자 할 경우 사용한다. 하나의 클라이언트마다 관리해주는 변수영역이라고 할 수 있다. 브라우저간의 탭끼리 해당 영역에 대한 내용 공유가 가능하다.
  
서블릿에서는 HttpServletRequest 의 getSession() 메소드를 이용하여 session 의 객체를 얻어 올 수 있고 JSP 같은경우에는 session 내장변수를 사용한다.

**사용법**
```java
session.getAttribute
session.setAttribute
```

## Application Scope
웹 어플리케이션이 시작되고 종료될 때까지 변수를 사용 할 수 있다.  
ServletContext 인터페이스를 구현한 객체를 사용한다.  
JSP 에서는 application 내장 객체를 사용한다. 특징으로는 클라이언트가 어떤 클라이언트든 동일한 내용을 사용하게된다는점이다. 이전 다른 스코프들은 각각의 영역내에서 사용가능했는데 어플리케이션 스코프는 전역변수같은역할을 한다고 볼 수 있다.

## EL(Expression Language)
값을 표현하는데 사용되는 스크립트 언어로 JSP 의 기본 문법을 보완하는 역할을 한다. 

**사용법**
```jsp
<body>
요청 URL ${pageContext.request.requestURL} // javascript 에서 사용하는 방법과 동일한것같다.
request 의 name 속성 ${requestScope.name} 이런식으로 사용 가능하다.
</body>
```

**EL 사용 예제**
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	pageContext.setAttribute("p1", "page scope value");
	request.setAttribute("r1", "request scope value");
	session.setAttribute("s1", "session scope value");
	application.setAttribute("a1", "application scope value");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

${pageScope.p1}<br/>
${requestScope.r1}<br/>
${sessionScope.s1}<br/>
${applicationScope.a1}<br/>

</body>
</html>
```
전체적으로 객체를 불러오거나 사칙연산, 삼항연산자 등 사용법은 javascript 에서 사용하는 방법과 거의 똑같은것같다.

## JSTL(JSP Standard Tag Library)
JSP 페이지에서 조건문 처리 반복문 처리 등을 html tag 형태로 작성 할 수 있도록 도와준다.  
[관련 라이브러리 파일 받는곳](http://tomcat.apache.org/download-taglibs.cgi)  

해당 문법을 사용하기 위해서는 세가지 파일을 다운로드 받아 `WEB-INF -> lib` 폴더에 넣어주어야 한다.


**사용법**
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="value1" scope="request" value="kang" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

성: ${value1}<br/>

<c:remove var="value1" scope="request" />

성: ${value1}<br/>

</body>
</html>
```

**조건문 사용**
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
	request.setAttribute("n", 10);
	이 코드와 아래의 코드는 동일한 기능을 갖는 코드 이다.
%> --%>
<c:set var="n" scope="request" value="10" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${n == 0}">
	n과 0은 같습니다.
</c:if>
<c:if test="${n == 10}">
	n과 10은 같습니다.
</c:if>

</body>
</html>
```

## choose 구문
switch 구문을 html 에서 태그로 표현하기 위한 문법이 아닐까 싶다.

**사용법**
```jsp
<c:choose>
	<c:when test="조건1">
		조건1이 참일때 실행
	</c:when>
	<c:when test="조건2">
		조건2가 참일때 실행
	</c:when>
	<c:otherwise>
		위의 모든 조건을 만족하지 않을때 실행
	</c:otherwise>
</c:choose>
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.util.*" %>
<%
    request.setAttribute("score", 83);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
    <c:when test="${score >=90 }">
    A학점입니다.
    </c:when>
    <c:when test="${score >=80 }">
    B학점입니다.
    </c:when>
    <c:when test="${score >=70 }">
    C학점입니다.
    </c:when>
    <c:when test="${score >=60 }">
    D학점입니다.
    </c:when>
    <c:otherwise>
    F학점입니다.
    </c:otherwise>            
</c:choose>
</body>
</html>
```

....이 외에 기타 등등 사용 가능 너무 관련 내용이 많아 정리하기도 힘들어서 실습과제하면서 필요할때 찾아보기로함

## DBMS (데이터베이스 관리시스템)
### 데이터베이스의 특성
- 실시간 접근성 : 사용자의 요구를 즉시 처리 가능하다.
- 계속적인 변화 : 정확한 값을 유지하기위해 삽입 삭제 수정 작업등을 이용해 지속적으로 갱신가능
- 동시 공유성 : 사용자마다 서로 목적이 다르므로 동시에 여러 사람이 동일한 데이터에 접근하고 이용할 수 있다.
- 내용참고 : 저장한 데이터의 위치나 주소가 아닌 사용자가 요구하는 데이터의 내용 즉 데이터 값에 따라 참조할 수 있어야 한다.

### 데이터베이스 관리시스템
데이터베이스를 관리하는 소프트웨어로 DBMS 라고 부른다. 필수적이 3가지 기능을 포함해야하는데 
- 정의기능
- 조작기능
- 제어기능

위의 세가지 기능을 포함하여야 하며 `Oracle, SQL Server, MySQL` 등의 소프트웨어가 있다. 
  
가장 큰 장점으로는 데이터의 중복을 최소화 할 수 있고 데이터의 안정성이 보장되고 데이터의 일관성과 무결성을 유지하기 쉽다.  

단점으로는 운영비가 비싸고 백업 및 복구에 대한 관리가 복잡하다.


## MySQL Install & start & stop for MAC
- brew install mysql
- brew services start mysql
- brew services stop mysql
- brew services list

## SQL (Structured Query Language)
데이터를 보다 쉽게 검색하고 추가 삭제 수정같은 조작을 할 수 있도록 고안된 컴퓨터 언어  
관계형 데이터베이스에서 데이터를 조작하고 쿼리하는 표준 수단이다.




>examples.sql  
https://github.com/perm4/examples  
MySQL 8버전  
create user 'connectuser'@'localhost' identified by 'connect123!@#';  
create user 'connectuser'@'%' identified by 'connect123!@#';  
grant all privileges on connectdb.* to 'connectuser'@'localhost';  
grant all privileges on connectdb.* to 'connectuser'@'%';  
flush privileges;  


## DML(select, insert, update, delete)
데이터 조작어의 4가지 종류 이다. 순서대로 검색, 등록, 수정, 삭제 를 조작할 수 있는 명령어이다.


### SELECT
```sql
show tables; --전체 테이블 조회
desc bonus; --보너스테이블의 정보 조회
select * from bonus; -- 보너스 테이블의 전체 데이터 조회
select name from employee; -- 직원 테이블에서 이름만 검색
select * from employee where name="ford"; -- 직원테이블에서 이름이 ford 인 사람의 데이터 조회
select job from employee order by name; -- 직원테이블에서 name 순으로 정렬된 job 데이터 출력
select * from employee where name like 'A%'; -- 직원테이블에서 이름이 A로 시작하는 데이터 출력
select name,job,deptno from employee; -- 직원테이블에서 name, job, deptno 의 컬럽에 있는 데이터만 출력
select count(*) from employee; -- 직원테이블의 null 데이터 포함하여 전체 컬럼 갯수 출력하는 함수
select employee.name, department.location from employee inner join department on employee.deptno = department.deptno; -- 직원테이블 기준으로 부서테이블 데이터중에 name과 location 을 출력하려고 한다 
```

### INSERT
```sql
insert into 테이블명 values(value1, value2....); -- 해당 테이블에 컬럼수 만큼 데이터 입력 컬럼의 타입에 맞춰야 한다.
insert into 테이블명(컬럼명) values(value); -- 해당 테이블의 원하는 컬럼에만 데이터 입력 가능 다만 필수키로 지정된 컬럼은 반듯이 값이 입력되어야 한다.
```

### UPDATE
```sql
update 테이블명 set 변경할컬럼명 = 'value' where 기준컬럼명 = 'value'; -- 해당 테이블의 변경할 컬러명 데이터를 변경하는데 기준컬럼 정보 기준으로 변경
```

### DELETE
```sql
delete from 테이블명 where 컬럼명 = value; -- 해당테이블의 컬럼데이터와 일하는 행 삭제;
```

## DDL (create, drop)
데이터 조작어는 테이블의 데이터를 조작하는 명령어라면 DDL(데이터 정의어) 은 데이터를 감싸고 있는 틀인 테이블을 생성 수정 삭제하는 명령어이다.

### CREATE
```sql
create table book (
	isbn varchar(10) primary key,
	title varchar(20) not null,
	price integer not null
);
-- isbn 컴럼은 테이블에서 유일한 키값을 가지며 varvhar 타입으로 10의 입력 제한을 받는다.
-- title 은 null 이 올수 없으며 20자의 입력 제한을 갖는다.
-- price null 이 올수 없으며 숫자형을 갖는다.
```


### ALTER
```sql
alert table book add author varchar(20); -- 테이블에 author 필드추가
alert table book drop price; -- 테이블에서 price 필드 제거
```

## MAVEN
javascript 에서 webpack이 있는것처럼 java 에서는 maven 이라는 패키지 매니저같은 시스템이 있는것같다. 메이븐을 사용할 경우 편리한 의존성 라이브러리 관리를 할 수 있고 프로젝트 빌드와 관련된 내용들을 일관성있게 만들어주는 도구라고 볼 수 있을것같다.

### MAVEN PROJECT SETTING
세팅을 진행하던 도중 몇가지 문제점이 있었다. 해결해서 설정을 완료하긴 했지만 이강좌...좀 불친절한면이 있는것같다. 2년전 강의이기도하고 기본프로젝트 구조가 좀 바뀌어 있는것도 한몫하는것 같다.

#### 문제1 web.xml 이 코드수정형태가 아니라 UI 형태로 나온다
우클릭해서 open width > text editor 로 열어서 수정했다.

#### 문제2 .settings 폴더가 없다.
폴더자체가 없는건 아니고 프로젝트 구조상 건들일 필요가 없다 라고 봤던건지 숨김처리되어있었다.  
필터아이콘을 클릭해서 .*resources 를 해제해 주었더니 숨김 파일 등장

여차저차해서 댓글로 다른사람들이 겪는 오류는 발생하지않고 무난하게 프로젝트 세팅은 진행했다.  
서버실행할때 오류나는 부분은 댓글에 나온내용과 동잃하게 진행했다. 서버리셋 , maven update 