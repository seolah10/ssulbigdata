package com.lec.man;

public class ManMain {
	public static void main(String[] args) { // (private�� new�� ������ �� ����.)
		
		Man kim = new Man(20,170,60,"010-999-9999");
		Man yi = new Man(20,180,65);
		Man park = new Man(20,"010-9999-9999");
		
		Man[] student = {kim, park};
		
		yi.setTel("010-8888-8888");
		park.setHeight(177);
		park.setHeight(63);
		
		double biman = kim.calculationBMI();
			if(biman>24) {
				System.out.println("kim�� ���̴� �ǰ� ����!");
			}else {
				System.out.println("kim�� ���̾�Ʈ ����");
			}
		
		biman = yi.calculationBMI();
				System.out.println(biman>24 ? "�ǰ� ����!" : "���̾�Ʈ ����");
				
		biman = park.calculationBMI();
				System.out.println(biman>24 ? "�ǰ� ����!" : "���̾�Ʈ ����");
		
	}	
}
