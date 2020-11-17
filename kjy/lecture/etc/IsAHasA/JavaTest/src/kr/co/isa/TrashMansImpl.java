package kr.co.isa;

public class TrashMansImpl implements TrashMans {
	
	@Override
	public void lowLevelStraberryMilk(SecondChildCompany ch, WasteMakeStrawberryCompany ch2) {
		String st = "";
		String mi ="";
		
		if(ch==null && ch2==null) {
			System.out.println("벌레 껍질로 만든 " + "로 만든 딸기우유");
			return;
		}
		
		if(ch==null) {
			st = ch2.getStrawberryPowder();
			mi = ch2.getMilkPowder();
		}else {
			st = ch.getStrawberry() + " + "+ ch2.getStrawberryPowder();
			mi = ch.getMilkPowder() + " + "+ ch2.getMilkPowder();
		}
	
		System.out.println(st + " 과 " + mi +" 로 만든 딸기우유"); 
	}

	@Override
	public void writeFakeDocu() {
		// TODO Auto-generated method stub
		
	}
}
