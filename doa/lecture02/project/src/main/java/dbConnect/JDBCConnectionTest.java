package dbConnect;

import dao.TodoDao;
import dto.TodoDto;

public class JDBCConnectionTest {
	
	public static void main(String[] args) {
		TodoDao dao = new TodoDao();
		dao.getTodoDto();
		System.out.println(dao);
	}

}
