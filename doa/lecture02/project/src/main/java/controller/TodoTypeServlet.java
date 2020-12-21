package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todocheck")
public class TodoTypeServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Controlloer 호출완료");
		String id = req.getParameter("id");
		String type = req.getParameter("type");
		
		System.out.println("id = " + id);
		System.out.println("type = " + type);
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write("TEST");
	}
}
