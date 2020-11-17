package kr.or.connect.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.todo.dto.TodoDto;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "test01";
	private static String dbpassword="Test01123!@#";
	
	// update
	public int updateTodo(TodoDto todo) {
		int updateCount = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "update todo set type=? where title=?";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
				PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, todo.getType());
				ps.setString(2, todo.getTitle());
				ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return updateCount;
	}
	
	// 전체 목록 조회
	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM todo";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				
				while (rs.next()) {
					String title = rs.getString("title");
					String name = rs.getString("name");
					int sequence = rs.getInt("sequence");
					String type = rs.getString("type");
					String regdate = rs.getString("regdate");
					
					TodoDto todos = new TodoDto(title, name, sequence, type, regdate);
					list.add(todos);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	// 할일 목록 추가 
	public int addTodo(TodoDto todo) {
		int insertCount = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO todo (title, name, sequence) VALUES (?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
				PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, todo.getTitle());
				ps.setString(2, todo.getName());
				ps.setInt(3, todo.getSequence());
			
			insertCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return insertCount;
	}
}
