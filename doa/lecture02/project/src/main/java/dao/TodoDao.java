package dao;

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

	


