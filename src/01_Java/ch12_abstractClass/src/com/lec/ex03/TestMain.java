package com.lec.ex03;

public class TestMain {
	
	public static void main(String[] args) {
		//SuperClass sp = new SuperClass();
		//ChildClass c = new ChildClass(); �߻� Ŭ������ �Ұ���
		
		SuperClass sp = new GrandChildClass();
		
		sp.method1();
		sp.method2();
//		sp.method3(); �Ұ��� (ChildClass�� �޼ҵ��)
		
		
		ChildClass child = new GrandChildClass();
		
		child.method1();
		child.method2();
		child.method3();
		
		
		GrandChildClass grand = new GrandChildClass();
		
		grand.method1();
		grand.method2();
		grand.method3();
	}

}
