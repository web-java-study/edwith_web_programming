package kr.or.todo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import kr.or.todo.db.DBConnect;
import kr.or.todo.dto.TodoDto;

public class TodoDao {
	
	
	public ArrayList<TodoDto> getTodos(){
		
		Connection conn =null;
		Statement st = null;
		ResultSet rs = null;
		
		String sql = "select id, title, name, sequence, type, regdate from todo order by regdate desc; ";
		ArrayList<TodoDto> list = new ArrayList<>();
		TodoDto dto=null;
		
		try{
			DBConnect db = new DBConnect();
			conn=db.connect();
			st= conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				dto=new TodoDto(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("name"),
						rs.getInt("sequence"),
						rs.getString("type"),
						rs.getDate("regdate")
						);
				list.add(dto);
				System.out.println(dto.toString());
			}
			
			db.db_close(rs, st, conn);
		}catch(SQLException e) {
			System.out.println("SQL문 에러");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int updateTodo(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs=0;
		
		String sql = "update todo.todo " + 
				"set type = " + 
				"case " + 
				"when type = 'TODO' " + 
				"then 'DOING'" + 
				"when type = 'DOING' " + 
				"then 'DONE' " + 
				"else 'DONE' " + 
				"end " + 
				"where id = ?"; 
		
		try {
			DBConnect db = new DBConnect();
			conn=db.connect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeUpdate();
			
			db.db_close(ps, conn);
			
		}catch(SQLException e) {
			System.out.println("SQL문 에러");
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return rs;
	}
	
	public int addTodo(String title, String name, int seq) {
		Connection conn = null;
		PreparedStatement ps = null;
		DBConnect db = new DBConnect();
		
		int rs=0;
		
		String sql = "insert into todo (title, name, sequence) "
				+ "values(?, ?, ?) ";
		
		try {
			conn= db.connect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setInt(3, seq);
			rs = ps.executeUpdate();
			
			System.out.println(rs);
			
			db.db_close(ps, conn);

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rs;

	}

}
