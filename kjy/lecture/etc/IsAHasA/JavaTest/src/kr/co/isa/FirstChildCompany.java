package kr.co.isa;

public class FirstChildCompany extends ParentCompany{
	
//	private String strawberry;
//	private String milk;
//	
//	
//	public FirstChildCompany() {
//		this.strawberry = super.getStrawberry();
//		this.milk = super.getStrawberry();
//	}
//	
//	public String getStrawberry() {
//		return strawberry;
//	}
//	
//	public String getMilk() {
//		return milk;
//	}
	
	@Override
	public String sellStrawberry() {
		return getStrawberry()+"\"-->첫째 자식이 판매\" "; 
	}
	
	@Override
	public String sellMilk() {
		return getMilk() +"\"-->첫째 자식이 판매\" "; 
	}
	
}
