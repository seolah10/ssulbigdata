package com.lec.ex04shape_void;

public abstract class Shape {

	public void draw() {
		System.out.println("도형을 그려요");
	}
	
	public abstract void computeArea(); // 추상 메소드 (선언만)
}
