package com.lex.ex13_final;

// final 클래스: 상속 불가

public class Dog extends Animal {
	
	@Override
	public void running() {
		
		speed += 10;
		System.out.println("강아지가 뛰면서 꼬리를 흔들어요!");
	
	}
	public void method() {
		System.out.println("method()");
	}
	
}
