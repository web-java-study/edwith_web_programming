package kr.co.access.ex;

public class AccessRestrictor {
	public void publicAccess() {
		System.out.println("public");
	}
	
	protected void protectedAccess() {
		System.out.println("protected");
	}
	
	void defaultAccess() {
		System.out.println("default");
	}
	
	private void privateAccess() {
		System.out.println("privateAccess");
	}
}
