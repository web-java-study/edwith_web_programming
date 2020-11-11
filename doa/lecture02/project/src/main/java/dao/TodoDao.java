package dao;

<<<<<<< HEAD
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
=======
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import dto.TodoDto;

public class TodoDao {
		/* [JDBC Java Database Connectivity] */
		// DB Account, Time zone error → UTF-8, Timezone=UTC 
		private static String url = "jdbc:mysql://localhost:3306/todolist?characterEncoding=UTF-8&serverTimezone=UTC";
		private static String user = "connect";
		private static String passwd = "1234";
		private static String driver = "com.mysql.cj.jdbc.Driver";
		public TodoDto getTodoDto() {
			TodoDto todo = null;
			Connection conn = null;
			PreparedStatement ps = null;
			@SuppressWarnings("unused")
			int rs;
			
			// close
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, passwd);
				String sql = "insert into todo(title, name, sequence) values(?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, "test");
				ps.setString(2, "test");
				ps.setLong(3, 11234);
				rs = ps.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
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
			
			return todo;
			
		}
}

	


>>>>>>> upstream/master
