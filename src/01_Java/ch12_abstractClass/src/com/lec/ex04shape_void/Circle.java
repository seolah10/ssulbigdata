package com.lec.ex04shape_void;

public class Circle extends Shape {

	private int r; // 반지름 
	
	
	public Circle() {}
	
	public Circle(int r) {
		this.r = r;
	}
	
	@Override // 추상 메소드라서 꼭 오버라이딩 해야 함
	public void computeArea() {
		System.out.println("원의 넓이는 " + (3.14 * r * r));
	}
	@Override // 일반 메소드라서 오버라이딩 선택 사항
	public void draw() {
		System.out.println("원 ");
		super.draw();
	}
	
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
}
