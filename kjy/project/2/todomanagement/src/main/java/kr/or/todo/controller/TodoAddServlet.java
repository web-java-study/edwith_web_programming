package kr.or.todo.controller;

import java.io.DataInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.todo.dao.TodoDao;

@WebServlet("/add")
public class TodoAddServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String title  =  req.getParameter("title");
		String name = req.getParameter("name");
		String seq = req.getParameter("seq");
		
		TodoDao dao = new TodoDao();
		dao.addTodo(title, name, Integer.parseInt(seq));
		
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/view/todoForm.jsp").forward(req, resp);
		
	}
	

	
}

