package com.lec.ex03;

public abstract class ChildClass extends SuperClass {

	// SuperClass로부터 받은 추상 메소드 method1()
	
	@Override
	public void method2() {
		System.out.println("ChildClass의 method2()");
		
	}
	public void method3() {
		System.out.println("ChildClass의 method3()");
	}
	

	
	
}
