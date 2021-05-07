package com.lec.ex04shape_void;

public class Circle extends Shape {

	private int r; // ������ 
	
	
	public Circle() {}
	
	public Circle(int r) {
		this.r = r;
	}
	
	@Override // �߻� �޼ҵ�� �� �������̵� �ؾ� ��
	public void computeArea() {
		System.out.println("���� ���̴� " + (3.14 * r * r));
	}
	@Override // �Ϲ� �޼ҵ�� �������̵� ���� ����
	public void draw() {
		System.out.println("�� ");
		super.draw();
	}
	
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
}
