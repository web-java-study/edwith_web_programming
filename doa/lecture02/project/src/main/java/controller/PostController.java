package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/post")
public class PostController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터에서 데이터를 가져오려면  req.getParameter 
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		int status = 200;
//		String address = req.getParameter("address");
//		String email = req.getParameter("email");
		
		System.out.println("id == " + id );
		System.out.println("pw == " + pw );
//		System.out.println("address == " + address);
//		System.out.println("email == " + email);
		
		System.out.println("=================");
		
		// 값이 비었거나, 공백이 포함되어 있으면 실행, 아래 status code 값은 임의로 지정한 값임
		if(id.isEmpty() || id.contains(" ")) {
			status = 210;
		}
		
		if(pw.isEmpty() || pw.contains(" ")) {
			status = 211;
		}		
		
		resp.setStatus(status);
		req.getRequestDispatcher("test.jsp").forward(req, resp);
	}
	
}
