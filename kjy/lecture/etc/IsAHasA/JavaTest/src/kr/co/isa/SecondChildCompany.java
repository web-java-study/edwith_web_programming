package kr.co.isa;

public class SecondChildCompany extends ParentCompany{
	
//	String strawberry;
//	String milk;
	String strawberryPowder;
	String milkPowder;
	
	public SecondChildCompany() {
//		this.strawberry = super.getStrawberry();
//		this.milk = super.getStrawberry();
		this.strawberryPowder = "자식딸기분말";
		this.milkPowder = "자식우유분말";
	}
	
	
	public String getStrawberryPowder() {
		return strawberryPowder;
	}
	
	public String getMilkPowder() {
		return milkPowder;
	}
	

}
