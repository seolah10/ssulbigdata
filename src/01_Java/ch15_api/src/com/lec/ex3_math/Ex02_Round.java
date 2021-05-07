package com.lec.ex3_math;

public class Ex02_Round {
	
	public static void main(String[] args) {
		
		System.out.println("소수점에서 반올림, 올림, 버림");
		System.out.println("9.12를 올림: "+(int)Math.ceil(9.12)); //int처리를 안하면 10.0으로 출력됨 
		System.out.println("9.12를 반올림:"+Math.round(9.12));
		System.out.println("9.12를 버림: "+(int)Math.floor(9.12)); ////int처리를 안하면 10.0으로 출력됨
		
		System.out.println("소수점 한자리에서 반올림, 올림, 버림");
		System.out.println("9.15를 올림: "+Math.ceil(9.15*10)/10);
		System.out.println("9.15를 반올림: "+Math.round(9.15*10)/10.0);
		System.out.println("9.15를 버림: "+Math.floor(9.15*10)/10);
		
		System.out.println("일의 자리에서 반올림, 올림, 버림");
		System.out.println("85를 올림(90): "+Math.ceil(85/10.0)*10);
		System.out.println("85를 반올림(90): "+Math.round(85/10.0)*10);
		System.out.println("85를 버림(80): "+Math.floor(85/10.0)*10);
	}

}
