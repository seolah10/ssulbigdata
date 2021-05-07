package com.lec.ex3_math;

import java.util.Random;

public class Ex03_Random {
	
	public static void main(String[] args) {
		
		System.out.println((int)(Math.random()*45)+1);
		
		Random random = new Random();
		
		System.out.println("int난수: "+random.nextInt()); // 정수
		System.out.println("0~100의 int난수: "+random.nextInt(101)); 
		System.out.println("0~44의 int난수:"+random.nextInt(45));
		System.out.println("1~45의 int난수: "+random.nextInt(45)+1);
		System.out.println("double난수: "+random.nextDouble());
		System.out.println("T/F 중에 하나 선택: "+random.nextBoolean());
	}

}
