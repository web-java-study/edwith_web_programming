package dbConnect;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	/* [JDBC Java Database Connectivity] */
	// DB Account, Time zone error → UTF-8, Timezone=UTC 
	static String url = "jdbc:mysql://localhost:3306/todolist?characterEncoding=UTF-8&serverTimezone=UTC";
	static String user = "connect";
	static String passwd = "1234";
	public String DBConnection() {
		
		Connection conn = null;	//	DB Connection Object
		String driver = "com.mysql.jdbc.Driver";	// JDBC Driver
		
		try {
			Class.forName(driver);
			
			// DB Connection 
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("[Connection]");
		} catch (SQLException ex) {
			System.out.println("[Fail] "+ex.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("[JDBC Error] "+ e.getMessage());
		} finally {
			// Connection 사용 후  Close
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
					
				}
			}
		}
		return driver;
		
=======
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConn {
	static String url = "jdbc:mysql://localhost:3306/todolist?characterEncoding=UTF-8&serverTimezone=UTC";
	static String user = "connect";
	static String passwd = "1234";
	static String driver = "com.mysql.cj.jdbc.Driver";
	public Connection DBConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, passwd);
		} catch(SQLException e) {
			System.out.println("SQL Error");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
>>>>>>> upstream/master
	}
}