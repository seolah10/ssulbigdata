package com.lec.ex05shape_return;

public class Triangle extends Shape {

	private int w; // �غ�
	private int h; // ����
	
	public Triangle() {}
		// TODO Auto-generated constructor stub
	public Triangle(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}
	
	@Override
	public double computeArea() {
		System.out.println("�ﰢ���� ���̴�"+(w * h * 0.5));
		return w * h * 0.5;
	}
	@Override
	public void draw() {
		System.out.println("�ﰢ�� ");
		super.draw();
	}
}
	

