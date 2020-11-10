package dao;

<<<<<<< HEAD
import java.sql.*;

public class TodoDao {
    String url = "jdbc:mysql://localhost:3306/todolist";
    String user = "connect";
    String passwd = "1234";
    String driver = "com.mysql.jdbc.Driver";

    public int TodoAdd() {
        Connection conn = null; // DB연결 객체
        PreparedStatement ps = null;    // SQL문을 디비에 전달
        String SQLQuery = "insert into todo(title, name, sequence) values(?,?,?)";


        // 예외처리
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection ok");
            ps = conn.prepareStatement(SQLQuery);

            ps.setString(1, "Test");
            ps.setString(2, "test");
            ps.setInt(3, 1234);

            int rs = ps.executeUpdate();
            System.out.println(rs);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage() + " :: Driver Loading 실패");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " :: Connection 실패 " + url + "/" + user + "/" + passwd);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
}

=======
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.*;

import java.util.ArrayList;
import dbConnect.DBConn;

public class TodoDao {
	PreparedStatement ps = null;
	
	public static void main(String[] args) {
	
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		DBConn test = new DBConn();
		System.out.println(test);
		
		String SQLQuery = "insert into todo(title, name, sequence) values(?,?,?)";

		// 20201111

	}
}
>>>>>>> upstream/master
