package com.lec.ex05_override;

public class TestMain {
	public static void main(String[] args) {
		
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass(2);

		
		pObj1.method1();
		pObj2.method2();
		System.out.println("=============");
		
		
		ChildClass cObj1 = new ChildClass();
		ChildClass cObj2 = new ChildClass(3); // 부모클래스도 함께 중복으로 출력된다.
		
		cObj1.method1();
		cObj1.method2(); // childclass의 부모 클래스인 parentclass에 있는 method2도 출력이 된다.
		cObj1.method3(); 
	}
}
