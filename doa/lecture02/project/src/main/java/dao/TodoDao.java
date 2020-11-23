package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.PreparedStatement;

import dto.TodoDto;
import dbConnect.DBConn;

public class TodoDao {
		/* [JDBC Java Database Connectivity] */
		// DB Account, Time zone error → UTF-8, Timezone=UTC 
		@SuppressWarnings("finally")
		public int getTodoDto() {
			@SuppressWarnings("unused")
			int insertCount = 0;	// Result
			
			TodoDto todo = null;
			PreparedStatement ps = null;
			Connection conn = null;
			ResultSet rs = null;
		
			// closes
			try {
				DBConn db = new DBConn();
				conn = db.DBConnection();
				System.out.println(conn);
				String sql = "insert into todo(title, name, sequence) values( ?,?,? )";
				ps = conn.prepareStatement(sql);
				
				// ?에 대한 값을 바인딩
				ps.setString(1, "test");
				ps.setString(2, "test");
				ps.setLong(3, 11234);
				
				
				// select excuteQuery() Method
				insertCount = ps.executeUpdate();
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}
			
			return insertCount;
			
			}
			
			
		}
		
		public int getSelect() {
			int selectCount = 0;
			String sql = "SELECT * FROM todo";
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				DBConn db = new DBConn();
				conn = db.DBConnection();
				System.out.println(conn);
				
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery(sql);
				
				
				while (rs.next()) {
					String id = rs.getString("id");
					String title = rs.getString("title");
					String name = rs.getNString("name");
					
					System.out.println(id + " " + title + " " + name + " ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
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
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		
			return selectCount;
		}
		
}


	


