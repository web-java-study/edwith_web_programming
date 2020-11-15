package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
<<<<<<< HEAD:doa/lecture02/project/src/main/java/controller/MainServlet.java

=======
>>>>>>> upstream/master:doa/lecture02/project/src/main/java/controller/TodoFormServlet.java
>>>>>>> upstream/master

@WebServlet("/TodoFormServlet")
public class TodoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoFormServlet() {
        super();
<<<<<<< HEAD
=======
        //todoDao = new TodoDao();
>>>>>>> upstream/master
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		response.getWriter().append("Served at: ").append(request.getContextPath());
<<<<<<< HEAD
=======
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title> Todo List </title></head>");
		out.println("<body>Test<br>Test</body>");
		out.println("</html");
>>>>>>> upstream/master
=======
		// Encoding forward
		request.getRequestDispatcher("/todoForm.jsp").forward(request, response);
>>>>>>> upstream/master
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
