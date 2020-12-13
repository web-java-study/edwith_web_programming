package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import dto.TodoDto;

@WebServlet("/TodoFormServlet")
public class TodoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/todoForm.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String sequence = request.getParameter("sequence");
		int status = 200;
		
		System.out.println(sequence);
		TodoDao dao = new TodoDao();
		TodoDto dto = new TodoDto(title, name, Integer.parseInt(sequence));
		
		int test;
		test = dao.getTodoDto(dto);
		
		System.out.println("테스트 :: "+ dto.toString());
		System.out.println("plan == " + title);
		System.out.println("whois == " + name);
		
		System.out.println("===================");
		
		response.setStatus(status);
	}

}
