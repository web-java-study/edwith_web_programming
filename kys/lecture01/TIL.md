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


## Web Server vs Was and Servlet
### Web
- 인터넷을 기반으로 한 정보를 공유, 검색할 수 있게 하는 서비스
- URL, HTTP, HTML

### Server
클라이언트에게 네트워크를 통해 정보나 서비스를 제공하는 컴퓨터 시스템

### Web Server
인터넷을 기반으로 클라이언트에게 웹 서비스를 제공하는 컴퓨터
  
기존의 웹 서버는 정적인 페이지만 응답가능, 동적인 부분이나 프로그래밍적인것들을 표현하는데에 한계가있음  
이것을 극복하기위해 등장한것이 WAS(Web Application Serever)

### WAS
웹 어플리케이션과 서버환경을 만들어 동작시키는 기능을 제공하는 소프트웨어 프레임워크
웹 어플리케이션을 실행시켜 필요한 기능을 수행학도 그 결과를 웹 서버에 전달
WAS 는 웹서버와 웹 컨테이너를 합친것과 같다고 볼 수 있다.
php, jsp, asp 와 같은 언어등을 사용해 동적인 페이지를 생성할 수 있는 서버
프로그램 실행환경과 데이터베이스 접속기능 제공
비즈니스로직 수행가능
* 컨테이너: jsp, servlet을 실행시킬 수 있는 소프트웨어

<!-- 좀더 정리가 필요 -->

1. 웹서버
클라이언트에서 주소를갖고 HTTP 규약에 맞춰 웹서버에 요청을하게되면 웹서버는 정적인 부분에 대해서 응답을 하고 그걸 사용자가 보는 화면에 그려줄수 있게끔 해주는 역할을합니다. 단점은 동적인처리를 할 수가 없어요 그냥 요청한 주소에맞는 페이지만 응답해줄뿐입니다. 이러한 웹 서버가 처리하지못하는 동적인 처리를 위해 우리는 WAS 를 사용합니다.

2. WAS
웹서버에서 처리하지못하는 동적인처리를 요청받아 디비와의 접속을통해 다양한 로직을 수행하고 그 결과를 리턴해주는 apllication server 입니다.
웹컨테이너 또는 서블릿컨테이너라고도 부르는데 JSP나 Servlet을 실행시키는 소프트웨어를 말합니다.
즉 was 내부에는 웹서버와 동적인 처리를 실행할 수 있게 해주는 컨테이너를가지는데 이걸 서블릿컨테이너라고 부르기도해서 아마 이름떄문에 저런 질문이 나오지 않았나 추측해봅니다.
WAS자체에 Servlet을 가지고 있다기보다는 Servlet을 실행할수있는 컨테이너환경을 제공해준다고 보는게 정확할것같습니다.

웹서버와 was 이렇게 두종류의 서버로 나누는 이유는 was 는 이미 db와의 연결이나 다양한 로직을 수행하고있기때문에 그냥 정적인 페이지는 웹서버에서 처리하게끔 하여 분산처리를 통해 좀더 빠른 응답을 가능하게 해주고 서버의 부하를 덜어주기위해 나누어서 사용한다고 볼 수 있습니다. 

https://gmlwjd9405.github.io/images/web/web-service-architecture.png
여기에 was 내부에 servlet이 있는것처럼 보여지는데 이 그림은 웹서비스가 제공되는 과정에대한 그림을 나타낸것입니다. was 내부에 servlet 의 그림은 servlet 내부에있는 즉 우리가 작성한 init(), service(), destroy() 를 실행하여 클라이언트에서 넘어온 요청에 따라 두겟과 두 포스트가 실행된다 라는 로직을 설명하기위한 이미지로 보시면 될것같습니다.