package dao;

import java.sql.*;

public class dbtest {
    public static void main(String[] args) {
        Connection con = null;

        String server = "localhost";
        String database = "todolist";
        String user_name = "connect";
        String password = "1234";

        // 1.드라이버 로딩
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" Fail " + e.getMessage());
            e.printStackTrace();
        }

        // 2.연결
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false", user_name, password);
            System.out.println(" Connection OK ");
        } catch(SQLException e) {
            System.err.println(" Conn Fail " + e.getMessage());
            e.printStackTrace();
        }

        // 3.해제
        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}
    }
}
