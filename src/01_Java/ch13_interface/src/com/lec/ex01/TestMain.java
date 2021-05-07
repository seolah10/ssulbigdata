package com.lec.ex01;

public class TestMain {

	public static void main(String[] args) {
		
		//InterfaceEx1 ex1 = new InterfaceEx1();
		//InterfaceEx2 ex1 = new InterfaceEx2(); 인터페이스는 이렇게 새 객체를 만들 수 없다. (추상 메소드만 가능하니까)
	
		InterfaceClass obj1 = new InterfaceClass();
		
		obj1.method1();
		obj1.method2();
		
		
		InterfaceEx1 obj2 = new InterfaceClass(); // 인터페이스로부터 구현받은 클래스에서 새 객체를 가져오는 것은 가능하다.
		
		obj2.method1();
//		obj2.method2(); InterfaceEx1엔 method2가 없으므로 불가능
		
		
		InterfaceEx2 obj3 = new InterfaceClass(); 
		
		if(obj3 instanceof InterfaceClass) {
			((InterfaceClass)obj3).method1(); // 형변환 : 다음 시간에 자세히 다루도록 한다.
		}
		// obj3.method1(); InterfaceEx2엔 mothod1이 없으므로 불가능
		 obj3.method2();
	}
}
