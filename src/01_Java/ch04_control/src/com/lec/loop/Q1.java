package com.lec.loop;

// 1~10의 곱 출력하기
public class Q1 {
	
	public static void main(String[] args) {
		
		int result = 1;
		
		for(int i=1 ; i<=10
				; i++) {
			result *= i; // result = result * 1
		}
		System.out.println("1~10까지의 곱은 "+result);
	}

}
