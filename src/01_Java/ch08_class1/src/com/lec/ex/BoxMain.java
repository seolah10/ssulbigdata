package com.lec.ex;

public class BoxMain {
	public static void main(String[] args) {
		
		Box box = new Box(5,6,10);
		Box rect = new Box(10,5);

		box.calNsetVolume();
		rect.calNsetVolume();
		
		System.out.println("�ڽ� ���� : "+box.getVolume());
		System.out.println("rect ���� : "+rect.getVolume());
	}
}

