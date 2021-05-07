package com.lec.ex02;

public class TestMain {

	public static void main(String[] args) {
		
		// Super s = new Super(); 추상 클래스는 객체를 생성할 수 없다.
		Child c1 = new Child();
		
		c1.method1();
		c1.method2(); 
		c1.method3();
		
		
		Super c2 = new Child();
		
		c2.method1();
		c2.method2();
//		c2.method3(); 불가 (because c2 변수가 Super타입이므로 Child타입에 있는 method3은 불가능)
	}
}
