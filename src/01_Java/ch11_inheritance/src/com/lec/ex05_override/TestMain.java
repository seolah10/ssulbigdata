package com.lec.ex05_override;

public class TestMain {
	public static void main(String[] args) {
		
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass(2);

		
		pObj1.method1();
		pObj2.method2();
		System.out.println("=============");
		
		
		ChildClass cObj1 = new ChildClass();
		ChildClass cObj2 = new ChildClass(3); // �θ�Ŭ������ �Բ� �ߺ����� ��µȴ�.
		
		cObj1.method1();
		cObj1.method2(); // childclass�� �θ� Ŭ������ parentclass�� �ִ� method2�� ����� �ȴ�.
		cObj1.method3(); 
	}
}
