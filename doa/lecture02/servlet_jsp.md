## Servlet과 JSP

서블릿과 JSP는 기능의 차이는 없으나, 역할의 차이만 있다. 서블릿의 단점을 보완하고 기술을 확장한 스크립트 표준이 JSP이다. 

### *Servlet === JSP !*

**서블릿은 Java 코드 안에 HTML**

**JSP는 HTML 코드 안에 JAVA 코드**

서블릿의 HTML을 코딩하기 너무 어렵고 불편하다는 단점을 보완한 JSP는 HTML 내부에 Java 코드를 삽입하는 형식이다. 서블릿을 이용하게 되면 화면 인터페이스 구현에 너무 많은 코드를 필요로 하며, 쌍따옴표 하나에도 에러가나는 등의 비효율적인 측면이 많다.

## Servlet

- 자바 코드로 구현하고 컴파일하여 배포
- HTML 태그로 문자열 안에 ("") 처리
- 코드가 수정되면 다시 컴파일하고 배포하는 과정을 거쳐야 함
- 서블릿에서 html 코드를 사용하려면 out.print 안에 문자열로 들어가야 한다. → 길어지면 매우 불편해진다는 단점

## JSP

- 키워드가 태그화되어 서블릿에 비해 배우기 쉬움
- 자바코드를 <%%> 태그에 처리하여 서블릿으로 바뀔 때 어떻게 바뀌어야 하는지 알림
- HTML과 같이 태그를 사용하여 자바코드도 사용이 가능
- html 안에 java 코드를 섞어놓은 것을 스클립틀릿이라고 함
- 톰캣이 JSP를 서블릿으로 바꿔준다

같은 동작을 하는 예제

## Servlet example

```jsx
out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; harset=UTF-8\">\r\n");
      out.write("<title>sum10</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- 스크립틀릿, html에 java 코드를 섞어놓은 것 -->\r\n");

	int total = 0;
	for (int i = 1; i <= 10; i++) {
		total = total + i;
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("1부터 10까지의 합 : ");
      out.print(total );
      out.write("\r\n");
      out.write("\r\n");
      out.write(" ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
```

## JSP example

```jsx
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; harset=UTF-8">
<title>sum10</title>
</head>
<body>

<!-- 스크립틀릿, html에 java 코드를 섞어놓은 것 -->
<%
	int total = 0;
	for (int i = 1; i <= 10; i++) {
		total = total + i;
	}
%>

<%-- <%= %> 표현식, 변수에 있는 값을 출력.. out.print 로 바뀜 --%>
1부터 10까지의 합 : <%=total %>
```

## JSP 스크립트 요소

선언문 : <%! %> 전역변수, JSP 페이지에서 필요한 멤버 변수나 메소드가 필요할 때 선언하여 사용하는 요소

스크립트릿 : <% %> 프로그래밍 코드 기술에 사용, 일반적으로 가장 많이 사용되는 스크립트 요소, 지역변수 선언

표현식 : <%= %> 화면에 출력할 내용 기술에 사용, JSP 페이지에서 웹 브라우저에 출력할 부분을 표현, 출력할 부분은 내장객체인 out 객체의 print() 혹은 println() 메소드를 사용해서 출력

## JSP 스크립트릿, 선언식의 예제

```jsx
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Scope</title>
</head>
<body>
hello ~~
<%-- 스크립트릿, service method 영역, 지역변수--%>
<%
	System.out.print("jspService()");
%>

<%-- 선언식, 해당 스코프는 서블릿으로 변환될 때 member field 영역, 전역변수--%>
<%!
	public void jspInit(){
	System.out.print("jspInit()!!!");
	}
%>

<%!
	public void jspDestory(){
	System.out.print("jspDestory()!!!!");
	}
%>

</body>
</html>
```

위 코드의 전역 스코프 영역은 다음과 같이 변환된다.

## 서블릿으로 변환된 JSP member field 영역

```jsx
<%-- 서블릿으로 변환된 JSP의 전역 스코프 영역 --%>
<%--
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lifecycle_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


	public void jspInit(){
	System.out.print("jspInit()");
	}


	public void jspDestory(){
	System.out.print("jspDestory()");
	}
--%>
```

## JSP 선언문(Declaration) 예제

```jsx
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Declaration</title>
</head>
<body>
id : <%=getID() %>
<%-- 어느 위치에서도 해당 변수를 참조 가능하나, 관례적으로 HTML문서 맨 위에 위치시킨다고 한다.--%>
<%!
	String id = "u001"; // 멤버변수 선언
	public String getID() {	// 메소드 선언
		return id;
	}
%>
</body>
</html>
```

## JSP 선언문 Servlet 변환

```jsx
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class exam1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

	String id = "u001"; // 멤버변수 선언
	public String getID() {	// 메소드 선언
		return id;
	}
...
service method 영역
...
out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Declaration</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("id : ");
      out.print(getID() ); // 호출
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
```

## JSP 스크립트릿(Scriptlet) 예제

```jsx
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scriptlet</title>
</head>
<body>
<%
	for (int i = 1; i <= 5; i++) {

%>
<%-- 스크립트릿을 쪼개서 사용이 가능  --%>
<%-- 표현식, h1 ~ h5 까지 반복하여 출력 --%>
<H<%=i %>>아름다운 한글</H<%=i %>>
<%
	}
%>
</body>
</html>
```

## JSP 표현식과 스크립트릿 Servlet 변환

```jsx
for (int i = 1; i <= 5; i++) {


      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<H");
      out.print(i ); // h1 ~ h5 반복
      out.write(">아름다운 한글</H");
      out.print(i );
      out.write('>');
      out.write('\r');
      out.write('\n');

	}
```

## 생각해보기

Q. JSP가 Servlet으로 변환되는 과정 (실행순서X)
→ 호출된 JSP 파일을 Jasper가 컴파일을 한 후 다시 HTML에 그려주는 과정을 거친다. (좀 더 알아볼 것)

Q. JSP의 주석을 JSP 영역에서 사용하면 실행이 되지 않음.
- 스크립트릿 등의 영역에서 JSP 주석을 사용하면 java로 변환되기 때문에?

Q. out.print / system.out.println

