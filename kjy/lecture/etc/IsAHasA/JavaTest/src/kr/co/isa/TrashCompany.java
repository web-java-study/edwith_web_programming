package kr.co.isa;

public class TrashCompany{
	
	private SecondChildCompany ch;
	private WasteMakeStrawberryCompany ch2;
	private TrashMans trashMan;
	
	
	//field injection
	public void getStrawberry() {
		this.ch = new SecondChildCompany();
	}
	
	
	public void copyStrawberry() {
		this.ch2 = new WasteMakeStrawberryCompany();
	}
	
	//setter injection
	public void setSecondChildCompany(SecondChildCompany ch) {
		this.ch=ch;
	}
	
	
	//constructor injection
	public TrashCompany() {
		this.trashMan = new TrashMansImpl();
	}
	
	
	public void makeTrashStrawberryMilk() {
		trashMan.lowLevelStraberryMilk(ch, ch2);
	}
	
	
}
