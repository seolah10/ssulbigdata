package com.lec.ex02;

public class Child extends Super {

	@Override
	public void method1() {
		System.out.println("Child의 method1() - 추상 메소드");
		
	}
	public void method3() {
		System.out.println("Child의 method3()"); // 현 클래스에서 새로 만든 일반 메소드
 	}

}
