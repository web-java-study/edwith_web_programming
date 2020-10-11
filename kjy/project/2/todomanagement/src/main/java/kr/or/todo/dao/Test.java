package kr.or.todo.dao;

public class Test {
	public static void main(String[] args) {
		TodoDao dao = new TodoDao();
//		dao.getTodo();
//		dao.updateTodo(2, "DONE");
		dao.addTodo("테스트에요", "없어요", 3);
		
		
	}
}
