package com.lec.ex3_math;

import java.util.Random;

public class Ex03_Random {
	
	public static void main(String[] args) {
		
		System.out.println((int)(Math.random()*45)+1);
		
		Random random = new Random();
		
		System.out.println("int����: "+random.nextInt()); // ����
		System.out.println("0~100�� int����: "+random.nextInt(101)); 
		System.out.println("0~44�� int����:"+random.nextInt(45));
		System.out.println("1~45�� int����: "+random.nextInt(45)+1);
		System.out.println("double����: "+random.nextDouble());
		System.out.println("T/F �߿� �ϳ� ����: "+random.nextBoolean());
	}

}
