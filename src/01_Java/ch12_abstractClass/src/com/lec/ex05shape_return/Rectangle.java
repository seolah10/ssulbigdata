package com.lec.ex05shape_return;

public class Rectangle extends Shape {

	private int w; // ����
	private int h; // ����
	
	
	public Rectangle() {}
	
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	@Override
	public double computeArea() {
		System.out.println("�簢���� ���̴� "+(w * h));
		return w * h;
	}
	@Override
	public void draw() {
		System.out.println("�簢�� ");
		super.draw();
	}
}

	
