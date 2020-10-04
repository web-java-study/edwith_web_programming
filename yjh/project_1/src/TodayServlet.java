import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name="today", urlPatterns = "/today")
public class TodayServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Date date = new Date();
        String date_format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);

        out.println("<a href=\"index.jsp\" type=\"button\">메인화면</a>");
        out.println("<div style=\"height:100%;display:flex; justify-content:center; align-items:center;\">");
        out.println("<h1>현재시간 :");
        out.println(date_format);
        out.println("</h1>");
        out.println("</div>");

        out.close();

    }
}
