package dbConnect;

import dao.TodoDao;
import dto.TodoDto;
import dbConnect.DBConn;

public class JDBCConnectionTest {
	
	public static void main(String[] args) {
		int TEST;
		String title = "TEST";
		String name = "Choidoa";
		int sequence = 1234;
		
		TodoDao db = new TodoDao();
		TEST = db.getTodoDto();
		System.out.println(TEST);
	}

}
