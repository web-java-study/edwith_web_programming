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

## 생각해보기

→ JSP가 Servlet으로 변환되는 과정 (실행순서X)
