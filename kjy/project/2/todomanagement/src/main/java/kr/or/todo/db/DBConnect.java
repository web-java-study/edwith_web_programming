package kr.or.todo.db;

import java.sql.*;

public class DBConnect {
	
	//url user pass 입력하기
	private static String url = "";
	private static String user = "";
	private static String pass ="";
	
	public Connection connect() {
		Connection conn=null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,user,pass);
		}catch(SQLException e) {
			System.out.println("SQL 문 오류 ");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public void db_close(ResultSet rs, PreparedStatement ps, Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(ps!=null) {
			try {
				ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void db_close(ResultSet rs, Statement st, Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(st!=null) {
			try {
				st.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void db_close(PreparedStatement ps, Connection conn) {
		db_close(null, ps, conn);
	}
}
