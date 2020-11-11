package controller;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.io.PrintWriter;

>>>>>>> upstream/master
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
<<<<<<< HEAD:doa/lecture02/project/src/main/java/controller/MainServlet.java

=======
>>>>>>> upstream/master:doa/lecture02/project/src/main/java/controller/TodoFormServlet.java

@WebServlet("/TodoFormServlet")
public class TodoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoFormServlet() {
=======


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
>>>>>>> upstream/master
        super();
        //todoDao = new TodoDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
<<<<<<< HEAD
		response.setContentType("text/html; charset=UTF-8");
=======
		// response.setContentType("application/json");
		
//		List<Todo> list = dao.getTodos();
//		
>>>>>>> upstream/master
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title> Todo List </title></head>");
		out.println("<body>Test<br>Test</body>");
		out.println("</html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
