package com.lec.square;

public class SquareMain {
	public static void main(String[] args) {
		Square s1 = new Square();
		Square s2 = new Square(10);
		
			System.out.println("s1�� �� ���� ���̴� "+s1.getSide());
			System.out.println("s1�� ���̴� "+s1.area());
			
			System.out.println("s2�� �� ���� ���̴� "+s1.getSide());
			System.out.println("s2�� ���̴� "+s1.area());
			
			s2.setSide(5);
			System.out.println("s2�� ���̴� "+s2.area());
	}
}
