package dao;

import dto.TodoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.List;

public class TodoDao2 {
    // 추후 DBDriverLoader 로 변경
    private static String url = "jdbc:mysql://localhost:3306/todolist";
    private static String user = "connect";
    private static String passwd = "1234";

    public int TodoAdd(TodoDto todo) throws SQLException {
            Connection conn = null;
            PreparedStatement ps = null;
            int rs = 0;

            // 예외처리
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            String SQLQuery = "insert into todo(title, name, sequence) values(?,?,?)";
            try conn = DriverManager.getConnection(url, user, passwd); {
                ps.setString(1, getTitle());
                ps.setString(2, getName());
                ps.setInt(3, getSequence());

                // int type
                rs = ps.executeUpdate();
            } catch (Exception ex) {
                ex.printStackTrace();
                // 20201109
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
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

            return todo;
        }

    public List<TodoDto> getTodo() {
    }
}
