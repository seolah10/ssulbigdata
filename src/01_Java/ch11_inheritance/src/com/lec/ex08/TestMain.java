package com.lec.ex08;

import java.util.GregorianCalendar;

public class TestMain {

	public static void main(String[] args) {
		
	Parent parent = new Parent();
	Child1 child1 = new Child1();
	Child2 child2 = new Child2();
	GrandChild grandChild = new GrandChild();
	
		System.out.println("parent�� p: "+parent.getP()); 
		System.out.println("child1�� p: "+child1.getP()); 
		
		System.out.println(child1.getC1());
		
		System.out.println(child2.getP());
		System.out.println(child2.getP()); 
//		System.out.println(child2.getC1()); �Ұ���

		System.out.println(grandChild.getP());
		System.out.println(grandChild.getC1());
		System.out.println(grandChild.getGc());
//		System.out.println(grandChild.getC2()); //�Ұ��� (gc�� c2�� �ƴ϶� c1�� �ڼ� Ŭ�����̱� ����)
		
		

	}
	
}