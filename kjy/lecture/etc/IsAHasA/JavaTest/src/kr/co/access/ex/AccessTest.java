package kr.co.access.ex;

public class AccessTest {
	public static void main(String[] args) {
		AccessRestrictor ac = new AccessRestrictor();
		
		ac.defaultAccess();
		ac.protectedAccess();
		ac.publicAccess();
//		ac.privateAccess();
	}
}
