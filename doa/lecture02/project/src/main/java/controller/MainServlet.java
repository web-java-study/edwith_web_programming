package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import dao.TodoDao2;
import dto.TodoDto;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello World! TEST</h1>");

        TodoDao2 dao = new TodoDao2();
        List<TodoDto> list = dao.getTodo();
        request.setAttribute("todo", list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main/index.php");
        requestDispatcher.forward(request, response);

    }
}
