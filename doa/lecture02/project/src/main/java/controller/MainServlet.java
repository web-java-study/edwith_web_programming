package controller;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.io.PrintWriter;

<<<<<<< HEAD
>>>>>>> upstream/master
=======
import javax.servlet.RequestDispatcher;
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

import java.sql.*;
import dao.TodoDao;
import dto.TodoDto;

@WebServlet("")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
>>>>>>> upstream/master
        super();
        //todoDao = new TodoDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		response.setContentType("text/html; charset=UTF-8");
=======
		// response.setContentType("application/json");
		
//		List<Todo> list = dao.getTodos();
//		
>>>>>>> upstream/master
=======
=======
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
>>>>>>> upstream/master
		
		TodoDao db = new TodoDao();
		db.getTodoDto();
		System.out.println(db);
>>>>>>> upstream/master
		
		// forward to jsp, MVC 패턴, forward 혹은 redirect 로 보낸다. → 서블릿 → JSP(view) 
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
