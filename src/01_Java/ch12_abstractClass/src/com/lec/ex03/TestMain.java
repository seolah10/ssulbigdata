package com.lec.ex03;

public class TestMain {
	
	public static void main(String[] args) {
		//SuperClass sp = new SuperClass();
		//ChildClass c = new ChildClass(); 추상 클래스라서 불가능
		
		SuperClass sp = new GrandChildClass();
		
		sp.method1();
		sp.method2();
//		sp.method3(); 불가능 (ChildClass의 메소드라서)
		
		
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
