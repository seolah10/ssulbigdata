package com.lec.ex02;

//추상 클래스는 한 개 이상의 추상 메소드를 가짐
//Super s = new Super(); 불가
//s.method(); 불가

public abstract class Super {

		public Super() {} // 디폴트 생성자
		
		public abstract void method1(); // 추상 메소드 
		
		public void method2() { // 일반 메소드
			System.out.println("Super의 method2()");
		}
}
