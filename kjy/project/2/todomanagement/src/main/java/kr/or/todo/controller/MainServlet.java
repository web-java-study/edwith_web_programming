package kr.or.todo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.todo.dao.TodoDao;
import kr.or.todo.dto.TodoDto;

@WebServlet("/")
public class MainServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<TodoDto> list=null;
		TodoDao dao = new TodoDao();
		list = dao.getTodos();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
	}

}
