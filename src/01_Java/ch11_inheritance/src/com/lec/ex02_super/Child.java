package com.lec.ex02_super;

public class Child extends SuperIJ {

	private int total;
	
	public Child(int i, int j) {
		setI(i); // this.i = i;
		setJ(j);
	}
	
	public void sum() {
		// total�� i+j�� �Ҵ�
		total = getI()+getJ();
		
		System.out.println("�� ��ü�� total: "+total);
	}
	
}
