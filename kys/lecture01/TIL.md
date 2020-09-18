## JSP
JSP 는 html 문서에 java 의 언어를 사용하여 동적인 데이터를 표현 할 수 있도록 해주는 파일이며 JSP 스스로 동작하지않고 실행하게되면 servlet 에서 실행가능한 코드로 변환된 후 컴파일되어 실행된다. 
  
또한 내장객체를 사용할 수 있어 servlet 에서는 선언해야만 사용 할 수 있었던 객체들이 선언없이 사용해도 변환되는 과정에서 자동으로 선언이 들어가게된다.
  
JSP 에서는 여러종류의 선언문을 사용 할 수 있는데 
```html
<%  %> = 서블릿의 라이프사이클중에 서비스에 들어가 실행될 자바코드를 작성 할 수 있다.
<%=  %> = 자바코드를 선언문에서 작성한 후 웹에 출력해주기 위한 용도로 사용한다.
<%!  %> = 서비스영역이 아닌 그 전과 후에 실행될 라이프사이클 에서 동작할 내용에 대해서 직접 선언하고 작성 할 수 있다.
```

## forward vs redirect
일단 가장 큰 차이점은 주소창의 변화다 
  
redirect 는 내가 입력한 주소와 이동되어 출려되는 주소가 다르게 나오고  
forward 는 주소는 그대로이고 요청한 내용의 처리만 다른 servlet 에 맡겨 응답을 받아오는 형태를 취한다.
  
즉 첫번쨰 방법은 하나의 서블릿파일로 처리 할 수 있고 두번째 방법은 두개의 서블릿 파일이 필요하다. 


**FrontServlet.java**
```java
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int diceValue = (int)(Math.random() * 6) + 1;
	request.setAttribute("dice", diceValue);
	
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/next");
	requestDispatcher.forward(request, response);
}
```


**NextServlet.java**
```java
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.print("<html>");
	out.print("<head><title>form</title></head>");
	out.print("<body>");
	
	int dice = (Integer)request.getAttribute("dice");
	out.print("dice: " + dice);
	for(int i = 0; i < dice; i++) {
		out.print("hello");
	}
	
	out.print("</body>");
	out.print("</html>");
}
```


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
