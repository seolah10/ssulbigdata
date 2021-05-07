package com.lec.ex05shape_return;

// ex04 패키지와 리턴 타입을 다르게 해 본다.

public abstract class Shape {

	public void draw() {
		System.out.println("도형을 그려요");
	}
	
	public abstract double computeArea(); // 넓이를 return하는 추상 메소드 선언
}
