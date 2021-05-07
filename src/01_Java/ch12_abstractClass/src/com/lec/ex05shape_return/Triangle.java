package com.lec.ex05shape_return;

public class Triangle extends Shape {

	private int w; // ¹Øº¯
	private int h; // ³ôÀÌ
	
	public Triangle() {}
		// TODO Auto-generated constructor stub
	public Triangle(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}
	
	@Override
	public double computeArea() {
		System.out.println("»ï°¢ÇüÀÇ ³ĞÀÌ´Â"+(w * h * 0.5));
		return w * h * 0.5;
	}
	@Override
	public void draw() {
		System.out.println("»ï°¢Çü ");
		super.draw();
	}
}
	

