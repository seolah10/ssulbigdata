package com.lec.ex04shape_void;

public class Rectangle extends Shape {

	private int w; // ����
	private int h; // ����
	
	
	public Rectangle() {}
	
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	@Override
	public void computeArea() {
		System.out.println("�簢���� ���̴� "+(w * h));
	}
	@Override
	public void draw() {
		System.out.println("�簢�� ");
		super.draw();
	}
}

	
