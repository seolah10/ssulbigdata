package com.lec.ex01;

public class TestMain {

	public static void main(String[] args) {
		
		//InterfaceEx1 ex1 = new InterfaceEx1();
		//InterfaceEx2 ex1 = new InterfaceEx2(); �������̽��� �̷��� �� ��ü�� ���� �� ����. (�߻� �޼ҵ常 �����ϴϱ�)
	
		InterfaceClass obj1 = new InterfaceClass();
		
		obj1.method1();
		obj1.method2();
		
		
		InterfaceEx1 obj2 = new InterfaceClass(); // �������̽��κ��� �������� Ŭ�������� �� ��ü�� �������� ���� �����ϴ�.
		
		obj2.method1();
//		obj2.method2(); InterfaceEx1�� method2�� �����Ƿ� �Ұ���
		
		
		InterfaceEx2 obj3 = new InterfaceClass(); 
		
		if(obj3 instanceof InterfaceClass) {
			((InterfaceClass)obj3).method1(); // ����ȯ : ���� �ð��� �ڼ��� �ٷ絵�� �Ѵ�.
		}
		// obj3.method1(); InterfaceEx2�� mothod1�� �����Ƿ� �Ұ���
		 obj3.method2();
	}
}
