package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.TodoDao;
import dto.TodoDto;

@SuppressWarnings("unused")
@WebServlet("")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	TodoDao dao = new TodoDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		List<TodoDto> list;

		list = dao.getSelect();
		System.out.println(list);
		request.setAttribute("dataList", list);
		
		// 1. 리턴타입, 2. 클래스 선언 후 메소드 실행
		
		// forward to jsp, MVC 패턴, forward 혹은 redirect 로 보낸다. → 서블릿 → JSP(view) 
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
