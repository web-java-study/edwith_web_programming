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