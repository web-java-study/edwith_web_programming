package kr.co.isa;

public abstract class ParentCompany {

	private String strawberry;
	private String milk; 
	
	public ParentCompany() {
		this.strawberry = "부모님의 비법 딸기";
		this.milk = "부모님의 비법 우유";
	}
	
	public String getStrawberry() {
		return strawberry;
	}
	
	public String getMilk() {
		return milk;
	}
	
	public String sellStrawberry() {
		return strawberry +" ---> 부모님 판매";
	}
	
	public String sellMilk() {
		return milk + " ---> 부모님 판매";
	}
	
	
}
