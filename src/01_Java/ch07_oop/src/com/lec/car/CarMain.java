package com.lec.car;

import java.util.Scanner;

public class CarMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Car myPorsche = new Car();
		Car yourPorshe = new Car(); // (�Ʒ� �Ҵ�� ���� ���� ���, new���� ���� 0�̳� null�� û�����ش�.)
		
		myPorsche.drive();
		yourPorshe.drive(); 
		myPorsche.park();
		myPorsche.race();
		myPorsche.setColor("red"); //myPorsche.color = "red"; 
		
		System.out.println("�� ������ ���� : "+myPorsche.getColor());
		System.out.println("�� ������ ���� : "+yourPorshe.getColor());
		System.out.println("�� ������ ��ⷮ: "+myPorsche.getCc());	
	}

}
