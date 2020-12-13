package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

import java.sql.PreparedStatement;

import dto.TodoDto;
import dbConnect.DBConn;
import controller.TodoFormServlet;

public class TodoDao {
		/* [JDBC Java Database Connectivity] */
		// DB Account, Time zone error → UTF-8, Timezone=UTC 
		@SuppressWarnings("finally")
		public int getTodoDto(TodoDto dto) {
			int insertCount = 0;	// Result
			PreparedStatement pstmt = null;
			Connection conn = null;
			String sql = "insert into todo(title, name, sequence) values(?,?,?)";
			
			// closes
			try {
				DBConn db = new DBConn();
				conn = db.DBConnection();
				System.out.println(conn);
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getName());
				pstmt.setLong(3, dto.getSequence());
				
				
				// select excuteQuery() Method
				insertCount = pstmt.executeUpdate();
				System.out.println();
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
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
		
		public List<TodoDto> getSelect() {
			String sql = "select id, title, name, sequence, type, regdate from todo order by regdate desc";
			@SuppressWarnings("rawtypes")
			List<TodoDto> dtos = new ArrayList();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				DBConn db = new DBConn();
				conn = db.DBConnection();
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery(sql);
				
				while (rs.next()) {
					TodoDto dto = new TodoDto();
					dto.setId(rs.getLong("id"));
					dto.setName(rs.getString("name"));
					dto.setTitle(rs.getString("title"));
					dto.setSequence(rs.getInt("sequence"));
					dto.setType(rs.getString("type"));
					dto.setRegdate(rs.getDate("regdate"));
					
					dtos.add(dto);
					System.out.println(dto.toString());
				}
				return dtos;
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
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return dtos;
		
		}

		
}


	


