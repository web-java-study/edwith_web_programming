package db;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.*;


public class DBDriverLoader {
    public void init() {
        try {
            // 드라이버 로드
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
