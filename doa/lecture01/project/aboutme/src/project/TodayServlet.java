package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>introduce</title></head>");
	    out.println("<body>");
		out.println("<a href=/aboutme/index.html>바로가기</a>");
		LocalDateTime dateTime = LocalDateTime.now();
		String dateTimeString = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		out.println("<div style=\"position:fixed; top:50%; left:50%; transform:translate(-50%,-50%);\"> 현재시간 : " + dateTimeString + "</div>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
