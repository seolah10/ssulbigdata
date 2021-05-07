package com.lec.man;

public class ManMain {
	public static void main(String[] args) { // (private은 new를 생성할 수 없다.)
		
		Man kim = new Man(20,170,60,"010-999-9999");
		Man yi = new Man(20,180,65);
		Man park = new Man(20,"010-9999-9999");
		
		Man[] student = {kim, park};
		
		yi.setTel("010-8888-8888");
		park.setHeight(177);
		park.setHeight(63);
		
		double biman = kim.calculationBMI();
			if(biman>24) {
				System.out.println("kim은 비만이니 건강 조심!");
			}else {
				System.out.println("kim은 다이어트 금지");
			}
		
		biman = yi.calculationBMI();
				System.out.println(biman>24 ? "건강 조심!" : "다이어트 금지");
				
		biman = park.calculationBMI();
				System.out.println(biman>24 ? "건강 조심!" : "다이어트 금지");
		
	}	
}
