package kr.co.isa;

public class FriendCompany {
	
	String gasiOgaPhy;
	String hutGei;
	SecondChildCompany child;
	
	//생성자 주입, DI/cosructor injection
	
	public FriendCompany() {
		this.gasiOgaPhy = "가시오가피";
		this.hutGei = "헛개";
		
		
		this.child = new SecondChildCompany();
	}
	
	public void makeDrink(String food) {
		System.out.println(food+"음료");
	}
	
	public void makeStrawberryMilk() {
		if(!child.getStrawberryPowder().equals("자식딸기분말")) {
			System.out.println("만들지 않음");
			return;
		}
		
		if(!child.getMilkPowder().equals("자식우유분말")) {
			System.out.println("만들지 않음");
			return;
		}
		
		System.out.println("리얼 딸기우유");
	}
	
	
}
