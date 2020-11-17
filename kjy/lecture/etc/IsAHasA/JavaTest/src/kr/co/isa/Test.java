package kr.co.isa;

public class Test {
	
	public static void main(String[] args) {
		ParentCompany parent = new ParentCompany();
		
		ParentCompany firstChild = new FirstChildCompany();
//		
//		ParentCompany secondChild = new SecondChildCompany();
		
		SecondChildCompany secondChild = new SecondChildCompany();
		secondChild.getStrawberryPowder();
		
		
		
		System.out.println("\n\n=====부모의 것=====");
		System.out.println(parent.getStrawberry());
		System.out.println(parent.getMilk());
		System.out.println(parent.sellStrawberry());
		System.out.println(parent.sellMilk());
		
		System.out.println("\n\n=====첫째자식이 물려받은 것들 IS A=====");
		System.out.println(firstChild.getStrawberry());
		System.out.println(firstChild.getMilk());
		System.out.println(firstChild.sellStrawberry());
		System.out.println(firstChild.sellMilk());


		
		
		
//
//		System.out.println("\n\n=====둘째자식이 물려받은 것들 IS A=====");
//		System.out.println(secondChild.getStrawberry());
//		System.out.println(secondChild.getMilk());
//		System.out.println(secondChild.getStrawberryPowder());
//		System.out.println(secondChild.getMilkPowder());
//		
////		System.out.println(((SecondChildCompany)secondChild).getStrawberryPowder());
////		System.out.println(((SecondChildCompany)secondChild).getMilkPowder());
//		
//		System.out.println("\n\n=====친구와의 관계 Has A -- Compositon / Aggregation)");
//		System.out.println("Composition Has a -- constructor Injection ");
//		System.out.println("Aggregation Has a ---  field Injection / Setter Injection");
//		
//		System.out.println("\n\n=====친구와의 관계 Has A");
//		FriendCompany fr = new FriendCompany();
//		fr.makeStrawberryMilk();
//		
		System.out.println("\n\n====쓰레기 업체와의 관계 Has A" );
		TrashCompany tc = new TrashCompany();
		
		tc.copyStrawberry();
		tc.getStrawberry();
		tc.setSecondChildCompany(secondChild);

		tc.makeTrashStrawberryMilk();
		
		
	}
	
	
}
