package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/get")
public class GetController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Controlloer 호출완료");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		
		System.out.println("name = " + name);
		System.out.println("id = " + id);
		System.out.println("email = " + name + email);
		
		resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write("success");
	}
}
